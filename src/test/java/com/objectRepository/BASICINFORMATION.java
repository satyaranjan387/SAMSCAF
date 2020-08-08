package com.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BASICINFORMATION {
	
	@FindBy(id="ddlBoard")
	private WebElement typeBoardName;
	
	
	
	@FindBy(id="ddlYOP")
	private WebElement typeYearOfPassing;
	
	
	@FindBy(id="rbtnAnnual")
	private WebElement typeAnnual;
	
	
	
	
	@FindBy(id="txtBoardRoll")
	private WebElement typeBoardRoll;
	
	
	@FindBy(id="txtApplName")
	private WebElement typeApplicantName;
	
	
	
	
	@FindBy(id="txtFatherName")
	private WebElement typeFatherName;
	
	
	@FindBy(id="txtMotherName")
	private WebElement typeMotherName;
	
	@FindBy(id="ddlBloodGroup")
	private WebElement typeBloodGroup;
	
	
	@FindBy(id="ddlGender")
	private WebElement typeGender;
	
	
	
	@FindBy(id="ddlReligion")
	private WebElement typeReligion;
	
	
	@FindBy(id="ddlDay")
	private WebElement typeDay;
	
	
	@FindBy(id="ddlMonth")
	private WebElement typeMonth;
	
	
	@FindBy(id="ddlYear")
	private WebElement typeYear;
	
	
	
	@FindBy(id="ddlNationality")
	private WebElement typeNationality;
	
	
	
	@FindBy(id="ddlMt")
	private WebElement typeMothertongue;
	
	
	@FindBy(id="txtadhar")
	private WebElement typeAadhar;
	
	
	@FindBy(id="txtParentMob")
	private WebElement typeParentMobileNo;
	
	
	
	
	public WebElement SelectBoardName(String Boardname)
	{
		return typeBoardName;
	}
	
	
	public WebElement SelectYearOfPassing(String PassingYear)
	{
		return typeYearOfPassing;
	}
	
	
	public WebElement ClickExamType()
	{
		return typeAnnual;
	}
	
	
	public WebElement gettypeBoardRoll(String Rollnumber)
	{
		return typeBoardRoll;
	}
	
	
	public WebElement gettypeApplicantName()
	{
		return typeApplicantName;
	}
	public WebElement gettypeFatherName()
	{
		return typeFatherName;
	}
	
	
	
	public WebElement gettypeMotherName()
	{
		return typeMotherName;
	}
	
	
	
	public WebElement SelectBloodGroup(String BloodGroup)
	{
		return typeBloodGroup;
	}
	
	
	
	public WebElement SelectGender(String Gender)
	{
		return typeGender;
	}
	
	
	
	public WebElement SelectReligion(String Religion)
	{
		return typeReligion;
	}
	
	
	public WebElement SelectDay(String Day)
	{
		return typeDay;
	}
	
	
	
	public WebElement SelectMonth(String Month)
	{
		return typeMonth;
	}
	
	
	
	public WebElement SelectYear(String Year)
	{
		return typeYear;
	}
	
	
	
	public WebElement SelectNationality(String Nationality)
	{
		return typeNationality;
	}
	
	
	
	
	public WebElement SelectMotherTongue(String MotherTongue)
	{
		return typeMothertongue;
	}
	
	
	
	
	public WebElement gettypeAadhar()
	{
		return typeAadhar;
	}
	
	
	
	public WebElement gettypeParentMobileNo()
	{
		return typeParentMobileNo;
	}

}
