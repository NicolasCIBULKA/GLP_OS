package data.primitive;

import data.processus.Processus;
import process.visitor.ArrayListVisitor;
import process.visitor.OSPrimitiveVisitor;

public class Kill extends Primitive {

	
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
	public Kill(Processus processus, String killoption) {
		super(processus);
		this.setKilloption(killoption);
	}
	
	// getters and setters 
	
	public String getKilloption() {
		return killoption;
	}

	public void setKilloption(String killoption) {
		this.killoption = killoption;
	}
	
	
	public <T> T accept(ArrayListVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
	public String toString() {
		return "Processus : " + this.getProcessus().getProcessusname() + " -  PID : " + this.getProcessus().getpid() + " has been stopped";
	}
	
	
	
	// primitive visitor
	
		public <T> T accept(OSPrimitiveVisitor<T> visitor) {
			return visitor.visit(this);
		}
	
}
