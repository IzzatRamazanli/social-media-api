package com.izzat.restapi.exception;

import com.izzat.restapi.enums.PostExceptionEnum;


public class PostNotFoundException extends RuntimeException{

    public PostNotFoundException(PostExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMessage());
    }
}
