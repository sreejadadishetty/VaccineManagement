package com.epam.vaccinemanagementtool.restcontroller;

import com.epam.vaccinemanagementtool.daolayer.CovaxinVaccineInterface;
import com.epam.vaccinemanagementtool.daolayer.CovishieldVaccineInterface;
import com.epam.vaccinemanagementtool.daolayer.UserDAOInterface;
import com.epam.vaccinemanagementtool.model.UserModel;
import com.epam.vaccinemanagementtool.servicelayer.RegistrationService;
import com.epam.vaccinemanagementtool.servicelayer.UserLoginService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = RegistrationRestController.class)
class RegistrationRestControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    UserLoginService userLoginService;
    @MockBean
    RegistrationService registrationService;
    @MockBean
    CovaxinVaccineInterface covaxinVaccineInterface;
    @MockBean
    CovishieldVaccineInterface covishieldVaccineInterface;
    @MockBean
    UserDAOInterface userDAOInterface;

    ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {

    }


    @Test
    void invalidRegistration() throws Exception {
        UserModel userModel = new UserModel();
        userModel.setUserName("abc");
        userModel.setPassword("abc");
        userModel.setAadharNumber("112233445566");
        userModel.setAge(20);
        given(userLoginService.login(anyString(),anyString())).willReturn(null);
        doNothing().when(registrationService).put(any());
        mockMvc.perform(post("/vaccine-registrations")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(userModel)))
                .andExpect(status().isCreated());
    }
    @Test
    void validRegistration() throws Exception {
        UserModel userModel = new UserModel();
        userModel.setUserName("abc");
        userModel.setPassword("abc");
        userModel.setAadharNumber("112233445566");
        userModel.setAge(20);
        given(userLoginService.login(anyString(),anyString())).willReturn(userModel);
        doNothing().when(registrationService).put(any());
        mockMvc.perform(post("/vaccine-registrations")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(userModel)))
                .andExpect(status().isNotAcceptable());
    }
}