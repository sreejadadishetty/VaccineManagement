package com.epam.vaccinemanagementtool.servicelayer;


import com.epam.vaccinemanagementtool.daolayer.CentersConverter;
import com.epam.vaccinemanagementtool.model.CovaxinVaccineModel;
import com.epam.vaccinemanagementtool.model.CovishieldVaccineModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class VaccineCentersTest {

    @Mock
    CentersConverter centersConverter;
    @InjectMocks
    VaccineCenters vaccineCenters;

    @Test
    void getCovaxinInfo() {
        List<CovaxinVaccineModel> list = new ArrayList<>();
        CovaxinVaccineModel model = new CovaxinVaccineModel();
        model.setVaccineCenter("hddd");
        model.setCount(20);
        list.add(model);
        when(centersConverter.covaxinInformation1()).thenReturn(list);
        assertNotNull(vaccineCenters.getCovaxin());
        assertNotNull(list);
        assertEquals(list.get(0).getCount(), vaccineCenters.getCovaxin().get(0).getCount());
    }


    @Test
    void getCovishieldInfo() {
        List<CovishieldVaccineModel> list = new ArrayList<>();
        CovishieldVaccineModel model = new CovishieldVaccineModel();
        model.setVaccineCenter("Guntur");
        model.setCount(20);
        list.add(model);
        when(centersConverter.covishieldInformation1()).thenReturn(list);
        assertNotNull(list);
        assertNotNull(vaccineCenters.getCovishield());
        assertEquals(list.get(0).getCount(), vaccineCenters.getCovishield().get(0).getCount());
    }
}