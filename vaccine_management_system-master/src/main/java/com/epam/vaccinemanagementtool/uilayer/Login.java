package com.epam.vaccinemanagementtool.uilayer;

import com.epam.vaccinemanagementtool.model.UserModel;
import com.epam.vaccinemanagementtool.servicelayer.UserLoginService;
import com.epam.vaccinemanagementtool.util.AppContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;


public class Login implements Menus {

    private static final Logger logger = LogManager.getLogger(Login.class);
    BufferedReader br = BufferSingleton.getBuffer();

    VaccineCenter center = new VaccineCenter();

    AppointmentUi appointmentBooking = new AppointmentUi();

    UserLoginService userLoginService = AppContext.getApplicationContext().getBean(UserLoginService.class);

    public void getInfo() {

        logger.info("Enter your Aadhaar Number");
        String aadhaarNumber = getName();
        logger.info("Enter password");
        String password = getName();

        UserModel model = userLoginService.loginValidation(aadhaarNumber, password);
        if (model != null) {
            logger.info("Success!!");
            boolean flag = true;
            int option;
            while (flag) {
                logger.info("\n1. Book Appointment\n2. View Centers Information\n3. User Dashboard\n4. Exit\nPlease Enter your choice : ");
                option = getChoice();
                switch (option) {
                    case 1:
                        appointmentBooking.bookAppointment(model);
                        break;
                    case 2:
                        center.centersInformation();
                        break;
                    case 3:
                        logger.info("{}", model.toString());
                        break;
                    case 4:
                        logger.info("Exiting!!");
                        flag = false;
                        break;
                    default:
                        logger.info("Wrong Input");
                        flag = false;
                        break;
                }
            }
        } else {
            logger.info("Invalid Credentials!!");
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
