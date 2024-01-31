package com.epam.vaccinemanagementtool.controllers;


import com.epam.vaccinemanagementtool.model.UserModel;
import com.epam.vaccinemanagementtool.servicelayer.BookCenterService;
import com.epam.vaccinemanagementtool.servicelayer.RegistrationService;
import com.epam.vaccinemanagementtool.servicelayer.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/BookFirstDose")
public class BookFirstDoseController {
    @Autowired
    BookCenterService bookCenterService;
    @Autowired
    RegistrationService registrationService;
    @Autowired
    UserLoginService userLoginService;

    @GetMapping
    public String bookFirstDose() {
        return "BookFirstDose";
    }

    @PostMapping
    public ModelAndView firstDose(@RequestParam("vaccineName") String vaccineName, @RequestParam("firstDoseDate") String firstDoseDate, @RequestParam("firstDoseCenterName") String firstDoseCenterName) {
        UserModel model = userLoginService.getModel();
        ModelAndView modelAndView = new ModelAndView();
        model.setVaccineName(vaccineName);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(firstDoseDate, formatter);
        model.setFirstDoseDate(localDate);
        model.setFirstDoseCenterName(firstDoseCenterName);

        if (bookCenterService.center(model.getVaccineName(), model.getFirstDoseCenterName())) {
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
