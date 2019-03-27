package com.homework.lesson10;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ValidatorsAppTest {
    ValidatorsApp validatorsApp;

    @Before
    public void setUp() {
        validatorsApp = new ValidatorsApp();
    }

    @Test
    public void isPhoneNumber() {
        assertTrue(validatorsApp.isPhoneNumber("380777777777"));
    }

    @Test
    public void isEmail() {
        assertTrue(validatorsApp.isEmail("main@gmail.com"));
    }

    @Test
    public void isDate() {
        assertTrue(validatorsApp.isDate("07.07.2007"));
    }

    @Test
    public void isIp() {
        assertTrue(validatorsApp.isIp("0.0.0.1"));
    }
}