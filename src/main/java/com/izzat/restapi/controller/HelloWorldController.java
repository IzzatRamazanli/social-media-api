package com.izzat.restapi.controller;

import com.izzat.restapi.bean.HelloWorldBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("hello")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping("hello-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello World Bean");
    }

    @GetMapping("hello/{name}")
    public HelloWorldBean greetPerson(@PathVariable String name) {
        return new HelloWorldBean(String.format("Hello, %s", name.toUpperCase()));
    }
}
