package utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	static XSSFWorkbook workbook = null;
	static XSSFSheet sheet = null;

	public ExcelUtils(String excelPath,String sheetName) {
		try {
			workbook = new XSSFWorkbook(excelPath);
			sheet = workbook.getSheet(sheetName);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	public static int getRowCount() {
		int rowcount = sheet.getPhysicalNumberOfRows();
		return rowcount;		
	}
	public static int getColumnCount() {
		int colcount = sheet.getRow(0).getPhysicalNumberOfCells();
		return colcount;		
	}
	public static String getCellDataString(int row,int col) {			
		String data = sheet.getRow(row).getCell(col).getStringCellValue();
		return data;	
	}
	public static Double getCellDataInt(int row,int col) {			
		Double data = sheet.getRow(row).getCell(col).getNumericCellValue();		
		return data;
	}

}
