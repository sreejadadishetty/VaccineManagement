package com.epam.vaccinemanagementtool.uilayer;


import com.epam.vaccinemanagementtool.model.UserModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;

public class AppointmentUi {

    private static final Logger logger = LogManager.getLogger(AppointmentUi.class);
    BufferedReader br = BufferSingleton.getBuffer();

    BookFirstDose setFirstDose = new BookFirstDose();

    BookSecondDose secondDose = new BookSecondDose();

    public void bookAppointment(UserModel model) {
        boolean flag = true;
        int option;
        while (flag) {
            logger.info("\n1. Book 1st dose\n2. Book 2nd dose\n3. Exit\nPlease Enter your choice: ");
            option = getChoice();
            switch (option) {
                case 1:
                    setFirstDose.bookFirstDose(model);
                    break;
                case 2:
                    secondDose.bookSecondDose(model);
                    break;
                default:
                    flag = false;
                    logger.info("Exiting!!");
                    break;
            }
        }
    }

    private int getChoice() {
        int choice;
        try {
            choice = Integer.parseInt(br.readLine());
        } catch (IOException | NumberFormatException e) {
            choice = getChoice();
        }
        return choice;
    }

}
