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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.genericlib.Xls_AllMethods;

public class Dummy_Duplicate_electivesubject {
	
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
    	htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/ExtentReport/AutoValidation-Report.html");

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
	public void Duplicate_Firstandforthelectivesubject_notapply() throws InterruptedException
	{
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
		driver.findElement(By.id("ddl4thELE1")).sendKeys("ECONOMICS");
		Thread.sleep(2000);
		driver.findElement(By.id("btnSave")).click();
		Thread.sleep(2000);
		String actpopup = driver.findElement(By.xpath("popup_message")).getText();
		
		if(actpopup.equals("Elective & fourth elective choice1 cannot same"))
		 {
			fileone.setCellData(sheetName, "Status", 10 , "Fail");	
		 }
		
		 else
		 {
			 fileone.setCellData(sheetName, "Status", 10, "Pass");
		 }
		
		driver.findElement(By.xpath("//input[@id='popup_ok']")).click();
		Thread.sleep(2000);
		
	}
		@Test(priority=1)
		public void Duplicate_Firstandsecondelectivesubject_notapply() throws InterruptedException {
			
//			driver.findElement(By.xpath("//input[@id='popup_ok']")).click();
			
			driver.findElement(By.id("ddlCompulsory")).sendKeys("MIL ODIA");
			Thread.sleep(2000);
			driver.findElement(By.id("ddlELE1")).sendKeys("ECONOMICS");
			Thread.sleep(2000);
			driver.findElement(By.id("ddlELE2")).sendKeys("ECONOMICS");
			Thread.sleep(2000);
			
	
			String actpopup = driver.findElement(By.xpath("popup_message")).getText();
			
			if(actpopup.equals("Same subject can not opted more than once !"))
			 {
				fileone.setCellData(sheetName, "Status", 11 , "Fail");	
			 }
			
			 else
			 {
				 fileone.setCellData(sheetName, "Status", 11, "Pass");
			 }
			driver.findElement(By.id("popup_ok")).click();
			Thread.sleep(2000);
		}
		
		@Test(priority=2)
		public void Duplicate_Firstandthirdelectivesubject_notapply() throws InterruptedException {
			
			driver.findElement(By.id("ddlCompulsory")).sendKeys("MIL ODIA");
			Thread.sleep(2000);
			driver.findElement(By.id("ddlELE1")).sendKeys("ECONOMICS");
			Thread.sleep(2000);
			driver.findElement(By.id("ddlELE2")).sendKeys("POLITICAL SCIENCE");
			Thread.sleep(2000);
			driver.findElement(By.id("ddlELE3")).sendKeys("ECONOMICS");
			Thread.sleep(2000);
			
			driver.findElement(By.id("btnSave")).click();
			
			String actpopup = driver.findElement(By.xpath("popup_message")).getText();
			
			if(actpopup.equals("First or second or third elective subject cannot be same"))
			 {
				fileone.setCellData(sheetName, "Status", 12 , "Fail");	
			 }
			
			 else
			 {
				 fileone.setCellData(sheetName, "Status", 12, "Pass");
			 }
			driver.findElement(By.id("popup_ok")).click();
			Thread.sleep(2000);
		}
		
		@Test(priority=3)
		public void Verify_Duplicate_Fourthelectivesubject() throws InterruptedException {
			
			driver.findElement(By.id("ddlCompulsory")).sendKeys("MIL ODIA");
			Thread.sleep(2000);
			driver.findElement(By.id("ddlELE1")).sendKeys("ECONOMICS");
			Thread.sleep(2000);
			driver.findElement(By.id("ddlELE2")).sendKeys("HISTORY");
			Thread.sleep(2000);
			driver.findElement(By.id("ddlELE3")).sendKeys("POLITICAL SCIENCE");
			Thread.sleep(2000);
			driver.findElement(By.id("ddl4thELE1")).sendKeys("ECONOMICS");
			Thread.sleep(2000);
			
			driver.findElement(By.id("btnAddmore")).click();
			
			String actpopup = driver.findElement(By.xpath("popup_message")).getText();
			
			String cs = "Elective & fourth elective choice1 cannot same";
			
			if(actpopup.contentEquals(cs))
			{
				 fileone.setCellData(sheetName, "Status", 13, "Pass");
			}
			
			else
			{
				fileone.setCellData(sheetName, "Status", 13 , "Fail");	
			}
//			if(actpopup.equals("Elective & fourth elective choice1 cannot same"))
//			 {
//				fileone.setCellData(sheetName, "Status", 13 , "Fail");	
//			 }
//			
//			 else
//			 {
//				 fileone.setCellData(sheetName, "Status", 13, "Pass");
//			 }
			driver.findElement(By.id("popup_ok")).click();
			
			driver.quit();
		}
		
	

}
