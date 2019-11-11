package com.sample.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Sabab on 10/7/2019.
 */

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String sayHi() {
        return "Hi!";
    }
}
