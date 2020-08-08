 package FieldText;
 
 import java.io.FileInputStream;
 import java.io.FileNotFoundException;
 import java.io.IOException;
 import java.util.ArrayList;
 import java.util.Iterator;
 import java.util.List;
 import java.util.Properties;
 import java.util.Set;
 import java.util.concurrent.TimeUnit;

 import org.apache.poi.xssf.usermodel.XSSFRow;
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

 import org.testng.annotations.BeforeMethod;
 import org.testng.annotations.BeforeTest;
 import org.testng.annotations.DataProvider;
 import org.testng.annotations.Listeners;
 import org.testng.annotations.Test;
 import org.testng.asserts.SoftAssert;

 import com.aventstack.extentreports.ExtentReports;
 import com.aventstack.extentreports.ExtentTest;
 import com.aventstack.extentreports.Status;
 import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
 import com.aventstack.extentreports.reporter.configuration.Theme;
 import Genericlib.ExcelUtils;

 import Genericlib.CommonFunction;
 import Genericlib.Xls_AllMethods;

public class VerifyOtherCondition {
	@SuppressWarnings("deprecation")
	public ExtentHtmlReporter htmlReporter;
	static Xls_AllMethods fileone = new Xls_AllMethods("C:\\Users\\milan.singh\\eclipse-workspace\\JuniorFieldPart\\JuniorFieldValidationwrite.xlsx");	
	//static WebDriver driver;
	XSSFWorkbook wb;
	XSSFSheet sht;
	String sheetName = "JuniorFieldMapping";
    int rowCount = fileone.getRowCount(sheetName);
    ExtentReports extent;
    public ExtentTest test;
    
    static WebDriver driver;
	CommonFunction data = new CommonFunction();
    @BeforeTest
	public void SetupReport() throws IOException
	{
    	htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/FieldText/VerifyOtherCondition-Report.html");

		htmlReporter.config().setDocumentTitle("Automation CAF"); 
		htmlReporter.config().setReportName("Functional Testing"); 
		
		htmlReporter.config().setTheme(Theme.DARK);
		  
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		extent.setSystemInfo("Host name", "Test Server");
		extent.setSystemInfo("Environment", "QC");
	}
    
    @BeforeMethod
    public void Setup() throws IOException, InterruptedException
    {
    	data.openBrowser("chrome");
		Thread.sleep(500);
		
		data.openUrl("http://o.samsodisha.gov.in/");
		
		Thread.sleep(500);
		data.LoginPage();
		
		Thread.sleep(500);
          data.Navigation();
    }
    
    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
		  if (result.getStatus() == ITestResult.FAILURE) {
		   test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getName()); // to add name in extent report
		   test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getThrowable()); // to add error/exception in extent report
		   //String screenshotPath = Testc.getScreenshot(driver, result.getName());
		  //s test.addScreenCaptureFromPath(screenshotPath);// adding screen shot
		  } else if (result.getStatus() == ITestResult.SKIP) {
		   test.log(Status.SKIP, "Test Case SKIPPED IS " + result.getName());
		  }
		  else if (result.getStatus() == ITestResult.SUCCESS) {
		   test.log(Status.PASS, "Test Case PASSED IS " + result.getName());
		  }
			extent.flush();
			driver.quit();
		 
		 }
    
   @DataProvider
   	public static Object[][] MandatoryData() throws Exception
   	{
   		ExcelUtils obj = new ExcelUtils();
   		
   		Object data[] [] = obj.gettingJuniorCAFdata("JuniorCAF");
   		System.out.println("Pass");
           return data;
   		
   	}
    @Test(priority=0,dataProvider="MandatoryData")
   	public void CheckOtherCondition(String NameOfBoard
,String YearofPassing,String RollNumber,String ApplicantName
   			,String FatherName,String MotherName,String BloodGroup,String Gender,String Religion,String Day
   			,String Month,String Year,String Nationality,String MotherTongue,String AadhaarNo,String GuardianMobileNo

,String State,String District,String Block,String HouseNo,String PINCode,String AreaCode,String PhoneNo


,String eMail,String MaximumMark,String TotalMarkSecured,String English,String Mathematics,String Science,String SocialScience,String FatherOccupation

,String MotherOccupation,String AnnualIncome,String NameofSchool,String LocationOfSchool,String Districtt,String YearofJoining,String AccountNumber
,String IFSCNumber,String MICRCode,String BankName,String BranchName,String Grade,String SubjectName
,String FailMark
,String PassMark


) throws InterruptedException, IOException
   	{
    	
    	
    	test = extent.createTest("CheckOtherCondition");
    	
    	
    	 FileInputStream myFile= new FileInputStream("C:\\Users\\milan.singh\\eclipse-workspace\\JuniorFieldPart\\JuniorFieldValidationData.xlsx");
	   		//FileInputStream fis = new FileInputStream(myFile);
	   		XSSFWorkbook myWorkBook = new XSSFWorkbook(myFile);
	   		XSSFSheet mySheet = myWorkBook.getSheet("JuniorCAF");
	   		XSSFRow row = null;
	    
	   		int rowCount =350;
	   	//System.out.println(rowCount);

	   	for (int j = 336; j < rowCount; j++)
	   	{
	   		 YearofPassing=mySheet.getRow(j).getCell(1).getStringCellValue();
	   		 
	   		RollNumber=mySheet.getRow(j).getCell(2).getStringCellValue();
	   		
	   		
	   		ApplicantName=mySheet.getRow(j).getCell(3).getStringCellValue();
	   		
	   		
	   		FatherName=mySheet.getRow(j).getCell(4).getStringCellValue();
	   		
	   		
	   		MotherName=mySheet.getRow(j).getCell(5).getStringCellValue();
	   		
	   		
	   		BloodGroup=mySheet.getRow(j).getCell(6).getStringCellValue();
	   		
	   		
	   		
	   		Gender=mySheet.getRow(j).getCell(7).getStringCellValue();
	   		
	   		
	   		
	   		Religion=mySheet.getRow(j).getCell(8).getStringCellValue();
	   		Day=mySheet.getRow(j).getCell(9).getStringCellValue();
	   		Month=mySheet.getRow(j).getCell(10).getStringCellValue();
	   		Year=mySheet.getRow(j).getCell(11).getStringCellValue();
	   		
	   		Nationality=mySheet.getRow(j).getCell(12).getStringCellValue();
	   		MotherTongue=mySheet.getRow(j).getCell(13).getStringCellValue();
	   		AadhaarNo=mySheet.getRow(j).getCell(14).getStringCellValue();
	   		GuardianMobileNo=mySheet.getRow(j).getCell(15).getStringCellValue();
	   		State=mySheet.getRow(j).getCell(16).getStringCellValue();
	   		District=mySheet.getRow(j).getCell(17).getStringCellValue();
	   		Block=mySheet.getRow(j).getCell(18).getStringCellValue();
	   		HouseNo=mySheet.getRow(j).getCell(19).getStringCellValue();
	   		PINCode=mySheet.getRow(j).getCell(20).getStringCellValue();
	   		AreaCode=mySheet.getRow(j).getCell(21).getStringCellValue();
	   		PhoneNo=mySheet.getRow(j).getCell(22).getStringCellValue();
	   		eMail=mySheet.getRow(j).getCell(23).getStringCellValue();
	   		MaximumMark=mySheet.getRow(j).getCell(24).getStringCellValue();
	   		TotalMarkSecured=mySheet.getRow(j).getCell(25).getStringCellValue();
	   		English=mySheet.getRow(j).getCell(26).getStringCellValue();
	   		Mathematics=mySheet.getRow(j).getCell(27).getStringCellValue();
	   		Science=mySheet.getRow(j).getCell(28).getStringCellValue();
	   		SocialScience=mySheet.getRow(j).getCell(29).getStringCellValue();
	   		FatherOccupation=mySheet.getRow(j).getCell(30).getStringCellValue();
	   		MotherOccupation=mySheet.getRow(j).getCell(31).getStringCellValue();
	   		AnnualIncome=mySheet.getRow(j).getCell(32).getStringCellValue();
	   		NameofSchool=mySheet.getRow(j).getCell(33).getStringCellValue();
	   		LocationOfSchool=mySheet.getRow(j).getCell(34).getStringCellValue();
	   		Districtt=mySheet.getRow(j).getCell(35).getStringCellValue();
	   		YearofJoining=mySheet.getRow(j).getCell(36).getStringCellValue();
	   		AccountNumber=mySheet.getRow(j).getCell(37).getStringCellValue();
	   		IFSCNumber=mySheet.getRow(j).getCell(38).getStringCellValue();
	   		MICRCode=mySheet.getRow(j).getCell(39).getStringCellValue();
	   		BankName=mySheet.getRow(j).getCell(40).getStringCellValue();
	   		BranchName=mySheet.getRow(j).getCell(41).getStringCellValue();
	   		Grade=mySheet.getRow(j).getCell(42).getStringCellValue();
	   		SubjectName=mySheet.getRow(j).getCell(43).getStringCellValue();
	   		FailMark=mySheet.getRow(j).getCell(44).getStringCellValue();
	   		PassMark=mySheet.getRow(j).getCell(45).getStringCellValue();
	   		
	   		data.SelectDropdown("id","ddlYOP",YearofPassing);
	   		
	   		Thread.sleep(300);
	   		data.clickOnLocator("id","rbtnAnnual");
	   		Thread.sleep(300);
	   		data.enterText("id","txtBoardRoll",RollNumber);
	   		Thread.sleep(300);
	   		data.enterText("id","txtApplName",ApplicantName);
	   		Thread.sleep(300);
	   		data.enterText("id","txtFatherName",FatherName);
	   		Thread.sleep(300);
	   		data.enterText("id","txtMotherName",MotherName);
	   		Thread.sleep(300);
	   		data.SelectDropdown("id","ddlBloodGroup",BloodGroup);
	   		Thread.sleep(300);
	   		data.SelectDropdown("id","ddlGender",Gender);
	   		Thread.sleep(300);
	   		data.SelectDropdown("id","ddlReligion",Religion);
	   		Thread.sleep(300);
	   		data.SelectDropdown("id","ddlDay",Day);
	   		Thread.sleep(300);
	   		data.SelectDropdown("id","ddlMonth",Month);
	   		Thread.sleep(300);
	   		data.SelectDropdown("id","ddlYear",Year);
	   		Thread.sleep(300);
	   		data.SelectDropdown("id","ddlNationality",Nationality);
	   		Thread.sleep(300);
	   		data.SelectDropdown("id","ddlMt",MotherTongue);
	   		Thread.sleep(300);
	   		data.enterText("id","txtadhar",AadhaarNo);
	   		Thread.sleep(300);
	   		data.enterText("id","txtParentMob",PhoneNo);
	   		//Thread.sleep(300);
	   		Thread.sleep(1300);
	   		data.SelectDropdown("id","ddlCState",State);
	   		Thread.sleep(1300);
	   		data.SelectDropdown("id","ddlCDist",District);
	   		Thread.sleep(1300);
	   		data.SelectDropdown("id","ddlCBlock",Block);
	   		Thread.sleep(300);
	   		data.enterText("id","txtCPS",HouseNo);
	   		Thread.sleep(300);
	   		data.enterText("id","txtCPC",PINCode);
	   		Thread.sleep(300);
	   		data.enterText("id","txtCTCode",AreaCode);
	   		Thread.sleep(300);
	   		data.enterText("id","txtCTeleNo",PhoneNo);
	   		Thread.sleep(300);
	   		data.enterText("id","txtCEmail",eMail);
	   		Thread.sleep(300);
	   		data.enterText("id","txtMaxMark",MaximumMark);
	   		Thread.sleep(300);
	   		data.enterText("id","txtTotMark",TotalMarkSecured);
	   		Thread.sleep(300);
	   		data.enterText("id","txtEnglish",English);
	   		Thread.sleep(300);
	   		data.enterText("id","txtMath",Mathematics);
	   		Thread.sleep(300);
	   		data.enterText("id","txtScience",Science);
	   		Thread.sleep(300);
	   		data.enterText("id","txtSocSci",SocialScience);
	   		Thread.sleep(300);
	   		data.SelectDropdown("id","ddlGrade",Grade);
	   		Thread.sleep(300);
	   		
	   		
	   		
	   		
	   		data.clickOnLocator("id","rbtCompartmentalY");
	   		
	   		
	   		
	   		Thread.sleep(300);
	   		data.SelectDropdown("id","ddlCompSubject1",SubjectName);
	   		Thread.sleep(300);
	   		data.enterText("id","txtCompFMark1",FailMark);
	   		
	   		
	   		Thread.sleep(300);
	   		data.enterText("id","txtCompPMark1",PassMark);
	   		Thread.sleep(300);
	   		data.SelectDropdown("id","ddlFOcu",FatherOccupation);
	   		Thread.sleep(300);
	   		data.SelectDropdown("id","ddlMOcu",MotherOccupation);
	   		Thread.sleep(300);
	   		data.SelectDropdown("id","ddlAIncome",AnnualIncome);
	   		Thread.sleep(300);
	   		data.enterText("id","txtacno",AccountNumber);
	   		Thread.sleep(300);
	   		data.enterText("id","txtifsc",IFSCNumber);
	   		Thread.sleep(300);
	   		data.enterText("id","txtmicr",MICRCode);
	   		Thread.sleep(300);
	   		
	   		
	   		Actions action1 = new Actions(driver);
	    	WebElement we = driver.findElement(By.id("txtBankname"));
	    	action1.moveToElement(we).click().perform();
	   		
	    	Thread.sleep(300);
	    	data.enterText("id","txtBankname",BankName);
	    	
	    	Thread.sleep(300);
	    	data.enterText("id","txtBrname",BranchName);
	    	
	    	
	    	Thread.sleep(300);
	   		data.enterText("id","txtschname",NameofSchool);
	   		
	   		
	   		Thread.sleep(300);
	   		data.enterText("id","txtschloc",LocationOfSchool);
	   		
	   		
	   		
	   		Thread.sleep(300);
	   		data.SelectDropdown("id","ddlinstDistrict",Districtt);
	   		
	   		
	   		
	   		Thread.sleep(300);
	   		data.SelectDropdown("id","ddlYOJ",YearofJoining);
	   		
	   		Thread.sleep(300);
	   		data.UploadImage();
	   		
	   		Thread.sleep(300);
	   		data.clickOnLocator("id","btnSave");
	   		
			//driver.findElement(By.id("btnSave")).click();
			Thread.sleep(1000);
			String wbs2 = driver.findElement(By.id("popup_title")).getText();
	    	
			String expectedmessage = "You have entered 5 Option .\r\n" + 
					"Click OK to submit.\r\n" + 
					"Click Cancel to add more options.";
	    	
	    	System.out.println(wbs2);
	    	// Assert.assertEquals(previousAddress, ActAddress, "Duplicated Address not accepting");
	    	 if(wbs2 != expectedmessage)
	    	 {
	    		 System.out.println("Sucessfully Message is" + wbs2);
	    		fileone.setCellData(sheetName, "Result", j , "Pass");	
	    	 }
	    	
	    	 else
	    	 {
	    		 fileone.setCellData(sheetName, "Result", j, "Fail");
	    	 }	
	    	 
	    	 SoftAssert softAssert = new SoftAssert();
	    	 softAssert.assertEquals(wbs2, wbs2);

	   	}
 	
 	
   	}
}
