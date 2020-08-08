package com.minimizedScenariosExtentReport;

import java.io.IOException;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
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

import bsh.org.objectweb.asm.Constants;

public class CAFTest {
	
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
    	htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/ExtentReport/Check_Fieldvalidation-Report.html");

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
	public void MALECandidate_CAF_Apply() throws InterruptedException, Exception {
		// TODO Auto-generated method stub

		
		
		test = extent.createTest("MALECandidate_CAF_Apply");
		System.setProperty("webdriver.chrome.driver", "C:/Users/satyaranjan.m//Desktop/chromedriver_win32 (2)/chromedriver.exe");
		driver  = new ChromeDriver();
		driver.manage().deleteAllCookies();
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
		user.sendKeys("9348028902");
		WebElement pw=driver.findElement(By.id("txtSPwd"));
		pw.sendKeys("Admin@123");
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
		YOP.sendKeys("2019");
		
	     Thread.sleep(2000);
		
		WebElement annual=driver.findElement(By.id("rbtnAnnual"));
		annual.click();
		
		
		Thread.sleep(2000);
		
		
		
		WebElement BoardRoll=driver.findElement(By.id("txtBoardRoll"));
		BoardRoll.sendKeys("1000660");
		Thread.sleep(2000);
		
		WebElement BloodGroup =driver.findElement(By.id("ddlBloodGroup"));
		BloodGroup.sendKeys("A+");
		
		Thread.sleep(2000);
		
		WebElement ApplicantName=driver.findElement(By.id("txtApplName"));
		ApplicantName.sendKeys("MILAN SINGH MILAN");
		
		Thread.sleep(4000);
		
		WebElement FatherName=driver.findElement(By.id("txtFatherName"));
		FatherName.sendKeys("RAJENDRA K S");
		
		Thread.sleep(2000);
		
		WebElement MotherName=driver.findElement(By.id("txtMotherName"));
		MotherName.sendKeys("SAROJINI SINGH");
		
		
		WebElement Gender =driver.findElement(By.id("ddlGender"));
		Gender.sendKeys("MALE");
		
		driver.findElement(By.id("btnSave")).click();
		
		String wbs2 = driver.findElement(By.id("popup_message")).getText();
		System.out.println("wbs2"+ wbs2);
		if(wbs2.equals("Please select your Religion !"))
		 {
			fileone.setCellData(sheetName, "Status", 18 , "Pass");	
		 }
		
		 else
		 {
			 fileone.setCellData(sheetName, "Status", 18, "Fail");
		 }
	
	
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(wbs2, "Please select your Religion !", "Test Failed");
		driver.findElement(By.id("popup_ok")).click();
		
		Thread.sleep(3000);
		}
	
	
	
		@Test(priority=1)
		public void femaleCandidate() throws InterruptedException {
			test = extent.createTest("femaleCandidate");
			Select sl = new Select(driver.findElement(By.id("ddlGender")));
			sl.selectByVisibleText("FEMALE");
//			WebElement Gender =driver.findElement(By.id("ddlGender"));
//			Gender.sendKeys("FEMALE");
			Thread.sleep(3000);
			driver.findElement(By.id("btnSave")).click();
			Thread.sleep(3000);
			String wbs21 = driver.findElement(By.id("popup_message")).getText();
			
			System.out.println("wbs21"+wbs21);
			
			if(wbs21.equals("Please select your Religion !"))
			 {
				fileone.setCellData(sheetName, "Status", 19 , "Pass");	
			 }
			
			 else
			 {
				 fileone.setCellData(sheetName, "Status", 19, "Fail");
			 }
		
		
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertEquals(wbs21, "Please select your Religion !", "Test Failed");
			driver.findElement(By.id("popup_ok")).click();
			
		}
		
		
		@Test(priority=2)
		public void Transgender_Candidate_CAF_Apply() throws InterruptedException {
			test = extent.createTest("Transgender_Candidate_CAF_Apply");
			WebElement Gender =driver.findElement(By.id("ddlGender"));
			Gender.sendKeys("TRANSGENDER");
			Thread.sleep(3000);
			driver.findElement(By.id("btnSave")).click();
			Thread.sleep(3000);
			String wbs22 = driver.findElement(By.id("popup_message")).getText();
			System.out.println("wbs22"+wbs22);
			
			if(wbs22.equals("Please select your Religion !"))
			 {
				fileone.setCellData(sheetName, "Status", 20 , "Pass");	
			 }
			
			 else
			 {
				 fileone.setCellData(sheetName, "Status", 20, "Fail");
			 }
		
		
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertEquals(wbs22, "Please select your Religion !", "Test Failed");
			driver.findElement(By.id("popup_ok")).click();
				
	
		//WebElement ApplicantName=driver.findElement(By.id("txtApplName"));
		//ApplicantName.sendKeys("MILAN SINGH MILAN");
		
		//Thread.sleep(4000);
		
		//WebElement FatherName=driver.findElement(By.id("txtFatherName"));
		//FatherName.sendKeys("RAJENDRA K S");
		
		//Thread.sleep(2000);
		
		//WebElement MotherName=driver.findElement(By.id("txtMotherName"));
		//MotherName.sendKeys("SAROJINI SINGH");
		
		
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
			Thread.sleep(4000);
			WebElement upload =driver.findElement(By.name("upload"));
			upload.click();
			Thread.sleep(4000);		
			WebElement okupload =driver.findElement(By.cssSelector("#form1 > div:nth-child(4) > table > tbody > tr:nth-child(5) > td > input:nth-child(1)"));
			okupload.click();
		}
		}
		Thread.sleep(2000);	        
		driver.switchTo().window(mainWindowName);
				
				
		Thread.sleep(2000);


		//Runtime.getRuntime().exec("C:\\Users\\milan.singh\\Desktop\\ImageUpload.exe");
		
		
		
		WebElement Day =driver.findElement(By.id("ddlDay"));
		Day.sendKeys("9");
		
		Thread.sleep(2000);
		
		WebElement Month =driver.findElement(By.id("ddlMonth"));
		Month.sendKeys("SEPTEMBER");
		
		
		Thread.sleep(2000);
		
		WebElement Year =driver.findElement(By.id("ddlYear"));
		Year.sendKeys("2006");
		
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
		
		String previousPmobileno = "7978329514";
		Assert.assertEquals(previousPmobileno, "7978329514", "Duplicated number not accepting");
				
		Thread.sleep(2000);
		
		
		WebElement State =driver.findElement(By.id("ddlCState"));
		State.sendKeys("1 - ODISHA");
		
		Thread.sleep(3000);
		
		WebElement District =driver.findElement(By.id("ddlCDist"));
		District.sendKeys("Angul");
		
		Thread.sleep(3000);
		
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
		
		
		WebElement Email =driver.findElement(By.id("txtCEmail"));
		Email.sendKeys("milansingh234@gmail.com");
		
		Thread.sleep(2000);
		
		}
		
		
		@Test(priority=3)
		public void Minimum_10thpercentage_Apply_CAF() throws InterruptedException {
		test = extent.createTest("Minimum_10thpercentage_Apply_CAF");
		
		WebElement SocialScience =driver.findElement(By.id("txtSocSci"));
		SocialScience.sendKeys("35");
		
		Thread.sleep(2000);
		
		WebElement Science =driver.findElement(By.id("txtScience"));
		Science.sendKeys("25");
		
		
		
		Thread.sleep(2000);
		WebElement Math =driver.findElement(By.id("txtMath"));
		Math.sendKeys("30");
		
		
		Thread.sleep(2000);
		
		
		WebElement English =driver.findElement(By.id("txtEnglish"));
		English.sendKeys("20");
		
		Thread.sleep(2000);
		
		
		WebElement TotalMark =driver.findElement(By.id("txtTotMark"));
		TotalMark.sendKeys("150");
		
		
		Thread.sleep(2000);
		
		WebElement MaxMark =driver.findElement(By.id("txtMaxMark"));
		MaxMark.sendKeys("600");
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("ddlGrade")).sendKeys("A2");
		
		driver.findElement(By.id("btnSave")).click();
		
		String wbs23 = driver.findElement(By.id("popup_message")).getText();
		
		System.out.println("wbs23"+wbs23);
		if(wbs23.equals("Please select Father's Occupation !"))
		 {
			fileone.setCellData(sheetName, "Status", 21 , "Pass");	
		 }
		
		 else
		 {
			 fileone.setCellData(sheetName, "Status", 21, "Fail");
		 }
	
	
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(wbs23, "Please select Father's Occupation !", "Test Failed");
		driver.findElement(By.id("popup_ok")).click();	

		
	}
		
		
		@Test(priority=4)
		public void CAFApply_10thpasscompartmental() {
		test = extent.createTest("CAFApply_10thpasscompartmental");
		
		driver.findElement(By.id("rbtCompartmentalY")).click();
		
		driver.findElement(By.id("ddlCompSubject1")).sendKeys("MIL");
		
		driver.findElement(By.id("txtCompFMark1")).sendKeys("20");
		
		driver.findElement(By.id("txtCompPMark1")).sendKeys("25");
		
		driver.findElement(By.id("ddlCompSubject2")).sendKeys("ENGLISH");
		
		driver.findElement(By.id("txtCompFMark2")).sendKeys("20");

		driver.findElement(By.id("txtCompPMark2")).sendKeys("25");
		
		driver.findElement(By.id("btnSave")).click();
		
		String wbs24 = driver.findElement(By.id("popup_message")).getText();
		System.out.println("wbs24"+wbs24);
		if(wbs24.equals("Please select Father's Occupation !"))
		 {
			fileone.setCellData(sheetName, "Status", 22 , "Pass");	
		 }
		
		 else
		 {
			 fileone.setCellData(sheetName, "Status", 22, "Fail");
		 }
		
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(wbs24, "Please select Father's Occupation !", "Test Failed");
		driver.findElement(By.id("popup_ok")).click();
		
		
		
	}
	
	@Test(priority=5)
	public void CAF_NotAccept_Lessthan5preference() throws InterruptedException {
		test = extent.createTest("CAF_NotAccept_Lessthan5preference");
		
		WebElement FatherOccupation =driver.findElement(By.id("ddlFOcu"));
		FatherOccupation.sendKeys("BUSINESS");
		
		Thread.sleep(2000);
		
		WebElement MotherOccupation =driver.findElement(By.id("ddlMOcu"));
		MotherOccupation.sendKeys("BUSINESS");
		
		Thread.sleep(2000);
		
		
		WebElement AnnualIncome =driver.findElement(By.id("ddlAIncome"));
		AnnualIncome.sendKeys("0 - 1,00,000");
		Thread.sleep(2000);
		WebElement AccountNo =driver.findElement(By.id("txtacno"));
		AccountNo.sendKeys("4444444444444444");
		
		Thread.sleep(2000);
		
		WebElement IFSCCODE =driver.findElement(By.id("txtifsc"));
		IFSCCODE.sendKeys("SBIN0012021");
		
		
		Thread.sleep(2000);
		WebElement MICRCODE =driver.findElement(By.id("txtmicr"));
		MICRCODE.sendKeys("888888888");
		
		Thread.sleep(2000);
		
		
		
		WebElement BankName =driver.findElement(By.id("txtBankname"));
		BankName.clear();
		BankName.sendKeys("SBI");
		
		
		Thread.sleep(2000);
		
		WebElement BranchName =driver.findElement(By.id("txtBrname"));
		BranchName.clear();
		BranchName.sendKeys("BBSR");
		
		Thread.sleep(2000);
		
		
		WebElement SchoolName =driver.findElement(By.id("txtschname"));
		SchoolName.sendKeys("VSK");
		
		Thread.sleep(2000);
		WebElement SchoolLocation =driver.findElement(By.id("txtschloc"));
		SchoolLocation.sendKeys("BBSR");
		
		
		
		
		Thread.sleep(2000);
		WebElement InstitutionDistrict =driver.findElement(By.id("ddlinstDistrict"));
		InstitutionDistrict.sendKeys("ANGUL");
		
		
		Thread.sleep(2000);
		
		WebElement YOJ =driver.findElement(By.id("ddlYOJ"));
		YOJ.sendKeys("1995");
		
		Thread.sleep(2000);

		WebElement CollegeDistrict =driver.findElement(By.id("ddlCollegeDistrict"));
		CollegeDistrict.sendKeys("ANGUL");
		
		
		Thread.sleep(2000);
		
		WebElement College =driver.findElement(By.id("ddlCollege"));
		College.sendKeys("NALCO NAGAR REGIONAL HIGHER SECONDARY SCHOOL, KULAD");
		
		Thread.sleep(2000);
		
		WebElement Stream =driver.findElement(By.id("ddlStream"));
		Stream.sendKeys("ARTS");
		
//		Thread.sleep(2000);
//		
//		
//		WebElement Compulsary =driver.findElement(By.id("ddlCompulsory"));
//		Compulsary.sendKeys("MIL ODIA");
		
		Thread.sleep(2000);
		
        //1st Option
		WebElement Elective12345 =driver.findElement(By.id("ddlELE1"));
		Elective12345.sendKeys("HISTORY");
		
		Thread.sleep(2000);
		
		WebElement Elective22345 =driver.findElement(By.id("ddlELE2"));
		Elective22345.sendKeys("ECONOMICS");
		
		Thread.sleep(2000);
		
		WebElement Elective32345 =driver.findElement(By.id("ddlELE3"));
		Elective32345.sendKeys("LANGUAGE ODIA");
		
		Thread.sleep(2000);
		
		
		WebElement ForthElective12345 =driver.findElement(By.id("ddl4thELE1"));
		ForthElective12345.sendKeys("BANKING");
		
		Thread.sleep(2000);
		
		
		WebElement ForthElectivep1 =driver.findElement(By.id("ddl4thELE2"));
		ForthElectivep1.sendKeys("POLITICAL SCIENCE");
		
		Thread.sleep(2000);
		
		
		WebElement ForthElectivep2 =driver.findElement(By.id("ddl4thELE3"));
		ForthElectivep2.sendKeys("LOGIC");
		
		Thread.sleep(2000);
	
//Thread.sleep(600);
//		
//		WebElement Hostel =driver.findElement(By.id("rbtAccomodation1"));
//		Hostel.click();
		
		Thread.sleep(2000);
		
		WebElement OptionNew =driver.findElement(By.id("btnAddmore"));
		OptionNew.click();
	
		Thread.sleep(3000);
		
		
		  //2nd Option
		WebElement CollegeDistrict2 =driver.findElement(By.id("ddlCollegeDistrict"));
		CollegeDistrict2.sendKeys("ANGUL");
		
		Thread.sleep(2000);
		
		WebElement College2 =driver.findElement(By.id("ddlCollege"));
		College2.sendKeys("GADTAL REGIONAL HIGHER SECONDARY SCHOOL, GADTAL");
		
		Thread.sleep(2000);
		
		WebElement Stream2 =driver.findElement(By.id("ddlStream"));
		Stream2.sendKeys("SCIENCE");
		
		
//		Thread.sleep(600);
//		
		WebElement Compulsary2 =driver.findElement(By.id("ddlCompulsory"));
		Compulsary2.sendKeys("MIL ODIA");
		
		Thread.sleep(2000);
		
	
		
		WebElement Elective32 =driver.findElement(By.id("ddlELE3"));
		Elective32.sendKeys("BIOLOGY");
		
		
		Thread.sleep(2000);
		
		WebElement ForthElective12 =driver.findElement(By.id("ddl4thELE1"));
		ForthElective12.sendKeys("DIARYING");
	
		Thread.sleep(2000);
		
		WebElement Hostel1 =driver.findElement(By.id("rbtAccomodation1"));
		Hostel1.click();
	
		WebElement OptionNew2 =driver.findElement(By.id("btnAddmore"));
		OptionNew2.click();
		
		
		
		  //3rd Option
		Thread.sleep(3000);
	
		WebElement CollegeDistrict3 =driver.findElement(By.id("ddlCollegeDistrict"));
		CollegeDistrict3.sendKeys("ANGUL");
		
		Thread.sleep(2000);
		
		WebElement College23 =driver.findElement(By.id("ddlCollege"));
		College23.sendKeys("KUMANDA JARASINGHA ANCHALIK PANCHAYAT HIGHER SECONDARY SCHOOL, KUMANDA");
		
		Thread.sleep(2000);
		
		WebElement Stream23 =driver.findElement(By.id("ddlStream"));
		Stream23.sendKeys("ARTS");
		
		Thread.sleep(600);
//		
//		
		//WebElement Compulsary23 =driver.findElement(By.id("ddlCompulsory"));
		//Compulsary23.sendKeys("MIL ODIA");
		
		Thread.sleep(2000);
		
		WebElement Elective123 =driver.findElement(By.id("ddlELE1"));
		Elective123.sendKeys("ECONOMICS");
		
		Thread.sleep(2000);
		
		WebElement Elective223 =driver.findElement(By.id("ddlELE2"));
		Elective223.sendKeys("HISTORY");
		
		Thread.sleep(2000);
		
		WebElement Elective323 =driver.findElement(By.id("ddlELE3"));
		Elective323.sendKeys("POLITICAL SCIENCE");
		
		
		Thread.sleep(2000);
		
		WebElement ForthElective123 =driver.findElement(By.id("ddl4thELE1"));
		ForthElective123.sendKeys("LANGUAGE ODIA");
		
		
		Thread.sleep(3000);
	
		
//Thread.sleep(600);
//		
//		WebElement Hostel2 =driver.findElement(By.id("rbtAccomodation1"));
//		Hostel2.click();
		
		
		WebElement OptionNew23 =driver.findElement(By.id("btnAddmore"));
		OptionNew23.click();
		
		Thread.sleep(2000);
		
		
		  //4th Option
		WebElement CollegeDistrict34 =driver.findElement(By.id("ddlCollegeDistrict"));
		CollegeDistrict34.sendKeys("ANGUL");
		Thread.sleep(2000);
		
		
		WebElement College234 =driver.findElement(By.id("ddlCollege"));
		College234.sendKeys("T.T.P.S. HIGHER SECONDARY SCHOOL, TALCHER THERMAL");
		
		
		Thread.sleep(2000);
		WebElement Stream234 =driver.findElement(By.id("ddlStream"));
		Stream234.sendKeys("ARTS");
		
//		Thread.sleep(600);
//		
//		
//		WebElement Compulsary234 =driver.findElement(By.id("ddlCompulsory"));
//		Compulsary234.sendKeys("MIL ODIA");
		
		Thread.sleep(2000);
		
		WebElement Elective1234 =driver.findElement(By.id("ddlELE1"));
		Elective1234.sendKeys("ECONOMICS");
		
		Thread.sleep(2000);
		
		WebElement Elective2234 =driver.findElement(By.id("ddlELE2"));
		Elective2234.sendKeys("HISTORY");
		
		
		Thread.sleep(2000);
		WebElement Elective3234 =driver.findElement(By.id("ddlELE3"));
		Elective3234.sendKeys("POLITICAL SCIENCE");
		
		
		Thread.sleep(2000);
		
		WebElement ForthElective1234 =driver.findElement(By.id("ddl4thELE1"));
		ForthElective1234.sendKeys("LANGUAGE ODIA");
		
		
		
		Thread.sleep(2000);
		
//		WebElement Hostel234 =driver.findElement(By.id("rbtAccomodation1"));
//		Hostel234.click();
		
		WebElement Submit =driver.findElement(By.id("btnSave"));
		Submit.click();
		
		Thread.sleep(5000);

		String ActURL = driver.findElement(By.id("popup_message")).getText();
		System.out.println("ActURL"+ActURL);
		
		
		if(ActURL.equals("Please select minimum 5 Option details"))
		 {
			 
			System.out.println(ActURL);
			System.out.println("Pass");
			
			fileone.setCellData(sheetName, "Status", 23 , "Pass");	
		 }
		
		 else
		 {
			 
			 fileone.setCellData(sheetName, "Status", 23, "Fail");
			 

		 }
	
		driver.findElement(By.id("popup_ok")).click();
		
		Thread.sleep(3000);
		
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(ActURL, "Please select minimum 5 Option details", "Test Failed");
		
		WebElement OptionNew1234 =driver.findElement(By.id("btnAddmore"));
		OptionNew1234.click();

		Thread.sleep(3000);
		
		}
	
	
	
	
	
	@Test(priority=6)
	public void CAF_Accept_Fivepreference() throws InterruptedException {
		test = extent.createTest("CAF_Accept_Fivepreference");
		  //5th Option
		WebElement CollegeDistrict345 =driver.findElement(By.id("ddlCollegeDistrict"));
		CollegeDistrict345.sendKeys("ANGUL");
		
		Thread.sleep(2000);
		
		WebElement College2345 =driver.findElement(By.id("ddlCollege"));
		College2345.sendKeys("PAINCHKUL HIGHER SECONDARY SCHOOL, AIDA");
		
		
		Thread.sleep(2000);
		WebElement Stream2345 =driver.findElement(By.id("ddlStream"));
		Stream2345.sendKeys("ARTS");
		
		Thread.sleep(2000);
//		
//		

		WebElement Compulsary2345 =driver.findElement(By.id("ddlCompulsory"));
		Compulsary2345.sendKeys("MIL ODIA");
		
		Thread.sleep(2000);
		
		WebElement Elective1 =driver.findElement(By.id("ddlELE1"));
		Elective1.sendKeys("ECONOMICS");
		
		Thread.sleep(2000);
		
		WebElement Elective2 =driver.findElement(By.id("ddlELE2"));
		Elective2.sendKeys("HISTORY");
		
		Thread.sleep(2000);
		
		WebElement Elective3 =driver.findElement(By.id("ddlELE3"));
		Elective3.sendKeys("POLITICAL SCIENCE");
		
		Thread.sleep(2000);
		
		
		WebElement Elective4 =driver.findElement(By.id("ddl4thELE1"));
		Elective4.sendKeys("LANGUAGE ODIA");
		
		
		Thread.sleep(2000);
		
		WebElement Hostel12345 =driver.findElement(By.id("rbtAccomodation1"));
		Hostel12345.click();
		
		WebElement OptionNew1 =driver.findElement(By.id("btnAddmore"));
		OptionNew1.click();
		Thread.sleep(3000);

	
		WebElement Submit =driver.findElement(By.id("btnSave"));
		Submit.click();
		
		Thread.sleep(5000);
		
		String ActURL1 = driver.findElement(By.id("popup_title")).getText();
		System.out.println("ActURL1"+ ActURL1);
		
		
	if(ActURL1.equals("SAMS, Govt. of Odisha"))
		 {
			 
			System.out.println(ActURL1);
			System.out.println("Pass");
			
			fileone.setCellData(sheetName, "Status", 24 , "Pass");	
		 }
		
		 else
		 {
			 
			 fileone.setCellData(sheetName, "Status", 24 , "Fail");
			 

		 }
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(ActURL1, "SAMS, Govt. of Odisha", "Test Failed");
	
//		WebElement Ok =driver.findElement(By.id("popup_ok"));
//		Ok.click();
		
		
		Thread.sleep(600);
		
		
		
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
