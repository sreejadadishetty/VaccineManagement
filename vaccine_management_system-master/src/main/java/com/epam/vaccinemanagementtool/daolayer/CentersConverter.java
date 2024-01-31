package com.epam.vaccinemanagementtool.daolayer;

import com.epam.vaccinemanagementtool.entities.CovaxinVaccineEntity;
import com.epam.vaccinemanagementtool.entities.CovishieldVaccineEntity;
import com.epam.vaccinemanagementtool.model.CovaxinVaccineModel;
import com.epam.vaccinemanagementtool.model.CovishieldVaccineModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;


@Repository
public class CentersConverter {
    @Inject
    CentresDAO centresDAO;
    @Inject
    CovaxinVaccineInterface covaxinVaccineInterface;
    @Inject
    CovishieldVaccineInterface covishieldVaccineInterface;


    public List<CovaxinVaccineModel> covaxinInformation1() {
        List<CovaxinVaccineModel> model = new ArrayList<>();
        ModelMapper mapper = new ModelMapper();
        covaxinVaccineInterface.flush();
        List<CovaxinVaccineEntity> covaxin = covaxinVaccineInterface.findAll();
        for (int i = 0; i < covaxin.size(); i++) {
            model.add(mapper.map(covaxin.get(i), CovaxinVaccineModel.class));
        }
        return model;
    }

    public List<CovishieldVaccineModel> covishieldInformation1() {
        List<CovishieldVaccineModel> model = new ArrayList<>();
        ModelMapper mapper = new ModelMapper();
        covaxinVaccineInterface.flush();

        List<CovishieldVaccineEntity> covaxin = covishieldVaccineInterface.findAll();
        for (int i = 0; i < covaxin.size(); i++) {
            model.add(mapper.map(covaxin.get(i), CovishieldVaccineModel.class));
        }
        return model;
    }


}
