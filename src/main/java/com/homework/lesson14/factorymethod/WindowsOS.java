package com.homework.lesson14.factorymethod;

public class WindowsOS implements OS {
    @Override
    public void getOS() {
        System.out.println("Use for Windows");
    }
}