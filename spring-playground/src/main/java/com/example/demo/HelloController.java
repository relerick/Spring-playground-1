package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/math/pi")
    public String Pi() {
        return "3.141592653589793";
    }

    @GetMapping("/")
    public String helloWorld() {
        return "Hello from Spring!";
    }
}




