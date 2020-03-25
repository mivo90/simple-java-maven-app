package com.kwieto.api.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/products")
public class ProductController {

    RestTemplate restTemplate = new RestTemplate();

    @RequestMapping(method = RequestMethod.GET)
    public String products() {
        final String uri = "http://catalog:8081/products";
        return this.restTemplate.getForObject(uri, String.class);
    }

    @RequestMapping(method = RequestMethod.POST)
    public String create() {
        final String uri = "http://catalog:8081/products/";
        return this.restTemplate.postForObject(uri, null, String.class);
    }
}
