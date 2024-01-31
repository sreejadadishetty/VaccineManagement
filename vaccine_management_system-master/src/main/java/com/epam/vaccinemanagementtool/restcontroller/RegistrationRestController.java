package com.epam.vaccinemanagementtool.restcontroller;

import com.epam.vaccinemanagementtool.model.UserModel;
import com.epam.vaccinemanagementtool.servicelayer.RegistrationService;
import com.epam.vaccinemanagementtool.servicelayer.UserLoginService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.validation.Valid;

@RestController
@RequestMapping("/vaccine-registrations")
public class RegistrationRestController {

    @Inject
    UserLoginService userLoginService;
    @Inject
    RegistrationService registrationService;


    @PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> registration(@RequestBody UserModel userModel) {
        ResponseEntity<String> responseEntity;
        UserModel userModel1 = userLoginService.login(userModel.getAadharNumber(), userModel.getPassword());
        if (userModel1 == null) {
            registrationService.put(userModel);//doNothing
            responseEntity = new ResponseEntity<>("Successfully Registered!!", HttpStatus.CREATED);
        } else {
            responseEntity = new ResponseEntity<>("User already existed",HttpStatus.NOT_ACCEPTABLE);
        }
        return responseEntity;
    }
}
