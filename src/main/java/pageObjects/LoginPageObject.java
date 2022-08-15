package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageObject {
	public WebDriver driver;
	
	private By Username=By.name("username");
	private By Password=By.id("password");
	private By Submit=By.id("submit");
	private By PartnerLogo=By.xpath("//a[@title='paymentz']//img");
	private By PCImg=By.xpath("//img[@src='/merchant/images/pci_dss_logo.png']");
	private By FrgotPass=By.linkText("Forgot your password?");
	private By SignUpLftTxt=By.cssSelector(".NewPlatformLabel");
	private By SignUpbtn=By.linkText("Sign Up");
	private By LoginFormTitle=By.cssSelector(".login-title");
	private By ErrMsg=By.xpath("//td[@class='text']");
	private By Links=By.tagName("a");
	
	public LoginPageObject(WebDriver driver) {
		this.driver=driver;
	}
	public WebElement getUsername()
	{
		return driver.findElement(Username);
	}
	public WebElement getPassword()
	{
		return driver.findElement(Password);
	}
	public void ClickSubmitButton()
	{
		driver.findElement(Submit).click();
	}
	public WebElement PatnerLogoImage()
	{
		return driver.findElement(PartnerLogo);
	}
	public WebElement PCILogo()
	{
		return driver.findElement(PCImg);
	}
	public void ClickOnForgotPassword()
	{
		driver.findElement(FrgotPass).click();
	}
	public WebElement getSignUpLftTxt()
	{
		return driver.findElement(SignUpLftTxt);
	}
	public void ClickSignUpButton()
	{
		driver.findElement(SignUpbtn).click();
	}
	public WebElement getLoginFormTitle()
	{
		return driver.findElement(LoginFormTitle);
	}
	public WebElement getErrMsg()
	{
		return driver.findElement(ErrMsg);
	}
	public List<WebElement> getAllLinks()
	{
		return driver.findElements(Links);
	}
}
