package MerchantUI;

import java.io.IOException;
import java.util.List;
import java.net.HttpURLConnection;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.DashboardPageObject;
import pageObjects.LoginPageObject;
import resources.XLUtils;
import resources.base;

public class LoginPage extends base {
	public WebDriver driver;
	public LoginPageObject lpg;	
	public DashboardPageObject dpg; 
	
	@BeforeTest
	public void beforeTestExec() throws IOException
	{
		driver=initializeDriver();
		log.info("Driver is initialized");
		driver.get(URL);
		log.info("Navigated to Desired URL");
	}
	
	@Test(priority=1)
	public void loginFormTitleValidation()
	{
		lpg= new LoginPageObject(driver);
		String ActualText=lpg.getLoginFormTitle().getText();
		String ExpectedText="Login to Test Merchant Account";
		log.debug("Validating Login Form Title..");
		Assert.assertEquals(ActualText, ExpectedText);
		log.info("Login Form Title is as per Expected.");
		
	}
	
	@Test(priority=2)
	public void IsPartnerLogoDisplayed() {
		
		lpg= new LoginPageObject(driver);
		if(lpg.PatnerLogoImage().isDisplayed())
		{
			Assert.assertTrue(true);
			log.debug("Partner logo is displayed in login page");
		}
		else
		{
			Assert.assertTrue(false);
			log.error("Partner logo is not Uploaded..");
		}
	}
	
	@Test(priority=8)
	public void IsPCILogoDisplayed() {
		
		lpg= new LoginPageObject(driver);
		if(lpg.PCILogo().isDisplayed())
		{
			Assert.assertTrue(true);
			log.debug("PCI logo is displayed in login page");
		}
		else
		{
			Assert.assertTrue(false);
			log.error("PCI logo is not Uploaded..");
		}
	}
	
	@Test
	public void CheckingForBrokenLink() throws InterruptedException, IOException {
		lpg= new LoginPageObject(driver);
		List<WebElement> listElements=lpg.getAllLinks();
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
				log.info(url+" - "+"is valid link");
				Assert.assertTrue(true);
			}
		}
	}
	
	
	@Test(priority=3)
	public void ValidLoginAttempt() throws InterruptedException {
		
		lpg= new LoginPageObject(driver);
		lpg.getUsername().sendKeys(prop.getProperty("Username"));
		lpg.getPassword().sendKeys(prop.getProperty("Password"));
		lpg.ClickSubmitButton();
		String ExpectedURL="https://staging.paymentz.com/merchant/servlet/Login?";
		String ActualURL=lpg.driver.getCurrentUrl();
		
		if(ActualURL.contains(ExpectedURL))
		{
			Assert.assertTrue(true);
			log.debug("Test Login passed");
		}
		else 
		{
				Assert.assertTrue(false);
		}
		dpg= new DashboardPageObject(driver);
		dpg.clickLogoutdropdown();
		dpg.ClickOnLogout();
		dpg.ClickOnLoginPageButton();
		
		
	}
	
	@Test(dataProvider="InvalidLoginData",priority=4)	
	public void InvalidLoginAttempts(String Username,String Password, String Text) throws IOException 
	{
			
		lpg= new LoginPageObject(driver);
		
		lpg.getUsername().sendKeys(Username);
		
		lpg.getPassword().sendKeys(Password);
		
		lpg.ClickSubmitButton();
		
		String ActualErrorMessage=lpg.getErrMsg().getText();
		
		String ExpectedErrorMessage="*Invalid Credentials.";
		
		log.debug("Validating Invalid Login Error Text with "+Text);
		
		if(ActualErrorMessage.equalsIgnoreCase(ExpectedErrorMessage))
		{
			log.info(Text+" TestCase Passed");
		}
		else
		{
			log.error(Text+" TestCase Failed");
		}
		}
	
	@DataProvider(name="InvalidLoginData")
	public String[][] getInvalidTestData() throws IOException
	{
		String path=System.getProperty("user.dir")+"\\src\\main\\java\\resources\\TestData.xlsx";
		int rowcount=XLUtils.getRowCount(path,"Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);
		
		String LoginInvalidData[][]=new String[rowcount][colcount];
		
		for(int i=1;i<=rowcount;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				LoginInvalidData[i-1][j]=XLUtils.getCellData(path,"Sheet1", i, j);
			}
		}
		return LoginInvalidData;
	}		
	
	@AfterTest
	public void CloseBrowser()
	{
		driver.close();	
	}
	
	

}
