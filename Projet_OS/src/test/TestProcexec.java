package test;

import process.rrobin.*;
import data.loop.ForLoop;
import data.processus.*;


public class TestProcexec {

	public static void main(String[] args) {
		// Test de la méthode d'execution des processus
		ProcessusExec pexec = new ProcessusExec();
		
		Processus proc = new Processus("test");
		Processus fortest = new Processus("Test2");
		
		Sleep slp = new Sleep(1000);
		Sleep slp2 = new Sleep(1000);
		
		proc.addOperation(slp);
		fortest.addOperation(slp2);
		System.out.println("oui");
		pexec.execution(proc);
		
		System.out.println("oui2");
		
		ForLoop flp = new ForLoop(fortest, 0, 5);
		
		proc.addOperation(flp);
		
		pexec.execution(proc);
		
		System.out.println("oui3");
	}
}
