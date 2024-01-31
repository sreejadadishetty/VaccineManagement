package com.epam.vaccinemanagementtool.restcontroller;

import com.epam.vaccinemanagementtool.model.UserModel;
import com.epam.vaccinemanagementtool.servicelayer.UserLoginService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
@RequestMapping(value = "/rest-login")
public class LoginRestController {
    @Inject
    UserLoginService userLoginService;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<UserModel> userInfo(@RequestBody UserModel model) {
        ResponseEntity<UserModel> responseEntity;
        UserModel userModel = userLoginService.login(model.getAadharNumber(), model.getPassword());
        if (userModel != null) {
            responseEntity = new ResponseEntity<>(userModel, HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return responseEntity;
    }

}
