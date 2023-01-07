package com.izzat.restapi.exception.handler;

import com.izzat.restapi.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionDetails> handleAllExceptions(Exception ex, WebRequest request) {

        ExceptionDetails exceptionDetails = new ExceptionDetails(
                LocalDateTime.now(),
                ex.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<>(exceptionDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<ExceptionDetails> userNotFound(UserNotFoundException ex, WebRequest request) {

        ExceptionDetails exceptionDetails = new ExceptionDetails(
                LocalDateTime.now(),
                ex.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<>(exceptionDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RuntimeException.class)
    public final ResponseEntity<ExceptionDetails> handleAllExceptions(RuntimeException ex, WebRequest request) {

        ExceptionDetails exceptionDetails = new ExceptionDetails(
                LocalDateTime.now(),
                ex.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<>(exceptionDetails, HttpStatus.UNAUTHORIZED);
    }


}
