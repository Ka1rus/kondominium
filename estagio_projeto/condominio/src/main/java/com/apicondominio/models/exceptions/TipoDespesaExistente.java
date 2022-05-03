package com.apicondominio.models.exceptions;

import java.time.LocalDate;

public class TipoDespesaExistente extends RuntimeException{
    
    private Integer statusCode;
    private String message;
    private String path;
    private LocalDate date;
    private String error;

    public TipoDespesaExistente() {}

    public Integer getStatusCode() {
        return statusCode;
    }
    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public String getError() {
        return error;
    }
    public void setError(String error) {
        this.error = error;
    }

}
