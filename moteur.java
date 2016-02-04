/**
 * Created by tamara on 04/02/2016.
 */


import com.pi4j.component.motor.impl.GpioStepperMotorComponent;
import com.pi4j.component.motor.impl.GpioStepperMotorControl;
import com.pi4j.io.gpio.GpioController; // Permet de contrôler les GPIO
import com.pi4j.io.gpio.GpioFactory; // Contient les méthodes statiques permettant de créer des instances de GpioController.
import com.pi4j.io.gpio.GpioPinDigitalOutput; // Les sorties sur le GPIO (contrôle sortant des GPIO)
import com.pi4j.io.gpio.PinState; // Permet d'avoir des informations sur l'état du pin
import com.pi4j.io.gpio.RaspiPin; // Les différents pins du Raspeberry
import java.lang.System;
import java.lang.Thread;
import java.lang.InterruptedException;

 

public class MotorControl extends GpioStepperMotorControl {

    private boolean open;
    private boolean closed;
    private GpioStepperMotorComponent motor;
   

    public MotorControl(GpioPinDigitalOutput pins[]){
	super(pins);
	open=false;
	closed=true;
	motor= new GpioStepperMotorComponent(pins);
    }
    
  
    public static void main(String[] args) throws InterruptedException {
       
        final GpioController gpio = GpioFactory.getInstance();
	GpioPinDigitalOutput[] pins = new GpioPinDigitalOutput[4];
	
	pins[0] = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "MotorPin1", PinState.HIGH);
	pins[1] = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02, "MotorPin2", PinState.HIGH);
	pins[2] = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03, "MotorPin3", PinState.HIGH);
	pins[3] = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04, "MotorPin4", PinState.HIGH);

	GpioStepperMotorControl controller = new GpioStepperMotorControl(pins);

        System.out.println("Moteur eteint, volets fermés");
	//ouverture des volets s'ils sont fermés
	if(controller.closed)
		controller.ouvrir();
	 System.out.println("Moteur allumé en ouverture");

	While (motor.getSate() != STOP){
		System.out.print(". "); // affiche la progression de l'ouverture et assure d'attendre l'arrêt du moteur
	}
	System.out.println("\nMoteur éteint,volets ouverts");

	//fermeture des volets s'ils sont ouverts
	if(controller.open)
		controller.fermer();
	 System.out.println("Moteur allumé en fermeture");

	While (motor.getSate() != STOP){
		System.out.print(". "); // affiche la progression de la fermeture et assure d'attendre l'arrêt du moteur
	}
	System.out.println("\nMoteur éteint,volets fermés");
        
    }

public void ouvrir(){
	motor.setState(FORWARD);
	controller.run();
	open=true;
	closed=false;
    }

    public boolean fermer(){
	motor.setState(REVERSE);
	controller.run();
	open=false;
	closed=true;
    }
}
