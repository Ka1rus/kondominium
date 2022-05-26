package com.apicondominio.models.exceptions;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends ApiError{

    private List<FieldErrors> errors;

    public ValidationError() {}

    public ValidationError(List<FieldErrors> errors) {
        this.errors = errors;
    }

    public ValidationError(int statusCode, String message, LocalDate date) {
        super(statusCode, message, date);
        this.errors = errors;
    }

    public List<FieldErrors> getErrors() {
        return errors;
    }

    public void setErrors(String fieldName, String message) {
        this.errors.add(new FieldErrors(fieldName, message));
    }
}

