package com.izzat.restapi.filtering;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilterController {

    private final SomeBean someBean = new SomeBean("value1", "value2", "value3");

    @GetMapping("/filtering")
    public SomeBean filtering() {
        return someBean;
    }
}
