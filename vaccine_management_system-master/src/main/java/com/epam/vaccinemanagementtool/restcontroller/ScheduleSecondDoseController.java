package com.epam.vaccinemanagementtool.restcontroller;

import com.epam.vaccinemanagementtool.model.UserModel;
import com.epam.vaccinemanagementtool.servicelayer.BookCenterService;
import com.epam.vaccinemanagementtool.servicelayer.RegistrationService;
import com.epam.vaccinemanagementtool.servicelayer.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/book-second_dose")
public class ScheduleSecondDoseController {
    @Autowired
    BookCenterService bookCenterService;
    @Autowired
    RegistrationService registrationService;
    @Inject
    UserLoginService userLoginService;


    @PutMapping
    public ResponseEntity<Object> secondDose(@RequestBody UserModel userModel) {
        UserModel model = userLoginService.login(userModel.getAadharNumber(), userModel.getPassword());
        ResponseEntity<Object> responseEntity = null;
        if (model != null && model.getFirstDoseDate() != null && model.getSecondDoseDate() == null) {
            model.setSecondDoseDate(userModel.getSecondDoseDate());
            model.setSecondDoseCenterName(userModel.getSecondDoseCenterName());
            if (bookCenterService.center(model.getVaccineName(), model.getSecondDoseCenterName())) {
                registrationService.put(model);
                responseEntity = new ResponseEntity<>("Success", HttpStatus.CREATED);
            } else {
                responseEntity = new ResponseEntity<>("Invalid Vaccine Name or Center", HttpStatus.BAD_REQUEST);
            }
        } else {
            responseEntity = new ResponseEntity<>("Invalid!!", HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }
}
