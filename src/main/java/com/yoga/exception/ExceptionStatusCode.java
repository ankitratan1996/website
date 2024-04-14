package com.yoga.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
public enum ExceptionStatusCode {

    INVALID_INPUT("The user request is invalid", HttpStatus.BAD_REQUEST),
    INVALID_USER("the user does not exist for this id",HttpStatus.BAD_REQUEST),
    INVALID_EMAIL("the email does not exit in our database",HttpStatus.BAD_REQUEST),
    EMAIL_EXIST("Email is already register",HttpStatus.BAD_REQUEST);
    private final  String statusMessage;
    private final HttpStatus httpStatus;

    ExceptionStatusCode(String statusMessage, HttpStatus httpStatus) {
        this.statusMessage = statusMessage;
        this.httpStatus = httpStatus;
    }
}
