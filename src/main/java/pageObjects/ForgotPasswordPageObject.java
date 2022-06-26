package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPageObject {
	public WebDriver driver;

	private By FormHeading=By.cssSelector(".subtitle1");
	
	
	
	
	
	
	public ForgotPasswordPageObject(WebDriver driver) {
		this.driver=driver;
	}
	
	public String getFormHeading()
	{
		return driver.findElement(FormHeading).getText();
	}
	
}
