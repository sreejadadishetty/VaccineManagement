package com.epam.vaccinemanagementtool.restcontroller;

import com.epam.vaccinemanagementtool.model.UserModel;
import com.epam.vaccinemanagementtool.servicelayer.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/user-profile-information")
public class UserController {
    @Autowired
    UserLoginService userLoginService;

    @GetMapping
    public ResponseEntity<Object> userInformation(@RequestBody UserModel userModel) {
        ResponseEntity<Object> responseEntity;
        UserModel userModel1 = userLoginService.loginValidation(userModel.getAadharNumber(), userModel.getPassword());
        if (userModel1 != null) {
            responseEntity = new ResponseEntity<>(userModel, HttpStatus.FOUND);
        }
        else {
            responseEntity = new ResponseEntity<>("First Login!", HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }
}
