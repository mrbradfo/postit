package org.postit.exceptions;

import org.springframework.http.HttpStatus;

public class ApiError {
    HttpStatus statusCode;
    String message;

    public ApiError(HttpStatus statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }
}
