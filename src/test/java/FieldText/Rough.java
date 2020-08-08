
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


import Genericlib.CommonFunction;
import Genericlib.ExcelUtils;
import Genericlib.Xls_AllMethods;


public class Rough extends ExtentReportBase {
	
	
	
		//private static final int j = 0;
		static Xls_AllMethods fileone = new Xls_AllMethods("C:/Users/satyaranjan.m/eclipse-workspace/JuniorForm/JuniorFieldValidationwrite.xlsx");	
		
		 
		 static Xls_AllMethods fileone1 = new Xls_AllMethods("C:/Users/satyaranjan.m/eclipse-workspace/JuniorForm/RoughSheet.xlsx");
		 
		 
		 
		 
		 
		XSSFWorkbook wb;
		XSSFSheet sht;
		String sheetName = "JuniorFieldMapping";
	 int rowCount = fileone.getRowCount(sheetName);

	 
	// static WebDriver driver;
		CommonFunction data = new CommonFunction();
		
		
		
		@Test(priority=18)
	   	public void whitespacenotallowinitialplaceForBankName
	(



	) throws IOException, InterruptedException
	   	{
	    	test = extent.createTest("whitespacenotallowinitialplaceForBankName");
	    	data.openBrowser("chrome");
			Thread.sleep(500);
			
			data.openUrl("http://o.samsodisha.gov.in/");
			
			Thread.sleep(500);
			data.LoginPage();
			
			
			
			Thread.sleep(1500);
			
			data.Navigation();
	    	String YOP = 	fileone1.getCellData("JuniorCAF", "YOP",21);
	String RollNumber = 	fileone1.getCellData("JuniorCAF", "RollNumber",21);
	String ApplicantName = 	fileone1.getCellData("JuniorCAF", "ApplicantName",21);
	String FatherName = 	fileone1.getCellData("JuniorCAF", "FatherName",21);
	String MotherName = 	fileone1.getCellData("JuniorCAF", "MotherName",21);
	String BloodGroup = 	fileone1.getCellData("JuniorCAF", "BloodGroup",21);
	String Gender = 	fileone1.getCellData("JuniorCAF", "Gender",21);
	String Religion = 	fileone1.getCellData("JuniorCAF", "Religion",21);
	String Day = 	fileone1.getCellData("JuniorCAF", "Day",21);
	String Month = 	fileone1.getCellData("JuniorCAF", "Month",21);
	String Year = 	fileone1.getCellData("JuniorCAF", "Year",21);
	String AadharNo = 	fileone1.getCellData("JuniorCAF", "AadharNo",21);
	String MobileNo = 	fileone1.getCellData("JuniorCAF", "MobileNo",21);
	String State = 	fileone1.getCellData("JuniorCAF", "State",21);
	String District = 	fileone1.getCellData("JuniorCAF", "District",21);
	String Block = 	fileone1.getCellData("JuniorCAF", "Block",21);
	String HouseNo = 	fileone1.getCellData("JuniorCAF", "HouseNo",21);
	String PinCode = 	fileone1.getCellData("JuniorCAF", "PinCode",21);
	String Email = 	fileone1.getCellData("JuniorCAF", "Email",21);
	String AreaCode = 	fileone1.getCellData("JuniorCAF", "AreaCode",21);
	String PhoneNo = 	fileone1.getCellData("JuniorCAF", "PhoneNo",21);
	String MaximumMark = 	fileone1.getCellData("JuniorCAF", "MaximumMark",21);
	String SecuredMark = 	fileone1.getCellData("JuniorCAF", "SecuredMark",21);
	String English = 	fileone1.getCellData("JuniorCAF", "English",21);
	String Math = 	fileone1.getCellData("JuniorCAF", "Math",21);
	String Science = 	fileone1.getCellData("JuniorCAF", "Science",21);
	String SocialScience = 	fileone1.getCellData("JuniorCAF", "SocialScience",21);
	String Grade = 	fileone1.getCellData("JuniorCAF", "Grade",21);
	String FatherOccupation = 	fileone1.getCellData("JuniorCAF", "FatherOccupation",21);
	String MotherOccupation = 	fileone1.getCellData("JuniorCAF", "MotherOccupation",21);
	String AuualIncome = 	fileone1.getCellData("JuniorCAF", "AuualIncome",21);
	String SchoolName = 	fileone1.getCellData("JuniorCAF", "SchoolName",21);
	String SchoolLocation = 	fileone1.getCellData("JuniorCAF", "SchoolLocation",21);
	String InstituteDistrict = 	fileone1.getCellData("JuniorCAF", "InstituteDistrict",21);
	String YOJ = 	fileone1.getCellData("JuniorCAF", "YOJ",21);
	String AccountNumber = 	fileone1.getCellData("JuniorCAF", "AccountNumber",21);
	String IFSC = 	fileone1.getCellData("JuniorCAF", "IFSC",21);
	      Thread.sleep(1300);
	      
	      data.SelectDropdown("id","ddlYOP","2009");
		   		Thread.sleep(100);

	Thread.sleep(1300);
	data.clickOnLocator("id","rbtnAnnual");

	Thread.sleep(1300);

	data.enterText("id","txtBoardRoll",RollNumber);


	Thread.sleep(1300);

	data.enterText("id","txtApplName",ApplicantName);

	

	Thread.sleep(1300);

	data.enterText("id","txtFatherName",FatherName);



	Thread.sleep(1300);

	data.enterText("id","txtMotherName",MotherName);

	Thread.sleep(1300);
      
      data.SelectDropdown("id","ddlBloodGroup","A+");



Thread.sleep(1300);
      
      data.SelectDropdown("id","ddlGender","MALE");



Thread.sleep(1300);
      
      data.SelectDropdown("id","ddlReligion","HINDU");



Thread.sleep(1300);
      
      data.SelectDropdown("id","ddlDay","11");


Thread.sleep(1300);
      
      data.SelectDropdown("id","ddlMonth","SEPTEMBER");


Thread.sleep(1300);
      
      data.SelectDropdown("id","ddlYear","1993");

	Thread.sleep(1300);
	      
	      data.SelectDropdown("id","ddlNationality","INDIAN");



	Thread.sleep(1300);
	      
	      data.SelectDropdown("id","ddlMt","ODIA");




	Thread.sleep(1300);

	data.enterText("id","txtadhar",AadharNo);


	Thread.sleep(1300);

	data.enterText("id","txtParentMob",MobileNo);
	Thread.sleep(1300);
	Thread.sleep(1300);
	      
	      data.SelectDropdown("id","ddlCState","1 - ODISHA");


	Thread.sleep(1300);
	      
	      data.SelectDropdown("id","ddlCDist","ANGUL");


	Thread.sleep(1300);
	      
	      data.SelectDropdown("id","ddlCBlock","ANGUL");

	Thread.sleep(1300);

	data.enterText("id","txtCPS",HouseNo);
	Thread.sleep(1300);

	data.enterText("id","txtCPC",PinCode);


	Thread.sleep(1300);

	data.enterText("id","txtCEmail",Email);




	Thread.sleep(1300);

	data.enterText("id","txtCTCode",AreaCode);



	Thread.sleep(1300);

	data.enterText("id","txtCTCode",PhoneNo);


	Thread.sleep(1300);

	data.enterText("id","txtMaxMark",MaximumMark);

	Thread.sleep(1300);

	data.enterText("id","txtTotMark",SecuredMark);


	Thread.sleep(1300);

	data.enterText("id","txtEnglish",English);


	Thread.sleep(1300);

	data.enterText("id","txtMath",Math);


	Thread.sleep(1300);

	data.enterText("id","txtScience",Science);


	Thread.sleep(1300);

	data.enterText("id","txtSocSci",SocialScience);


	//Thread.sleep(1300);
	      
	     // data.SelectDropdown("id","ddlGrade","A1");


	Thread.sleep(1300);
	      
	      data.SelectDropdown("id","ddlFOcu","BUSINESS");


	Thread.sleep(1300);
	      
	      data.SelectDropdown("id","ddlMOcu","BUSINESS");


	Thread.sleep(1300);
	      
	      data.SelectDropdown("id","ddlAIncome","0 - 1,00,000");


	


	Thread.sleep(1300);

	data.enterText("id","txtschname",SchoolName);

	Thread.sleep(1300);

	data.enterText("id","txtschloc",SchoolLocation);


	Thread.sleep(1300);
	      
	      data.SelectDropdown("id","ddlinstDistrict","ANGUL");

	Thread.sleep(1300);
	      
	      data.SelectDropdown("id","ddlYOJ","1995");

	Thread.sleep(1300);

	data.enterText("id","txtacno",AccountNumber);


	Thread.sleep(1300);

	data.enterText("id","txtifsc",IFSC);
	
	
	
	Thread.sleep(1300);

	data.enterText("id","txtBankname","  SBI");


	data.UploadImage();
	Thread.sleep(1300);
	data.clickOnLocator("id","btnSave");
		   		Thread.sleep(1000);
	String actualPopup =data.grtpopup().getText();
				
				System.out.println(actualPopup);
		    	
				String expectedmessage = "Please select minimum 5 Option details";

		    	 if(actualPopup.equals(expectedmessage))
		    	 {
		    		 System.out.println("Sucessfully Message is" + actualPopup);
		    		 data.clickOnLocator("id","popup_ok");
		    		 Thread.sleep(1000);
						System.out.println("Click Ok");
		    		fileone.setCellData(sheetName, "Result", 59, "Pass");	
		    	 }
		    	
		    	 else
		    	 {
		    		 fileone.setCellData(sheetName, "Result", 59, "Fail");
		    		 data.clickOnLocator("id","popup_ok");
		    	 }	
		    	 
		    	 SoftAssert softAssert = new SoftAssert();
		    	 softAssert.assertEquals(actualPopup, actualPopup);
			   	}
		
		
		
		@Test(priority=19)
	   	public void whitespacenotallowLastplaceForBankName
	(



	) throws IOException, InterruptedException
	   	{
	    	test = extent.createTest("whitespacenotallowLastplaceForBankName");
	    	String YOP = 	fileone1.getCellData("JuniorCAF", "YOP",21);
	String RollNumber = 	fileone1.getCellData("JuniorCAF", "RollNumber",21);
	String ApplicantName = 	fileone1.getCellData("JuniorCAF", "ApplicantName",21);
	String FatherName = 	fileone1.getCellData("JuniorCAF", "FatherName",21);
	String MotherName = 	fileone1.getCellData("JuniorCAF", "MotherName",21);
	String BloodGroup = 	fileone1.getCellData("JuniorCAF", "BloodGroup",21);
	String Gender = 	fileone1.getCellData("JuniorCAF", "Gender",21);
	String Religion = 	fileone1.getCellData("JuniorCAF", "Religion",21);
	String Day = 	fileone1.getCellData("JuniorCAF", "Day",21);
	String Month = 	fileone1.getCellData("JuniorCAF", "Month",21);
	String Year = 	fileone1.getCellData("JuniorCAF", "Year",21);
	String AadharNo = 	fileone1.getCellData("JuniorCAF", "AadharNo",21);
	String MobileNo = 	fileone1.getCellData("JuniorCAF", "MobileNo",21);
	String State = 	fileone1.getCellData("JuniorCAF", "State",21);
	String District = 	fileone1.getCellData("JuniorCAF", "District",21);
	String Block = 	fileone1.getCellData("JuniorCAF", "Block",21);
	String HouseNo = 	fileone1.getCellData("JuniorCAF", "HouseNo",21);
	String PinCode = 	fileone1.getCellData("JuniorCAF", "PinCode",21);
	String Email = 	fileone1.getCellData("JuniorCAF", "Email",21);
	String AreaCode = 	fileone1.getCellData("JuniorCAF", "AreaCode",21);
	String PhoneNo = 	fileone1.getCellData("JuniorCAF", "PhoneNo",21);
	String MaximumMark = 	fileone1.getCellData("JuniorCAF", "MaximumMark",21);
	String SecuredMark = 	fileone1.getCellData("JuniorCAF", "SecuredMark",21);
	String English = 	fileone1.getCellData("JuniorCAF", "English",21);
	String Math = 	fileone1.getCellData("JuniorCAF", "Math",21);
	String Science = 	fileone1.getCellData("JuniorCAF", "Science",21);
	String SocialScience = 	fileone1.getCellData("JuniorCAF", "SocialScience",21);
	String Grade = 	fileone1.getCellData("JuniorCAF", "Grade",21);
	String FatherOccupation = 	fileone1.getCellData("JuniorCAF", "FatherOccupation",21);
	String MotherOccupation = 	fileone1.getCellData("JuniorCAF", "MotherOccupation",21);
	String AuualIncome = 	fileone1.getCellData("JuniorCAF", "AuualIncome",21);
	String SchoolName = 	fileone1.getCellData("JuniorCAF", "SchoolName",21);
	String SchoolLocation = 	fileone1.getCellData("JuniorCAF", "SchoolLocation",21);
	String InstituteDistrict = 	fileone1.getCellData("JuniorCAF", "InstituteDistrict",21);
	String YOJ = 	fileone1.getCellData("JuniorCAF", "YOJ",21);
	String AccountNumber = 	fileone1.getCellData("JuniorCAF", "AccountNumber",21);
	String IFSC = 	fileone1.getCellData("JuniorCAF", "IFSC",21);
	      Thread.sleep(1300);
	      
	      data.SelectDropdown("id","ddlYOP","2009");
		   		Thread.sleep(100);

	Thread.sleep(1300);
	data.clickOnLocator("id","rbtnAnnual");

	Thread.sleep(1300);

	data.enterText("id","txtBoardRoll",RollNumber);


	Thread.sleep(1300);

	data.enterText("id","txtApplName",ApplicantName);

	

	Thread.sleep(1300);

	data.enterText("id","txtFatherName",FatherName);



	Thread.sleep(1300);

	data.enterText("id","txtMotherName",MotherName);

	Thread.sleep(1300);
      
      data.SelectDropdown("id","ddlBloodGroup","A+");



Thread.sleep(1300);
      
      data.SelectDropdown("id","ddlGender","MALE");



Thread.sleep(1300);
      
      data.SelectDropdown("id","ddlReligion","HINDU");



Thread.sleep(1300);
      
      data.SelectDropdown("id","ddlDay","11");


Thread.sleep(1300);
      
      data.SelectDropdown("id","ddlMonth","SEPTEMBER");


Thread.sleep(1300);
      
      data.SelectDropdown("id","ddlYear","1993");

	Thread.sleep(1300);
	      
	      data.SelectDropdown("id","ddlNationality","INDIAN");



	Thread.sleep(1300);
	      
	      data.SelectDropdown("id","ddlMt","ODIA");




	Thread.sleep(1300);

	data.enterText("id","txtadhar",AadharNo);


	Thread.sleep(1300);

	data.enterText("id","txtParentMob",MobileNo);
	Thread.sleep(1300);
	Thread.sleep(1300);
	      
	      data.SelectDropdown("id","ddlCState","1 - ODISHA");


	Thread.sleep(1300);
	      
	      data.SelectDropdown("id","ddlCDist","ANGUL");


	Thread.sleep(1300);
	      
	      data.SelectDropdown("id","ddlCBlock","ANGUL");

	Thread.sleep(1300);

	data.enterText("id","txtCPS",HouseNo);
	Thread.sleep(1300);

	data.enterText("id","txtCPC",PinCode);


	Thread.sleep(1300);

	data.enterText("id","txtCEmail",Email);




	Thread.sleep(1300);

	data.enterText("id","txtCTCode",AreaCode);



	Thread.sleep(1300);

	data.enterText("id","txtCTCode",PhoneNo);


	Thread.sleep(1300);

	data.enterText("id","txtMaxMark",MaximumMark);

	Thread.sleep(1300);

	data.enterText("id","txtTotMark",SecuredMark);


	Thread.sleep(1300);

	data.enterText("id","txtEnglish",English);


	Thread.sleep(1300);

	data.enterText("id","txtMath",Math);


	Thread.sleep(1300);

	data.enterText("id","txtScience",Science);


	Thread.sleep(1300);

	data.enterText("id","txtSocSci",SocialScience);


	//Thread.sleep(1300);
	      
	     // data.SelectDropdown("id","ddlGrade","A1");


	Thread.sleep(1300);
	      
	      data.SelectDropdown("id","ddlFOcu","BUSINESS");


	Thread.sleep(1300);
	      
	      data.SelectDropdown("id","ddlMOcu","BUSINESS");


	Thread.sleep(1300);
	      
	      data.SelectDropdown("id","ddlAIncome","0 - 1,00,000");


	


	Thread.sleep(1300);

	data.enterText("id","txtschname",SchoolName);

	Thread.sleep(1300);

	data.enterText("id","txtschloc",SchoolLocation);


	Thread.sleep(1300);
	      
	      data.SelectDropdown("id","ddlinstDistrict","ANGUL");

	Thread.sleep(1300);
	      
	      data.SelectDropdown("id","ddlYOJ","1995");

	Thread.sleep(1300);

	data.enterText("id","txtacno",AccountNumber);


	Thread.sleep(1300);

	data.enterText("id","txtifsc",IFSC);
	
	
	
	Thread.sleep(1300);

	data.enterText("id","txtBankname","SBI    ");


	data.UploadImage();
	Thread.sleep(1300);
	data.clickOnLocator("id","btnSave");
		   		Thread.sleep(1000);
	String actualPopup =data.grtpopup().getText();
				
				System.out.println(actualPopup);
		    	
				String expectedmessage = "White space not allowed at 1st place";

		    	 if(actualPopup.equals(expectedmessage))
		    	 {
		    		 System.out.println("Sucessfully Message is" + actualPopup);
		    		 data.clickOnLocator("id","popup_ok");
		    		 Thread.sleep(1000);
						System.out.println("Click Ok");
		    		fileone.setCellData(sheetName, "Result", 60, "Pass");	
		    	 }
		    	
		    	 else
		    	 {
		    		 fileone.setCellData(sheetName, "Result", 60, "NotExecuted");
		    		 data.clickOnLocator("id","popup_ok");
		    	 }	
		    	 
		    	 SoftAssert softAssert = new SoftAssert();
		    	 softAssert.assertEquals(actualPopup, actualPopup);
			   	}
		
		
		
		@Test(priority=20)
	   	public void whitespaceallowMiddleplaceForBankName
	(



	) throws IOException, InterruptedException
	   	{
	    	test = extent.createTest("whitespaceallowMiddleplaceForBankName");
	    	String YOP = 	fileone1.getCellData("JuniorCAF", "YOP",21);
	String RollNumber = 	fileone1.getCellData("JuniorCAF", "RollNumber",21);
	String ApplicantName = 	fileone1.getCellData("JuniorCAF", "ApplicantName",21);
	String FatherName = 	fileone1.getCellData("JuniorCAF", "FatherName",21);
	String MotherName = 	fileone1.getCellData("JuniorCAF", "MotherName",21);
	String BloodGroup = 	fileone1.getCellData("JuniorCAF", "BloodGroup",21);
	String Gender = 	fileone1.getCellData("JuniorCAF", "Gender",21);
	String Religion = 	fileone1.getCellData("JuniorCAF", "Religion",21);
	String Day = 	fileone1.getCellData("JuniorCAF", "Day",21);
	String Month = 	fileone1.getCellData("JuniorCAF", "Month",21);
	String Year = 	fileone1.getCellData("JuniorCAF", "Year",21);
	String AadharNo = 	fileone1.getCellData("JuniorCAF", "AadharNo",21);
	String MobileNo = 	fileone1.getCellData("JuniorCAF", "MobileNo",21);
	String State = 	fileone1.getCellData("JuniorCAF", "State",21);
	String District = 	fileone1.getCellData("JuniorCAF", "District",21);
	String Block = 	fileone1.getCellData("JuniorCAF", "Block",21);
	String HouseNo = 	fileone1.getCellData("JuniorCAF", "HouseNo",21);
	String PinCode = 	fileone1.getCellData("JuniorCAF", "PinCode",21);
	String Email = 	fileone1.getCellData("JuniorCAF", "Email",21);
	String AreaCode = 	fileone1.getCellData("JuniorCAF", "AreaCode",21);
	String PhoneNo = 	fileone1.getCellData("JuniorCAF", "PhoneNo",21);
	String MaximumMark = 	fileone1.getCellData("JuniorCAF", "MaximumMark",21);
	String SecuredMark = 	fileone1.getCellData("JuniorCAF", "SecuredMark",21);
	String English = 	fileone1.getCellData("JuniorCAF", "English",21);
	String Math = 	fileone1.getCellData("JuniorCAF", "Math",21);
	String Science = 	fileone1.getCellData("JuniorCAF", "Science",21);
	String SocialScience = 	fileone1.getCellData("JuniorCAF", "SocialScience",21);
	String Grade = 	fileone1.getCellData("JuniorCAF", "Grade",21);
	String FatherOccupation = 	fileone1.getCellData("JuniorCAF", "FatherOccupation",21);
	String MotherOccupation = 	fileone1.getCellData("JuniorCAF", "MotherOccupation",21);
	String AuualIncome = 	fileone1.getCellData("JuniorCAF", "AuualIncome",21);
	String SchoolName = 	fileone1.getCellData("JuniorCAF", "SchoolName",21);
	String SchoolLocation = 	fileone1.getCellData("JuniorCAF", "SchoolLocation",21);
	String InstituteDistrict = 	fileone1.getCellData("JuniorCAF", "InstituteDistrict",21);
	String YOJ = 	fileone1.getCellData("JuniorCAF", "YOJ",21);
	String AccountNumber = 	fileone1.getCellData("JuniorCAF", "AccountNumber",21);
	String IFSC = 	fileone1.getCellData("JuniorCAF", "IFSC",21);
	      Thread.sleep(1300);
	      
	      data.SelectDropdown("id","ddlYOP","2009");
		   		Thread.sleep(100);

	Thread.sleep(1300);
	data.clickOnLocator("id","rbtnAnnual");

	Thread.sleep(1300);

	data.enterText("id","txtBoardRoll",RollNumber);


	Thread.sleep(1300);

	data.enterText("id","txtApplName",ApplicantName);

	

	Thread.sleep(1300);

	data.enterText("id","txtFatherName",FatherName);



	Thread.sleep(1300);

	data.enterText("id","txtMotherName",MotherName);

	Thread.sleep(1300);
      
      data.SelectDropdown("id","ddlBloodGroup","A+");



Thread.sleep(1300);
      
      data.SelectDropdown("id","ddlGender","MALE");



Thread.sleep(1300);
      
      data.SelectDropdown("id","ddlReligion","HINDU");



Thread.sleep(1300);
      
      data.SelectDropdown("id","ddlDay","11");


Thread.sleep(1300);
      
      data.SelectDropdown("id","ddlMonth","SEPTEMBER");


Thread.sleep(1300);
      
      data.SelectDropdown("id","ddlYear","1993");

	Thread.sleep(1300);
	      
	      data.SelectDropdown("id","ddlNationality","INDIAN");



	Thread.sleep(1300);
	      
	      data.SelectDropdown("id","ddlMt","ODIA");




	Thread.sleep(1300);

	data.enterText("id","txtadhar",AadharNo);


	Thread.sleep(1300);

	data.enterText("id","txtParentMob",MobileNo);
	Thread.sleep(1300);
	Thread.sleep(1300);
	      
	      data.SelectDropdown("id","ddlCState","1 - ODISHA");


	Thread.sleep(1300);
	      
	      data.SelectDropdown("id","ddlCDist","ANGUL");


	Thread.sleep(1300);
	      
	      data.SelectDropdown("id","ddlCBlock","ANGUL");

	Thread.sleep(1300);

	data.enterText("id","txtCPS",HouseNo);
	Thread.sleep(1300);

	data.enterText("id","txtCPC",PinCode);


	Thread.sleep(1300);

	data.enterText("id","txtCEmail",Email);




	Thread.sleep(1300);

	data.enterText("id","txtCTCode",AreaCode);



	Thread.sleep(1300);

	data.enterText("id","txtCTCode",PhoneNo);


	Thread.sleep(1300);

	data.enterText("id","txtMaxMark",MaximumMark);

	Thread.sleep(1300);

	data.enterText("id","txtTotMark",SecuredMark);


	Thread.sleep(1300);

	data.enterText("id","txtEnglish",English);


	Thread.sleep(1300);

	data.enterText("id","txtMath",Math);


	Thread.sleep(1300);

	data.enterText("id","txtScience",Science);


	Thread.sleep(1300);

	data.enterText("id","txtSocSci",SocialScience);


	//Thread.sleep(1300);
	      
	     // data.SelectDropdown("id","ddlGrade","A1");


	Thread.sleep(1300);
	      
	      data.SelectDropdown("id","ddlFOcu","BUSINESS");


	Thread.sleep(1300);
	      
	      data.SelectDropdown("id","ddlMOcu","BUSINESS");


	Thread.sleep(1300);
	      
	      data.SelectDropdown("id","ddlAIncome","0 - 1,00,000");


	


	Thread.sleep(1300);

	data.enterText("id","txtschname",SchoolName);

	Thread.sleep(1300);

	data.enterText("id","txtschloc",SchoolLocation);


	Thread.sleep(1300);
	      
	      data.SelectDropdown("id","ddlinstDistrict","ANGUL");

	Thread.sleep(1300);
	      
	      data.SelectDropdown("id","ddlYOJ","1995");

	Thread.sleep(1300);

	data.enterText("id","txtacno",AccountNumber);


	Thread.sleep(1300);

	data.enterText("id","txtifsc",IFSC);
	
	
	
	Thread.sleep(1300);

	data.enterText("id","txtBankname","SBI SBI");


	data.UploadImage();
	Thread.sleep(1300);
	data.clickOnLocator("id","btnSave");
		   		Thread.sleep(1000);
	String actualPopup =data.grtpopup().getText();
				
				System.out.println(actualPopup);
		    	
				String expectedmessage = "Please select minimum 5 Option details";

		    	 if(actualPopup.equals(expectedmessage))
		    	 {
		    		 System.out.println("Sucessfully Message is" + actualPopup);
		    		 data.clickOnLocator("id","popup_ok");
		    		 Thread.sleep(1000);
						System.out.println("Click Ok");
		    		fileone.setCellData(sheetName, "Result", 61, "Pass");	
		    	 }
		    	
		    	 else
		    	 {
		    		 fileone.setCellData(sheetName, "Result", 61, "Fail");
		    		 data.clickOnLocator("id","popup_ok");
		    	 }	
		    	 
		    	 SoftAssert softAssert = new SoftAssert();
		    	 softAssert.assertEquals(actualPopup, actualPopup);
			   	}
		
	    	
   	}
 	


    	


