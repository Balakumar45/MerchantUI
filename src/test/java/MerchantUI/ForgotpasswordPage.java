package MerchantUI;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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
	public void IsPartnerLogoDisplayed() {
		
		lpg= new LoginPageObject(driver);
		lpg.ClickOnForgotPassword();
		fpg= new ForgotPasswordPageObject(driver);
		if(fpg.PatnerLogoImage().isDisplayed())
		{
			Assert.assertTrue(true);
			log.debug("Partner logo is displayed in login page");
		}
		else
		{
			Assert.assertTrue(false);
			log.error("Partner logo is not Uploaded in login page..");
		}
	}
	
	@Test(priority=2)
	public void FormInstructionTextValidation1()
	{
		lpg= new LoginPageObject(driver);
		lpg.ClickOnForgotPassword();
		fpg= new ForgotPasswordPageObject(driver);
		String ActualText=fpg.getWarningText1();
		String ExpectedText="Please fill in your username. An email will be sent to you containing a new password.";
		String TestName="Form Instruction 1 Test";
		TextCompare(ExpectedText,ActualText,TestName);
	}
	
	@Test(priority=3)
	public void FormInstructionTextValidation2()
	{
		lpg= new LoginPageObject(driver);
		lpg.ClickOnForgotPassword();
		fpg= new ForgotPasswordPageObject(driver);
		String ActualText=fpg.getWarningText2();
		String ExpectedText="Please fill in your username. An email will be sent to you containing a new password.";
		String TestName="Form Instruction 2 Test";
		TextCompare(ExpectedText,ActualText,TestName);
	}
	
	@Test(priority=4)
	public void UsernameTextFieldNameValidation()
	{
		lpg= new LoginPageObject(driver);
		lpg.ClickOnForgotPassword();
		fpg= new ForgotPasswordPageObject(driver);
		String ActualText=fpg.getUsernameFieldText();
		String ExpectedText="Username or Email:";
		String TestName="Username Text Field value validation";
		TextCompare(ExpectedText,ActualText,TestName);
	}
	
	@Test(priority=5)
	public void SendMailButtonTextValidation()
	{
		lpg= new LoginPageObject(driver);
		lpg.ClickOnForgotPassword();
		fpg= new ForgotPasswordPageObject(driver);
		String ActualText=fpg.getSubmitButton().getText().trim();
		String ExpectedText="Send Mail";
		String TestName="Submit button Text Validation";
		TextCompare(ExpectedText,ActualText,TestName);
	}
	
	@Test(priority=6)
	public void LoginButtonTextValidation()
	{
		lpg= new LoginPageObject(driver);
		lpg.ClickOnForgotPassword();
		fpg= new ForgotPasswordPageObject(driver);
		String ActualText=fpg.getLoginButton().getText().trim();
		String ExpectedText="Log In";
		String TestName="Login button Text Validation";
		TextCompare(ExpectedText,ActualText,TestName);
	}
	
	@Test(priority=7)
	public void ForgotPasswordCheck()
	{
		lpg= new LoginPageObject(driver);
		lpg.ClickOnForgotPassword();
		fpg= new ForgotPasswordPageObject(driver);
		fpg.getUsernameField().sendKeys("VinayakM1");
		fpg.getSubmitButton().click();
		String ActualText1=fpg.getResponsePageText();
		String ActualText2=fpg.getResponsePageText1();
		String ActualText3=fpg.getResponsePageText2();
		String ExpectedText="Your temporary password has been sent to you by email to your mailing address set on our server. Please use the login and password to logon to the paymentz System within one hour.";
		String TestName="Forgot Password Functionality";
		TextCompare(ExpectedText,ActualText1,TestName);
	}
	
	@Test(priority=8)
	public void LoginButtonFunctionalityCheck()
	{
		lpg= new LoginPageObject(driver);
		lpg.ClickOnForgotPassword();
		fpg= new ForgotPasswordPageObject(driver);
		fpg.getLoginButton().click();
		String CurrentURL=driver.getCurrentUrl();
		String ExpectedURL=URL;
		String TestName="LoginButton Redirection Test";
		TextCompare(CurrentURL,ExpectedURL,TestName);
		
	}

	
	
}
