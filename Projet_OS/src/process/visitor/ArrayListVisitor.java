package process.visitor;

import data.arithmeticaloperation.*;
import data.processus.*;

public interface ArrayListVisitor<T> {
	
	/*
	 * This class allow to visit all primitives and execute later the 
	 * 
	 * operations
	 * 
	 * @author Nicolas CIBULKA
	 */
	
	T visit(Addition node);
	
	T visit(Substraction node);
	
	T visit(Multiplication node);
	
	T visit(Exit node);
	
	T visit(Sleep node);
	
	T visit(Kill node);
	
	T visit(Nice node);
	
	T visit(Pause node);

	T visit(Comparaison node);
	
}
