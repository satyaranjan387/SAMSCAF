package com.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddressDetails {
	
	@FindBy(id="ddlCState")
	private WebElement TypeState;
	
	
	@FindBy(id="ddlCDist")
	private WebElement TypeDistrict;
	
	
	
	@FindBy(id="ddlCBlock")
	private WebElement TypeBlock;
	
	
	
	@FindBy(id="txtCPS")
	private WebElement typeHouseNo;
	
	
	
	@FindBy(id="txtCPC")
	private WebElement typepincode;
	
	
	
	@FindBy(id="txtCTCode")
	private WebElement typeAreaCode;
	
	
	
	@FindBy(id="txtCTeleNo")
	private WebElement typeTelephoneNo;
	
	
	
	
	@FindBy(id="txtCEmail")
	private WebElement typeEmail;
	
	
	
	public WebElement SelectState(String State)
	{
		return TypeState;
	}
	
	
	public WebElement SelectDistrict(String District)
	{
		return TypeDistrict;
	}
	
	
	public WebElement SelectBlock(String Block)
	{
		return TypeBlock;
	}
	
	
	public WebElement gettypehouseno()
	{
		return typeHouseNo;
	}
	
	
	
	public WebElement gettypepincode()
	{
		return typepincode;
	}
	
	
	public WebElement gettypeAreaCode()
	{
		return typeAreaCode;
	}
	
	public WebElement gettypeTelephoneNo()
	{
		return typeTelephoneNo;
	}
	
	
	
	public WebElement gettypeEmail()
	{
		return typeEmail;
	}
	

}
