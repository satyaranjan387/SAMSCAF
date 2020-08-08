package com.minimizedScenariosExtentReport;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
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

//@Listeners(com.genericlib.CustomListner.class)
public class Verify_Duplicate {
	@SuppressWarnings("deprecation")
	public ExtentHtmlReporter htmlReporter;
	static Xls_AllMethods fileone = new Xls_AllMethods("C:\\Users\\satyaranjan.m\\eclipse-workspace\\JuniorForm\\JuniorFormMappingData.xlsx");	
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
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/ExtentReport/Verify_Duplicate-Report.html");
		htmlReporter.loadXMLConfig(new File(System.getProperty("user.dir")+"/extent-config.xml"));
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
		
	}
	
	@AfterTest
	public void finish() {
		extent.flush();
		driver.quit();
	}
	
//	@AfterMethod
//	public void ereport() {
//		
//		extent.flush();
//	}
	
	@Test(priority=0)
	public void Accept_DuplicateAadharnumber_Differentuser() throws InterruptedException
	{
		test = extent.createTest("DuplicateAadharnumber");
		

		driver.findElement(By.id("txtadhar")).sendKeys("111111111209");
		
		driver.findElement(By.id("btnSave")).click();
		
		String actualPopup = driver.findElement(By.id("popup_message")).getText();
		System.out.println(actualPopup);
		
		if(actualPopup.contains("Parent or Gaurdian Mobile No cannot be left blank !"))
			
		{
			fileone.setCellData(sheetName, "Status", 2 , "Pass");	
		 }
		
		 else
		 {
			 fileone.setCellData(sheetName, "Status", 2, "Fail");
		 }
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualPopup, "Parent or Gaurdian Mobile No cannot be left blank !", "Test Failed");
		
		driver.findElement(By.id("popup_ok")).click();
		}
	
		@Test(priority=1)
		public void  Accept_Duplicate_Guardianmobilenumber() throws InterruptedException {
			
			test = extent.createTest("Duplicate_Guardianmobilenumber");
			driver.findElement(By.id("txtParentMob")).sendKeys("7978329514");
			
			driver.findElement(By.id("btnSave")).click();
			
			String ActPGurdmobileno = driver.findElement(By.id("popup_message")).getText();
			System.out.println(ActPGurdmobileno);
			
			if(ActPGurdmobileno.equals("Please select State !"))
			 {
				fileone.setCellData(sheetName, "Status", 3 , "Pass");	
			 }
			
			 else
			 {
				 fileone.setCellData(sheetName, "Status", 3 , "Fail");
			 }
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertEquals(ActPGurdmobileno, "select State !", "Test Failed");
//			Assert.assertEquals(ActPGurdmobileno, "select State !", "Test Failed");
			
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"popup_ok\"]")).click();
		}
		
		@Test(priority=2)
		public void sameNumGuardianMobile() throws InterruptedException {
			test = extent.createTest("sameNumGuardianMobile");
			driver.findElement(By.id("txtParentMob")).clear();
			Thread.sleep(2000);	
			driver.findElement(By.id("txtParentMob")).sendKeys("7978329514");
			driver.findElement(By.id("btnSave")).click();
			
			String ActSamemobileno = driver.findElement(By.id("popup_message")).getText();
			
			System.out.println(ActSamemobileno);
			if(ActSamemobileno.equals("Please select State !"))
			 {
				fileone.setCellData(sheetName, "Status", 4 , "Pass");	
			 }
			
			 else
			 {
				 fileone.setCellData(sheetName, "Status", 4 , "Fail");
			 }
			
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertEquals(ActSamemobileno, "Please select State !", "Test Failed");
			driver.findElement(By.id("popup_ok")).click();
		 }
		
		@Test(priority=3)
		public void Accept_DuplicateAddress_Differentuser() throws InterruptedException {
			test = extent.createTest("DuplicateAddress");
			
//			driver.findElement(By.id("txtParentMob")).sendKeys("7978329514");
			Thread.sleep(2000);	
			driver.findElement(By.id("ddlCState")).sendKeys("1 - ODISHA");
			Thread.sleep(2000);				
			driver.findElement(By.id("ddlCDist")).sendKeys("Angul");
			Thread.sleep(2000);	
			driver.findElement(By.id("ddlCBlock")).sendKeys("ANGUL");
			Thread.sleep(2000);	
			driver.findElement(By.id("txtCPS")).sendKeys("Bomikhal,Plot No-376");
			Thread.sleep(2000);
			driver.findElement(By.id("btnSave")).click();
			Thread.sleep(2000);	
			
			String ActAddress = driver.findElement(By.id("popup_message")).getText();
			System.out.println(ActAddress);
			// Assert.assertEquals(previousAddress, ActAddress, "Duplicated Address not accepting");
			 if(ActAddress.contains("English Mark cannot be left blank !"))
			 {
				fileone.setCellData(sheetName, "Status", 5 , "Pass");	
			 }
			
			 else
			 {
				 fileone.setCellData(sheetName, "Status", 5, "Fail");
			 }	
			 
			 SoftAssert softAssert = new SoftAssert();
			 softAssert.assertEquals(ActAddress, "Mark cannot be left blank !");
			 driver.findElement(By.id("popup_ok")).click();
		}
		
		
		@Test(priority=4)
		public void Accept_Duplicate_Telephonumber() throws InterruptedException {
			test = extent.createTest("Duplicate_Telephonumber"); 
		    driver.findElement(By.id("txtCPC")).sendKeys("751010");
			
			driver.findElement(By.id("txtCTCode")).sendKeys("0674");
			
			driver.findElement(By.id("txtCTeleNo")).sendKeys("270406");
			Thread.sleep(2000);	
			driver.findElement(By.id("btnSave")).click();
			Thread.sleep(2000);	
			String ActTeleno = driver.findElement(By.id("popup_message")).getText();
			
			 
			// Assert.assertEquals(previousTeleno, ActTeleno , "Duplicated number not accepting");
			 
			 System.out.println(ActTeleno);
			 if(ActTeleno.equals("English Mark cannot be left blank !"))
			 {
				fileone.setCellData(sheetName, "Status", 6 , "Pass");	
			 }
			
			 else
			 {
				 fileone.setCellData(sheetName, "Status", 6, "Fail");
			 }
			 
			 SoftAssert softAssert = new SoftAssert();
			 softAssert.assertEquals(ActTeleno, "English Mark cannot be left blank !");
			 driver.findElement(By.id("popup_ok")).click();
			}

		@Test(priority=5)
		public void Accept_samemobileno_telephonenumber() {
			test = extent.createTest("samemobileno_telephonenumber");
			driver.findElement(By.id("txtCTeleNo")).clear();
			driver.findElement(By.id("txtCTeleNo")).sendKeys("9776257875");
			
			 String ActTeleno = driver.findElement(By.id("txtCTeleNo")).getText();
			// Assert.assertEquals(previousTeleno, ActTeleno , "Duplicated number not accepting");
			 
			 System.out.println(ActTeleno);
			 
			 if(ActTeleno.equals("9776257875"))
			 {
				fileone.setCellData(sheetName, "Status", 7 , "Fail");	
			 }
			
			 else
			 {
				 fileone.setCellData(sheetName, "Status", 7, "Pass");
			 }
			 SoftAssert softAssert = new SoftAssert();
			 softAssert.assertEquals(ActTeleno, "9776257875");
			}
		
		
			@Test(priority=6)
			public void Duplicate_Compartmental_Pass_Subject() throws InterruptedException {
				test = extent.createTest("Duplicate_Compartmental");
//				driver.findElement(By.id("txtCEmail")).sendKeys("test111@gmail.com");
	
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
				
				driver.findElement(By.id("ddlCompSubject2")).sendKeys("MIL");
				
				driver.findElement(By.id("txtCompFMark2")).sendKeys("20");
		
				driver.findElement(By.id("txtCompPMark2")).sendKeys("25");
				
				driver.findElement(By.id("btnSave")).click();
				Thread.sleep(2000);
				String wbs2 = driver.findElement(By.xpath("//*[@id=\"popup_message\"]/strong")).getText();
				//OR;
				System.out.println(wbs2);
				
				if(wbs2.endsWith("twice for Compartment subject"))
				 {
					fileone.setCellData(sheetName, "Status", 8 , "Pass");	
				 }
				
				 else
				 {
					 fileone.setCellData(sheetName, "Status", 8, "Fail");
				 }
				
				SoftAssert softAssert = new SoftAssert();
				softAssert.assertEquals(wbs2, "You cannot enter same subject\\r\\n\" + \r\n" + 
						"						\"twice for Compartment subject", "Test Failed");
				
				driver.findElement(By.id("popup_ok")).click();
				
				driver.findElement(By.id("ddlCompSubject2")).sendKeys("ENGLISH");
				
				driver.findElement(By.id("ddlFOcu")).sendKeys("BUSINESS");
				
				driver.findElement(By.id("ddlMOcu")).sendKeys("BUSINESS");;
			
				driver.findElement(By.id("ddlAIncome")).sendKeys("0 - 1,00,000");
				
				driver.findElement(By.id("txtacno")).sendKeys("4444444444444444");
	
				driver.findElement(By.id("txtifsc")).sendKeys("SBIN0012021");
				
				driver.findElement(By.id("txtmicr")).sendKeys("888888888");
			
//				driver.findElement(By.id("txtBankname")).sendKeys("SBI");
//				
//				driver.findElement(By.id("txtBrname")).sendKeys("SBI");
			
				driver.findElement(By.id("txtschname")).sendKeys("VSK");
				
				driver.findElement(By.id("txtschloc")).sendKeys("BBSR");
				
				driver.findElement(By.id("ddlinstDistrict")).sendKeys("ANGUL");
			
				driver.findElement(By.id("ddlYOJ")).sendKeys("1995");
				
				driver.findElement(By.id("ddlCollegeDistrict")).sendKeys("ANGUL");
				Thread.sleep(2000);
				driver.findElement(By.id("ddlCollege")).sendKeys("BAPUJI HIGHER SECONDARY SCHOOL, CHHENDIPADA");
				Thread.sleep(2000);
				driver.findElement(By.id("ddlStream")).click();
				Thread.sleep(2000);
			}
			
			
			@SuppressWarnings("unlikely-arg-type")
			@Test(priority=7)
			public void CheckDuplicacy_College_Stream() throws InterruptedException {
				test = extent.createTest("Duplicacy_College_Stream");
		
				Select select = new Select(driver.findElement(By.id("ddlStream"))); 
				
				List<WebElement> li = select.getOptions();
				Set<String> listNames = new HashSet<String>(li.size());
				System.out.println(li);
				
				for (WebElement w : li) {
			        listNames.add(w.getText().trim());
			    }
				 
				 
				if(li.size()== listNames.size())
				 {
					fileone.setCellData(sheetName, "Status", 9 , "Pass");	
				 }
				 else
				 {
					 fileone.setCellData(sheetName, "Status", 9, "Fail");
				 }
				
				SoftAssert softAssert = new SoftAssert();
				softAssert.assertEquals(li, listNames, "Test Failed");
				driver.findElement(By.id("ddlStream")).sendKeys("ARTS");
				Thread.sleep(3000);
				
				
				
			}
			
			@Test(priority=8)
			public void Duplicate_Firstandforthelectivesubject_notapply() throws InterruptedException {
				test = extent.createTest("Firstandforthelectivesubject_notapply");
				driver.findElement(By.id("ddlCompulsory")).sendKeys("MIL ODIA");
				Thread.sleep(2000);
				driver.findElement(By.id("ddlELE1")).sendKeys("ECONOMICS");
				Thread.sleep(2000);
				driver.findElement(By.id("ddlELE2")).sendKeys("HISTORY");
				Thread.sleep(2000);
				driver.findElement(By.id("ddlELE3")).sendKeys("POLITICAL SCIENCE");
				Thread.sleep(2000);
				driver.findElement(By.id("ddl4thELE1")).sendKeys("ECONOMICS");
				Thread.sleep(3000);
				
				driver.findElement(By.id("btnSave")).click();
				
				
				String actpopup = driver.findElement(By.xpath("//*[@id=\"popup_message\"]/strong")).getText();
				System.out.println(actpopup);
				Thread.sleep(2000);
				if(actpopup.equals("Elective & fourth elective choice1 cannot same"))
				 {
					fileone.setCellData(sheetName, "Status", 10 , "Pass");	
				 }
				
				 else
				 {
					 fileone.setCellData(sheetName, "Status", 10, "Fail");
				 }
				SoftAssert softAssert = new SoftAssert();
				 softAssert.assertEquals(actpopup, "Elective & fourth elective choice1 cannot same");
				driver.findElement(By.xpath("//*[@id=\"popup_ok\"]")).click();
				Thread.sleep(2000);
			}
				
				
			@Test(priority=9)
			public void Duplicate_Firstandsecondelectivesubject_notapply() throws InterruptedException {
				
				test = extent.createTest("Firstandsecondelectivesubject_notapply");
				
				driver.findElement(By.id("ddlCompulsory")).sendKeys("MIL ODIA");
				
				driver.findElement(By.id("ddlELE1")).sendKeys("ECONOMICS");
				
				driver.findElement(By.id("ddlELE2")).sendKeys("ECONOMICS");
				
//				driver.findElement(By.id("btnSave")).click();
				
				Thread.sleep(2000);
				
				String actpopup1 = driver.findElement(By.xpath("//*[@id=\"popup_message\"]/strong")).getText();
				System.out.println(actpopup1);
				if(actpopup1.equals("Same subject can not opted more than once !"))
				 {
					fileone.setCellData(sheetName, "Status", 11 , "Pass");	
				 }
				
				 else
				 {
					 fileone.setCellData(sheetName, "Status", 11, "Fail");
				 }
				SoftAssert softAssert = new SoftAssert();
				 softAssert.assertEquals(actpopup1, "Same subject can not opted more than once !");
				//driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[2]/input[1]")).click();
				 Thread.sleep(2000);
				 driver.findElement(By.xpath("//*[@id=\"popup_ok\"]")).click();
				Thread.sleep(2000);
				
				
			}
			
			@Test(priority=10)
			public void Duplicate_Firstandthirdelectivesubject_notapply() throws InterruptedException {
				test = extent.createTest("Firstandthirdelectivesubject_notapply");
				driver.findElement(By.id("ddlCompulsory")).sendKeys("MIL ODIA");
				Thread.sleep(2000);
				driver.findElement(By.id("ddlELE1")).sendKeys("HISTORY");
				Thread.sleep(2000);
				driver.findElement(By.id("ddlELE2")).sendKeys("POLITICAL SCIENCE");
				Thread.sleep(2000);
				driver.findElement(By.id("ddlELE3")).sendKeys("HISTORY");
				Thread.sleep(2000);
				
				driver.findElement(By.id("btnSave")).click();
				
				String actpopup2 = driver.findElement(By.xpath("//*[@id=\"popup_message\"]/strong")).getText();
				System.out.println(actpopup2);
				
				if(actpopup2.equals("First or second or third elective subject cannot be same"))
				 {
					fileone.setCellData(sheetName, "Status", 12 , "Pass");	
				 }
				
				 else
				 {
					 fileone.setCellData(sheetName, "Status", 12, "Fail");
				 }
				SoftAssert softAssert = new SoftAssert();
				 softAssert.assertEquals(actpopup2, "First or second or third elective subject cannot be same");
				driver.findElement(By.cssSelector("#popup_ok")).click();
				Thread.sleep(2000);          
			}
			
			
			@Test(priority=11)
			public void Verify_Duplicate_Fourthelectivesubject() throws InterruptedException {
				test = extent.createTest("Fourthelectivesubject");
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
				
				String actpopup3 = driver.findElement(By.xpath("//*[@id=\"popup_message\"]/strong")).getText();
				System.out.println(actpopup3);
				
				if(actpopup3.equals("Elective preference & fourth elective preference cannot same"))
				 {
					fileone.setCellData(sheetName, "Status", 13 , "Pass");	
				 }
				
				 else
				 {
					 fileone.setCellData(sheetName, "Status", 13, "Fail");
				 }
				SoftAssert softAssert = new SoftAssert();
				 softAssert.assertEquals(actpopup3, "First or second or third elective subject cannot be same");
				driver.findElement(By.xpath("//*[@id=\"popup_ok\"]")).click();
				Thread.sleep(2000);
				
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
