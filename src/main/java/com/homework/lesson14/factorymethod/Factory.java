package com.homework.lesson14.factorymethod;

public class Factory {
    private static final String windowsOs = "windows";
    private static final String linuxOs = "linux";
    private static final String macOs = "mac";

    public OS getCurrentOS(String inputos) {
        OS os = null;
        if (inputos != null) {
            switch (inputos) {
                case windowsOs:
                    os = new WindowsOS();
                    break;
                case linuxOs:
                    os = new LinuxOS();
                    break;
                case macOs:
                    os = new MacOS();
                    break;
            }
        }
        return os;
    }
}
