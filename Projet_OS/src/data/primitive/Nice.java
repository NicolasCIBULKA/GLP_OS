package data.primitive;

import data.processus.Processus;
import process.visitor.ArrayListVisitor;
import process.visitor.OSPrimitiveVisitor;

public class Nice extends Primitive{
	
	// --------------------------------------
	// Attributs
	// --------------------------------------
	private int priority; // between -20 for the highest priority and +19 for the lowest
	// --------------------------------------
	// Methods
	// --------------------------------------
	

	public Nice(Processus processus, int priority) throws IllegalArgumentException {
		super(processus);
		if((priority < -20) || (priority > 19)) {
			throw new IllegalArgumentException();
		}
		else {
			
			this.priority = priority;
		}
	}
	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		if((priority < -20) || (priority > 19)) {
			throw new IllegalArgumentException();
		}
		else {
		this.priority = priority;
		}
	}
	
	// ToString
	public String toString() {
		return "Processus : " + this.getProcessus().getProcessusname() + " -  PID : " + this.getProcessus().getpid() + " has now a prioroty of " + this.getPriority();
	}
	
	// primitive visitor
	
		public <T> T accept(OSPrimitiveVisitor<T> visitor) {
			return visitor.visit(this);
		}

}
