package data.peripheral;

public class Screen extends Peripheral{
	/*
	 * This class is the screen of the OS, and will stock all the 
	 * 
	 * past inputs of the Keyboard
	 * 
	 * @Author Nicolas CIBULKA
	 */
	
	// --------------------------------------
	// Attributs
	// --------------------------------------
	private String screencontent; // this will stock the past inputs
	private boolean state; // true if the display is on, false if it's off
	private int luminosity; // An interger between 0 and 100 to set the luminosity
	private String theme; // "white" for the white theme, "black" for the dark one
	// --------------------------------------
	// Methods
	// --------------------------------------
	
	// This is the constructor of the Screen
	public Screen(String peripheralid) {
		super(peripheralid);
		this.setScreencontent("");
		this.setState(false);
		this.setLuminosity(100);
		this.setTheme("white");
	}
	
	
	// Getters and setters
	public String getScreencontent() {
		return screencontent;
	}

	public void setScreencontent(String screencontent) {
		this.screencontent = screencontent;
	}

	public boolean getState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public int getLuminosity() {
		return luminosity;
	}

	public void setLuminosity(int luminosity) {
		this.luminosity = luminosity;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}
	
	// toString
	
	public String toString() {
		return screencontent;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
