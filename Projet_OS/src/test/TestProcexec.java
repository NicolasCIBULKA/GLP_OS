package test;

import process.rrobin.*;
import data.arithmeticaloperation.Comparaison;
import data.functions.Print;
import data.functions.Sleep;
import data.iftest.Ifelsetest;
import data.loop.ForLoop;
import data.primitive.*;
import data.processus.*;
import data.variable.Intvariable;
import data.variable.Stringvariable;


public class TestProcexec {

	public static void main(String[] args) {
		// Test de la méthode d'execution des processus
		ProcessusExec pexec = new ProcessusExec();
		
		// Definition des variabless$
		Intvariable a = new Intvariable(3); 
		Intvariable b = new Intvariable(1);
		Intvariable c = new Intvariable(0);
		Stringvariable d = new Stringvariable("Ceci est un test");
		Stringvariable e = new Stringvariable("On est dans le else");
		
		// Definition des processus
		Processus proc = new Processus("test");
		Processus fortest = new Processus("Test2");
		Processus ifproc = new Processus("ifproc");
		Processus elseproc = new Processus("elseproc");
		
		// Definition des operations
		Comparaison comp = new Comparaison(a, b, c, "==");
		Operation ifelse = new Ifelsetest(ifproc, elseproc, comp);
		
		Sleep slp = new Sleep(1000);
		Sleep slp2 = new Sleep(1000);
		Sleep slp3 = new Sleep(3000);
		Sleep slp4 = new Sleep(300);
		Print prt = new Print(slp);
		Print prt3 = new Print(d);
		Print prt4 = new Print(e);
		Primitive exit = new Kill(proc, "RUN");

		// Ajout des opérations
		ifproc.addOperation(slp3);
		elseproc.addOperation(prt4);
		fortest.addOperation(slp2);
		fortest.addOperation(prt);
		fortest.addOperation(slp);
		proc.addOperation(exit);
		ForLoop flp = new ForLoop(fortest, 0, 5);
		Print prt2 = new Print(flp);
		
		proc.addOperation(flp);
		fortest.addOperation(prt2);
		fortest.addOperation(prt3);
		proc.addOperation(ifelse);
		
		System.out.println("----------- Test de l'execution du processus " + proc.getProcessusname() + " -----------\n\n");
		// Le programme effectue d'abord la boucle for, puis teste avec un if else si a == b
		// Si c'est vrai, on sleep pendant 3s, sinon écrit un texte
		
		
		pexec.execution(proc);
		
		System.out.println("\n\n----------- Fin de l'execution du processus " + proc.getProcessusname() + " -----------\n\n");
	}
}
