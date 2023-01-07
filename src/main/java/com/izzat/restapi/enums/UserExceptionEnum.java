package com.izzat.restapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserExceptionEnum {

    USER_NOT_FOUND("User not found"),
    USER_VALIDATION_ISSUE("User details are not valid");

    private final String message;
}
