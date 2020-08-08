package com.minimizedScenariosExtentReport;

import java.io.File;
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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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
//import com.genericlib.Constants;

import com.genericlib.Xls_AllMethods;
import com.testscenariosSmokeTest.Testc;

public class Mark_Grade {
	
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
    	htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/ExtentReport/Mark_Grade-Report.html");
    	htmlReporter.loadXMLConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
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
	public void finish(){
		
		extent.flush();
		driver.quit();
	} 
    
	@Test(priority=0)
	public void Mark_Grade_BPEKerela() {

		test = extent.createTest("Mark_Grade_BPEKerela");
		// Basic Personal Details
		
		driver.findElement(By.id("ddlBoard")).sendKeys("22 - BPE, KERALA");

		WebElement YOP=driver.findElement(By.id("ddlYOP"));
		YOP.sendKeys("2018");
		
		
		driver.findElement(By.id("rbtnAnnual")).click();
				
		String actText = driver.findElement(By.xpath("//table[@id='tblKERALA']//strong[contains(text(),'Grade')]")).getText();
		
		if(actText.equals("Grade"))
		 {
			fileone.setCellData(sheetName, "Status", 44 , "Pass");	
		 }
		
		 else
		 {
			 fileone.setCellData(sheetName, "Status", 44 , "Fail");
		 }
	
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actText, "Grade", "Test Failed");
	}
	
	@Test(priority=1)
	public void Mark_Grade_BSEAndhrapradesh() {
		
		test = extent.createTest("Mark_Grade_BSEAndhrapradesh");
		
		driver.findElement(By.id("ddlBoard")).sendKeys("11 - BSE, ANDHRA PRADESH");
		
		WebElement YOP=driver.findElement(By.id("ddlYOP"));
		YOP.sendKeys("2018");
		
		String actText1 = driver.findElement(By.xpath("//strong[contains(text(),'CGPA')]")).getText();
		
		if(actText1.equals("CGPA"))
		 {
			fileone.setCellData(sheetName, "Status", 45 , "Pass");	
		 }
		
		 else
		 {
			 fileone.setCellData(sheetName, "Status", 45 , "Fail");
		 }
	
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actText1, "CGPA", "Test Failed");
	}

	
	@Test(priority=2)
	public void Mark_Grade_BSEboard() {
		
		test = extent.createTest("Mark_Grade_BSEboard");
		
		driver.findElement(By.id("ddlBoard")).sendKeys("1 - BSE, ODISHA");
		
		String actText2 = driver.findElement(By.xpath("//table[@id='tblBSE']//strong[contains(text(),'Maximum Mark')]")).getText();
		System.out.println(actText2);
		if(actText2.equals("Maximum Mark"))
		 {
			fileone.setCellData(sheetName, "Status", 46 , "Pass");	
		 }
		
		 else
		 {
			 fileone.setCellData(sheetName, "Status", 46 , "Fail");
		 }
	
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actText2, "Maximum Mark", "Test Failed");
	}
	
	
	@Test(priority=3)
	public void Mark_Grade_CBSEBoard() throws Exception {
		
		test = extent.createTest("Mark_Grade_CBSEBoard");
		
		driver.findElement(By.id("ddlBoard")).sendKeys("2 - CBSE, NEW DELHI");
		
		//WebElement YOP=driver.findElement(By.id("ddlYOP"));
		//YOP.sendKeys("2018");
		
		Select YOP=new Select(driver.findElement(By.id("ddlYOP")));
		YOP.selectByValue("2018");
		
//		WebDriverWait wait = new WebDriverWait(driver,30);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[contains(text(),'CGPA')]")));
//		
		String actText3 = driver.findElement(By.xpath("//*[@id=\"tblBSE\"]/tbody/tr[1]/td[1]/strong")).getText();
		System.out.println(actText3);
		if(actText3.equals("Maximum Mark"))
		 {
			fileone.setCellData(sheetName, "Status", 47 , "Pass");	
		 }
		
		 else
		 {
			 fileone.setCellData(sheetName, "Status", 47 , "Fail");
		 }
	
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actText3, "Maximum Mark", "Test Failed");
	
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
