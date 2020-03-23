package com.bootcamp.demo_project.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/")
public class HomeController {

    @RequestMapping("/")
    public String index()
    {
        return"index";
    }
}
