package com.epam.vaccinemanagementtool.controllers;

import com.epam.vaccinemanagementtool.model.CovaxinVaccineModel;
import com.epam.vaccinemanagementtool.model.CovishieldVaccineModel;
import com.epam.vaccinemanagementtool.servicelayer.VaccineCenters;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


@SpringBootTest
@AutoConfigureMockMvc
class ViewCentersInfoTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    VaccineCenters vaccineCenters;

    @Test
    void centersInfo() throws Exception {
        List<CovaxinVaccineModel> list = new ArrayList<>();
        CovaxinVaccineModel model = new CovaxinVaccineModel();
        model.setCount(20);
        model.setVaccineCenter("guntur");
        list.add(model);
        when(vaccineCenters.getCovaxin()).thenReturn(list);
        List<CovishieldVaccineModel> list2 = new ArrayList<>();
        CovishieldVaccineModel model1 = new CovishieldVaccineModel();
        model1.setCount(20);
        model1.setVaccineCenter("hyd");
        when(vaccineCenters.getCovishield()).thenReturn(list2);
        mockMvc.perform(get("/ViewCentersInfo"))
                .andExpect(status().isOk())
                .andExpect(view().name("ViewCentersInfo"));

    }
}