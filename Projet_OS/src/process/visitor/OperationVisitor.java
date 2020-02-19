package process.visitor;

import data.arithmeticaloperation.*;
import data.processus.Exit;
import data.processus.Kill;
import data.processus.Nice;
import data.processus.Pause;
import data.processus.Sleep;
import data.variable.Intvariable;

public class OperationVisitor implements ArrayListVisitor<Void>{
	/*
	 * This class can execute all the arithmetical operations 
	 * 
	 * @author Nicolas CIBULKA
	 */
	
	@Override
	public Void visit(Addition node) {
		Intvariable a = node.getA();
		Intvariable b = node.getB();
		node.getResult().setContent(a.getContent() + b.getContent());
		return null;

	}

	@Override
	public Void visit(Substraction node) {
		Intvariable a = node.getA();
		Intvariable b = node.getB();
		node.getResult().setContent(a.getContent() - b.getContent());
		return null;
	}

	@Override
	public Void visit(Multiplication node) {
		Intvariable a = node.getA();
		Intvariable b = node.getB();
		node.getResult().setContent(a.getContent() * b.getContent());
		return null;
	}

	@Override
	public Void visit(Exit node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(Sleep node) {
		try {
			Thread.sleep(node.getTime());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Void visit(Kill node) {
		if(node.getKilloption() == "PAUSE") {
			
		}
		else if(node.getKilloption() == "RESTART") {
			notify();
		}
		return null;
	}

	@Override
	public Void visit(Nice node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(Pause node) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
