package process.rrobin;

import data.arithmeticaloperation.*;
import data.drivers.ScreenDriver;
import data.functions.Decrement;
import data.functions.Increment;
import data.functions.Print;
import data.functions.Sleep;
import data.iftest.Ifelsetest;
import data.loop.*;
import data.primitive.Kill;
import data.processus.Processus;
import data.variable.Intvariable;
import data.variable.Stringvariable;
import process.visitor.*;

public class ProcessusExec {
	/*
	 * This is the Class that will contain the method that will execute all the operation of a processus
	 *  
	 *  @author Nicolas CIBULKA
	 */
	
	// --------------------------------------
	// Attributs
	// --------------------------------------
	private ScreenDriver scdriver;
	// --------------------------------------
	// Methods
	// --------------------------------------
	
	// Constructor of the class ProcessusExec
	
	public ProcessusExec(ScreenDriver scdriver) {
		this.scdriver = scdriver;
	}
	
	// Method that will execute the processus
	
	public void execution(Processus proc) {
		if(proc.isAblerun() == true) {
			int i = 0;
			try {
				while( i < proc.getNboperation()){
					// Test of if the programm isn't forced to shutdown
					if(proc.isExiting() == false) {
						// if a shutdown primitive haven't been called, look if the program haven't been paused
						// If not, execute the operation 
						
						// Execution of the arithmeticalOperation
						if(proc.getOplist().get(i) instanceof Addition ) {
							Addition additionner = (Addition) proc.getOplist().get(i);
							ArrayListVisitor<Void> visitor = new OperationVisitor();
							visitor.visit(additionner);
							Intvariable result = additionner.getResult();
							proc.getVarbuffer().getIntvariablelist().get(result.getName()).setContent(result.getContent());
						}
						else if(proc.getOplist().get(i) instanceof Substraction ) {
							Substraction subber = (Substraction) proc.getOplist().get(i);
							ArrayListVisitor<Void> visitor = new OperationVisitor();
							visitor.visit(subber);
							Intvariable result = subber.getResult();
							proc.getVarbuffer().getIntvariablelist().get(result.getName()).setContent(result.getContent());
						}
						else if(proc.getOplist().get(i) instanceof Multiplication ) {
							Multiplication multiplier = (Multiplication) proc.getOplist().get(i);
							ArrayListVisitor<Void> visitor = new OperationVisitor();
							visitor.visit(multiplier);
							Intvariable result = multiplier.getResult();
							proc.getVarbuffer().getIntvariablelist().get(result.getName()).setContent(result.getContent());
						}
						
						else if(proc.getOplist().get(i) instanceof Division ) {
							Division divider = (Division) proc.getOplist().get(i);
							ArrayListVisitor<Void> visitor = new OperationVisitor();
							visitor.visit(divider);
							Intvariable result = divider.getResult();
							proc.getVarbuffer().getIntvariablelist().get(result.getName()).setContent(result.getContent());
						}
						else if(proc.getOplist().get(i) instanceof Modulo ) {
							Modulo modulo = (Modulo) proc.getOplist().get(i);
							ArrayListVisitor<Void> visitor = new OperationVisitor();
							visitor.visit(modulo);
							Intvariable result = modulo.getResult();
							proc.getVarbuffer().getIntvariablelist().get(result.getName()).setContent(result.getContent());
						}
						else if(proc.getOplist().get(i) instanceof Increment ) {
							ArrayListVisitor<Void> visitor = new OperationVisitor();
							Increment incrementer = (Increment) proc.getOplist().get(i);
							visitor.visit(incrementer);
							Intvariable result = incrementer.getVar();
							proc.getVarbuffer().getIntvariablelist().get(result.getName()).setContent(result.getContent());
						}
						else if(proc.getOplist().get(i) instanceof Decrement ) {
							ArrayListVisitor<Void> visitor = new OperationVisitor();
							Decrement decrementer = (Decrement) proc.getOplist().get(i);
							visitor.visit(decrementer);
							Intvariable result = decrementer.getVar();
							proc.getVarbuffer().getIntvariablelist().get(result.getName()).setContent(result.getContent());
						}

						
						// Execution of sleep
						else if(proc.getOplist().get(i) instanceof Sleep ) {
							ArrayListVisitor<Void> visitor = new OperationVisitor();
							visitor.visit((Sleep) proc.getOplist().get(i));
						}
						// Execution of Kill method
						else if(proc.getOplist().get(i) instanceof Kill ) {
							ArrayListVisitor<Void> visitor = new OperationVisitor();
							visitor.visit((Kill) proc.getOplist().get(i));
						}
						
						// Execution of the functions
						
						// Execution of print
						else if(proc.getOplist().get(i) instanceof Print) {
							//System.out.println(proc.getOplist());
							ArrayListVisitor<Void> visitor = new OperationVisitor();
							Print printer = (Print) proc.getOplist().get(i);
							//System.out.println(proc.getVarbuffer().getIntvariablelist().get(printer.getPrintop().getName()));
							if(printer.getPrintop() instanceof Intvariable) {
								Intvariable var = proc.getVarbuffer().getIntvariablelist().get(printer.getPrintop().getName());
								//System.out.println(proc.getVarbuffer().getIntvariablelist());
								//System.out.println(var.getContent());
								//printer.setPrintop(var);
								scdriver.addStringScreen(var.toString());
							}
							else if(printer.getPrintop() instanceof Stringvariable) {
								Stringvariable var = proc.getVarbuffer().getStringvariablelist().get(printer.getPrintop().getName());
								//System.out.println(var.toString());
								//printer.setPrintop(var);
								scdriver.addStringScreen(var.toString());
							}
							//System.out.println(proc.getVarbuffer().getIntvariablelist());
							//System.out.println(proc.getVarbuffer().getStringvariablelist());
							visitor.visit(printer);
							//System.out.println(printer.getPrintop());
							
						}
						// Execution of the loops Operation
						
						// Execution of the forloop
						else if(proc.getOplist().get(i) instanceof ForLoop ) {
							ForLoop floop = (ForLoop) proc.getOplist().get(i);
							int iterstart = floop.getIterstart();
							int iternumber = floop.getIternumber();
							floop.getVariable().setContent(iterstart);
							floop.getOperations().setVarbuffer(proc.getVarbuffer());
							for(int j = iterstart; j < iternumber; j++) {
								proc.setVarbuffer( floop.getOperations().getVarbuffer());
								execution(floop.getOperations());
								proc.getVarbuffer().getIntvariablelist().get(floop.getVariable().getName()).setContent(floop.getVariable().getContent() + 1);
								proc.setVarbuffer(floop.getOperations().getVarbuffer());
								}
							proc.getVarbuffer().getIntvariablelist().get(floop.getVariable().getName()).setContent(floop.getVariable().getContent()-1);

							
						}
						
						// Execution of the Whileloop
						
						else if(proc.getOplist().get(i) instanceof WhileLoop ){
							WhileLoop whloop = (WhileLoop) proc.getOplist().get(i);
							Comparaison comp = whloop.getComparaison();
							ArrayListVisitor<Void> visitor = new OperationVisitor();
							visitor.visit(comp);
							while(comp.getResult().getContent() == 0) {
								//System.out.println( "comparaison" + comp.getResult().getContent() );
								whloop.getOperations().setVarbuffer(proc.getVarbuffer());
								execution(whloop.getOperations());
								proc.setVarbuffer(whloop.getOperations().getVarbuffer());
								visitor.visit(comp);
							}
						}
						
						// Execution of the testOperation
						
						else if(proc.getOplist().get(i) instanceof Ifelsetest) {
							Ifelsetest test = (Ifelsetest) proc.getOplist().get(i);
							ArrayListVisitor<Void> visitor = new OperationVisitor();
							visitor.visit((Comparaison) test.getComparaison());	
							int testresult = test.getComparaison().getResult().getContent();
							if(testresult == 0) {
								test.getIfprocessus().setVarbuffer(proc.getVarbuffer());
								execution(test.getIfprocessus());
								proc.setVarbuffer(test.getIfprocessus().getVarbuffer());
							}
							else if(testresult == -1) {
								test.getElseprocessus().setVarbuffer(proc.getVarbuffer());
								execution(test.getElseprocessus());
								proc.setVarbuffer(test.getElseprocessus().getVarbuffer());
							}
						}
						else if(proc.getOplist().get(i) == null) {
							
						}
					}
					else {
						// If an EXIT command has been called, end the processus
						i = proc.getNboperation();
					}
					i++;
				}
			}
			catch(NullPointerException e) {
				scdriver.addStringScreen("ERROR in program " + proc.getProcessusname());
			}
			catch(NumberFormatException e) {
				scdriver.addStringScreen("Error in variable allocation");
			}
		}
		else {
			// processus can be stopped for 2 minutes, of he is closed if time go further
			for(int time = 0; time < 120; time++) {
				// If the processus is still in pause, sleep it for a second	
				if(proc.isAblerun() == false) {
				
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// To be continued ...
						e.printStackTrace();
					}
				}
				
			}
			
		}
	}

	
	
}
