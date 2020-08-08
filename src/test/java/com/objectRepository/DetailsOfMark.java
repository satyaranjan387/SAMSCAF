package com.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;




public class DetailsOfMark {
	
	@FindBy(id="txtMaxMark")
	private WebElement TypeMaximumMark;
	
	
	@FindBy(id="txtTotMark")
	private WebElement TypeSecuredMark;
	
	
	
	
	@FindBy(id="txtEnglish")
	private WebElement TypeEnglish;
	
	
	@FindBy(id="txtMath")
	private WebElement TypeMath;
	
	
	
	@FindBy(id="txtScience")
	private WebElement TypeScience;
	
	
	
	@FindBy(id="txtSocSci")
	private WebElement TypeSocialScience;
	
	
	
	@FindBy(id="rbtCompartmentalY")
	private WebElement TypeCompartmental;
	
	
	
	@FindBy(id="ddlCompSubject1")
	private WebElement TypeSubject;
	
	
	@FindBy(id="txtCompFMark1")
	private WebElement TypeFailMarkCompartmental;
	
	
	
	@FindBy(id="txtCompPMark1")
	private WebElement TypePassMarkCompartmental;
	
	
	
	
	public WebElement getTypeMaximumMark()
	{
		return TypeMaximumMark;
	}
	
	
	
	
	public WebElement getTypeSecuredMark()
	{
		return TypeSecuredMark;
	}
	
	
	public WebElement getTypeEnglish()
	{
		return TypeEnglish;
	}
	
	public WebElement getTypeMath()
	{
		return TypeMath;
	}
	
	
	public WebElement getTypeScience()
	{
		return TypeScience;
	}
	
	public WebElement getTypeSocialScience()
	{
		return TypeSocialScience;
	}
	
	
	
	
	
	public WebElement SelectSubject()
	{
		return TypeSubject;
	}
	
	public WebElement getFailMarkCompartmental()
	{
		return TypeFailMarkCompartmental;
	}
	
	
	public WebElement getTypePassMarkCompartmental()
	{
		return TypePassMarkCompartmental;
	}
	
	
	
	
	
}
