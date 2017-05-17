package nano_analytics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Scanner;

import au.com.bytecode.opencsv.CSVReader;

public class data_vault {
		
	static double[][] data;
	static int data_size;
	static int length;

	static Double x_data;
	static Double y_data;
	static double[][] xx_data;
	static double[][] yy_data;
	static double[][] data_x;
	static double x_value;
	static double[][] data_y;
	private static double y_value;
	private static int index;
	
	
	static void generate_data(int start, int end, int node) throws NumberFormatException, IOException{
		length = file_length(parameters_vault.istart);
		fetch_data(start, end, node, length);
		get_x_data(end);
		data_manipulate.data_devi(data_vault.data, node);
		}
		
	//================================= Generate data for calculations
	public static double[][] fetch_data(int start, int end, int node, int length) throws IOException{
		
		data = new double [length][end];

		for (int index = start; index < end; index++){
			@SuppressWarnings("resource")
			Scanner scan = new Scanner (new BufferedReader(new FileReader(file_call(index))));
			scan.nextLine();
			for (int i = 0; i < length; i++){
				String scanedData = scan.nextLine();
				String [] array = scanedData.split(",");
				data[i][index] = Double.parseDouble(array[node]);
				//System.out.println(data[i][index]);
			}
		}
		return data;
	}
	
	//================================= Generate x-data for plotting
	public static double[][] get_x_data(int number_of_files) throws IOException{
		
		// storing the volt column from the first file, we call it base experiment
		// base file is specified by the user or the machine will take the first file as base by default
		
		int base_index = 0; // should be implemented in the GUI later	
		if (base_index == 0){
			index = 1;
			@SuppressWarnings("resource")
			int length =  data_vault.file_length(index);
			String filename = data_vault.file_call(index);
			data_x = new double [length][number_of_files];
			Scanner scan = new Scanner (new BufferedReader(new FileReader(filename)));
			//System.out.println("node: " + node +  " in file: " + filename + " with index: " + index + " length " + length);
			scan.nextLine();
			for (int i = 0; i < length; i++){
				String scanedData = scan.nextLine();
				String [] array = scanedData.split(",");
				data_x[i][index] = Double.parseDouble(array[0]); // reading the first column for x-axis.
				x_value = data_x[i][index];
				//System.out.println("x-axis " + data_x[i][index] + " index " + index + " read " + i);
			}
		}
		return data_x;
	}

	//================================= Generate y-data for plotting
	public static double[][] get_y_data(int start, int end, int node) throws IOException{

		for (int index = start; index < end; index++){
			@SuppressWarnings("resource")
			int length =  file_length(index);
			data_y = new double [length][end];
			String filename = file_call(index);
			Scanner scan = new Scanner (new BufferedReader(new FileReader(filename)));
			scan.nextLine();
			for (int i = 0; i < length; i++){
				String scanedData = scan.nextLine();
				String [] array = scanedData.split(",");
				data_y[i][index] = Double.parseDouble(array[node]);
				y_value = data_y[i][index];
				//System.out.println(" y: " + y_value);
			}
		}
		return data_y;
	}
	
		
	//================================= Determine file length
	public static int file_length(int index) throws IOException{

    	LineNumberReader  lnr = new LineNumberReader(new FileReader(new File(file_call(index))));
    	try { 
    		lnr.skip(Long.MAX_VALUE); 
    		} 
    		catch (IOException e1) { 
    			e1.printStackTrace(); 
    			}
    	lnr.close();
    	data_size = lnr.getLineNumber()-1;
    	
    	return data_size;
	}
	
	//================================= Call the loaded data file and issue it a name
	public static String file_call(int index) throws IOException{
		
		String name = Analytics.exprName.getText();
    	String parameter = String.valueOf(Analytics.paramType_1.getSelectedItem());
    	String setting =  String.valueOf(Analytics.typeSet);
    	String filename = reading_data.locate_file(name, parameter, setting, index);
    
    	return filename;
	}		   
	
} 

