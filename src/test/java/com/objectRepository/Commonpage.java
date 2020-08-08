package com.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Commonpage {
	
	@FindBy(linkText="Junior Application")
	
	//@FindBy(css="div.container:nth-child(3) div.iticontainer div.row:nth-child(2) div.col-md-3.col-sm-5.bg-gray:nth-child(1) div.portlet > a.btn.more-btn.btn-block")
	private WebElement typejuniorlink;
	
	
	@FindBy(css="#leftmenu_divDiploma > ul > li.FormApply > a")
	private WebElement FormApply;
	
	
	
	@FindBy(css="#leftmenu_divDiploma > ul > li.FormApply.open > ul > li:nth-child(1) > a")
	private WebElement ApplyOnline;

	
	@FindBy(id="A1")
	private WebElement getsignup;
	
	
	
	
	@FindBy(id="txtName")
	private WebElement getname;
	
	
	@FindBy(id="txtSMobileNo")
	private WebElement getmobileno;
	

	
	@FindBy(id="txtmail")
	private WebElement getmail;
	
	
	@FindBy(id="btnOTP")
	private WebElement getotp;
	
	
	
	@FindBy(id="txtOTPVerify")
	private WebElement getotpverify;
	
	
	
	@FindBy(id="txtPwd")
	private WebElement getpassword;
	
	
	@FindBy(id="txtConfirmPwd")
	private WebElement getconfirmpassword;
	
	
	
	@FindBy(id="btnSubmit")
	private WebElement getfinalsubmit;
	
	
	
	
	@FindBy(id="txtSPwd")
	private WebElement getloginpassword;
	
	
	
	
	@FindBy(id="btnSIGNIN")
	private WebElement getsignin;
	
	
	
	
	
	
	
	public WebElement SelectLink()
	{
		 return typejuniorlink;
	}
	
	
	
	public WebElement ClickFormApply()
	{
		 return FormApply;
	}
	
	public WebElement ClickApplyOnline()
	{
		 return ApplyOnline;
	}
	
	
	
	
	
	
	
	
	public WebElement Clicknewuser()
	{
		return getsignup;
	}
	
	
	public WebElement gettypename()
	{
		return getname;
	}
	
	public WebElement gettypemobileno()
	{
		return getmobileno;
	}
	
	
	public WebElement gettypeemail()
	{
		return getmail;
	}
	
	
	public WebElement clickgetotp()
	{
		return getotp;
	}
	
	
	public WebElement gettypeotpverify()
	{
		return getotpverify;
	}
	
	
	
	public WebElement gettypepassword()
	{
		return getpassword;
	}
	
	
	
	public WebElement gettypeconfirmpassword()
	{
		return getconfirmpassword;
	}
	
	
	
	public WebElement clickfinalsubmit()
	{
		return getfinalsubmit;
	}
	
	
	public WebElement gettypeloginpassword()
	{
		return getloginpassword;
	}
	
	public WebElement getfinallogin()
	{
		return getsignin;
	}
	

}
