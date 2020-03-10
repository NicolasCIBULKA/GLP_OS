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
<<<<<<< HEAD
		String filenamebin = "/home/nico/Bureau/Fac/L2/S2/GLP/GLP_OS/GLP_OS/Projet_OS/src/scripts/convertit_binaire.txt" ;
		String filenamecompteur = "/home/nico/Bureau/Fac/L2/S2/GLP/GLP_OS/GLP_OS/Projet_OS/src/scripts/chrono.txt";
=======
<<<<<<< HEAD
		String filename = "/Users/theomarmeisse/git/GLP_OS/Projet_OS/src/scripts/convertit_binaire.txt" ;
		String filename2 = "/Users/theomarmeisse/git/GLP_OS/Projet_OS/src/scripts/chrono.txt";
		Processus proc2 = new Processus();
		Processus proc1 = new Processus();
		Processus proc3 = new Processus();
=======
		String filename = "/home/nico/Bureau/Fac/L2/S2/GLP/GLP_OS/GLP_OS/Projet_OS/src/scripts/convertit_binaire.txt" ;
>>>>>>> branch 'master' of https://github.com/NicolasCIBULKA/GLP_OS.git
		Processus proc = new Processus();
<<<<<<< HEAD
		Processus proc2 = new Processus();
=======
>>>>>>> branch 'master' of https://github.com/NicolasCIBULKA/GLP_OS
		
>>>>>>> branch 'master' of https://github.com/NicolasCIBULKA/GLP_OS.git
		// traduction du langage interpreté en un code utilisable
		
<<<<<<< HEAD
		transcriptor.transcription(proc, filenamebin);
		transcriptor.transcription(proc2, filenamecompteur);
		/*
=======
<<<<<<< HEAD
		transcriptor.transcription(proc1, filename);
		transcriptor.transcription(proc2, filename2);
		transcriptor.transcription(proc3, filename);
		
=======
		transcriptor.transcription(proc, filename);
>>>>>>> branch 'master' of https://github.com/NicolasCIBULKA/GLP_OS.git
		oplist.add(proc);
		oplist.add(proc2);
		rr.addProcess(proc);
		rr.addProcess(proc2);
		rr.runRR(oplist, 10, scdriver);
<<<<<<< HEAD
		*/
=======
>>>>>>> branch 'master' of https://github.com/NicolasCIBULKA/GLP_OS
>>>>>>> branch 'master' of https://github.com/NicolasCIBULKA/GLP_OS.git
		// execution du code via processusexec
		//System.out.println("==================== Execution via Processusexec ====================\n");
		//procexec.execution(proc);
<<<<<<< HEAD
		ArrayList<Processus> boy = new ArrayList();
		boy.add(proc1);
		boy.add(proc2);
		boy.add(proc3);
		RoundRobin2 rr = new RoundRobin2(scdriver);
		Interaction inte = new Interaction();
=======
>>>>>>> branch 'master' of https://github.com/NicolasCIBULKA/GLP_OS
		
<<<<<<< HEAD
		
		rr.runRR(boy, 3);
		System.out.println(scdriver.getScreencontent());
=======
>>>>>>> branch 'master' of https://github.com/NicolasCIBULKA/GLP_OS
		// execution du code via operationexec
<<<<<<< HEAD
		
		OperationExec opexec = new OperationExec();
		
=======
		//OperationExec opexec = new OperationExec();
>>>>>>> branch 'master' of https://github.com/NicolasCIBULKA/GLP_OS.git
		System.out.println("==================== Execution via Operationexec ====================\n");
<<<<<<< HEAD
		while(proc2.getAlreadydoneoperation() < proc2.getProcessussize()) {
			opexec.operationexecution(proc2, proc2.getOplist().get(proc2.getAlreadydoneoperation()), scdriver);
			//System.out.println("oui");
=======
<<<<<<< HEAD
		System.out.println(scdriver.toString());
		//while(proc.getAlreadydoneoperation() < proc.getNboperation()) {
			//opexec.operationexecution(proc, proc.getOplist().get(proc.getAlreadydoneoperation()), scdriver);
=======
		while(proc.getAlreadydoneoperation() < proc.getNboperation()) {
			opexec.operationexecution(proc, proc.getOplist().get(proc.getAlreadydoneoperation()), scdriver);
>>>>>>> branch 'master' of https://github.com/NicolasCIBULKA/GLP_OS
>>>>>>> branch 'master' of https://github.com/NicolasCIBULKA/GLP_OS.git
			//System.out.println(proc.getAlreadydoneoperation() + " < " + proc.getNboperation());
			//System.out.println(scdriver.toString());
						
		}
		// Affichage du contenu de l'écran
		
		System.out.println(scdriver.toString());
		//System.out.println(proc.getOplist());
	}

}
