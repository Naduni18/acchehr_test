package tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageMethods.Login_page_methods;
import pageObjects.Login_page_objects;

import utils.ExcelUtils;

public class Login_page {

	private static WebDriver driver =null;
	private static Login_page_objects obj=null;
	String projectpath = System.getProperty("user.dir");

	@BeforeMethod
	@BeforeTest
	public static void setUp() {

		obj = new Login_page_objects();
		driver = obj.getDriver();
	}
	
	@DataProvider(name = "test1Data")
	public Object[][] getData1() {
		
		Object data[][] = testData(projectpath+"/excel/data.xlsx","s1");
		return data;
	}
	
	@DataProvider(name = "test2Data")
	public Object[][] getData2() {
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

	@Test(dataProvider = "test1Data")
	public static void login_(String email,String pass) throws Exception {

		driver.get("https://www.acchehr.site/login");
		obj.gettextboxEmail(driver).clear();
		obj.gettextboxPassword(driver).clear();
		Login_page_methods.setTextInTextBox(obj.gettextboxEmail(driver),email);
		Login_page_methods.setTextInTextBox(obj.gettextboxPassword(driver),pass);
		
		Login_page_methods.clickButton(obj.getloginButton(driver));
		Login_page_methods.clickButton(obj.getdashboardButton(driver));
		Login_page_methods.clickButton(obj.getaddEventButton(driver));
		Thread.sleep(10000);
		String s = driver.getCurrentUrl();
		System.out.println(s);
		driver.switchTo().activeElement();
		Login_page_methods.setTextInTextBox(obj.gettextboxTitle(driver),"abcd");
		Login_page_methods.setTextInTextBox(obj.gettextboxdescription(driver),"abcd");
		Login_page_methods.setTextInTextBox(obj.getinputboxstart(driver),"09252020");
		Login_page_methods.shiftInTextBox(obj.getinputboxstart(driver));
		Login_page_methods.setTextInTextBox(obj.getinputboxstart(driver),"0245PM");
		Login_page_methods.setTextInTextBox(obj.getinputboxend(driver),"09252020");
		Login_page_methods.shiftInTextBox(obj.getinputboxend(driver));
		Login_page_methods.setTextInTextBox(obj.getinputboxend(driver),"0246PM");
		Login_page_methods.clickButton(obj.getbuttonsave(driver));
		Thread.sleep(3000);
		String s2 = driver.getCurrentUrl();
		System.out.println(s2);
	

	}
	
	/*
	 * @Test(dataProvider = "test2Data") public static void add_event_(String
	 * email,String pass) throws Exception {
	 * 
	 * driver.get("https://www.acchehr.site/home");
	 * Add_event_page_methods.setTextInTextBox(obj.gettextboxTitle(driver),"abcd");
	 * Thread.sleep(3000); String s2 = driver.getCurrentUrl();
	 * System.out.println(s2);
	 * 
	 * 
	 * }
	 */

	@AfterTest
	public static void finish() throws InterruptedException {
		Thread.sleep(3000);
		//driver.close();
	}
	
}
