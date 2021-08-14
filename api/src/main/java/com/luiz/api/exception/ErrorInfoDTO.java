package com.luiz.api.exception;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.luiz.domain.exceptions.AbstractGeneralException;
import org.springframework.web.servlet.support.RequestContext;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.stream.Collectors;

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

    private ErrorInfoDTO(HttpServletRequest req, Exception ex) {
        this.path = req.getRequestURI();
        this.httpMethod = req.getMethod();
        this.message = ex.getMessage();
        this.timeStamp = new Date().getTime();
    }
    public void setObject(Object request) {
        this.body = request;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public static ErrorInfoDTO create(HttpServletRequest req, Exception ex) {
        ErrorInfoDTO errorInfo = new ErrorInfoDTO(req, ex);
        if (ex instanceof AbstractGeneralException) {
            errorInfo.setStatusCode(((AbstractGeneralException) ex).httpStatus);
        }

        return errorInfo;
    }
}
