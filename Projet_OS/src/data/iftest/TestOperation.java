package data.iftest;

import data.arithmeticaloperation.Comparaison;
import data.processus.Operation;
import data.processus.Processus;

public abstract class TestOperation extends Operation{
	/*
	 * Abstract class of the test Operations
	 * 
	 * @author Nicolas CIBULKA
	 */

	// --------------------------------------
	// Attributs
	// --------------------------------------
	private Processus ifproc;
	private Processus elseproc;
	private Comparaison comparaison;
	// --------------------------------------
	// Methods
	// --------------------------------------
	
	// Constructor of the testOperation class
	
	public TestOperation(Processus ifproc,Processus elseproc, Comparaison comparaison) {
		this.setIfprocessus(ifproc);
		this.setElseprocessus(elseproc);
		this.setComparaison(comparaison);		
	}
	
	//getters and setters

	public Processus getIfprocessus() {
		return ifproc;
	}

	public void setIfprocessus(Processus ifproc) {
		this.ifproc = ifproc;
	}

	public Comparaison getComparaison() {
		return comparaison;
	}

	public void setComparaison(Comparaison comparaison) {
		this.comparaison = comparaison;
	}

	public Processus getElseprocessus() {
		return elseproc;
	}

	public void setElseprocessus(Processus elseproc) {
		this.elseproc = elseproc;
	}
	
}
