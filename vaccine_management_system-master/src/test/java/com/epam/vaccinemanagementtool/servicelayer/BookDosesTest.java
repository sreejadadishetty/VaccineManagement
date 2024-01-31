package com.epam.vaccinemanagementtool.servicelayer;

import com.epam.vaccinemanagementtool.daolayer.UserConverter;
import com.epam.vaccinemanagementtool.daolayer.UserDAOInterface;
import com.epam.vaccinemanagementtool.model.UserModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class BookDosesTest {
    @Mock
    UserDAOInterface userDAOInterface;
    @Mock
    UserConverter userConverter;
    @InjectMocks
    BookDoses bookDoses;


    /**
     * TODO Date
     * correct date
     * yyyy/mm/dd
     * d/m/yy
     * invalidDate(32/15/2022)
     * invalidMonth(15)
     * invalidDate
     * invalidYear
     * empty
     * using - instead of /
     */
    @Test
    void correctDateFormatte() {
        LocalDate date = bookDoses.setFirstDose("11/11/2021");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        LocalDate acutalDate = LocalDate.parse("11/11/2021", formatter);
        assertEquals(acutalDate, date);
    }

    @Test
    void reverseorder() {
        LocalDate date = bookDoses.setFirstDose("2021/11/11");
        assertEquals(null, date);
    }

    @Test
    void invalidMonth() {
        LocalDate date = bookDoses.setFirstDose("11/111/2021");
        assertEquals(null, date);
    }

    @Test
    void invalidDate() {
        LocalDate date = bookDoses.setFirstDose("111/11/2021");
        assertEquals(null, date);
    }

    @Test
    void invalid() {
        LocalDate date = bookDoses.setFirstDose("");
        assertEquals(null, date);
    }

    @Test
    void validDate2() {
        UserModel model = new UserModel();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        model.setFirstDoseDate(LocalDate.parse("01/12/2021", formatter));
        LocalDate date = bookDoses.setSecondDose("14/02/2022", model);
        assertEquals(LocalDate.parse("14/02/2022", formatter), date);
    }

    @Test
    void invalidDate2() {
        UserModel model = new UserModel();
        LocalDate date = bookDoses.setSecondDose("14/02/2022", model);
        assertEquals(null, date);
    }

//    @Test
//    public void update()
//    {
//        when(userConverter.dtoToEntity(any())).thenReturn(any());
//        bookDoses.updateDates(new UserModel());
//        verify(userDAOInterface,times(1)).save(any());
//    }

}
