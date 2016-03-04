package App.Global;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;

/**
 * The GPIO controller class
 *
 * @author Loïc FORTIN
 * @version 1.0.0
 */

/**
 * The GPIO controller class creator
 *
 * @since 1.0.0
 */
public final class GPIO {
    // Creates a gpio controller instance that is shared across the project
    public static final GpioController gpio = GpioFactory.getInstance();
}
