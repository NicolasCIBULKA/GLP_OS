package data.processus;

public abstract class Operation {
	/*
	 * This is the abstract class Operation, that allow us to 
	 * 
	 * create all the  different operations by calling only one class to create the arraylist 
	 * 
	 *  of all the different operations
	 *  
	 *  @author Nicolas CIBULKA
	 */
	
	// --------------------------------------
	// Attributs
	// --------------------------------------
	private int operationpriority;
	private int cpuusing; // Number between 1 and 100 that determines the % of CPU that is used to execute the operation
	// --------------------------------------
	// Methods
	// --------------------------------------
	
	public Operation() {
		
	}
	
	// getters and setters

	public int getOperationpriority() {
		return operationpriority;
	}

	public void setOperationpriority(int operationpriority) {
		this.operationpriority = operationpriority;
	}
	
	public int getCpuusing() {
		return cpuusing;
	}

	public void setCpuusing(int cpuusing) {
		this.cpuusing = cpuusing;
	}

	public String toString() {
		return "";
	}
	
}
