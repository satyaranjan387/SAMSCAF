package com.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EducationalRecord {
	
	@FindBy(id="txtschname")
	private WebElement TypeSchoolName;
	
	
	
	@FindBy(id="txtschloc")
	private WebElement TypeSchoolLocation;
	
	
	
	
	@FindBy(id="ddlinstDistrict")
	private WebElement TypeInstituteDistrict;
	
	
	@FindBy(id="ddlYOJ")
	private WebElement TypeYearOfJoining;
	
	
	
	
	@FindBy(id="ddlYOL")
	private WebElement TypeYearOfLeaving;
	
	
	
	public WebElement getTypeSchoolName()
	{
		return TypeSchoolName;
	}
	
	
	
	public WebElement getTypeSchoolLocation()
	{
		return TypeSchoolLocation;
	}
	
	
	public WebElement SelectTypeYearOfJoining(String YearOfJoining)
	{
		return TypeYearOfJoining;
	}
	
	
	public WebElement SelectTypeYearOfLeaving(String YearOfLeaving)
	{
		return TypeYearOfLeaving;
	}

}
