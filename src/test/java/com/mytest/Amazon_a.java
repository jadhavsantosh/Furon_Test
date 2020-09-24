package com.mytest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.test.utlis.TestUtility;

public class Amazon_a {
	WebDriver driver;

	@BeforeMethod
	@Parameters({"browser"})
	
	public void setUp(String browser) {
		if(browser.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\pratmesh\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		}
		else if (browser.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","C:\\Users\\pratmesh\\Downloads\\chromedriver_win32\\geckodriver.exe");
			driver=new FirefoxDriver();
			
		}
		
	}
	
	@DataProvider
	public Iterator<Object[]> getTestData()
	{
		ArrayList<Object[]> testData = TestUtility.getDataFromExcel();
		return testData.iterator();
		
	}
	
	@Test(dataProvider="getTestData")
	public void AmazonRegistertest(String Name,String Mobile,String email,String password)
	{
		
		
		driver.findElement(By.xpath("//span[text()='Hello, Sign in']")).click();
		driver.findElement(By.xpath("//a[@id='createAccountSubmit']")).click();
		driver.findElement(By.xpath("//input[@id='ap_customer_name']")).sendKeys(Name);
		driver.findElement(By.xpath("//input[@id='ap_phone_number']")).sendKeys(Mobile);
		driver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='continue']")).click();
		
	}
	/*@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}*/
}
