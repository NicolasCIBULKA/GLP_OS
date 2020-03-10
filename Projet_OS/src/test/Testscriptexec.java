package test;

import java.util.ArrayList;

import data.drivers.Interaction;
import data.drivers.ScreenDriver;
import data.peripheral.Screen;
import data.processus.Processus;
import process.rrobin.OperationExec;
import process.rrobin.ProcessusExec;
import process.rrobin.RoundRobin2;
import process.traduction.Transcriptor;

public class Testscriptexec {

	public static void main(String[] args) {
		// traducteur
		
		Transcriptor transcriptor = new Transcriptor();
		
		// Necessaire a l'utilisation de lecran
		
		Screen screen = new Screen("Screen");
		Interaction auth = new Interaction(true, true, true);
		
		ScreenDriver scdriver = new ScreenDriver("ScreenDriver", auth, screen);
		
		// Executeur de processus qui enverra les resultats sur le driver de l'ecran
		
		//ProcessusExec procexec = new ProcessusExec(scdriver);
		String filename = "/Users/theomarmeisse/git/GLP_OS/Projet_OS/src/scripts/convertit_binaire.txt" ;
		String filename2 = "/Users/theomarmeisse/git/GLP_OS/Projet_OS/src/scripts/chrono.txt";
		Processus proc2 = new Processus();
		Processus proc1 = new Processus();
		Processus proc3 = new Processus();
		
		// traduction du langage interpreté en un code utilisable
		
		transcriptor.transcription(proc1, filename);
		transcriptor.transcription(proc2, filename2);
		transcriptor.transcription(proc3, filename);
		
		// execution du code via processusexec
		//System.out.println("==================== Execution via Processusexec ====================\n");
		//procexec.execution(proc);
		ArrayList<Processus> boy = new ArrayList();
		boy.add(proc1);
		boy.add(proc2);
		boy.add(proc3);
		RoundRobin2 rr = new RoundRobin2(scdriver);
		Interaction inte = new Interaction();
		
		
		rr.runRR(boy, 3);
		System.out.println(scdriver.getScreencontent());
		// execution du code via operationexec
		//OperationExec opexec = new OperationExec();
		System.out.println("==================== Execution via Operationexec ====================\n");
		System.out.println(scdriver.toString());
		//while(proc.getAlreadydoneoperation() < proc.getNboperation()) {
			//opexec.operationexecution(proc, proc.getOplist().get(proc.getAlreadydoneoperation()), scdriver);
			//System.out.println(proc.getAlreadydoneoperation() + " < " + proc.getNboperation());
			//System.out.println(scdriver.toString());
						
		}
		// Affichage du contenu de l'écran
		
	//	System.out.println(scdriver.toString());
		//System.out.println(proc.getOplist());
	}

//}
