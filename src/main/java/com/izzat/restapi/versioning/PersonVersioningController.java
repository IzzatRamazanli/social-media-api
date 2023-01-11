package com.izzat.restapi.versioning;

import com.izzat.restapi.versioning.util.Name;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

    //Twitter
    @GetMapping("v1/person")
    public Person getPersonVersionOne() {
        return new PersonV1("Izzat Ramazanli");
    }

    @GetMapping("v2/person")
    public Person getPersonVersionTwo() {
        return new PersonV2(new Name("Izzat", "Ramazanli"));
    }

    //Amazon
    @GetMapping(path = "person", params = "version=1")
    public Person getPersonVersionRequestParameter() {
        return new PersonV1("Hummat Ramazanli");
    }

    @GetMapping(path = "person", params = "version=2")
    public Person getPerson2RequestParameter() {
        return new PersonV2(new Name("Hummat", "Ramazanli"));
    }

    @GetMapping("person/static")
    public Person getPersonsVersions(@RequestParam("version") Integer version) {
        if (version == 1) return new PersonV1("Izzat Ramazanli");
        else if (version == 2) return new PersonV2(new Name("Hummat", "Ramazanli"));
        else throw new RuntimeException("no version");
    }

    //Microsoft
    @GetMapping(path = "person/header", headers = "X-API-VERSION=1")
    public Person getPersonVersionHeader() {
        return new PersonV1("Izzat Ramazanli");
    }

    @GetMapping(path = "person/header", headers = "X-API-VERSION=2")
    public Person getPersonVersionHeader2() {
        return new PersonV2(new Name("Izzat", "Ramazanli"));
    }
}
