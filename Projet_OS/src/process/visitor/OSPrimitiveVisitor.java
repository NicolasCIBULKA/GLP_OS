package process.visitor;

import data.primitive.*;

public interface OSPrimitiveVisitor<T> {
	
	/*
	 * This interface contains the differents primitives of the OS primitives
	 * 
	 * @author Nicolas CIBULKA
	 */
	
	T visit(Clear node); 
	
	T visit(Ioctl node);
	
	T visit(Exit node);
	
	T visit(Kill node);

	T visit(Nice node);
	
	T visit(Pause node);
	
	T visit(Read node);
	
	T visit(Write node);
	
	T visit(Delete node);
	
}
