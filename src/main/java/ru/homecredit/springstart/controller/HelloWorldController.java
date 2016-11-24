package ru.homecredit.springstart.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dima
 */
@RestController
public class HelloWorldController {

    @GetMapping(value = "/hello")
    public String hello() {
        return "Hello world";
    }

    @GetMapping(value = "/helloMan")
    public String helloMen(@RequestParam String name) {
        return "Hello " + name;
    }
}
