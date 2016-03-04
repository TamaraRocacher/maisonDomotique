package Scenario;

import java.util.ArrayList;

/**
 * Abstract class which is used as a base class for all scenario
 *
 * @author Loïc FORTIN
 * @version 1.0.0
 */

/**
 * Scenario base class
 *
 * @since 1.0.0
 */

abstract public class Scenario {
    protected String name;
    protected String desc;
    protected boolean enabled;
    protected ArrayList<Scenario> excluded;
    protected ArrayList<Scenario> in_conflict;
    protected ArrayList<Scenario> compatible;
    /**
     * Sets the name of the scenario
     *
     * @return void
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the name of the scenario
     *
     * @return String
     */
    public final String getName() {
        return name;
    }

    /**
     * Sets the description of the scenario
     *
     * @return void
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * Returns the description of the scenario
     *
     * @return String
     */
    public final String getDesc() {
        return desc;
    }

    /**
     * Enables the scenario
     *
     * @return void
     */
    public void enable() {
        enabled = true;
    }

    /**
     * Disables the scenario
     *
     * @return void
     */
    public void disable() {
        enabled = false;
    }

    /**
     * Returns whether or not the scenario is active
     *
     * @return boolean
     */
    public final boolean isEnabled() {
        return enabled;
    }

    /**
     * Checks whether or not a scenario is exclude (i.e. is in conflict with no solution) with this scenario
     *
     * @return boolean
     */
    public final boolean isExcluded(Scenario sc) {
        return excluded.contains(sc);
    }

    /**
     * Excludes a scenario
     * @return void
     */
    public void exclude(Scenario sc) {
        if (!isExcluded(sc))
            excluded.add(sc);
    }

    /**
     * Removes a scenario which is excluded
     *
     * @return void
     */
    public void removeFromExcluded(Scenario sc) {
        if (isExcluded(sc))
            excluded.remove(sc);
    }

    /**
     * Checks whether a scenario is in conflict (i.e. has a solution) with this scenario
     *
     * @return boolean
     */
    public final boolean isInConflict(Scenario sc) {
        return in_conflict.contains(sc);
    }

    /**
     * Adds a new scenario to the conflict list
     *
     * @return void
     */
    public void addInConflict(Scenario sc) {
        if (!isInConflict(sc))
            in_conflict.add(sc);
    }

    /**
     * Removes a scenario from the conflict list
     *
     * @return void
     */
    public void removeFromConflict(Scenario sc) {
        if (isInConflict(sc))
            in_conflict.remove(sc);
    }

    /**
     * Checks whether a scenario is in conflict (i.e. has a solution) with this scenario
     *
     * @return boolean
     */
    public final boolean isCompatible(Scenario sc) {
        return compatible.contains(sc);
    }

    /**
     * Adds a new scenario to the conflict list
     *
     * @return void
     */
    public void addInCompatible(Scenario sc) {
        if (!isCompatible(sc))
            compatible.add(sc);
    }

    /**
     * Removes a scenario from the conflict list
     *
     * @return void
     */
    public void removeFromCompatible(Scenario sc) {
        if (isCompatible(sc))
            compatible.remove(sc);
    }

    /**
     * Clears the list of excluded scenarios
     *
     * @return void
     */
    public void clearExcluded() {
        excluded.clear();
    }

    /**
     * Clears the list of scenarios in conflict
     *
     * @return void
     */
    public void clearConflict() {
        in_conflict.clear();
    }

    /**
     * Clears the list of scenarios compatible
     *
     * @return void
     */
    public void clearCompatible() {
        compatible.clear();
    }

    /**
     * Clears both excluded and in conflict scenarios
     *
     * @return void
     */
    public void clear() {
        clearExcluded();
        clearConflict();
    }

    /**
     * Runs the scenario
     *
     * @todo Split, rewrite, etc.
     * @return void
     */
    public static void run() {}
}
