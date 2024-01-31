package com.epam.vaccinemanagementtool.servicelayer;


import com.epam.vaccinemanagementtool.daolayer.UserConverter;
import com.epam.vaccinemanagementtool.daolayer.UserDAOInterface;
import com.epam.vaccinemanagementtool.entities.UserEntity;
import com.epam.vaccinemanagementtool.model.UserModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserLoginServiceTest {
    @Mock
    UserConverter userConverter;
    @InjectMocks
    UserLoginService login;
    @Mock
    UserDAOInterface userDAOInterface;


    @Test
    void loginValidation() {
        UserModel userModel = new UserModel();
        userModel.setAadharNumber("112233445566");
        userModel.setPassword("abc");
        when(userConverter.getUser(anyString())).thenReturn(userModel);
        UserModel model = login.loginValidation("112233445566", "abc");
        assertEquals(model.getAadharNumber(), userModel.getAadharNumber());
    }

    @Test
    void invalidLoginValidation() {

        when(userConverter.getUser(anyString())).thenReturn(null);
        UserModel model = login.loginValidation("112233445566", "abc");
        assertEquals(null, model);
    }

    @Test
    void invalidPasswordValidation() {
        UserModel userModel = new UserModel();
        userModel.setAadharNumber("112233445566");
        userModel.setPassword("ac");
        when(userConverter.getUser(anyString())).thenReturn(userModel);
        UserModel model = login.loginValidation("112233445566", "abc");
        assertEquals(null, model);
    }


    @Test
    void login() {
        UserModel userModel = new UserModel();
        UserEntity userEntity = new UserEntity();
        userModel.setAadharNumber("112233445566");
        when(userConverter.entityToDto(any())).thenReturn(userModel);
        when(userDAOInterface.findByAadharnumberAndPassword(anyString(), anyString())).thenReturn(userEntity);
        UserModel model = login.login(anyString(), anyString());
        assertEquals(model.getAadharNumber(), userModel.getAadharNumber());
    }

    @Test
    void loginWithNotRegistered() {
        UserModel userModel = new UserModel();
        UserEntity userEntity = new UserEntity();
        userModel.setAadharNumber("112233445566");
        when(userConverter.entityToDto(any())).thenReturn(null);
        when(userDAOInterface.findByAadharnumberAndPassword(anyString(), anyString())).thenReturn(null);
        UserModel model = login.login(anyString(), anyString());
        assertEquals(null, model);
    }

    @Test
    void getModelTest() {

        assertEquals(null, login.getModel());

    }


}