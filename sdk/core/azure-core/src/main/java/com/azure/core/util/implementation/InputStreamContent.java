package com.azure.core.util.implementation;

import com.azure.core.util.logging.ClientLogger;
import com.azure.core.util.serializer.ObjectSerializer;
import com.azure.core.util.serializer.TypeReference;
import reactor.core.publisher.Flux;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.nio.ByteBuffer;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public class InputStreamContent extends BinaryDataContent {
    private final ClientLogger logger = new ClientLogger(InputStreamContent.class);
    private final InputStream content;
    private final AtomicReference<byte[]> bytes = new AtomicReference<>();

    public InputStreamContent(InputStream inputStream) {
        if (Objects.isNull(inputStream)) {
            this.content = new ByteArrayInputStream(ZERO_BYTE_ARRAY);
            return;
        }
        this.content = inputStream;
    }

    @Override
    public Long getLength() {
        return null;
    }

    @Override
    public String toString() {
        return new String(toBytes());
    }

    @Override
    public byte[] toBytes() {
        bytes.compareAndSet(null, getBytes());
        return bytes.get();
    }

    @Override
    public <T> T toObject(TypeReference<T> typeReference, ObjectSerializer serializer) {
        return serializer.deserializeFromBytes(toBytes(), typeReference);
    }

    @Override
    public InputStream toStream() {
        return this.content;
    }

    @Override
    public ByteBuffer toByteBuffer() {
        return ByteBuffer.wrap(toBytes()).asReadOnlyBuffer();
    }

    @Override
    public Flux<ByteBuffer> toByteBufferFlux() {
        return Flux.defer(() -> Flux.just(ByteBuffer.wrap(toBytes())));
    }

    private byte[] getBytes() {
        try {
            ByteArrayOutputStream dataOutputBuffer = new ByteArrayOutputStream();
            int nRead;
            byte[] data = new byte[STREAM_READ_SIZE];
            while ((nRead = this.content.read(data, 0, data.length)) != -1) {
                dataOutputBuffer.write(data, 0, nRead);
            }
            return dataOutputBuffer.toByteArray();
        } catch (IOException ex) {
            throw logger.logExceptionAsError(new UncheckedIOException(ex));
        }
    }
}
