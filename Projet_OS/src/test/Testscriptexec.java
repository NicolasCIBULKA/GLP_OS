package test;

import data.drivers.Interaction;
import data.drivers.ScreenDriver;
import data.peripheral.Screen;
import data.processus.Processus;
import process.rrobin.ProcessusExec;
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
		
		ProcessusExec procexec = new ProcessusExec(scdriver);
		String filename = "/home/nico/Bureau/Fac/L2/S2/GLP/GLP_OS/GLP_OS/Projet_OS/src/scripts/compteur.txt" ;
		Processus proc = new Processus();
		
		// traduction du langage interpreté en un code utilisable
		
		transcriptor.transcription(proc, filename);
		
		// execution du code 
		
		procexec.execution(proc);
		
		// Affichage du contenu de l'écran
		
		System.out.println(scdriver.toString());
	}

}
