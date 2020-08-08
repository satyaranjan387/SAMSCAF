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

public class VerifyLength extends ExtentReportBase{
	
	//private static final int j = 0;
	static Xls_AllMethods fileone = new Xls_AllMethods("C:/Users/satyaranjan.m/eclipse-workspace/JuniorForm/JuniorFieldValidationwrite.xlsx");	
	
	 
	 static Xls_AllMethods fileone1 = new Xls_AllMethods("C:/Users/satyaranjan.m/eclipse-workspace/JuniorForm/RoughSheet.xlsx");
	 
	 
	 
	 
	 
	XSSFWorkbook wb;
	XSSFSheet sht;
	String sheetName = "JuniorFieldMapping";
 int rowCount = fileone.getRowCount(sheetName);


	CommonFunction data = new CommonFunction();
	
	
	 @Test(priority=0)
	   	public void MaxLengthShouldNotAbove15ForRollNumber
	(



	) throws IOException, InterruptedException
	   	{
	    	test = extent.createTest("MaxLengthShouldNotAbove15ForRollNumber");
	    	
	    	data.openBrowser("chrome");
			Thread.sleep(500);
			
			data.openUrl("http://o.samsodisha.gov.in/");
			
			Thread.sleep(500);
			data.LoginPage();
			
			
			
			Thread.sleep(2220);
			
			data.Navigation();
	    	String ApplicantNameI = 	fileone1.getCellData("JuniorCAF", "RollNumber",18);
	    			
	    	
	      System.out.println(ApplicantNameI);
	      Thread.sleep(300);
	      
	      data.CheckMaxLength("id","txtBoardRoll",ApplicantNameI,"value","Data",15);
	      
	      
	      
	      Thread.sleep(300);
	      
	      data.clickOnLocator("id","btnSave");
	      
		   		Thread.sleep(1000);
	String actualPopup =data.grtpopup().getText();
				
				System.out.println(actualPopup);
		    	
				String expectedmessage = "Please select Year of Passing !";

		    	 if(actualPopup.equals(expectedmessage))
		    	 {
		    		 System.out.println("Sucessfully Message is" + actualPopup);
		    		 data.clickOnLocator("id","popup_ok");
		    		 Thread.sleep(1000);
						System.out.println("Click Ok");
		    		fileone.setCellData(sheetName, "Result", 291 , "Pass");	
		    	 }
		    	
		    	 else
		    	 {
		    		 fileone.setCellData(sheetName, "Result", 291, "Fail");
		    	 }	
		    	 
		    	 SoftAssert softAssert = new SoftAssert();
		    	 softAssert.assertEquals(actualPopup, actualPopup);
			   	}
  
    
   
    
    
    @Test(priority=1)
   	public void MaxLengthShouldNotAbove100ForApplicantName
(



) throws IOException, InterruptedException
   	{
    	test = extent.createTest("MaxLengthShouldNotAbove100ForApplicantName");
    	
    	
    	String ApplicantNameI = 	fileone1.getCellData("JuniorCAF", "ApplicantName",18);
    			
    	
      System.out.println(ApplicantNameI);
      Thread.sleep(300);
      
      data.CheckMaxLength("id","txtApplName",ApplicantNameI,"value","Data",100);
      
      
      
      Thread.sleep(300);
      
      data.clickOnLocator("id","btnSave");
      
	   		Thread.sleep(1000);
String actualPopup =data.grtpopup().getText();
			
			System.out.println(actualPopup);
	    	
			String expectedmessage = "Please enter only Alphabets";

	    	 if(!actualPopup.equals(expectedmessage))
	    	 {
	    		 System.out.println("Sucessfully Message is" + actualPopup);
	    		 data.clickOnLocator("id","popup_ok");
	    		 Thread.sleep(1000);
					System.out.println("Click Ok");
	    		fileone.setCellData(sheetName, "Result", 292 , "Pass");	
	    	 }
	    	
	    	 else
	    	 {
	    		 fileone.setCellData(sheetName, "Result", 292, "Fail");
	    	 }	
	    	 
	    	 SoftAssert softAssert = new SoftAssert();
	    	 softAssert.assertEquals(actualPopup, actualPopup);
		   	}
    
    
    
    
    @Test(priority=2)
   	public void MaxLengthShouldNotAbove100ForFatherName
(



) throws IOException, InterruptedException
   	{
    	test = extent.createTest("MaxLengthShouldNotAbove100ForFatherName");
    	String FatherNameI = 	fileone1.getCellData("JuniorCAF", "FatherName",18);
    			
    	
      System.out.println(FatherNameI);
      Thread.sleep(300);
      
      data.CheckMaxLength("id","txtFatherName",FatherNameI,"value","Data",100);
      
      
      
      Thread.sleep(300);
      
      data.clickOnLocator("id","btnSave");
      
	   		Thread.sleep(1000);
String actualPopup =data.grtpopup().getText();
			
			System.out.println(actualPopup);
	    	
			String expectedmessage = "Please enter only Alphabets";

	    	 if(!actualPopup.equals(expectedmessage))
	    	 {
	    		 System.out.println("Sucessfully Message is" + actualPopup);
	    		 data.clickOnLocator("id","popup_ok");
	    		 Thread.sleep(1000);
					System.out.println("Click Ok");
	    		fileone.setCellData(sheetName, "Result", 293 , "Pass");	
	    	 }
	    	
	    	 else
	    	 {
	    		 fileone.setCellData(sheetName, "Result", 293, "Fail");
	    	 }	
	    	 
	    	 SoftAssert softAssert = new SoftAssert();
	    	 softAssert.assertEquals(actualPopup, actualPopup);
		   	}
    
    @Test(priority=2)
   	public void MaxLengthShouldNotAbove100ForMotherName
(



) throws IOException, InterruptedException
   	{
    	test = extent.createTest("MaxLengthShouldNotAbove100ForMotherName");
    	String MotherNameI = 	fileone1.getCellData("JuniorCAF", "MotherName",18);
    			
    	
      System.out.println(MotherNameI);
      Thread.sleep(300);
      
      data.CheckMaxLength("id","txtMotherName",MotherNameI,"value","Data",100);
      
      
      
      Thread.sleep(300);
      
      data.clickOnLocator("id","btnSave");
      
	   		Thread.sleep(1000);
String actualPopup =data.grtpopup().getText();
			
			System.out.println(actualPopup);
	    	
			String expectedmessage = "Please enter only Alphabets";

	    	 if(!actualPopup.equals(expectedmessage))
	    	 {
	    		 System.out.println("Sucessfully Message is" + actualPopup);
	    		 data.clickOnLocator("id","popup_ok");
	    		 Thread.sleep(1000);
					System.out.println("Click Ok");
	    		fileone.setCellData(sheetName, "Result", 294 , "Pass");	
	    	 }
	    	
	    	 else
	    	 {
	    		 fileone.setCellData(sheetName, "Result", 294, "Fail");
	    	 }	
	    	 
	    	 SoftAssert softAssert = new SoftAssert();
	    	 softAssert.assertEquals(actualPopup, actualPopup);
		   	}
    
    
    @Test(priority=3)
   	public void MaxLengthShouldNotAbove12ForAadharNumber
(



) throws IOException, InterruptedException
   	{
    	test = extent.createTest("MaxLengthShouldNotAbove12ForAadharNumber");
    	String AadharNoI = 	fileone1.getCellData("JuniorCAF", "AadharNo",18);
    			
    	
      System.out.println(AadharNoI);
      Thread.sleep(300);
      
      data.CheckMaxLength("id","txtadhar",AadharNoI,"value","Data",12);
      
      
      
      Thread.sleep(300);
      
      data.clickOnLocator("id","btnSave");
      
	   		Thread.sleep(1000);
String actualPopup =data.grtpopup().getText();
			
			System.out.println(actualPopup);
	    	
			String expectedmessage = "Please enter only Alphabets";

	    	 if(!actualPopup.equals(expectedmessage))
	    	 {
	    		 System.out.println("Sucessfully Message is" + actualPopup);
	    		 data.clickOnLocator("id","popup_ok");
	    		 Thread.sleep(1000);
					System.out.println("Click Ok");
	    		fileone.setCellData(sheetName, "Result", 295 , "Pass");	
	    	 }
	    	
	    	 else
	    	 {
	    		 fileone.setCellData(sheetName, "Result", 295, "Fail");
	    	 }	
	    	 
	    	 SoftAssert softAssert = new SoftAssert();
	    	 softAssert.assertEquals(actualPopup, actualPopup);
		   	}
    @Test(priority=4)
   	public void MaxLengthShouldNotAbove10ForMobileNumber
(



) throws IOException, InterruptedException
   	{
    	test = extent.createTest("MaxLengthShouldNotAbove10ForMobileNumber");
    	String MobileNoI = 	fileone1.getCellData("JuniorCAF", "MobileNo",18);
    			
    	
      System.out.println(MobileNoI);
      Thread.sleep(300);
      
      data.CheckMaxLength("id","txtParentMob",MobileNoI,"value","Data",10);
      
      
      
      Thread.sleep(300);
      
      data.clickOnLocator("id","btnSave");
      
	   		Thread.sleep(1000);
String actualPopup =data.grtpopup().getText();
			
			System.out.println(actualPopup);
	    	
			String expectedmessage = "Please enter only Alphabets";

	    	 if(!actualPopup.equals(expectedmessage))
	    	 {
	    		 System.out.println("Sucessfully Message is" + actualPopup);
	    		 data.clickOnLocator("id","popup_ok");
	    		 Thread.sleep(1000);
					System.out.println("Click Ok");
	    		fileone.setCellData(sheetName, "Result", 296 , "Pass");	
	    	 }
	    	
	    	 else
	    	 {
	    		 fileone.setCellData(sheetName, "Result", 296, "Fail");
	    	 }	
	    	 
	    	 SoftAssert softAssert = new SoftAssert();
	    	 softAssert.assertEquals(actualPopup, actualPopup);
		   	}
    
    
    @Test(priority=4)
   	public void MaxLengthShouldNotAbove6ForMPinCode
(



) throws IOException, InterruptedException
   	{
    	test = extent.createTest("MaxLengthShouldNotAbove6ForMPinCode");
    	String PinCode = 	fileone1.getCellData("JuniorCAF", "PinCode",18);
    			
    	
      System.out.println(PinCode);
      Thread.sleep(300);
      
      data.CheckMaxLength("id","txtCPC",PinCode,"value","Data",6);
      
      
      
      Thread.sleep(300);
      
      data.clickOnLocator("id","btnSave");
      
	   		Thread.sleep(1000);
String actualPopup =data.grtpopup().getText();
			
			System.out.println(actualPopup);
	    	
			String expectedmessage = "Please enter only Alphabets";

	    	 if(!actualPopup.equals(expectedmessage))
	    	 {
	    		 System.out.println("Sucessfully Message is" + actualPopup);
	    		 data.clickOnLocator("id","popup_ok");
	    		 Thread.sleep(1000);
					System.out.println("Click Ok");
	    		fileone.setCellData(sheetName, "Result", 298 , "Pass");	
	    	 }
	    	
	    	 else
	    	 {
	    		 fileone.setCellData(sheetName, "Result", 298, "Fail");
	    	 }	
	    	 
	    	 SoftAssert softAssert = new SoftAssert();
	    	 softAssert.assertEquals(actualPopup, actualPopup);
		   	}
    
    
    
    @Test(priority=4)
   	public void MaxLengthShouldNotAbove5ForAreaCode
(



) throws IOException, InterruptedException
   	{
    	test = extent.createTest("MaxLengthShouldNotAbove6ForAreaCode");
    	String AreaCode = 	fileone1.getCellData("JuniorCAF", "AreaCode",18);
    			
    	
      System.out.println(AreaCode);
      Thread.sleep(300);
      
      data.CheckMaxLength("id","txtCTCode",AreaCode,"value","Data",5);
      
      
      
      Thread.sleep(300);
      
      data.clickOnLocator("id","btnSave");
      
	   		Thread.sleep(1000);
String actualPopup =data.grtpopup().getText();
			
			System.out.println(actualPopup);
	    	
			String expectedmessage = "Please enter only Alphabets";

	    	 if(!actualPopup.equals(expectedmessage))
	    	 {
	    		 System.out.println("Sucessfully Message is" + actualPopup);
	    		 data.clickOnLocator("id","popup_ok");
	    		 Thread.sleep(1000);
					System.out.println("Click Ok");
	    		fileone.setCellData(sheetName, "Result", 299 , "Pass");	
	    	 }
	    	
	    	 else
	    	 {
	    		 fileone.setCellData(sheetName, "Result", 299, "Fail");
	    	 }	
	    	 
	    	 SoftAssert softAssert = new SoftAssert();
	    	 softAssert.assertEquals(actualPopup, actualPopup);
		   	}
    
    
    
    
    
    @Test(priority=4)
   	public void MaxLengthShouldNotAbove7ForTelephoneNumber
(



) throws IOException, InterruptedException
   	{
    	test = extent.createTest("MaxLengthShouldNotAbove6ForTelephoneNumber");
    	String PhoneNo= 	fileone1.getCellData("JuniorCAF", "PhoneNo",18);
    			
    	
      System.out.println(PhoneNo);
      Thread.sleep(300);
      
      data.CheckMaxLength("id","txtCTeleNo",PhoneNo,"value","Data",7);
      
      
      
      Thread.sleep(300);
      
      data.clickOnLocator("id","btnSave");
      
	   		Thread.sleep(1000);
String actualPopup =data.grtpopup().getText();
			
			System.out.println(actualPopup);
	    	
			String expectedmessage = "Please enter only Alphabets";

	    	 if(!actualPopup.equals(expectedmessage))
	    	 {
	    		 System.out.println("Sucessfully Message is" + actualPopup);
	    		 data.clickOnLocator("id","popup_ok");
	    		 Thread.sleep(1000);
					System.out.println("Click Ok");
	    		fileone.setCellData(sheetName, "Result", 300, "Pass");	
	    	 }
	    	
	    	 else
	    	 {
	    		 fileone.setCellData(sheetName, "Result", 300, "Fail");
	    	 }	
	    	 
	    	 SoftAssert softAssert = new SoftAssert();
	    	 softAssert.assertEquals(actualPopup, actualPopup);
		   	}




@Test(priority=5)
   	public void MaxLengthShouldNotAbove4ForMaximumMark
(



) throws IOException, InterruptedException
   	{
    	test = extent.createTest("MaxLengthShouldNotAbove4ForMaximumMark");
    	String MaximumMark=	fileone1.getCellData("JuniorCAF", "MaximumMark",18);
    			
    	
      System.out.println(MaximumMark);
      Thread.sleep(300);
      
      data.CheckMaxLength("id","txtMaxMark",MaximumMark,"value","Data",4);
      
      
      
      Thread.sleep(300);
      
      data.clickOnLocator("id","btnSave");
      
	   		Thread.sleep(1000);
String actualPopup =data.grtpopup().getText();
			
			System.out.println(actualPopup);
	    	
			String expectedmessage = "Please enter only Alphabets";

	    	 if(!actualPopup.equals(expectedmessage))
	    	 {
	    		 System.out.println("Sucessfully Message is" + actualPopup);
	    		 data.clickOnLocator("id","popup_ok");
	    		 Thread.sleep(1000);
					System.out.println("Click Ok");
	    		fileone.setCellData(sheetName, "Result", 301, "Pass");	
	    	 }
	    	
	    	 else
	    	 {
	    		 fileone.setCellData(sheetName, "Result", 301, "Fail");
	    	 }	
	    	 
	    	 SoftAssert softAssert = new SoftAssert();
	    	 softAssert.assertEquals(actualPopup, actualPopup);
		   	}




@Test(priority=6)
   	public void MaxLengthShouldNotAbove4ForSecuredMark
(



) throws IOException, InterruptedException
   	{
    	test = extent.createTest("MaxLengthShouldNotAbove4ForSecuredMark");
    	String SecuredMark=	fileone1.getCellData("JuniorCAF", "SecuredMark",18);
    			
    	
      System.out.println(SecuredMark);
      Thread.sleep(300);
      
      data.CheckMaxLength("id","txtTotMark",SecuredMark,"value","Data",4);
      
      
      
      Thread.sleep(300);
      
      data.clickOnLocator("id","btnSave");
      
	   		Thread.sleep(1000);
String actualPopup =data.grtpopup().getText();
			
			System.out.println(actualPopup);
	    	
			String expectedmessage = "Please enter only Alphabets";

	    	 if(!actualPopup.equals(expectedmessage))
	    	 {
	    		 System.out.println("Sucessfully Message is" + actualPopup);
	    		 data.clickOnLocator("id","popup_ok");
	    		 Thread.sleep(1000);
					System.out.println("Click Ok");
	    		fileone.setCellData(sheetName, "Result", 302, "Pass");	
	    	 }
	    	
	    	 else
	    	 {
	    		 fileone.setCellData(sheetName, "Result", 302, "Fail");
	    	 }	
	    	 
	    	 SoftAssert softAssert = new SoftAssert();
	    	 softAssert.assertEquals(actualPopup, actualPopup);
		   	}




@Test(priority=7)
   	public void MaxLengthShouldNotAbove4ForEnglish
(



) throws IOException, InterruptedException
   	{
    	test = extent.createTest("MaxLengthShouldNotAbove4ForEnglish");
    	String English=	fileone1.getCellData("JuniorCAF", "English",18);
    			
    	
      System.out.println(English);
      Thread.sleep(300);
      
      data.CheckMaxLength("id","txtEnglish",English,"value","Data",4);
      
      
      
      Thread.sleep(300);
      
      data.clickOnLocator("id","btnSave");
      
	   		Thread.sleep(1000);
String actualPopup =data.grtpopup().getText();
			
			System.out.println(actualPopup);
	    	
			String expectedmessage = "Please enter only Alphabets";

	    	 if(!actualPopup.equals(expectedmessage))
	    	 {
	    		 System.out.println("Sucessfully Message is" + actualPopup);
	    		 data.clickOnLocator("id","popup_ok");
	    		 Thread.sleep(1000);
					System.out.println("Click Ok");
	    		fileone.setCellData(sheetName, "Result", 303, "Pass");	
	    	 }
	    	
	    	 else
	    	 {
	    		 fileone.setCellData(sheetName, "Result", 303, "Fail");
	    	 }	
	    	 
	    	 SoftAssert softAssert = new SoftAssert();
	    	 softAssert.assertEquals(actualPopup, actualPopup);
		   	}







@Test(priority=8)
   	public void MaxLengthShouldNotAbove4ForMath
(



) throws IOException, InterruptedException
   	{
    	test = extent.createTest("MaxLengthShouldNotAbove4ForMath");
    	String Math=	fileone1.getCellData("JuniorCAF", "Math",18);
    			
    	
      System.out.println(Math);
      Thread.sleep(300);
      
      data.CheckMaxLength("id","txtMath",Math,"value","Data",4);
      
      
      
      Thread.sleep(300);
      
      data.clickOnLocator("id","btnSave");
      
	   		Thread.sleep(1000);
String actualPopup =data.grtpopup().getText();
			
			System.out.println(actualPopup);
	    	
			String expectedmessage = "Please enter only Alphabets";

	    	 if(!actualPopup.equals(expectedmessage))
	    	 {
	    		 System.out.println("Sucessfully Message is" + actualPopup);
	    		 data.clickOnLocator("id","popup_ok");
	    		 Thread.sleep(1000);
					System.out.println("Click Ok");
	    		fileone.setCellData(sheetName, "Result", 304, "Pass");	
	    	 }
	    	
	    	 else
	    	 {
	    		 fileone.setCellData(sheetName, "Result", 304, "Fail");
	    	 }	
	    	 
	    	 SoftAssert softAssert = new SoftAssert();
	    	 softAssert.assertEquals(actualPopup, actualPopup);
		   	}




@Test(priority=8)
   	public void MaxLengthShouldNotAbove4ForScience
(



) throws IOException, InterruptedException
   	{
    	test = extent.createTest("MaxLengthShouldNotAbove4ForScience");
    	String Science=	fileone1.getCellData("JuniorCAF", "Science",18);
    			
    	
      System.out.println(Science);
      Thread.sleep(300);
      
      data.CheckMaxLength("id","txtScience",Science,"value","Data",4);
      
      
      
      Thread.sleep(300);
      
      data.clickOnLocator("id","btnSave");
      
	   		Thread.sleep(1000);
String actualPopup =data.grtpopup().getText();
			
			System.out.println(actualPopup);
	    	
			String expectedmessage = "Please enter only Alphabets";

	    	 if(!actualPopup.equals(expectedmessage))
	    	 {
	    		 System.out.println("Sucessfully Message is" + actualPopup);
	    		 data.clickOnLocator("id","popup_ok");
	    		 Thread.sleep(1000);
					System.out.println("Click Ok");
	    		fileone.setCellData(sheetName, "Result", 305, "Pass");	
	    	 }
	    	
	    	 else
	    	 {
	    		 fileone.setCellData(sheetName, "Result", 305, "Fail");
	    	 }	
	    	 
	    	 SoftAssert softAssert = new SoftAssert();
	    	 softAssert.assertEquals(actualPopup, actualPopup);
		   	}







@Test(priority=9)
   	public void MaxLengthShouldNotAbove4ForSocialScience
(



) throws IOException, InterruptedException
   	{
    	test = extent.createTest("MaxLengthShouldNotAbove4ForSocialScience");
    	String SocialScience=	fileone1.getCellData("JuniorCAF", "SocialScience",18);
    			
    	
      System.out.println(SocialScience);
      Thread.sleep(300);
      
      data.CheckMaxLength("id","txtSocSci",SocialScience,"value","Data",4);
      
      
      
      Thread.sleep(300);
      
      data.clickOnLocator("id","btnSave");
      
	   		Thread.sleep(1000);
String actualPopup =data.grtpopup().getText();
			
			System.out.println(actualPopup);
	    	
			String expectedmessage = "Please enter only Alphabets";

	    	 if(!actualPopup.equals(expectedmessage))
	    	 {
	    		 System.out.println("Sucessfully Message is" + actualPopup);
	    		 data.clickOnLocator("id","popup_ok");
	    		 Thread.sleep(1000);
					System.out.println("Click Ok");
	    		fileone.setCellData(sheetName, "Result", 306, "Pass");	
	    	 }
	    	
	    	 else
	    	 {
	    		 fileone.setCellData(sheetName, "Result", 306, "Fail");
	    	 }	
	    	 
	    	 SoftAssert softAssert = new SoftAssert();
	    	 softAssert.assertEquals(actualPopup, actualPopup);
		   	}







@Test(priority=10)
   	public void MaxLengthShouldNotAbove4ForFailMark
(



) throws IOException, InterruptedException
   	{
    	test = extent.createTest("MaxLengthShouldNotAbove4ForFailMark");
    	String FailMark=	fileone1.getCellData("JuniorCAF", "FailMark",18);
    			
    	
      System.out.println(FailMark);
      Thread.sleep(300);


 Thread.sleep(300);
      
      data.clickOnLocator("id","rbtCompartmentalY");
      
     
      data.CheckMaxLength("id","txtCompFMark1",FailMark,"value","Data",4);
      
       data.clickOnLocator("id","btnSave");
      Thread.sleep(300);
      
     
      
	   		Thread.sleep(1000);
String actualPopup =data.grtpopup().getText();
			
			System.out.println(actualPopup);
	    	
			String expectedmessage = "Please enter only Alphabets";

	    	 if(!actualPopup.equals(expectedmessage))
	    	 {
	    		 System.out.println("Sucessfully Message is" + actualPopup);
	    		 data.clickOnLocator("id","popup_ok");
	    		 Thread.sleep(1000);
					System.out.println("Click Ok");
	    		fileone.setCellData(sheetName, "Result", 307, "Pass");	
	    	 }
	    	
	    	 else
	    	 {
	    		 fileone.setCellData(sheetName, "Result", 307, "Fail");
	    	 }	
	    	 
	    	 SoftAssert softAssert = new SoftAssert();
	    	 softAssert.assertEquals(actualPopup, actualPopup);
		   	}





@Test(priority=11)
   	public void MaxLengthShouldNotAbove4ForPassMark
(



) throws IOException, InterruptedException
   	{
    	test = extent.createTest("MaxLengthShouldNotAbove4ForPassMark");
    	String PassMark=	fileone1.getCellData("JuniorCAF", "PassMark",18);
    			
    	
      System.out.println(PassMark);
       Thread.sleep(300);
      
      data.clickOnLocator("id","rbtCompartmentalY");



      
     
      Thread.sleep(300);
      data.CheckMaxLength("id","txtCompPMark1",PassMark,"value","Data",4);
      
       data.clickOnLocator("id","btnSave");
      
     
      
	   		Thread.sleep(1000);
String actualPopup =data.grtpopup().getText();
			
			System.out.println(actualPopup);
	    	
			String expectedmessage = "Please enter only Alphabets";

	    	 if(!actualPopup.equals(expectedmessage))
	    	 {
	    		 System.out.println("Sucessfully Message is" + actualPopup);
	    		 data.clickOnLocator("id","popup_ok");
	    		 Thread.sleep(1000);
					System.out.println("Click Ok");
	    		fileone.setCellData(sheetName, "Result", 308, "Pass");	
	    	 }
	    	
	    	 else
	    	 {
	    		 fileone.setCellData(sheetName, "Result", 308, "Fail");
	    	 }	
	    	 
	    	 SoftAssert softAssert = new SoftAssert();
	    	 softAssert.assertEquals(actualPopup, actualPopup);
		   	}








@Test(priority=11)
   	public void MaxLengthShouldNotAbove20ForAccountNumber
(



) throws IOException, InterruptedException
   	{
    	test = extent.createTest("MaxLengthShouldNotAbove20ForAccountNumber");
    	String AccountNumber=	fileone1.getCellData("JuniorCAF", "AccountNumber",18);
    			
    	
      System.out.println(AccountNumber);
      Thread.sleep(300);



      
      data.SelectDropdown("id","ddlAIncome","0 - 1,00,000");
      Thread.sleep(300);
      data.CheckMaxLength("id","txtacno",AccountNumber,"value","Data",20);
      
      
      
      Thread.sleep(300);
      
      data.clickOnLocator("id","btnSave");
      
	   		Thread.sleep(1000);
String actualPopup =data.grtpopup().getText();
			
			System.out.println(actualPopup);
	    	
			String expectedmessage = "Please enter only Alphabets";

	    	 if(!actualPopup.equals(expectedmessage))
	    	 {
	    		 System.out.println("Sucessfully Message is" + actualPopup);
	    		 data.clickOnLocator("id","popup_ok");
	    		 Thread.sleep(1000);
					System.out.println("Click Ok");
	    		fileone.setCellData(sheetName, "Result", 309, "Pass");	
	    	 }
	    	
	    	 else
	    	 {
	    		 fileone.setCellData(sheetName, "Result", 309, "Fail");
	    	 }	
	    	 
	    	 SoftAssert softAssert = new SoftAssert();
	    	 softAssert.assertEquals(actualPopup, actualPopup);
		   	}




















@Test(priority=12)
   	public void MaxLengthShouldNotAbove11ForIFSC
(



) throws IOException, InterruptedException
   	{
    	test = extent.createTest("MaxLengthShouldNotAbove11ForIFSC");
    	String IFSC=	fileone1.getCellData("JuniorCAF", "IFSC",18);
    			
    	
      System.out.println(IFSC);
      Thread.sleep(300);



      
      data.SelectDropdown("id","ddlAIncome","0 - 1,00,000");
      Thread.sleep(300);
      data.CheckMaxLength("id","txtifsc",IFSC,"value","Data",11);
      
      
      
      Thread.sleep(300);
      
      data.clickOnLocator("id","btnSave");
      
	   		Thread.sleep(1000);
String actualPopup =data.grtpopup().getText();
			
			System.out.println(actualPopup);
	    	
			String expectedmessage = "Please enter only Alphabets";

	    	 if(!actualPopup.equals(expectedmessage))
	    	 {
	    		 System.out.println("Sucessfully Message is" + actualPopup);
	    		 data.clickOnLocator("id","popup_ok");
	    		 Thread.sleep(1000);
					System.out.println("Click Ok");
	    		fileone.setCellData(sheetName, "Result", 310, "Pass");	
	    	 }
	    	
	    	 else
	    	 {
	    		 fileone.setCellData(sheetName, "Result", 310, "Fail");
	    	 }	
	    	 
	    	 SoftAssert softAssert = new SoftAssert();
	    	 softAssert.assertEquals(actualPopup, actualPopup);
		   	}



@Test(priority=13)
   	public void MaxLengthShouldNotAbove9ForMICRCode
(



) throws IOException, InterruptedException
   	{
    	test = extent.createTest("MaxLengthShouldNotAbove9ForMICRCode");
    	String MICR=	fileone1.getCellData("JuniorCAF", "MICR",18);
    			
    	
      System.out.println(MICR);
      Thread.sleep(300);



      
      data.SelectDropdown("id","ddlAIncome","0 - 1,00,000");
      Thread.sleep(300);
      data.CheckMaxLength("id","txtmicr",MICR,"value","Data",9);
      
      
      
      Thread.sleep(300);
      
      data.clickOnLocator("id","btnSave");
      
	   		Thread.sleep(1000);
String actualPopup =data.grtpopup().getText();
			
			System.out.println(actualPopup);
	    	
			String expectedmessage = "Please enter only Alphabets";

	    	 if(!actualPopup.equals(expectedmessage))
	    	 {
	    		 System.out.println("Sucessfully Message is" + actualPopup);
	    		 data.clickOnLocator("id","popup_ok");
	    		 Thread.sleep(1000);
					System.out.println("Click Ok");
	    		fileone.setCellData(sheetName, "Result", 311, "Pass");	
	    	 }
	    	
	    	 else
	    	 {
	    		 fileone.setCellData(sheetName, "Result", 311, "Fail");
	    	 }	
	    	 
	    	 SoftAssert softAssert = new SoftAssert();
	    	 softAssert.assertEquals(actualPopup, actualPopup);
		   	}




@Test(priority=14)
   	public void MaxLengthShouldNotAbove100ForBankName
(



) throws IOException, InterruptedException
   	{
    	test = extent.createTest("MaxLengthShouldNotAbove100ForBankName");
    	String BankName=	fileone1.getCellData("JuniorCAF", "BankName",18);
    			
    	
      System.out.println(BankName);
      Thread.sleep(300);



      
      data.SelectDropdown("id","ddlAIncome","0 - 1,00,000");
      Thread.sleep(300);
      data.CheckMaxLength("id","txtBankname",BankName,"value","Data",100);
      
      
      
      Thread.sleep(300);
      
      data.clickOnLocator("id","btnSave");
      
	   		Thread.sleep(1000);
String actualPopup =data.grtpopup().getText();
			
			System.out.println(actualPopup);
	    	
			String expectedmessage = "Please enter only Alphabets";

	    	 if(!actualPopup.equals(expectedmessage))
	    	 {
	    		 System.out.println("Sucessfully Message is" + actualPopup);
	    		 data.clickOnLocator("id","popup_ok");
	    		 Thread.sleep(1000);
					System.out.println("Click Ok");
	    		fileone.setCellData(sheetName, "Result", 312, "Pass");	
	    	 }
	    	
	    	 else
	    	 {
	    		 fileone.setCellData(sheetName, "Result", 312, "Fail");
	    	 }	
	    	 
	    	 SoftAssert softAssert = new SoftAssert();
	    	 softAssert.assertEquals(actualPopup, actualPopup);
		   	}





@Test(priority=15)
   	public void MaxLengthShouldNotAbove150ForBranchName
(



) throws IOException, InterruptedException
   	{
    	test = extent.createTest("MaxLengthShouldNotAbove150ForBranchName");
    	String BranchName=	fileone1.getCellData("JuniorCAF", "BranchName",18);
    			
    	
      System.out.println(BranchName);
      Thread.sleep(300);



      
      data.SelectDropdown("id","ddlAIncome","0 - 1,00,000");
      Thread.sleep(300);
      data.CheckMaxLength("id","txtBrname",BranchName,"value","Data",150);
      
      
      
      Thread.sleep(300);
      
      data.clickOnLocator("id","btnSave");
      
	   		Thread.sleep(1000);
String actualPopup =data.grtpopup().getText();
			
			System.out.println(actualPopup);
	    	
			String expectedmessage = "Please enter only Alphabets";

	    	 if(!actualPopup.equals(expectedmessage))
	    	 {
	    		 System.out.println("Sucessfully Message is" + actualPopup);
	    		 data.clickOnLocator("id","popup_ok");
	    		 Thread.sleep(1000);
					System.out.println("Click Ok");
	    		fileone.setCellData(sheetName, "Result", 313, "Pass");	
	    	 }
	    	
	    	 else
	    	 {
	    		 fileone.setCellData(sheetName, "Result", 313, "Fail");
	    	 }	
	    	 
	    	 SoftAssert softAssert = new SoftAssert();
	    	 softAssert.assertEquals(actualPopup, actualPopup);
		   	}








@Test(priority=15)
   	public void MaxLengthShouldNotAbove300ForSchoolName
(



) throws IOException, InterruptedException
   	{
    	test = extent.createTest("MaxLengthShouldNotAbove300ForSchoolName");
    	String SchoolName=	fileone1.getCellData("JuniorCAF", "SchoolName",18);
    			
    	
      System.out.println(SchoolName);
      Thread.sleep(300);



      
     
      data.CheckMaxLength("id","txtschname",SchoolName,"value","Data",300);
      
      
      
      Thread.sleep(300);
      
      data.clickOnLocator("id","btnSave");
      
	   		Thread.sleep(1000);
String actualPopup =data.grtpopup().getText();
			
			System.out.println(actualPopup);
	    	
			String expectedmessage = "Please enter only Alphabets";

	    	 if(!actualPopup.equals(expectedmessage))
	    	 {
	    		 System.out.println("Sucessfully Message is" + actualPopup);
	    		 data.clickOnLocator("id","popup_ok");
	    		 Thread.sleep(1000);
					System.out.println("Click Ok");
	    		fileone.setCellData(sheetName, "Result", 314, "Pass");	
	    	 }
	    	
	    	 else
	    	 {
	    		 fileone.setCellData(sheetName, "Result", 314, "Fail");
	    	 }	
	    	 
	    	 SoftAssert softAssert = new SoftAssert();
	    	 softAssert.assertEquals(actualPopup, actualPopup);
		   	}




@Test(priority=15)
   	public void MaxLengthShouldNotAbove300ForSchoolLocation
(



) throws IOException, InterruptedException
   	{
    	test = extent.createTest("MaxLengthShouldNotAbove300ForSchoolLocation");
    	String SchoolLocation=	fileone1.getCellData("JuniorCAF", "SchoolLocation",18);
    			
    	
      System.out.println(SchoolLocation);
      Thread.sleep(300);



      
     
      data.CheckMaxLength("id","txtschloc",SchoolLocation,"value","Data",300);
      
      
      
      Thread.sleep(300);
      
      data.clickOnLocator("id","btnSave");
      
	   		Thread.sleep(1000);
String actualPopup =data.grtpopup().getText();
			
			System.out.println(actualPopup);
	    	
			String expectedmessage = "Please enter only Alphabets";

	    	 if(!actualPopup.equals(expectedmessage))
	    	 {
	    		 System.out.println("Sucessfully Message is" + actualPopup);
	    		 data.clickOnLocator("id","popup_ok");
	    		 Thread.sleep(1000);
					System.out.println("Click Ok");
	    		fileone.setCellData(sheetName, "Result", 315, "Pass");	
	    	 }
	    	
	    	 else
	    	 {
	    		 fileone.setCellData(sheetName, "Result", 315, "Fail");
	    	 }	
	    	 
	    	 SoftAssert softAssert = new SoftAssert();
	    	 softAssert.assertEquals(actualPopup, actualPopup);
		   	}







@Test(priority=16)
	public void MaxLengthShouldNotLess12ForAadharNumber
(



) throws IOException, InterruptedException
	{
	test = extent.createTest("MaxLengthShouldNotLess12ForAadharNumber");
	String AadharNo=	fileone1.getCellData("JuniorCAF", "AadharNo",19);
			
	
  System.out.println(AadharNo);
  Thread.sleep(300);



  
 
  data.SelectDropdown("id","ddlYOP","2019");
	   		
	   		Thread.sleep(300);
	   		data.clickOnLocator("id","rbtnAnnual");
	   		Thread.sleep(300);
	   		data.enterText("id","txtBoardRoll","21tc187");
	   		Thread.sleep(300);
	   		data.enterText("id","txtApplName","Milan");
	   		Thread.sleep(300);
	   		data.enterText("id","txtFatherName","Rajendra");
	   		Thread.sleep(300);
	   		data.enterText("id","txtMotherName","Sarojini");
	   		Thread.sleep(300);
	   		data.SelectDropdown("id","ddlBloodGroup","A+");
	   		Thread.sleep(300);
	   		data.SelectDropdown("id","ddlGender","MALE");
	   		Thread.sleep(300);
	   		data.SelectDropdown("id","ddlReligion","HINDU");
	   		Thread.sleep(300);
	   		data.SelectDropdown("id","ddlDay","11");
	   		Thread.sleep(300);
	   		data.SelectDropdown("id","ddlMonth","SEPTEMBER");
	   		Thread.sleep(300);
	   		data.SelectDropdown("id","ddlYear","1993");
	   		
  Thread.sleep(300);
	   		data.enterText("id","txtadhar",AadharNo);
  
  
  
  
   		Thread.sleep(1000);
String actualPopup =driver.switchTo().alert().getText();
		
		System.out.println(actualPopup);
    	
		String expectedmessage = "Please enter only Alphabets";

    	 if(!actualPopup.equals(expectedmessage))
    	 {
    		 System.out.println("Sucessfully Message is" + actualPopup);
    		 driver.switchTo().alert().accept();
    		 Thread.sleep(1000);
				System.out.println("Click Ok");
    		fileone.setCellData(sheetName, "Result", 316, "Pass");	
    	 }
    	
    	 else
    	 {
    		 fileone.setCellData(sheetName, "Result", 316, "Fail");
    	 }	
    	 
    	 SoftAssert softAssert = new SoftAssert();
    	 softAssert.assertEquals(actualPopup, actualPopup);
	   	}











@Test(priority=17)
	public void MaxLengthShouldNotLess10ForMobileNo
(



) throws IOException, InterruptedException
	{
	test = extent.createTest("MaxLengthShouldNotLess10ForMobileNo");
	String MobileNo=	fileone1.getCellData("JuniorCAF", "MobileNo",19);
			
	
  System.out.println(MobileNo);
  Thread.sleep(300);



  
 
  data.SelectDropdown("id","ddlYOP","2009");
	   		
	   		Thread.sleep(300);
	   		data.clickOnLocator("id","rbtnAnnual");
	   		Thread.sleep(300);
	   		data.enterText("id","txtBoardRoll","21tc187");
	   		
	   		Thread.sleep(2300);
	   		data.enterText("id","txtApplName","Milan");
	   		Thread.sleep(300);
	   		data.enterText("id","txtFatherName","Rajendra");
	   		Thread.sleep(300);
	   		data.enterText("id","txtMotherName","Sarojini");
	   		Thread.sleep(300);
	   		data.SelectDropdown("id","ddlBloodGroup","A+");
	   		Thread.sleep(300);
	   		data.SelectDropdown("id","ddlGender","MALE");
	   		Thread.sleep(300);
	   		data.SelectDropdown("id","ddlReligion","HINDU");
	   		Thread.sleep(300);
	   		data.SelectDropdown("id","ddlDay","11");
	   		Thread.sleep(300);
	   		data.SelectDropdown("id","ddlMonth","SEPTEMBER");
	   		Thread.sleep(300);
	   		data.SelectDropdown("id","ddlYear","1993");
	   		
  Thread.sleep(300);
	   		data.enterText("id","txtadhar","761490617322");



Thread.sleep(300);
	   		data.enterText("id","txtParentMob","8");
  
	   		
  Thread.sleep(300);
  
  data.clickOnLocator("id","btnSave");
  
   		Thread.sleep(1000);
String actualPopup =data.grtpopup().getText();
		
		System.out.println(actualPopup);
    	
		String expectedmessage = "Please enter only Alphabets";

    	 if(!actualPopup.equals(expectedmessage))
    	 {
    		 System.out.println("Sucessfully Message is" + actualPopup);
    		 data.clickOnLocator("id","popup_ok");
    		 Thread.sleep(1000);
				System.out.println("Click Ok");
    		fileone.setCellData(sheetName, "Result", 317, "Pass");	
    	 }
    	
    	 else
    	 {
    		 fileone.setCellData(sheetName, "Result", 317, "Fail");
    	 }	
    	 
    	 SoftAssert softAssert = new SoftAssert();
    	 softAssert.assertEquals(actualPopup, actualPopup);
	   	}












@Test(priority=18)
	public void MaxLengthShouldNotLess6ForPinCode
(



) throws IOException, InterruptedException
	{
	test = extent.createTest("MaxLengthShouldNotLess10ForPinCode");
	String PinCode=	fileone1.getCellData("JuniorCAF", "PinCode",19);
			
	
  System.out.println(PinCode);
  Thread.sleep(300);



  
 
  data.SelectDropdown("id","ddlYOP","2009");
	   		
	   		Thread.sleep(300);
	   		data.clickOnLocator("id","rbtnAnnual");
	   		Thread.sleep(300);
	   		data.enterText("id","txtBoardRoll","21tc187");
	   		
	   		Thread.sleep(2300);
	   		data.enterText("id","txtApplName","Milan");
	   		Thread.sleep(300);
	   		data.enterText("id","txtFatherName","Rajendra");
	   		Thread.sleep(300);
	   		data.enterText("id","txtMotherName","Sarojini");
	   		Thread.sleep(300);
	   		data.SelectDropdown("id","ddlBloodGroup","A+");
	   		Thread.sleep(300);
	   		data.SelectDropdown("id","ddlGender","MALE");
	   		Thread.sleep(300);
	   		data.SelectDropdown("id","ddlReligion","HINDU");
	   		Thread.sleep(300);
	   		data.SelectDropdown("id","ddlDay","11");
	   		Thread.sleep(300);
	   		data.SelectDropdown("id","ddlMonth","SEPTEMBER");
	   		Thread.sleep(300);
	   		data.SelectDropdown("id","ddlYear","1993");
	   		
  Thread.sleep(300);
	   		data.enterText("id","txtadhar","761490617322");



Thread.sleep(300);
	   		data.enterText("id","txtParentMob","8280711795");

Thread.sleep(1300);
	   		data.SelectDropdown("id","ddlCState","1 - ODISHA");
	   		Thread.sleep(1300);
	   		data.SelectDropdown("id","ddlCDist","ANGUL");
	   		Thread.sleep(1300);
	   		data.SelectDropdown("id","ddlCBlock","ANGUL");
	   		Thread.sleep(300);
	   		data.enterText("id","txtCPS","PLOT NO-376");
Thread.sleep(300);
	   		data.enterText("id","txtCPC","7");
	   		Thread.sleep(1300);
	   		data.UploadImage();
  
  Thread.sleep(300);
  
  data.clickOnLocator("id","btnSave");
  
   		Thread.sleep(1000);
String actualPopup =data.grtpopup().getText();
		
		System.out.println(actualPopup);
    	
		String expectedmessage = "Please enter only Alphabets";

    	 if(!actualPopup.equals(expectedmessage))
    	 {
    		 System.out.println("Sucessfully Message is" + actualPopup);
    		 data.clickOnLocator("id","popup_ok");
    		 Thread.sleep(1000);
				System.out.println("Click Ok");
    		fileone.setCellData(sheetName, "Result", 318, "Pass");	
    	 }
    	
    	 else
    	 {
    		 fileone.setCellData(sheetName, "Result", 318, "Fail");
    	 }	
    	 
    	 SoftAssert softAssert = new SoftAssert();
    	 softAssert.assertEquals(actualPopup, actualPopup);
	   	}





@Test(priority=19)
	public void MaxLengthShouldNotLess3ForAreaCode
(



) throws IOException, InterruptedException
	{
	test = extent.createTest("MaxLengthShouldNotLess3ForAreaCode");
	String AreaCode=	fileone1.getCellData("JuniorCAF", "AreaCode",19);
			
	
  System.out.println(AreaCode);
  Thread.sleep(300);



  
 
  data.SelectDropdown("id","ddlYOP","2009");
	   		
	   		Thread.sleep(300);
	   		data.clickOnLocator("id","rbtnAnnual");
	   		Thread.sleep(300);
	   		data.enterText("id","txtBoardRoll","21tc187");
	   		
	   		Thread.sleep(2300);
	   		data.enterText("id","txtApplName","Milan");
	   		Thread.sleep(300);
	   		data.enterText("id","txtFatherName","Rajendra");
	   		Thread.sleep(300);
	   		data.enterText("id","txtMotherName","Sarojini");
	   		Thread.sleep(300);
	   		data.SelectDropdown("id","ddlBloodGroup","A+");
	   		Thread.sleep(300);
	   		data.SelectDropdown("id","ddlGender","MALE");
	   		Thread.sleep(300);
	   		data.SelectDropdown("id","ddlReligion","HINDU");
	   		Thread.sleep(300);
	   		data.SelectDropdown("id","ddlDay","11");
	   		Thread.sleep(300);
	   		data.SelectDropdown("id","ddlMonth","SEPTEMBER");
	   		Thread.sleep(300);
	   		data.SelectDropdown("id","ddlYear","1993");
	   		
  Thread.sleep(300);
	   		data.enterText("id","txtadhar","761490617322");



Thread.sleep(300);
	   		data.enterText("id","txtParentMob","8280711795");

Thread.sleep(1300);
	   		data.SelectDropdown("id","ddlCState","1 - ODISHA");
	   		Thread.sleep(1300);
	   		data.SelectDropdown("id","ddlCDist","ANGUL");
	   		Thread.sleep(1300);
	   		data.SelectDropdown("id","ddlCBlock","ANGUL");
	   		Thread.sleep(300);
	   		data.enterText("id","txtCPS","PLOT NO-376");
Thread.sleep(300);
	   		data.enterText("id","txtCPC","751010");


Thread.sleep(300);
	   		data.enterText("id","txtCTCode",AreaCode);
  
	   		Thread.sleep(1300);
	   		data.UploadImage();
  Thread.sleep(300);
  
  data.clickOnLocator("id","btnSave");
  
   		Thread.sleep(1000);
String actualPopup =data.grtpopup().getText();
		
		System.out.println(actualPopup);
    	
		String expectedmessage = "Please enter only Alphabets";

    	 if(!actualPopup.equals(expectedmessage))
    	 {
    		 System.out.println("Sucessfully Message is" + actualPopup);
    		 data.clickOnLocator("id","popup_ok");
    		 Thread.sleep(1000);
				System.out.println("Click Ok");
    		fileone.setCellData(sheetName, "Result", 319, "Pass");	
    	 }
    	
    	 else
    	 {
    		 fileone.setCellData(sheetName, "Result", 319, "Fail");
    	 }	
    	 
    	 SoftAssert softAssert = new SoftAssert();
    	 softAssert.assertEquals(actualPopup, actualPopup);
	   	}







@Test(priority=20)
	public void MaxLengthShouldNotLess5ForPhoneNo
(



) throws IOException, InterruptedException
	{
	test = extent.createTest("MaxLengthShouldNotLess5ForPhoneNo");
	String PhoneNo=	fileone1.getCellData("JuniorCAF", "PhoneNo",19);
			
	
  System.out.println(PhoneNo);
  Thread.sleep(300);



  
 
  data.SelectDropdown("id","ddlYOP","2009");
	   		
	   		Thread.sleep(300);
	   		data.clickOnLocator("id","rbtnAnnual");
	   		Thread.sleep(300);
	   		data.enterText("id","txtBoardRoll","21tc187");
	   		
	   		Thread.sleep(300);
	   		data.enterText("id","txtApplName","Milan");
	   		Thread.sleep(300);
	   		data.enterText("id","txtFatherName","Rajendra");
	   		Thread.sleep(300);
	   		data.enterText("id","txtMotherName","Sarojini");
	   		Thread.sleep(300);
	   		data.SelectDropdown("id","ddlBloodGroup","A+");
	   		Thread.sleep(300);
	   		data.SelectDropdown("id","ddlGender","MALE");
	   		Thread.sleep(300);
	   		data.SelectDropdown("id","ddlReligion","HINDU");
	   		Thread.sleep(300);
	   		data.SelectDropdown("id","ddlDay","11");
	   		Thread.sleep(300);
	   		data.SelectDropdown("id","ddlMonth","SEPTEMBER");
	   		Thread.sleep(300);
	   		data.SelectDropdown("id","ddlYear","1993");
	   		
  Thread.sleep(300);
	   		data.enterText("id","txtadhar","761490617322");



Thread.sleep(300);
	   		data.enterText("id","txtParentMob","8280711795");

Thread.sleep(1300);
	   		data.SelectDropdown("id","ddlCState","1 - ODISHA");
	   		Thread.sleep(1300);
	   		data.SelectDropdown("id","ddlCDist","ANGUL");
	   		Thread.sleep(1300);
	   		data.SelectDropdown("id","ddlCBlock","ANGUL");
	   		Thread.sleep(300);
	   		data.enterText("id","txtCPS","PLOT NO-376");
Thread.sleep(300);
	   		data.enterText("id","txtCPC","751010");


Thread.sleep(300);
	   		data.enterText("id","txtCTCode","0674");
	   		Thread.sleep(1300);
data.UploadImage();

Thread.sleep(300);
	   		data.enterText("id","txtCTeleNo",PhoneNo);
  
  
  Thread.sleep(300);
  
  data.clickOnLocator("id","btnSave");
  
   		Thread.sleep(1000);
String actualPopup =data.grtpopup().getText();
		
		System.out.println(actualPopup);
    	
		String expectedmessage = "Please enter only Alphabets";

    	 if(!actualPopup.equals(expectedmessage))
    	 {
    		 System.out.println("Sucessfully Message is" + actualPopup);
    		 data.clickOnLocator("id","popup_ok");
    		 Thread.sleep(1000);
				System.out.println("Click Ok");
    		fileone.setCellData(sheetName, "Result", 320, "Pass");	
    	 }
    	
    	 else
    	 {
    		 fileone.setCellData(sheetName, "Result", 320, "Fail");
    	 }	
    	 
    	 SoftAssert softAssert = new SoftAssert();
    	 softAssert.assertEquals(actualPopup, actualPopup);
	   	}






@Test(priority=21)
	public void MaxLengthShouldNotLess5ForAccountNumber
(



) throws IOException, InterruptedException
	{
	test = extent.createTest("MaxLengthShouldNotLess5ForAccountNumber");
	String AccountNumber=	fileone1.getCellData("JuniorCAF", "AccountNumber",19);
			
	
  System.out.println(AccountNumber);
  Thread.sleep(300);


data.SelectDropdown("id","ddlAIncome","0 - 1,00,000");
  Thread.sleep(300);
  
 
  data.enterText("id","txtacno",AccountNumber);
  
  
  
  
   		Thread.sleep(1000);
String actualPopup =data.grtpopup().getText();
		
		System.out.println(actualPopup);
    	
		String expectedmessage = "Please enter only Alphabets";

    	 if(!actualPopup.equals(expectedmessage))
    	 {
    		 System.out.println("Sucessfully Message is" + actualPopup);
    		 data.clickOnLocator("id","popup_ok");
    		 Thread.sleep(1000);
				System.out.println("Click Ok");
    		fileone.setCellData(sheetName, "Result", 321, "Pass");	
    	 }
    	
    	 else
    	 {
    		 fileone.setCellData(sheetName, "Result", 321, "Fail");
    	 }	
    	 
    	 SoftAssert softAssert = new SoftAssert();
    	 softAssert.assertEquals(actualPopup, actualPopup);
	   	}





@Test(priority=22)
	public void MaxLengthShouldNotLess11ForIFSC
(



) throws IOException, InterruptedException
	{
	test = extent.createTest("MaxLengthShouldNotLess11ForIFSC");
	String IFSC=	fileone1.getCellData("JuniorCAF", "IFSC",19);
			
	
  System.out.println(IFSC);
  Thread.sleep(300);


data.SelectDropdown("id","ddlAIncome","0 - 1,00,000");
  Thread.sleep(300);
  
 
  data.enterText("id","txtifsc",IFSC);
  
  
  
  
   		Thread.sleep(1000);
String actualPopup =data.grtpopup().getText();
		
		System.out.println(actualPopup);
    	
		String expectedmessage = "Please enter only Alphabets";

    	 if(!actualPopup.equals(expectedmessage))
    	 {
    		 System.out.println("Sucessfully Message is" + actualPopup);
    		 data.clickOnLocator("id","popup_ok");
    		 Thread.sleep(1000);
				System.out.println("Click Ok");
    		fileone.setCellData(sheetName, "Result", 322, "Pass");	
    	 }
    	
    	 else
    	 {
    		 fileone.setCellData(sheetName, "Result", 322, "Fail");
    	 }	
    	 
    	 SoftAssert softAssert = new SoftAssert();
    	 softAssert.assertEquals(actualPopup, actualPopup);
	   	}
		   	






   	}
   

