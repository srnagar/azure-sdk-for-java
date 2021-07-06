package com.azure.core.util.implementation;

import com.azure.core.util.FluxUtil;
import com.azure.core.util.serializer.ObjectSerializer;
import com.azure.core.util.serializer.TypeReference;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicReference;

public class FluxByteBufferContent extends BinaryDataContent {

    private final Flux<ByteBuffer> content;
    private final AtomicReference<byte[]> bytes = new AtomicReference<>();
    private final Scheduler scheduler;
    private final Long length;

    public FluxByteBufferContent(Flux<ByteBuffer> content) {
        this(content, null, Schedulers.boundedElastic());
    }

    public FluxByteBufferContent(Flux<ByteBuffer> content, Scheduler scheduler) {
        this(content, null, Schedulers.boundedElastic());
    }

    public FluxByteBufferContent(Flux<ByteBuffer> content, Long length) {
        this(content, length, Schedulers.boundedElastic());
    }

    public FluxByteBufferContent(Flux<ByteBuffer> content, Long length, Scheduler scheduler) {
        if (content == null) {
            content = Flux.just(ByteBuffer.wrap(ZERO_BYTE_ARRAY));
        }
        this.content = content;
        this.scheduler = scheduler;
        this.length = length;
    }

    @Override
    public Long getLength() {
        return length;
    }

    @Override
    public String toString() {
        return new String(toBytes());
    }

    @Override
    public byte[] toBytes() {
        bytes.compareAndSet(null, getBytes());
        return this.bytes.get();
    }

    @Override
    public <T> T toObject(TypeReference<T> typeReference, ObjectSerializer serializer) {
        return serializer.deserializeFromBytes(toBytes(), typeReference);
    }

    @Override
    public InputStream toStream() {
        return new ByteArrayInputStream(toBytes());
    }

    @Override
    public ByteBuffer toByteBuffer() {
        return ByteBuffer.wrap(toBytes()).asReadOnlyBuffer();
    }

    @Override
    public Flux<ByteBuffer> toByteBufferFlux() {
        return content;
    }

    private byte[] getBytes() {
        return FluxUtil.collectBytesInByteBufferStream(content)
                .publishOn(scheduler)
                .block();
    }
}
