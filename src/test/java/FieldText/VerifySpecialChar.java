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

public class VerifySpecialChar extends ExtentReportBase {
	
	
	
	//private static final int j = 0;
	static Xls_AllMethods fileone = new Xls_AllMethods("C:/Users/satyaranjan.m/eclipse-workspace/JuniorForm/JuniorFieldValidationwrite.xlsx");	
	
	 
	 static Xls_AllMethods fileone1 = new Xls_AllMethods("C:/Users/satyaranjan.m/eclipse-workspace/JuniorForm/RoughSheet.xlsx");
	 
	 
	 
	 
	 
	 
	XSSFWorkbook wb;
	XSSFSheet sht;
	String sheetName = "JuniorFieldMapping";
	int rowCount = fileone.getRowCount(sheetName);


 	static WebDriver driver;
	CommonFunction data = new CommonFunction();
	

	@Test(priority=63)
   	public void SpecialCharNotAllowInitialPlaceForRollNumber
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
    	String RollNumberI = 	fileone1.getCellData("JuniorCAF", "RollNumber",2);
    			
    	
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
	    		fileone.setCellData(sheetName, "Result", 103 , "Pass");	
	    	 }
	    	
	    	 else
	    	 {
	    		 fileone.setCellData(sheetName, "Result", 103, "Fail");
	    	 }	
	    	 
	    	 SoftAssert softAssert = new SoftAssert();
	    	 softAssert.assertEquals(actualPopup, actualPopup);
		   	}
    
    
    @Test(priority=64)
   	public void SpecialCharNotAllowLastPlaceForRollNumber
(



) throws IOException, InterruptedException
   	{
    	test = extent.createTest("SpecialCharNotAllowLastPlaceForApplicantName");
    	String RollNumberI = 	fileone1.getCellData("JuniorCAF", "RollNumber",3);
		
    	
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
	    		fileone.setCellData(sheetName, "Result", 104 , "Pass");	
	    	 }
	    	
	    	 else
	    	 {
	    		 fileone.setCellData(sheetName, "Result", 104, "Fail");
	    	 }	
	    	 
	    	 SoftAssert softAssert = new SoftAssert();
	    	 softAssert.assertEquals(actualPopup, actualPopup);
		   	}
    
    
    @Test(priority=65)
   	public void SpecialCharNotAllowMiddlePlaceForRollNumber
(



) throws IOException, InterruptedException
   	{
    	test = extent.createTest("SpecialCharNotAllowMiddlePlaceForApplicantName");
String RollNumberI = 	fileone1.getCellData("JuniorCAF", "RollNumber",4);
		
    	
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
	    		fileone.setCellData(sheetName, "Result", 105 , "Pass");	
	    	 }
	    	
	    	 else
	    	 {
	    		 fileone.setCellData(sheetName, "Result", 105, "Fail");
	    	 }	
	    	 
	    	 SoftAssert softAssert = new SoftAssert();
	    	 softAssert.assertEquals(actualPopup, actualPopup);
		   	}
   
    
    
    @Test(priority=0)
   	public void SpecialCharNotAllowInitialPlaceForApplicantName
(



) throws IOException, InterruptedException
   	{
    	test = extent.createTest("SpecialCharNotAllowInitialPlaceForApplicantName");
    	
    	
    	String ApplicantNameI = 	fileone1.getCellData("JuniorCAF", "ApplicantName",2);
    			
    	
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
	    		fileone.setCellData(sheetName, "Result", 106 , "Pass");	
	    	 }
	    	
	    	 else
	    	 {
	    		 fileone.setCellData(sheetName, "Result", 106, "Fail");
	    	 }	
	    	 
	    	 SoftAssert softAssert = new SoftAssert();
	    	 softAssert.assertEquals(actualPopup, actualPopup);
		   	}
    
    
    @Test(priority=1)
   	public void SpecialCharNotAllowLastPlaceForApplicantName
(



) throws IOException, InterruptedException
   	{
    	test = extent.createTest("SpecialCharNotAllowLastPlaceForApplicantName");
    	String ApplicantNameL = 	fileone1.getCellData("JuniorCAF", "ApplicantName",3);
    			
    	
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
	    		fileone.setCellData(sheetName, "Result", 107 , "Pass");	
	    	 }
	    	
	    	 else
	    	 {
	    		 fileone.setCellData(sheetName, "Result", 107, "Fail");
	    	 }	
	    	 
	    	 SoftAssert softAssert = new SoftAssert();
	    	 softAssert.assertEquals(actualPopup, actualPopup);
		   	}
    
    
    @Test(priority=2)
   	public void SpecialCharNotAllowMiddlePlaceForApplicantName
(



) throws IOException, InterruptedException
   	{
    	test = extent.createTest("SpecialCharNotAllowMiddlePlaceForApplicantName");
    	String ApplicantNameM = 	fileone1.getCellData("JuniorCAF", "ApplicantName",4);
    			
    	
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
	    		fileone.setCellData(sheetName, "Result", 108 , "Pass");	
	    	 }
	    	
	    	 else
	    	 {
	    		 fileone.setCellData(sheetName, "Result", 108, "Fail");
	    	 }	
	    	 
	    	 SoftAssert softAssert = new SoftAssert();
	    	 softAssert.assertEquals(actualPopup, actualPopup);
		   	}
    
    
    
    @Test(priority=3)
   	public void SpecialCharNotAllowInitialPlaceForFatherName
(



) throws IOException, InterruptedException
   	{
    	test = extent.createTest("SpecialCharNotAllowInitialPlaceForFatherName");
    	String FatherNameI = 	fileone1.getCellData("JuniorCAF", "FatherName",2);
    			
    	
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
	    		fileone.setCellData(sheetName, "Result", 109 , "Pass");	
	    	 }
	    	
	    	 else
	    	 {
	    		 fileone.setCellData(sheetName, "Result", 109, "Fail");
	    	 }	
	    	 
	    	 SoftAssert softAssert = new SoftAssert();
	    	 softAssert.assertEquals(actualPopup, actualPopup);
		   	}
    
    
    @Test(priority=4)
   	public void SpecialCharNotAllowLastPlaceForFatherName
(



) throws IOException, InterruptedException
   	{
    	test = extent.createTest("SpecialCharNotAllowLastPlaceForFatherName");
    	String FatherNameL = 	fileone1.getCellData("JuniorCAF", "FatherName",3);
    			
    	
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
	    		fileone.setCellData(sheetName, "Result", 110 , "Pass");	
	    	 }
	    	
	    	 else
	    	 {
	    		 fileone.setCellData(sheetName, "Result", 110, "Fail");
	    	 }	
	    	 
	    	 SoftAssert softAssert = new SoftAssert();
	    	 softAssert.assertEquals(actualPopup, actualPopup);
		   	}
    
    
    @Test(priority=5)
   	public void SpecialCharNotAllowMiddlePlaceForFatherName
(



) throws IOException, InterruptedException
   	{
    	test = extent.createTest("SpecialCharNotAllowMiddlePlaceForFatherName");
    	String FatherNameM = 	fileone1.getCellData("JuniorCAF", "FatherName",4);
    			
    	
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
	    		fileone.setCellData(sheetName, "Result", 111 , "Pass");	
	    	 }
	    	
	    	 else
	    	 {
	    		 fileone.setCellData(sheetName, "Result", 111, "Fail");
	    	 }	
	    	 
	    	 SoftAssert softAssert = new SoftAssert();
	    	 softAssert.assertEquals(actualPopup, actualPopup);
		   	}
    
    
    
    @Test(priority=6)
   	public void SpecialCharNotAllowInitialPlaceForMotherName
(



) throws IOException, InterruptedException
   	{
    	test = extent.createTest("SpecialCharNotAllowInitialPlaceForMotherName");
    	String MotherNameI = 	fileone1.getCellData("JuniorCAF", "MotherName",2);
    			
    	
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
	    		fileone.setCellData(sheetName, "Result", 112 , "Pass");	
	    	 }
	    	
	    	 else
	    	 {
	    		 fileone.setCellData(sheetName, "Result", 112, "Fail");
	    	 }	
	    	 
	    	 SoftAssert softAssert = new SoftAssert();
	    	 softAssert.assertEquals(actualPopup, actualPopup);
		   	}
    
    
    
    @Test(priority=7)
   	public void SpecialCharNotAllowLastPlaceForMotherName
(



) throws IOException, InterruptedException
   	{
    	test = extent.createTest("SpecialCharNotAllowLastPlaceForMotherName");
    	String MotherNameL = 	fileone1.getCellData("JuniorCAF", "MotherName",3);
    			
    	
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
	    		fileone.setCellData(sheetName, "Result", 113 , "Pass");	
	    	 }
	    	
	    	 else
	    	 {
	    		 fileone.setCellData(sheetName, "Result", 113, "Fail");
	    	 }	
	    	 
	    	 SoftAssert softAssert = new SoftAssert();
	    	 softAssert.assertEquals(actualPopup, actualPopup);
		   	}
    
    
    @Test(priority=8)
   	public void SpecialCharNotAllowMiddlePlaceForMotherName
(



) throws IOException, InterruptedException
   	{
    	test = extent.createTest("SpecialCharNotAllowMiddlePlaceForMotherName");
    	String MotherNameM = 	fileone1.getCellData("JuniorCAF", "MotherName",4);
    			
    	
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
	    		fileone.setCellData(sheetName, "Result", 114 , "Pass");	
	    	 }
	    	
	    	 else
	    	 {
	    		 fileone.setCellData(sheetName, "Result", 114, "Fail");
	    	 }	
	    	 
	    	 SoftAssert softAssert = new SoftAssert();
	    	 softAssert.assertEquals(actualPopup, actualPopup);
		   	}
    
    @Test(priority=9)
   	public void SpecialCharNotAllowInitialPlaceForAadharNumber
	() throws IOException, InterruptedException
   	{
    	test = extent.createTest("SpecialCharNotAllowInitialPlaceForAadharNumber");
    	String AadharNoI = 	fileone1.getCellData("JuniorCAF", "AadharNo",2);
    			
    	
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
	    		fileone.setCellData(sheetName, "Result", 115 , "Pass");	
	    	 }
	    	
	    	 else
	    	 {
	    		 fileone.setCellData(sheetName, "Result", 115, "Fail");
	    	 }	
	    	 
	    	 SoftAssert softAssert = new SoftAssert();
	    	 softAssert.assertEquals(actualPopup, actualPopup);
		   	}
    @Test(priority=10)
    public void SpecialCharNotAllowLastPlaceForAadharNumber
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SpecialCharNotAllowLastPlaceForAadharNumber");
        	String AadharNoL = 	fileone1.getCellData("JuniorCAF", "AadharNo",3);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 116 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 116, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    @Test(priority=11)
    public void SpecialCharNotAllowMiddlePlaceForAadharNumber
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SpecialCharNotAllowMiddlePlaceForAadharNumber");
        	String AadharNoM = 	fileone1.getCellData("JuniorCAF", "AadharNo",4);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 117 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 117, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    @Test(priority=12)
    public void SpecialCharNotAllowInitialPlaceForMobileNo
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SpecialCharNotAllowInitialPlaceForMobileNo");
        	String MobileNoI = 	fileone1.getCellData("JuniorCAF", "MobileNo",2);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 118 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 118, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    @Test(priority=13)
    public void SpecialCharNotAllowLastPlaceForMobileNo
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SpecialCharNotAllowLastPlaceForMobileNo");
        	String MobileNoL = 	fileone1.getCellData("JuniorCAF", "MobileNo",3);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 119 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 119, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    
    @Test(priority=14)
    public void SpecialCharNotAllowMiddlePlaceForMobileNo
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SpecialCharNotAllowMiddlePlaceForMobileNo");
        	String MobileNoM = 	fileone1.getCellData("JuniorCAF", "MobileNo",4);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 120 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 120, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    
    @Test(priority=15)
    public void SpecialCharNotAllowInitialPlaceForPinCode
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SpecialCharNotAllowInitialPlaceForPinCode");
        	String PinCodeI = 	fileone1.getCellData("JuniorCAF", "PinCode",2);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 121 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 121, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    
    @Test(priority=16)
    public void SpecialCharNotAllowLastPlaceForPinCode
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SpecialCharNotAllowLastPlaceForPinCode");
        	String PinCodeL = 	fileone1.getCellData("JuniorCAF", "PinCode",3);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 122 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 122, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    @Test(priority=17)
    public void SpecialCharNotAllowMiddlePlaceForPinCode
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SpecialCharNotAllowMiddlePlaceForPinCode");
        	String PinCodeM = 	fileone1.getCellData("JuniorCAF", "PinCode",4);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 123 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 123, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    @Test(priority=18)
    public void SpecialCharNotAllowInitialPlaceForAreaCode
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SpecialCharNotAllowInitialPlaceForAreaCode");
        	String AreaCodeI = 	fileone1.getCellData("JuniorCAF", "AreaCode",2);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 124 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 124, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    
    @Test(priority=19)
    public void SpecialCharNotAllowLastPlaceForAreaCode
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SpecialCharNotAllowLastPlaceForAreaCode");
        	String AreaCodeL = 	fileone1.getCellData("JuniorCAF", "AreaCode",3);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 125 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 125, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    @Test(priority=20)
    public void SpecialCharNotAllowMiddlePlaceForAreaCode
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SpecialCharNotAllowMiddlePlaceForAreaCode");
        	String AreaCodeM = 	fileone1.getCellData("JuniorCAF", "AreaCode",4);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 126 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 126, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    @Test(priority=21)
    public void SpecialCharNotAllowInitialPlaceForPhoneNo
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SpecialCharNotAllowInitialPlaceForPhoneNo");
        	String PhoneNoI = 	fileone1.getCellData("JuniorCAF", "PhoneNo",2);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 127 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 127, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    
    @Test(priority=22)
    public void SpecialCharNotAllowLastPlaceForPhoneNo
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SpecialCharNotAllowLastPlaceForPhoneNo");
        	String PhoneNoL= 	fileone1.getCellData("JuniorCAF", "PhoneNo",3);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 128 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 128, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    @Test(priority=23)
    public void SpecialCharNotAllowMiddlePlaceForPhoneNo
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SpecialCharNotAllowMiddlePlaceForPhoneNo");
        	String PhoneNoM= 	fileone1.getCellData("JuniorCAF", "PhoneNo",4);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 129 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 129, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    @Test(priority=24)
    public void SpecialCharNotAllowInitialPlaceForMaximumMark
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SpecialCharNotAllowInitialPlaceForMaximumMark");
        	String MaximumMarkI= 	fileone1.getCellData("JuniorCAF", "MaximumMark",2);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 130 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 130, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    @Test(priority=25)
    public void SpecialCharNotAllowLastPlaceForMaximumMark
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SpecialCharNotAllowLastPlaceForMaximumMark");
        	String MaximumMarkL= 	fileone1.getCellData("JuniorCAF", "MaximumMark",3);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 131 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 131, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    
    @Test(priority=26)
    public void SpecialCharNotAllowMiddlePlaceForMaximumMark
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SpecialCharNotAllowMiddlePlaceForMaximumMark");
        	String MaximumMarkM= 	fileone1.getCellData("JuniorCAF", "MaximumMark",4);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 132 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 132, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    @Test(priority=27)
    public void SpecialCharNotAllowInitialPlaceForSecuredMark
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SpecialCharNotAllowInitialPlaceForSecuredMark");
        	String SecuredMarkI= 	fileone1.getCellData("JuniorCAF", "SecuredMark",2);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 133 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 133, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    @Test(priority=28)
    public void SpecialCharNotAllowLastPlaceForSecuredMark
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SpecialCharNotAllowLastPlaceForSecuredMark");
        	String SecuredMarkL= 	fileone1.getCellData("JuniorCAF", "SecuredMark",3);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 134 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 134, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    @Test(priority=29)
    public void SpecialCharNotAllowMiddlePlaceForSecuredMark
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SpecialCharNotAllowMiddlePlaceForSecuredMark");
        	String SecuredMarkM= 	fileone1.getCellData("JuniorCAF", "SecuredMark",4);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 135 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 135, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    
    @Test(priority=30)
    public void SpecialCharNotAllowInitialPlaceForEnglish
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SpecialCharNotAllowInitialPlaceForEnglish");
        	String EnglishI= 	fileone1.getCellData("JuniorCAF", "English",2);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 136 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 136, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    @Test(priority=31)
    public void SpecialCharNotAllowLastPlaceForEnglish
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SpecialCharNotAllowLastPlaceForEnglish");
        	String EnglishL= 	fileone1.getCellData("JuniorCAF", "English",3);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 137 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 137, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    
    @Test(priority=32)
    public void SpecialCharNotAllowMiddlePlaceForEnglish
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SpecialCharNotAllowMiddlePlaceForEnglish");
        	String EnglishM= 	fileone1.getCellData("JuniorCAF", "English",4);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 138 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 138, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    
    @Test(priority=33)
    public void SpecialCharNotAllowInitialPlaceForMath
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SpecialCharNotAllowInitialPlaceForMath");
        	String MathI= 	fileone1.getCellData("JuniorCAF", "Math",2);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 139 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 139, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    @Test(priority=34)
    public void SpecialCharNotAllowLastPlaceForMath
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SpecialCharNotAllowLastPlaceForMath");
        	String MathL= 	fileone1.getCellData("JuniorCAF", "Math",3);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 140 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 140, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    
    
    @Test(priority=35)
    public void SpecialCharNotAllowMiddlePlaceForMath
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SpecialCharNotAllowMiddlePlaceForMath");
        	String MathM= 	fileone1.getCellData("JuniorCAF", "Math",4);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 141 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 141, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    
    @Test(priority=36)
    public void SpecialCharNotAllowInitialPlaceForScience
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SpecialCharNotAllowInitialPlaceForScience");
        	String ScienceI= 	fileone1.getCellData("JuniorCAF", "Science",2);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 142 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 142, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    @Test(priority=37)
    public void SpecialCharNotAllowLastPlaceForScience
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SpecialCharNotAllowLastPlaceForScience");
        	String ScienceL= 	fileone1.getCellData("JuniorCAF", "Science",3);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 143 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 143, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    @Test(priority=38)
    public void SpecialCharNotAllowMiddlePlaceForScience
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SpecialCharNotAllowMiddlePlaceForScience");
        	String ScienceM= 	fileone1.getCellData("JuniorCAF", "Science",4);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 144 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 144, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    @Test(priority=39)
    public void SpecialCharNotAllowInitialPlaceForSocialScience
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SpecialCharNotAllowInitialPlaceForSocialScience");
        	String SocialScienceI= 	fileone1.getCellData("JuniorCAF", "SocialScience",2);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 145 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 145, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    @Test(priority=40)
    public void SpecialCharNotAllowLastPlaceForSocialScience
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SpecialCharNotAllowLastPlaceForSocialScience");
        	String SocialScienceL= 	fileone1.getCellData("JuniorCAF", "SocialScience",3);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 146 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 146, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    
    @Test(priority=41)
    public void SpecialCharNotAllowMiddlePlaceForSocialScience
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SpecialCharNotAllowMiddlePlaceForSocialScience");
        	String SocialScienceM= 	fileone1.getCellData("JuniorCAF", "SocialScience",4);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 147 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 147, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    
    @Test(priority=42)
    public void SpecialCharNotAllowInitialPlaceForAccountNumber
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SpecialCharNotAllowInitialPlaceForAccountNumber");
        	String AccountNumberI= 	fileone1.getCellData("JuniorCAF", "AccountNumber",2);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 148 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 148, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    
    @Test(priority=43)
    public void SpecialCharNotAllowLastPlaceForAccountNumber
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SpecialCharNotAllowLastPlaceForAccountNumber");
        	String AccountNumberL= 	fileone1.getCellData("JuniorCAF", "AccountNumber",3);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 149 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 149, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    @Test(priority=44)
    public void SpecialCharNotAllowMiddlePlaceForAccountNumber
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SpecialCharNotAllowMiddlePlaceForAccountNumber");
        	String AccountNumberM= 	fileone1.getCellData("JuniorCAF", "AccountNumber",4);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 150 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 150, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    @Test(priority=45)
    public void SpecialCharNotAllowInitialPlaceForIFSCCode
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SpecialCharNotAllowInitialPlaceForIFSCCode");
        	String IFSCI= 	fileone1.getCellData("JuniorCAF", "IFSC",2);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 151 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 151, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    
    @Test(priority=46)
    public void SpecialCharNotAllowLastPlaceForIFSCCode
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SpecialCharNotAllowLastPlaceForIFSCCode");
        	String IFSCL= 	fileone1.getCellData("JuniorCAF", "IFSC",3);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 152 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 152, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    @Test(priority=47)
    public void SpecialCharNotAllowMiddlePlaceForIFSCCode
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SpecialCharNotAllowMiddlePlaceForIFSCCode");
        	String IFSCM= 	fileone1.getCellData("JuniorCAF", "IFSC",4);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 153 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 153, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    @Test(priority=48)
    public void SpecialCharNotAllowInitialPlaceForMICRCode
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SpecialCharNotAllowInitialPlaceForMICRCode");
        	String MICRI= 	fileone1.getCellData("JuniorCAF", "MICR",2);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 154 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 154, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    @Test(priority=48)
    public void SpecialCharNotAllowLastPlaceForMICRCode
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SpecialCharNotAllowLastPlaceForMICRCode");
        	String MICRL= 	fileone1.getCellData("JuniorCAF", "MICR",3);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 155 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 155, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    
    @Test(priority=48)
    public void SpecialCharNotAllowMiddlePlaceForMICRCode
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SpecialCharNotAllowMiddlePlaceForMICRCode");
        	String MICRM= 	fileone1.getCellData("JuniorCAF", "MICR",4);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 156 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 156, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    @Test(priority=49)
    public void SpecialCharNotAllowInitialPlaceForBankName
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SpecialCharNotAllowInitialPlaceForBankName");
        	String BankI= 	fileone1.getCellData("JuniorCAF", "BankName",2);
        			
        	
          System.out.println(BankI);
          Thread.sleep(300);
          
          
          data.SelectDropdown("id", "ddlAIncome", "0 - 1,00,000");
          Thread.sleep(700);
          data.CheckSpecialChar("id","txtBankname",BankI,"value","Data");
    	   		
          
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
    	    		fileone.setCellData(sheetName, "Result", 157 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 157, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    @Test(priority=50)
    public void SpecialCharNotAllowLastPlaceForBankName
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SpecialCharNotAllowLastPlaceForBankName");
        	String BankL= 	fileone1.getCellData("JuniorCAF", "BankName",3);
        			
        	
          System.out.println(BankL);
          Thread.sleep(300);
          
          
          data.SelectDropdown("id", "ddlAIncome", "0 - 1,00,000");
          Thread.sleep(700);
          data.CheckSpecialChar("id","txtBankname",BankL,"value","Data");
    	   		
          
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
    	    		fileone.setCellData(sheetName, "Result", 158 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 158, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    
    
    @Test(priority=50)
    public void SpecialCharNotAllowMiddlePlaceForBankName
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SpecialCharNotAllowMiddlePlaceForBankName");
        	String BankM= 	fileone1.getCellData("JuniorCAF", "BankName",4);
        			
        	
          System.out.println(BankM);
          Thread.sleep(300);
          
          
          data.SelectDropdown("id", "ddlAIncome", "0 - 1,00,000");
          Thread.sleep(700);
          data.CheckSpecialChar("id","txtBankname",BankM,"value","Data");
    	   		
          
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
    	    		fileone.setCellData(sheetName, "Result", 159 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 159, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    
    @Test(priority=51)
    public void SpecialCharNotAllowInitialPlaceForBranchName
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SpecialCharNotAllowInitialPlaceForBranchName");
        	String BranchI= 	fileone1.getCellData("JuniorCAF", "BranchName",2);
        			
        	
          System.out.println(BranchI);
          Thread.sleep(300);
          
          
          data.SelectDropdown("id", "ddlAIncome", "0 - 1,00,000");
          Thread.sleep(700);
          data.CheckSpecialChar("id","txtBrname",BranchI,"value","Data");
    	   		
          
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
    	    		fileone.setCellData(sheetName, "Result", 160 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 160, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    
    @Test(priority=52)
    public void SpecialCharNotAllowLastPlaceForBranchName
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SpecialCharNotAllowLastPlaceForBranchName");
        	String BranchL= 	fileone1.getCellData("JuniorCAF", "BranchName",3);
        			
        	
          System.out.println(BranchL);
          Thread.sleep(300);
          
          
          data.SelectDropdown("id", "ddlAIncome", "0 - 1,00,000");
          Thread.sleep(700);
          data.CheckSpecialChar("id","txtBrname",BranchL,"value","Data");
    	   		
          
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
    	    		fileone.setCellData(sheetName, "Result", 161 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 161, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    @Test(priority=53)
    public void SpecialCharNotAllowMiddlePlaceForBranchName
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SpecialCharNotAllowMiddlePlaceForBranchName");
        	String BranchM= 	fileone1.getCellData("JuniorCAF", "BranchName",4);
        			
        	
          System.out.println(BranchM);
          Thread.sleep(300);
          
          
          data.SelectDropdown("id", "ddlAIncome", "0 - 1,00,000");
          Thread.sleep(700);
          data.CheckSpecialChar("id","txtBrname",BranchM,"value","Data");
    	   		
          
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
    	    		fileone.setCellData(sheetName, "Result", 162 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 162, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    
    @Test(priority=54)
    public void SpecialCharNotAllowInitialPlaceForSchoolName
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SpecialCharNotAllowInitialPlaceForSchoolName");
        	String SchoolNameI= 	fileone1.getCellData("JuniorCAF", "SchoolName",2);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 163 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 163, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    
    @Test(priority=55)
    public void SpecialCharNotAllowLastPlaceForSchoolName
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SpecialCharNotAllowLastPlaceForSchoolName");
        	String SchoolNameL= 	fileone1.getCellData("JuniorCAF", "SchoolName",3);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 164 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 164, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    
    @Test(priority=55)
    public void SpecialCharNotAllowMiddlePlaceForSchoolName
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SpecialCharNotAllowMiddlePlaceForSchoolName");
        	String SchoolNameM= 	fileone1.getCellData("JuniorCAF", "SchoolName",4);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 165 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 165, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    @Test(priority=56)
    public void SpecialCharNotAllowInitialPlaceForSchoolLocation
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SpecialCharNotAllowInitialPlaceForSchoolLocation");
        	String SchoolLocationI= 	fileone1.getCellData("JuniorCAF", "SchoolLocation",2);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 166 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 166, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    @Test(priority=57)
    public void SpecialCharNotAllowLastPlaceForSchoolLocation
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SpecialCharNotAllowLastPlaceForSchoolLocation");
        	String SchoolLocationL= 	fileone1.getCellData("JuniorCAF", "SchoolLocation",3);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 167 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 167, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    @Test(priority=58)
    public void SpecialCharNotAllowMiddlePlaceForSchoolLocation
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SpecialCharNotAllowMiddlePlaceForSchoolLocation");
        	String SchoolLocationM= 	fileone1.getCellData("JuniorCAF", "SchoolLocation",4);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 168 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 168, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    
    
    @Test(priority=59)
    public void SpecialCharNotAllowInitialPlaceForFailMark
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SpecialCharNotAllowInitialPlaceForFailMark");
        	String FailMarkI= 	fileone1.getCellData("JuniorCAF", "FailMark",2);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 169 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 169, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    @Test(priority=60)
    public void SpecialCharNotAllowLastPlaceForFailMark
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SpecialCharNotAllowLastPlaceForFailMark");
        	String FailMarkL= 	fileone1.getCellData("JuniorCAF", "FailMark",3);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 170 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 170, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    @Test(priority=61)
    public void SpecialCharNotAllowMiddlePlaceForFailMark
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SpecialCharNotAllowMiddlePlaceForFailMark");
        	String FailMarkM= 	fileone1.getCellData("JuniorCAF", "FailMark",4);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 171 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 171, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    @Test(priority=62)
    public void SpecialCharNotAllowInitialPlaceForPassMark
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SpecialCharNotAllowInitialPlaceForPassMark");
        	String PassMarkI= 	fileone1.getCellData("JuniorCAF", "PassMark",2);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 172 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 172, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    @Test(priority=62)
    public void SpecialCharNotAllowLastPlaceForPassMark
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SpecialCharNotAllowLastPlaceForPassMark");
        	String PassMarkL= 	fileone1.getCellData("JuniorCAF", "PassMark",3);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 173 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 173, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    @Test(priority=62)
    public void SpecialCharNotAllowMiddlePlaceForPassMark
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("SpecialCharNotAllowMiddlePlaceForPassMark");
        	String PassMarkM= 	fileone1.getCellData("JuniorCAF", "PassMark",4);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 174 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 174, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
   	}
   

