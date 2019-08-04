package com.nopCommerce.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerRolePage 
{
	public WebDriver ldriver;
	
	public AddCustomerRolePage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	//By lnkCustomer_menu=By.xpath("//a[@href='#']//span[contains(text(),'Customers')]");
	//By lnkCustomerRole=By.xpath("//span[contains(text(),'Customer roles')]");
	//By btnAddnew=By.xpath("//a[@class='btn bg-blue']");
	
	
	public void clickOnCustomerMenu()
	{
		ldriver.findElement(By.xpath("//a[@href='#']//span[contains(text(),'Customers')]")).click();
	}
	
	public void clickOnCustomerRole()
	{
		ldriver.findElement(By.xpath("//span[contains(text(),'Customer roles')]")).click();
	}
	
	public void clickOnAddNew()
	{
		ldriver.findElement(By.xpath("//a[@class='btn bg-blue']")).click();
	}
	
	public void setName(String crname)
	{
		ldriver.findElement(By.xpath("//input[@id='Name']")).sendKeys(crname);
	}
	
	public void setSystemName(String sname)
	{
		ldriver.findElement(By.xpath("//input[@id='SystemName']")).sendKeys(sname);
	}
	
	public void ChkFreeShipping()
	{
		ldriver.findElement(By.xpath("//input[@id='FreeShipping']")).click();
	}
	
	public void ChkTaxExempt()
	{
		ldriver.findElement(By.xpath("//input[@id='TaxExempt']")).click();
	}
	
	public void ChkDefaultTaxDisType()
	{
		ldriver.findElement(By.xpath("//input[@id='OverrideTaxDisplayType']")).click();
	}
	
	public void ChkEnablePassLife()
	{
		ldriver.findElement(By.xpath("//input[@id='EnablePasswordLifetime']")).click();
	}
	
	public void ChkActive()
	{
		ldriver.findElement(By.xpath("//input[@id='Active']")).click();
	}
	
	public void ClickOnSave()
	{
		ldriver.findElement(By.xpath("//button[@name='save']")).click();
	}
	
	
	
	
	
	
	
}
