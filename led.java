/**
 * Created by loic on 02/02/2016.
 */

import com.pi4j.io.gpio.GpioController; // Permet de contrôler les GPIO
import com.pi4j.io.gpio.GpioFactory; // Contient les méthodes statiques permettant de créer des instances de GpioController.
import com.pi4j.io.gpio.GpioPinDigitalOutput; // Les sorties sur le GPIO (contrôle sortant des GPIO)
import com.pi4j.io.gpio.PinState; // Permet d'avoir des informations sur l'état du pin
import com.pi4j.io.gpio.RaspiPin; // Les différents pins du Raspeberry
import java.lang.System;
import java.lang.Thread;
import java.lang.InterruptedException;

public class led {
    private final GpioPinDigitalOutput pin; // Permet l'accès en sortie vers le pin.

    public led(int pin) {
        // Pin fixé sur 1 dans le code. Ne tien pas compte de l'argument de fonction

        // Il faudrait vérifier que le pin est bon, mais on va considérer que oui
        this.pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "LedControl", PinState.LOW); // L'accès en écriture au pin pour allumer la led. Par défaut, la led est éteinte.
    }

    /*
    Allume la led
     */
    public void on() {
        //this.pin.setShutdownOptions(true, PinState.HIGH);
        this.pin.high();
    }

    /*
    Eteint la led
     */
    public void off() {
        //this.pin.setShutdownOptions(true, PinState.LOW);
        this.pin.low();
    }

    /*
    Vrai si la led est éteinte, faux sinon.
     */
    public boolean isLow() {
        return this.pin.isLow();
    }

    /*
    Vrai si la led est allumée, faux sinon
     */
    public boolean isHigh() {
        return this.pin.isHigh();
    }

    /*
    Récupère l'état du pin (HIGH ou LOW)
     */
    public boolean getState() {
        return this.pin.getState();
    }

    /*
    Eclairage clignotant de la led

    time int Représente le temps que doit rester la led alllumée
     */
    public void pulse(int time) {
        // Même chose, il faudrait vérifier que les valeurs de time soient correctes.
        this.pin.pulse(time, true);
    }
}

public class ledControl {
    /*
    Programme principal, permet de lancer (théoriquement...) un test de led sur le raspberry.
    Note : un thread est susceptible de lancer un InterruptedException. Il est ignoré ici.
     */
    public static void main(String[] args) throws InterruptedException {
        led ledtest = new led(1);

        // Donne un accès au gpio
        final GpioController gpio = GpioFactory.getInstance();

        ledtest.on();

        System.out.println("LED allumée.");

        Thread.sleep(5000);

        ledtest.off();

        System.out.println("LED éteinte.");

        Thread.sleep(5000);

        System.out.println("LED blink (interval : 1s).");

        ledtest.pulse(1000);

        // Libère les accès GPIO
        gpio.shutdown();
    }
}