package Module.System.SysInfo;

/**
 * Display a all of the available system information properties
 *
 * @author Loïc FORTIN
 * @version 1.0.0
 */

/**
 * The System class
 *
 * @since 1.0.0
 */
public class SysInfo {
    /**
     * Display all available system information
     *
     * @since 1.0.0
     */
    public static final void display() {
        CPU.display();
        Hardware.display();
        Memory.display();
        OS.display();
        Java.display();
        Network.display();
        Codec.display();
        Clock.display();
    }
}
