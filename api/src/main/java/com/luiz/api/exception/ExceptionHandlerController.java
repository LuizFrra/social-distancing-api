package com.luiz.api.exception;

import com.luiz.domain.exceptions.AbstractGeneralException;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@RestControllerAdvice
public class ExceptionHandlerController {

    private final MessageSource messageSource;

    public ExceptionHandlerController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(AbstractGeneralException.class)
    public ResponseEntity<ErrorInfoDTO> catchExceptions(HttpServletRequest req, AbstractGeneralException exception, Locale locale) {
        ErrorInfoDTO errorInfoDTO = ErrorInfoDTO.create(req, exception, messageSource, locale);
        return new ResponseEntity<ErrorInfoDTO>(errorInfoDTO, HttpStatus.valueOf(exception.httpStatus));
    }
}
