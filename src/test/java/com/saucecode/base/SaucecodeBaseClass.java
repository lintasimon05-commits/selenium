package com.saucecode.base;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.saucecode.page.CheckoutPage;
import com.saucecode.page.SauceCartPage;
import com.saucecode.page.SauceInventoryPage;
import com.saucecode.page.SauceLoginPage;


public class SaucecodeBaseClass {
	
	public static WebDriver driver;
	public static WebDriverWait wait;
	
	public static ExtentSparkReporter reporter;
	public static ExtentTest test;
	public static ExtentReports extent;

	
	public SauceLoginPage lp;
	public SauceInventoryPage sp;
	public SauceCartPage scp;
	public CheckoutPage cop;
	
	@BeforeTest
	public void setup()
	{
		reporter=new ExtentSparkReporter("./Reports/swagreport.html");
		reporter.config().setDocumentTitle("Automation Report");
		reporter.config().setReportName("Functional Test");
		reporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("hostname", "localhost");
		extent.setSystemInfo("os", "macOS");
		extent.setSystemInfo("testername", "Linta");
		extent.setSystemInfo("Browser name", "Chrome");
		ChromeOptions options=new ChromeOptions();
		//Incoginto
		
		options.addArguments("---------Incoginto");
		driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com");
	}
  
	@BeforeMethod
	public void initializepages(Method mthd)
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		lp=new SauceLoginPage(driver);
		sp=new SauceInventoryPage(driver);
		scp=new SauceCartPage(driver);
		cop=new CheckoutPage(driver);
		test=extent.createTest(mthd.getName());
		
	}
	
	@AfterTest
	public void teardown()
	{
		extent.flush();
	}
	
	@AfterMethod
	public void browserclose(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			test.log(Status.FAIL, "Test case failed is " +result.getName());
			test.log(Status.FAIL, "Test case failed is " +result.getThrowable());
			//String screenshotpath=screenshotMethod(driver, result.getName());//previous run test name is getting using getname
			//test.addScreenCaptureFromPath(screenshotpath);
			
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			test.log(Status.SKIP, "Test case skipped is " +result.getName());
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.PASS, "Test case passed is " +result.getName());
		}
	}
	
}
