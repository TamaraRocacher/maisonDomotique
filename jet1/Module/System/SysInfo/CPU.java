package Module.System.SysInfo;

import com.pi4j.system.SystemInfo;

import java.io.IOException;

/**
 * Display a few of the available CPU information properties
 *
 * @author Loïc FORTIN
 * @version 1.0.0
 */

/**
 * The CPU class
 *
 * @since 1.0.0
 */
public final class CPU {
    /**
     * Display CPU information
     *
     * @since 1.0.0
     */
    public static final void display() {
        try {
            System.out.println("----------------------------------------------------");
            System.out.println("CPU INFO");
            System.out.println("----------------------------------------------------");
            System.out.println("Processor         :  " + SystemInfo.getProcessor());
            System.out.println("Serial Number     :  " + SystemInfo.getSerial());
            System.out.println("CPU Model Name    :  " + SystemInfo.getModelName());
            System.out.println("CPU Revision      :  " + SystemInfo.getCpuRevision());
            System.out.println("CPU Architecture  :  " + SystemInfo.getCpuArchitecture());
            System.out.println("CPU Part          :  " + SystemInfo.getCpuPart());
            System.out.println("CPU Temperature   :  " + SystemInfo.getCpuTemperature());
            System.out.println("CPU Core Voltage  :  " + SystemInfo.getCpuVoltage());
            System.out.println("CPU Features      :  " + SystemInfo.getCpuFeatures());
        }
        catch (InterruptedException | IOException ex) {
            System.out.println("Error while trying to display system information :");
            System.out.println(ex.getMessage());
        }
    }
}
