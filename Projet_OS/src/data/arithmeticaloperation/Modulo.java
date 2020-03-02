package data.arithmeticaloperation;

import data.variable.Intvariable;
import process.visitor.ArrayListVisitor;

public class Modulo extends Arithmeticaloperation{

	public Modulo(Intvariable a, Intvariable b, Intvariable result) {
		super(a, b, result);
	}

	@Override
	public <T> T accept(ArrayListVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
	// toString
	
	public String toString() {
		return getA().getContent() + " % " + getB().getContent() + " = " + this.getResult().getContent();
	}


}
