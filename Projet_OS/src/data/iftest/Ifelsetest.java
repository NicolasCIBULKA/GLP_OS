package data.iftest;

import data.arithmeticaloperation.Comparaison;
import data.processus.Processus;

public class Ifelsetest extends TestOperation{
	/*
	 * Data class of the if else Operation
	 * 
	 * @author Nicolas CIBULKA
	 */

	// --------------------------------------
	// Attributs
	// --------------------------------------

	// --------------------------------------
	// Methods
	// --------------------------------------
	
	// Constructor of the if else data class
	
	public Ifelsetest(Processus ifproc, Processus elseproc, Comparaison comparaison) {
		super(ifproc, elseproc, comparaison);
	}
	
}
