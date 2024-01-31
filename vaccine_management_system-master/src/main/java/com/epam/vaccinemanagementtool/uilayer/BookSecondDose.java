package com.epam.vaccinemanagementtool.uilayer;

import com.epam.vaccinemanagementtool.model.UserModel;
import com.epam.vaccinemanagementtool.servicelayer.BookDoses;
import com.epam.vaccinemanagementtool.util.AppContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;

public class BookSecondDose {

    private static final Logger logger = LogManager.getLogger(BookFirstDose.class);
    VaccineCenter centers = new VaccineCenter();
    BookDoses doses = AppContext.getApplicationContext().getBean(BookDoses.class);

    BufferedReader br = BufferSingleton.getBuffer();

    void bookSecondDose(UserModel model) {
        if (model.getFirstDoseDate() != null && model.getSecondDoseDate() == null) {
            logger.info("Enter your dose 2 date(dd/mm/yyyy) :   ");
            String secondDoseDate = getDate();

            LocalDate date = doses.setSecondDose(secondDoseDate, model);
            if (date != null) {
                model.setSecondDoseDate(date);

                if (model.getVaccineName().equalsIgnoreCase("Covaxin")) {
                    centers.covaxinInfo();
                    model.setSecondDoseCenterName(centers.bookCovaxinCenter(model));
                } else {
                    centers.covishieldInfo();
                    model.setSecondDoseCenterName(centers.bookCovishieldCenter(model));
                }
            } else {
                logger.info("Gap between 1st and 2nd dose should be 45 days at least and date formate should in the formate dd/mm/yyyy");
            }

            doses.updateDates(model);

        } else {
            logger.debug("First book 1st dose or you got vaccinated by 2 doses also");

        }
    }

    private String getDate() {
        String date;
        try {
            date = br.readLine();
        } catch (IOException e) {
            date = getDate();
        }
        return date;

    }


}
