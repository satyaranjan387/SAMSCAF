package com.minimizedScenariosExtentReport;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
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

public class Check_Fieldvalidation {
	
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
	    	htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/ExtentReport/Check_Fieldvalidation-Report.html");
	    	htmlReporter.loadXMLConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
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
		public void Check_Disabled_Supplementary_Currentyear() throws InterruptedException
		{
		test = extent.createTest("Disabled_Supplementary_Currentyear");	
		System.setProperty("webdriver.chrome.driver", "C:/Users/satyaranjan.m//Desktop/chromedriver_win32 (2)/chromedriver.exe");
		driver  = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://o.samsodisha.gov.in/");
		
		
		
		String Mainwindow = driver.getWindowHandle();
		
		
		Actions action =new Actions(driver);
		WebElement ele=driver.findElement(By.cssSelector("#maincontaint > div > div:nth-child(2) > div:nth-child(1) > div > a"));
		action.moveToElement(ele).perform();
		ele.click();
		
		
		
		Set<String> winHandles = driver.getWindowHandles();
		 
		 
		 
		for(String handle: winHandles){
            if(!handle.equals(Mainwindow)){
            driver.switchTo().window(handle);
            
            System.out.println("Title of the new window: " +
            driver.getTitle());
           
            }
        }
		driver.manage().window().maximize();
		
		WebElement user=driver.findElement(By.id("txtSMobileNo"));
		user.sendKeys("9776257875");
		WebElement pw=driver.findElement(By.id("txtSPwd"));
		pw.sendKeys("Admin@12");
		Thread.sleep(8000);
		
		String cptcha = driver.findElement(By.xpath("//*[@id=\"lblCaptcha\"]")).getText();
		driver.findElement(By.id("txtRandno")).sendKeys(cptcha);
		
		WebElement signin=driver.findElement(By.id("btnSIGNIN"));
		signin.click();
		
		
		
		WebElement Formapply=driver.findElement(By.cssSelector("#leftmenu_divDiploma > ul > li.FormApply > a"));
		Formapply.click();
		
		
		
		WebElement ApplyOnline=driver.findElement(By.cssSelector("#leftmenu_divDiploma > ul > li.FormApply.open > ul > li:nth-child(1) > a"));
		ApplyOnline.click();
		
		
		// Basic Personal Details

		WebElement YOP=driver.findElement(By.id("ddlYOP"));
		YOP.sendKeys("2020");
		
	    Thread.sleep(2000);
		
		boolean annual=driver.findElement(By.id("rbtnSuppl")).isEnabled();
		
		
		if(annual==true)
		 {
			fileone.setCellData(sheetName, "Status", 25 , "Fail");	
		 }
		
		 else
		 {
			 fileone.setCellData(sheetName, "Status", 25 , "Pass");
		 }
	
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(annual,"Test Case Failed");		
		
		Thread.sleep(2000);
		
		}
		
		
		@Test(priority=1)
		public void Check_Age_Equalto_13years_Apply() throws InterruptedException {
		test = extent.createTest("Age_Equalto_13years_Apply");
		WebElement BoardRoll=driver.findElement(By.id("txtBoardRoll"));
		BoardRoll.sendKeys("1000660");
		Thread.sleep(2000);
		
		WebElement BloodGroup =driver.findElement(By.id("ddlBloodGroup"));
		BloodGroup.sendKeys("A+");
		
		Thread.sleep(2000);
		
		
		WebElement Gender =driver.findElement(By.id("ddlGender"));
		Gender.sendKeys("MALE");
		
		Thread.sleep(2000);

		WebElement ApplicantName=driver.findElement(By.id("txtApplName"));
		ApplicantName.sendKeys("Rupesh Pati");
		
		Thread.sleep(4000);
		
		WebElement FatherName=driver.findElement(By.id("txtFatherName"));
		FatherName.sendKeys("RAJENDRA Pati");
		
		Thread.sleep(2000);
		
		WebElement MotherName=driver.findElement(By.id("txtMotherName"));
		MotherName.sendKeys("Sunita Pati");
		
		
		Thread.sleep(2000);
	
		
		
		WebElement Religion =driver.findElement(By.id("ddlReligion"));
		Religion.sendKeys("HINDU");
		Thread.sleep(2000);
        
		//Leaner Framework
         
		String mainWindowTitle 	= driver.getTitle();
		System.out.println("Length of main window title  :" + mainWindowTitle.length());
		String mainWindowName 	= driver.getWindowHandle();
		System.out.println("Main Window Title : "  + mainWindowTitle);
		System.out.println("Main Window Name : "  + mainWindowName);
		
		WebElement Image =driver.findElement(By.id("ImgAppl"));
		Image.click();
		
		
		Thread.sleep(3000);
		
		Set<String> windows = driver.getWindowHandles();
		for(String w : windows)
		{
			driver.switchTo().window(w);
			Thread.sleep(4000);

			if(driver.getCurrentUrl().equalsIgnoreCase("http://o.samsodisha.gov.in/ONLINE_CAF/UploadPopUpJr.aspx"))
			  {
				driver.findElement(By.xpath("//*[@id='imgUpload']")).sendKeys("E:/SAMS_Junior/dummy-image.png");
				Thread.sleep(4000);
			    driver.findElement(By.name("upload")).click();
				Thread.sleep(4000);
				driver.findElement(By.cssSelector("#form1 > div:nth-child(4) > table > tbody > tr:nth-child(5) > td > input:nth-child(1)")).click();			
			  }
			}
		Thread.sleep(2000);	        
		driver.switchTo().window(mainWindowName);
			
		Thread.sleep(2000);

		//Runtime.getRuntime().exec("C:\\Users\\milan.singh\\Desktop\\ImageUpload.exe");
		
		WebElement Day =driver.findElement(By.id("ddlDay"));
		Day.sendKeys("1");
		
		Thread.sleep(2000);
		
		WebElement Month =driver.findElement(By.id("ddlMonth"));
		Month.sendKeys("JANUARY");
		
		Thread.sleep(2000);
		
		WebElement Year =driver.findElement(By.id("ddlYear"));
		Year.sendKeys("2006");
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("btnSave")).click();
		
		Thread.sleep(2000);
		
		String actualText = driver.findElement(By.id("popup_message")).getText();
		
		if(actualText.equals("Parent or Gaurdian  Mobile  No cannot be left blank !"))
		 {
			fileone.setCellData(sheetName, "Status", 26 , "Fail");	
		 }
		
		 else
		 {
			 fileone.setCellData(sheetName, "Status", 26 , "Pass");
		 }
	
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualText, "Parent or Gaurdian  Mobile  No cannot be left blank !", "Test case failed");		
		
		driver.findElement(By.id("popup_ok")).click();
		Thread.sleep(2000);
		
			
		}
	
		
		@Test(priority=2)
		public void Check_Age_Lessthan_13years_Apply() throws InterruptedException {
			test = extent.createTest("Age_Lessthan_13years_Apply");
			Thread.sleep(2000);
			
			WebElement Year =driver.findElement(By.id("ddlYear"));
			Year.sendKeys("2007");
			
			Thread.sleep(2000);
			
			driver.findElement(By.id("btnSave")).click();
			
			Thread.sleep(2000);
			
			String actualText = driver.findElement(By.id("popup_message")).getText();
			
			if(actualText.equals("The difference of age between the birth year and 10th passing year should be greater than 13"))
			 {
				fileone.setCellData(sheetName, "Status", 27 , "Fail");	
			 }
			
			 else
			 {
				 fileone.setCellData(sheetName, "Status", 27 , "Pass");
			 }
		
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertEquals(actualText, "The difference of age between the birth year and 10th passing year should be greater than 13", "Test case failed");		
			
			driver.findElement(By.id("popup_ok")).click();
			Thread.sleep(2000);
			
			
		}
		
		
		@Test(priority=3)
		public void Check_Age_Morethan_13years_Apply() throws InterruptedException {
			test = extent.createTest("Age_Morethan_13years_Apply");
			Thread.sleep(2000);
			
			//WebElement Year =driver.findElement(By.id("ddlYear"));
			//Year.sendKeys("1990");
			
			Select Year=new Select(driver.findElement(By.id("ddlYear")));
			Year.selectByValue("1990");
			
			Thread.sleep(2000);
			
			driver.findElement(By.id("btnSave")).click();
			
			Thread.sleep(2000);
			
			String actualText = driver.findElement(By.id("popup_message")).getText();
			
			if(actualText.equals("Parent or Gaurdian  Mobile  No cannot be left blank !"))
			 {
				fileone.setCellData(sheetName, "Status", 28 , "Fail");	
			 }
			
			 else
			 {
				 fileone.setCellData(sheetName, "Status", 28 , "Pass");
			 }
		
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertEquals(actualText, "Parent or Gaurdian  Mobile  No cannot be left blank !", "Test case failed");		
			

			driver.findElement(By.id("popup_ok")).click();
			Thread.sleep(2000);
			
		}
		
		
		@Test(priority=4)
		public void Check_ResisteredMobileNo_Readonlymode() throws InterruptedException {
		
		test = extent.createTest("ResisteredMobileNo_Readonlymode");
		Thread.sleep(2000);
		
		
		
		WebElement Nationality =driver.findElement(By.id("ddlNationality"));
		Nationality.sendKeys("INDIAN");
		
		Thread.sleep(2000);
		
		WebElement MotherTongue =driver.findElement(By.id("ddlMt"));
		MotherTongue.sendKeys("ODIA");
		
		Thread.sleep(2000);
		
		WebElement AadharNo =driver.findElement(By.id("txtadhar"));
		AadharNo.sendKeys("111111111209");
		
		Thread.sleep(2000);
		
		WebElement Pmobileno =driver.findElement(By.id("txtParentMob"));
		Pmobileno.sendKeys("7978329514");
		
		Thread.sleep(2000);
		
		WebElement State =driver.findElement(By.id("ddlCState"));
		State.sendKeys("1 - ODISHA");
		
		Thread.sleep(2000);
		
		WebElement District =driver.findElement(By.id("ddlCDist"));
		District.sendKeys("Angul");
		
		Thread.sleep(2000);
		
		WebElement Block =driver.findElement(By.id("ddlCBlock"));
		Block.sendKeys("ANGUL");
		
		Thread.sleep(2000);
		WebElement Address =driver.findElement(By.id("txtCPS"));
		Address.sendKeys("Bomikhal,Plot No-376");
		
		Thread.sleep(2000);
		
		WebElement Pincode =driver.findElement(By.id("txtCPC"));
		Pincode.sendKeys("751010");
		
		Thread.sleep(2000);
		WebElement AreaCode =driver.findElement(By.id("txtCTCode"));
		AreaCode.sendKeys("0674");
		
		Thread.sleep(2000);
		WebElement Telephonecode =driver.findElement(By.id("txtCTeleNo"));
		Telephonecode.sendKeys("270406");
		
		Thread.sleep(2000);
		
		Boolean mobNum = driver.findElement(By.id("txtCMobNo")).isEnabled();
		
		if(mobNum==true)
		 {
			fileone.setCellData(sheetName, "Status", 29 , "Fail");	
		 }
		
		 else
		 {
			 fileone.setCellData(sheetName, "Status", 29 , "Pass");
		 }
	
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(mobNum,"Test Case Failed");		
		
		Thread.sleep(2000);
	}
		
		@Test(priority=5)
		public void Check_Displaying_ResisteredEmailId() throws InterruptedException {
		test = extent.createTest("Displaying_ResisteredEmailId");	
		String actText = driver.findElement(By.id("txtCEmail")).getText();
		
		if(actText.equals("dkp.world@gmail.com"))
		 {
			fileone.setCellData(sheetName, "Status", 30 , "Fail");	
		 }
		
		 else
		 {
			 fileone.setCellData(sheetName, "Status", 30 , "Pass");
		 }
	
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actText, "dkp.world@gmail.com", "Test case failed");	
		
		Thread.sleep(2000);
		
		}
		
		
		@Test(priority=6)
		public void Check_Enable_Compartmental_Selectannual() throws InterruptedException {
			test = extent.createTest("Enable_Compartmental_Selectannual");
			
			driver.findElement(By.id("txtSocSci")).sendKeys("60");
			
			driver.findElement(By.id("txtScience")).sendKeys("60");

			driver.findElement(By.id("txtMath")).sendKeys("60");
		
			driver.findElement(By.id("txtEnglish")).sendKeys("60");
		
			driver.findElement(By.id("txtTotMark")).sendKeys("400");
	
			driver.findElement(By.id("txtMaxMark")).sendKeys("600");
		
			driver.findElement(By.id("ddlGrade")).sendKeys("A2");
			
			boolean comp=driver.findElement(By.id("rbtCompartmentalY")).isEnabled();
			
			if(comp==true)
			 {
				fileone.setCellData(sheetName, "Status", 31 , "Pass");	
			 }
			
			 else
			 {
				 fileone.setCellData(sheetName, "Status", 31 , "Fail");
			 }
		
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertTrue(comp,"Test Case Failed");		
			
			Thread.sleep(2000);
			
		}
		
		@Test(priority=7)
		public void Check_Enable_Compartmental_Selectsupplementary() throws InterruptedException {
			test = extent.createTest("Enable_Compartmental_Selectsupplementary");
			WebElement YOP=driver.findElement(By.id("ddlYOP"));
			YOP.sendKeys("2018");
			
		    Thread.sleep(2000);
		    
		    driver.findElement(By.id("rbtnSuppl")).click();
		    
		    WebElement BoardRoll=driver.findElement(By.id("txtBoardRoll"));
			BoardRoll.sendKeys("1000660");
			Thread.sleep(2000);
			
			WebElement BloodGroup =driver.findElement(By.id("ddlBloodGroup"));
			BloodGroup.sendKeys("A+");
			
			Thread.sleep(2000);
			
			
			WebElement Gender =driver.findElement(By.id("ddlGender"));
			Gender.sendKeys("MALE");
			
			Thread.sleep(2000);

			WebElement ApplicantName=driver.findElement(By.id("txtApplName"));
			ApplicantName.sendKeys("Rupesh Pati");
			
			Thread.sleep(4000);
			
			WebElement FatherName=driver.findElement(By.id("txtFatherName"));
			FatherName.sendKeys("RAJENDRA Pati");
			
			Thread.sleep(2000);
			
			WebElement MotherName=driver.findElement(By.id("txtMotherName"));
			MotherName.sendKeys("Sunita Pati");
			
			
			Thread.sleep(2000);
		
			
			
			WebElement Religion =driver.findElement(By.id("ddlReligion"));
			Religion.sendKeys("HINDU");
			Thread.sleep(2000);
	        
			//Leaner Framework
	         
			String mainWindowTitle 	= driver.getTitle();
			System.out.println("Length of main window title  :" + mainWindowTitle.length());
			String mainWindowName 	= driver.getWindowHandle();
			System.out.println("Main Window Title : "  + mainWindowTitle);
			System.out.println("Main Window Name : "  + mainWindowName);
			
			WebElement Image =driver.findElement(By.id("ImgAppl"));
			Image.click();
			
			
			Thread.sleep(3000);
			
			Set<String> windows = driver.getWindowHandles();
			for(String w : windows)
			{
				driver.switchTo().window(w);
				Thread.sleep(2000);

			if(driver.getCurrentUrl().equalsIgnoreCase("http://o.samsodisha.gov.in/ONLINE_CAF/UploadPopUpJr.aspx"))
			{
				WebElement Imageupload =driver.findElement(By.xpath("//*[@id='imgUpload']"));
				Imageupload.sendKeys("E:/SAMS_Junior/dummy-image.png");
				Thread.sleep(2000);
				WebElement upload =driver.findElement(By.name("upload"));
				upload.click();
				Thread.sleep(2000);		
				WebElement okupload =driver.findElement(By.cssSelector("#form1 > div:nth-child(4) > table > tbody > tr:nth-child(5) > td > input:nth-child(1)"));
				okupload.click();
			}
			}
			
			Thread.sleep(2000);	        
			driver.switchTo().window(mainWindowName);
				
			Thread.sleep(2000);

			//Runtime.getRuntime().exec("C:\\Users\\milan.singh\\Desktop\\ImageUpload.exe");
			
			WebElement Day =driver.findElement(By.id("ddlDay"));
			Day.sendKeys("1");
			
			Thread.sleep(2000);
			
			WebElement Month =driver.findElement(By.id("ddlMonth"));
			Month.sendKeys("JANUARY");
			
			Thread.sleep(2000);
			
			WebElement Year =driver.findElement(By.id("ddlYear"));
			Year.sendKeys("1998");
			
			
			WebElement Nationality =driver.findElement(By.id("ddlNationality"));
			Nationality.sendKeys("INDIAN");
			
			Thread.sleep(2000);
			
			WebElement MotherTongue =driver.findElement(By.id("ddlMt"));
			MotherTongue.sendKeys("ODIA");
			
			Thread.sleep(2000);
			
			WebElement AadharNo =driver.findElement(By.id("txtadhar"));
			AadharNo.sendKeys("111111111209");
			
			Thread.sleep(2000);
			
			WebElement Pmobileno =driver.findElement(By.id("txtParentMob"));
			Pmobileno.sendKeys("7978329514");
			
			WebElement State =driver.findElement(By.id("ddlCState"));
			State.sendKeys("1 - ODISHA");
			
			Thread.sleep(2000);
			
			WebElement District =driver.findElement(By.id("ddlCDist"));
			District.sendKeys("Angul");
			
			Thread.sleep(2000);
			
			WebElement Block =driver.findElement(By.id("ddlCBlock"));
			Block.sendKeys("ANGUL");
			
			Thread.sleep(2000);
			WebElement Address =driver.findElement(By.id("txtCPS"));
			Address.sendKeys("Bomikhal,Plot No-376");
			
			Thread.sleep(2000);
			
			WebElement Pincode =driver.findElement(By.id("txtCPC"));
			Pincode.sendKeys("751010");
			
			Thread.sleep(2000);
			WebElement AreaCode =driver.findElement(By.id("txtCTCode"));
			AreaCode.sendKeys("0674");
			
			Thread.sleep(2000);
			WebElement Telephonecode =driver.findElement(By.id("txtCTeleNo"));
			Telephonecode.sendKeys("270406");
			
			Thread.sleep(2000);
			
			driver.findElement(By.id("txtSocSci")).sendKeys("60");
			
			driver.findElement(By.id("txtScience")).sendKeys("60");

			driver.findElement(By.id("txtMath")).sendKeys("60");
		
			driver.findElement(By.id("txtEnglish")).sendKeys("60");
		
			driver.findElement(By.id("txtTotMark")).sendKeys("400");
	
			driver.findElement(By.id("txtMaxMark")).sendKeys("600");
		
			driver.findElement(By.id("ddlGrade")).sendKeys("A2");
			
			boolean comp=driver.findElement(By.id("rbtCompartmentalY")).isEnabled();
			
			if(comp==true)
			 {
				fileone.setCellData(sheetName, "Status", 32 , "Pass");	
			 }
			
			 else
			 {
				 fileone.setCellData(sheetName, "Status", 32 , "Fail");
			 }
			
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertTrue(comp,"Test Case Failed");		

			
		}
		
		@Test(priority=8)
		public void Check_YOJ_Less_YOL() throws InterruptedException {
			test = extent.createTest("Check_YOJ_Less_YOL");
			driver.findElement(By.id("rbtCompartmentalN")).click();
			
			WebElement FatherOccupation =driver.findElement(By.id("ddlFOcu"));
			FatherOccupation.sendKeys("BUSINESS");
			
			
			
			WebElement MotherOccupation =driver.findElement(By.id("ddlMOcu"));
			MotherOccupation.sendKeys("BUSINESS");
			
			
			
			
			WebElement AnnualIncome =driver.findElement(By.id("ddlAIncome"));
			AnnualIncome.sendKeys("0 - 1,00,000");
			
			
			WebElement AccountNo =driver.findElement(By.id("txtacno"));
			AccountNo.sendKeys("4444444444444444");
			
			
			
			WebElement IFSCCODE =driver.findElement(By.id("txtifsc"));
			IFSCCODE.sendKeys("SBIN0012021");
			
			
			
			WebElement MICRCODE =driver.findElement(By.id("txtmicr"));
			MICRCODE.sendKeys("888888888");
			
			
			
			WebElement SchoolName =driver.findElement(By.id("txtschname"));
			SchoolName.sendKeys("VSK");
			
			
			WebElement SchoolLocation =driver.findElement(By.id("txtschloc"));
			SchoolLocation.sendKeys("BBSR");
			
		
			WebElement InstitutionDistrict =driver.findElement(By.id("ddlinstDistrict"));
			InstitutionDistrict.sendKeys("ANGUL");
			
			Thread.sleep(3000);
			
			Select YOJ=new Select(driver.findElement(By.id("ddlYOJ")));
			YOJ.selectByValue("2010");
			
			Thread.sleep(1000);
			
			driver.findElement(By.id("btnSave")).click();
			
			Thread.sleep(3000);
			
			String actualTeaxt= driver.findElement(By.xpath("//*[@id=\"popup_message\"]/strong")).getText();
			System.out.println(actualTeaxt);
			if(actualTeaxt.equals("Please select minimum 5 Option details"))
			 {
				fileone.setCellData(sheetName, "Status", 33 , "Pass");	
			 }
			
			
			 else
			 {
				 fileone.setCellData(sheetName, "Status", 33 , "Fail");
			 }
			
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertEquals(actualTeaxt, "Please select minimum 5 Option details", "Test case failed");
			
			driver.findElement(By.xpath("//*[@id=\"popup_ok\"]")).click();
			Thread.sleep(3000);
			
			

			
		}
		
		@Test(priority=9)
		public void Check_YOL_Disabled() throws InterruptedException {
			test = extent.createTest("Check_YOL_Disabled");
		
			boolean yolcheck = driver.findElement(By.id("ddlYOL")).isEnabled();
			
			if(yolcheck==true)
			 {
				fileone.setCellData(sheetName, "Status", 34 , "Fail");	
			 }
			
			 else
			 {
				 fileone.setCellData(sheetName, "Status", 34 , "Pass");
			 }
			
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertTrue(yolcheck,"Test Case Failed");		
			
		}
		
		
		@Test(priority=10)
		public void VerifyYOL_Same_10thYOP() throws InterruptedException{
			test = extent.createTest("YOL_Same_10thYOP");
			
			//WebElement YOJ =driver.findElement(By.xpath("//*[@id=\"ddlYOJ\"]"));
			//YOJ.sendKeys("2017");
			
			Thread.sleep(2000);
			
			driver.findElement(By.id("btnSave")).click();
			
			Thread.sleep(3000);
			
			
			String actualTeaxt10= driver.findElement(By.id("popup_message")).getText();
			
			if(actualTeaxt10.equals("Please select minimum 5 Option details"))
			 {
				fileone.setCellData(sheetName, "Status", 35 , "Pass");	
			 }
			
			 else
			 {
				 fileone.setCellData(sheetName, "Status", 35 , "Fail");
			 }
			
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertEquals(actualTeaxt10, "Please select minimum 5 Option details", "Test case failed");
			
			driver.findElement(By.id("popup_ok")).click();
			
		}
		
		
		@Test(priority=11)
		public void CheckStreamwise_Previousyear_Cuttoffmark() throws InterruptedException {
			test = extent.createTest("Streamwise_Previousyear_Cuttoffmark");
			driver.findElement(By.id("ddlCollegeDistrict")).sendKeys("ANGUL");
			Thread.sleep(2000);
			driver.findElement(By.id("ddlCollege")).sendKeys("BAPUJI HIGHER SECONDARY SCHOOL, CHHENDIPADA");
			Thread.sleep(2000);
			driver.findElement(By.id("ddlStream")).sendKeys("ARTS");
			Thread.sleep(2000);
			
			String cttoffText = driver.findElement(By.xpath("//*[@id=\"cutoffGen1\"]/font")).getText();
			
			if(cttoffText.equals("Gen - 59.17%"))
			 {
				fileone.setCellData(sheetName, "Status", 36 , "Pass");	
			 }
			
			 else
			 {
				 fileone.setCellData(sheetName, "Status", 36 , "Fail");
			 }
			
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertEquals(cttoffText,"Gen - 59.17%","Test case failed");
		
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
