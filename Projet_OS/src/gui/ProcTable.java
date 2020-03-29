package gui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JTable;

import data.processus.Processuslist;

public class ProcTable {
	// Attributs
	private final String tabpath = "./tab.html";
	// Methods
	public ProcTable() {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(tabpath, false));
			writer.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void refreshProcTable(Processuslist plist, int activeprocessusposition) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(tabpath, false));
			writer.write("<table style=\" border-collapse:collapse; \">");
			//writer.write("<style>td{border : 1px solid black;}</style>");
			writer.write("<tr>");
			writer.write("<td style = \"border:1px solid black; border-collapse:collapse; \">Processus Name</td><td style = \" border-collapse:collapse; border:1px solid black; \">Active</td>");
			String text;
			for(int i = 0; i < plist.getProcessuslist().size(); i++) {
				writer.write("<tr>");
				if(i == activeprocessusposition) {
					text = "<td>"+plist.getProcessuslist().get(i).getProcessusname()+"</td><td> YES </td>";
				}
				else {
					text = "<td>"+plist.getProcessuslist().get(i).getProcessusname()+"</td><td> NO </td>";
				}
				writer.write(text);
				writer.write("</tr>");
			}
			writer.write("</table>");
			writer.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getProcTable() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(tabpath));
			String line;
			String html = "";
			while((line = reader.readLine()) != null ) {
				html+=line;
			}
			reader.close();
			return html;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
}
