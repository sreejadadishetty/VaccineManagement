package com.epam.vaccinemanagementtool.servicelayer;

import com.epam.vaccinemanagementtool.daolayer.CentersConverter;
import com.epam.vaccinemanagementtool.model.CovaxinVaccineModel;
import com.epam.vaccinemanagementtool.model.CovishieldVaccineModel;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class VaccineCenters {
    @Inject
    CentersConverter centersConverter;

    public List<CovaxinVaccineModel> getCovaxin() {
        return centersConverter.covaxinInformation1();
    }

    public List<CovishieldVaccineModel> getCovishield() {
        return centersConverter.covishieldInformation1();
    }

}
