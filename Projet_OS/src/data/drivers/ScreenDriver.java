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
		setTranslatedscreen(">> OS_SIMULATION : \n");
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
		String content;
		content = screen.getScreencontent();
		screen.setScreencontent("");
		screen.setScreencontent(content + ";" + input);
	}
	
	public void resetScreen() {
		this.setScreencontent("");
		this.setTranslatedscreen(">> OS_SIMULATION : \n");
	}
	
	// toString
	
	public String toString() {
		String[] screentab = this.getScreencontent().split(";");
		for(int i = 0; i < screentab.length; i++) {
			this.setTranslatedscreen(this.getTranslatedscreen() + screentab[i]);
		}
		return this.translatedscreen;
	}
	
	
}
