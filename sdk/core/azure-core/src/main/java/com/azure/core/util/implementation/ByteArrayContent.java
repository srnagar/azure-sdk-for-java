package com.azure.core.util.implementation;

import com.azure.core.util.serializer.ObjectSerializer;
import com.azure.core.util.serializer.TypeReference;
import reactor.core.publisher.Flux;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Objects;

public class ByteArrayContent extends BinaryDataContent {
    private final byte[] content;

    public ByteArrayContent(byte[] content) {
        if (content == null || content.length == 0) {
            this.content = ZERO_BYTE_ARRAY;
            return;
        }
        // change in behavior - not making a copy of the byte array
        this.content = content;
    }

    @Override
    public Long getLength() {
        return (long) this.content.length;
    }

    @Override
    public String toString() {
        return new String(content);
    }

    @Override
    public byte[] toBytes() {
        return content;
    }

    @Override
    public <T> T toObject(TypeReference<T> typeReference, ObjectSerializer serializer) {
        Objects.requireNonNull(typeReference, "'typeReference' cannot be null.");
        Objects.requireNonNull(serializer, "'serializer' cannot be null.");

        return serializer.deserializeFromBytes(this.content, typeReference);
    }

    @Override
    public InputStream toStream() {
        return new ByteArrayInputStream(this.content);
    }

    @Override
    public ByteBuffer toByteBuffer() {
        return ByteBuffer.wrap(this.content).asReadOnlyBuffer();
    }

    @Override
    public Flux<ByteBuffer> toByteBufferFlux() {
        return Flux.defer(() -> Flux.just(ByteBuffer.wrap(toBytes())));
    }
}
