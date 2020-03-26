package com.kwieto.api.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "Werkt dit 2.0? ";
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return "Test!";
    }
}
