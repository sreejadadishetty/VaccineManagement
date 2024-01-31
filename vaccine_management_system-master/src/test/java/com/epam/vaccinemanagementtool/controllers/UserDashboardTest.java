package com.epam.vaccinemanagementtool.controllers;

import com.epam.vaccinemanagementtool.model.UserModel;
import com.epam.vaccinemanagementtool.servicelayer.UserLoginService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
class UserDashboardTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    UserLoginService userLoginService;

    @Test
    void user() throws Exception {
        UserModel userModel = new UserModel();
        userModel.setUserName("abc");
        when(userLoginService.getModel()).thenReturn(userModel);
        mockMvc.perform(get("/UserDashboard"))
                .andExpect(status().isOk())
                .andExpect(view().name("UserDashboard"));
    }
}