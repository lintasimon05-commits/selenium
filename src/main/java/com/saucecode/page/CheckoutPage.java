package com.saucecode.page;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {

	
	WebDriver driver;
	WebDriverWait wait;
	
	//@FindBy(xpath="//*[@id=\"header_container\"]/div[2]/span")
	//WebElement pagetitle;
	
	@FindBy(id="first-name")
	WebElement firstname;
	
	@FindBy(id="last-name")
	WebElement lastname;
	
	@FindBy(id="postal-code")
	WebElement postalcode;
	
	@FindBy(id="continue")
	WebElement continuebutton;
	
	@FindBy(id="finish")
	WebElement finishbutton;
	
	public CheckoutPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
       // wait.until(ExpectedConditions.visibilityOf(pagetitle));
        
	}
	public String getpagetitle()
	{
		return driver.getPageSource();
	}
	public void enterinfo(String fname,String lname, String zipcode)
	{
		firstname.sendKeys(fname);
		lastname.sendKeys(lname);
		postalcode.sendKeys(zipcode);
	}
	
	public void clickcontinue()
	{
		continuebutton.click();
	}
	
	public void clickfinish()
	{
		finishbutton.click();
	}
}
