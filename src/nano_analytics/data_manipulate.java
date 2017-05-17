/**
 * 
 */
package nano_analytics;

import java.io.IOException;

/**
 * @author Ahmed
 *
 */
public class data_manipulate {

	private static double mean;
	private static double sigma;
	private static double variance;
	private static double stanDevi;
	private static int counter;
	private static double variances;
	static double[][] trans_matrix;
	private static double sum;
	//private static double entry;
	static double[][] devi_data;

	/**
	 * 
	 */
	public data_manipulate() {
		// TODO Auto-generated constructor stub
	}
	
	private void initialize(){
		//data_vault.
	}

	//===================================== Taking the transpose matrx:
	public static double[][] transpose_data(double [][] dumy, int node){
		double counter = 0;
        trans_matrix = new double[dumy[0].length][dumy.length];
        for (int i = 0; i < dumy.length; i++){
        	sum = 0; // reinitialize the sum.
            for (int j = 0; j < dumy[0].length; j++){
                trans_matrix[j][i] = dumy[i][j];
                double value = trans_matrix[j][i];
                sum += value;
        	//System.out.println(" element " + value);
            }
			counter++;
        }
        mean = sum/(counter-1);
        //System.out.println("node " + node + " counter " + counter +  " sum " + sum  + " mean " + mean);
        return trans_matrix;
    }
	
	//===================================== Calculating the mean:
	public static double data_mean(double [][] dumy, int node) throws IOException{
		
		int length = data_vault.file_length(parameters_vault.istart);
		
		int start = parameters_vault.istart;
		int end = parameters_vault.iend;
		int counts = parameters_vault.iend - parameters_vault.istart;
        trans_matrix = new double[data_vault.data[0].length][data_vault.data.length];
        for (int i = 0; i < length; i++){
        	sum = 0; // reinitialize the sum.
            for (int index = start; index < end; index++){
                trans_matrix[index][i] = dumy[i][index];
                double value = trans_matrix[index][i];
                //System.out.println("node " + node + " read " + trans_matrix[index][i] + " double check " + value );
                sum += value;
//               System.out.println("file " + index + " node " + node + " read " + value + " sum " + sum );
////               System.out.println("                 " );

    	        mean = sum/counts;
            }
	        //System.out.println(" ----- sum " + sum  + " ----- mean " + mean);
//			System.out.println("                 " );
        }
        return mean;
    }
	
	
	//===================================== Calculating the standard deviations:
	public static double data_deviation(double [][] dumy, int node) throws IOException{
		
		int length = data_vault.file_length(parameters_vault.istart);
		
		int start = parameters_vault.istart;
		int end = parameters_vault.iend;
		int counts = parameters_vault.iend - parameters_vault.istart;
		double mean_value = 0;
        trans_matrix = new double[data_vault.data[0].length][data_vault.data.length];
        
        for (int i = 0; i < dumy.length; i++){
        	counter = 0;
			variance = 0;
			sum = 0;
			double value = 0;
//            for (int index = start; index < end; index++){
//            	//mean_value = data_mean(dumy, node);
//                trans_matrix[index][i] = dumy[i][index];
//                entry = trans_matrix[index][i];
//                sum = +entry;
//                counter++;
//            }
            for (int index = start; index < end; index++){
                trans_matrix[index][i] = dumy[i][index];
                double entry = trans_matrix[index][i];
                //System.out.println("node " + node + " read " + trans_matrix[index][i] + " double check " + value );
                sum += entry;
//               System.out.println("file " + index + " node " + node + " read " + value + " sum " + sum );
////               System.out.println("                 " );
            }

	        mean = sum/counts;
        	//System.out.println(" node " + node + " counts " + counts + " sum " + sum + " mean " + mean);

            for (int index = start; index < end; index++){
                value = trans_matrix[index][i] - mean;
                variances = value*value;//Math.pow(values, 2);
				variance += variances;
            	counter++;
//            	System.out.println("file " + index + " node " + node + " read " + value + " mean " + mean);
//            	System.out.println(
//            			" node " + node + 
//            			", read " + entry + 
//            			", mean " + mean_value +
//            			", deviation from mean " + value + 
//            			", entry variance " + variances + 
//            			", variance " + variance
//            			);

            	//System.out.println(" file " + index + " node " + node);
            }
			sigma = variance/counts; // the variance
			stanDevi = Math.sqrt(sigma); // the standard deviations
			//System.out.println(" --------- standDiv " + stanDevi);

//			System.out.println(
//					//"node " + node + 
//					//", counter " + counter + 
//					//", variance " + variance +  
//					//", mean " + mean + 
//					//", sigma   " + sigma + 
//					", standDiv " + stanDevi);
        }
        return stanDevi;
    }
	
	//===================================== Calculating the standard deviations:
	public static double[][] data_devi(double [][] dumy, int node) throws IOException{
		
		int length = data_vault.file_length(parameters_vault.istart);
		
		int start = parameters_vault.istart;
		int end = parameters_vault.iend;
		int counts = parameters_vault.iend - parameters_vault.istart;
		double mean_value = 0;
        trans_matrix = new double[data_vault.data[0].length][data_vault.data.length];
        devi_data =  new double[length][data_vault.data.length];
        
        for (int i = 0; i < dumy.length; i++){
        	counter = 0;
			variance = 0;
			sum = 0;
			double value = 0;
            for (int index = start; index < end; index++){
                trans_matrix[index][i] = dumy[i][index];
                double entry = trans_matrix[index][i];
                sum += entry;
            }
	        mean = sum/counts;
            for (int index = start; index < end; index++){
                value = trans_matrix[index][i] - mean;
                variances = value*value;//Math.pow(values, 2);
				variance += variances;
            	counter++;

            }
			sigma = variance/counts; // the variance
			stanDevi = Math.sqrt(sigma); // the standard deviations//devi_data[i][node]);
			devi_data[i][node] = stanDevi;
//			System.out.println("read -- " + i + " node -- " + node + " deviated -- " + devi_data[i][node]);
        }
        return devi_data;
    }
	
}
