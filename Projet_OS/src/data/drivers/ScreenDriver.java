package data.drivers;

import data.peripheral.Screen;
import process.visitor.ArrayListVisitor;

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
	private String translatedscreen;
	// --------------------------------------
	// Methods
	// --------------------------------------
	
	// This is the constructor of the ScreenDriver
	public ScreenDriver(String DriverID, Interaction authorization, Screen screen) {
		super(DriverID, authorization);
		this.screen = screen;
		setTranslatedscreen(" ");
	}
	// getters and setters 
	public String getScreencontent() {
		return screen.getScreencontent();
	}

	public void setScreencontent(String screencontent) {
		screen.setScreencontent(screencontent);
	}
	
	public String getTranslatedscreen() {
		return translatedscreen;
	}
	public void setTranslatedscreen(String translatedscreen) {
		this.translatedscreen = translatedscreen;
	}
	// Adding a String in the Screen to be seen by user
	public void addStringScreen(String input) {
		//screen.setScreencontent("\nuser-input: " + screen.getScreencontent() + input);
		screen.setScreencontent(screen.getScreencontent() + ";" + input);
	}
	
	public void resetScreen() {
		this.setScreencontent(" ");
		this.setTranslatedscreen(" ");
	}
	
	public String toString() {
		return this.getScreencontent();
	}
	
	

	public <T> T accept(ArrayListVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
	
}
