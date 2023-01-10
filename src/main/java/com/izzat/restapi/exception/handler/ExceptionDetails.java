package com.izzat.restapi.exception.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Instant;

@AllArgsConstructor
@Getter
public class ExceptionDetails {
    private Instant timeStamp;
    private String message;
    private String details;
    private String className;
}
