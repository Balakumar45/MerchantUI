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
	private By PartnerLogo=By.xpath("//a[@title='paymentz']//img");
	private By WarningText1=By.cssSelector("tbody tr:nth-child(1) td:nth-child(1)");
	private By WarningText2=By.cssSelector("tbody tr:nth-child(1) td:nth-child(1)");
	private By UNameTextfield=By.cssSelector("body > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > form:nth-child(4) > div:nth-child(2) > label:nth-child(1)");
	private By LoginButton=By.cssSelector(".btn.btn-green-3");
	private By SuccessFormTitle=By.cssSelector("div[class='login-title'] strong");
	private By SuccessFormTitle3=By.cssSelector("body form");
	
	
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
	public String getResponsePageText()
	{
		return driver.findElement(ResponseText1).getText();
	}
	public WebElement PatnerLogoImage()
	{
		return driver.findElement(PartnerLogo);
	}
	public String getWarningText1()
	{
		return driver.findElement(WarningText1).getText();
	}
	public String getWarningText2()
	{
		return driver.findElement(WarningText2).getText();
	}
	public String getUsernameFieldText()
	{
		return driver.findElement(UNameTextfield).getText();
	}
	public WebElement getLoginButton()
	{
		return driver.findElement(LoginButton);
	}
	public String getResponsePageText1()
	{
		return driver.findElement(SuccessFormTitle).getText();
	}
	public String getResponsePageText2()
	{
		return driver.findElement(SuccessFormTitle3).getText();
	}
}
