package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Add_event_page_objects {

	//final static String ROOT_URI ="https://www.acchehr.site/home";		
	private static WebElement element = null;
	static WebDriver driver = null;
	static By textboxTitle = By.id("input-title");
	//static By textboxPassword = By.xpath("//input[@placeholder='Password']");
	//static By loginButton = By.xpath("//button[@class='btn btn-primary my-4']");	

	public Add_event_page_objects() {
		 String projectpath = System.getProperty("user.dir");
		//System.setProperty("webdriver.gecko.driver",projectpath+"\\drivers\\geckodriver.exe");
		
		System.setProperty("webdriver.edge.driver",projectpath+"\\drivers\\msedgedriver.exe");
	    driver = new EdgeDriver();
		//driver = new FirefoxDriver();
	}

	public static WebDriver getDriver() {
		return driver;		
	}

	public static WebElement gettextboxTitle(WebDriver driver2) {
		element = driver2.findElement(textboxTitle);
		return element;	
	}
	
}
