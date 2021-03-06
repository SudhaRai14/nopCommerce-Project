package com.nopCommerce.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
	}
	
	@FindBy(id="Email")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(id="Password")
	@CacheLookup
	WebElement txtPassword;
	

	@FindBy(xpath="//input[@value='Log in']")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(xpath="//a[contains(text(),'Logout')]")
	@CacheLookup
	WebElement lnkLogout;
		

	public void setUsername(String uname)
	{
		txtEmail.sendKeys(uname);
	}
	
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void clickLogin()
	{
		btnLogin.click();
	}
	
	public void clickLogout()
	{
		lnkLogout.click();
	}


}

