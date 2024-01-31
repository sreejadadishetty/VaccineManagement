package com.epam.vaccinemanagementtool.servicelayer;

import com.epam.vaccinemanagementtool.daolayer.UserConverter;
import com.epam.vaccinemanagementtool.daolayer.UserDAOInterface;
import com.epam.vaccinemanagementtool.entities.UserEntity;
import com.epam.vaccinemanagementtool.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLoginService {
    @Autowired
    UserConverter userConverter;
    UserModel model = null;
    @Autowired
    UserDAOInterface userDAOInterface;


    public UserModel loginValidation(String aadhaarNumber, String password) {
        model = userConverter.getUser(aadhaarNumber);
        if (model != null && !model.getPassword().equals(password)) {
            model = null;
        }
        return model;
    }


    public UserModel login(String aadhaarNumber, String password) {
        UserEntity entity = userDAOInterface.findByAadharnumberAndPassword(aadhaarNumber, password);
        model = userConverter.entityToDto(entity);
        return model;
    }


    public UserModel getModel() {
        return model;
    }
}

