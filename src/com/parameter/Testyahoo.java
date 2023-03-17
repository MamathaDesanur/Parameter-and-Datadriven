package com.parameter;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Testyahoo {
	
	
	WebDriver driver;

	
	@BeforeMethod
	@Parameters({"url"})
	public void Setproperties(String url)
	{
		System.setProperty("webdriver.chrome.driver", "/Users/ajay/Downloads/chromedriver");  
        
        // Instantiate a ChromeDriver class.     
       driver=new ChromeDriver(); 
      
      // Launch Website  
       driver.navigate().to(url);  
     //Maximize the browser  
       driver.manage().window().maximize(); 
       //add wait
       driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);  
	}
	
      
	@Test
	@Parameters({"emailid"})
   public void YahooLoginTest(String emailid)
   {
		driver.findElement(By.xpath("//*[@id=\"login-username\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"login-username\"]")).sendKeys(emailid);	
		driver.findElement(By.xpath("//*[@id=\"login-signin\"]")).click();
   }
	
	@AfterMethod
	public void TearDown()
	{
	 driver.quit();
	}
	
	
	
	
	
}
