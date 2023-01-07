package com.izzat.restapi.exception;

import com.izzat.restapi.enums.UserExceptionEnum;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(UserExceptionEnum message) {
        super(message.getMessage());
    }
}
