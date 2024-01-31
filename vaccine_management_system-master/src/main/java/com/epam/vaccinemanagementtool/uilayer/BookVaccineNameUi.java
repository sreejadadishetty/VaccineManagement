package com.epam.vaccinemanagementtool.uilayer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;

@Component
public class BookVaccineNameUi {
    private static final Logger logger = LogManager.getLogger(AppointmentUi.class);
    BufferedReader br = BufferSingleton.getBuffer();

    public String setVaccineName() {


        while (true) {
            logger.info("\n1. Covaxin\n2. Covishield");
            String vaccineName;
            vaccineName = getName();
            if (vaccineName.equalsIgnoreCase("covaxin") || vaccineName.equalsIgnoreCase("covishield")) {
                return vaccineName;
            } else {
                logger.info("Enter correct vaccine name(Covaxin/Covishield)");
            }
        }

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
