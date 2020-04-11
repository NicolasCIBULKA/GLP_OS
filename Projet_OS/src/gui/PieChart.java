package gui;



import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import process.rrobin.Rrobin;


/**
 * this class is used to print the two pie charts in the GUI
 * 
 * @author redouane
 *
 */

public class PieChart {
	Rrobin roundrobin;
	
	DefaultPieDataset dataset = new DefaultPieDataset();

	 public PieChart(Rrobin rr) {
		 this.roundrobin=rr;
	 }
	 
	 
	public JFreeChart getCpuPie() {
		
		
		dataset.setValue("CPU used",  0);
		dataset.setValue("CPU left", 100 );

		return ChartFactory.createPieChart("CPU and Slots", dataset, true, true, false);
	}
	
	public void refreshData() {
		int CPUUsing = roundrobin.getCPUUsing();
		dataset.setValue("CPU used",CPUUsing);
		dataset.setValue("CPU left", 100-roundrobin.getCPUUsing() );
		
	}
	
}
