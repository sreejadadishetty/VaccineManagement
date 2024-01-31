package com.epam.vaccinemanagementtool.controllers;

import com.epam.vaccinemanagementtool.model.UserModel;
import com.epam.vaccinemanagementtool.servicelayer.BookCenterService;
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
class BookSecondDoseControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    BookCenterService bookCenterService;
    @MockBean
    RegistrationService registrationService;
    @MockBean
    UserLoginService userLoginService;

    @Test
    void bookSecondDose() throws Exception {
        mockMvc.perform(get("/BookSecondDose")).andExpect(status().isOk()).andExpect(view().name("BookSecondDose"));
    }

    @Test
    void secondDose() throws Exception {
        UserModel userModel = new UserModel();
        userModel.setVaccineName("Covaxin");
        when(userLoginService.getModel()).thenReturn(userModel);
        when(bookCenterService.center(anyString(), anyString())).thenReturn(true);
        doNothing().when(registrationService).put(any());
        mockMvc.perform(post("/BookSecondDose")
                        .param("secondDoseDate", "2021-02-22")
                        .param("secondDoseCenterName", "guntur"))
                .andExpect(status().isOk()).andExpect(view().name("Message"));


    }

    @Test
    void secondDose2() throws Exception {
        UserModel userModel = new UserModel();
        when(userLoginService.getModel()).thenReturn(userModel);
        when(bookCenterService.center(anyString(), anyString())).thenReturn(false);
        doNothing().when(registrationService).put(any());
        mockMvc.perform(post("/BookSecondDose")
                        .param("secondDoseDate", "2021-02-22")
                        .param("secondDoseCenterName", "guntur"))
                .andExpect(status().isOk()).andExpect(view().name("Message"));


    }
}