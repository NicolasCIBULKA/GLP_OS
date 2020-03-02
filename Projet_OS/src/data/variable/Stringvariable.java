package data.variable;

public class Stringvariable extends Variable {
	/*
	 * This class contain a String for the processus execution
	 * 
	 * @author Nicolas CIBULKA
	 */
	
	// --------------------------------------
	// Attributs
	// --------------------------------------
	private String content;
	private String name;
	// --------------------------------------
	// Methods
	// --------------------------------------
	
	// Constructor
	
	public Stringvariable(String name, String content) {
		super(name);
		this.content = content;
	}
	
	// getters and setters
	
	public Stringvariable(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return this.getContent() ;
	}
}
