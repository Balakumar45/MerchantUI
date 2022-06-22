package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignUpPageObject {
	public WebDriver driver;
	
	private By FormHeading=By.xpath("//p[@align=\"center\"]");
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
	private By PrvcyPolcylink=By.linkText("Privacy Policy");
	private By Termlink=By.linkText("Terms of use.");
	private By Loginlink=By.linkText("Log In");
	private By AlreadyUserTxt=By.cssSelector(".loginLabel']");
	private By ChckBoxMsg=By.cssSelector("div[class='form-group'] b");
	
	public SignUpPageObject(WebDriver driver) {
		this.driver=driver;
	}
	public WebElement getFormHeading()
	{
		return driver.findElement(FormHeading);
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
	public WebElement getChckBoxBtn()
	{
		return driver.findElement(ChckBoxBtn);
	}
	public WebElement getSbmtBoxBtn()
	{
		return driver.findElement(SbmtBoxBtn);
	}
	public WebElement getPrvcyPolcylink()
	{
		return driver.findElement(PrvcyPolcylink);
	}
	public WebElement getTermlink()
	{
		return driver.findElement(Termlink);
	}
	public WebElement getLoginlink()
	{
		return driver.findElement(Loginlink);
	}
	public WebElement getAlreadyUserTxt()
	{
		return driver.findElement(AlreadyUserTxt);
	}
	public WebElement getChckBoxMsg()
	{
		return driver.findElement(ChckBoxMsg);
	}
	
}
