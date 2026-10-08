package com.saucecode.test;

import org.testng.annotations.Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.saucecode.base.SaucecodeBaseClass;

public class InventoryTest extends SaucecodeBaseClass{
	
	
	
  @Test(priority=2)
  public void textverify()
  {
	  String actualtitle=sp.inventorytextverify();
	  Assert.assertEquals(actualtitle, "Products");
	  
  }
  
  @Test(priority=4)
  public void itemtocart()
  
  {
	  sp.productsortfilter();
	  sp.addtocart();
	  sp.cart();
	  
	  sp.itemname();
	  
	  
  }

  @Test(priority=3)
  public void linkcount()
  {
	 //
	  List<WebElement> linklist=driver.findElements(By.tagName("a"));
	  int actualcount=linklist.size();
	  int expectedcount=30;
	  System.out.println("Total number of links" + actualcount);
	  Assert.assertEquals(actualcount, expectedcount, "Link count mismatch");
	  
	  
  }
}
