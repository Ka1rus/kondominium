package com.apicondominio.models.exceptions;

import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

public class ApiError{
    
    private int statusCode;
    private String message;
    private LocalDate date;
    private String error;
    private String path;

    public ApiError(){}

    public ApiError(int statusCode, String message, LocalDate date) {
        this.statusCode = statusCode;
        this.message = message;
        this.date = date;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    
    public void setError(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

}
