package com.saucecode.page;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SauceCartPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(xpath="//*[@id=\"header_container\"]/div[2]/span")
	WebElement carttext;
	
	@FindBy(xpath="//*[@id=\"shopping_cart_container\"]/a")
	WebElement carticon;
	
	@FindBy(xpath="//*[@id=\"remove-sauce-labs-backpack\"]")
	WebElement removebutton;
	
	@FindBy(tagName="button")
	List<WebElement>allButton;
	
	@FindBy(xpath="//*[@id=\"checkout\"]")
	WebElement checkoutbutton;
	
	
	public SauceCartPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver,Duration.ofSeconds(30));
        //wait.until(ExpectedConditions.visibilityOf(carttext));
	}
	
	public void cartbasket()
	{
		carticon.click();
	}
	public String carttextverify()
	{
		return driver.getPageSource();
	}
	
	public void remove()
	{
		boolean isEnabled=removebutton.isEnabled();
		if(isEnabled)
		{
			System.out.println("Remove button is enabled");
		}else
		{
			System.out.println("Remove button is disabled");
		}
	}
		
	public List<WebElement> getButtonList()
	{
	    return allButton;
	}
	
	public void checkout()
	{
		checkoutbutton.click();
	}
		
	}
	


