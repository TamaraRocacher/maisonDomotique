package Module.System.SysInfo;

import com.pi4j.system.SystemInfo;

/**
 * Display a few of the available Java information properties
 *
 * @author Loïc FORTIN
 * @version 1.0.0
 */

/**
 * The Java class
 *
 * @since 1.0.0
 */
public class Java {
    /**
     * Display java information
     *
     * @since 1.0.0
     */
    public static final void display() {
        System.out.println("----------------------------------------------------");
        System.out.println("JAVA ENVIRONMENT INFO");
        System.out.println("----------------------------------------------------");
        System.out.println("Java Vendor       :  " + SystemInfo.getJavaVendor());
        System.out.println("Java Vendor URL   :  " + SystemInfo.getJavaVendorUrl());
        System.out.println("Java Version      :  " + SystemInfo.getJavaVersion());
        System.out.println("Java VM           :  " + SystemInfo.getJavaVirtualMachine());
        System.out.println("Java Runtime      :  " + SystemInfo.getJavaRuntime());
    }
}
