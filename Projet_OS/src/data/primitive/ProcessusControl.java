package data.primitive;

import data.processus.Operation;
import data.processus.Processus;

public abstract class ProcessusControl extends Operation{
	/*
	 * Data class of the Abstract class Processus control, that gives the processus 
	 * 
	 * which will be influenced by the primitive
	 * 
	 * @author Nicolas CIBULKA
	 */

	// --------------------------------------
	// Attributs
	// --------------------------------------
	private Processus processus;
	// --------------------------------------
	// Methods
	// --------------------------------------
	
	// Constructor of the Abstract class ProcessusControl
	public ProcessusControl(Processus processus) {
		this.setProcessus(processus);
	}

	// getters and setters
	
	public Processus getProcessus() {
		return processus;
	}

	public void setProcessus(Processus processus) {
		this.processus = processus;
	}
	

	
}
