package com.epam.vaccinemanagementtool.restcontroller;

import com.epam.vaccinemanagementtool.model.UserModel;
import com.epam.vaccinemanagementtool.servicelayer.BookCenterService;
import com.epam.vaccinemanagementtool.servicelayer.RegistrationService;
import com.epam.vaccinemanagementtool.servicelayer.UserLoginService;
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
@RequestMapping("/book-first-dose")
public class ScheduleFirstDoseController {

    @Inject
    BookCenterService bookCenterService;
    @Inject
    RegistrationService registrationService;
    @Inject
    UserLoginService userLoginService;


    @PutMapping
    public ResponseEntity<Object> bookFirstDose(@RequestBody UserModel userModel) {
        ResponseEntity<Object> responseEntity = null;
        UserModel model = userLoginService.login(userModel.getAadharNumber(), userModel.getPassword());
        if (model != null && model.getFirstDoseDate() == null) {
            model.setVaccineName(userModel.getVaccineName());
            model.setFirstDoseDate(userModel.getFirstDoseDate());
            model.setFirstDoseCenterName(userModel.getFirstDoseCenterName());
            if (bookCenterService.center(model.getVaccineName(), model.getFirstDoseCenterName())) {
                registrationService.put(model);
                responseEntity = new ResponseEntity<>("Successfully Registered!!", HttpStatus.CREATED);
            } else {
                responseEntity = new ResponseEntity<>("Not Booked!!", HttpStatus.BAD_REQUEST);
            }
        } else {
            responseEntity = new ResponseEntity<>("First Dose is already taken!!", HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }
}
