package data.drivers;

import data.peripheral.Screen;

public class ScreenDriver extends Driver{
	/*
	 *  This is the driver of the peripheral Screen
	 *  
	 *  @Author Nicolas CIBULKA
	 */
	
	// --------------------------------------
	// Attributs
	// --------------------------------------
	private Screen screen;
	// --------------------------------------
	// Methods
	// --------------------------------------
	
	// This is the constructor of the ScreenDriver
	public ScreenDriver(String DriverID, Interaction authorization, Screen screen) {
		super(DriverID, authorization);
		this.screen = screen;
	}
	// getters and setters 
	public String getScreencontent() {
		return screen.getScreencontent();
	}

	public void setScreencontent(String screencontent) {
		screen.setScreencontent(screencontent);
	}
	
	// Adding a String in the Screen to be seen by user
	public void addStringScreen(String input) {
		//screen.setScreencontent("\nuser-input: " + screen.getScreencontent() + input);
		screen.setScreencontent(screen.getScreencontent() + ";" + input);
	}
	
	public void resetScreen() {
		this.setScreencontent(" ");
	}
	
	public String toString() {
		String[] tabscreen = screen.getScreencontent().split(";");
		String usablescreencontent = "";
		for(int i = 0; i < tabscreen.length; i++) {
			usablescreencontent += tabscreen[i] + "\n";
		}
		return usablescreencontent;
	}
	
	
}
