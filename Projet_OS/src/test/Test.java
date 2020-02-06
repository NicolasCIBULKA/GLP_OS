package test;

import data.drivers.*;
import data.peripheral.*;
import data.processus.*;
import data.operation.*;

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
		
		// test des operations
		System.out.println("----------------------------------------");
		System.out.println("Test des operations arithmetiques");
		System.out.println("----------------------------------------");
		
		System.out.println("Test de l'addition");
		Operation a = new Addition(2, 4);
		System.out.println(a.calculate());
		
		System.out.println("Test de la soustraction");
		Operation b = new Substraction(2,4);
		System.out.println(b.calculate());
		
		System.out.println("Test de la multiplication");
		Operation c = new Multiplication(2,4);
		System.out.println(c.calculate());
		
	}

}
