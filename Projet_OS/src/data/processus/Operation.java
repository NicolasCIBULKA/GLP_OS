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
	
	public String toString() {
		return "";
	}
	
}
