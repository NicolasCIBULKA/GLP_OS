package data.drivers;


public class Interaction {
	/*
	 * This class regulate the reading, writing and executing access
	 * 
	 * @Author Nicolas CIBULKA
	 */

	// --------------------------------------
	// Attributs
	// --------------------------------------
	
	private boolean read;
	private boolean write;
	private boolean command;
	
	// --------------------------------------
	// Methods
	// --------------------------------------
	
	/* They are two contructor, the default one that allow to every access, and one that regulate access 
	 * 
	 */
	
	public Interaction() {
		this.read = true;
		this.write = true;
		this.command = true;
	}
	
	public Interaction(boolean read, boolean write, boolean command) {
		this.read = read;
		this.write = write;
		this.command = command;
	}
	
	// getters and setters
	
	public boolean getreadaccess() {
		return read;
	}
	
	public boolean getwriteaccess() {
		return write;
	}
	
	public boolean getcommandaccess() {
		return command;
	}
	
	public void setreadaccess(boolean read) {
		this.read = read;
	}
	
	public void setwriteaccess(boolean write) {
		this.write = write;
	}
	
	public void setcommandaccess(boolean command) {
		this.command = command;
	}
	
}
