package com.nopCommerce.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.nopCommerce.pageObjects.AddCustomerRolePage;
import com.nopCommerce.pageObjects.LoginPage;

import junit.framework.Assert;

public class TC_AddCustomerRoleTest_004 extends BaseClass 
{
	@Test
	public void addNewCustomerRole() throws IOException
	{
		driver.get(baseURL);
		
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(username);
		logger.info("User name is provided");
		
		lp.setPassword(password);
		logger.info("password is provided");
		
		lp.clickLogin();
		
		logger.info("providing customer role details....");
		
		AddCustomerRolePage addcustrole=new AddCustomerRolePage(driver);
		
		addcustrole.clickOnCustomerMenu();
		addcustrole.clickOnCustomerRole();
		
		addcustrole.clickOnAddNew();
		
		addcustrole.setName("Guest 2");
		addcustrole.setSystemName("Guest 2");
		
		addcustrole.ChkFreeShipping();
		addcustrole.ChkTaxExempt();
		
		addcustrole.ClickOnSave();
		
		logger.info("Validation Started");
		
		String msg=driver.findElement(By.tagName("body")).getText();
		
		if(msg.contains("The new customer role has been added successfully."))
		{
				Assert.assertTrue(true);
				logger.info("test case passed");
		}
		else
		{
			captureScreen(driver,"addCustomerRole");
			Assert.assertTrue(false);
		}
	}
	
	
}
