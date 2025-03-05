package com.azure.v2.storage.stress;

public class ContentMismatchException extends RuntimeException {
    public ContentMismatchException() {
        super("crc mismatch");
    }
}
