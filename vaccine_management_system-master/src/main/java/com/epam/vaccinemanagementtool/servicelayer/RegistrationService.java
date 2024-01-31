package com.epam.vaccinemanagementtool.servicelayer;

import com.epam.vaccinemanagementtool.daolayer.UserConverter;
import com.epam.vaccinemanagementtool.daolayer.UserDAOInterface;
import com.epam.vaccinemanagementtool.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    @Autowired
    UserConverter converter;
    @Autowired
    UserDAOInterface userDAOInterface;

    public boolean userNameValidation(String userName) {
        return !userName.matches("[a-zA-Z]+");
    }

    public boolean userPasswordValidation(String password) {
        return password.isBlank();
    }

    public boolean userAgeValidation(int age) {
        return (age >= 15 && age <= 95);
    }

    public String checkAadhaar(String aadharNumber) {
        aadharNumber = aadharNumber.replaceAll("[^0-9]", "");
        String message = null;
        if (aadharNumber.length() != 12) {
            message = "Enter correct aadhaar number!!";
        } else {
            UserModel model = converter.getUser(aadharNumber);
            if (model != null) {
                message = "Aadhaar number already exists!!";
            }
        }
        return message;

    }


    public void register(UserModel model) {
        converter.putUser(model);
        //store the data and assert equals
    }

    public void put(UserModel model) {
        userDAOInterface.save(converter.dtoToEntity(model));
    }

}
