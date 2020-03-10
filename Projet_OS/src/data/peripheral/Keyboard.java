package data.peripheral;

public class Keyboard extends Peripheral {
	/*
	 * This class will be used as a keyboard in the GUI of the OS
	 */
	
	// --------------------------------------
	// Attributs
	// --------------------------------------
	
	private String content;
	
	
	// --------------------------------------
	// Methods
	// --------------------------------------
	
	/*
	 * This is the constructor from the Keyboard class
	 */
	public Keyboard(String peripheralid) {
		super(peripheralid);
		this.content = "";
	}
	
	/*
	 * This method takes the argument input, that will contains a integer that will be converted later
	 * 
	 *  to a String by the driver by using the ASCII table
	 */
	public void keyinput(String input) {
		// test if the input is in the ASCII table part that will be accessible on the keyboard
		if((Integer.parseInt(input) >= 32) && (Integer.parseInt(input) <= 127)){
			content += input +";";
		}
	}
	
	public void resetContent() {
		content="";
	}
	
	public String toString() {
		return content;
	}
}
