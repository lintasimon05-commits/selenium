package com.saucecode.test;

import org.testng.annotations.Test;



import org.openqa.selenium.support.ui.ExpectedConditions;

import org.testng.Assert;

import com.saucecode.base.SaucecodeBaseClass;

public class SauceLoginTest extends SaucecodeBaseClass{
	
	@Test(priority=0)
	public void titleverification()
	{
		String actualtitle=lp.titleverify();
		Assert.assertEquals(actualtitle, "Swag Labs");
	}

	@Test(priority=1)
	public void validlogin()
	{
		lp.SetValues("standard_user", "secret_sauce");
		lp.login();
		wait.until(ExpectedConditions.urlContains("inventory.html"));
	}
	

	
}
