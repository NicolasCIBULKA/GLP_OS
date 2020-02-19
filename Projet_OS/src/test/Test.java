package test;

import data.drivers.*;
import data.arithmeticaloperation.*;
import data.peripheral.*;

public class Test {

	public static void main(String[] args) {
		// test du clavier
		Interaction per = new Interaction();
		Keyboard kb = new Keyboard("kb_1");
		KeyboardDriver kbd = new KeyboardDriver("kbd_1", per, kb);
		
		System.out.println("----------------------------------------");
		System.out.println("Test du clavier");
		System.out.println("----------------------------------------");
		
		for(int i = 0; i<5 ; i++ ) {
			kb.keyinput("33");
		}
		System.out.println(kb.toString());
				 
		System.out.println(kbd.translate());
		
		// test de l'ecran
		
		System.out.println("----------------------------------------");
		System.out.println("Test de l'ecran");
		System.out.println("----------------------------------------");
		
		Screen sc = new Screen("sc_1");
		ScreenDriver scd = new ScreenDriver("scd_1", per, sc);
		scd.addStringScreen(kbd.translate());
		System.out.println("Screen content:" + scd.toString());
		scd.addStringScreen("ceci est un test");
		System.out.println("Screen content:" + scd.toString());
		
		scd.resetScreen();
		System.out.println("Screen content:" + scd.toString());

		//test de la souris//
		System.out.println("----------------------------------------");
		System.out.println("Test de la souris");
		System.out.println("----------------------------------------");
		
		Interaction permSouris=new Interaction();
		Mouse souris = new Mouse();
		MouseDriver mdriv = new MouseDriver("mouse", permSouris, souris);
		System.out.println(mdriv.clic().toString());
		
		System.out.println("déplacement de la souris vers le bas puis vers la droite");
		mdriv.moveDown();
		System.out.println(mdriv.clic().toString());
		mdriv.moveRight();
		System.out.println(mdriv.clic().toString());
		
		// test des operations
		System.out.println("----------------------------------------");
		System.out.println("Test des operations arithmetiques");
		System.out.println("----------------------------------------");
		
		System.out.println("Test de l'addition");
		Arithmeticaloperation a = new Addition(2, 4);
		
		System.out.println("Test de la soustraction");
		Arithmeticaloperation b = new Substraction(2,4);
		
		System.out.println("Test de la multiplication");
		Arithmeticaloperation c = new Multiplication(2,4);
		
		
	}
}
