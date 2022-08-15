package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class base {
	public static WebDriver driver;
	public static Logger log=LogManager.getLogger(base.class.getName());
	public String URL;
	public Properties prop;
	public WebDriver initializeDriver() throws IOException
	{
		prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		//String browserName=System.getProperty("browser");
		//String EnvSelected=System.getProperty("Environment");
		String browserName=prop.getProperty("browser");
		String EnvSelected=prop.getProperty("Environment");
		if(browserName.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Driver\\chromedriver.exe");
			driver=new ChromeDriver();
			log.debug("Test Initiated in Chrome Browser");
			
		}
		else if(browserName.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\Driver\\geckodriver.exe");
			driver=new FirefoxDriver();
			log.debug("Test Initiated in Firefox Browser");
		}
		/*else if(browserName=="opera")
		{
			System.setProperty("webdriver.opera.driver", System.getProperty("user.dir")+"\\Driver\\operadriver.exe");
			driver=new OperaDriver();
		}*/
		else if(browserName.equals("Edge"))
		{
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"\\Driver\\msedgedriver.exe");
			driver = new EdgeDriver();
			log.debug("Test Initiated in Edge Browser");
		}
		else
		{
			System.out.println("We don't support for your browser...");
			log.error("Browser is not Identified");
		}
		if(EnvSelected.equals("Staging"))
		{
			URL="https://staging.paymentz.com/merchant/index.jsp?partnerid=1&fromtype=paymentz";
			log.debug("Test running on Staging Environment");
		}
		else if(EnvSelected.equals("Preprod"))
		{
			URL="https://preprod.paymentz.com/merchant/index.jsp?partnerid=1&fromtype=paymentz";
			log.debug("Test running on Preprod Environment");
		}
		else if(EnvSelected.equals("DSG"))
		{
			URL="https://test.seversent.com/merchant/index.jsp?fromtype=DSG&partnerid=1";
			log.debug("Test running on DSG Test Environment");
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
		}
		
	
	public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException{
	
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyy_hh_mm_ss");
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+formater.format(calendar.getTime())+".png";
		FileUtils.copyFile(source,new File(destinationFile));
		return destinationFile;
		}
	
	public void TextCompare(String ExpectedText, String ActualText, String Test){
		
		log.debug("Validating "+Test);
		if(ActualText.contentEquals(ExpectedText))
		{
			log.debug(Test+" is as per Expected.");
			Assert.assertTrue(true);
		}
		else
		{
			log.error(Test+" Validation Failed.");
			Assert.assertTrue(false);
		}
	}
}
