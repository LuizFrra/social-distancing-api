package com.luiz.api.exception;

import com.luiz.api.utils.CustomMessageSource;
import com.luiz.domain.exceptions.AbstractGeneralException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(AbstractGeneralException.class)
    public ResponseEntity<ErrorInfoDTO> catchExceptions(HttpServletRequest req, AbstractGeneralException exception, Locale locale) {
        ErrorInfoDTO errorInfoDTO = ErrorInfoDTO.create(req, exception, locale);
        return new ResponseEntity<>(errorInfoDTO, HttpStatus.valueOf(exception.httpStatus));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> catchValidationException(HttpServletRequest req, MethodArgumentNotValidException ex, Locale locale) {
        Map<String, String> errors = new TreeMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error -> errors.put(error.getField(), CustomMessageSource.getMessage(error.getDefaultMessage(), locale)));

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
