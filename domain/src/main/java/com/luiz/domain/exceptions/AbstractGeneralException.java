package com.luiz.domain.exceptions;

public class AbstractGeneralException extends RuntimeException {

    public final int httpStatus;

    public AbstractGeneralException(String message, int httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
