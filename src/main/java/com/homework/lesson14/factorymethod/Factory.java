package com.homework.lesson14.factorymethod;

public class Factory {
    private static final String WINDOWS_OS = "windows";
    private static final String LINUX_OS = "linux";
    private static final String MAC_OS = "mac";

    public OS getCurrentOS(String inputos) {
        OS os = null;
        if (inputos != null) {
            switch (inputos) {
                case WINDOWS_OS:
                    os = new WindowsOS();
                    break;
                case LINUX_OS:
                    os = new LinuxOS();
                    break;
                case MAC_OS:
                    os = new MacOS();
                    break;
            }
        }
        return os;
    }
}
