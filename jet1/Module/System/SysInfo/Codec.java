package Module.System.SysInfo;

import com.pi4j.system.SystemInfo;

import java.io.IOException;

/**
 * Display a few of the available codec information properties
 *
 * @author Loïc FORTIN
 * @version 1.0.0
 */

/**
 * The Codec class
 *
 * @since 1.0.0
 */
public class Codec {
    /**
     * Display codec information
     *
     * @since 1.0.0
     */
    public static final void display() {
        try {
            System.out.println("----------------------------------------------------");
            System.out.println("CODEC INFO");
            System.out.println("----------------------------------------------------");
            System.out.println("H264 Codec Enabled:  " + SystemInfo.getCodecH264Enabled());
            System.out.println("MPG2 Codec Enabled:  " + SystemInfo.getCodecMPG2Enabled());
            System.out.println("WVC1 Codec Enabled:  " + SystemInfo.getCodecWVC1Enabled());
        }
        catch (InterruptedException | IOException ex) {
            System.out.println("Error while trying to display system information :");
            System.out.println(ex.getMessage());
        }
    }
}
