package data.loop;

import java.util.ArrayList;

import data.processus.Operation;

public abstract class ForLoop extends LoopOperation{
	/*
	 * @author Nicolas CIBULKA
	 */
	
	private int iternumber;
	private int iterstart;
	// --------------------------------------
	// Methods
	// --------------------------------------
	
	// Constructor of the ForLoop Class
	public ForLoop(ArrayList<Operation> operations, int iternumber, int iterstart) {
		super(operations);
		this.setIternumber(iternumber);
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
	

}
