package process.visitor;

import data.arithmeticaloperation.*;
import data.functions.Print;
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

	@Override
	public Void visit(Comparaison node) {
		// Result is set to 0 if the comparaison is true, -1 for false
		int a = node.getA().getContent();
		int b = node.getB().getContent();
		Intvariable res = new Intvariable(0);
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
		System.out.println(res.getContent());
		node.setResult(res);
		return null;
	}

	@Override
	public Void visit(Print node) {
		System.out.println(node.print());
		return null;
	}
	
}
