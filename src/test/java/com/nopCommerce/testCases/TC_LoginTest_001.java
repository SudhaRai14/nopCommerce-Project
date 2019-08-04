package com.nopCommerce.testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.nopCommerce.pageObjects.LoginPage;

import junit.framework.Assert;

public class TC_LoginTest_001 extends BaseClass
{
	@Test
	public void loginTest() throws IOException
	{
		driver.get(baseURL);
		logger.info("URL opened");
		
		LoginPage lp=new LoginPage(driver);
		
		lp.setUsername(username);
		logger.info("Username Entered");
		
		lp.setPassword(password);
		logger.info("Password Entered");
		
		lp.clickLogin();
		logger.info("Clicked on Login");
		
		if(driver.getTitle().equals("Dashboard / nopCommerce administration"))
		{
			Assert.assertTrue(true);
			lp.clickLogout();
			logger.info("Clicked on logout");
			logger.info("Test passed");

		}
		else
		{
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			lp.clickLogout();
			logger.info("Clicked on logout");
			logger.info("Test Failed");
		}
		
	}
	
	
}
