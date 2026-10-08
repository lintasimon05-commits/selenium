package com.saucecode.page;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class SauceLoginPage {
	
	WebDriver driver;
	
	@FindBy(id="user-name")
	WebElement loginuser;
	
	@FindBy(id="password")
	WebElement loginpass;
	
	@FindBy(id="login-button")
	WebElement loginbutton;
	
	
	public SauceLoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void SetValues(String username, String password)
	{
		loginuser.sendKeys(username);
		loginpass.sendKeys(password);
	}
	
	public void login()
	{
		loginbutton.click();
	}
	
	
	
	
	public String titleverify()
	{
		return driver.getTitle();
	}

}
