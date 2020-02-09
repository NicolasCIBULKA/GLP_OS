package data.loop;

import java.util.ArrayList;

import data.processus.Operation;

public class ForLoop extends LoopOperation{
	/*
	 * @author Nicolas CIBULKA
	 */
	
	// --------------------------------------
	// Attributs
	// --------------------------------------
	private ArrayList<Operation> operations;
	private int iternumber;
	// --------------------------------------
	// Methods
	// --------------------------------------
	
	// Constructor of the ForLoop Class
	public ForLoop(ArrayList<Operation> operations, int iternumber) {
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
	
	// Execution of the for loop
	
	public void execute() {
		for(int i = 0; i < this.getIternumber() - 1; i++) {
			this.getOperations().get(i);
		}
	}
}
