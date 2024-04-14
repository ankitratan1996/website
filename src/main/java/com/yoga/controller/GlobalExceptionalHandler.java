package com.yoga.controller;

import com.yoga.exception.InvalidInputException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionalHandler {

    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity<String> HandlerInvalidInputExceptionResponse(InvalidInputException invalidInputException)
    {
        log.info("exception received {} ",invalidInputException.getExceptionStatusCode());
        return new ResponseEntity<>(invalidInputException.getExceptionStatusCode().getStatusMessage(),
                invalidInputException.getExceptionStatusCode().getHttpStatus());
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<String> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex) {
        String paramName = ex.getName();
        String errorMessage = "Invalid value for parameter '" + paramName + "'. Please provide a valid UUID.";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }

    @ExceptionHandler(IncorrectResultSizeDataAccessException.class)
    public ResponseEntity<String> handleIncorrectResultSizeDataAccessException(MethodArgumentTypeMismatchException ex) {
        String paramName = ex.getName();
        String errorMessage = "Query did not return a unique result for:" + paramName;
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }
}
