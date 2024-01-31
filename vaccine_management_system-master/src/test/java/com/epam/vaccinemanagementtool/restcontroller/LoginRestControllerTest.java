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
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = LoginRestController.class)
class LoginRestControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    UserLoginService userLoginService;
    @MockBean
    CovaxinVaccineInterface covaxinVaccineInterface;
    @MockBean
    CovishieldVaccineInterface covishieldVaccineInterface;
    @MockBean
    UserDAOInterface userDAOInterface;

    ObjectMapper objectMapper = new ObjectMapper();

    UserModel userModel = new UserModel();
    @BeforeEach
    void setUp() {
        userModel.setUserName("abc");
        userModel.setPassword("abc");
        userModel.setAadharNumber("112233445566");
        userModel.setAge(20);
    }


    @Test
    void userInfo() throws Exception {
        given(userLoginService.login(any(),any())).willReturn(userModel);
        mockMvc.perform(post("/rest-login")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(userModel)))
                .andExpect(status().isOk());

    }

    @Test
    void invalidUserInfo() throws Exception {
        given(userLoginService.login(any(),any())).willReturn(null);
        mockMvc.perform(post("/rest-login")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(userModel)))
                .andExpect(status().isNoContent());

    }
}