package com.jucya.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Handles application errors.
 */
@RestControllerAdvice
class EndpointErrorHandler {

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(CompanyDuplicateException.class)
    public ErrorDescription handleLocalLeadFoundException(CompanyDuplicateException error) {
        return new ErrorDescription(error.getMessage());
    }

    static final class ErrorDescription {
        private final String errorMessage;

        ErrorDescription(String errorMessage) {
            this.errorMessage = errorMessage;
        }

        public String getErrorMessage() {
            return errorMessage;
        }
    }

}
