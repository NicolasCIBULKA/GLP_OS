package data.primitive;

import data.processus.Processus;
import process.visitor.ArrayListVisitor;
import process.visitor.OSPrimitiveVisitor;

public class Exit extends Primitive{
	/*
	 * Data class of the Exit primitive 
	 * 
	 * @author Nicolas CIBULKA
	 */

	// --------------------------------------
	// Attributs
	// --------------------------------------


	
	// --------------------------------------
	// Methods
	// --------------------------------------
	
	// Constructor of the data class Exit 
	public Exit(Processus processus) {
		super(processus);
	}
	
	
	// toString 
	public String toString() {
		return "Processus : " + this.getProcessus().getProcessusname() + " -  PID : " + this.getProcessus().getpid() + " - has been stopped" ;
	}
	
	
	// primitive visitor
	
		public <T> T accept(OSPrimitiveVisitor<T> visitor) {
			return visitor.visit(this);
		}
}
