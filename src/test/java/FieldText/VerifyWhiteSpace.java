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

public class VerifyWhiteSpace extends ExtentReportBase {

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
   	public void WhiteSpaceNotAllowInitialPlaceForRollNumber
(



) throws IOException, InterruptedException
   	{
    	test = extent.createTest("WhiteSpaceNotAllowInitialPlaceForRollNumber");
    	
    	data.openBrowser("chrome");
		Thread.sleep(500);
		
		data.openUrl("http://o.samsodisha.gov.in/");
		
		Thread.sleep(500);
		data.LoginPage();
		
		
		
		Thread.sleep(1500);
		
		data.Navigation();
    	String AadharNoI = 	fileone1.getCellData("JuniorCAF", "AadharNo",14);
    			
    	
      System.out.println(AadharNoI);
      Thread.sleep(300);
      
      data.enterText("id","txtBoardRoll","  21TC169");
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
	    		fileone.setCellData(sheetName, "Result", 47 , "Pass");	
	    	 }
	    	
	    	 else
	    	 {
	    		 fileone.setCellData(sheetName, "Result", 47, "Fail");
	    	 }	
	    	 
	    	 SoftAssert softAssert = new SoftAssert();
	    	 softAssert.assertEquals(actualPopup, actualPopup);
		   	}
    
    
    
    @Test(priority=1)
   	public void WhiteSpaceNotAllowLastPlaceForRollNumber
(



) throws IOException, InterruptedException
   	{
    	test = extent.createTest("WhiteSpaceNotAllowInitialPlaceForRollNumber");
    	String AadharNoI = 	fileone1.getCellData("JuniorCAF", "AadharNo",14);
    			
    	
      System.out.println(AadharNoI);
      Thread.sleep(300);
      
      data.enterText("id","txtBoardRoll","21TC169   ");
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
	    		fileone.setCellData(sheetName, "Result", 48 , "Pass");	
	    	 }
	    	
	    	 else
	    	 {
	    		 fileone.setCellData(sheetName, "Result", 48, "Fail");
	    	 }	
	    	 
	    	 SoftAssert softAssert = new SoftAssert();
	    	 softAssert.assertEquals(actualPopup, actualPopup);
		   	}
    
    
    
    
    @Test(priority=2)
   	public void WhiteSpaceNotAllowMiddlePlaceForRollNumber
(



) throws IOException, InterruptedException
   	{
    	test = extent.createTest("WhiteSpaceNotAllowInitialPlaceForRollNumber");
    	String AadharNoI = 	fileone1.getCellData("JuniorCAF", "AadharNo",14);
    			
    	
      System.out.println(AadharNoI);
      Thread.sleep(300);
      
      data.enterText("id","txtBoardRoll","21T    C169");
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
	    		fileone.setCellData(sheetName, "Result", 49 , "Pass");	
	    	 }
	    	
	    	 else
	    	 {
	    		 fileone.setCellData(sheetName, "Result", 49, "Fail");
	    	 }	
	    	 
	    	 SoftAssert softAssert = new SoftAssert();
	    	 softAssert.assertEquals(actualPopup, actualPopup);
		   	}
 
    @Test(priority=9)
   	public void WhiteSpaceNotAllowInitialPlaceForAadharNumber
() throws IOException, InterruptedException
   	{
    	test = extent.createTest("WhiteSpaceNotAllowInitialPlaceForAadharNumber");
    	
    	String AadharNoI = 	fileone1.getCellData("JuniorCAF", "AadharNo",14);
    			
    	
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
	    		fileone.setCellData(sheetName, "Result", 75 , "Pass");	
	    	 }
	    	
	    	 else
	    	 {
	    		 fileone.setCellData(sheetName, "Result", 75, "Fail");
	    	 }	
	    	 
	    	 SoftAssert softAssert = new SoftAssert();
	    	 softAssert.assertEquals(actualPopup, actualPopup);
		   	}
    @Test(priority=10)
    public void WhiteSpaceNotAllowLastPlaceForAadharNumber
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("WhiteSpaceNotAllowLastPlaceForAadharNumber");
        	String AadharNoL = 	fileone1.getCellData("JuniorCAF", "AadharNo",15);
        			
        	
          System.out.println(AadharNoL);
          Thread.sleep(300);
          

          
          data.enterText("id","txtadhar",AadharNoL);
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
    	    		fileone.setCellData(sheetName, "Result", 76 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 76, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    @Test(priority=11)
    public void WhiteSpaceNotAllowMiddlePlaceForAadharNumber
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("WhiteSpaceNotAllowMiddlePlaceForAadharNumber");
        	String AadharNoM = 	fileone1.getCellData("JuniorCAF", "AadharNo",16);
        			
        	
          System.out.println(AadharNoM);
          Thread.sleep(300);
          
          data.enterText("id","txtadhar",AadharNoM);
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
    	    		fileone.setCellData(sheetName, "Result", 77 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 77, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    @Test(priority=12)
    public void WhiteSpaceNotAllowInitialPlaceForMobileNo
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("WhiteSpaceNotAllowInitialPlaceForMobileNo");
        	String MobileNoI = 	fileone1.getCellData("JuniorCAF", "MobileNo",14);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 78 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 78, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    @Test(priority=13)
    public void WhiteSpaceNotAllowLastPlaceForMobileNo
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("WhiteSpaceNotAllowLastPlaceForMobileNo");
        	String MobileNoL = 	fileone1.getCellData("JuniorCAF", "MobileNo",15);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 79 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 79, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    
    @Test(priority=14)
    public void WhiteSpaceNotAllowMiddlePlaceForMobileNo
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("WhiteSpaceNotAllowMiddlePlaceForMobileNo");
        	String MobileNoM = 	fileone1.getCellData("JuniorCAF", "MobileNo",16);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 80 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 80, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    
    @Test(priority=15)
    public void WhiteSpaceNotAllowInitialPlaceForPinCode
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("WhiteSpaceNotAllowInitialPlaceForPinCode");
        	String PinCodeI = 	fileone1.getCellData("JuniorCAF", "PinCode",14);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 81 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 81, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    
    @Test(priority=16)
    public void WhiteSpaceNotAllowLastPlaceForPinCode
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("WhiteSpaceNotAllowLastPlaceForPinCode");
        	String PinCodeL = 	fileone1.getCellData("JuniorCAF", "PinCode",15);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 82 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 82, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
   
    
    @Test(priority=18)
    public void WhiteSpaceNotAllowInitialPlaceForAreaCode
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("WhiteSpaceNotAllowInitialPlaceForAreaCode");
        	String AreaCodeI = 	fileone1.getCellData("JuniorCAF", "AreaCode",14);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 83 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 83, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    
    @Test(priority=19)
    public void WhiteSpaceNotAllowLastPlaceForAreaCode
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("WhiteSpaceNotAllowLastPlaceForAreaCode");
        	String AreaCodeL = 	fileone1.getCellData("JuniorCAF", "AreaCode",15);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 84 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 84, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
   
    
    
    @Test(priority=21)
    public void WhiteSpaceNotAllowInitialPlaceForPhoneNo
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("WhiteSpaceNotAllowInitialPlaceForPhoneNo");
        	String PhoneNoI = 	fileone1.getCellData("JuniorCAF", "PhoneNo",14);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 85 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 85, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    
    @Test(priority=22)
    public void WhiteSpaceNotAllowLastPlaceForPhoneNo
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("WhiteSpaceNotAllowLastPlaceForPhoneNo");
        	String PhoneNoL= 	fileone1.getCellData("JuniorCAF", "PhoneNo",15);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 86 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 86, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
  
    
    @Test(priority=24)
    public void WhiteSpaceNotAllowInitialPlaceForMaximumMark
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("WhiteSpaceNotAllowInitialPlaceForMaximumMark");
        	String MaximumMarkI= 	fileone1.getCellData("JuniorCAF", "MaximumMark",14);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 87 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 87, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    @Test(priority=25)
    public void WhiteSpaceNotAllowLastPlaceForMaximumMark
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("WhiteSpaceNotAllowLastPlaceForMaximumMark");
        	String MaximumMarkL= 	fileone1.getCellData("JuniorCAF", "MaximumMark",15);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 88 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 88, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    
   
    
    @Test(priority=27)
    public void WhiteSpaceNotAllowInitialPlaceForSecuredMark
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("WhiteSpaceNotAllowInitialPlaceForSecuredMark");
        	String SecuredMarkI= 	fileone1.getCellData("JuniorCAF", "SecuredMark",14);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 89 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 89, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    @Test(priority=28)
    public void WhiteSpaceNotAllowLastPlaceForSecuredMark
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("WhiteSpaceNotAllowLastPlaceForSecuredMark");
        	String SecuredMarkL= 	fileone1.getCellData("JuniorCAF", "SecuredMark",15);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 90 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 90, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
   
    
    
    @Test(priority=30)
    public void WhiteSpaceNotAllowInitialPlaceForEnglish
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("WhiteSpaceNotAllowInitialPlaceForEnglish");
        	String EnglishI= 	fileone1.getCellData("JuniorCAF", "English",14);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 91 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 91, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    @Test(priority=31)
    public void WhiteSpaceNotAllowLastPlaceForEnglish
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("WhiteSpaceNotAllowLastPlaceForEnglish");
        	String EnglishL= 	fileone1.getCellData("JuniorCAF", "English",15);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 92 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 92, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    
   
    
    
    
    @Test(priority=33)
    public void WhiteSpaceNotAllowInitialPlaceForMath
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("WhiteSpaceNotAllowInitialPlaceForMath");
        	String MathI= 	fileone1.getCellData("JuniorCAF", "Math",14);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 93 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 93, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    @Test(priority=34)
    public void WhiteSpaceNotAllowLastPlaceForMath
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("WhiteSpaceNotAllowLastPlaceForMath");
        	String MathL= 	fileone1.getCellData("JuniorCAF", "Math",15);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 94 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 94, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    
    
   
    
    
    @Test(priority=36)
    public void WhiteSpaceNotAllowInitialPlaceForScience
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("WhiteSpaceNotAllowInitialPlaceForScience");
        	String ScienceI= 	fileone1.getCellData("JuniorCAF", "Science",14);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 95 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 95, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    @Test(priority=37)
    public void WhiteSpaceNotAllowLastPlaceForScience
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("WhiteSpaceNotAllowLastPlaceForScience");
        	String ScienceL= 	fileone1.getCellData("JuniorCAF", "Science",15);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 96 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 96, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
   
    
    
    @Test(priority=39)
    public void WhiteSpaceNotAllowInitialPlaceForSocialScience
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("WhiteSpaceNotAllowInitialPlaceForSocialScience");
        	String SocialScienceI= 	fileone1.getCellData("JuniorCAF", "SocialScience",14);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 97 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 97, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    @Test(priority=40)
    public void WhiteSpaceNotAllowLastPlaceForSocialScience
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("WhiteSpaceNotAllowLastPlaceForSocialScience");
        	String SocialScienceL= 	fileone1.getCellData("JuniorCAF", "SocialScience",15);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 98 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 98, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    
    
    
    
    @Test(priority=42)
    public void WhiteSpaceNotAllowInitialPlaceForAccountNumber
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("WhiteSpaceNotAllowInitialPlaceForAccountNumber");
        	String AccountNumberI= 	fileone1.getCellData("JuniorCAF", "AccountNumber",14);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 99 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 99, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    
    @Test(priority=43)
    public void WhiteSpaceNotAllowLastPlaceForAccountNumber
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("WhiteSpaceNotAllowLastPlaceForAccountNumber");
        	String AccountNumberL= 	fileone1.getCellData("JuniorCAF", "AccountNumber",15);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 100 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 100, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
   
    
    
    @Test(priority=45)
    public void WhiteSpaceNotAllowInitialPlaceForIFSCCode
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("WhiteSpaceNotAllowInitialPlaceForIFSCCode");
        	String IFSCI= 	fileone1.getCellData("JuniorCAF", "IFSC",14);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 101 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 101, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    
   
    
    @Test(priority=48)
    public void WhiteSpaceNotAllowInitialPlaceForMICRCode
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("WhiteSpaceNotAllowInitialPlaceForMICRCode");
        	String MICRI= 	fileone1.getCellData("JuniorCAF", "MICR",14);
        			
        	
          System.out.println(MICRI);
          Thread.sleep(300);
          
          
          data.SelectDropdown("id", "ddlAIncome", "0 - 1,00,000");
          
          data.enterText("id","txtmicr",MICRI);
    	   		
          data.enterText("id","txtmicr","txtBankname");
          

          
      	
    	   		
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
    	    		fileone.setCellData(sheetName, "Result", 102 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 102, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    
    
    
   
   
   	}
   

