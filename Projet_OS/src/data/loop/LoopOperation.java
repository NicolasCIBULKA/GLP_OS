package data.loop;

import data.processus.Operation;
import data.processus.Processus;

public abstract class LoopOperation extends Operation{
	
	/*
	 * This is the abstract class of all the loop Operations, such
	 * 
	 * as "while" or "for"
	 * 
	 * @author Nicolas CIBULKA
	 * 
	 */
	
	// --------------------------------------
	// Attributs
	// --------------------------------------
	private Processus proc;
	
	// --------------------------------------
	// Methods
	// --------------------------------------

	// This is the constructors of the LoopOperation 
	public LoopOperation(Processus proc) {
		this.setProcessus(proc);
	}
	
	
	// getters and setters

	public Processus getOperations() {
		return proc;
	}

	public void setProcessus(Processus proc) {
		this.proc = proc;
	}
}
