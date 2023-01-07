package com.izzat.restapi.exception;

import com.izzat.restapi.enums.UserExceptionEnum;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
public class UserCredentialsException extends RuntimeException {
    public UserCredentialsException(UserExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMessage());
    }
}
