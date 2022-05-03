package com.apicondominio.controllers.exceptions;

import java.time.LocalDate;
import java.util.NoSuchElementException;

import javax.servlet.http.HttpServletRequest;

import com.apicondominio.models.exceptions.ApiError;
import com.apicondominio.models.exceptions.TipoDespesaExistente;

import org.hibernate.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
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
}
