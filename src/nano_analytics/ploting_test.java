package nano_analytics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import au.com.bytecode.opencsv.CSVReader;

public class ploting_test {

	private static double xvalue;
	private static double yvalue;
	private static Double[][] x_data;
	static double[][] data_x;
	static double[][] data_y;
	private static double x_value;
	private static double y_value;
	private static int index;

	public static void main() throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		//data_vault.data_generator();
		for (int node = parameters_vault.nstart; node < parameters_vault.nend; node++){
			//System.out.println("node: " + node);
			get_x_data(parameters_vault.istart, parameters_vault.iend, node);
			//x_call(index);
			int length = data_vault.file_length(parameters_vault.istart);
			data_vault.fetch_data(parameters_vault.istart, parameters_vault.iend, node, length);
			//data_vault.get_y_data(parameters_vault.istart, parameters_vault.iend, node+1);
			//y_call(parameters_vault.istart, parameters_vault.iend, data_vault.data, node+1);
			data_manipulate.data_deviation(data_vault.data, node);
		}
	}
	

	
	//================================= Generate x-data for plotting
	public static double[][] get_x_data(int start, int end, int node) throws IOException{
		// storing the volt column from the first file, we call it base experiment
		// base file is specified by the user or the machine will take the first file as base by default
		int base_index = 0; // should be implemented in the gui later
		
		if (base_index == 0){
			index = 1;
			@SuppressWarnings("resource")
			int length =  data_vault.file_length(index);
			String filename = data_vault.file_call(index);
			data_x = new double [length][end];
			Scanner scan = new Scanner (new BufferedReader(new FileReader(filename)));
			//System.out.println("node: " + node +  " in file: " + filename + " with index: " + index + " length " + length);
			scan.nextLine();
			for (int i = 0; i < length; i++){
				String scanedData = scan.nextLine();
				String [] array = scanedData.split(",");
				data_x[i][index] = Double.parseDouble(array[0]);
				x_value = data_x[i][index];
				//System.out.println("x-axis " + data_x[i][index] + " index " + index + " read " + i);
			}
		}
		return data_x;
	}
	
	//================================= testing calls for x values
	public static void x_call(int index) throws IOException{
		int length =  data_vault.file_length(index);
			for (int j = 0; j < length; j++){
				System.out.println("x-axis " + data_x[j][index] + " index " + index + " read " + j);
			}
	}

	//================================= Generate y-data for plotting
	public static double[][] get_y_data(int start, int end, int node) throws IOException{

		for (int index = start; index < end; index++){
			@SuppressWarnings("resource")
			int length =  data_vault.file_length(index);
			data_y = new double [length][end];
			String filename = data_vault.file_call(index);
			Scanner scan = new Scanner (new BufferedReader(new FileReader(filename)));
			scan.nextLine();
			for (int i = 0; i < length; i++){
				String scanedData = scan.nextLine();
				String [] array = scanedData.split(",");
				data_y[i][index] = Double.parseDouble(array[node]);
				y_value = data_y[i][index];
				//System.out.println(" y-axis " + y_value);
			}
		}
		return data_y;
	}
	
	//================================= testing calls for y values
	public static double[][] y_call(int start, int end, double [][] dumy, int node) throws IOException{
        double[][] trans_matrix = new double[dumy[0].length][dumy.length];
        for (int index = start; index < end; index++){
			@SuppressWarnings("resource")
			int length =  data_vault.file_length(index);
			for (int i = 0; i < length; i++){
                trans_matrix[index][i] = dumy[i][index];
                double value = trans_matrix[index][i];
        	System.out.println(" element " + dumy[i][index]);
            }
        }
        return trans_matrix;
    }
	
	//============================================= Building the datasets
	private XYSeriesCollection build_xy_ataset(int i) {
        XYSeries series = new XYSeries(i);
        return new XYSeriesCollection(series);
    }
	
	
	//============================================ Storing x/y-axis
	public static double xy_axis(int start, int end, int node) throws IOException {
		
		get_x_data(start, end, node);
		get_y_data(start, end, node);
		
		for (int index = start; index < end; index++){
			String filename = data_vault.file_call(index);
			System.out.println("collecting from file dir: " + filename);
		    int length;
			length = data_vault.file_length(index);
			for (int i = 0; i < length ; i++){
				xvalue = data_x[i][index];
		        yvalue = data_y[i][index];
		        //yvalue = y_pulls[i][j];
		        System.out.println(" reading " + i + " file " + index + " node: " + node + " x " + xvalue + "   y " + yvalue);
		            }
				}
				
        return yvalue;		
	}

}
