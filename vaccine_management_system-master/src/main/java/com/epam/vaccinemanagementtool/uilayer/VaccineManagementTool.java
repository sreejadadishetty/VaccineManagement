package com.epam.vaccinemanagementtool.uilayer;


import com.epam.vaccinemanagementtool.util.AppContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;

@Component
public class VaccineManagementTool {
    private static final Logger logger = LogManager.getLogger(VaccineManagementTool.class);
    static BufferedReader br = BufferSingleton.getBuffer();

    static int getChoice() {
        int choice;
        try {
            choice = Integer.parseInt(br.readLine());
        } catch (IOException | NumberFormatException e) {
            choice = getChoice();
        }
        return choice;

    }

    public void mainMethod() {


        boolean flag = true;
        logger.info("----------------Enter to Vaccine Management Portal----------------------\n");
        while (flag) {
            logger.info("Enter your choice\n1.Registration\n2.login\n3.Exit\nPlease Enter your choice : ");
            int option = 0;
            option = getChoice();
            if (option == 1) {
                Registration registration = new Registration();
                registration.getInfo();
            } else if (option == 2) {
                Login login = new Login();
                login.getInfo();
            } else {
                AppContext.closeContext();
                flag = false;
                logger.info("Exiting!!");
            }
        }
    }


}
