package tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageMethods.Add_event_page_methods;
import pageObjects.Add_event_page_objects;
import utils.ExcelUtils;

public class Add_event_page {

	private static WebDriver driver =null;
	private static Add_event_page_objects obj=null;

	@BeforeMethod
	@BeforeTest
	public static void setUp() {

		obj = new Add_event_page_objects();
		driver = obj.getDriver();
	}
	
	@DataProvider(name = "test2Data")
	public Object[][] getData() {
		String projectpath = System.getProperty("user.dir");
		Object data[][] = testData(projectpath+"/excel/data.xlsx","s2");
		return data;
	}
	
    @Test
	public Object[][] testData(String excelPath,String sheetName) {
		
		ExcelUtils eu =  new ExcelUtils(excelPath,sheetName);

		int rows = eu.getRowCount();
		int cols = eu.getColumnCount();
		
		Object data[][] = new Object[rows-1][cols];
		
		for(int i=1;i<rows;i++) {
			for(int j=0;j<cols;j++) {		
			String cellData = 	eu.getCellDataString(i,j).trim();
			data[i-1][j]=cellData;
			System.out.println(cellData);
		}
	}
		return data;
}

	@Test(dataProvider = "test2Data")
	public static void login_(String email,String pass) throws Exception {

		driver.get("https://www.acchehr.site/home");		
		Add_event_page_methods.setTextInTextBox(obj.gettextboxTitle(driver),"abcd");
		Thread.sleep(3000);
		String s = driver.getCurrentUrl();
		System.out.println(s);
	

	}

	@AfterTest
	public static void finish() throws InterruptedException {
		Thread.sleep(3000);
		//driver.close();
	}
	
	
}
