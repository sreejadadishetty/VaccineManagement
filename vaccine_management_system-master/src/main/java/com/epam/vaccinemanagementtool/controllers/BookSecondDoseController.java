package com.epam.vaccinemanagementtool.controllers;

import com.epam.vaccinemanagementtool.model.UserModel;
import com.epam.vaccinemanagementtool.servicelayer.BookCenterService;
import com.epam.vaccinemanagementtool.servicelayer.RegistrationService;
import com.epam.vaccinemanagementtool.servicelayer.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/BookSecondDose")
public class BookSecondDoseController {
    @Autowired
    BookCenterService bookCenterService;
    @Autowired
    RegistrationService registrationService;
    @Autowired
    UserLoginService userLoginService;

    @GetMapping
    public String bookSecondDose() {
        return "BookSecondDose";
    }

        @PostMapping
    public ModelAndView secondDose(@RequestParam("secondDoseDate") String secondDoseDate, @RequestParam("secondDoseCenterName") String secondDoseCenterName) {
        UserModel model = userLoginService.getModel();
        ModelAndView modelAndView = new ModelAndView();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(secondDoseDate, formatter);
        model.setSecondDoseDate(localDate);
        model.setSecondDoseCenterName(secondDoseCenterName);
        if (bookCenterService.center(model.getVaccineName(), model.getSecondDoseCenterName())) {
            modelAndView.addObject("successmsg", "Booked");
            modelAndView.setViewName("Message");
            registrationService.put(model);
        } else {
            modelAndView.addObject("successmsg", "Not Booked");
            modelAndView.setViewName("Message");
        }
        return modelAndView;
    }

}
