package nano_analytics;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.jfree.data.xy.XYSeriesCollection;

import au.com.bytecode.opencsv.CSVReader;

public class reading_data {
	
	static XYSeriesCollection dataset;
    static CSVReader reader;
    static String[] readNextLine;
    static String filename;
	public static String globalfile;
	
	//================================= Loading files
    public static XYSeriesCollection load_file(String filename) throws NumberFormatException,
    IOException {
    	dataset = new XYSeriesCollection();
    	try {
    		reader = new CSVReader(new FileReader(filename),',');
    		// Read the header and chuck it away
    		readNextLine = reader.readNext();
    		//System.out.println("File loaded: " + filename);
    		globalfile = filename;
    		} catch (FileNotFoundException e) {
    			System.out.println("File not found!");
    			}
    	return dataset;
    	}
    
  //================================= Locating files
	public static String locate_file(String name, String parameter, String setting, int index) {
		filename = System.getProperty(
        			"user.dir") + "/" + name + parameter + "_" + Analytics.typeSet + "_" + index + ".csv";
		try {
				reading_data.load_file(filename);
			} catch (NumberFormatException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace(); }
        	//}
    	return filename;
    	}
	}
