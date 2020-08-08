
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

public class VerifyChar extends ExtentReportBase {
	
	
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
   	public void AlphabetsAllowForApplicantName
(

) throws IOException, InterruptedException
   	{
    	test = extent.createTest("AlphabetsAllowForApplicantName");
    	data.openBrowser("chrome");
		Thread.sleep(500);
		
		data.openUrl("http://o.samsodisha.gov.in/");
		
		Thread.sleep(500);
		data.LoginPage();
		
		
		
		Thread.sleep(1500);
		
		data.Navigation();
    	String ApplicantNameI = 	fileone1.getCellData("JuniorCAF", "ApplicantName",10);
    			
    	
      System.out.println(ApplicantNameI);
      Thread.sleep(300);
      
      data.checkalphabets("id","txtApplName",ApplicantNameI,"value","Data");
      
      
      
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
	    		fileone.setCellData(sheetName, "Result", 247 , "Pass");	
	    	 }
	    	
	    	 else
	    	 {
	    		 fileone.setCellData(sheetName, "Result", 247, "Fail");
	    	 }	
	    	 
	    	 SoftAssert softAssert = new SoftAssert();
	    	 softAssert.assertEquals(actualPopup, actualPopup);
		   	}
    
    
   
    
    
    
    @Test(priority=3)
   	public void AlphabetsAllowFoeFatherName
(



) throws IOException, InterruptedException
   	{
    	test = extent.createTest("AlphabetsAllowFoeFatherName");
    	String FatherNameI = 	fileone1.getCellData("JuniorCAF", "FatherName",10);
    			
    	
      System.out.println(FatherNameI);
      Thread.sleep(300);
      
      data.checkalphabets("id","txtFatherName",FatherNameI,"value","Data");
	   		
	   		
	   		
	   		
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
	    		fileone.setCellData(sheetName, "Result", 248 , "Pass");	
	    	 }
	    	
	    	 else
	    	 {
	    		 fileone.setCellData(sheetName, "Result", 248, "Fail");
	    	 }	
	    	 
	    	 SoftAssert softAssert = new SoftAssert();
	    	 softAssert.assertEquals(actualPopup, actualPopup);
		   	}
    
    
   
    
    
    
    @Test(priority=6)
   	public void AlphabetsAllowForMotherName
(



) throws IOException, InterruptedException
   	{
    	test = extent.createTest("AlphabetsAllowForMotherName");
    	String MotherNameI = 	fileone1.getCellData("JuniorCAF", "MotherName",10);
    			
    	
      System.out.println(MotherNameI);
      Thread.sleep(300);
      
      data.checkalphabets("id","txtMotherName",MotherNameI,"value","Data");
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
	    		fileone.setCellData(sheetName, "Result", 249 , "Pass");	
	    	 }
	    	
	    	 else
	    	 {
	    		 fileone.setCellData(sheetName, "Result", 249, "Fail");
	    	 }	
	    	 
	    	 SoftAssert softAssert = new SoftAssert();
	    	 softAssert.assertEquals(actualPopup, actualPopup);
		   	}
    
    
    
   
    @Test(priority=9)
   	public void AlphabetsNotAllowForAadharNumber
(



) throws IOException, InterruptedException
   	{
    	test = extent.createTest("AlphabetsNotAllowForAadharNumber");
    	String AadharNoI = 	fileone1.getCellData("JuniorCAF", "AadharNo",10);
    			
    	
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
	    		fileone.setCellData(sheetName, "Result", 250 , "Pass");	
	    	 }
	    	
	    	 else
	    	 {
	    		 fileone.setCellData(sheetName, "Result", 250, "Fail");
	    	 }	
	    	 
	    	 SoftAssert softAssert = new SoftAssert();
	    	 softAssert.assertEquals(actualPopup, actualPopup);
		   	}
  
    @Test(priority=12)
    public void AlphabetsNotAllowForMobileNo
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("AlphabetsNotAllowForMobileNo");
        	String MobileNoI = 	fileone1.getCellData("JuniorCAF", "MobileNo",10);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 251 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 251, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
  
    
    
    
    @Test(priority=15)
    public void AlphabetsNotAllowForPincode
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("AlphabetsNotAllowForPincode");
        	String PinCodeI = 	fileone1.getCellData("JuniorCAF", "PinCode",10);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 252 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 252, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    
   
    
    @Test(priority=18)
    public void AlphabetsNotAllowForAreaCode
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("AlphabetsNotAllowForAreaCode");
        	String AreaCodeI = 	fileone1.getCellData("JuniorCAF", "AreaCode",10);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 253 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 253, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    
    
    
    
    @Test(priority=21)
    public void AlphabetsNotAllowForPhoneNo
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("AlphabetsNotAllowForPhoneNo");
        	String PhoneNoI = 	fileone1.getCellData("JuniorCAF", "PhoneNo",10);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 254 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 254, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    
   
    
    @Test(priority=24)
    public void AlphabetsNotAllowForMaximumMark
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("AlphabetsNotAllowForMaximumMark");
        	String MaximumMarkI= 	fileone1.getCellData("JuniorCAF", "MaximumMark",10);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 255 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 255, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
  
    
    
    @Test(priority=27)
    public void AlphabetsNotAllowForSecuredMark
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("AlphabetsNotAllowForSecuredMark");
        	String SecuredMarkI= 	fileone1.getCellData("JuniorCAF", "SecuredMark",10);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 256 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 256, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
   
    
    
    
    @Test(priority=30)
    public void AlphabetsNotAllowForEnglish
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("AlphabetsNotAllowForEnglish");
        	String EnglishI= 	fileone1.getCellData("JuniorCAF", "English",10);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 257 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 257, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
   
    
    
    
    @Test(priority=33)
    public void AlphabetsNotAllowForMath
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("AlphabetsNotAllowForMath");
        	String MathI= 	fileone1.getCellData("JuniorCAF", "Math",10);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 258 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 258, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    
    
    @Test(priority=36)
    public void AlphabetsNotAllowForScience
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("AlphabetsNotAllowForScience");
        	String ScienceI= 	fileone1.getCellData("JuniorCAF", "Science",10);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 259 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 259, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
  
    
    
    @Test(priority=39)
    public void AlphabetsNotAllowForSocialScience
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("AlphabetsNotAllowForSocialScience");
        	String SocialScienceI= 	fileone1.getCellData("JuniorCAF", "SocialScience",10);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 260 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 260, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
  
    
    
    
    @Test(priority=42)
    public void AlphabetsNotAllowForAccountNumber
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("AlphabetsNotAllowForAccountNumber");
        	String AccountNumberI= 	fileone1.getCellData("JuniorCAF", "AccountNumber",10);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 261 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 261, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    
    
    
    
    
    
    @Test(priority=48)
    public void AlphabetsNotAllowForMICRCode
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("AlphabetsNotAllowForMICRCode");
        	String MICRI= 	fileone1.getCellData("JuniorCAF", "MICR",10);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 262 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 262, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
   
    
    
    @Test(priority=49)
    public void AlphabetsAllowForBankName
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("AlphabetsAllowForBankName");
        	String BankI= 	fileone1.getCellData("JuniorCAF", "BankName",10);
        			
        	
          System.out.println(BankI);
          Thread.sleep(300);
          
          
          data.SelectDropdown("id", "ddlAIncome", "0 - 1,00,000");
          Thread.sleep(700);
          data.checkalphabets("id","txtBankname",BankI,"value","Data");
    	   		
          
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
    	    		fileone.setCellData(sheetName, "Result", 263 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 263, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
   
    
    
    
    @Test(priority=51)
    public void AlphabetsAllowForBranchName
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("AlphabetsAllowForBranchName");
        	String BranchI= 	fileone1.getCellData("JuniorCAF", "BranchName",10);
        			
        	
          System.out.println(BranchI);
          Thread.sleep(300);
          
          
          data.SelectDropdown("id", "ddlAIncome", "0 - 1,00,000");
          Thread.sleep(700);
          data.checkalphabets("id","txtBrname",BranchI,"value","Data");
    	   		
          
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
    	    		fileone.setCellData(sheetName, "Result", 264 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 264, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    
   
    
    
    
    @Test(priority=54)
    public void AlphabetsAllowForSchoolName
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("AlphabetsAllowForSchoolName");
        	String SchoolNameI= 	fileone1.getCellData("JuniorCAF", "SchoolName",10);
        			
        	
          System.out.println(SchoolNameI);
          Thread.sleep(300);
          
          
         
          Thread.sleep(700);
          data.checkalphabets("id","txtschname",SchoolNameI,"value","Data");
    	   		
          Thread.sleep(700);
          
          
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
    	    		fileone.setCellData(sheetName, "Result", 265 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 265, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    
   
    
    @Test(priority=56)
    public void AlphabetsAllowForSchoolLocation
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("AlphabetsAllowForSchoolLocation");
        	String SchoolLocationI= 	fileone1.getCellData("JuniorCAF", "SchoolLocation",10);
        			
        	
          System.out.println(SchoolLocationI);
          Thread.sleep(300);
          
          
         
          Thread.sleep(700);
          
    	   		
          data.checkalphabets("id","txtschloc",SchoolLocationI,"value","Data");
          
 Thread.sleep(700);
          
          
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
    	    		fileone.setCellData(sheetName, "Result", 266 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 266, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
   
    
    
    
    
    @Test(priority=59)
    public void AlphabetsNotAllowForFailMark
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("AlphabetsNotAllowForFailMark");
        	String FailMarkI= 	fileone1.getCellData("JuniorCAF", "FailMark",10);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 267 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 267, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    
    
    @Test(priority=62)
    public void AlphabetsNotAllowForPassMark
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("AlphabetsNotAllowForPassMark");
        	String PassMarkI= 	fileone1.getCellData("JuniorCAF", "PassMark",10);
        			
        	
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
    	    		fileone.setCellData(sheetName, "Result", 268 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 268, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    
    @Test(priority=62)
    public void NumericNotAlloForApplicantName
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("NumericNotAlloForApplicantName");
        	String ApplicantNameN= 	fileone1.getCellData("JuniorCAF", "ApplicantName",12);
        			
        	
          System.out.println(ApplicantNameN);
         // Thread.sleep(300);
          
         
         
          Thread.sleep(700);
          data.enterText("id","txtApplName",ApplicantNameN);
    	   		
          
          

          
      	
    	   		
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
    	    		fileone.setCellData(sheetName, "Result", 269 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 269, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    
    
    @Test(priority=62)
    public void NumericNotAlloForFatherName
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("NumericNotAlloForFatherName");
        	String FatherNameN= 	fileone1.getCellData("JuniorCAF", "FatherName",12);
        			
        	
          System.out.println(FatherNameN);
         // Thread.sleep(300);
          
         
         
          Thread.sleep(700);
          data.enterText("id","txtFatherName",FatherNameN);
    	   		
          
          

          
      	
    	   		
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
    	    		fileone.setCellData(sheetName, "Result", 270 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 270, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    @Test(priority=62)
    public void NumericNotAlloForMotherName
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("NumericNotAlloForMotherName");
        	String MotherNameN= 	fileone1.getCellData("JuniorCAF", "MotherName",12);
        			
        	
          System.out.println(MotherNameN);
         // Thread.sleep(300);
          
         
         
          Thread.sleep(700);
          data.enterText("id","txtMotherName",MotherNameN);
    	   		
          
          

          
      	
    	   		
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
    	    		fileone.setCellData(sheetName, "Result", 271 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 271, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    
    
    @Test(priority=62)
    public void NumericAlloForAadharNumber
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("NumericAlloForAadharNumber");
        	String AadharNoN= 	fileone1.getCellData("JuniorCAF", "AadharNo",12);
        			
        	
          System.out.println(AadharNoN);
         // Thread.sleep(300);
          
         
         
          Thread.sleep(700);
          data.checkNumeric("id","txtadhar",AadharNoN,"value","Data");
    	   		
          
          Thread.sleep(700);

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
    	    		fileone.setCellData(sheetName, "Result", 272 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 272, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    
    
    @Test(priority=62)
    public void NumericAlloForMobileNumber
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("NumericAlloForMobileNumber");
        	String MobileNoN= 	fileone1.getCellData("JuniorCAF", "MobileNo",12);
        			
        	
          System.out.println(MobileNoN);
         // Thread.sleep(300);
          
         
         
          Thread.sleep(700);
          data.checkNumeric("id","txtParentMob",MobileNoN,"value","Data");
    	   		
          
          Thread.sleep(700);

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
    	    		fileone.setCellData(sheetName, "Result", 273 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 273, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    
    @Test(priority=62)
    public void NumericAlloForPinCode
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("NumericAlloForPinCode");
        	String PinCodeN= 	fileone1.getCellData("JuniorCAF", "PinCode",12);
        			
        	
          System.out.println(PinCodeN);
         // Thread.sleep(300);
          
         
         
          Thread.sleep(700);
          data.checkNumeric("id","txtCPC",PinCodeN,"value","Data");
    	   		
          
          Thread.sleep(700);

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
    	    		fileone.setCellData(sheetName, "Result", 274 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 274, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    
    @Test(priority=62)
    public void NumericAlloForAreaCode
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("NumericAlloForAreaCode");
        	String AreaCodeN= 	fileone1.getCellData("JuniorCAF", "AreaCode",12);
        			
        	
          System.out.println(AreaCodeN);
         // Thread.sleep(300);
          
         
         
          Thread.sleep(700);
          data.checkNumeric("id","txtCTCode",AreaCodeN,"value","Data");
    	   		
          
          Thread.sleep(700);

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
    	    		fileone.setCellData(sheetName, "Result", 275 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 275, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    @Test(priority=62)
    public void NumericAlloForPhoneNumber
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("NumericAlloForPhoneNumber");
        	String PhoneNoN= 	fileone1.getCellData("JuniorCAF", "PhoneNo",12);
        			
        	
          System.out.println(PhoneNoN);
         // Thread.sleep(300);
          
         
         
          Thread.sleep(700);
          data.checkNumeric("id","txtCTeleNo",PhoneNoN,"value","Data");
    	   		
          
          Thread.sleep(700);

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
    	    		fileone.setCellData(sheetName, "Result", 276 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 276, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    
    
    @Test(priority=62)
    public void NumericAlloForMaximumMark
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("NumericAlloForMaximumMark");
        	String MaximumMarkN= 	fileone1.getCellData("JuniorCAF", "MaximumMark",12);
        			
        	
          System.out.println(MaximumMarkN);
         // Thread.sleep(300);
          
         
         
          Thread.sleep(700);
          data.checkNumeric("id","txtMaxMark",MaximumMarkN,"value","Data");
    	   		
          
          Thread.sleep(700);

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
    	    		fileone.setCellData(sheetName, "Result", 277 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 277, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    
    @Test(priority=62)
    public void NumericAlloForSecuredMark
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("NumericAlloForSecuredMark");
        	String SecuredMarkN= 	fileone1.getCellData("JuniorCAF", "SecuredMark",12);
        			
        	
          System.out.println(SecuredMarkN);
         // Thread.sleep(300);
          
         
         
          Thread.sleep(700);
          data.checkNumeric("id","txtTotMark",SecuredMarkN,"value","Data");
    	   		
          
          Thread.sleep(700);

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
    	    		fileone.setCellData(sheetName, "Result", 278 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 278, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    
    @Test(priority=62)
    public void NumericAlloForEnglish
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("NumericAlloForEnglish");
        	String EnglishN= 	fileone1.getCellData("JuniorCAF", "English",12);
        			
        	
          System.out.println(EnglishN);
         // Thread.sleep(300);
          
         
         
          Thread.sleep(700);
          data.checkNumeric("id","txtEnglish",EnglishN,"value","Data");
    	   		
          
          Thread.sleep(700);

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
    	    		fileone.setCellData(sheetName, "Result", 279 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 279, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    
    @Test(priority=62)
    public void NumericAlloForMath
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("NumericAlloForMath");
        	String MathN= 	fileone1.getCellData("JuniorCAF", "Math",12);
        			
        	
          System.out.println(MathN);
         // Thread.sleep(300);
          
         
         
          Thread.sleep(700);
          data.checkNumeric("id","txtMath",MathN,"value","Data");
    	   		
          
          Thread.sleep(700);

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
    	    		fileone.setCellData(sheetName, "Result", 280 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 280, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    
    @Test(priority=62)
    public void NumericAlloForScience
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("NumericAlloForScience");
        	String ScienceN= 	fileone1.getCellData("JuniorCAF", "Science",12);
        			
        	
          System.out.println(ScienceN);
         // Thread.sleep(300);
          
         
         
          Thread.sleep(700);
          data.checkNumeric("id","txtScience",ScienceN,"value","Data");
    	   		
          
          Thread.sleep(700);

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
    	    		fileone.setCellData(sheetName, "Result", 281 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 281, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    
    @Test(priority=62)
    public void NumericAlloForSocialScience
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("NumericAlloForSocialScience");
        	String SocialScienceN= 	fileone1.getCellData("JuniorCAF", "SocialScience",12);
        			
        	
          System.out.println(SocialScienceN);
         // Thread.sleep(300);
          
         
         
          Thread.sleep(700);
          data.checkNumeric("id","txtSocSci",SocialScienceN,"value","Data");
    	   		
          
          Thread.sleep(700);

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
    	    		fileone.setCellData(sheetName, "Result", 282 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 282, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    
    @Test(priority=62)
    public void NumericAlloForAccountNumber
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("NumericAlloForAccountNumber");
        	String AccountNumberN= 	fileone1.getCellData("JuniorCAF", "AccountNumber",12);
        			
        	
          System.out.println(AccountNumberN);
        Thread.sleep(300);
          
         data.SelectDropdown("id", "ddlAIncome", "0 - 1,00,000");
         
          Thread.sleep(700);
          data.checkNumeric("id","txtacno",AccountNumberN,"value","Data");
    	   		
          
          Thread.sleep(700);

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
    	    		fileone.setCellData(sheetName, "Result", 283 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 283, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    
    @Test(priority=62)
    public void NumericAlloForMICRCode
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("NumericAlloForMICRCode");
        	String MICRN= 	fileone1.getCellData("JuniorCAF", "MICR",12);
        			
        	
          System.out.println(MICRN);
        Thread.sleep(300);
          
         data.SelectDropdown("id", "ddlAIncome", "0 - 1,00,000");
         
          Thread.sleep(700);
          data.checkNumeric("id","txtmicr",MICRN,"value","Data");
    	   		
          
          Thread.sleep(700);

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
    	    		fileone.setCellData(sheetName, "Result", 284 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 284, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    @Test(priority=62)
    public void NumericNotAlloForBankName
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("NumericNotAlloForBankName");
        	String BankNameN= 	fileone1.getCellData("JuniorCAF", "BankName",12);
        			
        	
          System.out.println(BankNameN);
        Thread.sleep(300);
          
         data.SelectDropdown("id", "ddlAIncome", "0 - 1,00,000");
         
          Thread.sleep(700);
          data.checkNumeric("id","txtBankname",BankNameN,"value","Data");
    	   		
          
          data.clickOnLocator("id","btnSave");
      	
    	   		
    	   		Thread.sleep(7000);
    String actualPopup =data.grtpopup().getText();
    			
    			System.out.println(actualPopup);
    	    	
    			String expectedmessage = "Please select Year of Passing !";

    	    	 if(actualPopup.equals(expectedmessage))
    	    	 {
    	    		 System.out.println("Sucessfully Message is" + actualPopup);
    	    		 data.clickOnLocator("id","popup_ok");
    	    		 Thread.sleep(1000);
    					System.out.println("Click Ok");
    	    		fileone.setCellData(sheetName, "Result", 285 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 285, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    
    @Test(priority=62)
    public void NumericAlloForBranchName
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("NumericAlloForBranchName");
        	String BranchNameN= 	fileone1.getCellData("JuniorCAF", "BranchName",12);
        			
        	
          System.out.println(BranchNameN);
        Thread.sleep(300);
          
         data.SelectDropdown("id", "ddlAIncome", "0 - 1,00,000");
         
          Thread.sleep(700);
          data.checkNumeric("id","txtBrname",BranchNameN,"value","Data");
    	   		
          
          Thread.sleep(700);

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
    	    		fileone.setCellData(sheetName, "Result", 286 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 286, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    
    @Test(priority=62)
    public void NumericAlloForSchoolName
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("NumericAlloForSchoolName");
        	String SchoolNameN= 	fileone1.getCellData("JuniorCAF", "SchoolName",12);
        			
        	
          System.out.println(SchoolNameN);
        Thread.sleep(300);
          
         
          data.checkNumeric("id","txtschname",SchoolNameN,"value","Data");
    	   		
          
          Thread.sleep(700);

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
    	    		fileone.setCellData(sheetName, "Result", 287 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 287, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    @Test(priority=62)
    public void NumericAlloForLoactionSchool
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("NumericAlloForLoactionSchool");
        	String SchoolLocationN= 	fileone1.getCellData("JuniorCAF", "SchoolLocation",12);
        			
        	
          System.out.println(SchoolLocationN);
        Thread.sleep(300);
          
         
          data.checkNumeric("id","txtschloc",SchoolLocationN,"value","Data");
    	   		
          
          Thread.sleep(700);

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
    	    		fileone.setCellData(sheetName, "Result", 288 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 288, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    
    
    
    @Test(priority=62)
    public void NumericAlloForFailMark
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("NumericAlloForFailMark");
        	String FailMarkN= 	fileone1.getCellData("JuniorCAF", "FailMark",12);
        			
        	
          System.out.println(FailMarkN);
        Thread.sleep(300);
          data.clickOnLocator("id", "rbtCompartmentalY");
          Thread.sleep(300);
          data.checkNumeric("id","txtCompFMark1",FailMarkN,"value","Data");
    	   		
          
          Thread.sleep(700);

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
    	    		fileone.setCellData(sheetName, "Result", 289 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 289, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
    
    
    
    @Test(priority=62)
    public void NumericAlloForPassMark
    (



    ) throws IOException, InterruptedException
       	{
    	test = extent.createTest("NumericAlloForPassMark");
        	String PassMarkN= 	fileone1.getCellData("JuniorCAF", "PassMark",12);
        			
        	
          System.out.println(PassMarkN);
        Thread.sleep(300);
          data.clickOnLocator("id", "rbtCompartmentalY");
          Thread.sleep(300);
          data.checkNumeric("id","txtCompPMark1",PassMarkN,"value","Data");
    	   		
          
          Thread.sleep(700);

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
    	    		fileone.setCellData(sheetName, "Result", 290 , "Pass");	
    	    	 }
    	    	
    	    	 else
    	    	 {
    	    		 fileone.setCellData(sheetName, "Result", 290, "Fail");
    	    	 }	
    	    	 
    	    	 SoftAssert softAssert = new SoftAssert();
    	    	 softAssert.assertEquals(actualPopup, actualPopup);
    		   	}
  
   	}
   

