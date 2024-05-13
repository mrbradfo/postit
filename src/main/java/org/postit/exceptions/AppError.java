package org.postit.exceptions;

import org.springframework.http.HttpStatus;

public class AppError extends RuntimeException {
    HttpStatus statusCode;
    String message;

    public AppError(HttpStatus statusCode, String message) {
        super(message);
        this.statusCode = statusCode;
        this.message = message;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
