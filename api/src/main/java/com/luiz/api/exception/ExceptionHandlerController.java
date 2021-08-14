package com.luiz.api.exception;

import com.luiz.domain.exceptions.AbstractGeneralException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(AbstractGeneralException.class)
    public ResponseEntity<ErrorInfoDTO> catchExceptions(HttpServletRequest req, AbstractGeneralException exception) {
        ErrorInfoDTO errorInfoDTO = ErrorInfoDTO.create(req, exception);
        return new ResponseEntity<ErrorInfoDTO>(errorInfoDTO, HttpStatus.valueOf(exception.httpStatus));
    }
}
