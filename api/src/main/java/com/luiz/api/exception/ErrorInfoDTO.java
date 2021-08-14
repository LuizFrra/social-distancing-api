package com.luiz.api.exception;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.luiz.domain.exceptions.AbstractGeneralException;
import org.springframework.context.MessageSource;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Locale;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorInfoDTO {
    public final String path;

    public final String message;

    public final long timeStamp;

    public final String httpMethod;

    @JsonIgnore
    public int statusCode;

    public Object body;

    private ErrorInfoDTO(String path, String message, long timeStamp, String httpMethod, Object request, int statusCode) {
        this.path = path;
        this.message = message;
        this.timeStamp = timeStamp;
        this.httpMethod = httpMethod;
        this.body = request;
        this.statusCode = statusCode;
    }

    private ErrorInfoDTO(HttpServletRequest req, Exception ex, MessageSource messageSource, Locale locale) {
        this.path = req.getRequestURI();
        this.httpMethod = req.getMethod();
        this.message = messageSource.getMessage(ex.getMessage(), null, locale);
        this.timeStamp = new Date().getTime();
    }
    public void setObject(Object request) {
        this.body = request;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public static ErrorInfoDTO create(HttpServletRequest req, Exception ex, MessageSource messageSource, Locale locale) {
        ErrorInfoDTO errorInfo = new ErrorInfoDTO(req, ex, messageSource, locale);
        if (ex instanceof AbstractGeneralException) {
            errorInfo.setStatusCode(((AbstractGeneralException) ex).httpStatus);
        }

        return errorInfo;
    }
}
