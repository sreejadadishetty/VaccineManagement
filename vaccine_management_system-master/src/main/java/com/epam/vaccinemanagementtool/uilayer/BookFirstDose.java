package com.epam.vaccinemanagementtool.uilayer;

import com.epam.vaccinemanagementtool.model.UserModel;
import com.epam.vaccinemanagementtool.servicelayer.BookDoses;
import com.epam.vaccinemanagementtool.util.AppContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;

public class BookFirstDose {

    private static final Logger logger = LogManager.getLogger(BookFirstDose.class);
    VaccineCenter centers = new VaccineCenter();
    BookDoses doses = AppContext.getApplicationContext().getBean(BookDoses.class);

    BookVaccineNameUi bookVaccineNameUi = AppContext.getApplicationContext().getBean(BookVaccineNameUi.class);

    BufferedReader br = BufferSingleton.getBuffer();

    void bookFirstDose(UserModel model) {
        if (model.getFirstDoseDate() == null) {
            logger.info("Enter your dose 1 date(dd/mm/yyyy) :   ");
            String firstDoseDate = getDate();

            LocalDate date = doses.setFirstDose(firstDoseDate);
            while (date == null) {
                logger.info("Enter correct dose 1 date in the formate dd/mm/yyyy :   ");
                firstDoseDate = getDate();
                date = doses.setFirstDose(firstDoseDate);
            }
            model.setFirstDoseDate(date);
            model.setVaccineName(bookVaccineNameUi.setVaccineName());

            if (model.getVaccineName().equalsIgnoreCase("covaxin")) {
                centers.covaxinInfo();
                model.setFirstDoseCenterName(centers.bookCovaxinCenter(model));
            } else {
                centers.covishieldInfo();
                model.setFirstDoseCenterName(centers.bookCovishieldCenter(model));
            }
            doses.updateDates(model);
        } else {
            logger.info("Your 1st Vaccination is completed");
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
