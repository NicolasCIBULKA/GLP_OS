package data.processus;

import java.util.ArrayList;

import process.rrobin.Variablebuffer;

public class Processus {
	
	/*
	 * This class contains all the operations of a processus in the arrayList
	 * 
	 * @Author Nicolas CIBULKA
	 * 
	 */
	
	// --------------------------------------
	// Attributs
	// --------------------------------------
	private ArrayList<Operation> operationlist;
	private int priority;
	private int pid;
	private String processusname;
	private boolean ablerun;
	private boolean exiting;
	private Variablebuffer varbuffer;
	// --------------------------------------
	// Methods
	// --------------------------------------
	
	// this is the constructor of the Processus class
	
	public Processus() {
		this.operationlist = new ArrayList<Operation>();
		this.setAblerun(true);
		this.setExiting(false);
		varbuffer = new Variablebuffer();
	}
	public Processus(String processusname) {
		this.operationlist = new ArrayList<Operation>();
		this.processusname = processusname;
		this.setAblerun(true);
		this.setExiting(false);
		varbuffer = new Variablebuffer();
	}
	
	
	// Getters and setters
	
	public boolean isExiting() {
		return exiting;
	}

	public void setExiting(boolean exiting) {
		this.exiting = exiting;
	}

	public boolean isAblerun() {
		return ablerun;
	}

	public void setAblerun(boolean ablerun) {
		this.ablerun = ablerun;
	}

	public ArrayList<Operation> getOplist() {
		return operationlist;
	}
	
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
	
	public String getProcessusname() {
		return processusname;
	}
	
	public void setProcessusname(String processusname) {
		this.processusname = processusname;
	}
	
	public Variablebuffer getVarbuffer() {
		return varbuffer;
	}
	
	public void setVarbuffer(Variablebuffer varbuffer) {
		this.varbuffer.setIntvariablelist(varbuffer.getIntvariablelist());
		this.varbuffer.setStringvariablelist(varbuffer.getStringvariablelist());
	}

	public int getNboperation() {
		return operationlist.size();
	}
	// Methods
	
	
	public void addOperation(Operation op) {
		operationlist.add(op);
	}
	
	


	
		
}
