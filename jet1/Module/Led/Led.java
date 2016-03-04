package Module.Led;

import App.Global.GPIO;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.PinPullResistance;

/**
 * The command used to control a led
 *
 * @author Loïc FORTIN
 * @version 1.0.0
 */

/**
 * The Led class
 *
 * @since 1.0.0
 */
public class Led {
    private final GpioPinDigitalOutput pin; // Permet l'accès en sortie vers le pin.
    private int time;

    /**
     * Create a GPIO controller to controll the led
     *
     * @param pin Pin number where the led is connected to
     * @param name Name of the led (used as en identifier)
     */
    private Led(final Pin pin, final String name) {
        // Output access to the led which is, by default, powered off.
        this.pin = GPIO.gpio.provisionDigitalOutputPin(pin, name, PinState.LOW);

        // Default action when the GPIO access is release.
        this.pin.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);

        // Default pulse time
        time = 1000;
    }

    /**
     * Create a new led
     *
     * @param pin Pin were the led is connected to
     * @param name Name given to the led, used as an identifier
     * @return Led
     */
    public static final Led init(final Pin pin, final String name) {
        return new Led(pin, name);
    }

    /**
     * Switch the led on
     */
    public void on() {
        pin.high();
    }

    /**
     * Switch the led off
     */
    public void off() {
        pin.low();
    }

    /**
     * Inverse the state of the led (ON -> OFF, OFF -> ON)
     */
    public void toggle() {
        pin.toggle();
    }

    /**
     * Check if the led is OFF
     *
     * @return boolean
     */
    public final boolean isLow() {
        return pin.isLow();
    }

    /**s
     * Check if the led is ON
     *
     * @return boolean
     */
    public final boolean isHigh() {
        return pin.isHigh();
    }

    /**
     * Return the state of the led
     *
     * @return PinState
     */
    public final PinState getState() {
        return pin.getState();
    }

    public void setPulseTime(int mtime) {
        time = mtime;
    }

    /**
     * Make the led pulse for x milliseconds. x is set as a parameter
     *
     * @see Led::setPulseTime
     * @// FIXME: 02/03/2016 Check time values to make sure they are valid.
     */
    public void pulse() {
        pin.pulse(time, true);
    }
}
