package FieldText;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import Genericlib.ExcelUtils;

import Genericlib.CommonFunction;
import Genericlib.Xls_AllMethods;

public class VerifySqlChar extends ExtentReportBase {
	
	
	//private static final int j = 0;
	static Xls_AllMethods fileone = new Xls_AllMethods("C:/Users/satyaranjan.m/eclipse-workspace/JuniorForm/JuniorFieldValidationwrite.xlsx");	
	
	 
	 static Xls_AllMethods fileone1 = new Xls_AllMethods("C:/Users/satyaranjan.m/eclipse-workspace/JuniorForm/RoughSheet.xlsx");
	 
	 
	 
	 
	 
	XSSFWorkbook wb;
	XSSFSheet sht;
	String sheetName = "JuniorFieldMapping";
 int rowCount = fileone.getRowCount(sheetName);

 //static WebDriver driver;
	CommonFunction data = new CommonFunction();
	
	
	
	 @Test(priority=0)
	   	public void SqlCharNotAllowInitialPlaceForRollNumber
	(



	) throws IOException, InterruptedException
	   	{
	    	test = extent.createTest("SpecialCharNotAllowInitialPlaceForRollNumber");
	    	
	    	data.openBrowser("chrome");
			Thread.sleep(500);
			
			data.openUrl("http://o.samsodisha.gov.in/");
			
			Thread.sleep(500);
			data.LoginPage();
			
			
			
			Thread.sleep(1500);
			
			data.Navigation();
	    	String RollNumberI = 	fileone1.getCellData("JuniorCAF", "RollNumber",6);
	    			
	    	
	      System.out.println(RollNumberI);
	      Thread.sleep(300);
	      
	      data.enterText("id","txtBoardRoll",RollNumberI);
		   		Thread.sleep(1000);
	String actualPopup =data.grtpopup().getText();
				
				System.out.println(actualPopup);
		    	
				String expectedmessage = "Space/Special characters are not allowed";

		    	 if(actualPopup.equals(expectedmessage))
		    	 {
		    		 System.out.println("Sucessfully Message is" + actualPopup);
		    		 data.clickOnLocator("id","popup_ok");
		    		 Thread.sleep(1000);
						System.out.println("Click Ok");
		    		fileone.setCellData(sheetName, "Result", 175 , "Pass");	
		    	 }
		    	
		    	 else
		    	 {
		    		 fileone.setCellData(sheetName, "Result", 175, "Fail");
		    	 }	
		    	 
		    	 SoftAssert softAssert = new SoftAssert();
		    	 softAssert.assertEquals(actualPopup, actualPopup);
			   	}
	    
	    
	    @Test(priority=1)
	   	public void SqlCharNotAllowLastPlaceForRollNumber
	(



	) throws IOException, InterruptedException
	   	{
	    	test = extent.createTest("SpecialCharNotAllowLastPlaceForApplicantName");
	    	String RollNumberI = 	fileone1.getCellData("JuniorCAF", "RollNumber",7);
			
	    	
	        System.out.println(RollNumberI);
	      Thread.sleep(300);
	      
	      data.enterText("id","txtBoardRoll",RollNumberI);
		   		Thread.sleep(1000);
	String actualPopup =data.grtpopup().getText();
				
				System.out.println(actualPopup);
		    	
				String expectedmessage = "Space/Special characters are not allowed";

		    	 if(actualPopup.equals(expectedmessage))
		    	 {
		    		 System.out.println("Sucessfully Message is" + actualPopup);
		    		 data.clickOnLocator("id","popup_ok");
		    		 Thread.sleep(1000);
						System.out.println("Click Ok");
		    		fileone.setCellData(sheetName, "Result", 176 , "Pass");	
		    	 }
		    	
		    	 else
		    	 {
		    		 fileone.setCellData(sheetName, "Result", 176, "Fail");
		    	 }	
		    	 
		    	 SoftAssert softAssert = new SoftAssert();
		    	 softAssert.assertEquals(actualPopup, actualPopup);
			   	}
	    
	    
	    @Test(priority=2)
	   	public void SqlCharNotAllowMiddlePlaceForRollNumber
	(



	) throws IOException, InterruptedException
	   	{
	    	test = extent.createTest("SpecialCharNotAllowMiddlePlaceForApplicantName");
	String RollNumberI = 	fileone1.getCellData("JuniorCAF", "RollNumber",8);
			
	    	
	        System.out.println(RollNumberI);
	      Thread.sleep(300);
	      
	      data.enterText("id","txtBoardRoll",RollNumberI);
		   		Thread.sleep(1000);
	String actualPopup =data.grtpopup().getText();
				
				System.out.println(actualPopup);
		    	
				String expectedmessage = "Space/Special characters are not allowed";

		    	 if(actualPopup.equals(expectedmessage))
		    	 {
		    		 System.out.println("Sucessfully Message is" + actualPopup);
		    		 data.clickOnLocator("id","popup_ok");
		    		 Thread.sleep(1000);
						System.out.println("Click Ok");
		    		fileone.setCellData(sheetName, "Result", 177 , "Pass");	
		    	 }
		    	
		    	 else
		    	 {
		    		 fileone.setCellData(sheetName, "Result", 177, "Fail");
		    	 }	
		    	 
		    	 SoftAssert softAssert = new SoftAssert();
		    	 softAssert.assertEquals(actualPopup, actualPopup);
			   	}
	
 
    
    @Test(priority=0)
   	public void SqlCharNotAllowInitialPlaceForApplicantName
(



) throws IOException, InterruptedException
   	{
    	test = extent.createTest("SqlCharNotAllowInitialPlaceForApplicantName");
    	
    	
    	String ApplicantNameI = 	fileone1.getCellData("JuniorCAF", "ApplicantName",6);
    			
    	
      System.out.println(ApplicantNameI);
      Thread.sleep(300);
      
      data.enterText("id","txtApplName",ApplicantNameI);
	   		Thread.sleep(1000);
	   		
	   		String actualPopup =data.grtpopup().getText();
			
			System.out.println(actualPopup);
	    	
			String expectedmessage = "Please enter only Alphabets";

	    	 if(actualPopup.equals(expectedmessage))
	    	 {
	    		 System.out.println("Sucessfully Message is" + actualPopup);
	    		 data.clickOnLocator("id","popup_ok");
	    		 Thread.sleep(1000);
					System.out.println("Click Ok");
	    		fileone.setCellData(sheetName, "Result", 178 , "Pass");	
	    	 }
	    	
	    	 else
	    	 {
	    		 fileone.setCellData(sheetName, "Result", 178, "Fail");
	    	 }	
	    	 
	    	 SoftAssert softAssert = new SoftAssert();
	    	 softAssert.assertEquals(actualPopup, actualPopup);
		   	}
    
    
    @Test(priority=1)
   	public void SqlCharNotAllowLastPlaceForApplicantName
(



) throws IOException, InterruptedException
   	{
    	test = extent.createTest("SqlCharNotAllowLastPlaceForApplicantName");
    	String ApplicantNameL = 	fileone1.getCellData("JuniorCAF", "ApplicantName",7);
    			
    	
      System.out.println(ApplicantNameL);
      Thread.sleep(300);
      
      data.enterText("id","txtApplName",ApplicantNameL);
	   		Thread.sleep(1000);
String actualPopup =data.grtpopup().getText();
			
			System.out.println(actualPopup);
	    	
			String expectedmessage = "Please enter only Alphabets";

	    	 if(actualPopup.equals(expectedmessage))
	    	 {
	    		 System.out.println("Sucessfully Message is" + actualPopup);
	    		 data.clickOnLocator("id","popup_ok");
	    		 Thread.sleep(1000);
					System.out.println("Click Ok");
	    		fileone.setCellData(sheetName, "Result", 179 , "Pass");	
	    	 }
	    	
	    	 else
	    	 {
	    		 fileone.setCellData(sheetName, "Result", 179, "Fail");
	    	 }	
	    	 
	    	 SoftAssert softAssert = new SoftAssert();
	    	 softAssert.assertEquals(actualPopup, actualPopup);
		   	}
    
    
    @Test(priority=2)
   	public void SqlCharNotAllowMiddlePlaceForApplicantName
(



) throws IOException, InterruptedException
   	{
    	test = extent.createTest("SqlCharNotAllowMiddlePlaceForApplicantName");
    	String ApplicantNameM = 	fileone1.getCellData("JuniorCAF", "ApplicantName",8);
    			
    	
      System.out.println(ApplicantNameM);
      Thread.sleep(300);
      
      data.enterText("id","txtApplName",ApplicantNameM);
	   		Thread.sleep(1000);
String actualPopup =data.grtpopup().getText();
			
			System.out.println(actualPopup);
	    	
			String expectedmessage = "Please enter only Alphabets";

	    	 if(actualPopup.equals(expectedmessage))
	    	 {
	    		 System.out.println("Sucessfully Message is" + actualPopup);
	    		 data.clickOnLocator("id","popup_ok");
	    		 Thread.sleep(1000);
					System.out.println("Click Ok");
	    		fileone.setCellData(sheetName, "Result", 180 , "Pass");	
	    	 }
	    	
	    	 else
	    	 {
	    		 fileone.setCellData(sheetName, "Result", 180, "Fail");
	    	 }	
	    	 
	    	 SoftAssert softAssert = new SoftAssert();
	    	 softAssert.assertEquals(actualPopup, actualPopup);
		   	}
    
    
    
    @Test(priority=3)
   	public void SqlCharNotAllowInitialPlaceForFatherName
(



) throws IOException, InterruptedException
   	{
    	test = extent.createTest("SqlCharNotAllowInitialPlaceForFatherName");
    	String FatherNameI = 	fileone1.getCellData("JuniorCAF", "FatherName",6);
    			
    	
      System.out.println(FatherNameI);
      Thread.sleep(300);
      
      data.enterText("id","txtFatherName",FatherNameI);
	   		Thread.sleep(1000);
String actualPopup =data.grtpopup().getText();
			
			System.out.println(actualPopup);
	    	
			String expectedmessage = "Please enter only Alphabets";

	    	 if(actualPopup.equals(expectedmessage))
	    	 {
	    		 System.out.println("Sucessfully Message is" + actualPopup);
	    		 data.clickOnLocator("id","popup_ok");
	    		 Thread.sleep(1000);
					System.out.println("Click Ok");
	    		fileone.setCellData(sheetName, "Result", 181 , "Pass");	
	    	 }
	    	
	    	 else
	    	 {
	    		 fileone.setCellData(sheetName, "Result", 181, "Fail");
	    	 }	
	    	 
	    	 SoftAssert softAssert = new SoftAssert();
	    	 softAssert.assertEquals(actualPopup, actualPopup);
		   	}
    
    
    @Test(priority=4)
   	public void SqlCharNotAllowLastPlaceForFatherName
(



) throws IOException, InterruptedException
   	{
    	test = extent.createTest("SqlCharNotAllowLastPlaceForFatherName");
    	String FatherNameL = 	fileone1.getCellData("JuniorCAF", "FatherName",7);
    			
    	
      System.out.println(FatherNameL);
      Thread.sleep(300);
      
      data.enterText("id","txtFatherName",FatherNameL);
	   		Thread.sleep(1000);
String actualPopup =data.grtpopup().getText();
			
			System.out.println(actualPopup);
	    	
			String expectedmessage = "enter only Alphabets";

	    	 if(!actualPopup.equals(expectedmessage))
	    	 {
	    		 System.out.println("Sucessfully Message is" + actualPopup);
	    		 data.clickOnLocator("id","popup_ok");
	    		 Thread.sleep(1000);
					System.out.println("Click Ok");
	    		fileone.setCellData(sheetName, "Result", 182 , "Pass");	
	    	 }
	    	
	    	 else
	    	 {
	    		 fileone.setCellData(sheetName, "Result", 182, "Fail");
	    	 }	
	    	 
	    	 SoftAssert softAssert = new SoftAssert();
	    	 softAssert.assertEquals(actualPopup, actualPopup);
		   	}
    
    
    @Test(priority=5)
   	public void SqlCharNotAllowMiddlePlaceForFatherName
(



) throws IOException, InterruptedException
   	{
    	test = extent.createTest("SqlCharNotAllowMiddlePlaceForFatherName");
    	String FatherNameM = 	fileone1.getCellData("JuniorCAF", "FatherName",8);
    			
    	
      System.out.println(FatherNameM);
      Thread.sleep(300);
      
      data.enterText("id","txtFatherName",FatherNameM);
	   		Thread.sleep(1000);
String actualPopup =data.grtpopup().getText();
			
			System.out.println(actualPopup);
	    	
			String expectedmessage = "Please enter only Alphabets";

	    	 if(actualPopup.equals(expectedmessage))
	    	 {
	    		 System.out.println("Sucessfully Message is" + actualPopup);
	    		 data.clickOnLocator("id","popup_ok");
	    		 Thread.sleep(1000);
					System.out.println("Click Ok");
	    		fileone.setCellData(sheetName, "Result", 183 , "Pass");	
	    	 }
	    	
	    	 else
	    	 {
	    		 fileone.setCellData(sheetName, "Result", 183, "Fail");
	    	 }	
	    	 
	    	 SoftAssert softAssert = new SoftAssert();
	    	 softAssert.assertEquals(actualPopup, actualPopup);
		   	}
    
    
    
    @Test(priority=6)
   	public void SqlCharNotAllowInitialPlaceForMotherName
(



) throws IOException, InterruptedException
   	{
    	test = extent.createTest("SqlCharNotAllowInitialPlaceForMotherName");
    	String MotherNameI = 	fileone1.getCellData("JuniorCAF", "MotherName",6);
    			
    	
      System.out.println(MotherNameI);
      Thread.sleep(300);
      
      data.enterText("id","txtMotherName",MotherNameI);
	   		Thread.sleep(1000);
String actualPopup =data.grtpopup().getText();
			
			System.out.println(actualPopup);
	    	
			String expectedmessage = "Please enter only Alphabets";

	    	 if(actualPopup.equals(expectedmessage))
	    	 {
	    		 System.out.println("Sucessfully Message is" + actualPopup);
	    		 data.clickOnLocator("id","popup_ok");
	    		 Thread.sleep(1000);
					System.out.println("Click Ok");
	    		fileone.setCellData(sheetName, "Result", 184 , "Pass");	
	    	 }
	    	
	    	 else
	    	 {
	    		 fileone.setCellData(sheetName, "Result", 184, "Fail");
	    	 }	
	    	 
	    	 SoftAssert softAssert = new SoftAssert();
	    	 softAssert.assertEquals(actualPopup, actualPopup);
		   	}
    
    
    
    @Test(priority=7)
   	public void SqlCharNotAllowLastPlaceForMotherName
(



) throws IOException, InterruptedException
   	{
    	test = extent.createTest("SqlCharNotAllowLastPlaceForMotherName");
    	String MotherNameL = 	fileone1.getCellData("JuniorCAF", "MotherName",7);
    			
    	
      System.out.println(MotherNameL);
      Thread.sleep(300);
      
      data.enterText("id","txtMotherName",MotherNameL);
	   		Thread.sleep(1000);
String actualPopup =data.grtpopup().getText();
			
			System.out.println(actualPopup);
	    	
			String expectedmessage = "enter only Alphabets";

	    	 if(!actualPopup.equals(expectedmessage))
	    	 {
	    		 System.out.println("Sucessfully Message is" + actualPopup);
	    		 data.clickOnLocator("id","popup_ok");
	    		 Thread.sleep(1000);
					System.out.println("Click Ok");
	    		fileone.setCellData(sheetName, "Result", 185 , "Pass");	
	    	 }
	    	
	    	 else
	    	 {
	    		 fileone.setCellData(sheetName, "Result", 185, "Fail");
	    	 }	
	    	 
	    	 SoftAssert softAssert = new SoftAssert();
	    	 softAssert.assertEquals(actualPopup, actualPopup);
		   	}
    
    
    @Test(priority=8)
   	public void SqlCharNotAllowMiddlePlaceForMotherName
(



) throws IOException, InterruptedException
   	{
    	test = extent.createTest("SqlCharNotAllowMiddlePlaceForMotherName");
    	String MotherNameM = 	fileone1.getCellData("JuniorCAF", "MotherName",8);
    			
    	
      System.out.println(MotherNameM);
      Thread.sleep(300);
      
      data.enterText("id","txtMotherName",MotherNameM);
	   		Thread.sleep(1000);
String actualPopup =data.grtpopup().getText();
			
			System.out.println(actualPopup);
	    	
			String expectedmessage = "enter only Alphabets";

	    	 if(!actualPopup.equals(expectedmessage))
	    	 {
	    		 System.out.println("Sucessfully Message is" + actualPopup);
	    		 data.clickOnLocator("id","popup_ok");
	    		 Thread.sleep(1000);
					System.out.println("Click Ok");
	    		fileone.setCellData(sheetName, "Result", 186 , "Pass");	
	    	 }
	    	
	    	 else
	    	 {
	    		 fileone.setCellData(sheetName, "Result", 186, "Fail");
	    	 }	
	    	 
	    	 SoftAssert softAssert = new SoftAssert();
	    	 softAssert.assertEquals(actualPopup, actualPopup);
		   	}
    
    @Test(priority=9)
   	public void SqlCharNotAllowInitialPlaceForAadharNumber
(



) throws IOException, InterruptedException
   	{
    	test = extent.createTest("SqlCharNotAllowInitialPlaceForAadharNumber");
    	String AadharNoI = 	fileone1.getCellData("JuniorCAF", "AadharNo",6);
    			
    	
      System.out.println(AadharNoI);
      Thread.sleep(300);
      
      data.enterText("id","txtadhar",AadharNoI);
	   		Thread.sleep(1000);
	   		
	   		
	   		
	   		driver.switchTo().alert().accept();
	   		
	   		Thread.sleep(1000);
String actualPopup =data.grtpopup().getText();
			
			System.out.println(actualPopup);
	    	
			String expectedmessage = "Please write only numeric values for Aadhaar No.";

	    	 if(actualPopup.equals(expectedmessage))
	    	 {
	    		 System.out.println("Sucessfully Message is" + actualPopup);
	    		 data.clickOnLocator("id","popup_ok");
	    		 Thread.sleep(1000);
					System.out.println("Click Ok");
	    		fileone.setCellData(sheetName, "Result", 187 , "Pass");	
	    	 }
	    	
	    	 else
	    	 {
	    		 fileone.setCellData(sheetName, "Result", 187, "Fail");
	    	 }	
	    	 
	    	 SoftAssert softAssert = new SoftAssert();
	    	 softAssert.assertEquals(actualPopup, actualPopup);
		   	}
    @Test(priority=10)
    public void SqlCharNotAllowLastPlaceForAadharNumber
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SqlCharNotAllowLastPlaceForAadharNumber");
        	String AadharNoL = 	fileone1.getCellData("JuniorCAF", "AadharNo",7);
        			
        	
          System.out.println(AadharNoL);
          Thread.sleep(300);
          
          data.enterText("id","txtadhar",AadharNoL);
    	   		
    	   		
    	   		Thread.sleep(1000);
    String actualPopup =data.grtpopup().getText();
    			
    			System.out.println(actualPopup);
    	    	
    			String expectedmessage = "Please write only numeric values for Aadhaar No.";

    	    	 if(actualPopup.equals(expectedmessage))
    	    	 {
    	    		 System.out.println("Sucessfully Message is" + actualPopup);
    	    		 data.clickOnLocator("id","popup_ok");
    	    		 Thread.sleep(1000);
    					System.out.println("Click Ok");
    	    		fileone.setCellData(sheetName, "Result", 188 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 188, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    @Test(priority=11)
    public void SqlCharNotAllowMiddlePlaceForAadharNumber
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SqlCharNotAllowMiddlePlaceForAadharNumber");
        	String AadharNoM = 	fileone1.getCellData("JuniorCAF", "AadharNo",8);
        			
        	
          System.out.println(AadharNoM);
          Thread.sleep(300);
          
          data.enterText("id","txtadhar",AadharNoM);
    	   		
    	   		
    	   		Thread.sleep(1000);
    String actualPopup =data.grtpopup().getText();
    			
    			System.out.println(actualPopup);
    	    	
    			String expectedmessage = "Please write only numeric values for Aadhaar No.";

    	    	 if(actualPopup.equals(expectedmessage))
    	    	 {
    	    		 System.out.println("Sucessfully Message is" + actualPopup);
    	    		 data.clickOnLocator("id","popup_ok");
    	    		 Thread.sleep(1000);
    					System.out.println("Click Ok");
    	    		fileone.setCellData(sheetName, "Result", 189 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 189, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    @Test(priority=12)
    public void SqlCharNotAllowInitialPlaceForMobileNo
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SqlCharNotAllowInitialPlaceForMobileNo");
        	String MobileNoI = 	fileone1.getCellData("JuniorCAF", "MobileNo",6);
        			
        	
          System.out.println(MobileNoI);
          Thread.sleep(300);
          
          data.enterText("id","txtParentMob",MobileNoI);
    	   		
    	   		
    	   		Thread.sleep(1000);
    String actualPopup =data.grtpopup().getText();
    			
    			System.out.println(actualPopup);
    	    	
    			String expectedmessage = "Please write only numeric values for Aadhaar No.";

    	    	 if(!actualPopup.equals(expectedmessage))
    	    	 {
    	    		 System.out.println("Sucessfully Message is" + actualPopup);
    	    		 data.clickOnLocator("id","popup_ok");
    	    		 Thread.sleep(1000);
    					System.out.println("Click Ok");
    	    		fileone.setCellData(sheetName, "Result", 190 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 190, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    @Test(priority=13)
    public void SqlCharNotAllowLastPlaceForMobileNo
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SqlCharNotAllowLastPlaceForMobileNo");
        	String MobileNoL = 	fileone1.getCellData("JuniorCAF", "MobileNo",7);
        			
        	
          System.out.println(MobileNoL);
          Thread.sleep(300);
          
          data.enterText("id","txtParentMob",MobileNoL);
    	   		
    	   		
    	   		Thread.sleep(1000);
    String actualPopup =data.grtpopup().getText();
    			
    			System.out.println(actualPopup);
    	    	
    			String expectedmessage = "Please write only numeric values for Aadhaar No.";

    	    	 if(!actualPopup.equals(expectedmessage))
    	    	 {
    	    		 System.out.println("Sucessfully Message is" + actualPopup);
    	    		 data.clickOnLocator("id","popup_ok");
    	    		 Thread.sleep(1000);
    					System.out.println("Click Ok");
    	    		fileone.setCellData(sheetName, "Result", 191 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 191, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    
    @Test(priority=14)
    public void SqlCharNotAllowMiddlePlaceForMobileNo
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SqlCharNotAllowMiddlePlaceForMobileNo");
        	String MobileNoM = 	fileone1.getCellData("JuniorCAF", "MobileNo",8);
        			
        	
          System.out.println(MobileNoM);
          Thread.sleep(300);
          
          data.enterText("id","txtParentMob",MobileNoM);
    	   		
    	   		
    	   		Thread.sleep(1000);
    String actualPopup =data.grtpopup().getText();
    			
    			System.out.println(actualPopup);
    	    	
    			String expectedmessage = "Please write only numeric values for Aadhaar No.";

    	    	 if(!actualPopup.equals(expectedmessage))
    	    	 {
    	    		 System.out.println("Sucessfully Message is" + actualPopup);
    	    		 data.clickOnLocator("id","popup_ok");
    	    		 Thread.sleep(1000);
    					System.out.println("Click Ok");
    	    		fileone.setCellData(sheetName, "Result", 192 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 192, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    
    @Test(priority=15)
    public void SqlCharNotAllowInitialPlaceForPinCode
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SqlCharNotAllowInitialPlaceForPinCode");
        	String PinCodeI = 	fileone1.getCellData("JuniorCAF", "PinCode",6);
        			
        	
          System.out.println(PinCodeI);
          Thread.sleep(300);
          
          data.enterText("id","txtCPC",PinCodeI);
    	   		
    	   		
    	   		Thread.sleep(1000);
    String actualPopup =data.grtpopup().getText();
    			
    			System.out.println(actualPopup);
    	    	
    			String expectedmessage = "Please write only numeric values for Aadhaar No.";

    	    	 if(!actualPopup.equals(expectedmessage))
    	    	 {
    	    		 System.out.println("Sucessfully Message is" + actualPopup);
    	    		 data.clickOnLocator("id","popup_ok");
    	    		 Thread.sleep(1000);
    					System.out.println("Click Ok");
    	    		fileone.setCellData(sheetName, "Result", 193 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 193, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    
    @Test(priority=16)
    public void SqlCharNotAllowLastPlaceForPinCode
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SqlCharNotAllowLastPlaceForPinCode");
        	String PinCodeL = 	fileone1.getCellData("JuniorCAF", "PinCode",7);
        			
        	
          System.out.println(PinCodeL);
          Thread.sleep(300);
          
          data.enterText("id","txtCPC",PinCodeL);
    	   		
    	   		
    	   		Thread.sleep(1000);
    String actualPopup =data.grtpopup().getText();
    			
    			System.out.println(actualPopup);
    	    	
    			String expectedmessage = "Please write only numeric values for Aadhaar No.";

    	    	 if(!actualPopup.equals(expectedmessage))
    	    	 {
    	    		 System.out.println("Sucessfully Message is" + actualPopup);
    	    		 data.clickOnLocator("id","popup_ok");
    	    		 Thread.sleep(1000);
    					System.out.println("Click Ok");
    	    		fileone.setCellData(sheetName, "Result", 194 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 194, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    @Test(priority=17)
    public void SqlCharNotAllowMiddlePlaceForPinCode
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SqlCharNotAllowMiddlePlaceForPinCode");
        	String PinCodeM = 	fileone1.getCellData("JuniorCAF", "PinCode",8);
        			
        	
          System.out.println(PinCodeM);
          Thread.sleep(300);
          
          data.enterText("id","txtCPC",PinCodeM);
    	   		
    	   		
    	   		Thread.sleep(1000);
    String actualPopup =data.grtpopup().getText();
    			
    			System.out.println(actualPopup);
    	    	
    			String expectedmessage = "Please write only numeric values for Aadhaar No.";

    	    	 if(!actualPopup.equals(expectedmessage))
    	    	 {
    	    		 System.out.println("Sucessfully Message is" + actualPopup);
    	    		 data.clickOnLocator("id","popup_ok");
    	    		 Thread.sleep(1000);
    					System.out.println("Click Ok");
    	    		fileone.setCellData(sheetName, "Result", 195 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 195, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    @Test(priority=18)
    public void SqlCharNotAllowInitialPlaceForAreaCode
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SqlCharNotAllowInitialPlaceForAreaCode");
        	String AreaCodeI = 	fileone1.getCellData("JuniorCAF", "AreaCode",6);
        			
        	
          System.out.println(AreaCodeI);
          Thread.sleep(300);
          
          data.enterText("id","txtCTCode",AreaCodeI);
    	   		
    	   		
    	   		Thread.sleep(1000);
    String actualPopup =data.grtpopup().getText();
    			
    			System.out.println(actualPopup);
    	    	
    			String expectedmessage = "Please write only numeric values for Aadhaar No.";

    	    	 if(!actualPopup.equals(expectedmessage))
    	    	 {
    	    		 System.out.println("Sucessfully Message is" + actualPopup);
    	    		 data.clickOnLocator("id","popup_ok");
    	    		 Thread.sleep(1000);
    					System.out.println("Click Ok");
    	    		fileone.setCellData(sheetName, "Result", 196 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 196, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    
    @Test(priority=19)
    public void SqlCharNotAllowLastPlaceForAreaCode
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SqlCharNotAllowLastPlaceForAreaCode");
        	String AreaCodeL = 	fileone1.getCellData("JuniorCAF", "AreaCode",7);
        			
        	
          System.out.println(AreaCodeL);
          Thread.sleep(300);
          
          data.enterText("id","txtCTCode",AreaCodeL);
    	   		
    	   		
    	   		Thread.sleep(1000);
    String actualPopup =data.grtpopup().getText();
    			
    			System.out.println(actualPopup);
    	    	
    			String expectedmessage = "Please write only numeric values for Aadhaar No.";

    	    	 if(!actualPopup.equals(expectedmessage))
    	    	 {
    	    		 System.out.println("Sucessfully Message is" + actualPopup);
    	    		 data.clickOnLocator("id","popup_ok");
    	    		 Thread.sleep(1000);
    					System.out.println("Click Ok");
    	    		fileone.setCellData(sheetName, "Result", 197 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 197, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    @Test(priority=20)
    public void SqlCharNotAllowMiddlePlaceForAreaCode
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SqlCharNotAllowMiddlePlaceForAreaCode");
        	String AreaCodeM = 	fileone1.getCellData("JuniorCAF", "AreaCode",8);
        			
        	
          System.out.println(AreaCodeM);
          Thread.sleep(300);
          
          data.enterText("id","txtCTCode",AreaCodeM);
    	   		
    	   		
    	   		Thread.sleep(1000);
    String actualPopup =data.grtpopup().getText();
    			
    			System.out.println(actualPopup);
    	    	
    			String expectedmessage = "Please write only numeric values for Aadhaar No.";

    	    	 if(!actualPopup.equals(expectedmessage))
    	    	 {
    	    		 System.out.println("Sucessfully Message is" + actualPopup);
    	    		 data.clickOnLocator("id","popup_ok");
    	    		 Thread.sleep(1000);
    					System.out.println("Click Ok");
    	    		fileone.setCellData(sheetName, "Result", 198 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 198, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    @Test(priority=21)
    public void SqlCharNotAllowInitialPlaceForPhoneNo
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SqlCharNotAllowInitialPlaceForPhoneNo");
        	String PhoneNoI = 	fileone1.getCellData("JuniorCAF", "PhoneNo",6);
        			
        	
          System.out.println(PhoneNoI);
          Thread.sleep(300);
          
          data.enterText("id","txtCTeleNo",PhoneNoI);
    	   		
    	   		
    	   		Thread.sleep(1000);
    String actualPopup =data.grtpopup().getText();
    			
    			System.out.println(actualPopup);
    	    	
    			String expectedmessage = "Please write only numeric values for Aadhaar No.";

    	    	 if(!actualPopup.equals(expectedmessage))
    	    	 {
    	    		 System.out.println("Sucessfully Message is" + actualPopup);
    	    		 data.clickOnLocator("id","popup_ok");
    	    		 Thread.sleep(1000);
    					System.out.println("Click Ok");
    	    		fileone.setCellData(sheetName, "Result", 199 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 199, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    
    @Test(priority=22)
    public void SqlCharNotAllowLastPlaceForPhoneNo
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SqlCharNotAllowLastPlaceForPhoneNo");
        	String PhoneNoL= 	fileone1.getCellData("JuniorCAF", "PhoneNo",7);
        			
        	
          System.out.println(PhoneNoL);
          Thread.sleep(300);
          
          data.enterText("id","txtCTeleNo",PhoneNoL);
    	   		
    	   		
    	   		Thread.sleep(1000);
    String actualPopup =data.grtpopup().getText();
    			
    			System.out.println(actualPopup);
    	    	
    			String expectedmessage = "Please write only numeric values for Aadhaar No.";

    	    	 if(!actualPopup.equals(expectedmessage))
    	    	 {
    	    		 System.out.println("Sucessfully Message is" + actualPopup);
    	    		 data.clickOnLocator("id","popup_ok");
    	    		 Thread.sleep(1000);
    					System.out.println("Click Ok");
    	    		fileone.setCellData(sheetName, "Result", 200 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 200, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    @Test(priority=23)
    public void SqlCharNotAllowMiddlePlaceForPhoneNo
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SqlCharNotAllowMiddlePlaceForPhoneNo");
        	String PhoneNoM= 	fileone1.getCellData("JuniorCAF", "PhoneNo",8);
        			
        	
          System.out.println(PhoneNoM);
          Thread.sleep(300);
          
          data.enterText("id","txtCTeleNo",PhoneNoM);
    	   		
    	   		
    	   		Thread.sleep(1000);
    String actualPopup =data.grtpopup().getText();
    			
    			System.out.println(actualPopup);
    	    	
    			String expectedmessage = "Please write only numeric values for Aadhaar No.";

    	    	 if(!actualPopup.equals(expectedmessage))
    	    	 {
    	    		 System.out.println("Sucessfully Message is" + actualPopup);
    	    		 data.clickOnLocator("id","popup_ok");
    	    		 Thread.sleep(1000);
    					System.out.println("Click Ok");
    	    		fileone.setCellData(sheetName, "Result", 201 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 201, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    @Test(priority=24)
    public void SqlCharNotAllowInitialPlaceForMaximumMark
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SqlCharNotAllowInitialPlaceForMaximumMark");
        	String MaximumMarkI= 	fileone1.getCellData("JuniorCAF", "MaximumMark",6);
        			
        	
          System.out.println(MaximumMarkI);
          Thread.sleep(300);
          
          data.enterText("id","txtMaxMark",MaximumMarkI);
    	   		
    	   		
    	   		Thread.sleep(1000);
    String actualPopup =data.grtpopup().getText();
    			
    			System.out.println(actualPopup);
    	    	
    			String expectedmessage = "Please write only numeric values for Aadhaar No.";

    	    	 if(!actualPopup.equals(expectedmessage))
    	    	 {
    	    		 System.out.println("Sucessfully Message is" + actualPopup);
    	    		 data.clickOnLocator("id","popup_ok");
    	    		 Thread.sleep(1000);
    					System.out.println("Click Ok");
    	    		fileone.setCellData(sheetName, "Result", 202 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 202, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    @Test(priority=25)
    public void SqlCharNotAllowLastPlaceForMaximumMark
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SqlCharNotAllowLastPlaceForMaximumMark");
        	String MaximumMarkL= 	fileone1.getCellData("JuniorCAF", "MaximumMark",7);
        			
        	
          System.out.println(MaximumMarkL);
          Thread.sleep(300);
          
          data.enterText("id","txtMaxMark",MaximumMarkL);
    	   		
    	   		
    	   		Thread.sleep(1000);
    String actualPopup =data.grtpopup().getText();
    			
    			System.out.println(actualPopup);
    	    	
    			String expectedmessage = "Please write only numeric values for Aadhaar No.";

    	    	 if(!actualPopup.equals(expectedmessage))
    	    	 {
    	    		 System.out.println("Sucessfully Message is" + actualPopup);
    	    		 data.clickOnLocator("id","popup_ok");
    	    		 Thread.sleep(1000);
    					System.out.println("Click Ok");
    	    		fileone.setCellData(sheetName, "Result", 203 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 203, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    
    @Test(priority=26)
    public void SqlCharNotAllowMiddlePlaceForMaximumMark
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SqlCharNotAllowMiddlePlaceForMaximumMark");
        	String MaximumMarkM= 	fileone1.getCellData("JuniorCAF", "MaximumMark",8);
        			
        	
          System.out.println(MaximumMarkM);
          Thread.sleep(300);
          
          data.enterText("id","txtMaxMark",MaximumMarkM);
    	   		
    	   		
    	   		Thread.sleep(1000);
    String actualPopup =data.grtpopup().getText();
    			
    			System.out.println(actualPopup);
    	    	
    			String expectedmessage = "Please write only numeric values for Aadhaar No.";

    	    	 if(!actualPopup.equals(expectedmessage))
    	    	 {
    	    		 System.out.println("Sucessfully Message is" + actualPopup);
    	    		 data.clickOnLocator("id","popup_ok");
    	    		 Thread.sleep(1000);
    					System.out.println("Click Ok");
    	    		fileone.setCellData(sheetName, "Result", 204 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 204, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    @Test(priority=27)
    public void SqlCharNotAllowInitialPlaceForSecuredMark
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SqlCharNotAllowInitialPlaceForSecuredMark");
        	String SecuredMarkI= 	fileone1.getCellData("JuniorCAF", "SecuredMark",6);
        			
        	
          System.out.println(SecuredMarkI);
          Thread.sleep(300);
          
          data.enterText("id","txtTotMark",SecuredMarkI);
    	   		
    	   		
    	   		Thread.sleep(1000);
    String actualPopup =data.grtpopup().getText();
    			
    			System.out.println(actualPopup);
    	    	
    			String expectedmessage = "Please write only numeric values for Aadhaar No.";

    	    	 if(!actualPopup.equals(expectedmessage))
    	    	 {
    	    		 System.out.println("Sucessfully Message is" + actualPopup);
    	    		 data.clickOnLocator("id","popup_ok");
    	    		 Thread.sleep(1000);
    					System.out.println("Click Ok");
    	    		fileone.setCellData(sheetName, "Result", 205 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 205, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    @Test(priority=28)
    public void SqlCharNotAllowLastPlaceForSecuredMark
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SqlCharNotAllowLastPlaceForSecuredMark");
        	String SecuredMarkL= 	fileone1.getCellData("JuniorCAF", "SecuredMark",7);
        			
        	
          System.out.println(SecuredMarkL);
          Thread.sleep(300);
          
          data.enterText("id","txtTotMark",SecuredMarkL);
    	   		
    	   		
    	   		Thread.sleep(1000);
    String actualPopup =data.grtpopup().getText();
    			
    			System.out.println(actualPopup);
    	    	
    			String expectedmessage = "Please write only numeric values for Aadhaar No.";

    	    	 if(!actualPopup.equals(expectedmessage))
    	    	 {
    	    		 System.out.println("Sucessfully Message is" + actualPopup);
    	    		 data.clickOnLocator("id","popup_ok");
    	    		 Thread.sleep(1000);
    					System.out.println("Click Ok");
    	    		fileone.setCellData(sheetName, "Result", 206 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 206, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    @Test(priority=29)
    public void SqlCharNotAllowMiddlePlaceForSecuredMark
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SqlCharNotAllowMiddlePlaceForSecuredMark");
        	String SecuredMarkM= 	fileone1.getCellData("JuniorCAF", "SecuredMark",8);
        			
        	
          System.out.println(SecuredMarkM);
          Thread.sleep(300);
          
          data.enterText("id","txtTotMark",SecuredMarkM);
    	   		
    	   		
    	   		Thread.sleep(1000);
    String actualPopup =data.grtpopup().getText();
    			
    			System.out.println(actualPopup);
    	    	
    			String expectedmessage = "Please write only numeric values for Aadhaar No.";

    	    	 if(!actualPopup.equals(expectedmessage))
    	    	 {
    	    		 System.out.println("Sucessfully Message is" + actualPopup);
    	    		 data.clickOnLocator("id","popup_ok");
    	    		 Thread.sleep(1000);
    					System.out.println("Click Ok");
    	    		fileone.setCellData(sheetName, "Result", 207 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 207, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    
    @Test(priority=30)
    public void SqlCharNotAllowInitialPlaceForEnglish
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SqlCharNotAllowInitialPlaceForEnglish");
        	String EnglishI= 	fileone1.getCellData("JuniorCAF", "English",6);
        			
        	
          System.out.println(EnglishI);
          Thread.sleep(300);
          
          data.enterText("id","txtEnglish",EnglishI);
    	   		
    	   		
    	   		Thread.sleep(1000);
    String actualPopup =data.grtpopup().getText();
    			
    			System.out.println(actualPopup);
    	    	
    			String expectedmessage = "Please write only numeric values for Aadhaar No.";

    	    	 if(!actualPopup.equals(expectedmessage))
    	    	 {
    	    		 System.out.println("Sucessfully Message is" + actualPopup);
    	    		 data.clickOnLocator("id","popup_ok");
    	    		 Thread.sleep(1000);
    					System.out.println("Click Ok");
    	    		fileone.setCellData(sheetName, "Result", 208 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 208, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    @Test(priority=31)
    public void SqlCharNotAllowLastPlaceForEnglish
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SqlCharNotAllowLastPlaceForEnglish");
        	String EnglishL= 	fileone1.getCellData("JuniorCAF", "English",7);
        			
        	
          System.out.println(EnglishL);
          Thread.sleep(300);
          
          data.enterText("id","txtEnglish",EnglishL);
    	   		
    	   		
    	   		Thread.sleep(1000);
    String actualPopup =data.grtpopup().getText();
    			
    			System.out.println(actualPopup);
    	    	
    			String expectedmessage = "Please write only numeric values for Aadhaar No.";

    	    	 if(!actualPopup.equals(expectedmessage))
    	    	 {
    	    		 System.out.println("Sucessfully Message is" + actualPopup);
    	    		 data.clickOnLocator("id","popup_ok");
    	    		 Thread.sleep(1000);
    					System.out.println("Click Ok");
    	    		fileone.setCellData(sheetName, "Result", 209 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 209, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    
    @Test(priority=32)
    public void SqlCharNotAllowMiddlePlaceForEnglish
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SqlCharNotAllowMiddlePlaceForEnglish");
        	String EnglishM= 	fileone1.getCellData("JuniorCAF", "English",8);
        			
        	
          System.out.println(EnglishM);
          Thread.sleep(300);
          
          data.enterText("id","txtEnglish",EnglishM);
    	   		
    	   		
    	   		Thread.sleep(1000);
    String actualPopup =data.grtpopup().getText();
    			
    			System.out.println(actualPopup);
    	    	
    			String expectedmessage = "Please write only numeric values for Aadhaar No.";

    	    	 if(!actualPopup.equals(expectedmessage))
    	    	 {
    	    		 System.out.println("Sucessfully Message is" + actualPopup);
    	    		 data.clickOnLocator("id","popup_ok");
    	    		 Thread.sleep(1000);
    					System.out.println("Click Ok");
    	    		fileone.setCellData(sheetName, "Result", 210 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 210, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    
    @Test(priority=33)
    public void SqlCharNotAllowInitialPlaceForMath
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SqlCharNotAllowInitialPlaceForMath");
        	String MathI= 	fileone1.getCellData("JuniorCAF", "Math",6);
        			
        	
          System.out.println(MathI);
          Thread.sleep(300);
          
          data.enterText("id","txtMath",MathI);
    	   		
    	   		
    	   		Thread.sleep(1000);
    String actualPopup =data.grtpopup().getText();
    			
    			System.out.println(actualPopup);
    	    	
    			String expectedmessage = "Please write only numeric values for Aadhaar No.";

    	    	 if(!actualPopup.equals(expectedmessage))
    	    	 {
    	    		 System.out.println("Sucessfully Message is" + actualPopup);
    	    		 data.clickOnLocator("id","popup_ok");
    	    		 Thread.sleep(1000);
    					System.out.println("Click Ok");
    	    		fileone.setCellData(sheetName, "Result", 211 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 211, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    @Test(priority=34)
    public void SqlCharNotAllowLastPlaceForMath
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SqlCharNotAllowLastPlaceForMath");
        	String MathL= 	fileone1.getCellData("JuniorCAF", "Math",7);
        			
        	
          System.out.println(MathL);
          Thread.sleep(300);
          
          data.enterText("id","txtMath",MathL);
    	   		
    	   		
    	   		Thread.sleep(1000);
    String actualPopup =data.grtpopup().getText();
    			
    			System.out.println(actualPopup);
    	    	
    			String expectedmessage = "Please write only numeric values for Aadhaar No.";

    	    	 if(!actualPopup.equals(expectedmessage))
    	    	 {
    	    		 System.out.println("Sucessfully Message is" + actualPopup);
    	    		 data.clickOnLocator("id","popup_ok");
    	    		 Thread.sleep(1000);
    					System.out.println("Click Ok");
    	    		fileone.setCellData(sheetName, "Result", 212 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 212, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    
    
    @Test(priority=35)
    public void SqlCharNotAllowMiddlePlaceForMath
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SqlCharNotAllowMiddlePlaceForMath");
        	String MathM= 	fileone1.getCellData("JuniorCAF", "Math",8);
        			
        	
          System.out.println(MathM);
          Thread.sleep(300);
          
          data.enterText("id","txtMath",MathM);
    	   		
    	   		
    	   		Thread.sleep(1000);
    String actualPopup =data.grtpopup().getText();
    			
    			System.out.println(actualPopup);
    	    	
    			String expectedmessage = "Please write only numeric values for Aadhaar No.";

    	    	 if(!actualPopup.equals(expectedmessage))
    	    	 {
    	    		 System.out.println("Sucessfully Message is" + actualPopup);
    	    		 data.clickOnLocator("id","popup_ok");
    	    		 Thread.sleep(1000);
    					System.out.println("Click Ok");
    	    		fileone.setCellData(sheetName, "Result", 213 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 213, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    
    @Test(priority=36)
    public void SqlCharNotAllowInitialPlaceForScience
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SqlCharNotAllowInitialPlaceForScience");
        	String ScienceI= 	fileone1.getCellData("JuniorCAF", "Science",6);
        			
        	
          System.out.println(ScienceI);
          Thread.sleep(300);
          
          data.enterText("id","txtScience",ScienceI);
    	   		
    	   		
    	   		Thread.sleep(1000);
    String actualPopup =data.grtpopup().getText();
    			
    			System.out.println(actualPopup);
    	    	
    			String expectedmessage = "Please write only numeric values for Aadhaar No.";

    	    	 if(!actualPopup.equals(expectedmessage))
    	    	 {
    	    		 System.out.println("Sucessfully Message is" + actualPopup);
    	    		 data.clickOnLocator("id","popup_ok");
    	    		 Thread.sleep(1000);
    					System.out.println("Click Ok");
    	    		fileone.setCellData(sheetName, "Result", 214 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 214, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    @Test(priority=37)
    public void SqlCharNotAllowLastPlaceForScience
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SqlCharNotAllowLastPlaceForScience");
        	String ScienceL= 	fileone1.getCellData("JuniorCAF", "Science",7);
        			
        	
          System.out.println(ScienceL);
          Thread.sleep(300);
          
          data.enterText("id","txtScience",ScienceL);
    	   		
    	   		
    	   		Thread.sleep(1000);
    String actualPopup =data.grtpopup().getText();
    			
    			System.out.println(actualPopup);
    	    	
    			String expectedmessage = "Please write only numeric values for Aadhaar No.";

    	    	 if(!actualPopup.equals(expectedmessage))
    	    	 {
    	    		 System.out.println("Sucessfully Message is" + actualPopup);
    	    		 data.clickOnLocator("id","popup_ok");
    	    		 Thread.sleep(1000);
    					System.out.println("Click Ok");
    	    		fileone.setCellData(sheetName, "Result", 215 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 215, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    @Test(priority=38)
    public void SqlCharNotAllowMiddlePlaceForScience
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SqlCharNotAllowMiddlePlaceForScience");
        	String ScienceM= 	fileone1.getCellData("JuniorCAF", "Science",8);
        			
        	
          System.out.println(ScienceM);
          Thread.sleep(300);
          
          data.enterText("id","txtScience",ScienceM);
    	   		
    	   		
    	   		Thread.sleep(1000);
    String actualPopup =data.grtpopup().getText();
    			
    			System.out.println(actualPopup);
    	    	
    			String expectedmessage = "Please write only numeric values for Aadhaar No.";

    	    	 if(!actualPopup.equals(expectedmessage))
    	    	 {
    	    		 System.out.println("Sucessfully Message is" + actualPopup);
    	    		 data.clickOnLocator("id","popup_ok");
    	    		 Thread.sleep(1000);
    					System.out.println("Click Ok");
    	    		fileone.setCellData(sheetName, "Result", 216 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 216, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    @Test(priority=39)
    public void SqlCharNotAllowInitialPlaceForSocialScience
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SqlCharNotAllowInitialPlaceForSocialScience");
        	String SocialScienceI= 	fileone1.getCellData("JuniorCAF", "SocialScience",6);
        			
        	
          System.out.println(SocialScienceI);
          Thread.sleep(300);
          
          data.enterText("id","txtSocSci",SocialScienceI);
    	   		
    	   		
    	   		Thread.sleep(1000);
    String actualPopup =data.grtpopup().getText();
    			
    			System.out.println(actualPopup);
    	    	
    			String expectedmessage = "Please write only numeric values for Aadhaar No.";

    	    	 if(!actualPopup.equals(expectedmessage))
    	    	 {
    	    		 System.out.println("Sucessfully Message is" + actualPopup);
    	    		 data.clickOnLocator("id","popup_ok");
    	    		 Thread.sleep(1000);
    					System.out.println("Click Ok");
    	    		fileone.setCellData(sheetName, "Result", 217 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 217, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    @Test(priority=40)
    public void SqlCharNotAllowLastPlaceForSocialScience
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SqlCharNotAllowLastPlaceForSocialScience");
        	String SocialScienceL= 	fileone1.getCellData("JuniorCAF", "SocialScience",7);
        			
        	
          System.out.println(SocialScienceL);
          Thread.sleep(300);
          
          data.enterText("id","txtSocSci",SocialScienceL);
    	   		
    	   		
    	   		Thread.sleep(1000);
    String actualPopup =data.grtpopup().getText();
    			
    			System.out.println(actualPopup);
    	    	
    			String expectedmessage = "Please write only numeric values for Aadhaar No.";

    	    	 if(!actualPopup.equals(expectedmessage))
    	    	 {
    	    		 System.out.println("Sucessfully Message is" + actualPopup);
    	    		 data.clickOnLocator("id","popup_ok");
    	    		 Thread.sleep(1000);
    					System.out.println("Click Ok");
    	    		fileone.setCellData(sheetName, "Result", 218 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 218, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    
    @Test(priority=41)
    public void SqlCharNotAllowMiddlePlaceForSocialScience
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SqlCharNotAllowMiddlePlaceForSocialScience");
        	String SocialScienceM= 	fileone1.getCellData("JuniorCAF", "SocialScience",8);
        			
        	
          System.out.println(SocialScienceM);
          Thread.sleep(300);
          
          data.enterText("id","txtSocSci",SocialScienceM);
    	   		
    	   		
    	   		Thread.sleep(1000);
    String actualPopup =data.grtpopup().getText();
    			
    			System.out.println(actualPopup);
    	    	
    			String expectedmessage = "Please write only numeric values for Aadhaar No.";

    	    	 if(!actualPopup.equals(expectedmessage))
    	    	 {
    	    		 System.out.println("Sucessfully Message is" + actualPopup);
    	    		 data.clickOnLocator("id","popup_ok");
    	    		 Thread.sleep(1000);
    					System.out.println("Click Ok");
    	    		fileone.setCellData(sheetName, "Result", 219 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 219, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    
    @Test(priority=42)
    public void SqlCharNotAllowInitialPlaceForAccountNumber
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SqlCharNotAllowInitialPlaceForAccountNumber");
        	String AccountNumberI= 	fileone1.getCellData("JuniorCAF", "AccountNumber",6);
        			
        	
          System.out.println(AccountNumberI);
          Thread.sleep(300);
          
          
          
          data.SelectDropdown("id", "ddlAIncome", "0 - 1,00,000");
          
          
          Thread.sleep(300);
          
          data.enterText("id","txtacno",AccountNumberI);
    	   		
          Thread.sleep(300);
          
          data.enterText("id","txtifsc","");
          
          
          
    	   		
    	   		Thread.sleep(1000);
    String actualPopup =data.grtpopup().getText();
    			
    			System.out.println(actualPopup);
    	    	
    			String expectedmessage = "Please write only numeric values for Aadhaar No.";

    	    	 if(!actualPopup.equals(expectedmessage))
    	    	 {
    	    		 System.out.println("Sucessfully Message is" + actualPopup);
    	    		 data.clickOnLocator("id","popup_ok");
    	    		 Thread.sleep(1000);
    					System.out.println("Click Ok");
    	    		fileone.setCellData(sheetName, "Result", 220 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 220, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    
    @Test(priority=43)
    public void SqlCharNotAllowLastPlaceForAccountNumber
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SqlCharNotAllowLastPlaceForAccountNumber");
        	String AccountNumberL= 	fileone1.getCellData("JuniorCAF", "AccountNumber",7);
        			
        	
          System.out.println(AccountNumberL);
          Thread.sleep(300);
          
          
          data.SelectDropdown("id", "ddlAIncome", "0 - 1,00,000");
          
          data.enterText("id","txtacno",AccountNumberL);
    	   		
          
          
Thread.sleep(300);
          
          data.enterText("id","txtifsc","");
          
          
          
    	   		
    	   		Thread.sleep(7000);
    String actualPopup =data.grtpopup().getText();
    			
    			System.out.println(actualPopup);
    	    	
    			String expectedmessage = "Please write only numeric values for Aadhaar No.";

    	    	 if(!actualPopup.equals(expectedmessage))
    	    	 {
    	    		 System.out.println("Sucessfully Message is" + actualPopup);
    	    		 data.clickOnLocator("id","popup_ok");
    	    		 Thread.sleep(1000);
    					System.out.println("Click Ok");
    	    		fileone.setCellData(sheetName, "Result", 221 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 221, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    @Test(priority=44)
    public void SqlCharNotAllowMiddlePlaceForAccountNumber
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SqlCharNotAllowMiddlePlaceForAccountNumber");
        	String AccountNumberM= 	fileone1.getCellData("JuniorCAF", "AccountNumber",8);
        			
        	
          System.out.println(AccountNumberM);
          Thread.sleep(300);
          
          
          data.SelectDropdown("id", "ddlAIncome", "0 - 1,00,000");
          
          data.enterText("id","txtacno",AccountNumberM);
    	   		
          
          
Thread.sleep(300);
          
          data.enterText("id","txtifsc","");
          
          
          
    	   		
    	   		Thread.sleep(7000);
    String actualPopup =data.grtpopup().getText();
    			
    			System.out.println(actualPopup);
    	    	
    			String expectedmessage = "Please write only numeric values for Aadhaar No.";

    	    	 if(!actualPopup.equals(expectedmessage))
    	    	 {
    	    		 System.out.println("Sucessfully Message is" + actualPopup);
    	    		 data.clickOnLocator("id","popup_ok");
    	    		 Thread.sleep(1000);
    					System.out.println("Click Ok");
    	    		fileone.setCellData(sheetName, "Result", 222 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 222, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    @Test(priority=45)
    public void SqlCharNotAllowInitialPlaceForIFSCCode
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SqlCharNotAllowInitialPlaceForIFSCCode");
        	String IFSCI= 	fileone1.getCellData("JuniorCAF", "IFSC",6);
        			
        	
          System.out.println(IFSCI);
          Thread.sleep(300);
          
          
          data.SelectDropdown("id", "ddlAIncome", "0 - 1,00,000");
          
          data.enterText("id","txtifsc",IFSCI);
    	   		
          
          
Thread.sleep(300);
          
          data.enterText("id","txtmicr","");
          
          
      	
    	   		
    	   		Thread.sleep(7000);
    String actualPopup =data.grtpopup().getText();
    			
    			System.out.println(actualPopup);
    	    	
    			String expectedmessage = "Please write only numeric values for Aadhaar No.";

    	    	 if(!actualPopup.equals(expectedmessage))
    	    	 {
    	    		 System.out.println("Sucessfully Message is" + actualPopup);
    	    		 data.clickOnLocator("id","popup_ok");
    	    		 Thread.sleep(1000);
    					System.out.println("Click Ok");
    	    		fileone.setCellData(sheetName, "Result", 223 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 223, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    
    @Test(priority=46)
    public void SqlCharNotAllowLastPlaceForIFSCCode
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SqlCharNotAllowLastPlaceForIFSCCode");
        	String IFSCL= 	fileone1.getCellData("JuniorCAF", "IFSC",7);
        			
        	
          System.out.println(IFSCL);
          Thread.sleep(300);
          
          
          data.SelectDropdown("id", "ddlAIncome", "0 - 1,00,000");
          
          data.enterText("id","txtifsc",IFSCL);
    	   		
          
          
Thread.sleep(300);
          
          data.enterText("id","txtmicr","");
          
          
      	
    	   		
    	   		Thread.sleep(7000);
    String actualPopup =data.grtpopup().getText();
    			
    			System.out.println(actualPopup);
    	    	
    			String expectedmessage = "Please write only numeric values for Aadhaar No.";

    	    	 if(!actualPopup.equals(expectedmessage))
    	    	 {
    	    		 System.out.println("Sucessfully Message is" + actualPopup);
    	    		 data.clickOnLocator("id","popup_ok");
    	    		 Thread.sleep(1000);
    					System.out.println("Click Ok");
    	    		fileone.setCellData(sheetName, "Result", 224 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 224, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    @Test(priority=47)
    public void SqlCharNotAllowMiddlePlaceForIFSCCode
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SqlCharNotAllowMiddlePlaceForIFSCCode");
        	String IFSCM= 	fileone1.getCellData("JuniorCAF", "IFSC",8);
        			
        	
          System.out.println(IFSCM);
          Thread.sleep(300);
          
          
          data.SelectDropdown("id", "ddlAIncome", "0 - 1,00,000");
          
          data.enterText("id","txtifsc",IFSCM);
    	   		
          
          
Thread.sleep(300);
          
          data.enterText("id","txtmicr","");
          
          
      	
    	   		
    	   		Thread.sleep(7000);
    String actualPopup =data.grtpopup().getText();
    			
    			System.out.println(actualPopup);
    	    	
    			String expectedmessage = "Please write only numeric values for Aadhaar No.";

    	    	 if(!actualPopup.equals(expectedmessage))
    	    	 {
    	    		 System.out.println("Sucessfully Message is" + actualPopup);
    	    		 data.clickOnLocator("id","popup_ok");
    	    		 Thread.sleep(1000);
    					System.out.println("Click Ok");
    	    		fileone.setCellData(sheetName, "Result", 225 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 225, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    @Test(priority=48)
    public void SqlCharNotAllowInitialPlaceForMICRCode
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SqlCharNotAllowInitialPlaceForMICRCode");
        	String MICRI= 	fileone1.getCellData("JuniorCAF", "MICR",6);
        			
        	
          System.out.println(MICRI);
          Thread.sleep(300);
          
          
          data.SelectDropdown("id", "ddlAIncome", "0 - 1,00,000");
          
          data.enterText("id","txtmicr",MICRI);
    	   		
          
          

          
      	
    	   		
    	   		Thread.sleep(7000);
    String actualPopup =data.grtpopup().getText();
    			
    			System.out.println(actualPopup);
    	    	
    			String expectedmessage = "Please write only numeric values for Aadhaar No.";

    	    	 if(!actualPopup.equals(expectedmessage))
    	    	 {
    	    		 System.out.println("Sucessfully Message is" + actualPopup);
    	    		 data.clickOnLocator("id","popup_ok");
    	    		 Thread.sleep(1000);
    					System.out.println("Click Ok");
    	    		fileone.setCellData(sheetName, "Result", 226 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 226, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    @Test(priority=48)
    public void SqlCharNotAllowLastPlaceForMICRCode
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SqlCharNotAllowLastPlaceForMICRCode");
        	String MICRL= 	fileone1.getCellData("JuniorCAF", "MICR",7);
        			
        	
          System.out.println(MICRL);
          Thread.sleep(300);
          
          
          data.SelectDropdown("id", "ddlAIncome", "0 - 1,00,000");
          
          data.enterText("id","txtmicr",MICRL);
    	   		
          
          

          
      	
    	   		
    	   		Thread.sleep(7000);
    String actualPopup =data.grtpopup().getText();
    			
    			System.out.println(actualPopup);
    	    	
    			String expectedmessage = "Please write only numeric values for Aadhaar No.";

    	    	 if(!actualPopup.equals(expectedmessage))
    	    	 {
    	    		 System.out.println("Sucessfully Message is" + actualPopup);
    	    		 data.clickOnLocator("id","popup_ok");
    	    		 Thread.sleep(1000);
    					System.out.println("Click Ok");
    	    		fileone.setCellData(sheetName, "Result", 227 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 227, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    
    @Test(priority=48)
    public void SqlCharNotAllowMiddlePlaceForMICRCode
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SqlCharNotAllowMiddlePlaceForMICRCode");
        	String MICRM= 	fileone1.getCellData("JuniorCAF", "MICR",8);
        			
        	
          System.out.println(MICRM);
          Thread.sleep(300);
          
          
          data.SelectDropdown("id", "ddlAIncome", "0 - 1,00,000");
          
          data.enterText("id","txtmicr",MICRM);
    	   		
          
          

          
      	
    	   		
    	   		Thread.sleep(7000);
    String actualPopup =data.grtpopup().getText();
    			
    			System.out.println(actualPopup);
    	    	
    			String expectedmessage = "Please write only numeric values for Aadhaar No.";

    	    	 if(!actualPopup.equals(expectedmessage))
    	    	 {
    	    		 System.out.println("Sucessfully Message is" + actualPopup);
    	    		 data.clickOnLocator("id","popup_ok");
    	    		 Thread.sleep(1000);
    					System.out.println("Click Ok");
    	    		fileone.setCellData(sheetName, "Result", 228 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 228, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    @Test(priority=49)
    public void SqlCharNotAllowInitialPlaceForBankName
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SqlCharNotAllowInitialPlaceForBankName");
        	String BankI= 	fileone1.getCellData("JuniorCAF", "BankName",6);
        			
        	
          System.out.println(BankI);
          Thread.sleep(300);
          
          
          data.SelectDropdown("id", "ddlAIncome", "0 - 1,00,000");
          Thread.sleep(700);
          data.CheckSqlChar("id","txtBankname",BankI,"value","Data");
    	   		
          
          data.clickOnLocator("id", "btnSave");

          
      	
    	   		
    	   		Thread.sleep(7000);
    String actualPopup =data.grtpopup().getText();
    			
    			System.out.println(actualPopup);
    	    	
    			String expectedmessage = "Please write only numeric values for Aadhaar No.";

    	    	 if(!actualPopup.equals(expectedmessage))
    	    	 {
    	    		 System.out.println("Sucessfully Message is" + actualPopup);
    	    		 data.clickOnLocator("id","popup_ok");
    	    		 Thread.sleep(1000);
    					System.out.println("Click Ok");
    	    		fileone.setCellData(sheetName, "Result", 229 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 229, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    @Test(priority=50)
    public void SqlCharNotAllowLastPlaceForBankName
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SqlCharNotAllowLastPlaceForBankName");
        	String BankL= 	fileone1.getCellData("JuniorCAF", "BankName",7);
        			
        	
          System.out.println(BankL);
          Thread.sleep(300);
          
          
          data.SelectDropdown("id", "ddlAIncome", "0 - 1,00,000");
          Thread.sleep(700);
          data.CheckSqlChar("id","txtBankname",BankL,"value","Data");
    	   		
          
          data.clickOnLocator("id", "btnSave");

          
      	
    	   		
    	   		Thread.sleep(7000);
    String actualPopup =data.grtpopup().getText();
    			
    			System.out.println(actualPopup);
    	    	
    			String expectedmessage = "Please write only numeric values for Aadhaar No.";

    	    	 if(!actualPopup.equals(expectedmessage))
    	    	 {
    	    		 System.out.println("Sucessfully Message is" + actualPopup);
    	    		 data.clickOnLocator("id","popup_ok");
    	    		 Thread.sleep(1000);
    					System.out.println("Click Ok");
    	    		fileone.setCellData(sheetName, "Result", 230 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 230, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    
    
    @Test(priority=50)
    public void SqlCharNotAllowMiddlePlaceForBankName
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SqlCharNotAllowMiddlePlaceForBankName");
        	String BankM= 	fileone1.getCellData("JuniorCAF", "BankName",8);
        			
        	
          System.out.println(BankM);
          Thread.sleep(300);
          
          
          data.SelectDropdown("id", "ddlAIncome", "0 - 1,00,000");
          Thread.sleep(700);
          data.CheckSqlChar("id","txtBankname",BankM,"value","Data");
    	   		
          
          data.clickOnLocator("id", "btnSave");

          
      	
    	   		
    	   		Thread.sleep(7000);
    String actualPopup =data.grtpopup().getText();
    			
    			System.out.println(actualPopup);
    	    	
    			String expectedmessage = "Please write only numeric values for Aadhaar No.";

    	    	 if(!actualPopup.equals(expectedmessage))
    	    	 {
    	    		 System.out.println("Sucessfully Message is" + actualPopup);
    	    		 data.clickOnLocator("id","popup_ok");
    	    		 Thread.sleep(1000);
    					System.out.println("Click Ok");
    	    		fileone.setCellData(sheetName, "Result", 231 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 231, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    
    @Test(priority=51)
    public void SqlCharNotAllowInitialPlaceForBranchName
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SqlCharNotAllowInitialPlaceForBranchName");
        	String BranchI= 	fileone1.getCellData("JuniorCAF", "BranchName",6);
        			
        	
          System.out.println(BranchI);
          Thread.sleep(300);
          
          
          data.SelectDropdown("id", "ddlAIncome", "0 - 1,00,000");
          Thread.sleep(700);
          data.CheckSqlChar("id","txtBrname",BranchI,"value","Data");
    	   		
          
          data.clickOnLocator("id", "btnSave");

          
      	
    	   		
    	   		Thread.sleep(7000);
    String actualPopup =data.grtpopup().getText();
    			
    			System.out.println(actualPopup);
    	    	
    			String expectedmessage = "Please write only numeric values for Aadhaar No.";

    	    	 if(!actualPopup.equals(expectedmessage))
    	    	 {
    	    		 System.out.println("Sucessfully Message is" + actualPopup);
    	    		 data.clickOnLocator("id","popup_ok");
    	    		 Thread.sleep(1000);
    					System.out.println("Click Ok");
    	    		fileone.setCellData(sheetName, "Result", 232 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 232, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    
    @Test(priority=52)
    public void SqlCharNotAllowLastPlaceForBranchName
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SqlCharNotAllowLastPlaceForBranchName");
        	String BranchL= 	fileone1.getCellData("JuniorCAF", "BranchName",7);
        			
        	
          System.out.println(BranchL);
          Thread.sleep(300);
          
          
          data.SelectDropdown("id", "ddlAIncome", "0 - 1,00,000");
          Thread.sleep(700);
          data.CheckSqlChar("id","txtBrname",BranchL,"value","Data");
    	   		
          
          data.clickOnLocator("id", "btnSave");

          
      	
    	   		
    	   		Thread.sleep(7000);
    String actualPopup =data.grtpopup().getText();
    			
    			System.out.println(actualPopup);
    	    	
    			String expectedmessage = "Please write only numeric values for Aadhaar No.";

    	    	 if(!actualPopup.equals(expectedmessage))
    	    	 {
    	    		 System.out.println("Sucessfully Message is" + actualPopup);
    	    		 data.clickOnLocator("id","popup_ok");
    	    		 Thread.sleep(1000);
    					System.out.println("Click Ok");
    	    		fileone.setCellData(sheetName, "Result", 233 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 233, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    @Test(priority=53)
    public void SqlCharNotAllowMiddlePlaceForBranchName
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SqlCharNotAllowMiddlePlaceForBranchName");
        	String BranchM= 	fileone1.getCellData("JuniorCAF", "BranchName",8);
        			
        	
          System.out.println(BranchM);
          Thread.sleep(300);
          
          
          data.SelectDropdown("id", "ddlAIncome", "0 - 1,00,000");
          Thread.sleep(700);
          data.CheckSqlChar("id","txtBrname",BranchM,"value","Data");
    	   		
          
          data.clickOnLocator("id", "btnSave");

          
      	
    	   		
    	   		Thread.sleep(7000);
    String actualPopup =data.grtpopup().getText();
    			
    			System.out.println(actualPopup);
    	    	
    			String expectedmessage = "Please write only numeric values for Aadhaar No.";

    	    	 if(!actualPopup.equals(expectedmessage))
    	    	 {
    	    		 System.out.println("Sucessfully Message is" + actualPopup);
    	    		 data.clickOnLocator("id","popup_ok");
    	    		 Thread.sleep(1000);
    					System.out.println("Click Ok");
    	    		fileone.setCellData(sheetName, "Result", 234 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 234, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    
    @Test(priority=54)
    public void SqlCharNotAllowInitialPlaceForSchoolName
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SqlCharNotAllowInitialPlaceForSchoolName");
        	String SchoolNameI= 	fileone1.getCellData("JuniorCAF", "SchoolName",6);
        			
        	
          System.out.println(SchoolNameI);
          Thread.sleep(300);
          
          
         
          Thread.sleep(700);
          data.enterText("id","txtschname",SchoolNameI);
    	   		
          
          

          
      	
    	   		
    	   		Thread.sleep(7000);
    String actualPopup =data.grtpopup().getText();
    			
    			System.out.println(actualPopup);
    	    	
    			String expectedmessage = "Please write only numeric values for Aadhaar No.";

    	    	 if(!actualPopup.equals(expectedmessage))
    	    	 {
    	    		 System.out.println("Sucessfully Message is" + actualPopup);
    	    		 data.clickOnLocator("id","popup_ok");
    	    		 Thread.sleep(1000);
    					System.out.println("Click Ok");
    	    		fileone.setCellData(sheetName, "Result", 235 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 235, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    
    @Test(priority=55)
    public void SqlCharNotAllowLastPlaceForSchoolName
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SqlCharNotAllowLastPlaceForSchoolName");
        	String SchoolNameL= 	fileone1.getCellData("JuniorCAF", "SchoolName",7);
        			
        	
          System.out.println(SchoolNameL);
          Thread.sleep(300);
          
          
         
          Thread.sleep(700);
          data.enterText("id","txtschname",SchoolNameL);
    	   		
          
          

          
      	
    	   		
    	   		Thread.sleep(7000);
    String actualPopup =data.grtpopup().getText();
    			
    			System.out.println(actualPopup);
    	    	
    			String expectedmessage = "Please write only numeric values for Aadhaar No.";

    	    	 if(!actualPopup.equals(expectedmessage))
    	    	 {
    	    		 System.out.println("Sucessfully Message is" + actualPopup);
    	    		 data.clickOnLocator("id","popup_ok");
    	    		 Thread.sleep(1000);
    					System.out.println("Click Ok");
    	    		fileone.setCellData(sheetName, "Result", 236 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 236, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    
    @Test(priority=55)
    public void SqlCharNotAllowMiddlePlaceForSchoolName
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SqlCharNotAllowMiddlePlaceForSchoolName");
        	String SchoolNameM= 	fileone1.getCellData("JuniorCAF", "SchoolName",8);
        			
        	
          System.out.println(SchoolNameM);
          Thread.sleep(300);
          
          
         
          Thread.sleep(700);
          data.enterText("id","txtschname",SchoolNameM);
    	   		
          
          

          
      	
    	   		
    	   		Thread.sleep(7000);
    String actualPopup =data.grtpopup().getText();
    			
    			System.out.println(actualPopup);
    	    	
    			String expectedmessage = "Please write only numeric values for Aadhaar No.";

    	    	 if(!actualPopup.equals(expectedmessage))
    	    	 {
    	    		 System.out.println("Sucessfully Message is" + actualPopup);
    	    		 data.clickOnLocator("id","popup_ok");
    	    		 Thread.sleep(1000);
    					System.out.println("Click Ok");
    	    		fileone.setCellData(sheetName, "Result", 237 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 237, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    @Test(priority=56)
    public void SqlCharNotAllowInitialPlaceForSchoolLocation
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SqlCharNotAllowInitialPlaceForSchoolLocation");
        	String SchoolLocationI= 	fileone1.getCellData("JuniorCAF", "SchoolLocation",6);
        			
        	
          System.out.println(SchoolLocationI);
          Thread.sleep(300);
          
          
         
          Thread.sleep(700);
          data.enterText("id","txtschloc",SchoolLocationI);
    	   		
          
          

          
      	
    	   		
    	   		Thread.sleep(7000);
    String actualPopup =data.grtpopup().getText();
    			
    			System.out.println(actualPopup);
    	    	
    			String expectedmessage = "Please write only numeric values for Aadhaar No.";

    	    	 if(!actualPopup.equals(expectedmessage))
    	    	 {
    	    		 System.out.println("Sucessfully Message is" + actualPopup);
    	    		 data.clickOnLocator("id","popup_ok");
    	    		 Thread.sleep(1000);
    					System.out.println("Click Ok");
    	    		fileone.setCellData(sheetName, "Result", 238 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 238, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    @Test(priority=57)
    public void SqlCharNotAllowLastPlaceForSchoolLocation
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SqlCharNotAllowLastPlaceForSchoolLocation");
        	String SchoolLocationL= 	fileone1.getCellData("JuniorCAF", "SchoolLocation",7);
        			
        	
          System.out.println(SchoolLocationL);
          Thread.sleep(300);
          
          
         
          Thread.sleep(700);
          data.enterText("id","txtschloc",SchoolLocationL);
    	   		
          
          

          
      	
    	   		
    	   		Thread.sleep(7000);
    String actualPopup =data.grtpopup().getText();
    			
    			System.out.println(actualPopup);
    	    	
    			String expectedmessage = "Please write only numeric values for Aadhaar No.";

    	    	 if(!actualPopup.equals(expectedmessage))
    	    	 {
    	    		 System.out.println("Sucessfully Message is" + actualPopup);
    	    		 data.clickOnLocator("id","popup_ok");
    	    		 Thread.sleep(1000);
    					System.out.println("Click Ok");
    	    		fileone.setCellData(sheetName, "Result", 239 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 239, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    @Test(priority=58)
    public void SqlCharNotAllowMiddlePlaceForSchoolLocation
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SqlCharNotAllowMiddlePlaceForSchoolLocation");
        	String SchoolLocationM= 	fileone1.getCellData("JuniorCAF", "SchoolLocation",8);
        			
        	
          System.out.println(SchoolLocationM);
          Thread.sleep(300);
          
          
         
          Thread.sleep(700);
          data.enterText("id","txtschloc",SchoolLocationM);
    	   		
          
          

          
      	
    	   		
    	   		Thread.sleep(7000);
    String actualPopup =data.grtpopup().getText();
    			
    			System.out.println(actualPopup);
    	    	
    			String expectedmessage = "Please write only numeric values for Aadhaar No.";

    	    	 if(!actualPopup.equals(expectedmessage))
    	    	 {
    	    		 System.out.println("Sucessfully Message is" + actualPopup);
    	    		 data.clickOnLocator("id","popup_ok");
    	    		 Thread.sleep(1000);
    					System.out.println("Click Ok");
    	    		fileone.setCellData(sheetName, "Result", 240 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 240, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    
    
    @Test(priority=59)
    public void SqlCharNotAllowInitialPlaceForFailMark
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SqlCharNotAllowInitialPlaceForFailMark");
        	String FailMarkI= 	fileone1.getCellData("JuniorCAF", "FailMark",6);
        			
        	
          System.out.println(FailMarkI);
         // Thread.sleep(300);
          
          Thread.sleep(700);
          data.clickOnLocator("id","rbtCompartmentalY");
         
          Thread.sleep(700);
          data.enterText("id","txtCompFMark1",FailMarkI);
    	   		
          
          

          
      	
    	   		
    	   		Thread.sleep(7000);
    String actualPopup =data.grtpopup().getText();
    			
    			System.out.println(actualPopup);
    	    	
    			String expectedmessage = "Please write only numeric values for Aadhaar No.";

    	    	 if(!actualPopup.equals(expectedmessage))
    	    	 {
    	    		 System.out.println("Sucessfully Message is" + actualPopup);
    	    		 data.clickOnLocator("id","popup_ok");
    	    		 Thread.sleep(1000);
    					System.out.println("Click Ok");
    	    		fileone.setCellData(sheetName, "Result", 241 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 241, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    @Test(priority=60)
    public void SqlCharNotAllowLastPlaceForFailMark
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SqlCharNotAllowLastPlaceForFailMark");
        	String FailMarkL= 	fileone1.getCellData("JuniorCAF", "FailMark",7);
        			
        	
          System.out.println(FailMarkL);
         // Thread.sleep(300);
          
          Thread.sleep(700);
          data.clickOnLocator("id","rbtCompartmentalY");
         
          Thread.sleep(700);
          data.enterText("id","txtCompFMark1",FailMarkL);
    	   		
          
          

          
      	
    	   		
    	   		Thread.sleep(7000);
    String actualPopup =data.grtpopup().getText();
    			
    			System.out.println(actualPopup);
    	    	
    			String expectedmessage = "Please write only numeric values for Aadhaar No.";

    	    	 if(!actualPopup.equals(expectedmessage))
    	    	 {
    	    		 System.out.println("Sucessfully Message is" + actualPopup);
    	    		 data.clickOnLocator("id","popup_ok");
    	    		 Thread.sleep(1000);
    					System.out.println("Click Ok");
    	    		fileone.setCellData(sheetName, "Result", 242 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 242, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    @Test(priority=61)
    public void SqlCharNotAllowMiddlePlaceForFailMark
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SqlCharNotAllowMiddlePlaceForFailMark");
        	String FailMarkM= 	fileone1.getCellData("JuniorCAF", "FailMark",8);
        			
        	
          System.out.println(FailMarkM);
         // Thread.sleep(300);
          
          Thread.sleep(700);
          data.clickOnLocator("id","rbtCompartmentalY");
         
          Thread.sleep(700);
          data.enterText("id","txtCompFMark1",FailMarkM);
    	   		
          
          

          
      	
    	   		
    	   		Thread.sleep(7000);
    String actualPopup =data.grtpopup().getText();
    			
    			System.out.println(actualPopup);
    	    	
    			String expectedmessage = "Please write only numeric values for Aadhaar No.";

    	    	 if(!actualPopup.equals(expectedmessage))
    	    	 {
    	    		 System.out.println("Sucessfully Message is" + actualPopup);
    	    		 data.clickOnLocator("id","popup_ok");
    	    		 Thread.sleep(1000);
    					System.out.println("Click Ok");
    	    		fileone.setCellData(sheetName, "Result", 243 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 243, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    @Test(priority=62)
    public void SqlCharNotAllowInitialPlaceForPassMark
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SqlCharNotAllowInitialPlaceForPassMark");
        	String PassMarkI= 	fileone1.getCellData("JuniorCAF", "PassMark",6);
        			
        	
          System.out.println(PassMarkI);
         // Thread.sleep(300);
          
          Thread.sleep(700);
          data.clickOnLocator("id","rbtCompartmentalY");
         
          Thread.sleep(700);
          data.enterText("id","txtCompPMark1",PassMarkI);
    	   		
          
          

          
      	
    	   		
    	   		Thread.sleep(7000);
    String actualPopup =data.grtpopup().getText();
    			
    			System.out.println(actualPopup);
    	    	
    			String expectedmessage = "Please write only numeric values for Aadhaar No.";

    	    	 if(!actualPopup.equals(expectedmessage))
    	    	 {
    	    		 System.out.println("Sucessfully Message is" + actualPopup);
    	    		 data.clickOnLocator("id","popup_ok");
    	    		 Thread.sleep(1000);
    					System.out.println("Click Ok");
    	    		fileone.setCellData(sheetName, "Result", 244 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 244, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    @Test(priority=62)
    public void SqlCharNotAllowLastPlaceForPassMark
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SqlCharNotAllowLastPlaceForPassMark");
        	String PassMarkL= 	fileone1.getCellData("JuniorCAF", "PassMark",7);
        			
        	
          System.out.println(PassMarkL);
         // Thread.sleep(300);
          
          Thread.sleep(700);
          data.clickOnLocator("id","rbtCompartmentalY");
         
          Thread.sleep(700);
          data.enterText("id","txtCompPMark1",PassMarkL);
    	   		
          
          

          
      	
    	   		
    	   		Thread.sleep(7000);
    String actualPopup =data.grtpopup().getText();
    			
    			System.out.println(actualPopup);
    	    	
    			String expectedmessage = "Please write only numeric values for Aadhaar No.";

    	    	 if(!actualPopup.equals(expectedmessage))
    	    	 {
    	    		 System.out.println("Sucessfully Message is" + actualPopup);
    	    		 data.clickOnLocator("id","popup_ok");
    	    		 Thread.sleep(1000);
    					System.out.println("Click Ok");
    	    		fileone.setCellData(sheetName, "Result", 245 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 245, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    @Test(priority=62)
    public void SqlCharNotAllowMiddlePlaceForPassMark
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SqlCharNotAllowMiddlePlaceForPassMark");
        	String PassMarkM= 	fileone1.getCellData("JuniorCAF", "PassMark",8);
        			
        	
          System.out.println(PassMarkM);
         // Thread.sleep(300);
          
          Thread.sleep(700);
          data.clickOnLocator("id","rbtCompartmentalY");
         
          Thread.sleep(700);
          data.enterText("id","txtCompPMark1",PassMarkM);
    	   		
          
          

          
      	
    	   		
    	   		Thread.sleep(7000);
    String actualPopup =data.grtpopup().getText();
    			
    			System.out.println(actualPopup);
    	    	
    			String expectedmessage = "Please write only numeric values for Aadhaar No.";

    	    	 if(!actualPopup.equals(expectedmessage))
    	    	 {
    	    		 System.out.println("Sucessfully Message is" + actualPopup);
    	    		 data.clickOnLocator("id","popup_ok");
    	    		 Thread.sleep(1000);
    					System.out.println("Click Ok");
    	    		fileone.setCellData(sheetName, "Result", 246 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 246, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
   	}
   

