package com.luiz.api.exception;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.luiz.api.utils.CustomMessageSource;
import com.luiz.domain.exceptions.AbstractGeneralException;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Locale;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorInfoDTO {
    private final String path;

    private final String message;

    private final long timeStamp;

    private final String httpMethod;

    @JsonIgnore
    private int statusCode;

    private Object body;

    private ErrorInfoDTO(HttpServletRequest req, Exception ex, Locale locale) {
        this.path = req.getRequestURI();
        this.httpMethod = req.getMethod();
        this.message = CustomMessageSource.getMessage(ex.getMessage(), locale);
        this.timeStamp = new Date().getTime();
    }

    public static ErrorInfoDTO create(HttpServletRequest req, Exception ex, Locale locale) {
        ErrorInfoDTO errorInfo = new ErrorInfoDTO(req, ex, locale);
        if (ex instanceof AbstractGeneralException) {
            errorInfo.setStatusCode(((AbstractGeneralException) ex).httpStatus);
        }

        return errorInfo;
    }

    public String getPath() {
        return path;
    }

    public String getMessage() {
        return message;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }
}
