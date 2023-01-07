package com.izzat.restapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserExceptionEnum {

    USER_NOT_FOUND("User not found"),
    USER_CREDENTIALS_INCORRECT("User credentials are incomplete");

    private final String message;
}
