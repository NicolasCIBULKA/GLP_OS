package test;

import data.arithmeticaloperation.Addition;
import data.functions.Print;
import data.processus.Processus;
import data.variable.Intvariable;
import process.rrobin.ProcessusExec;
import process.traduction.Transcriptor;

public class Testscriptexec {

	public static void main(String[] args) {
		Transcriptor transcriptor = new Transcriptor();
		ProcessusExec procexec = new ProcessusExec();
		String filename = "/home/nico/Bureau/Fac/L2/S2/GLP/GLP_OS/GLP_OS/Projet_OS/src/scripts/compteur.txt" ;
		Processus proc = new Processus();
		transcriptor.transcription(proc, filename);
		procexec.execution(proc);
		
		/*
		Intvariable a = new Intvariable(3);
		Intvariable b = new Intvariable(2);
		Intvariable res = new Intvariable(1);
		Processus test = new Processus();
		Addition add = new Addition(a,b,res);
		Print pr = new Print(res);
		test.addOperation(add);
		test.addOperation(pr);
		procexec.execution(test);
		*/
	}

}
