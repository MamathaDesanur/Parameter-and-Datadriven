package com.DataproviderTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Test.utility.Testutility;

public class HalfEbayTest {

	
WebDriver driver;

	@BeforeMethod
	public void Setproperties()
	{
		System.setProperty("webdriver.chrome.driver", "/Users/ajay/Downloads/chromedriver");      
       driver=new ChromeDriver();  
       driver.navigate().to("https:\\Halfebay.com");    
       driver.manage().window().maximize(); 
       //add wait
       driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);  
	}

	@DataProvider
	public Iterator<Object[]> getTestData() {
		ArrayList<Object[]> testData = Testutility.getDataFromExcel(); //call the getDataFromExcel() method from testUtility class (Testutility.getDataFromExcel();)   so it returns myData(its array list ) so store it in arraylist.
		return testData.iterator(); //iterater will return the value in sequence
	}
	
      
	@Test(dataProvider = "getTestData")
   public void halfebayTest(String firstname,String lastname,String address1,String address2,
		                    String city,String state,String zipcode,String emailaddress)
   {
		driver.findElement(By.xpath("//*[@id='firstname']")).clear();  //in the loop without clearing it enters text so need to clear it before entering another data
   		driver.findElement(By.xpath("//*[@id='firstname']")).sendKeys(firstname);
   		
   		driver.findElement(By.xpath("//*[@id='lastname']")).clear();
   		driver.findElement(By.xpath("//*[@id='lastname']")).sendKeys(lastname);
   		
   		driver.findElement(By.xpath("//*[@id='address1']")).clear();
   		driver.findElement(By.xpath("//*[@id='address1']")).sendKeys(address1);
   		
   		driver.findElement(By.xpath("//*[@id='address2']")).clear();
   		driver.findElement(By.xpath("//*[@id='address2']")).sendKeys(address2);
   		
   		driver.findElement(By.xpath("//*[@id='city']")).clear();
   		driver.findElement(By.xpath("//*[@id='city']")).sendKeys(city);
   		
   		Select select=new Select(driver.findElement(By.xpath("//*[@id='state']")));
   		select.selectByValue(state);
   		
   		driver.findElement(By.xpath("//*[@id='zipcode']")).clear();
   		driver.findElement(By.xpath("//*[@id='zipcode']")).sendKeys(zipcode);
   		
   		driver.findElement(By.xpath("//*[@id='emailaddress']")).clear();
   		driver.findElement(By.xpath("//*[@id='emailaddress']")).sendKeys(emailaddress);
   }
	
	@AfterMethod
	public void TearDown()
	{
	 driver.quit();
	}
	
}
