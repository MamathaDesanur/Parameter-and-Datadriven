package com.datadrivenTest;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.excel.utility.Xls_Reader;

public class DataDrivenTest {
 
	//this program can fill get the data from excel sheet and fill one form.
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/ajay/Downloads/chromedriver");     
		WebDriver driver=new ChromeDriver();  
        driver.navigate().to("https;//ebay.com/rigisterpage"); 
	   
        //get the data from excel sheet.

       //create an object xls_reader
        Xls_Reader reader= new Xls_Reader("user/ajay/documents/workspace/"); //pass the excel file path 
		
        String firstname=reader.getCellData("RegtestData", "firstname", 2);  //gives the second row first column value
		System.out.println(firstname);
		
		String lastname=reader.getCellData("RegtestData", "lastname", 2);  //gives the second row second column value
		System.out.println(lastname);
		
		String address1=reader.getCellData("RegtestData", "address1", 2);  //gives the second row third column value
		System.out.println(address1);
		
		String address2=reader.getCellData("RegtestData", "address2", 2);  //gives the second row forth column value
		System.out.println(address2);
		
		String city=reader.getCellData("RegtestData", "city", 2);  //gives the second row fifth column value
		System.out.println(city);
		
		String state=reader.getCellData("RegtestData", "state", 2);  //gives the second row sixth column value
		System.out.println(state);
		 
		String zipcode=reader.getCellData("RegtestData", "zipcode", 2);  //gives the second row seventh column value
		System.out.println(zipcode);
		
		String emailaddress=reader.getCellData("RegtestData", "emailaddress", 2);  //gives the second row eight column value
		System.out.println(emailaddress);
	
		//prepare the webdriver
		
		driver.findElement(By.xpath("//*[@id='firstname']")).sendKeys(firstname);
		driver.findElement(By.xpath("//*[@id='lastname']")).sendKeys(lastname);
		driver.findElement(By.xpath("//*[@id='address1']")).sendKeys(address1);
		driver.findElement(By.xpath("//*[@id='address2']")).sendKeys(address2);
		driver.findElement(By.xpath("//*[@id='city']")).sendKeys(city);
		
		Select select=new Select(driver.findElement(By.xpath("//*[@id='state']")));
		select.selectByValue(state);
		driver.findElement(By.xpath("//*[@id='zipcode']")).sendKeys(zipcode);
		driver.findElement(By.xpath("//*[@id='emailaddress']")).sendKeys(emailaddress);
		
	}

}
