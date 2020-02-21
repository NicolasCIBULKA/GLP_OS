package process.visitor;

import data.arithmeticaloperation.*;
import data.functions.*;
import data.primitive.*;



public interface ArrayListVisitor<T> {
	
	/*
	 * This class allow to visit all primitives and execute later the 
	 * 
	 * operations
	 * 
	 * @author Nicolas CIBULKA
	 */
	
	// Arithmetical operations
	
	T visit(Addition node);
	
	T visit(Substraction node);
	
	T visit(Multiplication node);
	
	// Functions
	
	T visit(Sleep node);
	
	T visit(Print node);
	
	// Primitives
	
	T visit(Exit node);
	
	T visit(Kill node);
	
	T visit(Nice node);
	
	T visit(Pause node);

	T visit(Comparaison node);
	
}
