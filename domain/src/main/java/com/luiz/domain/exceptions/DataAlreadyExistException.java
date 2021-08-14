package com.luiz.domain.exceptions;

public class DataAlreadyExistException extends AbstractGeneralException {
    public DataAlreadyExistException(String message) {
        super(message, 409);
    }
}
