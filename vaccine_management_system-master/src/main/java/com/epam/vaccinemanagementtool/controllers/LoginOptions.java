package com.epam.vaccinemanagementtool.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/loginOptions")
public class LoginOptions {
    @GetMapping
    public String loginOptions() {
        return "loginOptions";
    }

}
