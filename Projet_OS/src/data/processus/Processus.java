package data.processus;

import java.util.ArrayList;

public class Processus {
	
	/*
	 * This class contains all the operations of a processus in the arrayList
	 * 
	 * @author Nicolas CIBULKA
	 * 
	 */
	
	// --------------------------------------
	// Attributs
	// --------------------------------------
	private ArrayList<Operation> operationlist;
	private int priority;
	private int pid;
	// --------------------------------------
	// Methods
	// --------------------------------------
	
	// this is the constructor of the Processus class
	public Processus() {
		this.operationlist = new ArrayList<Operation>();
	}
	
	// Getters and setters
	public int getPriority() {
		return priority;
	}
	
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	public int getpid() {
		return pid;
	}
	
	public void setpid(int pid) {
		this.pid = pid;	
	}
	
	// Methods
	
	public void addOperation(Operation op) {
		operationlist.add(op);
	}
	
	
		
}
