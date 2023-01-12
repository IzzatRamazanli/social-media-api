package com.izzat.restapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PostExceptionEnum {
    POST_NOT_FOUND("Post not found");

    private final String message;
}
