package com.azure.core.util.implementation;

import com.azure.core.util.serializer.ObjectSerializer;
import com.azure.core.util.serializer.TypeReference;
import reactor.core.publisher.Flux;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public class StringContent extends BinaryDataContent {
    private String stringData;
    private final AtomicReference<byte[]> bytes = new AtomicReference<>();

    public StringContent(String data) {
        if (data == null) {
            // this is to maintain backward compatibility with BinaryData
            bytes.set(ZERO_BYTE_ARRAY);
            this.stringData = "";
            return;
        }
        this.stringData = data;
    }

    @Override
    public Long getLength() {
        return (long) toBytes().length;
    }

    @Override
    public String toString() {
        return this.stringData;
    }

    @Override
    public byte[] toBytes() {
        bytes.compareAndSet(null, getStringDataBytes());
        return this.bytes.get();
    }

    @Override
    public <T> T toObject(TypeReference<T> typeReference, ObjectSerializer serializer) {
        Objects.requireNonNull(typeReference, "'typeReference' cannot be null.");
        Objects.requireNonNull(serializer, "'serializer' cannot be null.");
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
        return Flux.defer(() -> Flux.just(ByteBuffer.wrap(toBytes())));
    }

    private byte[] getStringDataBytes() {
        return this.stringData.getBytes(StandardCharsets.UTF_8);
    }
}
