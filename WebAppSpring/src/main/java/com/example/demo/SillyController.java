package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class SillyController {

    @RequestMapping("/showForm")
    public String displayTheForm() {
        return "silly";
    }
}
