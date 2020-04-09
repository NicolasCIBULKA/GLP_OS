package gui;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;


/**
 * this class is used to print the two pie charts in the GUI
 * 
 * @author redouane
 *
 */

public class PieChart {

	//utilisation de constantes pour evaluer le rendu graphique. voir les commentaire pour regler les dataset
	public JFreeChart getCpuPie() {
		DefaultPieDataset dataset = new DefaultPieDataset();
		
		//utiliser operation.getCpuusing()
		dataset.setValue("CPU used", 5 );
		
		
		//100-op.getCpuusing
		dataset.setValue("CPU left", 10 );

		return ChartFactory.createPieChart("CPU and Slots", dataset, true, true, false);
	}
	
	
	//method for the pie chart of the slots
	public JFreeChart getSlotPie() {
		DefaultPieDataset dataset = new DefaultPieDataset();
		//methode pas encore dispo
		dataset.setValue("CPU used", 50 );
		dataset.setValue("CPU left", 50 );

		return ChartFactory.createPieChart("", dataset, true, true, false);
	}
}
