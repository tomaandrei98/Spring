package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ResourceController {
    @GetMapping("/")
    public String welcome() {
        return "home";
    }
}
