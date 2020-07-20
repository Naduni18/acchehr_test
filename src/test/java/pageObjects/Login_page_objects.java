package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Login_page_objects {

	final static String ROOT_URI ="https://www.acchehr.site/login";		
	private static WebElement element = null;
	static WebDriver driver = null;
	static By textboxEmail = By.xpath("//input[@placeholder='Email']");
	static By textboxPassword = By.xpath("//input[@placeholder='Password']");
	static By loginButton = By.xpath("//button[@class='btn btn-primary my-4']");	
	static By dashboardButton = By.xpath("//body/nav[@id='sidenav-main']/div[@class='container-fluid']/div[@id='sidenav-collapse-main']/ul[@class='navbar-nav']/li[2]/a[1]");	
	static By textboxTitle = By.id("input-title");
	static By addEventButton = By.xpath("//button[@class='fc-addEventButton-button btn btn-primary']");
	static By textboxdescription = By.xpath("//input[@id='input-description']");
	static By inputboxstart = By.xpath("//input[@id='input-start']");
	static By inputboxend = By.xpath("//input[@id='input-end']");
	static By buttonsave = By.xpath("//button[contains(text(),'Save')]");

	public Login_page_objects() {
		 String projectpath = System.getProperty("user.dir");
		//System.setProperty("webdriver.gecko.driver",projectpath+"\\drivers\\geckodriver.exe");
		
		System.setProperty("webdriver.edge.driver",projectpath+"\\drivers\\msedgedriver.exe");
	    driver = new EdgeDriver();
		//driver = new FirefoxDriver();
	}

	public static WebDriver getDriver() {
		return driver;		
	}

	public static WebElement gettextboxEmail(WebDriver driver2) {
		element = driver2.findElement(textboxEmail);
		return element;	
	}
	
	public static WebElement gettextboxPassword(WebDriver driver2) {
		element = driver2.findElement(textboxPassword);
		return element;	
	}
	
	public static WebElement getloginButton(WebDriver driver2) {
		element = driver2.findElement(loginButton);
		return element;	
	}
	
	public static WebElement gettextboxTitle(WebDriver driver2) {
		element = driver2.findElement(textboxTitle);
		return element;	
	}
	
	public static WebElement getdashboardButton(WebDriver driver2) {
		element = driver2.findElement(dashboardButton);
		return element;	
	}
	
	public static WebElement getaddEventButton(WebDriver driver2) {
		element = driver2.findElement(addEventButton);
		return element;	
	}
	
	public static WebElement gettextboxdescription(WebDriver driver2) {
		element = driver2.findElement(textboxdescription);
		return element;	
	}
	
	public static WebElement getinputboxstart(WebDriver driver2) {
		element = driver2.findElement(inputboxstart);
		return element;	
	}
	
	public static WebElement getinputboxend(WebDriver driver2) {
		element = driver2.findElement(inputboxend);
		return element;	
	}
	
	public static WebElement getbuttonsave(WebDriver driver2) {
		element = driver2.findElement(buttonsave);
		return element;	
	}

}
