package com.datadrivenTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.excel.utility.Xls_Reader;

public class DataDrivenparameterize {

	public static void main(String[] args) {
		
		//prepare the webdriver
		System.setProperty("webdriver.chrome.driver", "/Users/ajay/Downloads/chromedriver");     
		WebDriver driver=new ChromeDriver();  
        driver.navigate().to("https;//ebay.com/rigisterpage");
        
		//get the data from excel sheet.

	       //create an object xls_reader
	        Xls_Reader reader= new Xls_Reader("user/ajay/documents/workspace/"); //pass the  created excel file path 
	        int rowCount= reader.getRowCount("RegtestData"); //gives the row count of  
	        //write the data into excel sheet here create status column
	        reader.addColumn(RegtestData, status);  //adding column
	        reader.addSheet(LoginData);     //adding sheet
	        
	        
	        
	       //parameterizatation using for loop 		
	       for(int rowNum = 2;rowNum<=rowCount; rowNum++)
	       {
	    	   String firstname=reader.getCellData("RegtestData", "firstname", rowNum);  //gives the second row first column value
	   		System.out.println(firstname);
	   		
	   		String lastname=reader.getCellData("RegtestData", "lastname", rowNum);  //gives the second row second column value
	   		System.out.println(lastname);
	   		
	   		String address1=reader.getCellData("RegtestData", "address1", rowNum);  //gives the second row third column value
	   		System.out.println(address1);
	   		
	   		String address2=reader.getCellData("RegtestData", "address2", rowNum);  //gives the second row forth column value
	   		System.out.println(address2);
	   		
	   		String city=reader.getCellData("RegtestData", "city", rowNum);  //gives the second row fifth column value
	   		System.out.println(city);
	   		
	   		String state=reader.getCellData("RegtestData", "state", rowNum);  //gives the second row sixth column value
	   		System.out.println(state);
	   		 
	   		String zipcode=reader.getCellData("RegtestData", "zipcode", rowNum);  //gives the second row seventh column value
	   		System.out.println(zipcode);
	   		
	   		String emailaddress=reader.getCellData("RegtestData", "emailaddress", rowNum);  //gives the second row eight column value
	   		System.out.println(emailaddress);
	   	
	   		//enter data
	   		driver.findElement(By.xpath("//*[@id='firstname']")).clear();  //in the loop withot clearing it enters text so need to clear it before entering another data
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
	   		
	   		
	   		reader.setCellData(lastname, "status", rowNum, "pass");  //write data		
	   }	
	}

}
