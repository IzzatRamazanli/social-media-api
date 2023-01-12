package com.izzat.restapi.exception.handler;

import com.izzat.restapi.exception.PostNotFoundException;
import com.izzat.restapi.exception.UserNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;
import java.util.Objects;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionDetails> handleAllExceptions(Exception ex, WebRequest request) {

        ExceptionDetails exceptionDetails = new ExceptionDetails(
                Instant.now(),
                ex.getMessage(),
                request.getDescription(false),
                ex.getClass().getSimpleName()
        );

        return new ResponseEntity<>(exceptionDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<ExceptionDetails> userNotFound(UserNotFoundException ex, WebRequest request) {

        ExceptionDetails exceptionDetails = new ExceptionDetails(
                Instant.now(),
                ex.getMessage(),
                request.getDescription(false),
                ex.getClass().getSimpleName()
        );

        return new ResponseEntity<>(exceptionDetails, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatusCode status,
                                                                  WebRequest request) {

        ExceptionDetails exceptionDetails = new ExceptionDetails(
                Instant.now(),
                Objects.requireNonNull(ex.getFieldError()).getDefaultMessage(),
                request.getDescription(false),
                ex.getClass().getSimpleName()
        );

        return new ResponseEntity<>(exceptionDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PostNotFoundException.class)
    public final ResponseEntity<ExceptionDetails> postNotFound(PostNotFoundException ex, WebRequest request) {

        ExceptionDetails exceptionDetails = new ExceptionDetails(
                Instant.now(),
                ex.getMessage(),
                request.getDescription(false),
                ex.getClass().getSimpleName()
        );

        return new ResponseEntity<>(exceptionDetails, HttpStatus.NOT_FOUND);
    }



}
