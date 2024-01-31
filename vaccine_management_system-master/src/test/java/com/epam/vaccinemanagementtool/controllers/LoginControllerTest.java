package com.epam.vaccinemanagementtool.controllers;

import com.epam.vaccinemanagementtool.model.UserModel;
import com.epam.vaccinemanagementtool.servicelayer.UserLoginService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
class LoginControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    UserLoginService loginService;

    @Test
    void login() throws Exception {
        mockMvc.perform(get("/login")).andExpect(status().isOk()).andExpect(view().name("login"));
    }

    @Test
    void ll2() throws Exception {
        when(loginService.login(anyString(), anyString())).thenReturn(null);
        mockMvc.perform(post("/login")).andExpect(status().isOk()).andExpect(view().name("login"));
    }

    @Test
    void loginTest() throws Exception {
        UserModel user = new UserModel();
        user.setUserName("abc");
        user.setAadharNumber("112233445566");
        user.setPassword("pass");
        given(loginService.login(anyString(), anyString())).willReturn(user);
        mockMvc.perform(post("/login").contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .flashAttr("model", user))
                .andExpect(status().isOk()).andExpect(view().name("loginOptions"));
    }

    @Test
    void logintest() throws Exception {
        UserModel user = new UserModel();
        user.setUserName("abc");
        user.setAadharNumber("112233445566");
        user.setPassword("pass");
        given(loginService.login(anyString(), anyString())).willReturn(null);
        mockMvc.perform(post("/login").contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .flashAttr("model", user))
                .andExpect(status().isOk()).andExpect(view().name("login"));
    }


    @Test
    void ll4() throws Exception {
        UserModel model = new UserModel();
        model.setUserName("abc");
        model.setAadharNumber("112233445566");

        when(loginService.login(anyString(), anyString())).thenReturn(model);
        mockMvc.perform(post("/login")).andExpect(status().isOk()).andExpect(view().name("login"));
    }
}