/**
 * 
 */
package nano_analytics;

/**
 * @author Ahmed
 *
 */
public class parameters_vault {

	static Integer nstart;
	static Integer nend;
	static Integer istart;
	static Integer iend;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static void nodes(String starter, String ender){
		nstart = Integer.valueOf(starter)-1;
		nend = Integer.valueOf(ender);
	}
	
	public static void index(String starter, String ender){
		istart = Integer.valueOf(starter);
		iend = Integer.valueOf(ender)+1;
	}

}
