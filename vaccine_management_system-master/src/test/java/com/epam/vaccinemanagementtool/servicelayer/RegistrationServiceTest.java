package com.epam.vaccinemanagementtool.servicelayer;


import com.epam.vaccinemanagementtool.daolayer.UserConverter;
import com.epam.vaccinemanagementtool.daolayer.UserDAOInterface;
import com.epam.vaccinemanagementtool.model.UserModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RegistrationServiceTest {
    @Mock
    UserDAOInterface userDAOInterface;
    @Mock
    UserConverter userConverter;
    @InjectMocks
    RegistrationService registration;


    /**
     * TODO USERName
     *  abhi -> false
     *  a     -> false
     *  ""    -> true
     *  1     -> true
     */


    @BeforeEach
    void setup() {
        // registration = new RegistrationService();
    }

    @Test
    void testForStringName() {
        assertFalse(registration.userNameValidation("Abhi"));

    }

    @Test
    void testForSingleCharName() {
        assertFalse(registration.userNameValidation("a"));


    }

    @Test
    void testForEmptyName() {
        assertTrue(registration.userNameValidation(""));

    }

    @Test
    void testForNumberName() {
        assertTrue(registration.userNameValidation("1"));

    }

    /**
     * TODOPassword
     * "" -> true
     */
    @Test
    void testForEmptyPassword() {
        assertTrue(registration.userPasswordValidation(""));

    }

    /**
     * TODO age
     *  0  -> false
     *  15 -> true
     *  25 -> true
     *  95 -> true
     *  100 -> false
     */
    @Test
    void testForAge0() {
        assertFalse(registration.userAgeValidation(0));

    }

    @Test
    void testForAge15() {
        assertTrue(registration.userAgeValidation(15));

    }

    @Test
    void testForAge25() {
        assertTrue(registration.userAgeValidation(25));

    }

    @Test
    void testForAge95() {
        assertTrue(registration.userAgeValidation(95));

    }

    @Test
    void testForAge100() {
        assertFalse(registration.userAgeValidation(100));

    }

    @Test
    void wrongAadhaar() {
        String message = registration.checkAadhaar("112233");
        assertEquals("Enter correct aadhaar number!!", message);
    }

    @Test
    void testForNotExistedAadhaar() {
        when(userConverter.getUser(anyString())).thenReturn(null);
        String message = registration.checkAadhaar("112233445566");
        assertEquals(null, message);

    }

    @Test
    void testForExistedAadhaar() {
        UserModel model = new UserModel();
        model.setAadharNumber("112233445566");
        when(userConverter.getUser(anyString())).thenReturn(model);
        String message = registration.checkAadhaar("112233445566");
        assertEquals("Aadhaar number already exists!!", message);

    }


    @Test
    void testRegister() {
        doNothing().when(userConverter).putUser(any());
        registration.register(any());
        verify(userConverter, times(1)).putUser(any());
    }

    @Test
    void testPut() {
        registration.put(any());
        verify(userDAOInterface, times(1)).save(any());
    }


}