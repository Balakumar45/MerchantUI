package MerchantUI;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.ForgotPasswordPageObject;
import pageObjects.LoginPageObject;
import resources.base;

public class ForgotpasswordPage extends base {
	public WebDriver driver;
	public LoginPageObject lpg;
	public ForgotPasswordPageObject fpg;
	
	@BeforeTest
	public void beforeTestExec() throws IOException
	{
		driver=initializeDriver();
		log.info("Driver is initialized");
		driver.get(URL);
		log.info("Navigated to Desired URL");
	}
	@AfterTest
	public void CloseBrowser()
	{
		driver.close();	
	}
	
	@Test(priority=0)
	public void ForgotPasswordTitleValidation()
	{
		lpg= new LoginPageObject(driver);
		lpg.ClickOnForgotPassword();
		fpg= new ForgotPasswordPageObject(driver);
		String ActualText=fpg.getFormHeading();
		String ExpectedText="Forgot Password";
		String TestName="Forgot Password Form Title";
		TextCompare(ExpectedText,ActualText,TestName);
	}
	
	@Test(priority=1)
	public void ForgotPasswordCheck()
	{
		lpg= new LoginPageObject(driver);
		lpg.ClickOnForgotPassword();
		fpg= new ForgotPasswordPageObject(driver);
		fpg.getUsernameField().sendKeys("VinayakM1");
		fpg.getSubmitButton().click();
		String ActualText=fpg.getResponseText();;
		String ExpectedText="Your temporary password has been sent to you by email to your mailing address set on our server. Please use the login and password to logon to the paymentz System within one hour.";
		String TestName="Forgot Password Functionality";
		TextCompare(ExpectedText,ActualText,TestName);
	}
		

	
	
}
