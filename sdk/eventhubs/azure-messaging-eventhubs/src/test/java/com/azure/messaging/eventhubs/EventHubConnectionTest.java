// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.messaging.eventhubs;

import com.azure.core.amqp.ExponentialRetryPolicy;
import com.azure.core.amqp.FixedRetryPolicy;
import com.azure.core.amqp.RetryMode;
import com.azure.core.amqp.RetryOptions;
import com.azure.core.amqp.TransportType;
import com.azure.core.amqp.implementation.AmqpReceiveLink;
import com.azure.core.amqp.implementation.AmqpSendLink;
import com.azure.core.amqp.implementation.CBSAuthorizationType;
import com.azure.core.amqp.implementation.ConnectionOptions;
import com.azure.core.amqp.models.ProxyOptions;
import com.azure.core.credential.TokenCredential;
import com.azure.messaging.eventhubs.implementation.EventHubAmqpConnection;
import com.azure.messaging.eventhubs.implementation.EventHubConsumerOptions;
import com.azure.messaging.eventhubs.implementation.EventHubManagementNode;
import com.azure.messaging.eventhubs.implementation.EventHubSession;
import com.azure.messaging.eventhubs.models.EventPosition;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import reactor.test.StepVerifier;

import java.io.IOException;
import java.time.Duration;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class EventHubConnectionTest {
    private static final Duration TIMEOUT = Duration.ofSeconds(2);
    private static final String HOST_NAME = "Some-host-name";
    private final RetryOptions retryOptions = new RetryOptions()
        .setTryTimeout(Duration.ofSeconds(5))
        .setMaxRetries(0);

    @Mock
    private EventHubAmqpConnection connection;
    @Mock
    private EventHubSession session;
    @Mock
    private TokenCredential tokenCredential;

    private EventHubConnection provider;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        ConnectionOptions connectionOptions = new ConnectionOptions(HOST_NAME, "event-hub-path", tokenCredential,
            CBSAuthorizationType.SHARED_ACCESS_SIGNATURE, TransportType.AMQP_WEB_SOCKETS, retryOptions,
            ProxyOptions.SYSTEM_DEFAULTS, Schedulers.parallel());
        provider = new EventHubConnection(Mono.just(connection), connectionOptions);
    }

    @Test
    public void getManagementNode() {
        // Arrange
        EventHubManagementNode managementNode = mock(EventHubManagementNode.class);
        when(connection.getManagementNode()).thenReturn(Mono.just(managementNode));

        // Act & Assert
        StepVerifier.create(provider.getManagementNode())
            .expectNext(managementNode)
            .expectComplete()
            .verify(TIMEOUT);
    }

    @Test
    public void getSendLink() {
        // Arrange
        final Duration timeout = Duration.ofSeconds(4);
        final AmqpSendLink sendLink = mock(AmqpSendLink.class);
        final RetryOptions options = new RetryOptions()
            .setTryTimeout(timeout)
            .setMaxRetries(2)
            .setRetryMode(RetryMode.FIXED);

        final String linkName = "some-link-name";
        final String entityPath = "some-entity-path";
        when(connection.createSession(entityPath)).thenReturn(Mono.just(session));
        when(session.createProducer(eq(linkName), eq(entityPath), eq(timeout),
            argThat(matcher -> options.getMaxRetries() == matcher.getMaxRetries()
                && matcher instanceof FixedRetryPolicy)))
            .thenReturn(Mono.just(sendLink));

        // Act & Assert
        StepVerifier.create(provider.createSendLink(linkName, entityPath, options))
            .expectNext(sendLink)
            .verifyComplete();
    }

    @Test
    public void getReceiveLink() {
        // Arrange
        final AmqpReceiveLink receiveLink = mock(AmqpReceiveLink.class);
        final EventHubConsumerOptions options = new EventHubConsumerOptions();

        final EventPosition position = EventPosition.fromOffset(10L);
        final String linkName = "some-link-name";
        final String entityPath = "some-entity-path";

        when(connection.createSession(entityPath)).thenReturn(Mono.just(session));
        when(session.createConsumer(
            eq(linkName), eq(entityPath), eq(retryOptions.getTryTimeout()),
            argThat(matcher -> retryOptions.getMaxRetries() == matcher.getMaxRetries()
                && matcher instanceof ExponentialRetryPolicy),
            eq(position), eq(options)))
            .thenReturn(Mono.just(receiveLink));

        // Act & Assert
        StepVerifier.create(provider.createReceiveLink(linkName, entityPath, position, options))
            .expectNext(receiveLink)
            .verifyComplete();
    }

    @Test
    public void disposesOnce() throws IOException {
        // Arrange
        final EventHubManagementNode node = mock(EventHubManagementNode.class);
        when(connection.getManagementNode()).thenReturn(Mono.just(node));

        // Force us to evaluate the connection Mono
        provider.getManagementNode().block();

        // Act
        provider.close();

        // This should not call connection.close() a second time. The connection has already been disposed.
        provider.close();

        // Assert
        verify(connection, times(1)).close();
    }

    @AfterEach
    public void teardown() {
        Mockito.framework().clearInlineMocks();
    }
}
