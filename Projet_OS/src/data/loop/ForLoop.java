package data.loop;

import data.processus.Processus;
import data.variable.Intvariable;

public class ForLoop extends LoopOperation{
	/*
	 * @author Nicolas CIBULKA
	 */
	
	private int iternumber;
	private int iterstart;
	private int iterposition;
	private Intvariable variable;
	private boolean needcheck;
	// --------------------------------------
	// Methods
	// --------------------------------------
	
	// Constructor of the ForLoop Class
	public ForLoop(Processus proc, Intvariable variable, int iterstart, int iternumber) {
		super(proc);
		this.setIternumber(iternumber);
		this.setVariable(variable);
		this.setIterposition(iterstart);
		this.setNeedcheck(true);
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
	
	public int getIterposition() {
		return iterposition;
	}

	public void setIterposition(int iterposition) {
		this.iterposition = iterposition;
	}

	public Intvariable getVariable() {
		return variable;
	}

	public void setVariable(Intvariable variable) {
		this.variable = variable;
	}

	
	// toString

	public boolean isNeedcheck() {
		return needcheck;
	}

	public void setNeedcheck(boolean needcheck) {
		this.needcheck = needcheck;
	}

	public String toString() {
		return this.getIterstart() + " / " + this.getIternumber()  ;
	}
}
