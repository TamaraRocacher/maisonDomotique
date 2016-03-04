package Module.System.SysInfo;

import com.pi4j.system.SystemInfo;

import java.io.IOException;

/**
 * Display a few of the available clock information properties
 *
 * @author Loïc FORTIN
 * @version 1.0.0
 */

/**
 * The Clock class
 *
 * @since 1.0.0
 */
public class Clock {
    /**
     * Display clock information
     *
     * @since 1.0.0
     */
    public static final void display() {
        try {
            System.out.println("----------------------------------------------------");
            System.out.println("CLOCK INFO");
            System.out.println("----------------------------------------------------");
            System.out.println("ARM Frequency     :  " + SystemInfo.getClockFrequencyArm());
            System.out.println("CORE Frequency    :  " + SystemInfo.getClockFrequencyCore());
            System.out.println("H264 Frequency    :  " + SystemInfo.getClockFrequencyH264());
            System.out.println("ISP Frequency     :  " + SystemInfo.getClockFrequencyISP());
            System.out.println("V3D Frequency     :  " + SystemInfo.getClockFrequencyV3D());
            System.out.println("UART Frequency    :  " + SystemInfo.getClockFrequencyUART());
            System.out.println("PWM Frequency     :  " + SystemInfo.getClockFrequencyPWM());
            System.out.println("EMMC Frequency    :  " + SystemInfo.getClockFrequencyEMMC());
            System.out.println("Pixel Frequency   :  " + SystemInfo.getClockFrequencyPixel());
            System.out.println("VEC Frequency     :  " + SystemInfo.getClockFrequencyVEC());
            System.out.println("HDMI Frequency    :  " + SystemInfo.getClockFrequencyHDMI());
            System.out.println("DPI Frequency     :  " + SystemInfo.getClockFrequencyDPI());
        }
        catch (InterruptedException | IOException ex) {
            System.out.println("Error while trying to display system information :");
            System.out.println(ex.getMessage());
        }
    }
}
