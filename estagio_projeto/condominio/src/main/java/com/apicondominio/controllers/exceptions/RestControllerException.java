package com.apicondominio.controllers.exceptions;

import java.time.LocalDate;
import java.util.NoSuchElementException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.apicondominio.models.exceptions.ApiError;
import com.apicondominio.models.exceptions.FieldErrors;
import com.apicondominio.models.exceptions.TipoDespesaExistente;

import com.apicondominio.models.exceptions.ValidationError;
import org.hibernate.ObjectNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestControllerException{

    //Exceção para recurso/objeto nao encontrado
    @ExceptionHandler(ObjectNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiError handlerObjectNotFoundException(ObjectNotFoundException ex, HttpServletRequest http) {
        ApiError apiError = new ApiError();
        apiError.setMessage("Recurso não encontrado, valor:");
        apiError.setDate(LocalDate.now());
        apiError.setStatusCode(HttpStatus.NOT_FOUND.value());
        apiError.setError(ex.getMessage());
        apiError.setPath(http.getRequestURI());
        return apiError;
    }

    //Exceção para recurso/objeto nao encontrado
    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiError handlerNoSuchElementException(NoSuchElementException ex, HttpServletRequest http) {
        ApiError apiError = new ApiError();
        apiError.setMessage("Recurso não encontrado");
        apiError.setDate(LocalDate.now());
        apiError.setStatusCode(HttpStatus.NOT_FOUND.value());
        apiError.setError(ex.getMessage());
        apiError.setPath(http.getRequestURI());
        return apiError;
    }

    //Exceção para TipoDespesa com nome já existente
    @ExceptionHandler(TipoDespesaExistente.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handlerTipoDespesaExistente(TipoDespesaExistente ex, HttpServletRequest http) {
        ApiError apiError = new ApiError();
        apiError.setMessage("Tipo de despesa já existe");
        apiError.setDate(LocalDate.now());
        apiError.setStatusCode(HttpStatus.NOT_FOUND.value());
        apiError.setError(ex.getMessage());
        apiError.setPath(http.getRequestURI());
        return apiError;
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError dataIntegrityViolationException(DataIntegrityViolationException ex, HttpServletRequest http) {
        ApiError apiError = new ApiError();
        apiError.setMessage("Erro na validação de dados");
        apiError.setDate(LocalDate.now());
        apiError.setStatusCode(HttpStatus.BAD_REQUEST.value());
        apiError.setError(ex.getMessage());
        apiError.setPath(http.getRequestURI());
        return apiError;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidationError validationErrors(MethodArgumentNotValidException ex, HttpServletRequest http) {
        ValidationError apiError = new ValidationError();
        apiError.setMessage("Erro na validação de dados");
        apiError.setDate(LocalDate.now());
        apiError.setStatusCode(HttpStatus.BAD_REQUEST.value());
        apiError.setError(ex.getMessage());
        apiError.setPath(http.getRequestURI());
        for(FieldError x : ex.getBindingResult().getFieldErrors()) {
            apiError.setErrors(x.getField(), x.getDefaultMessage());
        }
        return apiError;
    }

}
