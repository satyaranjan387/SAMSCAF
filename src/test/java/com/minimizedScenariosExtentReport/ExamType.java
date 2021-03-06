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

public class ExamType {

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
    	
       	htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/ExtentReport/ExamType-Report.html");
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
//       	driver.findElement(By.id("txtSMobileNo")).sendKeys(UserName);
//       	driver.findElement(By.id("txtSPwd")).sendKeys(Password);
////       	String cptcha = driver.findElement(By.xpath("//*[@id=\"lblCaptcha\"]")).getText();
////       	driver.findElement(By.id("txtRandno")).sendKeys(cptcha);
//       	driver.findElement(By.id("btnSIGNIN")).click();
   		
   		driver.findElement(By.xpath("//span[@class='menu-text']")).click();
   		
   		driver.findElement(By.xpath("//a[contains(text(),'CAF Apply')]")).click();
   	}
       
       @AfterTest
   	public void finish(){
   		
   		extent.flush();
   		driver.quit();
   	} 
	
	@Test(priority=0)
	public void ExamType_Annual() {
		test = extent.createTest("ExamType_Annual");
		// Basic Personal Details

		WebElement YOP=driver.findElement(By.id("ddlYOP"));
		YOP.sendKeys("2018");
		
		
		driver.findElement(By.id("rbtnAnnual")).click();
		
		driver.findElement(By.id("btnSave")).click();
		
		String actualText = driver.findElement(By.id("popup_message")).getText();
		
		if(actualText.equals("Roll Number cannot be left blank !"))
		 {
			fileone.setCellData(sheetName, "Status", 41 , "Pass");	
		 }
		
		 else
		 {
			 fileone.setCellData(sheetName, "Status", 41 , "Fail");
		 }
	
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualText, "Roll Number cannot be left blank !", "Test case failed");		
		
		driver.findElement(By.id("popup_ok")).click();
		
		
	}
	
	
	@Test(priority=1)
	public void Examtype_Supplementary() {
		test = extent.createTest("Examtype_Supplementary");
		
		driver.findElement(By.id("rbtnSuppl")).click();
		
		driver.findElement(By.id("btnSave")).click();
		
		String actualText2 = driver.findElement(By.xpath("//*[@id=\"popup_message\"]/strong")).getText();
		
		if(actualText2.equals("Roll Number cannot be left blank !"))
		 {
			fileone.setCellData(sheetName, "Status", 42 , "Pass");	
		 }
		
		 else
		 {
			 fileone.setCellData(sheetName, "Status", 42 , "Fail");
		 }
	
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualText2, "Roll Number cannot be left blank !", "Test case failed");		
		
		driver.findElement(By.id("popup_ok")).click();
		
	}
	
	
	@Test(priority=2)
	public void ChildrenOfMatrys_Apply() throws InterruptedException {
		test = extent.createTest("ChildrenOfMatrys_Apply");
		
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
			Thread.sleep(3000);
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
		Thread.sleep(3000);
		driver.findElement(By.id("ddlCDist")).sendKeys("Angul");
		Thread.sleep(3000);				
		driver.findElement(By.id("ddlCBlock")).sendKeys("ANGUL");
		Thread.sleep(3000);
		driver.findElement(By.id("txtCPS")).sendKeys("Bomikhal,Plot No-376");
		
		driver.findElement(By.id("rbtCoM")).click();
		
		driver.findElement(By.id("btnSave")).click();

		
		String actualText3 = driver.findElement(By.id("popup_message")).getText();
		
		if(actualText3.equals("English Mark cannot be left blank !"))
		 {
			fileone.setCellData(sheetName, "Status", 43 , "Pass");	
		 }
		
		 else
		 {
			 fileone.setCellData(sheetName, "Status", 43 , "Fail");
		 }
	
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualText3, "English Mark cannot be left blank !", "Test case failed");		
		
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
