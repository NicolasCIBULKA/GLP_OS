package test;

import process.rrobin.*;
import data.arithmeticaloperation.Comparaison;
import data.functions.Print;
import data.iftest.Ifelsetest;
import data.loop.ForLoop;
import data.processus.*;
import data.variable.Intvariable;


public class TestProcexec {

	public static void main(String[] args) {
		// Test de la méthode d'execution des processus
		ProcessusExec pexec = new ProcessusExec();
		
		Intvariable a = new Intvariable(3); 
		Intvariable b = new Intvariable(1);
		Intvariable c = new Intvariable(0);
		
		Processus proc = new Processus("test");
		Processus fortest = new Processus("Test2");
		Processus ifproc = new Processus("ifproc");
		Processus elseproc = new Processus("elseproc");
		
		
		Comparaison comp = new Comparaison(a, b, c, "==");
		Operation ifelse = new Ifelsetest(ifproc, elseproc, comp);
		
		Sleep slp = new Sleep(1000);
		Sleep slp2 = new Sleep(1000);
		Sleep slp3 = new Sleep(10000);
		Sleep slp4 = new Sleep(300);
		//Kill pause = new Kill("PAUSE");
		Print prt = new Print(slp);
				
		proc.addOperation(slp);
		ifproc.addOperation(slp3);
		elseproc.addOperation(slp4);
		fortest.addOperation(slp2);
		fortest.addOperation(prt);
		//fortest.addOperation(slp);
		
		
		System.out.println("oui");
		
		System.out.println(prt.print());
		pexec.execution(proc);
		
		System.out.println("oui2");
		
		ForLoop flp = new ForLoop(fortest, 0, 5);
		
		proc.addOperation(flp);
		proc.addOperation(ifelse);
		pexec.execution(proc);
		
		System.out.println("oui3");
	}
}
