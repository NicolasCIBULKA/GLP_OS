package process.rrobin;

import org.apache.log4j.Logger;
import data.arithmeticaloperation.*;
import data.drivers.ScreenDriver;
import data.functions.Decrement;
import data.functions.Increment;
import data.functions.Print;
import data.functions.Sleep;
import data.iftest.Ifelsetest;
import data.loop.*;
import data.primitive.Kill;
import data.processus.Operation;
import data.processus.Processus;
import data.variable.Intvariable;
import data.variable.Stringvariable;
import logs.LoggerUtility;
import process.visitor.*;

public class OperationExec {
	/*
	 * This is the Class that will contain the method that will execute all the operation of a processus
	 *  
	 *  @author Nicolas CIBULKA
	 */
	
	// --------------------------------------
	// Attributs
	// --------------------------------------
	private static Logger logger = LoggerUtility.getLogger(OperationExec.class, "text");
	// --------------------------------------
	// Methods
	// --------------------------------------
	
	// Constructor of the class ProcessusExec
	
	public OperationExec() {
		
	}
	
	// Method that will execute the processus
	
	public void operationexecution(Processus proc, Operation operation, ScreenDriver scdriver) {
		
		// Execution of the arithmeticalOperation
		
		if(operation instanceof Addition ) {
			logger.info("Executed an Addition in Processus : " + proc.getProcessusname());
			Addition additionner = (Addition) operation;
			ArrayListVisitor<Void> visitor = new OperationVisitor();
			visitor.visit(additionner);
			Intvariable result = additionner.getResult();
			proc.getVarbuffer().getIntvariablelist().get(result.getName()).setContent(result.getContent());
			proc.setAlreadydoneoperation(proc.getAlreadydoneoperation() + 1);
		}
		else if(operation instanceof Substraction ) {
			logger.info("Executed a Substraction in Processus : " + proc.getProcessusname());
			Substraction subber = (Substraction) operation;
			ArrayListVisitor<Void> visitor = new OperationVisitor();
			visitor.visit(subber);
			Intvariable result = subber.getResult();
			proc.getVarbuffer().getIntvariablelist().get(result.getName()).setContent(result.getContent());
			proc.setAlreadydoneoperation(proc.getAlreadydoneoperation() + 1);
		}
		else if(operation instanceof Multiplication ) {
			logger.info("Executed an Multiplication in Processus : " + proc.getProcessusname());
			Multiplication multiplier = (Multiplication) operation;
			ArrayListVisitor<Void> visitor = new OperationVisitor();
			visitor.visit(multiplier);
			Intvariable result = multiplier.getResult();
			proc.getVarbuffer().getIntvariablelist().get(result.getName()).setContent(result.getContent());
			proc.setAlreadydoneoperation(proc.getAlreadydoneoperation() + 1);
		}
		
		else if(operation instanceof Division ) {
			logger.info("Executed an Division in Processus : " + proc.getProcessusname());
			Division divider = (Division) operation;
			ArrayListVisitor<Void> visitor = new OperationVisitor();
			visitor.visit(divider);
			Intvariable result = divider.getResult();
			proc.getVarbuffer().getIntvariablelist().get(result.getName()).setContent(result.getContent());
			proc.setAlreadydoneoperation(proc.getAlreadydoneoperation() + 1);
		}
		else if(operation instanceof Modulo ) {
			logger.info("Executed a Modulo in Processus : " + proc.getProcessusname());
			Modulo modulo = (Modulo) operation;
			ArrayListVisitor<Void> visitor = new OperationVisitor();
			visitor.visit(modulo);
			Intvariable result = modulo.getResult();
			proc.getVarbuffer().getIntvariablelist().get(result.getName()).setContent(result.getContent());
			proc.setAlreadydoneoperation(proc.getAlreadydoneoperation() + 1);
		}
		else if(operation instanceof Increment ) {
			logger.info("Executed an Increment in Processus : " + proc.getProcessusname());
			ArrayListVisitor<Void> visitor = new OperationVisitor();
			Increment incrementer = (Increment) operation;
			visitor.visit(incrementer);
			Intvariable result = incrementer.getVar();
			proc.getVarbuffer().getIntvariablelist().get(result.getName()).setContent(result.getContent());
			proc.setAlreadydoneoperation(proc.getAlreadydoneoperation() + 1);
		}
		else if(operation instanceof Decrement ) {
			logger.info("Executed an Decrement in Processus : " + proc.getProcessusname());
			ArrayListVisitor<Void> visitor = new OperationVisitor();
			Decrement decrementer = (Decrement) operation;
			visitor.visit(decrementer);
			Intvariable result = decrementer.getVar();
			proc.getVarbuffer().getIntvariablelist().get(result.getName()).setContent(result.getContent());
			proc.setAlreadydoneoperation(proc.getAlreadydoneoperation() + 1);
		}
		
		// Execution of sleep
		else if(operation instanceof Sleep ) {
			logger.info("Executed an Sleep in Processus : " + proc.getProcessusname());
			ArrayListVisitor<Void> visitor = new OperationVisitor();
			visitor.visit((Sleep) operation);
			proc.setAlreadydoneoperation(proc.getAlreadydoneoperation() + 1);
		}
		
		// Execution of print
		else if(operation instanceof Print) {
			logger.info("Executed a Print in Processus : " + proc.getProcessusname());
			//ArrayListVisitor<Void> visitor = new OperationVisitor();
			Print printer = (Print) operation;
			if(printer.getPrintop() instanceof Intvariable) {
				Intvariable var = proc.getVarbuffer().getIntvariablelist().get(printer.getPrintop().getName());
				scdriver.dynamicScreenadd(proc.getProcessusname()+" >> " + var.toString() + "\n");
			}
			else if(printer.getPrintop() instanceof Stringvariable) {
				logger.info("Created a Stringvariable in Processus : " + proc.getProcessusname());
				Stringvariable var = proc.getVarbuffer().getStringvariablelist().get(printer.getPrintop().getName());
				scdriver.dynamicScreenadd(proc.getProcessusname()+" >> "+var.toString() + "\n");
			}
			//visitor.visit(printer);
			proc.setAlreadydoneoperation(proc.getAlreadydoneoperation() + 1);
		}
		// skip if we are in instance of a variable
		else if(operation instanceof Stringvariable ||operation instanceof Intvariable  ) {
			proc.setAlreadydoneoperation(proc.getAlreadydoneoperation() + 1);
		}
		// Execution of loops and tests
		
		// Execution of for loop
		else if(operation instanceof ForLoop ) {
			logger.info("Execution of a ForLoop in Processus : " + proc.getProcessusname());
			ForLoop floop = (ForLoop) operation;
			String pname = proc.getProcessusname();
			floop.getOperations().setProcessusname(pname);
			int doneop = proc.getAlreadydoneoperation();
			// Test if we have to check the condition
			if(floop.isNeedcheck()) {
				if(floop.getIterposition() < floop.getIternumber()) {
					int iterpos = floop.getIterposition();
					floop.setIterposition( iterpos + 1);
					proc.getVarbuffer().getIntvariablelist().get(floop.getVariable().getName()).setContent(floop.getVariable().getContent() + 1);
					floop.setNeedcheck(false);
				}
				else {
					proc.setAlreadydoneoperation(doneop + 1);
				}
			}
			// If the condition has already been checked, execute the serie of instruction
			else {
				int currentop = floop.getOperations().getAlreadydoneoperation();
				// Checking if we are at the end of the instrution list
				if(currentop < floop.getOperations().getNboperation()) {
					floop.getOperations().setVarbuffer( proc.getVarbuffer());
					this.operationexecution(floop.getOperations(), floop.getOperations().getOplist().get(currentop), scdriver);
					proc.setVarbuffer(floop.getOperations().getVarbuffer());
					floop.getOperations().setAlreadydoneoperation(currentop + 1);
				}
				else {
					proc.setVarbuffer(floop.getOperations().getVarbuffer());
					floop.getOperations().setAlreadydoneoperation(0);
					floop.setNeedcheck(true);
				}
			}
		}
		
		// execution of While
		
		else if(operation instanceof WhileLoop ) {
			logger.info("Execution of a Whileloop in Processus : " + proc.getProcessusname());
			WhileLoop whloop = (WhileLoop) operation;
			String pname = proc.getProcessusname();
			whloop.getOperations().setProcessusname(pname);
			whloop.getOperations().setVarbuffer( proc.getVarbuffer());
			if(whloop.isNeedcheck() == true) {
				Comparaison comp = whloop.getComparaison();
				ArrayListVisitor<Void> visitor = new OperationVisitor();
				visitor.visit(comp);
				if(comp.getResult().getContent() == 0) {
					whloop.setNeedcheck(false);
				}
				else {
					proc.setAlreadydoneoperation(proc.getAlreadydoneoperation() + 1);
				}
			}
			else {
				int currentop = whloop.getOperations().getAlreadydoneoperation();
				if(whloop.getOperations().getAlreadydoneoperation() < whloop.getOperations().getNboperation()) {
					whloop.getOperations().setVarbuffer( proc.getVarbuffer());
					operationexecution(whloop.getOperations(), whloop.getOperations().getOplist().get(currentop), scdriver);
					proc.setVarbuffer(whloop.getOperations().getVarbuffer());
					whloop.getOperations().setAlreadydoneoperation(currentop + 1);
				}
				else {
					proc.setVarbuffer(whloop.getOperations().getVarbuffer());
					whloop.setNeedcheck(true);
					whloop.getOperations().setAlreadydoneoperation(0);
				}
			}
			
		}
			
		// Execution of if else
		
		else if(operation instanceof Ifelsetest ) {
			logger.info("Executing an Ifelse test in Processus : " + proc.getProcessusname());
			Ifelsetest test = (Ifelsetest) operation;
			String pname = proc.getProcessusname();
			test.getIfprocessus().setProcessusname(pname);
			test.getElseprocessus().setProcessusname(pname);
			// System.out.println(test.isNeedcheck());
			if(test.isNeedcheck() == true) {
				Comparaison comp = test.getComparaison();
				ArrayListVisitor<Void> visitor = new OperationVisitor();
				visitor.visit(comp);
				test.setComparaison(comp);
				test.setNeedcheck(false);
				int res = test.getComparaison().getResult().getContent();
				if(res == 0 && test.getIfprocessus().getAlreadydoneoperation() < test.getIfprocessus().getNboperation()) {
					int currentop = test.getIfprocessus().getAlreadydoneoperation();
					test.getIfprocessus().setVarbuffer( proc.getVarbuffer());
					this.operationexecution(test.getIfprocessus(), test.getIfprocessus().getOplist().get(currentop), scdriver);
					proc.setVarbuffer(test.getIfprocessus().getVarbuffer());
					test.getIfprocessus().setAlreadydoneoperation(currentop + 1);
				}
				else if (res == -1 && test.getElseprocessus().getAlreadydoneoperation() < test.getElseprocessus().getNboperation()){
					int currentop = test.getElseprocessus().getAlreadydoneoperation();
					test.getElseprocessus().setVarbuffer( proc.getVarbuffer());
					this.operationexecution(test.getElseprocessus(), test.getElseprocessus().getOplist().get(currentop), scdriver);
					proc.setVarbuffer(test.getElseprocessus().getVarbuffer());
					test.getElseprocessus().setAlreadydoneoperation(currentop + 1);
				}
				else {
					test.getIfprocessus().setAlreadydoneoperation(0);
					test.getElseprocessus().setAlreadydoneoperation(0);
					test.setNeedcheck(true);
					proc.setAlreadydoneoperation(proc.getAlreadydoneoperation() + 1);
				}
			}
			//else {
				int res = test.getComparaison().getResult().getContent();
				if(res == 0 && test.getIfprocessus().getAlreadydoneoperation() < test.getIfprocessus().getNboperation()) {
					int currentop = test.getIfprocessus().getAlreadydoneoperation();
					test.getIfprocessus().setVarbuffer( proc.getVarbuffer());
					this.operationexecution(test.getIfprocessus(), test.getIfprocessus().getOplist().get(currentop), scdriver);
					proc.setVarbuffer(test.getIfprocessus().getVarbuffer());
					test.getIfprocessus().setAlreadydoneoperation(currentop + 1);
				}
				else if (res == -1 && test.getElseprocessus().getAlreadydoneoperation() < test.getElseprocessus().getNboperation()){
					int currentop = test.getElseprocessus().getAlreadydoneoperation();
					test.getElseprocessus().setVarbuffer( proc.getVarbuffer());
					this.operationexecution(test.getElseprocessus(), test.getElseprocessus().getOplist().get(currentop), scdriver);
					proc.setVarbuffer(test.getElseprocessus().getVarbuffer());
					test.getElseprocessus().setAlreadydoneoperation(currentop + 1);
				}
				else {
					test.getIfprocessus().setAlreadydoneoperation(0);
					test.getElseprocessus().setAlreadydoneoperation(0);
					test.setNeedcheck(true);
					proc.setAlreadydoneoperation(proc.getAlreadydoneoperation() + 1);
				}
			//}
		}
		/*
		else if(operation == null) {
			
		}
		*/
	}
}
