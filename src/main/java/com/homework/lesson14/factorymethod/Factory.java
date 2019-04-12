package com.homework.lesson14.factorymethod;

public class Factory {
    public OS getCurrentOS(String inputos) {
        OS os = null;
        if (inputos.equals("windows")) {
            os = new WindowsOS();
        } else if (inputos.equals("linux")) {
            os = new LinuxOS();
        } else if (inputos.equals("mac")) {
            os = new MacOS();
        }
        return os;
    }
}
