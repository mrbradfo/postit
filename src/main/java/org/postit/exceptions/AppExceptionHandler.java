package org.postit.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {AppError.class})
    protected ResponseEntity<ApiError> handleAppException(AppError ex, WebRequest request) {
        ApiError error = new ApiError(ex.getStatusCode(), ex.getMessage());
        return new ResponseEntity<>(error, error.getStatusCode());
    }

    @ExceptionHandler(value = {Exception.class})
    protected ResponseEntity<ApiError> handleAppException(Exception ex, WebRequest request) {
        ApiError error = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");
        return new ResponseEntity<>(error, error.getStatusCode());
    }

}