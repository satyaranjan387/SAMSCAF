		package com.minimizedScenariosExtentReport;
		
		import java.io.FileInputStream;
		import java.io.FileNotFoundException;
		import java.io.IOException;
		import java.util.Iterator;
		import java.util.Properties;
		import java.util.Set;
		import java.util.concurrent.TimeUnit;
		
		import org.apache.poi.xssf.usermodel.XSSFSheet;
		import org.apache.poi.xssf.usermodel.XSSFWorkbook;
		import org.openqa.selenium.By;
		import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
		import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.genericlib.Xls_AllMethods;
import com.testscenariosSmokeTest.Testc;
		
		public class AutoValidation {
		
			@SuppressWarnings("deprecation")
			public ExtentHtmlReporter htmlReporter;
			static Xls_AllMethods fileone = new Xls_AllMethods("C:/Users/satyaranjan.m/eclipse-workspace/JuniorForm/JuniorFormMappingData.xlsx");	
			static WebDriver driver;
			XSSFWorkbook wb;
			XSSFSheet sht;
			String sheetName = "Result";
		    int rowCount = fileone.getRowCount(sheetName);
		    ExtentReports extent;
		    public ExtentTest test;
	    
		    @BeforeTest
			public void Setup() throws IOException, InterruptedException
			{
		    	htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/ExtentReport/AutoValidation-Report.html");

				htmlReporter.config().setDocumentTitle("Automation CAF"); 
				htmlReporter.config().setReportName("Functional Testing"); 
				
				htmlReporter.config().setTheme(Theme.DARK);
				  
				extent = new ExtentReports();
				extent.attachReporter(htmlReporter);
				
				extent.setSystemInfo("Host name", "Test Server");
				extent.setSystemInfo("Environment", "QC");
				
			}
		  
		    @AfterTest
			public void finish() {
				extent.flush();
				driver.quit();
			}
		    
	    
	    @Test(priority=0)
	    public void Verify10throllno_autovalidation_nonodishaboard() throws FileNotFoundException {
    	
	    test = extent.createTest("10throllno_autovalidation_nonodishaboard");
    	System.setProperty("webdriver.chrome.driver", "C:/Users/satyaranjan.m//Desktop/chromedriver_win32 (2)/chromedriver.exe");
    	driver= new ChromeDriver();
    	driver.manage().deleteAllCookies();
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(20000, TimeUnit.SECONDS);
    	FileInputStream fis= new FileInputStream("C:\\Users\\satyaranjan.m\\eclipse-workspace\\JuniorForm\\config.properties");
    	Properties prop=new Properties();
    	try {
    	prop.load(fis);
    	}
    	catch(IOException e)

    	{
    		e.printStackTrace();
    	}
    	//driver.get(url);
    	driver.get(prop.getProperty("url"));
    	driver.findElement(By.xpath("//a[contains(text(),'Junior Application')]")).click();
    	String parent = driver.getWindowHandle();
    	Set<String> set = driver.getWindowHandles();
    	Iterator<String> itr= set.iterator();
    	while(itr.hasNext())
    	{
    		String child = itr.next();
    		if(!parent.equals(child))
    		{
    			driver.switchTo().window(child);
    		}
    	}
    	driver.findElement(By.id("txtSMobileNo")).sendKeys(prop.getProperty("UserName"));
		driver.findElement(By.id("txtSPwd")).sendKeys(prop.getProperty("Password"));
		String cptcha = driver.findElement(By.xpath("//*[@id=\"lblCaptcha\"]")).getText();
		driver.findElement(By.id("txtRandno")).sendKeys(cptcha);
		driver.findElement(By.id("btnSIGNIN")).click();
//    	driver.findElement(By.id("txtSMobileNo")).sendKeys(UserName);
//    	driver.findElement(By.id("txtSPwd")).sendKeys(Password);
//    	String cptcha = driver.findElement(By.xpath("//*[@id=\"lblCaptcha\"]")).getText();
//    	driver.findElement(By.id("txtRandno")).sendKeys(cptcha);
//    	driver.findElement(By.id("btnSIGNIN")).click();
		
		driver.findElement(By.xpath("//span[@class='menu-text']")).click();
		
		driver.findElement(By.xpath("//a[contains(text(),'CAF Apply')]")).click();
		
		driver.findElement(By.id("ddlBoard")).sendKeys("11 - BSE, ANDHRA PRADESH");
		
		driver.findElement(By.id("ddlYOP")).sendKeys("2019");
		
		driver.findElement(By.id("rbtnAnnual")).click();
		
		driver.findElement(By.id("txtBoardRoll")).sendKeys("157CD0105");
		
		String applNEnb = driver.findElement(By.id("lblBExam")).getText();
		System.out.println(applNEnb);
		
		if(applNEnb.equals("Mark secured in 10th Board Examination"))
		 {
			fileone.setCellData(sheetName, "Status", 60 , "Fail");	
		 }
		
		 else
		 {
			 fileone.setCellData(sheetName, "Status", 60, "Pass");
		 }
	
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(applNEnb, "Mark secured in 10th Board Examination");
	    }
	    
	    @Test(priority=1)
	    public void VerifyTenthrollno_autovalidation_before2013() {
	    	
	    	test = extent.createTest("Tenthrollno_autovalidation_before2013");
	    	
	    	driver.findElement(By.id("ddlBoard")).sendKeys("1 - BSE, ODISHA");
			
			driver.findElement(By.id("ddlYOP")).sendKeys("2010");
			
			driver.findElement(By.id("rbtnAnnual")).click();
			
			driver.findElement(By.id("txtBoardRoll")).sendKeys("157CD0105");
			
			String applNEnb1 = driver.findElement(By.id("lblBExam")).getText();
			System.out.println(applNEnb1);
			
			if(applNEnb1.equals("Mark secured in 10th Board Examination"))
			 {
				fileone.setCellData(sheetName, "Status", 61 , "Fail");	
			 }
			
			 else
			 {
				 fileone.setCellData(sheetName, "Status", 61, "Pass");
			 }
		
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertEquals(applNEnb1, "Mark secured in 10th Board Examination");	
	    	
	    }
	    
	    
	    @Test(priority=2)
	    public void VerifyTenththrollno_autovalidation() throws Exception {
	    	
	    	test = extent.createTest("Tenththrollno_autovalidation");
	    	
	    	driver.findElement(By.id("ddlBoard")).sendKeys("1 - BSE, ODISHA");
			
			driver.findElement(By.id("ddlYOP")).sendKeys("2019");
			
			driver.findElement(By.id("rbtnAnnual")).click();
			
			driver.findElement(By.id("txtBoardRoll")).sendKeys("157CD0105");
			
			driver.findElement(By.id("txtApplName")).click();
			
			//String actText = driver.findElement(By.id("lblBExam")).getText();
			
			WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtApplName")));
			Thread.sleep(1000);
			String actText = driver.findElement(By.id("txtApplName")).getAttribute("value");
			Thread.sleep(1000);
			System.out.println(actText);
			if(actText.contentEquals("RUPASHREE MOHANTA"))
			 {
				fileone.setCellData(sheetName, "Status", 62 , "Pass");	
			 }
			
			 else
			 {
				 fileone.setCellData(sheetName, "Status", 62, "Fail");
			 }
		
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertEquals(actText, "RUPASHREE MOHANTA", "Test case Failed");
			
	    }

	    @AfterMethod
		 public void tearDown(ITestResult result) throws IOException {
		  if (result.getStatus() == ITestResult.FAILURE) {
		   test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getName()); // to add name in extent report
		   test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getThrowable()); // to add error/exception in extent report
		   String screenshotPath = Testc.getScreenshot(driver, result.getName());
		   test.addScreenCaptureFromPath(screenshotPath);// adding screen shot
		  } else if (result.getStatus() == ITestResult.SKIP) {
		   test.log(Status.SKIP, "Test Case SKIPPED IS " + result.getName());
		  }
		  else if (result.getStatus() == ITestResult.SUCCESS) {
		   test.log(Status.PASS, "Test Case PASSED IS " + result.getName());
		  }
		 
		 }

		}
