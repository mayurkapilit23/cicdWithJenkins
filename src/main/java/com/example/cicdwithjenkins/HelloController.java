package com.example.cicdwithjenkins;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "ci cd with jenkins on AWS EC2";
    }

    @GetMapping("/{name}/hello")
    public String greet(@PathVariable String name) {
        return "Hello " + name + " ";
    }

    @GetMapping("/{value}")
    public String multiply(@PathVariable int value) {
        return "Ans " + value * value;
    }

}
