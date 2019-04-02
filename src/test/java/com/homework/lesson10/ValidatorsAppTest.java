package com.homework.lesson10;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidatorsAppTest {
    ValidatorsApp validatorsApp;

    @Before
    public void setUp() {
        validatorsApp = new ValidatorsApp();
    }

    @Test
    public void phoneNumberShouldBeValid() {
        assertTrue(validatorsApp.isPhoneNumber("380777777777"));
    }

    @Test
    public void phoneNumberShouldBeInValid() {
        assertFalse(validatorsApp.isPhoneNumber("38**"));
    }

    @Test
    public void emailShouldBeValid() {
        assertTrue(validatorsApp.isEmail("main@gmail.com"));
    }

    @Test
    public void emailShouldBeInValid() {
        assertFalse(validatorsApp.isEmail("---@12/---"));
    }

    @Test
    public void dateShouldBeValid() {
        assertTrue(validatorsApp.isDate("2007.07.07"));
    }

    @Test
    public void dateShouldBeInValid() {
        assertFalse(validatorsApp.isDate("0707.2007"));
    }

    @Test
    public void ipShouldBeValid() {
        assertTrue(validatorsApp.isIp("0.0.0.1"));
    }

    @Test
    public void ipShouldBeInValid() {
        assertFalse(validatorsApp.isIp("256.0.0.1"));
    }
}
