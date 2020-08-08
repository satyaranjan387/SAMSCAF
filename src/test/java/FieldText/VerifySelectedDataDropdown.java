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


public class VerifySelectedDataDropdown extends ExtentReportBase {
	
	
	
		//private static final int j = 0;
		static Xls_AllMethods fileone = new Xls_AllMethods("C:/Users/satyaranjan.m/eclipse-workspace/JuniorForm/JuniorFieldValidationwrite.xlsx");	
		
		 
		 static Xls_AllMethods fileone1 = new Xls_AllMethods("C:/Users/satyaranjan.m/eclipse-workspace/JuniorForm/RoughSheet.xlsx");
		 
		 
		 
		 
		 
		XSSFWorkbook wb;
		XSSFSheet sht;
		String sheetName = "JuniorFieldMapping";
	 int rowCount = fileone.getRowCount(sheetName);

	
//	 static WebDriver driver;
		CommonFunction data = new CommonFunction();

		@Test(priority=1)
		   	public void SelectDataShouldBeDisplayedForBloodGroup
		() throws IOException, InterruptedException
		   	{
		    	test = extent.createTest("SelectDataShouldBeDisplayedForBloodGroup");
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
		data.clickOnLocator("id","btnSave");
			   		Thread.sleep(1000);
		String actualPopup =data.grtpopup().getText();
					
					System.out.println(actualPopup);
			    	
					String expectedmessage = "Please select your Gender !";

			    	 if(actualPopup.equals(expectedmessage))
			    	 {
			    		 System.out.println("Sucessfully Message is" + actualPopup);
			    		 data.clickOnLocator("id","popup_ok");
			    		 Thread.sleep(1000);
							System.out.println("Click Ok");
			    		fileone.setCellData(sheetName, "Result", 324 , "Pass");	
			    	 }
			    	
			    	 else
			    	 {
			    		 fileone.setCellData(sheetName, "Result", 324, "Fail");
			    	 }	
			    	 
			    	 SoftAssert softAssert = new SoftAssert();
			    	 softAssert.assertEquals(actualPopup, actualPopup);
				   	}





		@Test(priority=2)
		   	public void SelectDataShouldBeDisplayedForGender
		(



		) throws IOException, InterruptedException
		   	{
		    	test = extent.createTest("SelectDataShouldBeDisplayedForGender");
		    	String YOP = 	fileone1.getCellData("JuniorCAF", "YOP",21);
		String RollNumber = 	fileone1.getCellData("JuniorCAF", "RollNumber",21);
		String ApplicantName = 	fileone1.getCellData("JuniorCAF", "ApplicantName",21);
		String FatherName = 	fileone1.getCellData("JuniorCAF", "FatherName",21);
		String MotherName = 	fileone1.getCellData("JuniorCAF", "MotherName",21);
		String BloodGroup = 	fileone1.getCellData("JuniorCAF", "BloodGroup",21);
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
		data.clickOnLocator("id","btnSave");
			   		Thread.sleep(1000);
		String actualPopup =data.grtpopup().getText();
					
					System.out.println(actualPopup);
			    	
					String expectedmessage = "Please select your Religion !";

			    	 if(actualPopup.equals(expectedmessage))
			    	 {
			    		 System.out.println("Sucessfully Message is" + actualPopup);
			    		 data.clickOnLocator("id","popup_ok");
			    		 Thread.sleep(1000);
							System.out.println("Click Ok");
			    		fileone.setCellData(sheetName, "Result", 325 , "Pass");	
			    	 }
			    	
			    	 else
			    	 {
			    		 fileone.setCellData(sheetName, "Result", 325, "Fail");
			    	 }	
			    	 
			    	 SoftAssert softAssert = new SoftAssert();
			    	 softAssert.assertEquals(actualPopup, actualPopup);
				   	}







		@Test(priority=3)
		   	public void SelectDataShouldBeDisplayedForReligion
		(



		) throws IOException, InterruptedException
		   	{
		    	test = extent.createTest("SelectDataShouldBeDisplayedForReligion");
		    	String YOP = 	fileone1.getCellData("JuniorCAF", "YOP",21);
		String RollNumber = 	fileone1.getCellData("JuniorCAF", "RollNumber",21);
		String ApplicantName = 	fileone1.getCellData("JuniorCAF", "ApplicantName",21);
		String FatherName = 	fileone1.getCellData("JuniorCAF", "FatherName",21);
		String MotherName = 	fileone1.getCellData("JuniorCAF", "MotherName",21);
		String BloodGroup = 	fileone1.getCellData("JuniorCAF", "BloodGroup",21);
		String Gender = 	fileone1.getCellData("JuniorCAF", "Gender",21);
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
		data.clickOnLocator("id","btnSave");
			   		Thread.sleep(1000);
		String actualPopup =data.grtpopup().getText();
					
					System.out.println(actualPopup);
			    	
					String expectedmessage = "Please select the Day of your Date of Birth !";

			    	 if(actualPopup.equals(expectedmessage))
			    	 {
			    		 System.out.println("Sucessfully Message is" + actualPopup);
			    		 data.clickOnLocator("id","popup_ok");
			    		 Thread.sleep(1000);
							System.out.println("Click Ok");
			    		fileone.setCellData(sheetName, "Result", 326 , "Pass");	
			    	 }
			    	
			    	 else
			    	 {
			    		 fileone.setCellData(sheetName, "Result", 326, "Fail");
			    	 }	
			    	 
			    	 SoftAssert softAssert = new SoftAssert();
			    	 softAssert.assertEquals(actualPopup, actualPopup);
				   	}









		@Test(priority=4)
		   	public void SelectDataShouldBeDisplayedForDay
		(



		) throws IOException, InterruptedException
		   	{
		    	test = extent.createTest("SelectDataShouldBeDisplayedForDay");
		    	String YOP = 	fileone1.getCellData("JuniorCAF", "YOP",21);
		String RollNumber = 	fileone1.getCellData("JuniorCAF", "RollNumber",21);
		String ApplicantName = 	fileone1.getCellData("JuniorCAF", "ApplicantName",21);
		String FatherName = 	fileone1.getCellData("JuniorCAF", "FatherName",21);
		String MotherName = 	fileone1.getCellData("JuniorCAF", "MotherName",21);
		String BloodGroup = 	fileone1.getCellData("JuniorCAF", "BloodGroup",21);
		String Gender = 	fileone1.getCellData("JuniorCAF", "Gender",21);
		String Religion = 	fileone1.getCellData("JuniorCAF", "Religion",21);
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
		data.clickOnLocator("id","btnSave");
			   		Thread.sleep(1000);
		String actualPopup =data.grtpopup().getText();
					
					System.out.println(actualPopup);
			    	
					String expectedmessage = "Please select the Month of your Date of Birth !"; 
							

			    	 if(actualPopup.equals(expectedmessage))
			    	 {
			    		 System.out.println("Sucessfully Message is" + actualPopup);
			    		 data.clickOnLocator("id","popup_ok");
			    		 Thread.sleep(1000);
							System.out.println("Click Ok");
			    		fileone.setCellData(sheetName, "Result", 327 , "Pass");	
			    	 }
			    	
			    	 else
			    	 {
			    		 fileone.setCellData(sheetName, "Result", 327, "Fail");
			    	 }	
			    	 
			    	 SoftAssert softAssert = new SoftAssert();
			    	 softAssert.assertEquals(actualPopup, actualPopup);
				   	}






		@Test(priority=5)
		   	public void SelectDataShouldBeDisplayedForMonth
		(



		) throws IOException, InterruptedException
		   	{
		    	test = extent.createTest("SelectDataShouldBeDisplayedForMonth");
		    	String YOP = 	fileone1.getCellData("JuniorCAF", "YOP",21);
		String RollNumber = 	fileone1.getCellData("JuniorCAF", "RollNumber",21);
		String ApplicantName = 	fileone1.getCellData("JuniorCAF", "ApplicantName",21);
		String FatherName = 	fileone1.getCellData("JuniorCAF", "FatherName",21);
		String MotherName = 	fileone1.getCellData("JuniorCAF", "MotherName",21);
		String BloodGroup = 	fileone1.getCellData("JuniorCAF", "BloodGroup",21);
		String Gender = 	fileone1.getCellData("JuniorCAF", "Gender",21);
		String Religion = 	fileone1.getCellData("JuniorCAF", "Religion",21);
		String Day = 	fileone1.getCellData("JuniorCAF", "Day",21);
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
		data.clickOnLocator("id","btnSave");
			   		Thread.sleep(1000);
		String actualPopup =data.grtpopup().getText();
					
					System.out.println(actualPopup);
			    	
					String expectedmessage = "Please select the Year of your Date of Birth !";

			    	 if(actualPopup.equals(expectedmessage))
			    	 {
			    		 System.out.println("Sucessfully Message is" + actualPopup);
			    		 data.clickOnLocator("id","popup_ok");
			    		 Thread.sleep(1000);
							System.out.println("Click Ok");
			    		fileone.setCellData(sheetName, "Result", 328 , "Pass");	
			    	 }
			    	
			    	 else
			    	 {
			    		 fileone.setCellData(sheetName, "Result", 328, "Fail");
			    	 }	
			    	 
			    	 SoftAssert softAssert = new SoftAssert();
			    	 softAssert.assertEquals(actualPopup, actualPopup);
				   	}






		@Test(priority=5)
		   	public void SelectDataShouldBeDisplayedForYear
		(



		) throws IOException, InterruptedException
		   	{
		    	test = extent.createTest("SelectDataShouldBeDisplayedForYear");
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
		      
		      data.SelectDropdown("id","ddlMonth","1993");
		      
Thread.sleep(1300);
		      
		      data.SelectDropdown("id","ddlYear","1993");
		Thread.sleep(1300);
		data.clickOnLocator("id","btnSave");
			   		Thread.sleep(1000);
		String actualPopup =data.grtpopup().getText();
					
					System.out.println(actualPopup);
			    	
					String expectedmessage = "Parent or Gaurdian Mobile No cannot be left blank !";

			    	 if(actualPopup.equals(expectedmessage))
			    	 {
			    		 System.out.println("Sucessfully Message is" + actualPopup);
			    		 data.clickOnLocator("id","popup_ok");
			    		 Thread.sleep(1000);
							System.out.println("Click Ok");
			    		fileone.setCellData(sheetName, "Result", 329 , "Pass");	
			    	 }
			    	
			    	 else
			    	 {
			    		 fileone.setCellData(sheetName, "Result", 329, "Fail");
			    	 }	
			    	 
			    	 SoftAssert softAssert = new SoftAssert();
			    	 softAssert.assertEquals(actualPopup, actualPopup);
				   	}









		
		@Test(priority=6)
	   	public void whitespacenotallowinitialplaceforApplicantName
	(



	) throws IOException, InterruptedException
	   	{
	    	test = extent.createTest("whitespacenotallowinitialplaceforApplicantName");
	    	String YOP = 	fileone1.getCellData("JuniorCAF", "YOP",21);
	String RollNumber = 	fileone1.getCellData("JuniorCAF", "RollNumber",21);
	      Thread.sleep(1300);
	      
	      data.SelectDropdown("id","ddlYOP","2009");
		   		Thread.sleep(100);

	Thread.sleep(1300);
	data.clickOnLocator("id","rbtnAnnual");

	Thread.sleep(1300);

	data.enterText("id","txtBoardRoll",RollNumber);
	
	
	
	Thread.sleep(1300);

	data.enterText("id","txtApplName","   Milan");

	
	

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
		    		fileone.setCellData(sheetName, "Result", 50 , "Pass");	
		    	 }
		    	
		    	 else
		    	 {
		    		 fileone.setCellData(sheetName, "Result", 50, "Fail");
		    		 data.clickOnLocator("id","popup_ok");
		    	 }	
		    	 
		    	 SoftAssert softAssert = new SoftAssert();
		    	 softAssert.assertEquals(actualPopup, actualPopup);
			   	}



	



		@Test(priority= 7)
	   	public void whitespacenotallowLastplaceforApplicantName
	(



	) throws IOException, InterruptedException
	   	{
	    	test = extent.createTest("whitespacenotallowinitialplaceforApplicantName");
	    	String YOP = 	fileone1.getCellData("JuniorCAF", "YOP",21);
	String RollNumber = 	fileone1.getCellData("JuniorCAF", "RollNumber",21);
	      Thread.sleep(1300);
	      
	      data.SelectDropdown("id","ddlYOP","2009");
		   		Thread.sleep(100);

	Thread.sleep(1300);
	data.clickOnLocator("id","rbtnAnnual");
	
	
	Thread.sleep(1300);

	data.enterText("id","txtBoardRoll",RollNumber);

	Thread.sleep(1300);

	data.enterText("id","txtApplName","Milan    ");


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
		    		fileone.setCellData(sheetName, "Result", 51 , "Pass");	
		    	 }
		    	
		    	 else
		    	 {
		    		 fileone.setCellData(sheetName, "Result", 51, "NotExecuted");
		    		 data.clickOnLocator("id","popup_ok");
		    	 }	
		    	 
		    	 SoftAssert softAssert = new SoftAssert();
		    	 softAssert.assertEquals(actualPopup, actualPopup);
			   	}


	

		

		@Test(priority= 7)
	   	public void whitespaceallowMiddleplaceforApplicantName
	(



	) throws IOException, InterruptedException
	   	{
	    	test = extent.createTest("whitespaceallowMiddleplaceforApplicantName");
	    	String YOP = 	fileone1.getCellData("JuniorCAF", "YOP",21);
	String RollNumber = 	fileone1.getCellData("JuniorCAF", "RollNumber",21);
	      Thread.sleep(1300);
	      
	      data.SelectDropdown("id","ddlYOP","2009");
		   		Thread.sleep(100);

	Thread.sleep(1300);
	data.clickOnLocator("id","rbtnAnnual");

	//Thread.sleep(1300);
	
	



	data.enterText("id","txtApplName","Milan Singh");


	Thread.sleep(1300);
	data.clickOnLocator("id","btnSave");
		   		Thread.sleep(1000);
	String actualPopup =data.grtpopup().getText();
				
				System.out.println(actualPopup);
		    	
				String expectedmessage = "Father's Name cannot be left blank !";

		    	 if(actualPopup.equals(expectedmessage))
		    	 {
		    		 System.out.println("Sucessfully Message is" + actualPopup);
		    		 data.clickOnLocator("id","popup_ok");
		    		 Thread.sleep(1000);
						System.out.println("Click Ok");
		    		fileone.setCellData(sheetName, "Result", 52 , "Pass");	
		    	 }
		    	
		    	 else
		    	 {
		    		 fileone.setCellData(sheetName, "Result", 52, "Fail");
		    		 data.clickOnLocator("id","popup_ok");
		    	 }	
		    	 
		    	 SoftAssert softAssert = new SoftAssert();
		    	 softAssert.assertEquals(actualPopup, actualPopup);
			   	}



		@Test(priority=8)
	   	public void whitespacenotallowinitialplaceforFatherName
	(



	) throws IOException, InterruptedException
	   	{
	    	test = extent.createTest("whitespacenotallowinitialplaceforFatherName");
	    	String YOP = 	fileone1.getCellData("JuniorCAF", "YOP",21);
	String RollNumber = 	fileone1.getCellData("JuniorCAF", "RollNumber",21);
	String ApplicantName = 	fileone1.getCellData("JuniorCAF", "ApplicantName",21);
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

	data.enterText("id","txtFatherName","   Rajendra");


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
		    		fileone.setCellData(sheetName, "Result", 53 , "Pass");	
		    	 }
		    	
		    	 else
		    	 {
		    		 fileone.setCellData(sheetName, "Result", 53, "Fail");
		    	 }	
		    	 
		    	 SoftAssert softAssert = new SoftAssert();
		    	 softAssert.assertEquals(actualPopup, actualPopup);
			   	}
		



		@Test(priority=9)
	   	public void whitespacenotallowLastplaceforFatherName
	(



	) throws IOException, InterruptedException
	   	{
	    	test = extent.createTest("whitespacenotallowLastplaceforFatherName");
	    	String YOP = 	fileone1.getCellData("JuniorCAF", "YOP",21);
	String RollNumber = 	fileone1.getCellData("JuniorCAF", "RollNumber",21);
	String ApplicantName = 	fileone1.getCellData("JuniorCAF", "ApplicantName",21);
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

	data.enterText("id","txtFatherName","Rajendra     ");


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
		    		fileone.setCellData(sheetName, "Result", 54 , "Pass");	
		    	 }
		    	
		    	 else
		    	 {
		    		 fileone.setCellData(sheetName, "Result", 54, "NotExecuted");
		    		 data.clickOnLocator("id","popup_ok");
		    	 }	
		    	 
		    	 SoftAssert softAssert = new SoftAssert();
		    	 softAssert.assertEquals(actualPopup, actualPopup);
			   	}
		

		@Test(priority=10)
	   	public void whitespaceallowMiddleplaceforFatherName
	(



	) throws IOException, InterruptedException
	   	{
	    	test = extent.createTest("whitespaceallowMiddleplaceforFatherName");
	    	String YOP = 	fileone1.getCellData("JuniorCAF", "YOP",21);
	String RollNumber = 	fileone1.getCellData("JuniorCAF", "RollNumber",21);
	String ApplicantName = 	fileone1.getCellData("JuniorCAF", "ApplicantName",21);
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

	data.enterText("id","txtFatherName","Rajendra Kumar Singh");


	Thread.sleep(1300);
	data.clickOnLocator("id","btnSave");
		   		Thread.sleep(1000);
	String actualPopup =data.grtpopup().getText();
				
				System.out.println(actualPopup);
		    	
				String expectedmessage = "Mother's Name cannot be left blank !";

		    	 if(actualPopup.equals(expectedmessage))
		    	 {
		    		 System.out.println("Sucessfully Message is" + actualPopup);
		    		 data.clickOnLocator("id","popup_ok");
		    		 Thread.sleep(1000);
						System.out.println("Click Ok");
		    		fileone.setCellData(sheetName, "Result", 55 , "Pass");	
		    	 }
		    	
		    	 else
		    	 {
		    		 fileone.setCellData(sheetName, "Result", 55, "Fail");
		    	 }	
		    	 
		    	 SoftAssert softAssert = new SoftAssert();
		    	 softAssert.assertEquals(actualPopup, actualPopup);
			   	}
		
		
		
		@Test(priority=11)
	   	public void whtespacenotallowinitialplaceforMotherName
	(



	) throws IOException, InterruptedException
	   	{
	    	test = extent.createTest("whtespacenotallowinitialplaceforMotherName");
	    	String YOP = 	fileone1.getCellData("JuniorCAF", "YOP",21);
	String RollNumber = 	fileone1.getCellData("JuniorCAF", "RollNumber",21);
	String ApplicantName = 	fileone1.getCellData("JuniorCAF", "ApplicantName",21);
	String FatherName = 	fileone1.getCellData("JuniorCAF", "FatherName",21);
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

	data.enterText("id","txtMotherName","   Text");


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
		    		fileone.setCellData(sheetName, "Result", 56 , "Pass");	
		    	 }
		    	
		    	 else
		    	 {
		    		 fileone.setCellData(sheetName, "Result", 56, "Fail");
		    	 }	
		    	 
		    	 SoftAssert softAssert = new SoftAssert();
		    	 softAssert.assertEquals(actualPopup, actualPopup);
			   	}
		
		
		
		@Test(priority=12)
	   	public void whtespacenotallowLastplaceforMotherName
	(



	) throws IOException, InterruptedException
	   	{
	    	test = extent.createTest("whtespacenotallowinitialplaceforMotherName");
	    	String YOP = 	fileone1.getCellData("JuniorCAF", "YOP",21);
	String RollNumber = 	fileone1.getCellData("JuniorCAF", "RollNumber",21);
	String ApplicantName = 	fileone1.getCellData("JuniorCAF", "ApplicantName",21);
	String FatherName = 	fileone1.getCellData("JuniorCAF", "FatherName",21);
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

	data.enterText("id","txtMotherName","Text    ");


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
		    		fileone.setCellData(sheetName, "Result", 57 , "Pass");	
		    	 }
		    	
		    	 else
		    	 {
		    		 fileone.setCellData(sheetName, "Result", 57, "NotExecuted");
		    		 data.clickOnLocator("id","popup_ok");
		    	 }	
		    	 
		    	 SoftAssert softAssert = new SoftAssert();
		    	 softAssert.assertEquals(actualPopup, actualPopup);
			   	}
		
		@Test(priority=13)
	   	public void whtespaceallowMiddleplaceforMotherName
	(



	) throws IOException, InterruptedException
	   	{
	    	test = extent.createTest("whtespaceallowMiddleplaceforMotherName");
	    	String YOP = 	fileone1.getCellData("JuniorCAF", "YOP",21);
	String RollNumber = 	fileone1.getCellData("JuniorCAF", "RollNumber",21);
	String ApplicantName = 	fileone1.getCellData("JuniorCAF", "ApplicantName",21);
	String FatherName = 	fileone1.getCellData("JuniorCAF", "FatherName",21);
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

	data.enterText("id","txtMotherName","Text Text");


	Thread.sleep(1300);
	data.clickOnLocator("id","btnSave");
		   		Thread.sleep(1000);
	String actualPopup =data.grtpopup().getText();
				
				System.out.println(actualPopup);
		    	
				String expectedmessage = "Please select your Gender !";

		    	 if(actualPopup.equals(expectedmessage))
		    	 {
		    		 System.out.println("Sucessfully Message is" + actualPopup);
		    		 data.clickOnLocator("id","popup_ok");
		    		 Thread.sleep(1000);
						System.out.println("Click Ok");
		    		fileone.setCellData(sheetName, "Result", 58 , "Pass");	
		    	 }
		    	
		    	 else
		    	 {
		    		 fileone.setCellData(sheetName, "Result", 58, "Fail");
		    		 data.clickOnLocator("id","popup_ok");
		    	 }	
		    	 
		    	 SoftAssert softAssert = new SoftAssert();
		    	 softAssert.assertEquals(actualPopup, actualPopup);
			   	}
		
		
		
		@Test(priority=14)
	   	public void whitespacenotallowinitialplaceforAddress
	(



	) throws IOException, InterruptedException
	   	{
	    	test = extent.createTest("whitespacenotallowinitialplaceforAddress");
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

	  	data.enterText("id","txtCPS"," Text");


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
		    		fileone.setCellData(sheetName, "Result", 71 , "Pass");	
		    	 }
		    	
		    	 else
		    	 {
		    		 fileone.setCellData(sheetName, "Result", 71, "Fail");
		    	 }	
		    	 
		    	 SoftAssert softAssert = new SoftAssert();
		    	 softAssert.assertEquals(actualPopup,actualPopup);
	   	}
		
		
		
		
		@Test(priority=15)
	   	public void whitespacenotallowLastplaceforAddress
	(



	) throws IOException, InterruptedException
	   	{
	    	test = extent.createTest("whitespacenotallowLastplaceforAddress");
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

	  	data.enterText("id","txtCPS","Text    ");


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
		    		fileone.setCellData(sheetName, "Result", 72 , "Pass");	
		    	 }
		    	
		    	 else
		    	 {
		    		 fileone.setCellData(sheetName, "Result", 72, "NotExecuted");
		    		 data.clickOnLocator("id","popup_ok");
		    	 }	
		    	 
		    	 SoftAssert softAssert = new SoftAssert();
		    	 softAssert.assertEquals(actualPopup,actualPopup);
	   	}
		
		
		
		@Test(priority=16)
	   	public void whitespacenotallowinitialplaceforEmail
	(



	) throws IOException, InterruptedException
	   	{
	    	test = extent.createTest("whitespacenotallowinitialplaceforEmail");
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

	data.enterText("id","txtCEmail","   milansingh234@gmail.com");
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
		    		fileone.setCellData(sheetName, "Result", 73 , "Pass");	
		    	 }
		    	
		    	 else
		    	 {
		    		 fileone.setCellData(sheetName, "Result", 73, "Fail");
		    	 }	
		    	 
		    	 SoftAssert softAssert = new SoftAssert();
		    	 softAssert.assertEquals(actualPopup, actualPopup);
			   	}
		
		
		
		@Test(priority=17)
	   	public void whitespacenotallowLastplaceforEmail
	(



	) throws IOException, InterruptedException
	   	{
	    	test = extent.createTest("whitespacenotallowLastplaceforEmail");
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

	data.enterText("id","txtCEmail","milansingh234@gmail.com     ");
	data.UploadImage();
	Thread.sleep(1300);
	data.clickOnLocator("id","btnSave");
		   		Thread.sleep(1000);
	String actualPopup =data.grtpopup().getText();
				
				System.out.println(actualPopup);
		    	
				String expectedmessage = "Please write a valid e-Mail ID";

		    	 if(actualPopup.equals(expectedmessage))
		    	 {
		    		 System.out.println("Sucessfully Message is" + actualPopup);
		    		 data.clickOnLocator("id","popup_ok");
		    		 Thread.sleep(1000);
						System.out.println("Click Ok");
		    		fileone.setCellData(sheetName, "Result", 74 , "Pass");	
		    	 }
		    	
		    	 else
		    	 {
		    		 fileone.setCellData(sheetName, "Result", 74, "Fail");
		    	 }	
		    	 
		    	 SoftAssert softAssert = new SoftAssert();
		    	 softAssert.assertEquals(actualPopup, actualPopup);
			   	}
		
		
		
		
		
		@Test(priority=18)
	   	public void whitespacenotallowinitialplaceForBankName
	(



	) throws IOException, InterruptedException
	   	{
	    	test = extent.createTest("whitespacenotallowinitialplaceForBankName");
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
		
		
		
		
		
		
		@Test(priority=21)
	   	public void whitespaceNotallowInitialeplaceForBranchName
	(



	) throws IOException, InterruptedException
	   	{
	    	test = extent.createTest("whitespaceNotallowInitialeplaceForBranchName");
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

	data.enterText("id","txtBankname","SBI");
	
	
	
	Thread.sleep(1300);

	data.enterText("id","txtBrname","    BBSR");


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
		    		fileone.setCellData(sheetName, "Result", 62, "Pass");	
		    	 }
		    	
		    	 else
		    	 {
		    		 fileone.setCellData(sheetName, "Result", 62, "Fail");
		    		 data.clickOnLocator("id","popup_ok");
		    	 }	
		    	 
		    	 SoftAssert softAssert = new SoftAssert();
		    	 softAssert.assertEquals(actualPopup, actualPopup);
			   	}
		
		
		
		@Test(priority=22)
	   	public void whitespaceNotallowLasteplaceForBranchName
	(



	) throws IOException, InterruptedException
	   	{
	    	test = extent.createTest("whitespaceNotallowLasteplaceForBranchName");
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

	data.enterText("id","txtBankname","SBI");
	
	
	
	Thread.sleep(1300);

	data.enterText("id","txtBrname","BBSR     ");


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
		    		fileone.setCellData(sheetName, "Result", 63, "Pass");	
		    	 }
		    	
		    	 else
		    	 {
		    		 fileone.setCellData(sheetName, "Result", 63, "Fail");
		    		 data.clickOnLocator("id","popup_ok");
		    	 }	
		    	 
		    	 SoftAssert softAssert = new SoftAssert();
		    	 softAssert.assertEquals(actualPopup, actualPopup);
			   	}
		
		
		
		
		@Test(priority=22)
	   	public void whitespaceallowMiddleeplaceForBranchName
	(



	) throws IOException, InterruptedException
	   	{
	    	test = extent.createTest("whitespaceallowMiddleeplaceForBranchName");
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

	data.enterText("id","txtBankname","SBI");
	
	
	
	Thread.sleep(1300);

	data.enterText("id","txtBrname","BBSR Text");


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
		    		fileone.setCellData(sheetName, "Result", 64, "Pass");	
		    	 }
		    	
		    	 else
		    	 {
		    		 fileone.setCellData(sheetName, "Result", 64, "Fail");
		    		 data.clickOnLocator("id","popup_ok");
		    	 }	
		    	 
		    	 SoftAssert softAssert = new SoftAssert();
		    	 softAssert.assertEquals(actualPopup, actualPopup);
			   	}
		
		
		
		
		
		
		@Test(priority=22)
	   	public void whitespaceNotallowInitialplaceForSchoolName
	(



	) throws IOException, InterruptedException
	   	{
	    	test = extent.createTest("whitespaceNotallowInitialplaceForSchoolName");
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

	data.enterText("id","txtschname","   vsk");

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

	data.enterText("id","txtBankname","SBI");
	
	
	
	Thread.sleep(1300);

	data.enterText("id","txtBrname","BBSR Text");


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
		    		fileone.setCellData(sheetName, "Result", 65, "Pass");	
		    	 }
		    	
		    	 else
		    	 {
		    		 fileone.setCellData(sheetName, "Result", 65, "Fail");
		    		 data.clickOnLocator("id","popup_ok");
		    	 }	
		    	 
		    	 SoftAssert softAssert = new SoftAssert();
		    	 softAssert.assertEquals(actualPopup, actualPopup);
			   	}
		
		
		
		@Test(priority=22)
	   	public void whitespaceNotallowLastplaceForSchoolName
	(



	) throws IOException, InterruptedException
	   	{
	    	test = extent.createTest("whitespaceNotallowLastplaceForSchoolName");
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

	data.enterText("id","txtschname","vsk    ");

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

	data.enterText("id","txtBankname","SBI");
	
	
	
	Thread.sleep(1300);

	data.enterText("id","txtBrname","BBSR Text");


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
		    		fileone.setCellData(sheetName, "Result", 66, "Pass");	
		    	 }
		    	
		    	 else
		    	 {
		    		 fileone.setCellData(sheetName, "Result", 66, "NotExecuted");
		    		 data.clickOnLocator("id","popup_ok");
		    	 }	
		    	 
		    	 SoftAssert softAssert = new SoftAssert();
		    	 softAssert.assertEquals(actualPopup, actualPopup);
			   	}
		
		
		
		
		
		@Test(priority=22)
	   	public void whitespaceallowMiddleplaceForSchoolName
	(



	) throws IOException, InterruptedException
	   	{
	    	test = extent.createTest("whitespaceallowMiddleplaceForSchoolName");
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

	data.enterText("id","txtschname","vs Text");

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

	data.enterText("id","txtBankname","SBI");
	
	
	
	Thread.sleep(1300);

	data.enterText("id","txtBrname","BBSR Text");


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
		    		fileone.setCellData(sheetName, "Result", 67, "Pass");	
		    	 }
		    	
		    	 else
		    	 {
		    		 fileone.setCellData(sheetName, "Result", 67, "Fail");
		    		 data.clickOnLocator("id","popup_ok");
		    	 }	
		    	 
		    	 SoftAssert softAssert = new SoftAssert();
		    	 softAssert.assertEquals(actualPopup, actualPopup);
			   	}
		
		
		
		
		@Test(priority=22)
	   	public void whitespaceallowNotAllowInitialplaceForSchoolLocation
	(



	) throws IOException, InterruptedException
	   	{
	    	test = extent.createTest("whitespaceallowNotAllowInitialplaceForSchoolLocation");
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

	data.enterText("id","txtschname","vs Text");

	Thread.sleep(1300);

	data.enterText("id","txtschloc","   Text");


	Thread.sleep(1300);
	      
	      data.SelectDropdown("id","ddlinstDistrict","ANGUL");

	Thread.sleep(1300);
	      
	      data.SelectDropdown("id","ddlYOJ","1995");

	Thread.sleep(1300);

	data.enterText("id","txtacno",AccountNumber);


	Thread.sleep(1300);

	data.enterText("id","txtifsc",IFSC);
	
	
	
	Thread.sleep(1300);

	data.enterText("id","txtBankname","SBI");
	
	
	
	Thread.sleep(1300);

	data.enterText("id","txtBrname","BBSR Text");


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
		    		fileone.setCellData(sheetName, "Result", 68, "Pass");	
		    	 }
		    	
		    	 else
		    	 {
		    		 fileone.setCellData(sheetName, "Result", 68, "Fail");
		    		 data.clickOnLocator("id","popup_ok");
		    	 }	
		    	 
		    	 SoftAssert softAssert = new SoftAssert();
		    	 softAssert.assertEquals(actualPopup, actualPopup);
			   	}
		
		
		
		@Test(priority=22)
	   	public void whitespaceallowNotAllowLastplaceForSchoolLocation
	(



	) throws IOException, InterruptedException
	   	{
	    	test = extent.createTest("whitespaceallowNotAllowLastplaceForSchoolLocation");
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

	data.enterText("id","txtschname","vs Text");

	Thread.sleep(1300);

	data.enterText("id","txtschloc","Text    ");


	Thread.sleep(1300);
	      
	      data.SelectDropdown("id","ddlinstDistrict","ANGUL");

	Thread.sleep(1300);
	      
	      data.SelectDropdown("id","ddlYOJ","1995");

	Thread.sleep(1300);

	data.enterText("id","txtacno",AccountNumber);


	Thread.sleep(1300);

	data.enterText("id","txtifsc",IFSC);
	
	
	
	Thread.sleep(1300);

	data.enterText("id","txtBankname","SBI");
	
	
	
	Thread.sleep(1300);

	data.enterText("id","txtBrname","BBSR Text");


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
		    		fileone.setCellData(sheetName, "Result", 69, "Pass");	
		    	 }
		    	
		    	 else
		    	 {
		    		 fileone.setCellData(sheetName, "Result", 69, "NotExecuted");
		    		 data.clickOnLocator("id","popup_ok");
		    	 }	
		    	 
		    	 SoftAssert softAssert = new SoftAssert();
		    	 softAssert.assertEquals(actualPopup, actualPopup);
			   	}
		
		
		@Test(priority=23)
	   	public void whitespaceallowMiddleplaceForSchoolLocation
	(



	) throws IOException, InterruptedException
	   	{
	    	test = extent.createTest("whitespaceallowMiddleplaceForSchoolLocation");
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

	data.enterText("id","txtschname","vs Text");

	Thread.sleep(1300);

	data.enterText("id","txtschloc","BBSR Unit-4");


	Thread.sleep(1300);
	      
	      data.SelectDropdown("id","ddlinstDistrict","ANGUL");

	Thread.sleep(1300);
	      
	      data.SelectDropdown("id","ddlYOJ","1995");

	Thread.sleep(1300);

	data.enterText("id","txtacno",AccountNumber);


	Thread.sleep(1300);

	data.enterText("id","txtifsc",IFSC);
	
	
	
	Thread.sleep(1300);

	data.enterText("id","txtBankname","SBI");
	
	
	
	Thread.sleep(1300);

	data.enterText("id","txtBrname","BBSR Text");


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
		    		fileone.setCellData(sheetName, "Result", 70, "Pass");	
		    	 }
		    	
		    	 else
		    	 {
		    		 fileone.setCellData(sheetName, "Result", 70, "Fail");
		    		 data.clickOnLocator("id","popup_ok");
		    	 }	
		    	 
		    	 SoftAssert softAssert = new SoftAssert();
		    	 softAssert.assertEquals(actualPopup, actualPopup);
			   	}
   	}
 	


    	


