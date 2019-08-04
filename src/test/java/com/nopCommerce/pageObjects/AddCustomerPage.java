package com.nopCommerce.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage 
{
	public WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	By lnkCustomer_menu=By.xpath("//a[@href='#']//span[contains(text(),'Customers')]");
	By lnkCustomer_menuitem=By.xpath("//span[@class='menu-item-title'][contains(text(),'Customers')]");
	By btnAddnew=By.xpath("//a[@class='btn bg-blue']");
	
	By txtEmail=By.xpath("//input[@name='Email']");
	By txtPassword=By.xpath("//input[@id='Password']");
	
	By txtCustomerRole=By.xpath("//div[@class='k-multiselect-wrap k-floatwrap']");
	
	By lstitemAdministrator=By.xpath("//li[contains(text(),'Administrators')]");
	By lstitemForumModerators=By.xpath("//li[contains(text(),'Forum Moderators')]");
	By lstitemGuests=By.xpath("//li[contains(text(),'Guests')]");
	By lstitemRegistered=By.xpath("//li[contains(text(),'Registered')]");
	By lstitemVendors=By.xpath("//li[contains(text(),'Vendors')]");
	
	By drpmgrOfVendor=By.xpath("//*[@name='VendorId']");
	
	By rdMaleGender=By.id("Gender_Male");
	By rdFemaleGender=By.id("Gender_Female");
	
	By txtFirstName=By.xpath("//input[@id='FirstName']");
	By txtLastName=By.xpath("//input[@id='LastName']");
	By txtDOB=By.xpath("//input[@id='DateOfBirth']");
	
	By txtCompanyName=By.xpath("//input[@name='Company']");
	By txtAdminComment=By.xpath("//textarea[@id='AdminComment']");
	
	By btnSave=By.xpath("//button[@name='save']");
	

	public void clickOnCustomerMenu()
	{
		ldriver.findElement(lnkCustomer_menu).click();
	}
	
	public void clickOnCustomersMenuItem() 
	{
		ldriver.findElement(lnkCustomer_menuitem).click();
	}
	
	public void clickOnAddnew() 
	{
		ldriver.findElement(btnAddnew).click();
	}

	public void setEmail(String email)
	{
		ldriver.findElement(txtEmail).sendKeys(email);
	}
	
	public void setPassword(String password)
	{
		ldriver.findElement(txtPassword).sendKeys(password);
	}

	public void setCustomerRoles(String role) throws InterruptedException
	{
		ldriver.findElement(By.xpath("//*[@id=\"SelectedCustomerRoleIds_taglist\"]/li/span[2]")).click();
		
		ldriver.findElement(txtCustomerRole).click();
		
		WebElement listitem;
		
		Thread.sleep(3000);
		if(role.equals("Administrators"))
		{
			listitem=ldriver.findElement(lstitemAdministrator); 
		}
		else if(role.equals("Guests"))
		{
			listitem=ldriver.findElement(lstitemGuests);
		}
		else if(role.equals("Registered"))
		{
			listitem=ldriver.findElement(lstitemRegistered);
		}
		else if(role.equals("Vendors"))
		{
			listitem=ldriver.findElement(lstitemVendors);
		}
		else
		{
			listitem=ldriver.findElement(lstitemGuests);
		}
		
		//listitem.click();
		Thread.sleep(3000);
		
		JavascriptExecutor js = (JavascriptExecutor)ldriver;
		js.executeScript("arguments[0].click();", listitem);

	}
	
	public void setManagerOfVendor(String value)
	{
		Select drp=new Select(ldriver.findElement(drpmgrOfVendor));
		drp.selectByVisibleText(value);
	}
	
	public void setGender(String gender)
	{
		if(gender.equals("Male"))
		{
			ldriver.findElement(rdMaleGender).click();
		}
		else if(gender.equals("Female"))
		{
			ldriver.findElement(rdFemaleGender).click();
		}
		else
		{
			ldriver.findElement(rdMaleGender).click();//Default
		}
		
	}
	
	public void setFirstName(String fname)
	{
		ldriver.findElement(txtFirstName).sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		ldriver.findElement(txtLastName).sendKeys(lname);
	}
	
	public void setDob(String dob) throws InterruptedException
	{
		ldriver.findElement(txtDOB).sendKeys(dob);
		Thread.sleep(1000);
	}
	
	public void setCompanyName(String comname) 
	{
		ldriver.findElement(txtCompanyName).sendKeys(comname);
	}
	
	public void setAdminContent(String content)
	{
		ldriver.findElement(txtAdminComment).sendKeys(content);
	}
	
	public void clickOnSave()
	{
		ldriver.findElement(btnSave).click();
	}
	
	

}