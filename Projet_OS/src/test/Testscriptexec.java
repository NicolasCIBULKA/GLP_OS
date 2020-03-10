package test;

import java.util.ArrayList;

import data.drivers.Interaction;
import data.drivers.ScreenDriver;
import data.peripheral.Screen;
import data.processus.Processus;
import process.rrobin.*;
import process.traduction.Transcriptor;

public class Testscriptexec {

	public static void main(String[] args) {
		// traducteur
		
		Transcriptor transcriptor = new Transcriptor();
		
		// RR
		RoundRobin2 rr = new RoundRobin2();
		ArrayList<Processus> oplist = new ArrayList<Processus>();
		
		// Necessaire a l'utilisation de lecran
		
		Screen screen = new Screen("Screen");
		Interaction auth = new Interaction(true, true, true);
		
		ScreenDriver scdriver = new ScreenDriver("ScreenDriver", auth, screen);
		
		// Executeur de processus qui enverra les resultats sur le driver de l'ecran
		
		//ProcessusExec procexec = new ProcessusExec(scdriver);
		String filenamebin = "/home/nico/Bureau/Fac/L2/S2/GLP/GLP_OS/GLP_OS/Projet_OS/src/scripts/convertit_binaire.txt" ;
		String filenamecompteur = "/home/nico/Bureau/Fac/L2/S2/GLP/GLP_OS/GLP_OS/Projet_OS/src/scripts/chrono.txt";
		Processus proc = new Processus();
		Processus proc2 = new Processus();
		// traduction du langage interpreté en un code utilisable
		
		transcriptor.transcription(proc, filenamebin);
		transcriptor.transcription(proc2, filenamecompteur);
		/*
		oplist.add(proc);
		oplist.add(proc2);
		rr.addProcess(proc);
		rr.addProcess(proc2);
		rr.runRR(oplist, 10, scdriver);
		*/
		// execution du code via processusexec
		//System.out.println("==================== Execution via Processusexec ====================\n");
		//procexec.execution(proc);
		
		// execution du code via operationexec
		
		OperationExec opexec = new OperationExec();
		
		System.out.println("==================== Execution via Operationexec ====================\n");
		while(proc2.getAlreadydoneoperation() < proc2.getProcessussize()) {
			opexec.operationexecution(proc2, proc2.getOplist().get(proc2.getAlreadydoneoperation()), scdriver);
			//System.out.println("oui");
			//System.out.println(proc.getAlreadydoneoperation() + " < " + proc.getNboperation());
			//System.out.println(scdriver.toString());
						
		}
		// Affichage du contenu de l'écran
		
		System.out.println(scdriver.toString());
		//System.out.println(proc.getOplist());
	}

}
