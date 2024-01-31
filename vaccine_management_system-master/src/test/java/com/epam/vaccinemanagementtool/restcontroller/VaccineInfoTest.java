package com.epam.vaccinemanagementtool.restcontroller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.will;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import com.epam.vaccinemanagementtool.daolayer.CentersConverter;
import com.epam.vaccinemanagementtool.daolayer.UserDAOInterface;
import com.epam.vaccinemanagementtool.model.CovaxinVaccineModel;
import com.epam.vaccinemanagementtool.model.CovishieldVaccineModel;
import com.epam.vaccinemanagementtool.servicelayer.BookCenterService;
import com.epam.vaccinemanagementtool.servicelayer.VaccineCenters;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;


@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = RegistrationRestController.class)
class VaccineInfoTest {

    @Autowired
    MockMvc mockMvc;
    @MockBean
    VaccineCenters vaccineCenters;
    @MockBean
    BookCenterService bookCenterService;
    @MockBean
    UserDAOInterface userDAOInterface;
    @MockBean
    CentersConverter centersConverter;


    protected String mapToJson(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(obj);
    }

    protected <T> T mapFromJson(String json, Class<T> clazz)
            throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper objectMapper = null;
        if (json!=null){
            objectMapper= new ObjectMapper();
        }

        return objectMapper.readValue(json, clazz);
    }


    @Test
    void covaxinCentersInformation() throws Exception {
        List<CovaxinVaccineModel> list = new ArrayList<>();
        CovaxinVaccineModel covaxinVaccineModel = new CovaxinVaccineModel();
        covaxinVaccineModel.setVaccineCenter("guntur");
        covaxinVaccineModel.setCount(20);
        list.add(covaxinVaccineModel);
        given(vaccineCenters.getCovaxin()).willReturn(list);
        MvcResult mvcRes = mockMvc
                .perform(get("/available-vaccines")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .param("vaccineType","Covaxin"))
                .andReturn();
        String content = mvcRes.getResponse().getContentAsString();
        List<CovaxinVaccineModel> covaxin = mapFromJson(content, List.class);
        assertEquals(1,covaxin.size());
        assertEquals(200,mvcRes.getResponse().getStatus());
    }
    @Test
    void covishieldCentersInformation() throws Exception {
        List<CovishieldVaccineModel> list = new ArrayList<>();
        CovishieldVaccineModel covishieldVaccineModel = new CovishieldVaccineModel();
        covishieldVaccineModel.setVaccineCenter("guntur");
        covishieldVaccineModel.setCount(20);
        list.add(covishieldVaccineModel);
        given(vaccineCenters.getCovishield()).willReturn(list);
        MvcResult mvcRes = mockMvc
                .perform(get("/available-vaccines")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .param("vaccineType","Covishield"))
                .andReturn();
        String content = mvcRes.getResponse().getContentAsString();
        List<CovaxinVaccineModel> covishield = mapFromJson(content, List.class);
        assertEquals(1,covishield.size());
        assertEquals(200,mvcRes.getResponse().getStatus());
    }
    @Test
    void invalidCentersInformation() throws Exception {
        List<CovishieldVaccineModel> list = new ArrayList<>();
        list=null;
        given(vaccineCenters.getCovishield()).willReturn(list);
        MvcResult mvcRes = mockMvc
                .perform(get("/available-vaccines")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .param("vaccineType","Covishie"))
                .andReturn();
        assertEquals(204,mvcRes.getResponse().getStatus());
    }

}