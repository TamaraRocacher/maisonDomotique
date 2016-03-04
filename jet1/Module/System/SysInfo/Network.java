package Module.System.SysInfo;

import com.pi4j.system.NetworkInfo;

import java.io.IOException;

/**
 * Display a few of the available network information properties
 *
 * @author Loïc FORTIN
 * @version 1.0.0
 */

/**
 * The Network class
 *
 * @since 1.0.0
 */
public class Network {
    /**
     * Display network information
     *
     * @since 1.0.0
     */
    public static final void display() {
        try {
            System.out.println("----------------------------------------------------");
            System.out.println("NETWORK INFO");
            System.out.println("----------------------------------------------------");

            // display some of the network information
            System.out.println("Hostname          :  " + NetworkInfo.getHostname());
            for (String ipAddress : NetworkInfo.getIPAddresses())
                System.out.println("IP Addresses      :  " + ipAddress);
            for (String fqdn : NetworkInfo.getFQDNs())
                System.out.println("FQDN              :  " + fqdn);
            for (String nameserver : NetworkInfo.getNameservers())
                System.out.println("Nameserver        :  " + nameserver);
        }
        catch (InterruptedException | IOException ex) {
            System.out.println("Error while trying to display system information :");
            System.out.println(ex.getMessage());
        }
    }
}
