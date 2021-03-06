package com.ultimatesoftware.aeon.core.common.helpers;

import java.util.Locale;

/**
 * Detects the type of OS being used.
 */
public final class OsCheck {

    static OSType detectedOS;

    /**
     * Detect the operating system from the os.name System property and cache
     * the result.
     *
     * @return - the operating system detected
     */
    public static OSType getOperatingSystemType() {
        if (detectedOS == null) {
            String os = System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH);
            if ((os.contains("mac") || os.contains("darwin"))) {
                detectedOS = OSType.MAC_OS;
            } else if (os.contains("win")) {
                detectedOS = OSType.WINDOWS;
            } else if (os.contains("nux")) {
                detectedOS = OSType.LINUX;
            } else {
                detectedOS = OSType.OTHER;
            }
        }
        return detectedOS;
    }

    /**
     * Types of Operating Systems.
     */
    public enum OSType {
        WINDOWS, MAC_OS, LINUX, OTHER
    }

    /**
     * Sets the type of OS.
     * @param os The type of OS.
     */
    public static void setDetectedOS(OSType os) {
        OsCheck.detectedOS = os;
    }
}
