package com.jucya.extention;

import com.fasterxml.jackson.databind.JsonMappingException;
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
    public ErrorDescription handleCompanyDuplicateException(CompanyDuplicateException error) {
        return new ErrorDescription(error.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(JsonMappingException.class)
    public ErrorDescription handleValidationException(JsonMappingException error) {
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
