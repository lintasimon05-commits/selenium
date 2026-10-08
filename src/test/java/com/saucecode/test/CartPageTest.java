package com.saucecode.test;


import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.saucecode.base.SaucecodeBaseClass;

public class CartPageTest extends SaucecodeBaseClass{
	
	@Test(priority=5)
	public void itemincart()
	{
		scp.cartbasket();
	}

	@Test(priority=6)
	public void textverify()
	{
		String actualtitle=scp.carttextverify();
		Assert.assertEquals(actualtitle, "Your Cart");
	}
	@Test(priority=8)
	public void buttonenable()
	{
		scp.remove();
	}
	@Test(priority=7)
	public void buttonlist() 
	{
	    List<WebElement> buttons = scp.getButtonList();
	    System.out.println("Total buttons: " + buttons.size());
	}
	@Test(priority=9)
	public void checkoutbutton()
	{
		scp.checkout();
	}
	

}
