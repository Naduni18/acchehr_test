package pageMethods;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class Login_page_methods {
	
	public static  void setTextInTextBox(WebElement element,String text) {
		
		element.sendKeys(text);

	}
public static  void shiftInTextBox(WebElement element) {
		
		element.sendKeys(Keys.TAB);

	}
	
   public static void clickButton(WebElement element) {
		
		element.click();

	}
	
}
