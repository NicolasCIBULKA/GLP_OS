package gui;

import java.util.ArrayList;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import data.processus.Processus;

//----------------------------------------
//work in progress
//----------------------------------------
/**
 * this class manages the line chart of running programs
 * 
 * @author redouane
 *
 */
public class Charts {

	private ArrayList<Processus> listchart = new ArrayList<Processus>();
	
	
	public JFreeChart getHeightEvolutionChart() {
		XYSeries serie = new XYSeries("Running programs");
		for (int index = 0; index < ; index++) {
			serie.add(index, listchart.);
		}

		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(serie);

		return ChartFactory.createXYLineChart("Processus", "Time", "Number of programs running", dataset, PlotOrientation.VERTICAL, true, true, false);
	}
}
