package com.group4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Books {

    @GetMapping("/index")
    public String helloPage() {
        return null;
    }
}
