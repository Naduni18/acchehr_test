package pageMethods;

import org.openqa.selenium.WebElement;

public class Add_event_page_methods {
	
public static  void setTextInTextBox(WebElement element,String text) {
		
		element.sendKeys(text);

	}
}
