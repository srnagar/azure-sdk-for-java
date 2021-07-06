package com.azure.core.util.implementation;

import com.azure.core.util.serializer.JsonSerializer;
import com.azure.core.util.serializer.JsonSerializerProviders;
import com.azure.core.util.serializer.ObjectSerializer;
import com.azure.core.util.serializer.TypeReference;
import reactor.core.publisher.Flux;

import java.io.InputStream;
import java.nio.ByteBuffer;

public abstract class BinaryDataContent {
    static final byte[] ZERO_BYTE_ARRAY = new byte[0];
    static final int STREAM_READ_SIZE = 1024;
    static final JsonSerializer SERIALIZER = JsonSerializerProviders.createInstance(true);

    public abstract Long getLength();

    public abstract String toString();

    public abstract byte[] toBytes();

    public abstract <T> T toObject(TypeReference<T> typeReference, ObjectSerializer serializer);

    public abstract InputStream toStream();

    public abstract ByteBuffer toByteBuffer();

    public abstract Flux<ByteBuffer> toByteBufferFlux();
}
