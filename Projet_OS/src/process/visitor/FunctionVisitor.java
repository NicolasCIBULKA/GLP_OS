package process.visitor;

import data.arithmeticaloperation.Addition;
import data.arithmeticaloperation.Comparaison;
import data.arithmeticaloperation.Multiplication;
import data.arithmeticaloperation.Substraction;
import data.drivers.ScreenDriver;
import data.functions.Increment;
import data.functions.Print;
import data.functions.Sleep;
import data.primitive.Exit;
import data.primitive.Kill;
import data.primitive.Nice;
import data.primitive.Pause;

public class FunctionVisitor implements ArrayListVisitor<Integer>{


	@Override
	public Integer visit(Addition node) {
		return node.getA().getContent() + node.getB().getContent();
	}

	@Override
	public Integer visit(Substraction node) {
		return node.getA().getContent() - node.getB().getContent();
	}

	@Override
	public Integer visit(Multiplication node) {
		return node.getA().getContent() * node.getB().getContent();
	}

	@Override
	public Integer visit(Sleep node) {
		try {
			Thread.sleep(node.getTime());
			return node.getTime();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public Integer visit(Print node) {
		System.out.println(node.toString());
		return node.toString().length();
	}

	@Override
	public Integer visit(Exit node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer visit(Kill node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer visit(Nice node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer visit(Pause node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer visit(Comparaison node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer visit(Increment node) {
		// TODO Auto-generated method stub
		return null;
	}

}
