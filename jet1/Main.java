package Pattern.Command;

import App.Global.GPIO;
import Scenario.Day.Day;
import Scenario.Day.Night;

/**
 * Entry point to the application
 *
 * @author Loïc FORTIN
 * @version 1.0.0
 */

/**
 * The Main class
 *
 * @since 1.0.0
 * @// FIXME: 03/03/2016 Create a more interactive and dynamic way to launch/add/enable scenario (json or something else) + uncomment gpio shutdown
 */
public class Main {
    /**
     * Program entry point
     *
     * @since 1.0.0
     */
    public static void main(String[] args) {
        // Create a new command factory used to manage scenario
        CommandFactory scenario_factory = CommandFactory.init();

         // Register scenario
        scenario_factory.add("Day", Day::run);

        // Enable scenario
        scenario_factory.enable("Day");

        // Launch scenario
        scenario_factory.execute("Day");

        // Clear all scenario
        scenario_factory.clear();

        // Shutdown GPIO and close access
        //GPIO.gpio.shutdown();
    }
}