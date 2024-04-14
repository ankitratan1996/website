package com.yoga.exception;

import lombok.Getter;

@Getter
public class InvalidInputException extends RuntimeException{

    private ExceptionStatusCode exceptionStatusCode;
    public InvalidInputException(ExceptionStatusCode exceptionStatusCode)
    {
        super(exceptionStatusCode.getStatusMessage());
        this.exceptionStatusCode=exceptionStatusCode;
    }
}
