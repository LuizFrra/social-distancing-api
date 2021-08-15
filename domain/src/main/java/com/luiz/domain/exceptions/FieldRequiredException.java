package com.luiz.domain.exceptions;

public class FieldRequiredException extends AbstractGeneralException {
    public FieldRequiredException(String message) {
        super(message, 400);
    }
}
