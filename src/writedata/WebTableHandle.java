package writedata;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.excel.utility.Xls_Reader;

public class WebTableHandle {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "/Users/ajay/Downloads/chromedriver");     
		WebDriver driver=new ChromeDriver();  
        driver.navigate().to("https://www.w3schools.com/html/html_tables.asp");

     
      //*[@id="customers"]/tbody/tr[2]/td[2]
      //*[@id="customers"]/tbody/tr[2]/td[1]
        String companyBeforxpath = "*[@id=\"customers\"]/tbody/tr[" ;
        String companyAfterxpath = "]/td[1]";
        String contactBeforxpath = "*[@id=\"customers\"]/tbody/tr[" ;
        String contactAfterxpath = "]/td[2]";
         
        
        
          //get the row count
          List<WebElement> rows= driver.findElements(By.xpath("//*[@id=\"customers\"]/tbody//tr"));
          System.out.println("total number of rows = " + rows.size());
          int rowcount = rows.size();
          
          //check if sheet exist if not create sheet ,columns
          Xls_Reader reader = new Xls_Reader("user/ajay/documents/workspace/"); //path of the excel sheet
          if(!reader.isSheetExist("TableData")) {
          reader.addSheet("TableData");
          reader.addColumn("TableData", "companyname1");
          reader.addColumn("TableData", "contactname1");
          }
         
            for(int i=2;i<=rowcount;i++) {
        	String CompanyActualPath=companyBeforxpath+i+companyAfterxpath;
        	String  Companyname= driver.findElement(By.xpath(CompanyActualPath)).getText();
        	System.out.println(Companyname);
        	reader.setCellData("TableData", Companyname, i, Companyname);
        	
        	
        	String CompanyActualPath1=contactBeforxpath+i+contactAfterxpath;
        	String  contactname= driver.findElement(By.xpath(CompanyActualPath1)).getText();
        	System.out.println(contactname);
        	reader.setCellData("TableData", contactname, i, contactname);
        	
        }
	}

}
