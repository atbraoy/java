/**
 * 
 */
package nano_analytics;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import au.com.bytecode.opencsv.CSVReader;

/**
 * @author Ahmed
 *
 */
public class plotting {

	private static XYSeriesCollection dataset;
	private static Double X;
	private static Double Y;
	private static double[][] XX;

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(int start, int end) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
 	   for (int node = start; node < end; node++){
 			XYSeriesCollection data = plotting_data(node);
 			JFreeChart chart = create_chart(data, node);
 			data_chart(node);
 	   }
	}
	
	//====================================== Plotting data chart
	public static JFreeChart data_chart(int node) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		XYSeriesCollection data = plotting_data(node);
		JFreeChart data_chart = create_chart(data, node);
		return data_chart;
	}
	
	//====================================== Creating the XY data for plotting 
	   public static XYSeriesCollection plotting_data(int node) throws NumberFormatException,
	           IOException {
	       dataset = new XYSeriesCollection();
	       try {
	            
	           // Set up series and bla bla bla
		            final XYSeries XYData = new XYSeries("node " + node + " current");
		            CSVReader reader = new CSVReader(new FileReader(reading_data.filename),',');
		            // Read the header and chuck it away
		            String[] readNextLine = reader.readNext();
		            while ((readNextLine = reader.readNext()) != null) {
		                // add values to dataset
		            	int m = -1;
		                X = Double.valueOf(readNextLine[node]);
		                Y = Double.valueOf(readNextLine[0]);
		                XYData.add(X*m, Y);
		                //System.out.println("("+ X + ";" + Y + ")");
		            }
		            //dataset.addSeries(seriesX);
		            //System.out.println(XYData.getMaxX() + "; " + XYData.getMaxY());
		            dataset.addSeries(XYData);

	        } catch (FileNotFoundException e) {
	            System.out.println("File not found!");
	        }
	        return dataset;
	    }
//	   
//	 //======================================= Creating mean plotting data
//	   public static void plotting_mean() throws IOException{
//		   int display_node = 1; // fix later!
//           final XYSeries meanXY = new XYSeries("node " + display_node + " current");
//		   for (int node = parameters_vault.nstart; node < parameters_vault.nend; node++ ){
//   			int length = data_vault.file_length(parameters_vault.istart);
//   			X_value = data_manipulate.data_deviation(data_vault.data, node);
//   			System.out.println("x values " + X_value);
//		   }
	   
	   //====================================== Initializing charts
		public static JFreeChart create_chart(XYDataset dataset, int id)
	            throws NumberFormatException, IOException {
	    	int id_node = id-2;
	    	JFreeChart chart = ChartFactory.createXYLineChart(" ", // chart
	                                                                        // title
	                "voltage", // domain axis label
	                "node " + id_node + " current", // range axis label
	                dataset, // data
	                PlotOrientation.VERTICAL, // the plot orientation
	                true, // legend
	                true, // tooltips
	                false); // urls
	    	
	    	// Below for saving as jpg, use later 		
//	    	int width = 640; /* Width of the image */
//	        int height = 480; /* Height of the image */ 
//	        File lineChart = new File( "LineChart.jpeg" ); 
//	        ChartUtilities.saveChartAsPNG(lineChart ,fix this, width ,height);

	        return chart;
	    }
	   
}
