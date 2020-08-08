package com.genericlib;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
public class Driver {
	
	public static WebDriver driver;
	public void getDriver()
	{
		if(constants.browser.equalsIgnoreCase("firefox"))
				{
			     driver = new FirefoxDriver();
				}
		else if(constants.browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\milan.singh\\Desktop\\chromedriver.exe");
			driver  = new ChromeDriver();
			
			driver.get(constants.url);
			
			
			
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
			
			
			
			
			
			
			
			System.out.println("Current URL " + driver.getCurrentUrl());
			
		}
		driver.manage().window().maximize();
		//return driver;
	}

}

