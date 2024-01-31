package com.epam.vaccinemanagementtool.controllers;

import com.epam.vaccinemanagementtool.model.CovaxinVaccineModel;
import com.epam.vaccinemanagementtool.model.CovishieldVaccineModel;
import com.epam.vaccinemanagementtool.servicelayer.VaccineCenters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/ViewCentersInfo")
public class ViewCentersInfo {
    @Autowired
    VaccineCenters vaccineCenters;

    @GetMapping
    public ModelAndView centersInfo() {
        ModelAndView modelAndView = new ModelAndView();
        List<CovaxinVaccineModel> l1 = vaccineCenters.getCovaxin();
        modelAndView.addObject("l1", l1);
        List<CovishieldVaccineModel> l2 = vaccineCenters.getCovishield();
        modelAndView.addObject("l2", l2);
        modelAndView.setViewName("ViewCentersInfo");
        return modelAndView;
    }

}
