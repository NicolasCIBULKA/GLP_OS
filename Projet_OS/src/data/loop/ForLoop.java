package data.loop;

import data.processus.Processus;

public class ForLoop extends LoopOperation{
	/*
	 * @author Nicolas CIBULKA
	 */
	
	private int iternumber;
	private int iterstart;
	// --------------------------------------
	// Methods
	// --------------------------------------
	
	// Constructor of the ForLoop Class
	public ForLoop(Processus proc, int iterstart, int iternumber) {
		super(proc);
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
