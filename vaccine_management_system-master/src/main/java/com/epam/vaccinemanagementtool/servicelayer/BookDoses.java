package com.epam.vaccinemanagementtool.servicelayer;

import com.epam.vaccinemanagementtool.daolayer.UserConverter;
import com.epam.vaccinemanagementtool.daolayer.UserDAOInterface;
import com.epam.vaccinemanagementtool.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import static java.time.temporal.ChronoUnit.DAYS;

@Service
public class BookDoses {

    @Autowired
    UserDAOInterface userDAOInterface;
    @Autowired
    UserConverter converter;

    public LocalDate setFirstDose(String firstDoseDate) {
        DateTimeFormatter formatter;
        LocalDate date;
        try {
            formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
            date = LocalDate.parse(firstDoseDate, formatter);
        } catch (DateTimeParseException exception) {
            date = null;
        }

        return date;
    }

    public LocalDate setSecondDose(String secondDoseDate, UserModel model) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        LocalDate secondDose = null;
        try {
            long diffInDays = DAYS.between(model.getFirstDoseDate(), LocalDate.parse(secondDoseDate, formatter));
            if (diffInDays > 45) {
                secondDose = LocalDate.parse(secondDoseDate, formatter);
            }
        } catch (Exception e) {
            secondDose = null;
        }
        return secondDose;
    }

    public void updateDates(UserModel model) {
        userDAOInterface.save(converter.dtoToEntity(model));
    }
}
