package MerchantUI;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LoginPageObject;
import pageObjects.SignUpPageObject;
import resources.XLUtils;
import resources.base;

public class SignupPage extends base {
	public WebDriver driver;
	public SignUpPageObject spg;
	public LoginPageObject lpg;	
	
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
	
	@Test(priority=1)
	public void SignUpFormTitleValidation()
	{
		lpg= new LoginPageObject(driver);
		lpg.ClickSignUpButton();
		spg= new SignUpPageObject(driver);
		String ActualText=spg.getFormHeading();
		String ExpectedText="Sign up to create an account with us";
		String TestName="SignUp Form Title";
		TextCompare(ExpectedText,ActualText,TestName);
	}
	
	@Test(priority=2)
	public void AlreadyUserTextValidation()
	{
		lpg= new LoginPageObject(driver);
		lpg.ClickSignUpButton();
		spg= new SignUpPageObject(driver);
		String ActualText=spg.getAlreadyUserText();
		String ExpectedText="Already a user?";
		String TestName="Already User Text";
		TextCompare(ExpectedText,ActualText,TestName);
	}
	
	@Test(priority=3)
	public void IsPartnerLogoDisplayed() {
		
		lpg= new LoginPageObject(driver);
		lpg.ClickSignUpButton();
		spg= new SignUpPageObject(driver);
		if(spg.getPartnerLogo().isDisplayed())
		{
			log.debug("Partner logo is displayed in SignUp page");
			Assert.assertTrue(true);			
		}
		else
		{
			log.error("Partner logo is not Uploaded in SignUp page..");
			Assert.assertTrue(false);
		}
	}
	
	@Test(priority=4)
	public void CheckingForBrokenLink() throws InterruptedException, IOException {
		lpg= new LoginPageObject(driver);
		lpg.ClickSignUpButton();
		spg= new SignUpPageObject(driver);
		List<WebElement> listElements=spg.getAllLinks();
		for(int i=0;i<listElements.size();i++) {
			WebElement Element=listElements.get(i);
			String url=Element.getAttribute("href");
			URL link=new URL(url);
			HttpURLConnection httpConn=(HttpURLConnection) link.openConnection();
			Thread.sleep(2000);
			httpConn.connect();
			int ResponseCode=httpConn.getResponseCode();
			if(ResponseCode>=400)
			{
				log.error(url+" - "+"is broken link");
				Assert.assertTrue(false);
			}
			else
			{
				log.debug(url+" - "+"is valid link");
				Assert.assertTrue(true);
			}
		}
	}
	
	@Test(dataProvider="InvalidSignUpData",priority=6)
	public void SignUpWithInvalidCredentials(
			String Username,
			String Password,
			String ConfirmPassword,
			String OrganizationName,
			String SiteURL,
			String Country,
			String SupportNumber,
			String EmailAddress,
			String ContactPerson,
			String TelephoneNo,
			String TestName,
			String ExpectedResult		
			) throws InterruptedException
	{
		lpg= new LoginPageObject(driver);
		lpg.ClickSignUpButton();
		spg= new SignUpPageObject(driver);
		spg.getSignUpUname().sendKeys(Username);
		spg.getSignUpPass().sendKeys(Password);
		spg.getCnfrmPass().sendKeys(ConfirmPassword);
		spg.getOrgName().sendKeys(OrganizationName);
		spg.getSiteUrl().sendKeys(SiteURL);
		Select dropdown=new Select(spg.getCountryDrpdown());
		dropdown.selectByVisibleText(Country);
		//spg.getSupportNum().click();
		spg.getSupportNum().sendKeys("9866781567");
		spg.getCntEmailAdd().sendKeys(EmailAddress);
		spg.getCntPrsnName().sendKeys(ContactPerson);
		spg.getCntTelNum().sendKeys(TelephoneNo);
		spg.ClickCheckBox();
		spg.CLickSubmitbutton();
		spg.ClickAlertNoButton();
		String ActualErrorMessage=spg.getSubimtErrorMessage();
		TextCompare(ActualErrorMessage,ExpectedResult,TestName);
	}
		
		@DataProvider(name="InvalidSignUpData")
		public String[][] getInvalidTestData() throws IOException
		{
			String path=System.getProperty("user.dir")+"\\src\\main\\java\\resources\\TestData.xlsx";
			int rowcount=XLUtils.getRowCount(path,"InvalidSignUp");
			int colcount=XLUtils.getCellCount(path,"InvalidSignUp",1);
			
			String SignUpInvalidData[][]=new String[rowcount][colcount];
			
			for(int i=1;i<=rowcount;i++)
			{
				for(int j=0;j<colcount;j++)
				{
					SignUpInvalidData[i-1][j]=XLUtils.getCellData(path,"InvalidSignUp", i, j);
				}
			}
			return SignUpInvalidData;
		
	    }
	}
