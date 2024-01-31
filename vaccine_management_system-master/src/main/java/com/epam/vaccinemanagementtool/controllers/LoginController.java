package com.epam.vaccinemanagementtool.controllers;

import com.epam.vaccinemanagementtool.model.UserModel;
import com.epam.vaccinemanagementtool.servicelayer.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    UserLoginService loginService;

    @GetMapping
    public String login() {
        return "login";
    }

    @PostMapping
    public ModelAndView ll2(@Valid @ModelAttribute("model") UserModel model, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView();
        if (result.getFieldErrorCount("password") == 0 && result.getFieldErrorCount("aadhaar") == 0) {
            UserModel model1 = loginService.login(model.getAadharNumber(), model.getPassword());
            if (model1 == null) {
                modelAndView.addObject("message", "Invalid Crendentials!");
                modelAndView.setViewName("login");
            } else {
                modelAndView.setViewName("loginOptions");
            }
        } else {
            modelAndView.setViewName("login");
        }
        return modelAndView;
    }
}
