package com.saucecode.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.saucecode.base.SaucecodeBaseClass;

public class CheckoutTest extends SaucecodeBaseClass{
	@Test(priority=9)
	
	public void checkouttext()
	{
		String title=cop.getpagetitle();
		Assert.assertEquals(title, "Checkout:Your information");
	}
	@Test(priority=10)
public void checkoutaction()
{
	cop.enterinfo("Linta", "Simon", "12abc");
	cop.clickcontinue();
	cop.clickfinish();
}
	

}
