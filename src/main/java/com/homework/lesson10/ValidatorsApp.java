package com.homework.lesson10;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorsApp {

    public boolean isPhoneNumber(String number) {
        Pattern pattern = Pattern.compile("^\\\\+?[0-9. ()-]{10,25}$");
        Matcher matcher = pattern.matcher(number);
        return matcher.matches();
    }

    public boolean isEmail(String email) {
        Pattern pattern = Pattern.compile("^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public boolean isDate (String date) {
        Pattern pattern = Pattern.compile("^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$");
        Matcher matcher = pattern.matcher(date);
        return matcher.matches();
    }

    public boolean isIp(String ip) {
        Pattern pattern = Pattern.compile("(([01]?\\\\d\\\\d?|2[0-4]\\\\d|25[0-5])\\\\.){3}([01]?\\\\d\\\\d?|2[0-4]\\\\d|25[0-5])");
        Matcher matcher = pattern.matcher(ip);
        return matcher.matches();
    }

}
