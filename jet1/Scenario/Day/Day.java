package Scenario.Day;

import Module.Led.Led;
import Pattern.Command.CommandFactory;
import Scenario.Scenario;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.system.SystemInfo;

import java.util.ArrayList;

/**
 * Day scenario
 *
 * @author Loïc FORTIN
 * @version 1.0.0
 */

/**
 * Day class
 *
 * @since 1.0.0
 * @// FIXME: 03/03/2016 Create a real scenario with other excluded, in conflict and compatible scenario + uncomment led creation and register commands
 */
public class Day extends Scenario {
    public Day() {
        ArrayList<Scenario> excluded =  new ArrayList<Scenario>();
        ArrayList<Scenario> in_conflict =  new ArrayList<Scenario>();
        ArrayList<Scenario> compatible =  new ArrayList<Scenario>();
    }

    public static final void run() {
        // Create a new scenario
        Day d = new Day();
        d.setName("Day");

        // Create a new command factory used to manage commands
        CommandFactory cf = CommandFactory.init();

        if (App.Config.Env.verbose)
            System.out.println("[VERBOSE] Launching scenario " + d.getName() + ".");

        // Create a new led
        //Led led = Led.init(RaspiPin.GPIO_01, "My LED @ Pin#01");

        if (App.Config.Env.verbose)
            System.out.print("[VERBOSE] Registering commands... ");

        // Register commands
        /*
        cf.add("Switch On", led::on);
        cf.add("Switch Off", led::off);
        cf.add("Toggle", led::toggle);
        cf.add("Pulse", led::pulse);
        */

        cf.add("Switch On", () -> System.out.println("Led switched to ON"));
        cf.add("Switch Off", () -> System.out.println("Led switched to OFF"));
        cf.add("Toggle", () -> System.out.println("Led toggle"));
        cf.add("Pulse", () -> System.out.println("Led switched to pulse"));

        if (App.Config.Env.verbose)
            System.out.print("Done.\n");

        if (App.Config.Env.verbose)
            System.out.print("[VERBOSE] Enabling commands... ");

        // Enable commands
        cf.enable("Switch On");
        cf.enable("Switch Off");
        cf.enable("Toggle");
        cf.enable("Pulse");

        if (App.Config.Env.verbose)
            System.out.print("Done.\n");

        /*
         * Scenario actions should be here.
         * Nevertheless, no access to Raspberry was possible that why simple text message were used.
         */

        if (App.Config.Env.verbose)
            System.out.print("[VERBOSE] Executing scenario... ");

        // Scenario
        try {
            cf.execute("Switch On");

            Thread.sleep(5000);

            cf.execute("Switch Off");

            Thread.sleep(5000);

            cf.execute("Toggle");

            Thread.sleep(5000);

            cf.execute("Pulse");

            Thread.sleep(5000);

            cf.execute("Switch Off");
        }
        catch (InterruptedException ex) {
            System.out.println("Error while trying to sleep the thread :");
            System.out.println(ex.getMessage());
        }

        if (App.Config.Env.verbose)
            System.out.print("Done.\n");

        if (App.Config.Env.verbose)
            System.out.print("[VERBOSE] Clearing commands... ");

        // Clear all commands
        cf.clear();

        if (App.Config.Env.verbose)
            System.out.print("Done.\n");

        if (App.Config.Env.verbose)
            System.out.println("[VERBOSE] Scenario " + d.getName() + " successfully terminated.");
    }
}
