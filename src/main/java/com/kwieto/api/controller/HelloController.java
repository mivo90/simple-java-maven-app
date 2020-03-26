package com.kwieto.api.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "Ik ben er h-h-helemaal klaar mee ~Guido ";
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return "Test!";
    }
}
