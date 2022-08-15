package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPageObject {
	public WebDriver driver;

	private By FormHeading=By.cssSelector(".subtitle1");
	private By UName=By.name("username");
	private By Submitbtn=By.name("submit");
	private By ResponseText1=By.xpath("//p[contains(text(),'Your temporary password has been sent to you by em')]");
	
	
	
	
	
	public ForgotPasswordPageObject(WebDriver driver) {
		this.driver=driver;
	}
	
	public String getFormHeading()
	{
		return driver.findElement(FormHeading).getText();
	}
	public WebElement getUsernameField()
	{
		return driver.findElement(UName);
	}
	public WebElement getSubmitButton()
	{
		return driver.findElement(Submitbtn);
	}
	public String getResponseText()
	{
		return driver.findElement(ResponseText1).getText();
	}
}
