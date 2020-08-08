package com.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OptionDetails {
	
	
	@FindBy(id="ddlCollegeDistrict")
	private WebElement TypeCollegeDistrict;
	
	@FindBy(id="ddlCollege")
	private WebElement TypeCollege;
	
	
	@FindBy(id="ddlStream")
	private WebElement TypeStream;
	
	
	
	
	@FindBy(id="ddlCompulsory")
	private WebElement TypeCompulsary;
	
	
	
	
	
	@FindBy(id="ddlELE1")
	private WebElement TypeElective1;
	
	
	
	
	@FindBy(id="ddlELE2")
	private WebElement TypeElective2;
	
	
	
	
	
	@FindBy(id="ddlELE3")
	private WebElement TypeElective3;
	
	
	
	@FindBy(id="ddl4thELE1")
	private WebElement TypeForthElective1;
	
	
	@FindBy(id="ddl4thELE2")
	private WebElement TypeForthElective2;
	
	
	
	@FindBy(id="ddl4thELE3")
	private WebElement TypeForthElective3;
	
	
	@FindBy(id="button")
	private WebElement OptionNew;
	
	
	@FindBy(id="button2")
	private WebElement OptionNewSecond;
	
	
	
	
	@FindBy(id="button3")
	private WebElement OptionNewThird;
	
	
	
	@FindBy(id="button4")
	private WebElement OptionNewForth;
	
	@FindBy(id="button5")
	private WebElement OptionNewFifth;
	
	
	
	
	public WebElement SelectTypeCollegeDistrictn(String CollegeDistrict)
	{
		return TypeCollegeDistrict;
	}
	
	public WebElement SelectTypeCollege(String College)
	{
		return TypeCollege;
	}
	
	public WebElement SelectStream(String Streamm)
	{
		return TypeStream;
	}
	
	
	public WebElement SelectTypeCompulsary(String Compulsary)
	{
		return TypeCompulsary;
	}
	
	public WebElement SelectTypeElective1(String Elective1)
	{
		return TypeElective1;
	}
	
	public WebElement SelectTypeElective2(String Elective2)
	{
		return TypeElective2;
	}
	
	
	public WebElement SelectTypeElective3(String Elective3)
	{
		return TypeElective3;
	}
	
	
	public WebElement SelectTypeForthElective1(String ForthElective1)
	{
		return TypeForthElective1;
	}
	
	
	
	public WebElement SelectTypeForthElective2(String ForthElective2)
	{
		return TypeForthElective2;
	}
	
	
	public WebElement SelectTypeForthElective3(String ForthElective3)
	{
		return TypeForthElective3;
	}
	
	public WebElement ClickOptionNew()
	{
		return OptionNew;
	}
	
	
	public WebElement ClickOptionNewSecond()
	{
		return OptionNewSecond;
	}
	
	
	public WebElement ClickOptionNewThird()
	{
		return OptionNewThird;
	}
	
	public WebElement ClickOptionNewForth()
	{
		return OptionNewForth;
	}
	
	public WebElement ClickOptionNewFifth()
	{
		return OptionNewFifth;
	}
	
}
