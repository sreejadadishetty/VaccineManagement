package com.epam.vaccinemanagementtool.servicelayer;


import com.epam.vaccinemanagementtool.daolayer.CovaxinVaccineInterface;
import com.epam.vaccinemanagementtool.daolayer.CovishieldVaccineInterface;
import com.epam.vaccinemanagementtool.entities.CovaxinVaccineEntity;
import com.epam.vaccinemanagementtool.entities.CovishieldVaccineEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookCenterServiceTest {

    @InjectMocks
    BookCenterService bookCenterService;
    @Mock
    CovaxinVaccineInterface covaxinVaccineInterface;
    @Mock
    CovishieldVaccineInterface covishieldVaccineInterface;

    @BeforeEach
    void setUp() {

    }


//    @Test
//    void existingCovaxinCenter() {
//        assertNotNull(centresDAO);
//        when(centresDAO.updateCovaxinCenter(anyString())).thenReturn(true);
//        boolean check = bookCenterService.center("Covaxin","Guntur");
//        verify(centresDAO).updateCovaxinCenter(anyString());
//    }
//
//
//    @Test
//    void nonExistingCovaxinCenter() {
//        assertNotNull(centresDAO);
//        when(centresDAO.updateCovaxinCenter(anyString())).thenReturn(false);
//        boolean check = bookCenterService.center("Covaxin", "tur");
//        assertFalse(check);
//    }
//
//    @Test
//    void nonExistingCovaxinCenter2() {
//        assertFalse(bookCenterService.center("Covaxin","Guntu"));
//    }
//    @Test
//    void existingCovishieldCenter() {
//        assertFalse(bookCenterService.center("Covishield","Guntur"));
//    }
//
//    @Test
//    void nonExistingCovishieldCenter() {
//        assertFalse(bookCenterService.center("Covishield","Guntu"));
//    }

    @Test
    void covaxinCenterTest() {
        BookCenterService bookCenterService = Mockito.spy(BookCenterService.class);
        Mockito.doReturn(true).when(bookCenterService).updateCovaxin("Guntur");
        assertTrue(bookCenterService.center("Covaxin", "Guntur"));
    }

    @Test
    void covishieldCenterTest() {
        BookCenterService bookCenterService = Mockito.spy(BookCenterService.class);
        Mockito.doReturn(true).when(bookCenterService).updateCovishield("Guntur");
        assertTrue(bookCenterService.center("Covishield", "Guntur"));
    }

    @Test
    void updateValidCovaxinCenterTest() {
        CovaxinVaccineEntity covaxinVaccineEntity = new CovaxinVaccineEntity();
        covaxinVaccineEntity.setCount(20);
        covaxinVaccineEntity.setVaccineCenter("Guntur");
        when(covaxinVaccineInterface.findByVaccineCenter(anyString())).thenReturn(covaxinVaccineEntity);
        assertTrue(bookCenterService.updateCovaxin("Guntur"));
    }

    @Test
    void updateCovaxinCenterTest() {
        when(covaxinVaccineInterface.findByVaccineCenter(anyString())).thenReturn(null);
        assertFalse(bookCenterService.updateCovaxin("Guntur"));
    }

    @Test
    void updateCovishieldCenterTest() {
        when(covishieldVaccineInterface.findByVaccineCenter(anyString())).thenReturn(null);
        assertFalse(bookCenterService.updateCovishield("Guntur"));
    }

    @Test
    void updateValidCovishieldCenterTest() {
        CovishieldVaccineEntity covishieldVaccineEntity = new CovishieldVaccineEntity();
        covishieldVaccineEntity.setCount(20);
        covishieldVaccineEntity.setVaccineCenter("Guntur");
        when(covishieldVaccineInterface.findByVaccineCenter(anyString())).thenReturn(covishieldVaccineEntity);
        assertTrue(bookCenterService.updateCovishield("Guntur"));
    }


}