package com.epam.vaccinemanagementtool.uilayer;

import com.epam.vaccinemanagementtool.model.CovaxinVaccineModel;
import com.epam.vaccinemanagementtool.model.CovishieldVaccineModel;
import com.epam.vaccinemanagementtool.model.UserModel;
import com.epam.vaccinemanagementtool.servicelayer.BookCenterService;
import com.epam.vaccinemanagementtool.servicelayer.VaccineCenters;
import com.epam.vaccinemanagementtool.util.AppContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;


public class VaccineCenter {
    private static final Logger logger = LogManager.getLogger(AppointmentUi.class);

    BookCenterService bookCenterService = AppContext.getApplicationContext().getBean(BookCenterService.class);

    VaccineCenters centers = AppContext.getApplicationContext().getBean(VaccineCenters.class);
    BufferedReader br = BufferSingleton.getBuffer();
    List<CovaxinVaccineModel> covaxin = centers.getCovaxin();
    List<CovishieldVaccineModel> covishield = centers.getCovishield();
    String center;
    String breaker = "\n=================================\n\n";

    public void centersInformation() {
        logger.info("Available centers for covaxin are: ");
        logger.info("==============COVAXIN==========");
        logger.info("{}", covaxin.toString());

        logger.info("Available centers for covishield are: ");
        logger.info("==============COVISHIELD==========");
        logger.info(covishield.toString());

    }

    public void covaxinInfo() {
        logger.info("==============COVAXIN==========");
        logger.info("{}", covaxin.toString());
        logger.info(breaker);
    }

    public void covishieldInfo() {
        logger.info("==============COVISHIELD==========");
        logger.info("{}", covishield.toString());
        logger.info(breaker);
    }

    public String bookCovaxinCenter(UserModel model) {
        logger.info("Enter a center: ");
        center = getName();
        String name = model.getVaccineName();
        boolean flag = bookCenterService.center(name, center);
        if (flag) {
            logger.info("Successfully registered!");
        } else {
            logger.info("Insufficient vaccines available!");
            bookCovaxinCenter(model);
        }
        return center;
    }

    public String bookCovishieldCenter(UserModel model) {
        logger.info("Enter a center: ");
        center = getName();
        String name = model.getVaccineName();
        boolean flag = bookCenterService.center(name, center);
        if (flag) {
            logger.info("Successfully registered!");
        } else {
            logger.info("Insufficient vaccines available!");
            bookCovishieldCenter(model);
        }
        return center;
    }


    private String getName() {
        String name;
        try {
            name = br.readLine();
        } catch (IOException e) {
            name = getName();
        }
        return name;

    }

}

