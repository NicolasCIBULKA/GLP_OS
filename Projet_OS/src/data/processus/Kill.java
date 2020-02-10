package data.processus;



public class Kill extends Operation {

	
	/*
	 * This class is the data class of the kill operation
	 * 
	 * @Author Nicolas CIBULKA
	 * 
	 */
	
	// --------------------------------------
	// Attributs
	// --------------------------------------
	private String killoption;
	
	// --------------------------------------
	// Methods
	// --------------------------------------
	
	// Constructor of the Kill Operation
	public Kill(String killoption) {
		this.setKilloption(killoption);
	}
	
	// getters and setters 
	
	public String getKilloption() {
		return killoption;
	}

	public void setKilloption(String killoption) {
		this.killoption = killoption;
	}
	
}
