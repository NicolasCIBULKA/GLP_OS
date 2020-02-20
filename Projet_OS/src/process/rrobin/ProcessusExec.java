package process.rrobin;

import data.arithmeticaloperation.*;
import data.functions.Print;
import data.iftest.Ifelsetest;
import data.loop.*;
import data.processus.Processus;
import data.processus.*;
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
	
	
	// --------------------------------------
	// Methods
	// --------------------------------------
	
	// Constructor of the class ProcessusExec
	
	public ProcessusExec() {
		
	}
	
	// Method that will execute the processus
	
	public void execution(Processus proc) {
		for(int i = 0; i < proc.getNboperation(); i++) {
			// Execution of the arithmeticalOperation
			if(proc.getOplist().get(i) instanceof Addition ) {
				ArrayListVisitor<Void> visitor = new OperationVisitor();
				visitor.visit((Addition) proc.getOplist().get(i));
			}
			else if(proc.getOplist().get(i) instanceof Substraction ) {
				ArrayListVisitor<Void> visitor = new OperationVisitor();
				visitor.visit((Substraction) proc.getOplist().get(i));
			}
			else if(proc.getOplist().get(i) instanceof Multiplication ) {
				ArrayListVisitor<Void> visitor = new OperationVisitor();
				visitor.visit((Multiplication) proc.getOplist().get(i));
			}
			// Exectution of the Primitives
			
			// Execution of sleep
			else if(proc.getOplist().get(i) instanceof Sleep ) {
				ArrayListVisitor<Void> visitor = new OperationVisitor();
				visitor.visit((Sleep) proc.getOplist().get(i));
			}
			
			// Execution of the functions
			// Execution of print
			else if(proc.getOplist().get(i) instanceof Print ) {
				ArrayListVisitor<Void> visitor = new OperationVisitor();
				visitor.visit((Print) proc.getOplist().get(i));
			}
			// Execution of the loops Operation
			// Execution of the forloop
			else if(proc.getOplist().get(i) instanceof ForLoop ) {
				ForLoop floop = (ForLoop) proc.getOplist().get(i);
				int iterstart = floop.getIterstart();
				int iternumber = floop.getIternumber();
				for(int j = iterstart+1; j < iternumber+1; j++) {
					floop.setIterstart(j);
					execution(floop.getOperations());
				}
			}
			// Execution of the testOperation
			else if(proc.getOplist().get(i) instanceof Ifelsetest) {
				Ifelsetest test = (Ifelsetest) proc.getOplist().get(i);
				ArrayListVisitor<Void> visitor = new OperationVisitor();
				visitor.visit((Comparaison) test.getComparaison());	
				int testresult = test.getComparaison().getResult().getContent();
				if(testresult == 0) {
					execution(test.getIfprocessus());
				}
				else if(testresult == -1) {
					execution(test.getElseprocessus());
				}
			}
		}
	}
	
	
	
}
