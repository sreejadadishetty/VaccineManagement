package com.epam.vaccinemanagementtool.controllers;

import com.epam.vaccinemanagementtool.servicelayer.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/UserDashboard")
public class UserDashboard {
    @Autowired
    UserLoginService loginService;

    @GetMapping
    public ModelAndView user() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("model", loginService.getModel());
        modelAndView.setViewName("UserDashboard");
        return modelAndView;
    }
}
