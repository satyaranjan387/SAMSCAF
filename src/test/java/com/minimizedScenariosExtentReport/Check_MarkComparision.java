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
import org.openqa.selenium.WebElement;
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

public class Check_MarkComparision 
{
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
		    	htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/ExtentReport/Check_MarkComparision-Report.html");

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
//	    	driver.findElement(By.id("txtSMobileNo")).sendKeys(UserName);
//	    	driver.findElement(By.id("txtSPwd")).sendKeys(Password);
//	    	String cptcha = driver.findElement(By.xpath("//*[@id=\"lblCaptcha\"]")).getText();
//	    	driver.findElement(By.id("txtRandno")).sendKeys(cptcha);
//	    	driver.findElement(By.id("btnSIGNIN")).click();
			
			driver.findElement(By.xpath("//span[@class='menu-text']")).click();
			
			driver.findElement(By.xpath("//a[contains(text(),'CAF Apply')]")).click();
			
		}
		
		    @AfterTest
			public void finish() {
				extent.flush();
				driver.quit();
			}
		
		@Test(priority=0)
		public void Compare_TotalMarkSecured_MaxMark() throws InterruptedException
		{
			test = extent.createTest("TotalMarkSecured_MaxMark");
			driver.findElement(By.id("ddlBoard")).sendKeys("1 - BSE, ODISHA");
			

			driver.findElement(By.id("ddlYOP")).sendKeys("2009");
			
			
			driver.findElement(By.id("rbtnAnnual")).click();
			
			
			driver.findElement(By.id("txtBoardRoll")).sendKeys("001BB040");
			
			
			driver.findElement(By.id("txtApplName")).sendKeys("Milan Singh");
			
			
			driver.findElement(By.id("txtFatherName")).sendKeys("Rajendra Kumar Singh");
			
			
			driver.findElement(By.id("txtMotherName")).sendKeys("Sarojini Singh");
			
			
			driver.findElement(By.id("ddlBloodGroup")).sendKeys("A+");
			
			
			driver.findElement(By.id("ddlGender")).sendKeys("MALE");
			
			
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
			WebElement Imageupload =driver.findElement(By.xpath("//*[@id='imgUpload']"));
			Imageupload.sendKeys("E:/SAMS_Junior/dummy-image.png");
	
			WebElement upload =driver.findElement(By.name("upload"));
			upload.click();
			Thread.sleep(4000);		
			WebElement okupload =driver.findElement(By.cssSelector("#form1 > div:nth-child(4) > table > tbody > tr:nth-child(5) > td > input:nth-child(1)"));
			okupload.click();
		    }
	  }
		        
	       driver.switchTo().window(mainWindowName);
			
			
	//Runtime.getRuntime().exec("C:\\Users\\milan.singh\\Desktop\\ImageUpload.exe");

			
			driver.findElement(By.id("ddlDay")).sendKeys("9");
			
			
			driver.findElement(By.id("ddlMonth")).sendKeys("SEPTEMBER");
			
							
			driver.findElement(By.id("ddlYear")).sendKeys("1993");
			
			
			
			
		    driver.findElement(By.id("ddlNationality")).sendKeys("INDIAN");
			
			
			driver.findElement(By.id("ddlMt")).sendKeys("ODIA");
			
			
			driver.findElement(By.id("txtadhar")).sendKeys("111111111209");
			
			
			driver.findElement(By.id("txtParentMob")).sendKeys("8280711795");
			
			
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
			
			
			//driver.findElement(By.id("txtCEmail")).sendKeys("milansingh234@gmail.com");
			
			
			driver.findElement(By.id("txtSocSci")).sendKeys("60");
			
			
			driver.findElement(By.id("txtScience")).sendKeys("60");
			
			
			driver.findElement(By.id("txtMath")).sendKeys("60");
			
			
			driver.findElement(By.id("txtEnglish")).sendKeys("60");
			
			
			driver.findElement(By.id("txtTotMark")).sendKeys("800");
			
			
			driver.findElement(By.id("txtMaxMark")).sendKeys("600");
		
			
			driver.findElement(By.id("btnSave")).click();
			
			
			WebElement Alertmsg =driver.findElement(By.xpath("//*[@id=\"popup_message\"]/strong"));
			
			String msg = Alertmsg.getText();
			System.out.println(msg);
			
			if (msg.equals("Total Mark cannot be greater than Maximum Mark"))
			{
				
     			
				fileone.setCellData(sheetName, "Status", 37, "Pass");
			}
			
			else 
				
			{
				fileone.setCellData(sheetName, "Status", 37, "Fail");
			}
			
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertEquals(Alertmsg,"Total Mark cannot be greater than Maximum Mark","Test case failed");
			
			driver.findElement(By.id("popup_ok")).click();
		}
		
			@Test(priority=1)
			public void Compare_TotalMarkSecured_Sumofindividualmarks()
			{
				test = extent.createTest("TotalMarkSecured_Sumofindividualmarks");
				driver.findElement(By.id("txtSocSci")).clear();
				driver.findElement(By.id("txtSocSci")).sendKeys("60");
				
				driver.findElement(By.id("txtScience")).clear();
				driver.findElement(By.id("txtScience")).sendKeys("60");
				
				driver.findElement(By.id("txtMath")).clear();
			    driver.findElement(By.id("txtMath")).sendKeys("60");
				
			    driver.findElement(By.id("txtEnglish")).clear();				
				driver.findElement(By.id("txtEnglish")).sendKeys("90");
				
				driver.findElement(By.id("txtTotMark")).clear();				
				driver.findElement(By.id("txtTotMark")).sendKeys("240");
				
				driver.findElement(By.id("txtMaxMark")).clear();				
				driver.findElement(By.id("txtMaxMark")).sendKeys("600");
				
				
				driver.findElement(By.id("btnSave")).click();
				
								
				WebElement Alertmsg =driver.findElement(By.xpath("//*[@id=\"popup_message\"]/strong"));
				
				String msg1 = Alertmsg.getText();
				
				System.out.println(msg1);
				
				if (msg1.equalsIgnoreCase("The sum of your individual marks cannot be greater than the Total Mark")) 
				{
					
					fileone.setCellData(sheetName, "Status", 38, "Pass");
					
				}	
				
				else
					
				{
					fileone.setCellData(sheetName, "Status", 38, "Fail");	
					
				}
				
				SoftAssert softAssert = new SoftAssert();
				softAssert.assertEquals(msg1,"The sum of your individual marks cannot be greater than the Total Mark","Test case failed");
				
				driver.findElement(By.id("popup_ok")).click();
			}

		@Test(priority=2)
		public void Compare_PassMarkCompartmental_FailMarkPrevious()
		{
		test = extent.createTest("PassMarkCompartmental_FailMarkPrevious");		
		driver.findElement(By.id("txtSocSci")).clear();
		driver.findElement(By.id("txtSocSci")).sendKeys("60");
		
		driver.findElement(By.id("txtScience")).clear();
		driver.findElement(By.id("txtScience")).sendKeys("60");
		
		driver.findElement(By.id("txtMath")).clear();
		driver.findElement(By.id("txtMath")).sendKeys("60");
		
		driver.findElement(By.id("txtEnglish")).clear();
		driver.findElement(By.id("txtEnglish")).sendKeys("60");
		
		driver.findElement(By.id("txtTotMark")).clear();
		driver.findElement(By.id("txtTotMark")).sendKeys("240");
		
		driver.findElement(By.id("txtMaxMark")).clear();
		driver.findElement(By.id("txtMaxMark")).sendKeys("600");
		
		
		driver.findElement(By.id("rbtCompartmentalY")).click();
		
		
		driver.findElement(By.id("ddlCompSubject1")).sendKeys("ENGLISH");
		
		driver.findElement(By.id("txtCompFMark1")).sendKeys("15");
				
		driver.findElement(By.id("txtCompPMark1")).sendKeys("10");
		
		
		driver.findElement(By.id("btnSave")).click();
				
		
		WebElement Alertmsg =driver.findElement(By.xpath("//*[@id=\"popup_message\"]/strong"));
		
		String msg2 = Alertmsg.getText();
		
		System.out.println(msg2);
		
		if (msg2.equals("Fail Mark cannot be greater than or equal to Pass Mark"))
		{
			fileone.setCellData(sheetName, "Status", 39, "Pass");
			
		 }
		
		else
			
		{
			
			
			fileone.setCellData(sheetName, "Status", 39, "Pass");
			
		}
		
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(msg2,"Fail Mark cannot be greater than or equal to Pass Mark","Test case failed");
		
		driver.findElement(By.id("popup_ok")).click();
		
		driver.findElement(By.id("rbtCompartmentalN")).click();
	}
			
			
			
			@Test(priority=3)
			public void Minimum_PassPercentages_IndividualSubject() throws InterruptedException {
				test = extent.createTest("PassPercentages_IndividualSubject");
				
				driver.findElement(By.id("ddlBoard")).sendKeys("1 - BSE, ODISHA");
				

				driver.findElement(By.id("ddlYOP")).sendKeys("2009");
				
				
				driver.findElement(By.id("rbtnAnnual")).click();
				
				
				driver.findElement(By.id("txtBoardRoll")).sendKeys("001BB040");
				
				
				driver.findElement(By.id("txtApplName")).sendKeys("Milan Singh");
				
				
				driver.findElement(By.id("txtFatherName")).sendKeys("Rajendra Kumar Singh");
				
				
				driver.findElement(By.id("txtMotherName")).sendKeys("Sarojini Singh");
				
				
				driver.findElement(By.id("ddlBloodGroup")).sendKeys("A+");
				
				
				driver.findElement(By.id("ddlGender")).sendKeys("MALE");
				
				
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
				WebElement Imageupload =driver.findElement(By.xpath("//*[@id='imgUpload']"));
				Imageupload.sendKeys("E:/SAMS_Junior/dummy-image.png");
		
				WebElement upload =driver.findElement(By.name("upload"));
				upload.click();
						
				WebElement okupload =driver.findElement(By.cssSelector("#form1 > div:nth-child(4) > table > tbody > tr:nth-child(5) > td > input:nth-child(1)"));
				okupload.click();
			    }
		  }
			        
		       driver.switchTo().window(mainWindowName);
				
				
		//Runtime.getRuntime().exec("C:\\Users\\milan.singh\\Desktop\\ImageUpload.exe");

				
				driver.findElement(By.id("ddlDay")).sendKeys("9");
				
				
				driver.findElement(By.id("ddlMonth")).sendKeys("SEPTEMBER");
				
								
				driver.findElement(By.id("ddlYear")).sendKeys("1993");
				
				
				
				
			    driver.findElement(By.id("ddlNationality")).sendKeys("INDIAN");
				
				
				driver.findElement(By.id("ddlMt")).sendKeys("ODIA");
				
				
				driver.findElement(By.id("txtadhar")).sendKeys("111111111209");
				
				
				driver.findElement(By.id("txtParentMob")).sendKeys("8280711795");
				
				
				driver.findElement(By.id("ddlCState")).sendKeys("1 - ODISHA");
				Thread.sleep(3000);
				
				driver.findElement(By.id("ddlCDist")).sendKeys("Angul");
				Thread.sleep(3000);
				
				driver.findElement(By.id("ddlCBlock")).sendKeys("ANGUL");
				Thread.sleep(3000);
				
				driver.findElement(By.id("txtCPS")).clear();
				driver.findElement(By.id("txtCPS")).sendKeys("Bomikhal,Plot No-376");
				
				
				driver.findElement(By.id("txtCPC")).sendKeys("751010");
				
							
				driver.findElement(By.id("txtCTCode")).sendKeys("0674");
				
				
				driver.findElement(By.id("txtCTeleNo")).sendKeys("270406");
				
				
				//driver.findElement(By.id("txtCEmail")).sendKeys("milansingh234@gmail.com");
				
				
				driver.findElement(By.id("txtSocSci")).sendKeys("9");
				
				
				driver.findElement(By.id("txtScience")).sendKeys("10");
				
				
				driver.findElement(By.id("txtMath")).sendKeys("5");
				
				
				driver.findElement(By.id("txtEnglish")).sendKeys("5");
				
				
				driver.findElement(By.id("txtTotMark")).sendKeys("29");
				
				
				driver.findElement(By.id("txtMaxMark")).sendKeys("100");
			
				
				driver.findElement(By.id("btnSave")).click();
				
				
				WebElement Alertmsg3 =driver.findElement(By.xpath("//*[@id=\"popup_message\"]/strong"));
				
				String msg = Alertmsg3.getText();
				System.out.println(msg);
				
				if (msg.equals("Please select Father's Occupation !"))
				{
				
					fileone.setCellData(sheetName, "Status", 40, "Pass");
				}
				
				else 
					
				{
					fileone.setCellData(sheetName, "Status", 40, "Fail");
				}
				
				SoftAssert softAssert = new SoftAssert();
				softAssert.assertEquals(msg,"Please select Father's Occupation !","Test case failed");
				
				
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
