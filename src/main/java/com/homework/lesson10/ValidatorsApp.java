package com.homework.lesson10;

public class ValidatorsApp {

    private static final String REGEX_PHONE_NUMBER = "^(380)?[\\d]{9}$";
    private static final String REGEX_EMAIL = "[A-Z0-9._%+-]+@[A-Z0-9-]+.+.[A-Z]{2,4}";
    private static final String REGEX_DATE = "^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$";
    private static final String REGEX_IP = "\\b(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\b";


    public boolean isPhoneNumber(String number) {
        String result = number.replaceAll("[\\D]", "");
        return result.matches(REGEX_PHONE_NUMBER);
    }

    public boolean isEmail(String email) {
        return email.matches(REGEX_EMAIL);
    }

    public boolean isDate(String date) {
        return date.matches(REGEX_DATE);
    }

    public boolean isIp(String ip) {
        return ip.matches(REGEX_IP);
    }
}
