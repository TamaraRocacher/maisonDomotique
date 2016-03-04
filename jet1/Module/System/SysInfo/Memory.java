package Module.System.SysInfo;

import com.pi4j.system.SystemInfo;

import java.io.IOException;

/**
 * Display a few of the available memory information properties
 *
 * @author Loïc FORTIN
 * @version 1.0.0
 */

/**
 * The Memory class
 *
 * @since 1.0.0
 */
public class Memory {
    /**
     * Display memory information
     *
     * @since 1.0.0
     */
    public static final void display() {
        try {
            System.out.println("----------------------------------------------------");
            System.out.println("MEMORY INFO");
            System.out.println("----------------------------------------------------");
            System.out.println("Total Memory      :  " + SystemInfo.getMemoryTotal());
            System.out.println("Used Memory       :  " + SystemInfo.getMemoryUsed());
            System.out.println("Free Memory       :  " + SystemInfo.getMemoryFree());
            System.out.println("Shared Memory     :  " + SystemInfo.getMemoryShared());
            System.out.println("Memory Buffers    :  " + SystemInfo.getMemoryBuffers());
            System.out.println("Cached Memory     :  " + SystemInfo.getMemoryCached());
            System.out.println("SDRAM_C Voltage   :  " + SystemInfo.getMemoryVoltageSDRam_C());
            System.out.println("SDRAM_I Voltage   :  " + SystemInfo.getMemoryVoltageSDRam_I());
            System.out.println("SDRAM_P Voltage   :  " + SystemInfo.getMemoryVoltageSDRam_P());
        }
        catch (InterruptedException | IOException ex) {
            System.out.println("Error while trying to display system information :");
            System.out.println(ex.getMessage());
        }
    }
}
