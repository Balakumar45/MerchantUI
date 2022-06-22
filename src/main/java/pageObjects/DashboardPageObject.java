package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPageObject{
	public WebDriver driver;
	
	private By LogoutDrpdown=By.xpath("//a[@class='dropdown-toggle']//i[@class='fa fa-caret-down']");
	private By LogoutBtn=By.xpath("//button[normalize-space()='Logout']");
	private By loginpagebtn=By.name("submit");
	
	public DashboardPageObject(WebDriver driver) {
		this.driver=driver;
	}
	
	public void clickLogoutdropdown()
	{
		driver.findElement(LogoutDrpdown).click();
	}
	public void ClickOnLogout()
	{
		driver.findElement(LogoutBtn).click();
	}
	public  void ClickOnLoginPageButton()
	{
		driver.findElement(loginpagebtn).click();
	}
	
	
	
	
	
	
	
	
	
}
