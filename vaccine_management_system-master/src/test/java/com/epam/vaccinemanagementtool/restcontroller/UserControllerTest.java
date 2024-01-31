package com.epam.vaccinemanagementtool.restcontroller;

import com.epam.vaccinemanagementtool.daolayer.CovaxinVaccineInterface;
import com.epam.vaccinemanagementtool.daolayer.CovishieldVaccineInterface;
import com.epam.vaccinemanagementtool.daolayer.UserDAOInterface;
import com.epam.vaccinemanagementtool.model.UserModel;
import com.epam.vaccinemanagementtool.servicelayer.UserLoginService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import javax.inject.Inject;

import java.io.IOException;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = UserController.class)
class UserControllerTest {
    @MockBean
    UserLoginService userLoginService;
    @Autowired
    private MockMvc mockmvc;
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
    void userInformation() throws Exception {
        given(userLoginService.loginValidation(any(),any())).willReturn(userModel);
        mockmvc.perform(get("/user-profile-information").contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(userModel))).andExpect(status().isFound())
                .andExpect(jsonPath("$.password", Matchers.equalTo(userModel.getPassword())));
    }
    @Test
    void invalidUserInformation() throws Exception {
        given(userLoginService.loginValidation(anyString(),anyString())).willReturn(null);
        mockmvc.perform(get("/user-profile-information").contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(new UserModel()))).andExpect(status().isBadRequest());

    }
}
