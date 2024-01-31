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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class BookFirstDoseControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    BookCenterService bookCenterService;
    @MockBean
    RegistrationService registrationService;
    @MockBean
    UserLoginService userLoginService;

    @Test
    void bookFirstDose() throws Exception {
        mockMvc.perform(get("/BookFirstDose")).andExpect(status().isOk()).andExpect(view().name("BookFirstDose"));
    }

    @Test
    void firstDose() throws Exception {
        UserModel userModel = new UserModel();
        when(userLoginService.getModel()).thenReturn(userModel);
        when(bookCenterService.center(anyString(), anyString())).thenReturn(true);
        //doNothing().when(registrationService).put(any());
        mockMvc.perform(post("/BookFirstDose")
                        .param("vaccineName", "Covaxin")
                        .param("firstDoseDate", "2021-02-22")
                        .param("firstDoseCenterName", "guntur"))
                .andExpect(status().isOk()).andExpect(view().name("Message")).andExpect(model().attribute("successmsg", "Booked"));

    }

    @Test
    void firstDose1() throws Exception {
        UserModel userModel = new UserModel();
        when(userLoginService.getModel()).thenReturn(userModel);
        when(bookCenterService.center(anyString(), anyString())).thenReturn(false);
        doNothing().when(registrationService).put(any());
        mockMvc.perform(post("/BookFirstDose")
                        .param("vaccineName", "Covaxin")
                        .param("firstDoseDate", "2021-02-22")
                        .param("firstDoseCenterName", "guntur"))
                .andExpect(status().isOk()).andExpect(view().name("Message"));

    }
}