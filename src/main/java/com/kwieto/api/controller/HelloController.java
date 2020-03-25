package com.kwieto.api.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class HelloController {

    @RequestMapping(method = RequestMethod.GET)
    public String hello() {
        return "Hello!";
    }
}
