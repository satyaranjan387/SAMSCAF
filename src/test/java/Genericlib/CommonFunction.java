package Genericlib;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Pattern;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.inject.matcher.Matcher;

public class CommonFunction {
	 WebDriver driver;
	    WebDriverWait wait;
	    Properties properties;
	 
	    static Xls_AllMethods fileone = new Xls_AllMethods("C:\\Users\\satyaranjan.m\\eclipse-workspace\\JuniorForm\\JuniorFieldValidationwrite.xlsx");	
		
		String sheetName = "JuniorFieldMapping";
	   
	 
	    public void openBrowser(String browserName) {
	        if (browserName.equalsIgnoreCase("Firefox")) {
	            System.setProperty("webdriver.gecko.driver", properties.getProperty("gecko.path"));
	            driver = new FirefoxDriver();
	            driver.manage().window().maximize();
	        } else if (browserName.equalsIgnoreCase("chrome")) {
	            System.setProperty("webdriver.chrome.driver","C:/Users/satyaranjan.m//Desktop/chromedriver_win32 (2)/chromedriver.exe");
	            driver = new ChromeDriver();
	            driver.manage().window().maximize();
	        }
//	            else if (browserName.equalsIgnoreCase("IE")) {
//	                driver = new InternetExplorerDriver();sssssssss
//	            }
	    }
	 
	    public void openUrl(String url) {
	        driver.navigate().to(url);
	        
	        driver.findElement(By.xpath("//*[@id=\"maincontaint\"]/div/div[2]/div[1]/div/a")).click();
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
	    }
	 
	    private By locatorValue(String locatorType, String value) {
	        By by;
	        switch (locatorType) {
	            case "id":
	                by = By.id(value);
	                break;
	            case "name":
	                by = By.name(value);
	                break;
	            case "xpath":
	                by = By.xpath(value);
	                break;
	            case "css":
	                by = By.cssSelector(value);
	                break;
	            case "linkText":
	                by = By.linkText(value);
	                break;
	            case "partialLinkText":
	                by = By.partialLinkText(value);
	                break;
	            default:
	                by = null;
	                break;
	        }
	        return by;
	    }
	    
	   
	 
	    public void enterText(String locatorType, String value, String text) {
	    	
	    	//System.out.println("Pass");
	            By locator = locatorValue(locatorType, value);
	            WebElement element = driver.findElement(locator);
	        element.clear();
	            element.sendKeys(text);
	    }
	    
	    
	    
	   By popup = By.id("popup_message");
	   
	   public WebElement grtpopup() {
		   
		   return driver.findElement(popup);
	   }
//public void GetMessage(String locatorType, String value) {
//	    	
//	    	//System.out.println("Pass");
//	            By locator = locatorValue(locatorType, value);
//	            WebElement element = driver.findElement(locator);
//	           // element.clear();
//	           // element.getText();
//	    }
//	    
	    
	    
	    public void CheckMaxLength (String locatorType, String value, String text,String attribute,String Data,int x)
	    {
	    	By locator = locatorValue(locatorType, value);
	        WebElement element = driver.findElement(locator);
	        element.clear();
            element.sendKeys(text);
	        Data =element.getAttribute(attribute);
	        
	        int datalength = Data.length();
	        
	        if(datalength==x)
	        {
	        	System.out.println("Pass");
	        }
	    }
	    
	    
	    public void CheckSpecialChar (String locatorType, String value, String text,String attribute,String Data)
	    {
	    	By locator = locatorValue(locatorType, value);
	        WebElement element = driver.findElement(locator);
	        element.clear();
            element.sendKeys(text);
	        Data =element.getAttribute(attribute);
	
	        Pattern special = Pattern.compile ("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
			java.util.regex.Matcher matcher = special.matcher(Data);
			boolean constainsSpecial = matcher.find();
			
			
			if(constainsSpecial == true)
			{
				System.out.println("Special Char Allowed");
			}
			else
			{
				System.out.println("Special Char Not Allowed");
			}
	        
	        
	        
	
	    }
	    
	    
	    public void CheckSqlChar (String locatorType, String value, String text,String attribute,String Data)
	    {
	    	By locator = locatorValue(locatorType, value);
	        WebElement element = driver.findElement(locator);
	        element.clear();
            element.sendKeys(text);
	        Data =element.getAttribute(attribute);
	
	        Pattern special = Pattern.compile ("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
			java.util.regex.Matcher matcher = special.matcher(Data);
			boolean constainsSpecial = matcher.find();
			
			
			if(constainsSpecial == true)
			{
				System.out.println("Special Char Allowed");
			}
			else
			{
				System.out.println("Special Char Not Allowed");
			}
	        
	        
	        
	
	    }
	    
	    
	    
	    public void LoginPage() throws InterruptedException
	    {
	    	enterText("name","txtSMobileNo","7381894032");
	    	Thread.sleep(200);
	    	enterText("name","txtSPwd","Password@123");
	    	Thread.sleep(200);
	    	String cptcha = driver.findElement(By.xpath("//*[@id=\"lblCaptcha\"]")).getText();
			driver.findElement(By.id("txtRandno")).sendKeys(cptcha);
			
			clickOnLocator("id","btnSIGNIN");
	    }
	    
	    
	    
	    
	    public void Navigation() throws InterruptedException
	    {
	    	//Thread.sleep(2000);
	    	//clickOnLocator("xpath","//*[@id=\"leftmenu_divDiploma\"]/ul/li/a/span");
	    	Thread.sleep(2000);
	    	clickOnLocator("xpath","//a[contains(text(),'CAF Apply')]");
	    }
	    
	    
	    
public void SelectDropdown(String locatorType, String value, String text) {
	    	
	    	//System.out.println("Pass");
	            By locator = locatorValue(locatorType, value);
	            Select dropdown = new Select(driver.findElement(locator));
	            dropdown.selectByVisibleText(text);
	    }



public void GetSelectDropdown(String locatorType, String value, String text) {
	
	
	
	
	
	By locator = locatorValue(locatorType, value);
	
	Select select = new Select(driver.findElement(locator));
	WebElement option = select.getFirstSelectedOption();
	String defaultItem = option.getText();
	
   if (defaultItem.equals(text))
   {
	   System.out.println("Pass");
   }
    
        
}
	 
	 
	    public void clickOnLocator(String locatorType, String value) {
	    	
	    	System.out.println("Pass");
	        By locator = locatorValue(locatorType, value);
	        WebElement element = driver.findElement(locator);
	        element.click();
	    }
	 
	    public void closeBrowser() {
	         wait = new WebDriverWait(driver,2);
	         driver.close();
	    }
	    
	    
	   
	    
	    
	    public int getSqlCharacterCount(String Data)
		{
			
			
			Pattern special = Pattern.compile ("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
			java.util.regex.Matcher matcher = special.matcher(Data);
			boolean constainsSpecial = matcher.find();
			
			
			if(constainsSpecial == true)
			{
				System.out.println("Fail");
			}
			else
			{
				System.out.println("Pass");
			}
			
			
			return 0;
			
		}

	    
		public void checkalphabets(String locatorType, String value, String text,String attribute,String Data)
		{
			By locator = locatorValue(locatorType, value);
	        WebElement element = driver.findElement(locator);
	        element.clear();
            element.sendKeys(text);
	        Data =element.getAttribute(attribute);
	        
	        Pattern special = Pattern.compile("[a-zA-z]");
			java.util.regex.Matcher matcher = special.matcher(Data);
			boolean constainsSpecial = matcher.find();
			
			
			if(constainsSpecial == true)
			{
				System.out.println("AlphabetsAllowed");
			}
			else
			{
				System.out.println("AlphabetsNotAllowed");
			}
		}
		
		
		
		public void checkalphaNumeric(String locatorType, String value, String text,String attribute,String Data)
		{
			By locator = locatorValue(locatorType, value);
	        WebElement element = driver.findElement(locator);
	        element.clear();
            element.sendKeys(text);
	        Data =element.getAttribute(attribute);
	        
	        Pattern special = Pattern.compile("[a-zA-Z0-9]");
			java.util.regex.Matcher matcher = special.matcher(Data);
			boolean constainsSpecial = matcher.find();
			
			
			if(constainsSpecial == true)
			{
				System.out.println("Pass");
			}
			else
			{
				System.out.println("Fail");
			}
		}
		
		
		public void checkNumeric(String locatorType, String value, String text,String attribute,String Data)
		{
			By locator = locatorValue(locatorType, value);
	        WebElement element = driver.findElement(locator);
	        element.clear();
            element.sendKeys(text);
	        Data =element.getAttribute(attribute);
	        
	        Pattern special = Pattern.compile("[0-9]");
			java.util.regex.Matcher matcher = special.matcher(Data);
			boolean constainsSpecial = matcher.find();
			
			
			if(constainsSpecial == true)
			{
				System.out.println("Numeric Allowed");
			}
			else
			{
				System.out.println("Numeric Not Allowed");
			}
		}
		
	
		public void UploadImage()
		{
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
			
		}
	
	    public boolean verify(String locatorType, String value,String attribute,String valueToCheck){
	        By locator = locatorValue(locatorType, value);
	        WebElement element = driver.findElement(locator);
	        String elementValue =element.getAttribute(attribute);
	        if(valueToCheck != null){
	            return valueToCheck.equalsIgnoreCase(elementValue);
	        }
	        return element != null;
	    }
}
