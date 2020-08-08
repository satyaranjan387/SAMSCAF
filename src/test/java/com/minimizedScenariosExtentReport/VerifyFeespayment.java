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

public class VerifyFeespayment {
	
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
	public void Setup() throws IOException
	{
    	htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/ExtentReport/VerifyPWD_Feespayment-Report.html");
    	
		htmlReporter.config().setDocumentTitle("Automation CAF"); 
		htmlReporter.config().setReportName("Functional Testing"); 
		
		htmlReporter.config().setTheme(Theme.DARK);
		  
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		extent.setSystemInfo("Host name", "Test Server");
		extent.setSystemInfo("Environment", "QC");
		
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
////    	String cptcha = driver.findElement(By.xpath("//*[@id=\"lblCaptcha\"]")).getText();
////    	driver.findElement(By.id("txtRandno")).sendKeys(cptcha);
//    	driver.findElement(By.id("btnSIGNIN")).click();
		
		driver.findElement(By.xpath("//span[@class='menu-text']")).click();
		
		driver.findElement(By.xpath("//a[contains(text(),'CAF Apply')]")).click();
	}
    
    @Test(priority=0)
    public void VerifyTransgender_Feespayment() throws InterruptedException, FileNotFoundException {
    	
    	test = extent.createTest("Transgender_Feespayment");
    	
		
		driver.findElement(By.xpath("//select[@id='ddlBoard']")).sendKeys("1 - BSE, ODISHA");
		
	    driver.findElement(By.id("ddlYOP")).sendKeys("2016");
	
		
		driver.findElement(By.id("rbtnAnnual")).click();
	
		
		driver.findElement(By.id("txtBoardRoll")).sendKeys("1000660");
		
		
		driver.findElement(By.id("ddlBloodGroup")).sendKeys("A+");
		Thread.sleep(4000);
		
		driver.findElement(By.id("ddlGender")).sendKeys("TRANSGENDER");
		Thread.sleep(4000);
		
		String actualPopup = driver.findElement(By.id("lblFees")).getText();
		System.out.println(actualPopup);
		
		if(actualPopup.equals("Application Fees = Rs 0"))
			
		{
			fileone.setCellData(sheetName, "Status", 50 , "Pass");	
		 }
		
		 else
		 {
			 fileone.setCellData(sheetName, "Status", 50 , "Fail");
		 }
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualPopup, "Application Fees = Rs 0", "Test Failed");
		
		driver.findElement(By.id("ddlGender")).sendKeys("MALE");
		Thread.sleep(4000);
			
	    }
	    
    	@Test(priority=1)
	    public void VerifyORPHAN_Feespayment() throws InterruptedException {
	    
    	test = extent.createTest("ORPHAN_Feespayment");	
    	
    	driver.findElement(By.id("txtApplName")).sendKeys("Indu Rath");
		
		driver.findElement(By.id("txtFatherName")).sendKeys("Rajesh Rath");
		
		driver.findElement(By.id("txtMotherName")).sendKeys("Purnima Rath");
		
		driver.findElement(By.id("ddlReligion")).sendKeys("HINDU");
		
		//Leaner Framework
         
		String mainWindowTitle 	= driver.getTitle();
		System.out.println("Length of main window title  :" + mainWindowTitle.length());
		String mainWindowName 	= driver.getWindowHandle();
		System.out.println("Main Window Title : "  + mainWindowTitle);
		System.out.println("Main Window Name : "  + mainWindowName);
		
		driver.findElement(By.id("ImgAppl")).click();
		
		Set<String> windows = driver.getWindowHandles();
		for(String w : windows)
		{
			driver.switchTo().window(w);

		if(driver.getCurrentUrl().equalsIgnoreCase("http://o.samsodisha.gov.in/ONLINE_CAF/UploadPopUpJr.aspx"))
		  {
			driver.findElement(By.xpath("//*[@id='imgUpload']")).sendKeys("E:/SAMS_Junior/dummy-image.png");
			
		    driver.findElement(By.name("upload")).click();
			Thread.sleep(4000);
			driver.findElement(By.cssSelector("#form1 > div:nth-child(4) > table > tbody > tr:nth-child(5) > td > input:nth-child(1)")).click();			
		  }
		}
		driver.switchTo().window(mainWindowName);
		
		driver.findElement(By.id("ddlDay")).sendKeys("9");
				
		driver.findElement(By.id("ddlMonth")).sendKeys("SEPTEMBER");
				
		driver.findElement(By.id("ddlYear")).sendKeys("1998");
				
		driver.findElement(By.id("ddlNationality")).sendKeys("INDIAN");
					
		driver.findElement(By.id("ddlMt")).sendKeys("ODIA");
		
		driver.findElement(By.id("txtadhar")).sendKeys("111111111209");
		
		driver.findElement(By.id("txtParentMob")).sendKeys("7978329514");
		
		driver.findElement(By.id("chkorph")).click();
		Thread.sleep(2000);
		String actualPopup2 = driver.findElement(By.xpath("//*[@id=\"lblFees\"]")).getText();
		System.out.println(actualPopup2);
		
		if(actualPopup2.equals("Application Fees = Rs 0"))
			
		{
			fileone.setCellData(sheetName, "Status", 51 , "Pass");	
		 }
		
		 else
		 {
			 fileone.setCellData(sheetName, "Status", 51 , "Fail");
		 }
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualPopup2, "Application Fees = Rs 0", "Test Failed");
		
		driver.findElement(By.id("chkorph")).click();
		

    }
    	
    	
    	@Test(priority=2)
    	public void VerifyST_Feespayment() throws InterruptedException {
    	
    	test = extent.createTest("VerifyST_Feespayment");		
    		
    	driver.findElement(By.id("ddlCState")).sendKeys("1 - ODISHA");
		Thread.sleep(3000);
		driver.findElement(By.id("ddlCDist")).sendKeys("Angul");
		Thread.sleep(3000);				
		driver.findElement(By.id("ddlCBlock")).sendKeys("ANGUL");
		Thread.sleep(3000);
		driver.findElement(By.id("txtCPS")).sendKeys("Bomikhal,Plot No-376");
		
		driver.findElement(By.id("rbtST")).click();
		Thread.sleep(2000);
		String actualPopup3 = driver.findElement(By.id("lblFees")).getText();
		
		
		if(actualPopup3.equals("Application Fees = Rs 200"))
			
		{
			fileone.setCellData(sheetName, "Status", 52 , "Pass");	
		 }
		
		 else
		 {
			 fileone.setCellData(sheetName, "Status", 52 , "Fail");
		 }
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualPopup3, "Application Fees = Rs 200", "Test Failed");
    	}

    	@Test(priority=3)
    	public void VerifySC_Feespayment() throws InterruptedException {
		
    	test = extent.createTest("SC_Feespayment");	
    		
		driver.findElement(By.id("rbtSC")).click();
		Thread.sleep(2000);
		String actualPopup4 = driver.findElement(By.id("lblFees")).getText();
		
		if(actualPopup4.equals("Application Fees = Rs 200"))
			
		{
			fileone.setCellData(sheetName, "Status", 53 , "Pass");	
		 }
		
		 else
		 {
			 fileone.setCellData(sheetName, "Status", 53 , "Fail");
		 }
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualPopup4, "Application Fees = Rs 200", "Test Failed");
		
    	}
    	
    	
    	@Test(priority=4)
    	public void VerifyOBC_Feespayment() throws InterruptedException {
    		
    		test = extent.createTest("VerifyOBC_Feespayment");
    		
    		driver.findElement(By.id("rbtnOBC")).click();
    		Thread.sleep(2000);
    		String actualPopup4 = driver.findElement(By.id("lblFees")).getText();
    		
    		if(actualPopup4.equals("Application Fees = Rs 300"))
    			
    		{
    			fileone.setCellData(sheetName, "Status", 54 , "Pass");	
    		 }
    		
    		 else
    		 {
    			 fileone.setCellData(sheetName, "Status", 54 , "Fail");
    		 }
    		SoftAssert softAssert = new SoftAssert();
    		softAssert.assertEquals(actualPopup4, "Application Fees = Rs 300", "Test Failed");
    		
     	}
    	
    	@Test(priority=5)
    	public void Verify_SEBC_Feespayment() throws InterruptedException {
    		
    		test = extent.createTest("Verify_SEBC_Feespayment");
    		
    		driver.findElement(By.id("rbtOther")).click();
    		Thread.sleep(2000);
    		String actualPopup4 = driver.findElement(By.id("lblFees")).getText();
    		
    		if(actualPopup4.equals("Application Fees = Rs 300"))
    			
    		{
    			fileone.setCellData(sheetName, "Status", 55 , "Pass");	
    		 }
    		
    		 else
    		 {
    			 fileone.setCellData(sheetName, "Status", 55 , "Fail");
    		 }
    		SoftAssert softAssert = new SoftAssert();
    		softAssert.assertEquals(actualPopup4, "Application Fees = Rs 300", "Test Failed");
    		
     	}
    	
    	@Test(priority=6)
    	public void VerifyGeneral_Feespayment() throws InterruptedException {
    		
    		test = extent.createTest("VerifyGeneral_Feespayment");
    		
    		driver.findElement(By.id("rbtGeneral")).click();
    		Thread.sleep(2000);
    		String actualPopup4 = driver.findElement(By.id("lblFees")).getText();
    		
    		if(actualPopup4.equals("Application Fees = Rs 300"))
    			
    		{
    			fileone.setCellData(sheetName, "Status", 56 , "Pass");	
    		 }
    		
    		 else
    		 {
    			 fileone.setCellData(sheetName, "Status", 56 , "Fail");
    		 }
    		SoftAssert softAssert = new SoftAssert();
    		softAssert.assertEquals(actualPopup4, "Application Fees = Rs 300", "Test Failed");
    		
     	}
    	
    	
    	@Test(priority=7)
    	public void VerifyPWD_Feespayment() throws InterruptedException {
    		
    		test = extent.createTest("VerifyPWD_Feespayment");
    		
    		driver.findElement(By.id("chkPHOH")).click();
    		Thread.sleep(3000);
    		String actualPopup5 = driver.findElement(By.id("lblFees")).getText();
   
    		
    		if(actualPopup5.equals("Application Fees = Rs 0"))
    			
    		{
    			fileone.setCellData(sheetName, "Status", 57 , "Pass");	
    		 }
    		
    		 else
    		 {
    			 fileone.setCellData(sheetName, "Status", 57 , "Fail");
    		 }
    		SoftAssert softAssert = new SoftAssert();
    		softAssert.assertEquals(actualPopup5, "Application Fees = Rs 0", "Test Failed");
    		
    		driver.findElement(By.id("chkPHOH")).click();
    		Thread.sleep(3000);
     	}

    	
    	@Test(priority=8)
    	public void ExServiceman_Apply() {
    		
    		test = extent.createTest("ExServiceman_Apply");
    		
    		driver.findElement(By.id("rbtESM")).click();
    		
			driver.findElement(By.id("btnSave")).click();
	
    		String Actmsg = driver.findElement(By.xpath("//*[@id=\"popup_message\"]/strong")).getText();
			System.out.println(Actmsg);
			// Assert.assertEquals(previousAddress, ActAddress, "Duplicated Address not accepting");
			 if(Actmsg.equals("English Mark cannot be left blank !"))
			 {
				fileone.setCellData(sheetName, "Status", 58 , "Pass");	
			 }
			
			 else
			 {
				 fileone.setCellData(sheetName, "Status", 58 , "Fail");
			 }	
			 
			 SoftAssert softAssert = new SoftAssert();
			 softAssert.assertEquals(Actmsg, "English Mark cannot be left blank !");
			 driver.findElement(By.id("popup_ok")).click();
    		
     	}
    	
    	
    	@Test(priority=9)
    	public void SDP_Apply() {
    		
    		test = extent.createTest("SDP_Apply");
    		
    		driver.findElement(By.id("rbtSDP")).click();
    		
			driver.findElement(By.id("btnSave")).click();
	
    		String Actmsg = driver.findElement(By.id("popup_message")).getText();
			System.out.println(Actmsg);
			// Assert.assertEquals(previousAddress, ActAddress, "Duplicated Address not accepting");
			 if(Actmsg.equals("English Mark cannot be left blank !"))
			 {
				fileone.setCellData(sheetName, "Status", 59 , "Pass");	
			 }
			
			 else
			 {
				 fileone.setCellData(sheetName, "Status", 59 , "Fail");
			 }	
			 
			 SoftAssert softAssert = new SoftAssert();
			 softAssert.assertEquals(Actmsg, "English Mark cannot be left blank !");
			 driver.findElement(By.id("popup_ok")).click();
    		
			 
     	}
    		
    	@AfterTest
    	public void finish(){
    		
    		extent.flush();
    		driver.quit();
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
