package com.saucecode.page;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class SauceInventoryPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(className="inventory_item_name")
	WebElement backpackitem;
	
	@FindBy(xpath="//*[@id=\"add-to-cart-sauce-labs-backpack\"]")
	WebElement addcart;
	
	@FindBy(xpath="//*[@id=\"header_container\"]/div[2]/div/span/select")
	WebElement filter;
	
	@FindBy(id="shopping_cart_container")
	WebElement carticon;
	
	@FindBy(xpath="//*[@id='header_container']//span[@class='title']")
	WebElement pageheading;
	
	@FindBy(tagName="a")
	List<WebElement>allATags;
	
	
	public SauceInventoryPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver,Duration.ofSeconds(30));
	}

	public void itemname()
	{
		backpackitem.click();
	}
	public void addtocart()
	{
		addcart.click();
		
	}
	public void cart()
	{
		carticon.click();
	}
	
	public void productsortfilter()
	{
		//filter.click();
		Select lowprice=new Select(filter);
		lowprice.selectByValue("lohi");
		
	}
	public int getLinkCount()
	{
		return allATags.size();
	}
	public String inventorytextverify()
	{
		
		return pageheading.getText();
	}

}
