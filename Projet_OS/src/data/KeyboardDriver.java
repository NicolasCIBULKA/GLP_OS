package data;

import java.util.HashMap;

public class KeyboardDriver extends Driver{
	/*
	 *  This class is the driver of the Keyboard class, and have to translate the coded input
	 *  
	 * 	of the keyboard to what has been really written
	 */
	
	// --------------------------------------
	// Attributs
	// --------------------------------------
	
	private String input;
	
	// --------------------------------------
	// Methods
	// --------------------------------------
	
	public KeyboardDriver(String driverID, Interaction authorization, HashMap<String, Peripheral> linkperipheral) {
		super(driverID, authorization, linkperipheral);
	}
	
	public String translate(String input) {
		String[] tabinput = input.split(";");
		String translated = "";
		int intascii;
		for(int i = 0; i< tabinput.length; i++) {
			intascii = Integer.parseInt(tabinput[i]);
			translated += Character.toString((char)intascii);
		}
		return translated;
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}
	
}
