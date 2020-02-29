package process.visitor;

import data.arithmeticaloperation.*;
import data.drivers.ScreenDriver;
import data.functions.Increment;
import data.functions.Print;
import data.functions.Sleep;
import data.primitive.Exit;
import data.primitive.Kill;
import data.primitive.Nice;
import data.primitive.Pause;
import data.processus.Processus;
import data.variable.Intvariable;

public class OperationVisitor implements ArrayListVisitor<Void>{
	/*
	 * This class can execute all the arithmetical operations 
	 * 
	 * @author Nicolas CIBULKA
	 */
	
	// Arithmetical Operation
	
	@Override
	public Void visit(Addition node) {
		Intvariable a = node.getA();
		Intvariable b = node.getB();
		int res = a.getContent() + b.getContent();
		node.getResult().setContent(res);
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
	public Void visit(Increment node) {
		Intvariable varincremented = new Intvariable(node.getVar().getName(),node.getVar().getContent() + 1);
		node.setVar(varincremented);
		return null;
	}
	
	

	// Primitives
	
	@Override
	public Void visit(Exit node) {
		node.getProcessus().setExiting(true);
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
			node.getProcessus().setAblerun(false);
		}
		else if(node.getKilloption() == "EXIT") {
			node.getProcessus().setExiting(true);
		}
		else if(node.getKilloption() == "TOP-PRIORITY") {
			node.getProcessus().setPriority(20);
		}
		else if(node.getKilloption() == "BOTTOM-PRIORITY") {
			node.getProcessus().setPriority(1);
		}
		else if(node.getKilloption() == "RUN") {
			node.getProcessus().setAblerun(true);
		}
		
		return null;
	}

	@Override
	public Void visit(Nice node) {
		int newpriority = node.getPriority();
		node.getProcessus().setPriority(newpriority);
		return null;
	}

	@Override
	public Void visit(Pause node) {
		Processus proc = node.getProcessus();
		proc.setAblerun(false);
		return null;
	}
	
	// Comparaison

	@Override
	public Void visit(Comparaison node) {
		// Result is set to 0 if the comparaison is true, -1 for false
		int a = node.getA().getContent();
		int b = node.getB().getContent();
		Intvariable res = new Intvariable("result",0);
		if(node.getComparator().equals("==")){
			if(a == b) {
				res.setContent(0);
			}
			else {
				res.setContent(-1);
			}
		}
		else if(node.getComparator().equals("<")) {
			if(a < b) {
				res.setContent(0);
			}
			else {
				res.setContent(-1);
			}
		}
		else if(node.getComparator().equals(">")) {
			if(a > b) {
				res.setContent(0);
			}
			else {
				res.setContent(-1);
			}
		}
		else if(node.getComparator().equals("<=")) {
			if(a <= b) {
				res.setContent(0);
			}
			else {
				res.setContent(-1);
			}
		}
		else if(node.getComparator().equals(">=")) {
			if(a >= b) {
				res.setContent(0);
			}
			else {
				res.setContent(-1);
			}
		}
		node.setResult(res);
		return null;
	}

	// Functions
	
	@Override
	public Void visit(Print node) {
		// Need to be modified to write on the Screen
		System.out.println(node.print());
		return null;
	}


	
}
