package com.epam.vaccinemanagementtool.controllers;

import com.epam.vaccinemanagementtool.model.UserModel;
import com.epam.vaccinemanagementtool.servicelayer.RegistrationService;
import com.epam.vaccinemanagementtool.servicelayer.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@ComponentScan(basePackages = "org.epam.webapp")
@RequestMapping("/registration")
public class RegistrationController {


    @Autowired
    RegistrationService registrationService;
    @Autowired
    UserLoginService userLoginService;

    @GetMapping
    public ModelAndView register() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @PostMapping
    public ModelAndView register1(@Valid @ModelAttribute UserModel model, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView();
        if (result.getFieldErrorCount("userName") == 0 && result.getFieldErrorCount("age") == 0 && result.getFieldErrorCount("password") == 0 && result.getFieldErrorCount("aadharNumber") == 0) {
            if (userLoginService.login(model.getAadharNumber(), model.getPassword()) == null) {
                registrationService.put(model);
                modelAndView.setViewName("ll2");
                modelAndView.addObject("successmsg", "successfully registered!");
                modelAndView.setViewName("Message");
            } else {
                modelAndView.addObject("message", "User Already Existed!");
                modelAndView.setViewName("registration");
            }

        } else {
            modelAndView.setViewName("registration");
        }
        return modelAndView;
    }
}
