package com.Test.utility;

import java.util.ArrayList;

import com.excel.utility.Xls_Reader;

public class Testutility {
	static Xls_Reader reader;   //this is another utility imported
	
	
	//create a arrylist object bcoz that excel sheet returns a values so cannot keep it as void
	
	public static ArrayList<Object[]> getDataFromExcel() {
	
		     ArrayList<Object[]> myData = new ArrayList<Object[]>();
		     
		       try {
			        reader = new Xls_Reader("user/ajay/documents/workspace/"); //pass the  created excel file path
		           }catch(Exception e) {
		                   e.printStackTrace();
		           }
		       
		 for(int rowNum=2; rowNum <= reader.getRowCount("RegtestData"); rowNum++)
		 {
			    String firstname=reader.getCellData("RegtestData", "firstname", rowNum);  //gives the second row first column value
		   		String lastname=reader.getCellData("RegtestData", "lastname", rowNum);  //gives the second row second column value
		   		String address1=reader.getCellData("RegtestData", "address1", rowNum);  //gives the second row third column value
		   		String address2=reader.getCellData("RegtestData", "address2", rowNum);  //gives the second row forth column value
		   		String city=reader.getCellData("RegtestData", "city", rowNum);  //gives the second row fifth column value
		   		String state=reader.getCellData("RegtestData", "state", rowNum);  //gives the second row sixth column value
		   		String zipcode=reader.getCellData("RegtestData", "zipcode", rowNum);  //gives the second row seventh column value
		   		String emailaddress=reader.getCellData("RegtestData", "emailaddress", rowNum);  //gives the second row eight column value
		   	
		   		//store all the values into object array and send to myData
		   		
		   	    Object Ob[] = {firstname,lastname,address1,address2,city,state,zipcode,emailaddress};
		   	    myData.add(Ob);
		 }
		return myData;
		}
}
