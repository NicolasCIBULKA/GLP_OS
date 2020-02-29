package data.variable;

public class Intvariable extends Variable {
	/*
	 * This class contain a int for the processus execution
	 * 
	 * @author Nicolas CIBULKA
	 */
	
	// --------------------------------------
	// Attributs
	// --------------------------------------
	private int content;
	
	// --------------------------------------
	// Methods
	// --------------------------------------
	
	// Constructor
	
	public Intvariable(String name, int content) {
		super(name);
		this.content = content;

	}
	
	public Intvariable(int content) {
		super();
		this.content = content;
	}
	
	// getters and setters
	
	public int getContent() {
		return content;
	}

	public void setContent(int content) {
		this.content = content;
	}

	public String toString() {
		return this.getContent() + " " ;
	}
}
