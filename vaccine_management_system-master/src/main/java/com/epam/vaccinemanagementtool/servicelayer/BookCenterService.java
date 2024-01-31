package com.epam.vaccinemanagementtool.servicelayer;

import com.epam.vaccinemanagementtool.daolayer.CovaxinVaccineInterface;
import com.epam.vaccinemanagementtool.daolayer.CovishieldVaccineInterface;
import com.epam.vaccinemanagementtool.entities.CovaxinVaccineEntity;
import com.epam.vaccinemanagementtool.entities.CovishieldVaccineEntity;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class BookCenterService {

    @Inject
    CovaxinVaccineInterface covaxinVaccineInterface;
    @Inject
    CovishieldVaccineInterface covishieldVaccineInterface;

    public boolean center(String vaccineName, String center) {
        boolean flag = false;

        if (vaccineName.equalsIgnoreCase("Covaxin")) {
            flag = updateCovaxin(center);

        }
        if (vaccineName.equalsIgnoreCase("Covishield")) {
            flag = updateCovishield(center);
        }
        return flag;
    }

    public boolean updateCovaxin(String centerName) {
        boolean flag = false;

        CovaxinVaccineEntity model = covaxinVaccineInterface.findByVaccineCenter(centerName);
        if (model != null && model.getCount() > 0) {
            model.setCount(model.getCount() - 1);
            covaxinVaccineInterface.save(model);
            flag = true;
        }
        return flag;
    }

    public boolean updateCovishield(String centerName) {
        boolean flag = false;
        CovishieldVaccineEntity model = covishieldVaccineInterface.findByVaccineCenter(centerName);
        if (model != null && model.getCount() > 0) {
            model.setCount(model.getCount() - 1);
            covishieldVaccineInterface.save(model);
            flag = true;
        }
        return flag;
    }

}
