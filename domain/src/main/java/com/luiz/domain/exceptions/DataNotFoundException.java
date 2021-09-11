package com.luiz.domain.exceptions;

public class DataNotFoundException extends AbstractGeneralException {
    public DataNotFoundException(String message) {
        super(message, 404);
    }
}
