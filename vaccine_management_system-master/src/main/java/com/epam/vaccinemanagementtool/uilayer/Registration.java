package com.epam.vaccinemanagementtool.uilayer;

import com.epam.vaccinemanagementtool.model.UserModel;
import com.epam.vaccinemanagementtool.servicelayer.RegistrationService;
import com.epam.vaccinemanagementtool.util.AppContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;


public class Registration implements Menus {
    private static final Logger logger = LogManager.getLogger(Registration.class);
    BufferedReader br = BufferSingleton.getBuffer();

    RegistrationService service = AppContext.getApplicationContext().getBean(RegistrationService.class);

    @Override
    public void getInfo() {


        logger.info("\nEnter your name :  ");
        String userName = getString();
        while (service.userNameValidation(userName)) {
            logger.debug("Please enter a valid UserName\nEnter your Full name :  ");
            userName = getString();
        }


        logger.info("\nEnter your password :  ");
        String password = getString();
        while (service.userPasswordValidation(password)) {
            logger.debug("Please enter a valid password\nEnter your password :  ");
            password = getString();

        }

        logger.info("\nEnter your age(greater than 15) :  ");
        int age = 0;
        while (true) {
            try {
                age = getNumber();
                while (!service.userAgeValidation(age)) {
                    logger.info("Enter correct age(greater than 15) :");
                    age = getNumber();
                }
            } catch (NumberFormatException e) {
                logger.info("Enter correct age(greater than 15) :");
            }
            break;
        }
        String aadharNumber;
        String message = null;
        do {
            logger.info("\nEnter your Aadhar Number :  ");
            aadharNumber = getString();
            message = service.checkAadhaar(aadharNumber);
            if (message != null) {
                logger.info(message);
            }
        } while (message != null);


        UserModel model = new UserModel();
        model.setUserName(userName);
        model.setPassword(password);
        model.setAadharNumber(aadharNumber);
        model.setAge(age);
        service.register(model);
        logger.info("\nRegistration Successful\n");

    }

    private int getNumber() {
        int choice;
        try {
            choice = Integer.parseInt(br.readLine());
        } catch (IOException | NumberFormatException e) {
            choice = getNumber();
        }
        return choice;
    }

    private String getString() {
        String name;
        try {
            name = br.readLine();
        } catch (IOException e) {
            name = getString();
        }
        return name;
    }
}



