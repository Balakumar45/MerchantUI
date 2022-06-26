package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignUpPageObject {
	public WebDriver driver;
	
	private By FormHeading=By.cssSelector("p[align='center']");
	private By SignUpUname=By.cssSelector("input[placeholder='Username or Email*']");
	private By SignUpPass=By.id("passwd");
	private By CnfrmPass=By.id("conpasswd");
	private By OrgName=By.cssSelector("[placeholder='Organisation Name*']");
	private By SiteUrl=By.xpath("//input[@placeholder='Site URL*']");
	private By CountryDrpdown=By.id("country");
	private By Phonecc=By.id("phonecc");
	private By SupportNum=By.cssSelector("input[placeholder='Support Number*']");
	private By CntEmailAdd=By.cssSelector("input[placeholder='Contact Email Address*']");
	private By CntPrsnName=By.cssSelector("input[placeholder='Contact Person's Name*']");
	private By CntTelNum=By.cssSelector("input[placeholder='Contact Telephone Number*']");
	private By ChckBoxBtn=By.id("check");
	private By SbmtBoxBtn=By.id("btnSubmit");
	private By Loginlink=By.linkText("Log In");
	private By AlreadyUserTxt=By.cssSelector(".loginLabel']");
	private By ChckBoxMsg=By.cssSelector("div[class='form-group'] b");
	private By AlertNoButton=By.id("noSubmit");
	private By Message=By.xpath("//*[@id=\"log_alignsign\"]/table/tbody/tr[2]/td/font");
	private By PartnerLogo=By.xpath("/html/body/div[1]/div/div/div/div/a/img");
	private By AlreadyUser=By.cssSelector(".loginLabel");
	private By Links=By.tagName("a");
	
	public SignUpPageObject(WebDriver driver) {
		this.driver=driver;
	}
	public String getFormHeading()
	{
		return driver.findElement(FormHeading).getText();
	}
	public WebElement getSignUpUname()
	{
		return driver.findElement(SignUpUname);
	}
	public WebElement getSignUpPass()	
	{
		return driver.findElement(SignUpPass);
	}
	public WebElement getCnfrmPass()
	{
		return driver.findElement(CnfrmPass);
	}
	public WebElement getOrgName()
	{
		return driver.findElement(OrgName);
	}
	public WebElement getSiteUrl()
	{
		return driver.findElement(SiteUrl);
	}
	public WebElement getCountryDrpdown()
	{
		return driver.findElement(CountryDrpdown);
	}
	public WebElement getPhonecc()
	{
		return driver.findElement(Phonecc);
	}
	public WebElement getSupportNum()
	{
		return driver.findElement(SupportNum);
	}
	public WebElement getCntEmailAdd()
	{
		return driver.findElement(CntEmailAdd);
	}
	public WebElement getCntPrsnName()
	{
		return driver.findElement(CntPrsnName);
	}
	public WebElement getCntTelNum()
	{
		return driver.findElement(CntTelNum);
	}
	public void ClickCheckBox()
	{
		driver.findElement(ChckBoxBtn).click();
	}
	public void CLickSubmitbutton()
	{
		driver.findElement(SbmtBoxBtn).click();
	}
	public WebElement getLoginlink()
	{
		return driver.findElement(Loginlink);
	}
	public WebElement getAlreadyUserTxt()
	{
		return driver.findElement(AlreadyUserTxt);
	}
	public String getChckBoxMsg()
	{
		return driver.findElement(ChckBoxMsg).getText();
	}
	public void ClickAlertNoButton()
	{
		driver.findElement(AlertNoButton).click();
	}
	public String getSubimtErrorMessage()
	{
		return driver.findElement(Message).getText();
	}
	public WebElement getPartnerLogo()
	{
		return driver.findElement(PartnerLogo);
	}
	public String getAlreadyUserText()
	{
		return driver.findElement(AlreadyUser).getText();
	}
	public List<WebElement> getAllLinks()
	{
		return driver.findElements(Links);
	}
	
	
}
