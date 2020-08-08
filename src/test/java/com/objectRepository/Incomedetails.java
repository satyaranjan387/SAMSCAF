package com.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Incomedetails {
	
	
	@FindBy(id="ddlFOcu")
	private WebElement TypeFatherOccupation;
	
	
	@FindBy(id="ddlMOcu")
	private WebElement TypeMotherrOccupation;
	
	
	@FindBy(id="ddlAIncome")
	private WebElement TypeAnnualIncome;
	
	@FindBy(id="txtacno")
	private WebElement TypeAccountNo;
	
	
	
	@FindBy(id="txtifsc")
	private WebElement TypeIFSC;
	
	
	@FindBy(id="txtmicr")
	private WebElement TypeMICRCode;
	
	
	
	@FindBy(id="txtBankname")
	private WebElement TypeBankName;
	
	
	
	
	@FindBy(id="txtBrname")
	private WebElement TypeBranchName;

	
	
	
	public WebElement SelectTypeFatherOccupation(String FatherOccupation)
	{
		return TypeFatherOccupation;
	}
	
	
	public WebElement SelectTypeMotherrOccupation(String MotherOccupation)
	{
		return TypeMotherrOccupation;
	}
	
	
	public WebElement SelectTypeAnnualIncome(String AnnualIncome)
	{
		return TypeAnnualIncome;
	}
	
	public WebElement getTypeAccountNo()
	{
		return TypeAccountNo;
	}
	
	
	public WebElement getTypeIFSC()
	{
		return TypeIFSC;
	}
	
	
	public WebElement getTypeMICRCode()
	{
		return TypeMICRCode;
	}
	
	public WebElement getTypeBankName()
	{
		return TypeBankName;
	}
	
	
	public WebElement getTypeBranchName()
	{
		return TypeBranchName;
	}
	
}
