package FieldText;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Genericlib.CommonFunction;

public class ExtentReportBase {
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static  ExtentTest test;
	WebDriver driver;
	 
	@BeforeSuite
	public void extentReportSetUp() {
		
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/ValidationExtentReport/VerifyFieldValidation-Report.html");
		htmlReporter.loadXMLConfig(new File(System.getProperty("user.dir")+"/extent-config.xml"));
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		
		htmlReporter.config().setDocumentTitle("Automation CAF"); 
		htmlReporter.config().setReportName("Functional Testing"); 
		
		htmlReporter.config().setTheme(Theme.DARK);
		  
	
		
		extent.setSystemInfo("Host name", "Test Server");
		extent.setSystemInfo("Environment", "QC");
  	
	}
	
	 @AfterMethod
	    public void tearDown(ITestResult result) throws IOException {
			  if (result.getStatus() == ITestResult.FAILURE) {
			   test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getName()); // to add name in extent report
			   test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getThrowable()); // to add error/exception in extent report
			   //String screenshotPath = Testc.getScreenshot(driver, result.getName());
			  //s test.addScreenCaptureFromPath(screenshotPath);// adding screen shot
			  } else if (result.getStatus() == ITestResult.SKIP) {
			   test.log(Status.SKIP, "Test Case SKIPPED IS " + result.getName());
			  }
			  else if (result.getStatus() == ITestResult.SUCCESS) {
			   test.log(Status.PASS, "Test Case PASSED IS " + result.getName());
			  }
				
		
			 
			 }
	     
	 
	 @AfterTest
		 public void tearDown() {
		 driver.quit(); 
		 
	 }
	
	@AfterSuite
	public void finishExtentReport() {
		extent.flush();
		
	}
	
	
}
