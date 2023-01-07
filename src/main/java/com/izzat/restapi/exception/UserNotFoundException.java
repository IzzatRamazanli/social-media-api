package com.izzat.restapi.exception;

import com.izzat.restapi.enums.UserExceptionEnum;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(UserExceptionEnum message) {
        super(message.getMessage());
    }
}
