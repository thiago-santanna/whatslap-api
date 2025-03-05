package com.tsswebapps.lapinformatica.whatslap.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Tratando exceção específica
    @ExceptionHandler(NotFoundResourceException.class)
    public ResponseEntity<ResponseExceptionHandler> handleCustomException(NotFoundResourceException ex, HttpServletRequest request) {
        String path = request.getRequestURI();
        var response = new ResponseExceptionHandler(ex.getMessage(), LocalDateTime.now(), path);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    // Tratando exceção específica
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ResponseExceptionHandler> handleBadRequestException(BadRequestException ex, HttpServletRequest request) {
        String path = request.getRequestURI();
        var response = new ResponseExceptionHandler(ex.getMessage(), LocalDateTime.now(), path);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    // Tratando exceções genéricas
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseExceptionHandler> handleGlobalException(Exception ex, HttpServletRequest request) {
        String path = request.getRequestURI();
        var response = new ResponseExceptionHandler(ex.getMessage(), LocalDateTime.now(), path);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
