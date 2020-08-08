package com.minimizedScenariosExtentReport;

import java.io.FileInputStream;
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

public class Uniqueelectivesubject {

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
    	htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/ExtentReport/Uniqueelectivesubject-Report.html");

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
	
	@AfterTest
	public void finish() {
		extent.flush();
		driver.quit();
	}
	
	@Test(priority=0)
	public void Accept_Uniqueelectivesubject() throws InterruptedException
	{
		test = extent.createTest("Uniqueelectivesubject");
		driver.findElement(By.xpath("//select[@id='ddlBoard']")).sendKeys("1 - BSE, ODISHA");
		
	    driver.findElement(By.id("ddlYOP")).sendKeys("2016");
	
		
		driver.findElement(By.id("rbtnAnnual")).click();
	
		
		driver.findElement(By.id("txtBoardRoll")).sendKeys("1000660");
		
		
		driver.findElement(By.id("ddlBloodGroup")).sendKeys("A+");
	
		Thread.sleep(4000);
		driver.findElement(By.id("ddlGender")).sendKeys("MALE");
		Thread.sleep(4000);
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
		
		driver.findElement(By.id("ddlCState")).sendKeys("1 - ODISHA");
		
		driver.findElement(By.id("ddlCDist")).sendKeys("Angul");
		Thread.sleep(3000);				
		driver.findElement(By.id("ddlCBlock")).sendKeys("ANGUL");
		Thread.sleep(3000);
		driver.findElement(By.id("txtCPS")).sendKeys("Bomikhal,Plot No-376");
		
		driver.findElement(By.id("txtCPC")).sendKeys("751010");
		
		driver.findElement(By.id("txtCTCode")).sendKeys("0674");
		
		driver.findElement(By.id("txtCTeleNo")).sendKeys("270406");
		
		driver.findElement(By.id("txtSocSci")).sendKeys("60");
		
		driver.findElement(By.id("txtScience")).sendKeys("60");

		driver.findElement(By.id("txtMath")).sendKeys("60");
	
		driver.findElement(By.id("txtEnglish")).sendKeys("60");
	
		driver.findElement(By.id("txtTotMark")).sendKeys("400");

		driver.findElement(By.id("txtMaxMark")).sendKeys("600");
	
		driver.findElement(By.id("ddlGrade")).sendKeys("A2");

		driver.findElement(By.id("rbtCompartmentalY")).click();
		
		driver.findElement(By.id("ddlCompSubject1")).sendKeys("MIL");
		
		driver.findElement(By.id("txtCompFMark1")).sendKeys("20");
		
		driver.findElement(By.id("txtCompPMark1")).sendKeys("25");
		
		driver.findElement(By.id("ddlCompSubject2")).sendKeys("English");
		
		driver.findElement(By.id("txtCompFMark2")).sendKeys("20");

		driver.findElement(By.id("txtCompPMark2")).sendKeys("25");
		
		driver.findElement(By.id("ddlFOcu")).sendKeys("BUSINESS");
		
		driver.findElement(By.id("ddlMOcu")).sendKeys("BUSINESS");;
	
		driver.findElement(By.id("ddlAIncome")).sendKeys("0 - 1,00,000");
		
		driver.findElement(By.id("txtacno")).sendKeys("4444444444444444");

		driver.findElement(By.id("txtifsc")).sendKeys("SBIN0012021");
		
		driver.findElement(By.id("txtmicr")).sendKeys("888888888");
	
//		driver.findElement(By.id("txtBankname")).sendKeys("SBI");
//		
//		driver.findElement(By.id("txtBrname")).sendKeys("SBI");
	
		driver.findElement(By.id("txtschname")).sendKeys("VSK");
		
		driver.findElement(By.id("txtschloc")).sendKeys("BBSR");
		
		driver.findElement(By.id("ddlinstDistrict")).sendKeys("ANGUL");
	
		driver.findElement(By.id("ddlYOJ")).sendKeys("1995");
		
		driver.findElement(By.id("ddlCollegeDistrict")).sendKeys("ANGUL");
	
		driver.findElement(By.id("ddlCollege")).sendKeys("BAPUJI HIGHER SECONDARY SCHOOL, CHHENDIPADA");
		Thread.sleep(2000);
		driver.findElement(By.id("ddlStream")).sendKeys("ARTS");
		Thread.sleep(2000);
		driver.findElement(By.id("ddlCompulsory")).sendKeys("MIL ODIA");
		Thread.sleep(2000);
		driver.findElement(By.id("ddlELE1")).sendKeys("ECONOMICS");
		Thread.sleep(2000);
		driver.findElement(By.id("ddlELE2")).sendKeys("HISTORY");
		Thread.sleep(2000);
		driver.findElement(By.id("ddlELE3")).sendKeys("POLITICAL SCIENCE");
		Thread.sleep(2000);
		driver.findElement(By.id("ddl4thELE1")).sendKeys("LANGUAGE ODIA");

		driver.findElement(By.id("btnSave")).click();
		
		String electiveHeading = driver.findElement(By.id("lbloptions")).getText();
		
		if(electiveHeading.equals("Enter here for 2nd Option"))
			 {
				fileone.setCellData(sheetName, "Status", 14 , "Fail");	
			 }
			
			 else
			 {
				 fileone.setCellData(sheetName, "Status", 14, "Pass");
			 }
		
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(electiveHeading, "Enter here for 2nd Option");	
    	
		driver.findElement(By.id("popup_ok")).click();	
		
	}
	
	
	@Test(priority=1)
	public void Accept_Uniqueforthelectivesubject() {
		
		test = extent.createTest("Uniqueforthelectivesubject");
		driver.findElement(By.id("btnSave")).click();
		String electiveHeading = driver.findElement(By.id("lbloptions")).getText();
		
		if(electiveHeading.equals("Enter here for 2nd Option"))
			 {
				fileone.setCellData(sheetName, "Status", 15 , "Fail");	
			 }
			
			 else
			 {
				 fileone.setCellData(sheetName, "Status", 15 , "Pass");
			 }
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(electiveHeading, "Enter here for 2nd Option");	
    	
		driver.findElement(By.id("popup_ok")).click();
		
	}
	
	@Test(priority=2)
	public void Verify_Accepting_Duplicate_10thdata() {
		
		test = extent.createTest("Duplicate_10thdata");
		driver.findElement(By.xpath("//select[@id='ddlBoard']")).sendKeys("1 - BSE, ODISHA");
		
	    driver.findElement(By.id("ddlYOP")).sendKeys("2016");
	
		
		driver.findElement(By.id("rbtnAnnual")).click();
	
		
		driver.findElement(By.id("txtBoardRoll")).sendKeys("1000660");
		driver.findElement(By.id("btnSave")).click();
		
		String electiveHeading1 = driver.findElement(By.id("lbloptions")).getText();
		if(electiveHeading1.equals("Enter here for 2nd Option"))
			 {
				fileone.setCellData(sheetName, "Status", 16 , "Fail");	
			 }
			
			 else
			 {
				 fileone.setCellData(sheetName, "Status", 16 , "Pass");
			 }
		
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(electiveHeading1, "Enter here for 2nd Option");	
    	
		driver.findElement(By.id("popup_ok")).click();
	
		
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
