package data.drivers;

import data.peripheral.Keyboard;

public class KeyboardDriver extends Driver{
	/*
	 *  This class is the driver of the Keyboard class, and have to translate the coded input
	 *  
	 * 	of the keyboard to what have been really written
	 * 
	 * @Author Nicolas CIBULKA
	 */
	
	// --------------------------------------
	// Attributs
	// --------------------------------------
	
	private Keyboard keyboard;
	
	// --------------------------------------
	// Methods
	// --------------------------------------
	
	public KeyboardDriver(String driverID, Interaction authorization, Keyboard keyboard) {
		super(driverID, authorization);
		this.keyboard = keyboard;
	}
	
	public String translate() {
		String[] tabinput = keyboard.toString().split(";");
		String translated = "";
		int intascii;
		for(int i = 0; i< tabinput.length; i++) {
			intascii = Integer.parseInt(tabinput[i]);
			translated += Character.toString((char)intascii);
		}
		return translated;
	}
	
	
}
