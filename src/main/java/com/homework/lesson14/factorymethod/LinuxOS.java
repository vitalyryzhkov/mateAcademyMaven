package com.homework.lesson14.factorymethod;

class LinuxOS implements OS {
    @Override
    public void getOS() {
        System.out.println("Use for Linux");
    }
}
