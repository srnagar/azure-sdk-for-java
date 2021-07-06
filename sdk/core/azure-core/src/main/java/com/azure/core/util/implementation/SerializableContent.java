package com.azure.core.util.implementation;

import com.azure.core.util.serializer.ObjectSerializer;
import com.azure.core.util.serializer.TypeReference;
import reactor.core.publisher.Flux;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public class SerializableContent extends BinaryDataContent {

    private final Object content;
    private final ObjectSerializer serializer;

    private final AtomicReference<byte[]> bytes = new AtomicReference<>();

    public SerializableContent(Object content, ObjectSerializer serializer) {
        this.content = content;
        if (content == null) {
            bytes.set(ZERO_BYTE_ARRAY);
            this.serializer = SERIALIZER;
            return;
        }
        Objects.requireNonNull(serializer, "'serializer' cannot be null.");
        this.serializer = serializer;
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
        bytes.compareAndSet(null, serialize());
        return this.bytes.get();
    }

    @Override
    public <T> T toObject(TypeReference<T> typeReference, ObjectSerializer serializer) {
        if (content == null) {
            return null;
        }
        return serializer.deserializeFromBytes(toBytes(), typeReference);
    }

    @Override
    public InputStream toStream() {
        return null;
    }

    @Override
    public ByteBuffer toByteBuffer() {
        return ByteBuffer.wrap(toBytes()).asReadOnlyBuffer();
    }

    @Override
    public Flux<ByteBuffer> toByteBufferFlux() {
        return Flux.defer(() -> Flux.just(ByteBuffer.wrap(toBytes())));
    }

    private byte[] serialize() {
        return serializer.serializeToBytes(content);
    }


}
