package data.iftest;

import java.util.ArrayList;
import data.loop.LoopOperation;
import data.processus.Operation;

public abstract class TestOperation extends LoopOperation{
	/*
	 * 
	 * 
	 * @author Nicolas CIBULKA
	 * 
	 */

	// --------------------------------------
	// Attributs
	// --------------------------------------
	private ArrayList<Operation> operations;
	
	// --------------------------------------
	// Methods
	// --------------------------------------
	
	// Constructor of the 
	
	public TestOperation(ArrayList<Operation> operations) {
		super(operations);
		
	}

}
