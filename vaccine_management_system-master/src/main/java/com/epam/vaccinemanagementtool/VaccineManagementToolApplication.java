package com.epam.vaccinemanagementtool;

import com.epam.vaccinemanagementtool.uilayer.VaccineManagementTool;
import com.epam.vaccinemanagementtool.util.AppContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@ComponentScan(basePackages = "com.epam")
public class VaccineManagementToolApplication {


    public static void main(String[] args) {

        SpringApplication.run(VaccineManagementToolApplication.class, args);
        VaccineManagementTool vaccineManagementTool = AppContext.getApplicationContext().getBean(VaccineManagementTool.class);
        vaccineManagementTool.mainMethod();

    }
}
