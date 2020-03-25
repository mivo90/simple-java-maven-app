package com.kwieto.api.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/")
public class HelloController {

    @RequestMapping(method = RequestMethod.GET)
    public String products() {
        return "Hello!";
    }
}
