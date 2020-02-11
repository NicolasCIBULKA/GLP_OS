package data.processus;

public class Pause extends ProcessusControl{
	/*
	 * Data class of the Pause primitive 
	 * 
	 * @author Nicolas CIBULKA
	 */

	// --------------------------------------
	// Attributs
	// --------------------------------------

	// --------------------------------------
	// Methods
	// --------------------------------------
	
	// constructor of the data class Pause
	
	public Pause(Processus processus) {
		super(processus);
	}
	
	// toString 
	public String toString() {
		return "Processus : " + this.getProcessus().getProcessusname() + " -  PID : " + this.getProcessus().getpid() + " - has been paused" ;
	}
	
}
