package test;

import data.processus.*;
import data.variable.*;
import process.visitor.*;
import data.arithmeticaloperation.*;
import data.functions.*;
import data.primitive.*;

public class TestProcessus {

	public static void main(String[] args) {
		Processus proc = new Processus("Test");
		
		// Creation des variables
		
		Intvariable a = new Intvariable(3); 
		Intvariable b = new Intvariable(1);
		Intvariable c = new Intvariable(0);
		Intvariable i = new Intvariable(1000);
		Intvariable one = new Intvariable(1);
		
		// Creations des processus
		
		Arithmeticaloperation op1 = new Addition(a,b,c);
		Substraction op2 = new Substraction(a, one, a);
		Sleep slp = new Sleep(1000);
		Primitive killpause = new Kill(proc, "PAUSE");
		// Ajout des opérations dans le processus
		
		proc.addOperation(op1);
		
		// Test des méthodes
		
		System.out.println("Nombre d'operations dans le processus 1: " + proc.getNboperation());
		ArrayListVisitor<Void> visitor = new OperationVisitor();
		visitor.visit((Addition) op1);
		System.out.println("Resultat de l'Operation 3 + 1 = " + op1.getResult().getContent());
		
		for(i.setContent(0); i.getContent() < 10; i.setContent(i.getContent()+1)) {
			//System.out.println("Valeur de i : " + i.getContent());
			visitor.visit(op2);
			visitor.visit(slp);
			//visitor.visit(killpause);
			System.out.println(op2.getResult().getContent());
		}
			
			//test du temps d'execution des méthodes
		int j;
			long startTime = System.nanoTime();
		    for (j=0; j < 100000; j++) {
		    	visitor.visit((Addition) op1);
		    }
		    long endTime = System.nanoTime();			    System.out.println("Total elapsed time in execution of method is :"+ ((endTime-startTime)/100000));
		}
}
