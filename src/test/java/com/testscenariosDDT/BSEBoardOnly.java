package com.testscenariosDDT;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.genericlib.GetData;
import com.genericlib.Xls_AllMethods;

public class BSEBoardOnly  {
	Xls_AllMethods fileone = new Xls_AllMethods("C:\\Users\\satyaranjan.m\\eclipse-workspace\\JuniorForm\\MappingJuniorDDT.xlsx");	
	XSSFWorkbook wb;
	XSSFSheet sht;
	String sheetName = "Result";
    int rowCount = fileone.getRowCount(sheetName);
  
    int rowNum =2;
	
	WebDriver driver;
	

	@Test(priority=0)
	public void rbutton() throws IOException, Exception
	{
		FileInputStream fis= new FileInputStream("C:\\Users\\satyaranjan.m\\eclipse-workspace\\JuniorForm\\config.properties");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\satyaranjan.m\\Desktop\\chromedriver_win32 (2)\\chromedriver.exe");
    	driver= new ChromeDriver();
    	driver.manage().deleteAllCookies();
    	driver.manage().window().maximize();
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
    	Thread.sleep(3000);
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
		Thread.sleep(5000);

	}
	
	@Test(priority=1)
	public void FormApply() throws InterruptedException {
		
		driver.findElement(By.xpath("//span[@class='menu-text']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[contains(text(),'CAF Apply')]")).click();
		Thread.sleep(3000);

	}

	@DataProvider
	public static Object[][] EnterData() throws Exception
	{
		GetData obj=new GetData();
		Object data[][]= obj.gettingdata("BSEODISHA");
		return data;
		
	}
	
	
	@Test(priority=2, dataProvider="EnterData")
	public void setData(String Board, String YoP, String Type, String Roll, String Photo, String AName, String FName, String MName, String Blood, String Gender, String Religion, 
			String BirthD, String BirthM, String BirthY, String Nationality, String MotherTongue, String Aadhaar, String Gmobile, String Orphan, 
			String State, String District, String Block, String HouseNo, String PIN, String CTCode, String TeleCode, String Mobile, String eMail, 
			String ReservationDetails, String Disabilities, String CoM, String OSA, String NCCA, String NCCC, String ScoutGuideOne,
			String ScoutGuideTwo, String Sports, String MaximumMark, String TotalMark, String English, String Mathematics, String Science,
			String SocialScience,String Grade, String Compartmentally, String Foccupation, String Moccupation, String AnnualIncome, String School,
			String Location, String Districttwo, String YoJ, String YoL, String HSSTypeA, String DistrictthreeA, String HSSA, String StreamA, String CompulsoryA,
			String FirstElectiveA, String SecondElectiveA, String ThirdElectiveA, String FirstChoiceA, String SecondChoiceA, String ThirdChoiceA,
			String HSSTypeB, String DistrictthreeB, String HSSB, String StreamB, String CompulsoryB,
			String FirstElectiveB, String SecondElectiveB, String ThirdElectiveB, String FirstChoiceB, String SecondChoiceB, String ThirdChoiceB,
			String HSSTypeC, String DistrictthreeC, String HSSC, String StreamC, String CompulsoryC,
			String FirstElectiveC, String SecondElectiveC, String ThirdElectiveC, String FirstChoiceC, String SecondChoiceC, String ThirdChoiceC,
			String HSSTypeD, String DistrictthreeD, String HSSD, String StreamD, String CompulsoryD,
			String FirstElectiveD, String SecondElectiveD, String ThirdElectiveD, String FirstChoiceD, String SecondChoiceD, String ThirdChoiceD,
			String HSSTypeE, String DistrictthreeE, String HSSE, String StreamE, String CompulsoryE,
			String FirstElectiveE, String SecondElectiveE, String ThirdElectiveE, String FirstChoiceE, String SecondChoiceE, String ThirdChoiceE ) throws Exception
	{
		
//		JavascriptExecutor js= (JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy(0,100)");
//		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//select[@id='ddlBoard']")).sendKeys(Board);
		driver.findElement(By.id("ddlYOP")).sendKeys(YoP);	
		
		if(Type.equals("Type"))
		{
			driver.findElement(By.id("rbtnAnnual")).click();;
		}
		else  {
			driver.findElement(By.id("rbtnSuppl")).click();;
		}
		
//		driver.findElement(By.id("rbtnAnnual")).sendKeys(Type);
		driver.findElement(By.id("txtBoardRoll")).clear();
		driver.findElement(By.id("txtBoardRoll")).sendKeys(Roll);
		
		WebElement Image =driver.findElement(By.id("ImgAppl"));
		Image.click();
		
		
Thread.sleep(3000);
String mainWindowName 	= driver.getWindowHandle();
Set<String> windows = driver.getWindowHandles();
for(String w : windows)
{
	driver.switchTo().window(w);
	Thread.sleep(2000);

	if(driver.getCurrentUrl().equalsIgnoreCase("http://o.samsodisha.gov.in/ONLINE_CAF/UploadPopUpJr.aspx"))
	{
		WebElement Imageupload =driver.findElement(By.xpath("//*[@id='imgUpload']"));
		Imageupload.sendKeys(Photo);
		Thread.sleep(600);
		WebElement upload =driver.findElement(By.name("upload"));
		upload.click();
		Thread.sleep(500);		
		WebElement okupload =driver.findElement(By.cssSelector("#form1 > div:nth-child(4) > table > tbody > tr:nth-child(5) > td > input:nth-child(1)"));
		okupload.click();
	}
}
Thread.sleep(1500);	        
driver.switchTo().window(mainWindowName);
		
		
Thread.sleep(200);

		
		driver.findElement(By.id("txtApplName")).clear();
		driver.findElement(By.id("txtApplName")).sendKeys(AName);
		
		driver.findElement(By.id("txtFatherName")).clear();
		driver.findElement(By.id("txtFatherName")).sendKeys(FName);
		
		driver.findElement(By.id("txtMotherName")).clear();
		driver.findElement(By.id("txtMotherName")).sendKeys(MName);
		
		
		//Personal Details
		
		driver.findElement(By.id("ddlBloodGroup")).sendKeys(Blood);
		
		driver.findElement(By.id("ddlGender")).sendKeys(Gender);
		
		driver.findElement(By.id("ddlReligion")).sendKeys(Religion);
		
		driver.findElement(By.id("ddlDay")).sendKeys(BirthD);
		
		driver.findElement(By.id("ddlMonth")).sendKeys(BirthM);
		
		driver.findElement(By.id("ddlYear")).sendKeys(BirthY);
		
		driver.findElement(By.id("ddlNationality")).sendKeys(Nationality);
		
		driver.findElement(By.id("ddlMt")).sendKeys(MotherTongue);
		
		driver.findElement(By.id("txtadhar")).clear();
		driver.findElement(By.id("txtadhar")).sendKeys(Aadhaar);
		Thread.sleep(3000);
		
		driver.findElement(By.id("txtParentMob")).clear();
		driver.findElement(By.id("txtParentMob")).sendKeys(Gmobile);
		
		driver.findElement(By.id("chkorph")).sendKeys(Orphan);
		Thread.sleep(3000);

		
		//Address for Correspondence
		driver.findElement(By.id("ddlCState")).sendKeys(State);
		Thread.sleep(3000);
		
		driver.findElement(By.id("ddlCDist")).sendKeys(District);
		Thread.sleep(3000);
		
		driver.findElement(By.id("ddlCBlock")).sendKeys(Block);
		Thread.sleep(3000);
	
		driver.findElement(By.id("txtCPS")).clear();
		driver.findElement(By.id("txtCPS")).sendKeys(HouseNo);
		
		driver.findElement(By.id("txtCPC")).clear();
		driver.findElement(By.id("txtCPC")).sendKeys(PIN);
		
		driver.findElement(By.id("txtCTCode")).clear();
		driver.findElement(By.id("txtCTCode")).sendKeys(CTCode);
		
		driver.findElement(By.id("txtCTeleNo")).clear();
		driver.findElement(By.id("txtCTeleNo")).sendKeys(TeleCode);
		
//		driver.findElement(By.id("txtCMobNo")).sendKeys(Mobile);
		driver.findElement(By.id("txtCEmail")).clear();
		driver.findElement(By.id("txtCEmail")).sendKeys(eMail);

		
		
		//Reservation Details
		
		if(ReservationDetails.equals("Schedule Tribe (ST)"))
		{
			driver.findElement(By.id("rbtST")).click();;
		}
		else if (ReservationDetails.equals("Schedule Caste (SC)")) {
			driver.findElement(By.id("rbtSC")).click();;
		}
		else if (ReservationDetails.equals("Other Backward Class (OBC)")) {
			driver.findElement(By.id("rbtnOBC")).click();;
		} 
		else if (ReservationDetails.equals("Socially and Educationally Backward Classes (SEBC) ")) {
			driver.findElement(By.id("rbtOther")).click();;
		} 
		else 	
		{
			driver.findElement(By.id("rbtGeneral")).click();
		}
		
		
		driver.findElement(By.id("chkPHOH")).sendKeys(Disabilities);
		
		if(CoM.equals("Ex-Service Man (ESM)"))
		{
			driver.findElement(By.id("rbtESM")).click();;
		}
		
		else if (CoM.equals("Children of Martyrs (CoM)")) {
			driver.findElement(By.id("rbtCoM")).click();;
		}
		
		else if (CoM.equals("Serving Defence Personnel (SDP)")) {
			driver.findElement(By.id("rbtSDP")).click();;
		} 
		
		else 	
		{
			driver.findElement(By.id("rbtNon")).click();
		}
//		driver.findElement(By.id("rbtCoM")).sendKeys(CoM);
		
		if(OSA.equals("No"))
		{
			driver.findElement(By.id("rbtOSAN")).click();;
		}
		else  {
			driver.findElement(By.id("rbtOSAY")).click();;
		}
		
		driver.findElement(By.id("rbtOSAN")).sendKeys(OSA);
		
		
		//Weightage Details 
		driver.findElement(By.id("chkNCCA")).sendKeys(NCCA);
		Thread.sleep(2000);
		driver.findElement(By.id("chkNCCC")).sendKeys(NCCC);
		Thread.sleep(2000);
		driver.findElement(By.id("chkSCRP")).sendKeys(ScoutGuideOne);
		
		Thread.sleep(2000);
		driver.findElement(By.id("chkSCPR")).sendKeys(ScoutGuideTwo);
		Thread.sleep(2000);
		driver.findElement(By.id("chkSportsN")).sendKeys(Sports);
		Thread.sleep(2000);
		
		
		
		//Details of Mark/Grade Secured in 10th Board
		driver.findElement(By.id("txtMaxMark")).click();
		driver.findElement(By.id("txtMaxMark")).sendKeys(MaximumMark);
		
		driver.findElement(By.id("txtTotMark")).clear();
		driver.findElement(By.id("txtTotMark")).sendKeys(TotalMark);
		
		driver.findElement(By.id("txtEnglish")).clear();
		driver.findElement(By.id("txtEnglish")).sendKeys(English);
		
		driver.findElement(By.id("txtMath")).clear();
		driver.findElement(By.id("txtMath")).sendKeys(Mathematics);
		
		driver.findElement(By.id("txtScience")).clear();
		driver.findElement(By.id("txtScience")).sendKeys(Science);
		
		driver.findElement(By.id("txtSocSci")).clear();
		driver.findElement(By.id("txtSocSci")).sendKeys(SocialScience);
		Thread.sleep(3000);
		
		driver.findElement(By.id("ddlGrade")).sendKeys(Grade);
		Thread.sleep(3000);
		
		driver.findElement(By.id("rbtCompartmentalN")).sendKeys(Compartmentally);
		Thread.sleep(3000);
		
		
		//Income Details of Parents
		
		driver.findElement(By.id("ddlFOcu")).sendKeys(Foccupation);
		
		driver.findElement(By.id("ddlMOcu")).sendKeys(Moccupation);
		
		driver.findElement(By.id("ddlAIncome")).sendKeys(AnnualIncome);		
		
		
		//Record of educational institution
		driver.findElement(By.id("txtschname")).sendKeys(School);
		
		driver.findElement(By.id("txtschloc")).sendKeys(Location);
		
		driver.findElement(By.id("ddlinstDistrict")).sendKeys(Districttwo);
		
		driver.findElement(By.id("ddlYOJ")).sendKeys(YoJ);

		
		//Blocker Issue need to discuss
	//	driver.findElement(By.xpath("//select[@id='ddlinstDistrict']")).sendKeys(Districttwo);
		
		//To be disscussed
//		driver.findElement(By.xpath("//select[@id='ddlYOJ']")).sendKeys(YoJ);
//		
//		driver.findElement(By.id("ddlYOL")).sendKeys(YoL);		
		
		
		//Enter here for 1st Option
		
		//driver.findElement(By.id("rbtOthersFinance")).sendKeys(HSSType); 
		if(HSSTypeA.equals("Govt. / Aided / Private"))
		{
			driver.findElement(By.id("rbtOthersFinance")).click();;
		}
		
		else if (HSSTypeA.equals("Self Financing")) {
			driver.findElement(By.id("rbtSelfFinance")).click();;
		}
		
		else if (HSSTypeA.equals("Vocational")) {
			driver.findElement(By.id("rbtVocational")).click();;
		} 
		
		else 	
		{
			driver.findElement(By.id("rbtSanskrit")).click();
		}
		Thread.sleep(2000);
		driver.findElement(By.id("ddlCollegeDistrict")).sendKeys(DistrictthreeA);
		Thread.sleep(2000);
		driver.findElement(By.id("ddlCollege")).sendKeys(HSSA);
		Thread.sleep(2000);
		driver.findElement(By.id("ddlStream")).sendKeys(StreamA);
		Thread.sleep(2000);
		driver.findElement(By.id("ddlCompulsory")).sendKeys(CompulsoryA);
		Thread.sleep(2000);
		driver.findElement(By.id("ddlELE1")).sendKeys(FirstElectiveA);
		Thread.sleep(2000);
		driver.findElement(By.id("ddlELE2")).sendKeys(SecondElectiveA);
		Thread.sleep(2000);
		driver.findElement(By.id("ddlELE3")).sendKeys(ThirdElectiveA);
		Thread.sleep(2000);
		driver.findElement(By.id("ddl4thELE1")).sendKeys(FirstChoiceA);
		Thread.sleep(2000);
		driver.findElement(By.id("ddl4thELE2")).sendKeys(SecondChoiceA);
		Thread.sleep(2000);
		driver.findElement(By.id("ddl4thELE3")).sendKeys(ThirdChoiceA);		
		Thread.sleep(2000);
		driver.findElement(By.id("btnAddmore")).click();
		
//		driver.findElement(By.id("rbtAccomodation2")).sendKeys(ThirdChoice);
		
		Thread.sleep(3000);
				
		if(HSSTypeB.equals("Govt. / Aided / Private"))
		{
			driver.findElement(By.id("rbtOthersFinance")).click();;
		}
		
		else if (HSSTypeB.equals("Self Financing")) {
			driver.findElement(By.id("rbtSelfFinance")).click();;
		}
		
		else if (HSSTypeB.equals("Vocational")) {
			driver.findElement(By.id("rbtVocational")).click();;
		} 
		
		else 	
		{
			driver.findElement(By.id("rbtSanskrit")).click();
		}
		Thread.sleep(2000);
		driver.findElement(By.id("ddlCollegeDistrict")).sendKeys(DistrictthreeB);
		Thread.sleep(2000);
		driver.findElement(By.id("ddlCollege")).sendKeys(HSSB);
		Thread.sleep(2000);
		driver.findElement(By.id("ddlStream")).sendKeys(StreamB);
		Thread.sleep(2000);
		driver.findElement(By.id("ddlCompulsory")).sendKeys(CompulsoryB);
		Thread.sleep(2000);
		driver.findElement(By.id("ddlELE1")).sendKeys(FirstElectiveB);
		Thread.sleep(2000);
		driver.findElement(By.id("ddlELE2")).sendKeys(SecondElectiveB);
		Thread.sleep(2000);
		driver.findElement(By.id("ddlELE3")).sendKeys(ThirdElectiveB);
		Thread.sleep(2000);
		driver.findElement(By.id("ddl4thELE1")).sendKeys(FirstChoiceB);
		Thread.sleep(2000);
		driver.findElement(By.id("ddl4thELE2")).sendKeys(SecondChoiceB);
		Thread.sleep(2000);
		driver.findElement(By.id("ddl4thELE3")).sendKeys(ThirdChoiceB);	
		Thread.sleep(2000);
		driver.findElement(By.id("btnAddmore")).click();
		
//		driver.findElement(By.id("rbtAccomodation2")).sendKeys(ThirdChoice);
		
		Thread.sleep(3000);
		
		if(HSSTypeC.equals("Govt. / Aided / Private"))
		{
			driver.findElement(By.id("rbtOthersFinance")).click();;
		}
		
		else if (HSSTypeC.equals("Self Financing")) {
			driver.findElement(By.id("rbtSelfFinance")).click();;
		}
		
		else if (HSSTypeC.equals("Vocational")) {
			driver.findElement(By.id("rbtVocational")).click();;
		} 
		
		else 	
		{
			driver.findElement(By.id("rbtSanskrit")).click();
		}
		
		driver.findElement(By.id("ddlCollegeDistrict")).sendKeys(DistrictthreeC);
		Thread.sleep(2000);
		driver.findElement(By.id("ddlCollege")).sendKeys(HSSC);
		Thread.sleep(2000);
		driver.findElement(By.id("ddlStream")).sendKeys(StreamC);
		Thread.sleep(2000);
		driver.findElement(By.id("ddlCompulsory")).sendKeys(CompulsoryC);
		Thread.sleep(2000);
		driver.findElement(By.id("ddlELE1")).sendKeys(FirstElectiveC);
		Thread.sleep(2000);
		driver.findElement(By.id("ddlELE2")).sendKeys(SecondElectiveC);
		Thread.sleep(2000);
		driver.findElement(By.id("ddlELE3")).sendKeys(ThirdElectiveC);
		Thread.sleep(2000);
		driver.findElement(By.id("ddl4thELE1")).sendKeys(FirstChoiceC);
		Thread.sleep(2000);
		driver.findElement(By.id("ddl4thELE2")).sendKeys(SecondChoiceC);
		Thread.sleep(2000);
		driver.findElement(By.id("ddl4thELE3")).sendKeys(ThirdChoiceC);		
		Thread.sleep(2000);
		driver.findElement(By.id("btnAddmore")).click();
//		driver.findElement(By.id("rbtAccomodation2")).sendKeys(ThirdChoice);
		
		Thread.sleep(3000);
		if(HSSTypeD.equals("Govt. / Aided / Private"))
		{
			driver.findElement(By.id("rbtOthersFinance")).click();;
		}
		
		else if (HSSTypeD.equals("Self Financing")) {
			driver.findElement(By.id("rbtSelfFinance")).click();;
		}
		
		else if (HSSTypeD.equals("Vocational")) {
			driver.findElement(By.id("rbtVocational")).click();;
		} 
		
		else 	
		{
			driver.findElement(By.id("rbtSanskrit")).click();
		}
		Thread.sleep(2000);
		driver.findElement(By.id("ddlCollegeDistrict")).sendKeys(DistrictthreeD);
		Thread.sleep(2000);
		driver.findElement(By.id("ddlCollege")).sendKeys(HSSD);
		Thread.sleep(2000);
		driver.findElement(By.id("ddlStream")).sendKeys(StreamD);
		Thread.sleep(2000);
		driver.findElement(By.id("ddlCompulsory")).sendKeys(CompulsoryD);
		Thread.sleep(2000);
		driver.findElement(By.id("ddlELE1")).sendKeys(FirstElectiveD);
		Thread.sleep(2000);
		driver.findElement(By.id("ddlELE2")).sendKeys(SecondElectiveD);
		Thread.sleep(2000);
		driver.findElement(By.id("ddlELE3")).sendKeys(ThirdElectiveD);
		Thread.sleep(2000);
		driver.findElement(By.id("ddl4thELE1")).sendKeys(FirstChoiceD);
		Thread.sleep(2000);
		driver.findElement(By.id("ddl4thELE2")).sendKeys(SecondChoiceD);
		Thread.sleep(2000);
		driver.findElement(By.id("ddl4thELE3")).sendKeys(ThirdChoiceD);	
		Thread.sleep(2000);
		driver.findElement(By.id("btnAddmore")).click();
		
//		driver.findElement(By.id("rbtAccomodation2")).sendKeys(ThirdChoice);
		
		Thread.sleep(3000);
		if(HSSTypeE.equals("Govt. / Aided / Private"))
		{
			driver.findElement(By.id("rbtOthersFinance")).click();;
		}
		
		else if (HSSTypeE.equals("Self Financing")) {
			driver.findElement(By.id("rbtSelfFinance")).click();;
		}
		
		else if (HSSTypeE.equals("Vocational")) {
			driver.findElement(By.id("rbtVocational")).click();;
		} 
		
		else 	
		{
			driver.findElement(By.id("rbtSanskrit")).click();
		}
		Thread.sleep(2000);
		driver.findElement(By.id("ddlCollegeDistrict")).sendKeys(DistrictthreeE);
		Thread.sleep(2000);
		driver.findElement(By.id("ddlCollege")).sendKeys(HSSE);
		Thread.sleep(2000);
		driver.findElement(By.id("ddlStream")).sendKeys(StreamE);
		Thread.sleep(2000);
		driver.findElement(By.id("ddlCompulsory")).sendKeys(CompulsoryE);
		Thread.sleep(2000);
		driver.findElement(By.id("ddlELE1")).sendKeys(FirstElectiveE);
		Thread.sleep(2000);
		driver.findElement(By.id("ddlELE2")).sendKeys(SecondElectiveE);
		Thread.sleep(2000);
		driver.findElement(By.id("ddlELE3")).sendKeys(ThirdElectiveE);
		Thread.sleep(2000);
		driver.findElement(By.id("ddl4thELE1")).sendKeys(FirstChoiceE);
		Thread.sleep(2000);
		driver.findElement(By.id("ddl4thELE2")).sendKeys(SecondChoiceE);
		Thread.sleep(2000);
		driver.findElement(By.id("ddl4thELE3")).sendKeys(ThirdChoiceE);		
		Thread.sleep(2000);
		
		driver.findElement(By.id("btnAddmore")).click();
//		driver.findElement(By.id("rbtAccomodation2")).sendKeys(ThirdChoice);
		
		Thread.sleep(3000);
//		driver.findElement(By.id("btnSave")).click();
		//input[@id='btnSave']
		
		driver.findElement(By.id("btnSave")).click();
		Thread.sleep(2000);
		
		
		String ActURL = driver.findElement(By.id("popup_title")).getText();
		System.out.println(ActURL);
		String exptext = "SAMS, Govt. of Odisha";
		
		if(ActURL.equals(exptext))
		 {
			
		 fileone.setCellData(sheetName, "Status", rowNum , "Pass");

		 
		 }
		
		 else
		 {
			 
			 fileone.setCellData(sheetName, "Status", rowNum, "Fail");
			 

		 }
	
		
		//driver.findElement(By.id("popup_ok")).click();
		
		
		
		

	}
	
	
}
