package Module.System.SysInfo;

import com.pi4j.system.SystemInfo;

import java.io.IOException;
import java.text.ParseException;

/**
 * Display a few of the available OS information properties
 *
 * @author Loïc FORTIN
 * @version 1.0.0
 */

/**
 * The OS class
 *
 * @since 1.0.0
 */
public class OS {
    /**
     * Display OS information
     *
     * @since 1.0.0
     */
    public static final void display() {
        try {
            System.out.println("----------------------------------------------------");
            System.out.println("OPERATING SYSTEM INFO");
            System.out.println("----------------------------------------------------");
            System.out.println("OS Name           :  " + SystemInfo.getOsName());
            System.out.println("OS Version        :  " + SystemInfo.getOsVersion());
            System.out.println("OS Architecture   :  " + SystemInfo.getOsArch());
            System.out.println("OS Firmware Build :  " + SystemInfo.getOsFirmwareBuild());
            System.out.println("OS Firmware Date  :  " + SystemInfo.getOsFirmwareDate());
        }
        catch (InterruptedException | IOException | ParseException ex) {
            System.out.println("Error while trying to display system information :");
            System.out.println(ex.getMessage());
        }
    }
}
