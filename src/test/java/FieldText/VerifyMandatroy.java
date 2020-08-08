
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


public class VerifyMandatroy extends ExtentReportBase {
	
	
	
		//private static final int j = 0;
		static Xls_AllMethods fileone = new Xls_AllMethods("C:/Users/satyaranjan.m/eclipse-workspace/JuniorForm/JuniorFieldValidationwrite.xlsx");	
		
		 
		 static Xls_AllMethods fileone1 = new Xls_AllMethods("C:/Users/satyaranjan.m/eclipse-workspace/JuniorForm/RoughSheet.xlsx");
		 
		 
		 
		 
		 
		XSSFWorkbook wb;
		XSSFSheet sht;
		String sheetName = "JuniorFieldMapping";
	 int rowCount = fileone.getRowCount(sheetName);

	 
	// static WebDriver driver;
		CommonFunction data = new CommonFunction();
		
		
		
		@Test(priority=0)
	   	public void CheckMandatoryForYearOfPassing
	(

			

	) throws IOException, InterruptedException
	   	{
	    	test = extent.createTest("CheckMandatoryForRollNumber");
	    	String YOP = 	fileone1.getCellData("JuniorCAF", "YOP",21);

	      Thread.sleep(700);
	      
	     
	data.clickOnLocator("id","rbtnAnnual");

	data.SelectDropdown("id", "ddlYOP", "--SELECT--");


	Thread.sleep(700);
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
		    		fileone.setCellData(sheetName, "Result", 2 , "Pass");	
		    	 }
		    	
		    	 else
		    	 {
		    		 fileone.setCellData(sheetName, "Result", 2, "Fail");
		    	 }	
		    	 
		    	 SoftAssert softAssert = new SoftAssert();
		    	 softAssert.assertEquals(actualPopup, actualPopup);
			   	}

		@Test(priority=1)
		   	public void CheckMandatoryForRollNumber
		() throws IOException, InterruptedException
		   	{
		    	test = extent.createTest("CheckMandatoryForRollNumber");
		    	data.openBrowser("chrome");
				Thread.sleep(500);
				
				data.openUrl("http://o.samsodisha.gov.in/");
				
				Thread.sleep(500);
				data.LoginPage();
				
				
				
				Thread.sleep(1500);
				
				data.Navigation();
		    	String YOP = 	fileone1.getCellData("JuniorCAF", "YOP",21);

		      Thread.sleep(1300);
		      
		      data.SelectDropdown("id","ddlYOP","2009");
			   		Thread.sleep(100);

		Thread.sleep(1300);
		data.clickOnLocator("id","rbtnAnnual");




		Thread.sleep(1300);
		data.clickOnLocator("id","btnSave");
			   		Thread.sleep(1000);
		String actualPopup =data.grtpopup().getText();
					
					System.out.println(actualPopup);
			    	
					String expectedmessage = "Roll Number cannot be left blank !";

			    	 if(actualPopup.equals(expectedmessage))
			    	 {
			    		 System.out.println("Sucessfully Message is" + actualPopup);
			    		 data.clickOnLocator("id","popup_ok");
			    		 Thread.sleep(1000);
							System.out.println("Click Ok");
			    		fileone.setCellData(sheetName, "Result", 3 , "Pass");	
			    	 }
			    	
			    	 else
			    	 {
			    		 fileone.setCellData(sheetName, "Result", 3, "Fail");
			    	 }	
			    	 
			    	 SoftAssert softAssert = new SoftAssert();
			    	 softAssert.assertEquals(actualPopup, actualPopup);
				   	}










		@Test(priority=2)
		   	public void CheckMandatoryForApplicantName
		(



		) throws IOException, InterruptedException
		   	{
		    	test = extent.createTest("CheckMandatoryForApplicantName");
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
		data.clickOnLocator("id","btnSave");
			   		Thread.sleep(1000);
		String actualPopup =data.grtpopup().getText();
					
					System.out.println(actualPopup);
			    	
					String expectedmessage = "Applicant's Name cannot be left blank !";

			    	 if(actualPopup.equals(expectedmessage))
			    	 {
			    		 System.out.println("Sucessfully Message is" + actualPopup);
			    		 data.clickOnLocator("id","popup_ok");
			    		 Thread.sleep(1000);
							System.out.println("Click Ok");
			    		fileone.setCellData(sheetName, "Result", 4 , "Pass");	
			    	 }
			    	
			    	 else
			    	 {
			    		 fileone.setCellData(sheetName, "Result", 4, "Fail");
			    	 }	
			    	 
			    	 SoftAssert softAssert = new SoftAssert();
			    	 softAssert.assertEquals(actualPopup, actualPopup);
				   	}








		@Test(priority=3)
		   	public void CheckMandatoryForFatherName
		(



		) throws IOException, InterruptedException
		   	{
		    	test = extent.createTest("CheckMandatoryForFatherName");
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
			    		fileone.setCellData(sheetName, "Result", 5 , "Pass");	
			    	 }
			    	
			    	 else
			    	 {
			    		 fileone.setCellData(sheetName, "Result", 5, "Fail");
			    	 }	
			    	 
			    	 SoftAssert softAssert = new SoftAssert();
			    	 softAssert.assertEquals(actualPopup, actualPopup);
				   	}










		@Test(priority=4)
		   	public void CheckMandatoryForMotherName
		(



		) throws IOException, InterruptedException
		   	{
		    	test = extent.createTest("CheckMandatoryForMotherName");
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
			    		fileone.setCellData(sheetName, "Result", 6 , "Pass");	
			    	 }
			    	
			    	 else
			    	 {
			    		 fileone.setCellData(sheetName, "Result", 6, "Fail");
			    	 }	
			    	 
			    	 SoftAssert softAssert = new SoftAssert();
			    	 softAssert.assertEquals(actualPopup, actualPopup);
				   	}







		@Test(priority=5)
		   	public void CheckNonMandatoryForBloodGroup
		(



		) throws IOException, InterruptedException
		   	{
		    	test = extent.createTest("CheckNonMandatoryForBloodGroup");
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
			    		fileone.setCellData(sheetName, "Result", 7 , "Pass");	
			    	 }
			    	
			    	 else
			    	 {
			    		 fileone.setCellData(sheetName, "Result", 7, "Fail");
			    	 }	
			    	 
			    	 SoftAssert softAssert = new SoftAssert();
			    	 softAssert.assertEquals(actualPopup, actualPopup);
				   	}





		@Test(priority=6)
		   	public void CheckMandatoryForGender
		(



		) throws IOException, InterruptedException
		   	{
		    	test = extent.createTest("CheckMandatoryForGender");
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
			    		fileone.setCellData(sheetName, "Result", 8 , "Pass");	
			    	 }
			    	
			    	 else
			    	 {
			    		 fileone.setCellData(sheetName, "Result", 8, "Fail");
			    	 }	
			    	 
			    	 SoftAssert softAssert = new SoftAssert();
			    	 softAssert.assertEquals(actualPopup, actualPopup);
				   	}







		@Test(priority=7)
		   	public void CheckMandatoryForReligion
		(



		) throws IOException, InterruptedException
		   	{
		    	test = extent.createTest("CheckMandatoryForReligion");
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
			    		fileone.setCellData(sheetName, "Result", 9 , "Pass");	
			    	 }
			    	
			    	 else
			    	 {
			    		 fileone.setCellData(sheetName, "Result", 9, "Fail");
			    	 }	
			    	 
			    	 SoftAssert softAssert = new SoftAssert();
			    	 softAssert.assertEquals(actualPopup, actualPopup);
				   	}









		@Test(priority=8)
		   	public void CheckMandatoryForDay
		(



		) throws IOException, InterruptedException
		   	{
		    	test = extent.createTest("CheckMandatoryForDay");
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
			    		fileone.setCellData(sheetName, "Result", 10 , "Pass");	
			    	 }
			    	
			    	 else
			    	 {
			    		 fileone.setCellData(sheetName, "Result", 10, "Fail");
			    	 }	
			    	 
			    	 SoftAssert softAssert = new SoftAssert();
			    	 softAssert.assertEquals(actualPopup, actualPopup);
				   	}






		@Test(priority=9)
		   	public void CheckMandatoryForMonth
		(



		) throws IOException, InterruptedException
		   	{
		    	test = extent.createTest("CheckMandatoryForMonth");
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
			    		fileone.setCellData(sheetName, "Result", 11 , "Pass");	
			    	 }
			    	
			    	 else
			    	 {
			    		 fileone.setCellData(sheetName, "Result", 11, "Fail");
			    	 }	
			    	 
			    	 SoftAssert softAssert = new SoftAssert();
			    	 softAssert.assertEquals(actualPopup, actualPopup);
				   	}






		@Test(priority=10)
		   	public void CheckMandatoryForYear
		(



		) throws IOException, InterruptedException
		   	{
		    	test = extent.createTest("CheckMandatoryForYear");
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
			    		fileone.setCellData(sheetName, "Result", 12 , "Pass");	
			    	 }
			    	
			    	 else
			    	 {
			    		 fileone.setCellData(sheetName, "Result", 12, "Fail");
			    	 }	
			    	 
			    	 SoftAssert softAssert = new SoftAssert();
			    	 softAssert.assertEquals(actualPopup, actualPopup);
				   	}









		@Test(priority=11)
		   	public void CheckMandatoryForNationality
		(



		) throws IOException, InterruptedException
		   	{
		    	test = extent.createTest("CheckMandatoryForNationality");
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
		      
		      data.SelectDropdown("id","ddlNationality","--SELECT--");
		Thread.sleep(1300);
		data.clickOnLocator("id","btnSave");
			   		Thread.sleep(1000);
		String actualPopup =data.grtpopup().getText();
					
					System.out.println(actualPopup);
			    	
					String expectedmessage = "Please select Nationality !";

			    	 if(actualPopup.equals(expectedmessage))
			    	 {
			    		 System.out.println("Sucessfully Message is" + actualPopup);
			    		 data.clickOnLocator("id","popup_ok");
			    		 Thread.sleep(1000);
							System.out.println("Click Ok");
			    		fileone.setCellData(sheetName, "Result", 13 , "Pass");	
			    	 }
			    	
			    	 else
			    	 {
			    		 fileone.setCellData(sheetName, "Result", 13, "Fail");
			    	 }	
			    	 
			    	 SoftAssert softAssert = new SoftAssert();
			    	 softAssert.assertEquals(actualPopup, actualPopup);
				   	}









		@Test(priority=12)
		   	public void CheckMandatoryForMotherTongue
		(



		) throws IOException, InterruptedException
		   	{
		    	test = extent.createTest("CheckMandatoryForMotherTongue");
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
		      
		      data.SelectDropdown("id","ddlMt","--SELECT");
		Thread.sleep(1300);
		data.clickOnLocator("id","btnSave");
			   		Thread.sleep(1000);
		String actualPopup =data.grtpopup().getText();
					
					System.out.println(actualPopup);
			    	
					String expectedmessage = "Please select Mother Tongue !";

			    	 if(actualPopup.equals(expectedmessage))
			    	 {
			    		 System.out.println("Sucessfully Message is" + actualPopup);
			    		 data.clickOnLocator("id","popup_ok");
			    		 Thread.sleep(1000);
							System.out.println("Click Ok");
			    		fileone.setCellData(sheetName, "Result", 14 , "Pass");	
			    	 }
			    	
			    	 else
			    	 {
			    		 fileone.setCellData(sheetName, "Result", 14, "Fail");
			    	 }	
			    	 
			    	 SoftAssert softAssert = new SoftAssert();
			    	 softAssert.assertEquals(actualPopup, actualPopup);
				   	}






		@Test(priority=13)
		   	public void CheckNonMandatoryForAadharNumber
		(



		) throws IOException, InterruptedException
		   	{
		    	test = extent.createTest("CheckNonMandatoryForAadharNumber");
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
			    		fileone.setCellData(sheetName, "Result", 15 , "Pass");	
			    	 }
			    	
			    	 else
			    	 {
			    		 fileone.setCellData(sheetName, "Result", 15, "Fail");
			    	 }	
			    	 
			    	 SoftAssert softAssert = new SoftAssert();
			    	 softAssert.assertEquals(actualPopup, actualPopup);
				   	}





		@Test(priority=14)
		   	public void CheckMandatoryForMobileNumber
		(



		) throws IOException, InterruptedException
		   	{
		    	test = extent.createTest("CheckMandatoryForMobileNumber");
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
			    		fileone.setCellData(sheetName, "Result", 16 , "Pass");	
			    	 }
			    	
			    	 else
			    	 {
			    		 fileone.setCellData(sheetName, "Result", 16, "Fail");
			    	 }	
			    	 
			    	 SoftAssert softAssert = new SoftAssert();
			    	 softAssert.assertEquals(actualPopup, actualPopup);
				   	}






		@Test(priority=15)
		   	public void CheckMandatoryForState
		(



		) throws IOException, InterruptedException
		   	{
		    	test = extent.createTest("CheckMandatoryForState");
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



		data.UploadImage();
		Thread.sleep(1300);
		data.clickOnLocator("id","btnSave");
			   		Thread.sleep(1000);
		String actualPopup =data.grtpopup().getText();
					
					System.out.println(actualPopup);
			    	
					String expectedmessage = "Please select State !";

			    	 if(actualPopup.equals(expectedmessage))
			    	 {
			    		 System.out.println("Sucessfully Message is" + actualPopup);
			    		 data.clickOnLocator("id","popup_ok");
			    		 Thread.sleep(1000);
							System.out.println("Click Ok");
			    		fileone.setCellData(sheetName, "Result", 17 , "Pass");	
			    	 }
			    	
			    	 else
			    	 {
			    		 fileone.setCellData(sheetName, "Result", 17, "Fail");
			    	 }	
			    	 
			    	 SoftAssert softAssert = new SoftAssert();
			    	 softAssert.assertEquals(actualPopup, actualPopup);
				   	}








		@Test(priority=16)
		   	public void CheckMandatoryForDistrict
		(



		) throws IOException, InterruptedException
		   	{
		    	test = extent.createTest("CheckMandatoryForDistrict");
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


		data.UploadImage();
		Thread.sleep(1300);
		data.clickOnLocator("id","btnSave");
			   		Thread.sleep(1000);
		String actualPopup =data.grtpopup().getText();
					
					System.out.println(actualPopup);
			    	
					String expectedmessage = "Please select District !";

			    	 if(actualPopup.equals(expectedmessage))
			    	 {
			    		 System.out.println("Sucessfully Message is" + actualPopup);
			    		 data.clickOnLocator("id","popup_ok");
			    		 Thread.sleep(1000);
							System.out.println("Click Ok");
			    		fileone.setCellData(sheetName, "Result", 18 , "Pass");	
			    	 }
			    	
			    	 else
			    	 {
			    		 fileone.setCellData(sheetName, "Result", 18, "Fail");
			    	 }	
			    	 
			    	 SoftAssert softAssert = new SoftAssert();
			    	 softAssert.assertEquals(actualPopup, actualPopup);
				   	}







		@Test(priority=17)
		   	public void CheckMandatoryForBlock
		(



		) throws IOException, InterruptedException
		   	{
		    	test = extent.createTest("CheckMandatoryForBlock");
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


		data.UploadImage();
		Thread.sleep(1300);
		data.clickOnLocator("id","btnSave");
			   		Thread.sleep(1000);
		String actualPopup =data.grtpopup().getText();
					
					System.out.println(actualPopup);
			    	
					String expectedmessage = "Please select Block/ULB !";

			    	 if(actualPopup.equals(expectedmessage))
			    	 {
			    		 System.out.println("Sucessfully Message is" + actualPopup);
			    		 data.clickOnLocator("id","popup_ok");
			    		 Thread.sleep(1000);
							System.out.println("Click Ok");
			    		fileone.setCellData(sheetName, "Result", 19 , "Pass");	
			    	 }
			    	
			    	 else
			    	 {
			    		 fileone.setCellData(sheetName, "Result", 19, "Fail");
			    	 }	
			    	 
			    	 SoftAssert softAssert = new SoftAssert();
			    	 softAssert.assertEquals(actualPopup, actualPopup);
				   	}





		@Test(priority=18)
		   	public void CheckMandatoryForHouseNo
		(



		) throws IOException, InterruptedException
		   	{
		    	test = extent.createTest("CheckMandatoryForHouseNo");
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


		data.UploadImage();
		Thread.sleep(1300);
		data.clickOnLocator("id","btnSave");
			   		Thread.sleep(1000);
		String actualPopup =data.grtpopup().getText();
					
					System.out.println(actualPopup);
			    	
					String expectedmessage = "House No., Street/Village, Post Office, Police Station Name cannot be left blank !";

			    	 if(actualPopup.equals(expectedmessage))
			    	 {
			    		 System.out.println("Sucessfully Message is" + actualPopup);
			    		 data.clickOnLocator("id","popup_ok");
			    		 Thread.sleep(1000);
							System.out.println("Click Ok");
			    		fileone.setCellData(sheetName, "Result", 20 , "Pass");	
			    	 }
			    	
			    	 else
			    	 {
			    		 fileone.setCellData(sheetName, "Result", 20, "Fail");
			    	 }	
			    	 
			    	 SoftAssert softAssert = new SoftAssert();
			    	 softAssert.assertEquals(actualPopup, actualPopup);
				   	}




		@Test(priority=19)
		   	public void CheckNonMandatoryForPinCode
		(



		) throws IOException, InterruptedException
		   	{
		    	test = extent.createTest("CheckNonMandatoryForPinCode");
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
		data.UploadImage();
		Thread.sleep(1300);
		data.clickOnLocator("id","btnSave");
			   		Thread.sleep(1000);
		String actualPopup =data.grtpopup().getText();
					
					System.out.println(actualPopup);
			    	
					String expectedmessage = "English Mark cannot be left blank !";

			    	 if(actualPopup.equals(expectedmessage))
			    	 {
			    		 System.out.println("Sucessfully Message is" + actualPopup);
			    		 data.clickOnLocator("id","popup_ok");
			    		 Thread.sleep(1000);
							System.out.println("Click Ok");
			    		fileone.setCellData(sheetName, "Result", 21 , "Pass");	
			    	 }
			    	
			    	 else
			    	 {
			    		 fileone.setCellData(sheetName, "Result", 21, "Fail");
			    	 }	
			    	 
			    	 SoftAssert softAssert = new SoftAssert();
			    	 softAssert.assertEquals(actualPopup, actualPopup);
				   	}






		@Test(priority=20)
		   	public void CheckNonMandatoryForEmail
		(



		) throws IOException, InterruptedException
		   	{
		    	test = extent.createTest("CheckNonMandatoryForEmail");
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
		data.UploadImage();
		Thread.sleep(1300);
		data.clickOnLocator("id","btnSave");
			   		Thread.sleep(1000);
		String actualPopup =data.grtpopup().getText();
					
					System.out.println(actualPopup);
			    	
					String expectedmessage = "English Mark cannot be left blank !";

			    	 if(actualPopup.equals(expectedmessage))
			    	 {
			    		 System.out.println("Sucessfully Message is" + actualPopup);
			    		 data.clickOnLocator("id","popup_ok");
			    		 Thread.sleep(1000);
							System.out.println("Click Ok");
			    		fileone.setCellData(sheetName, "Result", 22 , "Pass");	
			    	 }
			    	
			    	 else
			    	 {
			    		 fileone.setCellData(sheetName, "Result", 22, "Fail");
			    	 }	
			    	 
			    	 SoftAssert softAssert = new SoftAssert();
			    	 softAssert.assertEquals(actualPopup, actualPopup);
				   	}






		@Test(priority=21)
		   	public void CheckNonMandatoryForAreaCode
		(



		) throws IOException, InterruptedException
		   	{
		    	test = extent.createTest("CheckNonMandatoryForAreaCode");
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
		data.UploadImage();
		Thread.sleep(1300);
		data.clickOnLocator("id","btnSave");
			   		Thread.sleep(1000);
		String actualPopup =data.grtpopup().getText();
					
					System.out.println(actualPopup);
			    	
					String expectedmessage = "English Mark cannot be left blank !";

			    	 if(actualPopup.equals(expectedmessage))
			    	 {
			    		 System.out.println("Sucessfully Message is" + actualPopup);
			    		 data.clickOnLocator("id","popup_ok");
			    		 Thread.sleep(1000);
							System.out.println("Click Ok");
			    		fileone.setCellData(sheetName, "Result", 23 , "Pass");	
			    	 }
			    	
			    	 else
			    	 {
			    		 fileone.setCellData(sheetName, "Result", 23, "Fail");
			    	 }	
			    	 
			    	 SoftAssert softAssert = new SoftAssert();
			    	 softAssert.assertEquals(actualPopup, actualPopup);
				   	}




		@Test(priority=22)
		   	public void CheckNonMandatoryForPhoneNo
		(



		) throws IOException, InterruptedException
		   	{
		    	test = extent.createTest("CheckNonMandatoryForPhoneNo");
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
		data.UploadImage();
		Thread.sleep(1300);
		data.clickOnLocator("id","btnSave");
			   		Thread.sleep(1000);
		String actualPopup =data.grtpopup().getText();
					
					System.out.println(actualPopup);
			    	
					String expectedmessage = "English Mark cannot be left blank !";

			    	 if(actualPopup.equals(expectedmessage))
			    	 {
			    		 System.out.println("Sucessfully Message is" + actualPopup);
			    		 data.clickOnLocator("id","popup_ok");
			    		 Thread.sleep(1000);
							System.out.println("Click Ok");
			    		fileone.setCellData(sheetName, "Result", 24 , "Pass");	
			    	 }
			    	
			    	 else
			    	 {
			    		 fileone.setCellData(sheetName, "Result", 24, "Fail");
			    	 }	
			    	 
			    	 SoftAssert softAssert = new SoftAssert();
			    	 softAssert.assertEquals(actualPopup, actualPopup);
				   	}






		@Test(priority=23)
	   	public void CheckMandatoryForMaximumMark
	(



	) throws IOException, InterruptedException
	   	{
	    	test = extent.createTest("CheckMandatoryForMaximumMark");
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
	
	
	String SecuredMark = 	fileone1.getCellData("JuniorCAF", "SecuredMark",21);
	String English = 	fileone1.getCellData("JuniorCAF", "English",21);
	String Math = 	fileone1.getCellData("JuniorCAF", "Math",21);
	String Science = 	fileone1.getCellData("JuniorCAF", "Science",21);
	String SocialScience = 	fileone1.getCellData("JuniorCAF", "SocialScience",21);
	      Thread.sleep(700);
	      
	      data.SelectDropdown("id","ddlYOP","2009");
		   		Thread.sleep(100);

	Thread.sleep(700);
	data.clickOnLocator("id","rbtnAnnual");

	Thread.sleep(700);

	data.enterText("id","txtBoardRoll",RollNumber);


	Thread.sleep(700);

	data.enterText("id","txtApplName",ApplicantName);



	Thread.sleep(700);

	data.enterText("id","txtFatherName",FatherName);



	Thread.sleep(700);

	data.enterText("id","txtMotherName",MotherName);

	Thread.sleep(700);
      
      data.SelectDropdown("id","ddlBloodGroup","A+");



Thread.sleep(700);
      
      data.SelectDropdown("id","ddlGender","MALE");



Thread.sleep(700);
      
      data.SelectDropdown("id","ddlReligion","HINDU");



Thread.sleep(700);
      
      data.SelectDropdown("id","ddlDay","11");


Thread.sleep(700);
      
      data.SelectDropdown("id","ddlMonth","SEPTEMBER");


Thread.sleep(700);
      
      data.SelectDropdown("id","ddlYear","1993");

	Thread.sleep(700);
	      
	      data.SelectDropdown("id","ddlNationality","INDIAN");



	Thread.sleep(700);
	      
	      data.SelectDropdown("id","ddlMt","ODIA");




	Thread.sleep(700);

	data.enterText("id","txtadhar",AadharNo);


	Thread.sleep(700);

	data.enterText("id","txtParentMob",MobileNo);
	Thread.sleep(700);
	Thread.sleep(700);
	      
	      data.SelectDropdown("id","ddlCState","1 - ODISHA");


	Thread.sleep(700);
	      
	      data.SelectDropdown("id","ddlCDist","ANGUL");


	Thread.sleep(700);
	      
	      data.SelectDropdown("id","ddlCBlock","ANGUL");

	Thread.sleep(700);

	data.enterText("id","txtCPS",HouseNo);
	Thread.sleep(700);

	data.enterText("id","txtCPC",PinCode);


	Thread.sleep(700);

	data.enterText("id","txtCEmail",Email);




	Thread.sleep(700);

	data.enterText("id","txtCTCode",AreaCode);



	Thread.sleep(700);

	data.enterText("id","txtCTCode",PhoneNo);
	
	
	
	Thread.sleep(700);

	data.enterText("id","txtTotMark",SecuredMark);


	Thread.sleep(700);

	data.enterText("id","txtEnglish",English);


	Thread.sleep(700);

	data.enterText("id","txtMath",Math);


	Thread.sleep(700);

	data.enterText("id","txtScience",Science);


	Thread.sleep(700);

	data.enterText("id","txtSocSci",SocialScience);




	data.UploadImage();
	Thread.sleep(700);
	data.clickOnLocator("id","btnSave");
		   		Thread.sleep(1000);
	String actualPopup =data.grtpopup().getText();
				
				System.out.println(actualPopup);
		    	
				String expectedmessage = "Maximum Mark cannot be left blank !";

		    	 if(actualPopup.equals(expectedmessage))
		    	 {
		    		 System.out.println("Sucessfully Message is" + actualPopup);
		    		 data.clickOnLocator("id","popup_ok");
		    		 Thread.sleep(1000);
						System.out.println("Click Ok");
		    		fileone.setCellData(sheetName, "Result", 25 , "Pass");	
		    	 }
		    	
		    	 else
		    	 {
		    		 fileone.setCellData(sheetName, "Result", 25, "Fail");
		    		 data.clickOnLocator("id","popup_ok");
		    	 }	
		    	 
		    	 SoftAssert softAssert = new SoftAssert();
		    	 softAssert.assertEquals(actualPopup, actualPopup);
			   	}





	@Test(priority=24)
	   	public void CheckMandatoryForSecuredMark
	(



	) throws IOException, InterruptedException
	   	{
	    	test = extent.createTest("CheckMandatoryForSecuredMark");
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
	      Thread.sleep(700);
	      
	      data.SelectDropdown("id","ddlYOP","2009");
		   		Thread.sleep(100);

	Thread.sleep(700);
	data.clickOnLocator("id","rbtnAnnual");

	Thread.sleep(700);

	data.enterText("id","txtBoardRoll",RollNumber);


	Thread.sleep(700);

	data.enterText("id","txtApplName",ApplicantName);



	Thread.sleep(700);

	data.enterText("id","txtFatherName",FatherName);



	Thread.sleep(700);

	data.enterText("id","txtMotherName",MotherName);

	Thread.sleep(700);
      
      data.SelectDropdown("id","ddlBloodGroup","A+");



Thread.sleep(700);
      
      data.SelectDropdown("id","ddlGender","MALE");



Thread.sleep(700);
      
      data.SelectDropdown("id","ddlReligion","HINDU");



Thread.sleep(700);
      
      data.SelectDropdown("id","ddlDay","11");


Thread.sleep(700);
      
      data.SelectDropdown("id","ddlMonth","SEPTEMBER");


Thread.sleep(700);
      
      data.SelectDropdown("id","ddlYear","1993");

	Thread.sleep(700);
	      
	      data.SelectDropdown("id","ddlNationality","INDIAN");



	Thread.sleep(700);
	      
	      data.SelectDropdown("id","ddlMt","ODIA");




	Thread.sleep(700);

	data.enterText("id","txtadhar",AadharNo);


	Thread.sleep(700);

	data.enterText("id","txtParentMob",MobileNo);
	Thread.sleep(700);
	Thread.sleep(700);
	      
	      data.SelectDropdown("id","ddlCState","1 - ODISHA");


	Thread.sleep(700);
	      
	      data.SelectDropdown("id","ddlCDist","ANGUL");


	Thread.sleep(700);
	      
	      data.SelectDropdown("id","ddlCBlock","ANGUL");

	Thread.sleep(700);

	data.enterText("id","txtCPS",HouseNo);
	Thread.sleep(700);

	data.enterText("id","txtCPC",PinCode);


	Thread.sleep(700);

	data.enterText("id","txtCEmail",Email);




	Thread.sleep(700);

	data.enterText("id","txtCTCode",AreaCode);



	Thread.sleep(700);

	data.enterText("id","txtCTCode",PhoneNo);


	Thread.sleep(700);

	data.enterText("id","txtMaxMark",MaximumMark);
	
	
	
	Thread.sleep(700);

	data.enterText("id","txtEnglish",English);


	Thread.sleep(700);

	data.enterText("id","txtMath",Math);


	Thread.sleep(700);

	data.enterText("id","txtScience",Science);


	Thread.sleep(700);

	data.enterText("id","txtSocSci",SocialScience);

	data.UploadImage();
	Thread.sleep(700);
	data.clickOnLocator("id","btnSave");
		   		Thread.sleep(1000);
	String actualPopup =data.grtpopup().getText();
				
				System.out.println(actualPopup);
		    	
				String expectedmessage = "Total Mark cannot be left blank !";

		    	 if(actualPopup.equals(expectedmessage))
		    	 {
		    		 System.out.println("Sucessfully Message is" + actualPopup);
		    		 data.clickOnLocator("id","popup_ok");
		    		 Thread.sleep(1000);
						System.out.println("Click Ok");
		    		fileone.setCellData(sheetName, "Result", 26 , "Pass");	
		    	 }
		    	
		    	 else
		    	 {
		    		 fileone.setCellData(sheetName, "Result", 26, "Fail");
		    		 data.clickOnLocator("id","popup_ok");
		    	 }	
		    	 
		    	 SoftAssert softAssert = new SoftAssert();
		    	 softAssert.assertEquals(actualPopup, actualPopup);
			   	}







		@Test(priority=25)
		   	public void CheckMandatoryForEnglish
		(



		) throws IOException, InterruptedException
		   	{
		    	test = extent.createTest("CheckMandatoryForEnglish");
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

		data.enterText("id","txtCTeleNo",PhoneNo);


		Thread.sleep(1300);

		data.enterText("id","txtMaxMark",MaximumMark);

		Thread.sleep(1300);

		data.enterText("id","txtTotMark",SecuredMark);

		data.UploadImage();
		Thread.sleep(1300);
		data.clickOnLocator("id","btnSave");
			   		Thread.sleep(1000);
		String actualPopup =data.grtpopup().getText();
					
					System.out.println(actualPopup);
			    	
					String expectedmessage = "English Mark cannot be left blank !";

			    	 if(actualPopup.equals(expectedmessage))
			    	 {
			    		 System.out.println("Sucessfully Message is" + actualPopup);
			    		 data.clickOnLocator("id","popup_ok");
			    		 Thread.sleep(1000);
							System.out.println("Click Ok");
			    		fileone.setCellData(sheetName, "Result", 27 , "Pass");	
			    	 }
			    	
			    	 else
			    	 {
			    		 fileone.setCellData(sheetName, "Result", 27, "Fail");
			    	 }	
			    	 
			    	 SoftAssert softAssert = new SoftAssert();
			    	 softAssert.assertEquals(actualPopup, actualPopup);
				   	}






		@Test(priority=26)
		   	public void CheckMandatoryForMath
		(



		) throws IOException, InterruptedException
		   	{
		    	test = extent.createTest("CheckMandatoryForMath");
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

		data.enterText("id","txtCTeleNo",PhoneNo);


		Thread.sleep(1300);

		data.enterText("id","txtMaxMark",MaximumMark);

		Thread.sleep(1300);

		data.enterText("id","txtTotMark",SecuredMark);


		Thread.sleep(1300);

		data.enterText("id","txtEnglish",English);

		data.UploadImage();
		Thread.sleep(1300);
		data.clickOnLocator("id","btnSave");
			   		Thread.sleep(1000);
		String actualPopup =data.grtpopup().getText();
					
					System.out.println(actualPopup);
			    	
					String expectedmessage = "Mathematics Mark cannot be left blank !";

			    	 if(actualPopup.equals(expectedmessage))
			    	 {
			    		 System.out.println("Sucessfully Message is" + actualPopup);
			    		 data.clickOnLocator("id","popup_ok");
			    		 Thread.sleep(1000);
							System.out.println("Click Ok");
			    		fileone.setCellData(sheetName, "Result", 28 , "Pass");	
			    	 }
			    	
			    	 else
			    	 {
			    		 fileone.setCellData(sheetName, "Result", 28, "Fail");
			    	 }	
			    	 
			    	 SoftAssert softAssert = new SoftAssert();
			    	 softAssert.assertEquals(actualPopup, actualPopup);
				   	}





		@Test(priority=27)
		   	public void CheckMandatoryForScience
		(



		) throws IOException, InterruptedException
		   	{
		    	test = extent.createTest("CheckMandatoryForScience");
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

		data.enterText("id","txtCTeleNo",PhoneNo);


		Thread.sleep(1300);

		data.enterText("id","txtMaxMark",MaximumMark);

		Thread.sleep(1300);

		data.enterText("id","txtTotMark",SecuredMark);


		Thread.sleep(1300);

		data.enterText("id","txtEnglish",English);


		Thread.sleep(1300);

		data.enterText("id","txtMath",Math);

		data.UploadImage();
		Thread.sleep(1300);
		data.clickOnLocator("id","btnSave");
			   		Thread.sleep(1000);
		String actualPopup =data.grtpopup().getText();
					
					System.out.println(actualPopup);
			    	
					String expectedmessage = "Science Mark cannot be left blank !";

			    	 if(actualPopup.equals(expectedmessage))
			    	 {
			    		 System.out.println("Sucessfully Message is" + actualPopup);
			    		 data.clickOnLocator("id","popup_ok");
			    		 Thread.sleep(1000);
							System.out.println("Click Ok");
			    		fileone.setCellData(sheetName, "Result", 29 , "Pass");	
			    	 }
			    	
			    	 else
			    	 {
			    		 fileone.setCellData(sheetName, "Result", 29, "Fail");
			    	 }	
			    	 
			    	 SoftAssert softAssert = new SoftAssert();
			    	 softAssert.assertEquals(actualPopup, actualPopup);
				   	}





		@Test(priority=28)
		   	public void CheckMandatoryForSocialScience
		(



		) throws IOException, InterruptedException
		   	{
		    	test = extent.createTest("CheckMandatoryForSocialScience");
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

		data.enterText("id","txtCTeleNo",PhoneNo);


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

		data.UploadImage();
		Thread.sleep(1300);
		data.clickOnLocator("id","btnSave");
			   		Thread.sleep(1000);
		String actualPopup =data.grtpopup().getText();
					
					System.out.println(actualPopup);
			    	
					String expectedmessage = "Social Science Mark cannot be left blank !";

			    	 if(actualPopup.equals(expectedmessage))
			    	 {
			    		 System.out.println("Sucessfully Message is" + actualPopup);
			    		 data.clickOnLocator("id","popup_ok");
			    		 Thread.sleep(1000);
							System.out.println("Click Ok");
			    		fileone.setCellData(sheetName, "Result", 30 , "Pass");	
			    	 }
			    	
			    	 else
			    	 {
			    		 fileone.setCellData(sheetName, "Result", 30, "Fail");
			    	 }	
			    	 
			    	 SoftAssert softAssert = new SoftAssert();
			    	 softAssert.assertEquals(actualPopup, actualPopup);
				   	}





		@Test(priority=29)
		   	public void CheckMandatoryForGrade
		(



		) throws IOException, InterruptedException
		   	{
		    	test = extent.createTest("CheckMandatoryForGrade");
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
		 Thread.sleep(1300);
	      
	      data.SelectDropdown("id","ddlYOP","2019");
		   		Thread.sleep(100);

	
	data.clickOnLocator("id","rbtnAnnual");

	Thread.sleep(1300);

	data.enterText("id","txtBoardRoll","21AW5678");


	Thread.sleep(1300);
   
   data.SelectDropdown("id","ddlBloodGroup","A+");
   Thread.sleep(1300);
	data.enterText("id","txtApplName",ApplicantName);



	Thread.sleep(1300);

	data.enterText("id","txtFatherName",FatherName);



	Thread.sleep(1300);

	data.enterText("id","txtMotherName",MotherName);

	



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

	data.enterText("id","txtCTeleNo",PhoneNo);


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

	data.UploadImage();
	Thread.sleep(1300);
	data.clickOnLocator("id","btnSave");
		   		Thread.sleep(1000);
	String actualPopup =data.grtpopup().getText();
				
				System.out.println(actualPopup);
		    	
				String expectedmessage = "Please select Grade !";

		    	 if(actualPopup.equals(expectedmessage))
		    	 {
		    		 System.out.println("Sucessfully Message is" + actualPopup);
		    		 data.clickOnLocator("id","popup_ok");
		    		 Thread.sleep(1000);
						System.out.println("Click Ok");
		    		fileone.setCellData(sheetName, "Result", 31 , "Pass");	
		    	 }
		    	
		    	 else
		    	 {
		    		 fileone.setCellData(sheetName, "Result", 31, "Fail");
		    		 data.clickOnLocator("id","popup_ok");
		    	 }	
		    	 
		    	 SoftAssert softAssert = new SoftAssert();
		    	 softAssert.assertEquals(actualPopup, actualPopup);
			   	}
				   	





		@Test(priority=30)
		   	public void CheckMandatoryForFatherOccupation
		(



		) throws IOException, InterruptedException
		   	{
		    	test = extent.createTest("CheckMandatoryForFatherOccupation");
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

		data.enterText("id","txtCTeleNo",PhoneNo);


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


		Thread.sleep(1300);
		      
		     // data.SelectDropdown("id","ddlGrade","A1");

		data.UploadImage();
		Thread.sleep(1300);
		data.clickOnLocator("id","btnSave");
			   		Thread.sleep(1000);
		String actualPopup =data.grtpopup().getText();
					
					System.out.println(actualPopup);
			    	
					String expectedmessage = "Please select Father's Occupation !";

			    	 if(actualPopup.equals(expectedmessage))
			    	 {
			    		 System.out.println("Sucessfully Message is" + actualPopup);
			    		 data.clickOnLocator("id","popup_ok");
			    		 Thread.sleep(1000);
							System.out.println("Click Ok");
			    		fileone.setCellData(sheetName, "Result", 32 , "Pass");	
			    	 }
			    	
			    	 else
			    	 {
			    		 fileone.setCellData(sheetName, "Result", 32, "Fail");
			    	 }	
			    	 
			    	 SoftAssert softAssert = new SoftAssert();
			    	 softAssert.assertEquals(actualPopup, actualPopup);
				   	}





		@Test(priority=31)
		   	public void CheckMandatoryForMotherOccupation
		(



		) throws IOException, InterruptedException
		   	{
		    	test = extent.createTest("CheckMandatoryForMotherOccupation");
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

		data.enterText("id","txtCTeleNo",PhoneNo);


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


		Thread.sleep(1300);
		      
		     // data.SelectDropdown("id","ddlGrade","A1");


		Thread.sleep(1300);
		      
		      data.SelectDropdown("id","ddlFOcu","BUSINESS");

		data.UploadImage();
		Thread.sleep(1300);
		data.clickOnLocator("id","btnSave");
			   		Thread.sleep(1000);
		String actualPopup =data.grtpopup().getText();
					
					System.out.println(actualPopup);
			    	
					String expectedmessage = "Please select Mother's Occupation !";

			    	 if(actualPopup.equals(expectedmessage))
			    	 {
			    		 System.out.println("Sucessfully Message is" + actualPopup);
			    		 data.clickOnLocator("id","popup_ok");
			    		 Thread.sleep(1000);
							System.out.println("Click Ok");
			    		fileone.setCellData(sheetName, "Result", 33 , "Pass");	
			    	 }
			    	
			    	 else
			    	 {
			    		 fileone.setCellData(sheetName, "Result", 33, "Fail");
			    	 }	
			    	 
			    	 SoftAssert softAssert = new SoftAssert();
			    	 softAssert.assertEquals(actualPopup, actualPopup);
				   	}





		@Test(priority=32)
		   	public void CheckMandatoryForAnnualIncome
		(



		) throws IOException, InterruptedException
		   	{
		    	test = extent.createTest("CheckMandatoryForAnnualIncome");
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

		data.enterText("id","txtCTeleNo",PhoneNo);


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


		Thread.sleep(1300);
		      
		     // data.SelectDropdown("id","ddlGrade","A1");


		Thread.sleep(1300);
		      
		      data.SelectDropdown("id","ddlFOcu","BUSINESS");


		Thread.sleep(1300);
		      
		      data.SelectDropdown("id","ddlMOcu","BUSINESS");

		data.UploadImage();
		Thread.sleep(1300);
		data.clickOnLocator("id","btnSave");
			   		Thread.sleep(1000);
		String actualPopup =data.grtpopup().getText();
					
					System.out.println(actualPopup);
			    	
					String expectedmessage = "Please select Annual Income of the Parents !";

			    	 if(actualPopup.equals(expectedmessage))
			    	 {
			    		 System.out.println("Sucessfully Message is" + actualPopup);
			    		 data.clickOnLocator("id","popup_ok");
			    		 Thread.sleep(1000);
							System.out.println("Click Ok");
			    		fileone.setCellData(sheetName, "Result", 34 , "Pass");	
			    	 }
			    	
			    	 else
			    	 {
			    		 fileone.setCellData(sheetName, "Result", 34, "Fail");
			    	 }	
			    	 
			    	 SoftAssert softAssert = new SoftAssert();
			    	 softAssert.assertEquals(actualPopup, actualPopup);
				   	}




		@Test(priority=33)
		   	public void CheckMandatoryForNameOfSchool
		(



		) throws IOException, InterruptedException
		   	{
		    	test = extent.createTest("CheckMandatoryForNameOfSchool");
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

		data.enterText("id","txtCTeleNo",PhoneNo);


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


		Thread.sleep(1300);
		      
		     // data.SelectDropdown("id","ddlGrade","A1");


		Thread.sleep(1300);
		      
		      data.SelectDropdown("id","ddlFOcu","BUSINESS");


		Thread.sleep(1300);
		      
		      data.SelectDropdown("id","ddlMOcu","BUSINESS");


		Thread.sleep(1300);
		      
		      data.SelectDropdown("id","ddlAIncome","OTHERS");

		data.UploadImage();
		Thread.sleep(1300);
		data.clickOnLocator("id","btnSave");
			   		Thread.sleep(1000);
		String actualPopup =data.grtpopup().getText();
					
					System.out.println(actualPopup);
			    	
					String expectedmessage = "Name of the School cannot be left blank !";

			    	 if(actualPopup.equals(expectedmessage))
			    	 {
			    		 System.out.println("Sucessfully Message is" + actualPopup);
			    		 data.clickOnLocator("id","popup_ok");
			    		 Thread.sleep(1000);
							System.out.println("Click Ok");
			    		fileone.setCellData(sheetName, "Result", 35 , "Pass");	
			    	 }
			    	
			    	 else
			    	 {
			    		 fileone.setCellData(sheetName, "Result", 35, "Fail");
			    	 }	
			    	 
			    	 SoftAssert softAssert = new SoftAssert();
			    	 softAssert.assertEquals(actualPopup, actualPopup);
				   	}




		@Test(priority=34)
		   	public void CheckMandatoryForLocationOfSchool
		(



		) throws IOException, InterruptedException
		   	{
		    	test = extent.createTest("CheckMandatoryForLocationOfSchool");
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

		data.enterText("id","txtCTCodee",AreaCode);

		

		Thread.sleep(1300);

		data.enterText("id","txtCTeleNo",PhoneNo);


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


		Thread.sleep(1300);
		      
		     // data.SelectDropdown("id","ddlGrade","A1");


		Thread.sleep(1300);
		      
		      data.SelectDropdown("id","ddlFOcu","BUSINESS");


		Thread.sleep(1300);
		      
		      data.SelectDropdown("id","ddlMOcu","BUSINESS");


		Thread.sleep(1300);
		      
		      data.SelectDropdown("id","ddlAIncome","OTHERS");


		Thread.sleep(1300);

		data.enterText("id","txtschname",SchoolName);

		data.UploadImage();
		Thread.sleep(1300);
		data.clickOnLocator("id","btnSave");
			   		Thread.sleep(1000);
		String actualPopup =data.grtpopup().getText();
					
					System.out.println(actualPopup);
			    	
					String expectedmessage = "Location of the School cannot be left blank !";

			    	 if(actualPopup.equals(expectedmessage))
			    	 {
			    		 System.out.println("Sucessfully Message is" + actualPopup);
			    		 data.clickOnLocator("id","popup_ok");
			    		 Thread.sleep(1000);
							System.out.println("Click Ok");
			    		fileone.setCellData(sheetName, "Result", 36 , "Pass");	
			    	 }
			    	
			    	 else
			    	 {
			    		 fileone.setCellData(sheetName, "Result", 36, "Fail");
			    	 }	
			    	 
			    	 SoftAssert softAssert = new SoftAssert();
			    	 softAssert.assertEquals(actualPopup, actualPopup);
				   	}






		@Test(priority=35)
		   	public void CheckMandatoryForDistrictInstitute
		(



		) throws IOException, InterruptedException
		   	{
		    	test = extent.createTest("CheckMandatoryForDistrictInstitute");
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

		data.enterText("id","txtCTeleNo",PhoneNo);


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


		Thread.sleep(1300);
		      
		     // data.SelectDropdown("id","ddlGrade","A1");


		Thread.sleep(1300);
		      
		      data.SelectDropdown("id","ddlFOcu","BUSINESS");


		Thread.sleep(1300);
		      
		      data.SelectDropdown("id","ddlMOcu","BUSINESS");


		Thread.sleep(1300);
		      
		      data.SelectDropdown("id","ddlAIncome","OTHERS");


		Thread.sleep(1300);

		data.enterText("id","txtschname",SchoolName);

		Thread.sleep(1300);

		data.enterText("id","txtschloc",SchoolLocation);

		data.UploadImage();
		Thread.sleep(1300);
		data.clickOnLocator("id","btnSave");
			   		Thread.sleep(1000);
		String actualPopup =data.grtpopup().getText();
					
					System.out.println(actualPopup);
			    	
					String expectedmessage = "Please select District !";

			    	 if(actualPopup.equals(expectedmessage))
			    	 {
			    		 System.out.println("Sucessfully Message is" + actualPopup);
			    		 data.clickOnLocator("id","popup_ok");
			    		 Thread.sleep(1000);
							System.out.println("Click Ok");
			    		fileone.setCellData(sheetName, "Result", 37 , "Pass");	
			    	 }
			    	
			    	 else
			    	 {
			    		 fileone.setCellData(sheetName, "Result", 37, "Fail");
			    	 }	
			    	 
			    	 SoftAssert softAssert = new SoftAssert();
			    	 softAssert.assertEquals(actualPopup, actualPopup);
				   	}






		@Test(priority=36)
		   	public void CheckMandatoryForYearOfJoining
		(



		) throws IOException, InterruptedException
		   	{
		    	test = extent.createTest("CheckMandatoryForYearOfJoining");
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

		data.enterText("id","txtCTeleNo",PhoneNo);


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


		Thread.sleep(1300);
		      
		     // data.SelectDropdown("id","ddlGrade","A1");


		Thread.sleep(1300);
		      
		      data.SelectDropdown("id","ddlFOcu","BUSINESS");


		Thread.sleep(1300);
		      
		      data.SelectDropdown("id","ddlMOcu","BUSINESS");


		Thread.sleep(1300);
		      
		      data.SelectDropdown("id","ddlAIncome","OTHERS");


		Thread.sleep(1300);

		data.enterText("id","txtschname",SchoolName);

		Thread.sleep(1300);

		data.enterText("id","txtschloc",SchoolLocation);


		Thread.sleep(1300);
		      
		      data.SelectDropdown("id","ddlinstDistrict","ANGUL");

		data.UploadImage();
		Thread.sleep(1300);
		data.clickOnLocator("id","btnSave");
			   		Thread.sleep(1000);
		String actualPopup =data.grtpopup().getText();
					
					System.out.println(actualPopup);
			    	
					String expectedmessage = "Please select Year of Joining !";

			    	 if(actualPopup.equals(expectedmessage))
			    	 {
			    		 System.out.println("Sucessfully Message is" + actualPopup);
			    		 data.clickOnLocator("id","popup_ok");
			    		 Thread.sleep(1000);
							System.out.println("Click Ok");
			    		fileone.setCellData(sheetName, "Result", 38 , "Pass");	
			    	 }
			    	
			    	 else
			    	 {
			    		 fileone.setCellData(sheetName, "Result", 38, "Fail");
			    	 }	
			    	 
			    	 SoftAssert softAssert = new SoftAssert();
			    	 softAssert.assertEquals(actualPopup, actualPopup);
				   	}




		@Test(priority=37)
		   	public void CheckMandatoryForAccountNumber
		(



		) throws IOException, InterruptedException
		   	{
		    	test = extent.createTest("CheckMandatoryForAccountNumber");
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

		data.enterText("id","txtCTeleNo",PhoneNo);


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


		Thread.sleep(1300);
		      
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

		data.UploadImage();
		Thread.sleep(1300);
		data.clickOnLocator("id","btnSave");
			   		Thread.sleep(1000);
		String actualPopup =data.grtpopup().getText();
					
					System.out.println(actualPopup);
			    	
					String expectedmessage = "Account No cannot be left blank !";

			    	 if(actualPopup.equals(expectedmessage))
			    	 {
			    		 System.out.println("Sucessfully Message is" + actualPopup);
			    		 data.clickOnLocator("id","popup_ok");
			    		 Thread.sleep(1000);
							System.out.println("Click Ok");
			    		fileone.setCellData(sheetName, "Result", 39 , "Pass");	
			    	 }
			    	
			    	 else
			    	 {
			    		 fileone.setCellData(sheetName, "Result", 39, "Fail");
			    	 }	
			    	 
			    	 SoftAssert softAssert = new SoftAssert();
			    	 softAssert.assertEquals(actualPopup, actualPopup);
				   	}




		@Test(priority=38)
		   	public void CheckMandatoryForIFSC
		(



		) throws IOException, InterruptedException
		   	{
		    	test = extent.createTest("CheckMandatoryForIFSC");
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

		data.enterText("id","txtCTeleNo",PhoneNo);


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


		Thread.sleep(1300);
		      
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


		data.UploadImage();
		Thread.sleep(1300);
		data.clickOnLocator("id","btnSave");
			   		Thread.sleep(1000);
		String actualPopup =data.grtpopup().getText();
					
					System.out.println(actualPopup);
			    	
					String expectedmessage = "IFSC Code cannot be left blank !";

			    	 if(actualPopup.equals(expectedmessage))
			    	 {
			    		 System.out.println("Sucessfully Message is" + actualPopup);
			    		 data.clickOnLocator("id","popup_ok");
			    		 Thread.sleep(1000);
							System.out.println("Click Ok");
			    		fileone.setCellData(sheetName, "Result", 40 , "Pass");	
			    	 }
			    	
			    	 else
			    	 {
			    		 fileone.setCellData(sheetName, "Result", 40, "Fail");
			    	 }	
			    	 
			    	 SoftAssert softAssert = new SoftAssert();
			    	 softAssert.assertEquals(actualPopup, actualPopup);
				   	}







		@Test(priority=39)
		   	public void CheckNonMandatoryForMICR
		(



		) throws IOException, InterruptedException
		   	{
		    	test = extent.createTest("CheckNonMandatoryForMICR");
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

		data.enterText("id","txtCTeleNo",PhoneNo);


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


		Thread.sleep(1300);
		      
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
			    		fileone.setCellData(sheetName, "Result", 41 , "Pass");	
			    	 }
			    	
			    	 else
			    	 {
			    		 fileone.setCellData(sheetName, "Result", 41, "Fail");
			    	 }	
			    	 
			    	 SoftAssert softAssert = new SoftAssert();
			    	 softAssert.assertEquals(actualPopup, actualPopup);
				   	}



		@Test(priority=40)
		   	public void CheckMandatoryForBankName
		(



		) throws IOException, InterruptedException
		   	{
		    	test = extent.createTest("CheckMandatoryForBankName");
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

		data.enterText("id","txtCTeleNo",PhoneNo);


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
			    		fileone.setCellData(sheetName, "Result", 42 , "Pass");	
			    	 }
			    	
			    	 else
			    	 {
			    		 fileone.setCellData(sheetName, "Result", 42, "Fail");
			    	 }	
			    	 
			    	 SoftAssert softAssert = new SoftAssert();
			    	 softAssert.assertEquals(actualPopup, actualPopup);
				   	}
		
		
		@Test(priority=41)
	   	public void CheckMandatoryForBranchName
	(



	) throws IOException, InterruptedException
	   	{
	    	test = extent.createTest("CheckMandatoryForBankName");
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
	      Thread.sleep(700);
	      
	      data.SelectDropdown("id","ddlYOP","2009");
		   		Thread.sleep(100);

	Thread.sleep(700);
	data.clickOnLocator("id","rbtnAnnual");

	Thread.sleep(700);

	data.enterText("id","txtBoardRoll",RollNumber);


	Thread.sleep(700);

	data.enterText("id","txtApplName",ApplicantName);

	

	Thread.sleep(700);

	data.enterText("id","txtFatherName",FatherName);



	Thread.sleep(700);

	data.enterText("id","txtMotherName",MotherName);

	Thread.sleep(700);
      
      data.SelectDropdown("id","ddlBloodGroup","A+");



Thread.sleep(700);
      
      data.SelectDropdown("id","ddlGender","MALE");



Thread.sleep(700);
      
      data.SelectDropdown("id","ddlReligion","HINDU");



Thread.sleep(700);
      
      data.SelectDropdown("id","ddlDay","11");


Thread.sleep(700);
      
      data.SelectDropdown("id","ddlMonth","SEPTEMBER");


Thread.sleep(700);
      
      data.SelectDropdown("id","ddlYear","1993");

	Thread.sleep(700);
	      
	      data.SelectDropdown("id","ddlNationality","INDIAN");



	Thread.sleep(700);
	      
	      data.SelectDropdown("id","ddlMt","ODIA");




	Thread.sleep(700);

	data.enterText("id","txtadhar",AadharNo);


	Thread.sleep(700);

	data.enterText("id","txtParentMob",MobileNo);
	Thread.sleep(700);
	Thread.sleep(700);
	      
	      data.SelectDropdown("id","ddlCState","1 - ODISHA");


	Thread.sleep(700);
	      
	      data.SelectDropdown("id","ddlCDist","ANGUL");


	Thread.sleep(700);
	      
	      data.SelectDropdown("id","ddlCBlock","ANGUL");

	Thread.sleep(700);

	data.enterText("id","txtCPS",HouseNo);
	Thread.sleep(700);

	data.enterText("id","txtCPC",PinCode);


	Thread.sleep(700);

	data.enterText("id","txtCEmail",Email);




	Thread.sleep(700);

	data.enterText("id","txtCTCode",AreaCode);



	Thread.sleep(700);

	data.enterText("id","txtCTCode",PhoneNo);


	Thread.sleep(700);

	data.enterText("id","txtMaxMark",MaximumMark);

	Thread.sleep(700);

	data.enterText("id","txtTotMark",SecuredMark);


	Thread.sleep(700);

	data.enterText("id","txtEnglish",English);


	Thread.sleep(700);

	data.enterText("id","txtMath",Math);


	Thread.sleep(700);

	data.enterText("id","txtScience",Science);


	Thread.sleep(700);

	data.enterText("id","txtSocSci",SocialScience);


	//Thread.sleep(700);
	      
	     // data.SelectDropdown("id","ddlGrade","A1");


	Thread.sleep(700);
	      
	      data.SelectDropdown("id","ddlFOcu","BUSINESS");


	Thread.sleep(700);
	      
	      data.SelectDropdown("id","ddlMOcu","BUSINESS");


	Thread.sleep(700);
	      
	      data.SelectDropdown("id","ddlAIncome","0 - 1,00,000");


	


	Thread.sleep(700);

	data.enterText("id","txtschname",SchoolName);

	Thread.sleep(700);

	data.enterText("id","txtschloc",SchoolLocation);


	Thread.sleep(700);
	      
	      data.SelectDropdown("id","ddlinstDistrict","ANGUL");

	Thread.sleep(700);
	      
	      data.SelectDropdown("id","ddlYOJ","1995");

	Thread.sleep(700);

	data.enterText("id","txtacno",AccountNumber);


	Thread.sleep(700);

	data.enterText("id","txtifsc",IFSC);
	
	
	
	Thread.sleep(700);

	data.enterText("id","txtBankname","SBI");


	data.UploadImage();
	Thread.sleep(700);
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
		    		fileone.setCellData(sheetName, "Result", 43 , "Pass");	
		    	 }
		    	
		    	 else
		    	 {
		    		 fileone.setCellData(sheetName, "Result", 43, "Fail");
		    	 }	
		    	 
		    	 SoftAssert softAssert = new SoftAssert();
		    	 softAssert.assertEquals(actualPopup, actualPopup);
			   	}
		
		
		
		@Test(priority=42)
	   	public void CheckMandatoryForCompartmentalSubjectName
	(



	) throws IOException, InterruptedException
	   	{
	    	test = extent.createTest("CheckMandatoryForBankName");
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
	      Thread.sleep(700);
	      
	      data.SelectDropdown("id","ddlYOP","2009");
		   		Thread.sleep(100);

	Thread.sleep(700);
	data.clickOnLocator("id","rbtnAnnual");

	Thread.sleep(700);

	data.enterText("id","txtBoardRoll",RollNumber);


	Thread.sleep(700);

	data.enterText("id","txtApplName",ApplicantName);

	

	Thread.sleep(700);

	data.enterText("id","txtFatherName",FatherName);



	Thread.sleep(700);

	data.enterText("id","txtMotherName",MotherName);

	Thread.sleep(700);
      
      data.SelectDropdown("id","ddlBloodGroup","A+");



Thread.sleep(700);
      
      data.SelectDropdown("id","ddlGender","MALE");



Thread.sleep(700);
      
      data.SelectDropdown("id","ddlReligion","HINDU");



Thread.sleep(700);
      
      data.SelectDropdown("id","ddlDay","11");


Thread.sleep(700);
      
      data.SelectDropdown("id","ddlMonth","SEPTEMBER");


Thread.sleep(700);
      
      data.SelectDropdown("id","ddlYear","1993");

	Thread.sleep(700);
	      
	      data.SelectDropdown("id","ddlNationality","INDIAN");



	Thread.sleep(700);
	      
	      data.SelectDropdown("id","ddlMt","ODIA");




	Thread.sleep(700);

	data.enterText("id","txtadhar",AadharNo);


	Thread.sleep(700);

	data.enterText("id","txtParentMob",MobileNo);
	Thread.sleep(700);
	Thread.sleep(700);
	      
	      data.SelectDropdown("id","ddlCState","1 - ODISHA");


	Thread.sleep(700);
	      
	      data.SelectDropdown("id","ddlCDist","ANGUL");


	Thread.sleep(700);
	      
	      data.SelectDropdown("id","ddlCBlock","ANGUL");

	Thread.sleep(700);

	data.enterText("id","txtCPS",HouseNo);
	Thread.sleep(700);

	data.enterText("id","txtCPC",PinCode);


	Thread.sleep(700);

	data.enterText("id","txtCEmail",Email);




	Thread.sleep(700);

	data.enterText("id","txtCTCode",AreaCode);



	Thread.sleep(700);

	data.enterText("id","txtCTCode",PhoneNo);


	Thread.sleep(700);

	data.enterText("id","txtMaxMark",MaximumMark);

	Thread.sleep(700);

	data.enterText("id","txtTotMark",SecuredMark);


	Thread.sleep(700);

	data.enterText("id","txtEnglish",English);


	Thread.sleep(700);

	data.enterText("id","txtMath",Math);


	Thread.sleep(700);

	data.enterText("id","txtScience",Science);


	Thread.sleep(700);

	data.enterText("id","txtSocSci",SocialScience);


	//Thread.sleep(700);
	      
	     // data.SelectDropdown("id","ddlGrade","A1");


data.clickOnLocator("id", "rbtCompartmentalY");


	data.UploadImage();
	Thread.sleep(700);
	data.clickOnLocator("id","btnSave");
		   		Thread.sleep(1000);
	String actualPopup =data.grtpopup().getText();
				
				System.out.println(actualPopup);
		    	
				String expectedmessage = "Please select Subject1 !";

		    	 if(actualPopup.equals(expectedmessage))
		    	 {
		    		 System.out.println("Sucessfully Message is" + actualPopup);
		    		 data.clickOnLocator("id","popup_ok");
		    		 Thread.sleep(1000);
						System.out.println("Click Ok");
		    		fileone.setCellData(sheetName, "Result", 44 , "Pass");	
		    	 }
		    	
		    	 else
		    	 {
		    		 fileone.setCellData(sheetName, "Result", 44, "Fail");
		    	 }	
		    	 
		    	 SoftAssert softAssert = new SoftAssert();
		    	 softAssert.assertEquals(actualPopup, actualPopup);
			   	}
		
		
		
		@Test(priority=43)
	   	public void CheckMandatoryForCompartmentalFailMark
	(



	) throws IOException, InterruptedException
	   	{
	    	test = extent.createTest("CheckMandatoryForBankName");
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
	      Thread.sleep(700);
	      
	      data.SelectDropdown("id","ddlYOP","2009");
		   		Thread.sleep(100);

	Thread.sleep(700);
	data.clickOnLocator("id","rbtnAnnual");

	Thread.sleep(700);

	data.enterText("id","txtBoardRoll",RollNumber);


	Thread.sleep(700);

	data.enterText("id","txtApplName",ApplicantName);

	

	Thread.sleep(700);

	data.enterText("id","txtFatherName",FatherName);



	Thread.sleep(700);

	data.enterText("id","txtMotherName",MotherName);

	Thread.sleep(700);
      
      data.SelectDropdown("id","ddlBloodGroup","A+");



Thread.sleep(700);
      
      data.SelectDropdown("id","ddlGender","MALE");



Thread.sleep(700);
      
      data.SelectDropdown("id","ddlReligion","HINDU");



Thread.sleep(700);
      
      data.SelectDropdown("id","ddlDay","11");


Thread.sleep(700);
      
      data.SelectDropdown("id","ddlMonth","SEPTEMBER");


Thread.sleep(700);
      
      data.SelectDropdown("id","ddlYear","1993");

	Thread.sleep(700);
	      
	      data.SelectDropdown("id","ddlNationality","INDIAN");



	Thread.sleep(700);
	      
	      data.SelectDropdown("id","ddlMt","ODIA");




	Thread.sleep(700);

	data.enterText("id","txtadhar",AadharNo);


	Thread.sleep(700);

	data.enterText("id","txtParentMob",MobileNo);
	Thread.sleep(700);
	Thread.sleep(700);
	      
	      data.SelectDropdown("id","ddlCState","1 - ODISHA");


	Thread.sleep(700);
	      
	      data.SelectDropdown("id","ddlCDist","ANGUL");


	Thread.sleep(700);
	      
	      data.SelectDropdown("id","ddlCBlock","ANGUL");

	Thread.sleep(700);

	data.enterText("id","txtCPS",HouseNo);
	Thread.sleep(700);

	data.enterText("id","txtCPC",PinCode);


	Thread.sleep(700);

	data.enterText("id","txtCEmail",Email);




	Thread.sleep(700);

	data.enterText("id","txtCTCode",AreaCode);



	Thread.sleep(700);

	data.enterText("id","txtCTCode",PhoneNo);


	Thread.sleep(700);

	data.enterText("id","txtMaxMark",MaximumMark);

	Thread.sleep(700);

	data.enterText("id","txtTotMark",SecuredMark);


	Thread.sleep(700);

	data.enterText("id","txtEnglish",English);


	Thread.sleep(700);

	data.enterText("id","txtMath",Math);


	Thread.sleep(700);

	data.enterText("id","txtScience",Science);


	Thread.sleep(700);

	data.enterText("id","txtSocSci",SocialScience);


	//Thread.sleep(700);
	      
	     // data.SelectDropdown("id","ddlGrade","A1");


data.clickOnLocator("id", "rbtCompartmentalY");


Thread.sleep(700);
data.SelectDropdown("id", "ddlCompSubject1", "MIL");


	data.UploadImage();
	Thread.sleep(700);
	data.clickOnLocator("id","btnSave");
		   		Thread.sleep(1000);
	String actualPopup =data.grtpopup().getText();
				
				System.out.println(actualPopup);
		    	
				String expectedmessage = "Fail Mark in previous exam cannot be left blank !";

		    	 if(actualPopup.equals(expectedmessage))
		    	 {
		    		 System.out.println("Sucessfully Message is" + actualPopup);
		    		 data.clickOnLocator("id","popup_ok");
		    		 Thread.sleep(1000);
						System.out.println("Click Ok");
		    		fileone.setCellData(sheetName, "Result", 45 , "Pass");	
		    	 }
		    	
		    	 else
		    	 {
		    		 fileone.setCellData(sheetName, "Result", 45, "Fail");
		    	 }	
		    	 
		    	 SoftAssert softAssert = new SoftAssert();
		    	 softAssert.assertEquals(actualPopup, actualPopup);
			   	}
		
		
		
		
		@Test(priority=44)
	   	public void CheckMandatoryForCompartmentalPassMark
	(



	) throws IOException, InterruptedException
	   	{
	    	test = extent.createTest("CheckMandatoryForBankName");
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
	      Thread.sleep(700);
	      
	      data.SelectDropdown("id","ddlYOP","2009");
		   		Thread.sleep(100);

	Thread.sleep(700);
	data.clickOnLocator("id","rbtnAnnual");

	Thread.sleep(700);

	data.enterText("id","txtBoardRoll",RollNumber);


	Thread.sleep(700);

	data.enterText("id","txtApplName",ApplicantName);

	

	Thread.sleep(700);

	data.enterText("id","txtFatherName",FatherName);



	Thread.sleep(700);

	data.enterText("id","txtMotherName",MotherName);

	Thread.sleep(700);
      
      data.SelectDropdown("id","ddlBloodGroup","A+");



Thread.sleep(700);
      
      data.SelectDropdown("id","ddlGender","MALE");



Thread.sleep(700);
      
      data.SelectDropdown("id","ddlReligion","HINDU");



Thread.sleep(700);
      
      data.SelectDropdown("id","ddlDay","11");


Thread.sleep(700);
      
      data.SelectDropdown("id","ddlMonth","SEPTEMBER");


Thread.sleep(700);
      
      data.SelectDropdown("id","ddlYear","1993");

	Thread.sleep(700);
	      
	      data.SelectDropdown("id","ddlNationality","INDIAN");



	Thread.sleep(700);
	      
	      data.SelectDropdown("id","ddlMt","ODIA");




	Thread.sleep(700);

	data.enterText("id","txtadhar",AadharNo);


	Thread.sleep(700);

	data.enterText("id","txtParentMob",MobileNo);
	Thread.sleep(700);
	Thread.sleep(700);
	      
	      data.SelectDropdown("id","ddlCState","1 - ODISHA");


	Thread.sleep(700);
	      
	      data.SelectDropdown("id","ddlCDist","ANGUL");


	Thread.sleep(700);
	      
	      data.SelectDropdown("id","ddlCBlock","ANGUL");

	Thread.sleep(700);

	data.enterText("id","txtCPS",HouseNo);
	Thread.sleep(700);

	data.enterText("id","txtCPC",PinCode);


	Thread.sleep(700);

	data.enterText("id","txtCEmail",Email);




	Thread.sleep(700);

	data.enterText("id","txtCTCode",AreaCode);



	Thread.sleep(700);

	data.enterText("id","txtCTCode",PhoneNo);


	Thread.sleep(700);

	data.enterText("id","txtMaxMark",MaximumMark);

	Thread.sleep(700);

	data.enterText("id","txtTotMark",SecuredMark);


	Thread.sleep(700);

	data.enterText("id","txtEnglish",English);


	Thread.sleep(700);

	data.enterText("id","txtMath",Math);


	Thread.sleep(700);

	data.enterText("id","txtScience",Science);


	Thread.sleep(700);

	data.enterText("id","txtSocSci",SocialScience);


	//Thread.sleep(700);
	      
	     // data.SelectDropdown("id","ddlGrade","A1");


data.clickOnLocator("id", "rbtCompartmentalY");


Thread.sleep(700);
data.SelectDropdown("id", "ddlCompSubject1", "MIL");
Thread.sleep(700);
data.enterText("id", "txtCompFMark1", "34");


	data.UploadImage();
	Thread.sleep(700);
	data.clickOnLocator("id","btnSave");
		   		Thread.sleep(1000);
	String actualPopup =data.grtpopup().getText();
				
				System.out.println(actualPopup);
		    	
				String expectedmessage = "Pass Mark in previous exam cannot be left blank !";

		    	 if(actualPopup.equals(expectedmessage))
		    	 {
		    		 System.out.println("Sucessfully Message is" + actualPopup);
		    		 data.clickOnLocator("id","popup_ok");
		    		 Thread.sleep(1000);
						System.out.println("Click Ok");
		    		fileone.setCellData(sheetName, "Result", 46 , "Pass");	
		    	 }
		    	
		    	 else
		    	 {
		    		 fileone.setCellData(sheetName, "Result", 46, "Fail");
		    	 }	
		    	 
		    	 SoftAssert softAssert = new SoftAssert();
		    	 softAssert.assertEquals(actualPopup, actualPopup);
			   	}
	    	
   	}
 	


    	


