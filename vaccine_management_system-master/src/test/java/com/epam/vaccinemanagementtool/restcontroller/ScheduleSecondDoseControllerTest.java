package com.epam.vaccinemanagementtool.restcontroller;

import com.epam.vaccinemanagementtool.daolayer.CentersConverter;
import com.epam.vaccinemanagementtool.daolayer.UserDAOInterface;
import com.epam.vaccinemanagementtool.model.UserModel;
import com.epam.vaccinemanagementtool.servicelayer.BookCenterService;
import com.epam.vaccinemanagementtool.servicelayer.RegistrationService;
import com.epam.vaccinemanagementtool.servicelayer.UserLoginService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = ScheduleSecondDoseController.class)
class ScheduleSecondDoseControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    UserLoginService userLoginService;
    @MockBean
    BookCenterService bookCenterService;
    @MockBean
    RegistrationService registrationService;
    @MockBean
    UserDAOInterface userDAOInterface;
    @MockBean
    CentersConverter centersConverter;
    ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
    }

    @Test
    void secondDose() throws Exception {
        UserModel userModel = new UserModel();
        userModel.setAadharNumber("112233445566");
        userModel.setPassword("abc");
        userModel.setSecondDoseDate(LocalDate.parse("2021-12-01"));
        userModel.setSecondDoseCenterName("guntur");

        UserModel userModel1 = new UserModel();
        userModel1.setAadharNumber("112233445566");
        userModel1.setFirstDoseDate(LocalDate.parse("2021-12-01"));
        userModel1.setVaccineName("Covaxin");
        userModel1.setPassword("abc");
        when(userLoginService.login(anyString(),anyString())).thenReturn(userModel1);
        when(bookCenterService.center(anyString(),anyString())).thenReturn(true);
        doNothing().when(registrationService).put(any());
        mockMvc.perform(put("/book-second_dose").contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(userModel)))
                .andExpect(status().isCreated());
    }
    @Test
    void testSecondDose() throws Exception {
        UserModel userModel = new UserModel();
        userModel.setAadharNumber("112233445566");
        userModel.setPassword("abc");
        userModel.setSecondDoseDate(LocalDate.parse("2021-12-01"));
        userModel.setSecondDoseCenterName("guntur");

        UserModel userModel1 = new UserModel();
        userModel1.setAadharNumber("112233445566");
        userModel1.setFirstDoseDate(LocalDate.parse("2021-12-01"));
        userModel1.setVaccineName("Covaxin");
        userModel1.setPassword("abc");
        when(userLoginService.login(anyString(),anyString())).thenReturn(null);
        when(bookCenterService.center(anyString(),anyString())).thenReturn(true);
        doNothing().when(registrationService).put(any());
        mockMvc.perform(put("/book-second_dose").contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(userModel)))
                .andExpect(status().isBadRequest());
    }
    @Test
    void invalidSecondDose() throws Exception {
        UserModel userModel = new UserModel();
        userModel.setAadharNumber("112233445566");
        userModel.setPassword("abc");
        userModel.setSecondDoseDate(LocalDate.parse("2021-12-01"));
        userModel.setSecondDoseCenterName("guntur");

        UserModel userModel1 = new UserModel();
        userModel1.setAadharNumber("112233445566");
        userModel1.setFirstDoseDate(LocalDate.parse("2021-12-01"));
        userModel1.setVaccineName("Covaxin");
        userModel1.setPassword("abc");
        when(userLoginService.login(anyString(),anyString())).thenReturn(userModel1);
        when(bookCenterService.center(anyString(),anyString())).thenReturn(false);
        doNothing().when(registrationService).put(any());
        mockMvc.perform(put("/book-second_dose").contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(userModel)))
                .andExpect(status().isBadRequest());
    }
}