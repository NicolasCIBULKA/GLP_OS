package data.loop;

import data.processus.Processus;
import data.variable.Intvariable;

public class ForLoop extends LoopOperation{
	/*
	 * @author Nicolas CIBULKA
	 */
	
	private int iternumber;
	private int iterstart;
	private Intvariable variable;
	// --------------------------------------
	// Methods
	// --------------------------------------
	
	// Constructor of the ForLoop Class
	public ForLoop(Processus proc, Intvariable variable, int iterstart, int iternumber) {
		super(proc);
		this.setIternumber(iternumber);
		this.setVariable(variable);
	}
	
	// getters and setters

	public int getIternumber() {
		return iternumber;
	}

	public void setIternumber(int iternumber) {
		this.iternumber = iternumber;
	}
	

	public int getIterstart() {
		return iterstart;
	}

	public void setIterstart(int iterstart) {
		this.iterstart = iterstart;
	}
	
	public Intvariable getVariable() {
		return variable;
	}

	public void setVariable(Intvariable variable) {
		this.variable = variable;
	}

	// toString
	
	public String toString() {
		return this.getIterstart() + " / " + this.getIternumber()  ;
	}
}
