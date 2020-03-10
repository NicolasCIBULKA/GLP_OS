package test;

import data.drivers.*;
import data.peripheral.*;
import data.processus.*;
import process.rrobin.*;
import process.traduction.*;

public class TestRR {
	public static void main(String[] args) {
		Transcriptor transcriptor = new Transcriptor();
		Processuslist plist = new Processuslist();
		
		
		Screen screen = new Screen("Screen");
		Interaction auth = new Interaction(true, true, true);
		
		ScreenDriver scdriver = new ScreenDriver("ScreenDriver", auth, screen);

		
		Rrobin RR = new Rrobin(plist, scdriver);
		
		//ProcessusExec procexec = new ProcessusExec(scdriver);
		String filenamebin = "/home/nico/Bureau/Fac/L2/S2/GLP/GLP_OS/GLP_OS/Projet_OS/src/scripts/convertit_binaire.txt" ;
		String filenamecompteur = "/home/nico/Bureau/Fac/L2/S2/GLP/GLP_OS/GLP_OS/Projet_OS/src/scripts/chrono.txt";
		
		Processus proc = new Processus();
		Processus proc2 = new Processus();
		
		transcriptor.transcription(proc, filenamebin);
		transcriptor.transcription(proc2, filenamecompteur);
		
		RR.addProcRR(proc2);
		RR.addProcRR(proc);
		
		RR.Roundrobin();
		System.out.println(scdriver.toString());
		
	}
}
