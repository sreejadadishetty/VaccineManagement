package com.epam.vaccinemanagementtool.controllers;

import com.epam.vaccinemanagementtool.model.UserModel;
import com.epam.vaccinemanagementtool.servicelayer.RegistrationService;
import com.epam.vaccinemanagementtool.servicelayer.UserLoginService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
class RegistrationControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    RegistrationService registrationService;
    @MockBean
    UserLoginService userLoginService;

    @Test
    void register() throws Exception {
        mockMvc.perform(get("/registration"))
                .andExpect(status().isOk()).andExpect(view().name("registration"));
    }

    @Test
    void register1() throws Exception {
        UserModel user = new UserModel();
        user.setUserName("abc");
        Integer age = 22;
        user.setAge(age);
        user.setPassword("abc");
        user.setAadharNumber("112233445566");
        when(userLoginService.login(anyString(), anyString())).thenReturn(null);
        doNothing().when(registrationService).put(any());
        mockMvc.perform(post("/registration")
                        .param("userName", user.getUserName())
                        .param("aadharNumber", user.getAadharNumber())
                        .param("password", user.getPassword())
                        .param("age", String.valueOf(user.getAge())))
                .andExpect(status().isOk())
                .andExpect(view().name("Message"));

    }

    @Test
    void unSuccessRegister() throws Exception {
        UserModel user = new UserModel();
        user.setUserName("abc");
        Integer age = 22;
        user.setAge(age);
        user.setPassword("abc");
        user.setAadharNumber("112233445566");
        when(userLoginService.login(anyString(), anyString())).thenReturn(null);
        doNothing().when(registrationService).put(any());
        mockMvc.perform(post("/registration")
                        .param("userName", user.getUserName())
                        .param("aadharNumber", user.getAadharNumber())
                        .param("age", String.valueOf(user.getAge())))
                .andExpect(status().isOk())
                .andExpect(view().name("registration"));

    }

    @Test
    void alreadyRegister() throws Exception {
        UserModel user = new UserModel();
        user.setUserName("abc");
        Integer age = 22;
        user.setAge(age);
        user.setPassword("abc");
        user.setAadharNumber("112233445566");
        when(userLoginService.login(anyString(), anyString())).thenReturn(user);
        doNothing().when(registrationService).put(any());
        mockMvc.perform(post("/registration")
                        .param("userName", user.getUserName())
                        .param("aadharNumber", user.getAadharNumber())
                        .param("password", user.getPassword())
                        .param("age", String.valueOf(user.getAge())))
                .andExpect(status().isOk())
                .andExpect(view().name("registration"));

    }
}