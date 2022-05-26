package com.apicondominio.models.exceptions;

import java.time.LocalDate;
import java.util.List;

public class FieldErrors extends ApiError {

    private String field;
    private String message;

    public FieldErrors() {
    }

    public  FieldErrors(String field, String message) {
        this.field = field;
        this.message = message;
    }

    public FieldErrors(int statusCode, String message, LocalDate date, String field, String messageError) {
        super(statusCode, message, date);
        this.field = field;
        this.message = messageError;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }
}
