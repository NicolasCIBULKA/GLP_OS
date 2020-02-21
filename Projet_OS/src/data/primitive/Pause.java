package data.primitive;

import data.processus.Processus;
import process.visitor.ArrayListVisitor;

public class Pause extends Primitive{
	/*
	 * Data class of the Pause primitive 
	 * 
	 * @author Nicolas CIBULKA
	 */

	// --------------------------------------
	// Attributs
	// --------------------------------------
	private int time;
	// --------------------------------------
	// Methods
	// --------------------------------------
	
	// constructor of the data class Pause
	
	public Pause(Processus processus, int time) {
		super(processus);
		this.setTime(time);
		
	}
	// getters and setters
	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	// toString 
	public String toString() {
		return "Processus : " + this.getProcessus().getProcessusname() + " -  PID : " + this.getProcessus().getpid() + " - has been paused" ;
	}
	
	public <T> T accept(ArrayListVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
}
