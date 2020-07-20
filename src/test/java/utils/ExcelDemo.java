package utils;

public class ExcelDemo {
	static String projectpath = System.getProperty("user.dir");
	
	public static void main(String[] args) {
		ExcelUtils eu =  new ExcelUtils(projectpath+"/excel/data.xlsx","s1");
		eu.getRowCount();
		eu.getColumnCount();
		eu.getCellDataString(0, 0);
		eu.getCellDataInt(1, 1);
	}

}
