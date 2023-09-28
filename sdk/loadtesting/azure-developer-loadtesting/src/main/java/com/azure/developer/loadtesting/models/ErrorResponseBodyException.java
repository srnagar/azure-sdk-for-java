package com.azure.developer.loadtesting.models;

import com.azure.core.exception.HttpResponseException;
import com.azure.core.http.HttpResponse;

/** Exception thrown for an invalid response with ErrorResponseBody information. */
public final class ErrorResponseBodyException extends HttpResponseException {
    /**
     * Initializes a new instance of the ErrorResponseBodyException class.
     *
     * @param message the exception message or the response content if a message is not available.
     * @param response the HTTP response.
     */
    public ErrorResponseBodyException(String message, HttpResponse response) {
        super(message, response);
    }

    /**
     * Initializes a new instance of the ErrorResponseBodyException class.
     *
     * @param message the exception message or the response content if a message is not available.
     * @param response the HTTP response.
     * @param value the deserialized response value.
     */
    public ErrorResponseBodyException(String message, HttpResponse response, ErrorResponseBody value) {
        super(message, response, value);
    }

    /** {@inheritDoc} */
    @Override
    public ErrorResponseBody getValue() {
        return (ErrorResponseBody) super.getValue();
    }
}
