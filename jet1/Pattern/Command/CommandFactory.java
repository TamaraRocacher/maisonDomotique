package Pattern.Command;

import App.Config.Env;

import java.util.HashMap;
import java.util.stream.Collectors;

/**
 * The command factory class
 *
 * @author Loïc FORTIN
 * @version 1.0.0
 */

/**
 * The Command factory class
 *
 * @since 1.0.0
 */
public final class CommandFactory {
    /**
     * List of available commands
     */
    private final HashMap<String, ICommand> available_commands;

    /**
     * List of enabled commands
     */
    private final HashMap<String, ICommand> enabled_commands;

    /**
     * Private constructor
     */
    private CommandFactory() {
        available_commands = new HashMap<String, ICommand>();
        enabled_commands = new HashMap<String, ICommand>();
    }

    /**
     * Adds a new command
     *
     * @param name The name of the command
     * @param command
     */
    public void add(String name, ICommand command) {
        available_commands.put(name, command);
        if (Env.verbose)
            System.out.println("[VERBOSE] " + name + " was successfully added from available commands.");
    }

    /**
     * Executes the command if it exists
     *
     * @param name Command name
     */
    public void execute(String name) {
        if (enabled_commands.containsKey(name)) {
            if (Env.verbose)
                System.out.println("[VERBOSE] Loading " + name + "...");
            enabled_commands.get(name).apply();
        }
        else
            if (Env.verbose)
                System.out.println("[VERBOSE] " + name + " not enabled.");
    }

    /**
     * Removes the command from the commands list
     *
     * @param name The name of the command
     */
    public void remove(String name) {
        if (available_commands.containsKey(name)) {
            if (enabled_commands.containsKey(name)) {
                enabled_commands.remove(name);
                if (Env.verbose)
                    System.out.println("[VERBOSE] " + name + " was successfully removed from enabled commands.");
            }

            available_commands.remove(name);
            if (Env.verbose)
                System.out.println("[VERBOSE] " + name + " was successfully removed from available commands.");
        }
        else
            if (Env.verbose)
                System.out.println("[VERBOSE] " + name + " does not exist.");
    }

    /**
     * Removes all available and enabled commands.
     */
    public void clear() {
        enabled_commands.clear();
        if (Env.verbose)
            System.out.println("[VERBOSE] Enabled items were successfully cleared.");

        available_commands.clear();
        if (Env.verbose)
            System.out.println("[VERBOSE] Available items were successfully cleared.");
    }

    /**
     * Generates a list off all available and enabled commands.
     */
    public void list() {
        System.out.println("Available items : " + available_commands.keySet().stream().collect(Collectors.joining(", ")) + ".");
        System.out.println("Enabled items : " + enabled_commands.keySet().stream().collect(Collectors.joining(", ")) + ".");
    }

    /**
     * Enables the command
     *
     * @param name The name of the command
     */
    public void enable(String name) {
        if (available_commands.containsKey(name)) {
            if (!enabled_commands.containsKey(name)) {
                enabled_commands.put(name, available_commands.get(name));
                if (Env.verbose)
                    System.out.println("[VERBOSE] " + name + " was successfully enabled.");
            }
            else
                if (Env.verbose)
                    System.out.println("[VERBOSE] " + name + " already enabled.");
        }
        else
            if (Env.verbose)
                System.out.println("[VERBOSE] " + name + " not available.");
    }

    /**
     * Disables the command
     *
     * @param name The name of the command
     */
    public void disable(String name) {
        if (available_commands.containsKey(name)) {
            if (enabled_commands.containsKey(name)) {
                enabled_commands.remove(name);
                if (Env.verbose)
                    System.out.println("[VERBOSE] " + name + " was successfully disabled.");
            }
            else
                if (Env.verbose)
                    System.out.println("[VERBOSE] " + name + " not enabled.");
        }
        else
            if (Env.verbose)
                System.out.println("[VERBOSE] " + name + " not available.");
    }

    /**
     * Factory Pattern
     *
     * @return CommandFactory
     */
    public static CommandFactory init() {
        return new CommandFactory();
    }
}

