package Module.System.SysInfo;

import com.pi4j.system.SystemInfo;

import java.io.IOException;

/**
 * Display a few of the available hardware information properties
 *
 * @author Loïc FORTIN
 * @version 1.0.0
 */

/**
 * The Hardware class
 *
 * @since 1.0.0
 */
public class Hardware {
    /**
     * Display hardware information
     *
     * @since 1.0.0
     */
    public static final void display() {
        try {
            System.out.println("----------------------------------------------------");
            System.out.println("HARDWARE INFO");
            System.out.println("----------------------------------------------------");
            System.out.println("Processor         :  " + SystemInfo.getProcessor());
            System.out.println("Hardware Revision :  " + SystemInfo.getRevision());
            System.out.println("Is Hard Float ABI :  " + SystemInfo.isHardFloatAbi());
            System.out.println("Board Type        :  " + SystemInfo.getBoardType().name());
        }
        catch (InterruptedException | IOException ex) {
            System.out.println("Error while trying to display system information :");
            System.out.println(ex.getMessage());
        }
    }
}
