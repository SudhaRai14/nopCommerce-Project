package com.nopCommerce.testCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nopCommerce.pageObjects.LoginPage;
import com.nopCommerce.utilities.XLUtils;

import junit.framework.Assert;

public class TC_LoginDDT_002 extends BaseClass
{
	@Test(dataProvider="LoginData")
	public void loginTest(String usr, String pwd) throws InterruptedException, IOException
	{
		driver.get(baseURL);
		driver.manage().window().maximize();
		
		LoginPage lp=new LoginPage(driver);
		
		lp.setUsername(usr);
		logger.info("Username entered");
		
		lp.setPassword(pwd);
		logger.info("Password entered");
		
		lp.clickLogin();
		logger.info("Clicked on login");
		
		
		Thread.sleep(2000);
		
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
		
		@DataProvider(name="LoginData")
		public String [][] getData() throws IOException
		{
			String path=System.getProperty("user.dir")+"/src/test/java/com/nopCommerce/testData/LoginData.xlsx";
			
			int rownum=XLUtils.getRowCount(path,"Sheet1");
			int colnum=XLUtils.getCellCount(path,"Sheet1",1);
			
			System.out.print(rownum);
			
			String logindata[][]=new String[rownum][colnum];
			
			for(int i=1; i<=rownum; i++)
			{
				for(int j=0; j<colnum; j++)
				{
					logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1",i,j);
				}
			}
			
			return logindata;
		}
		
		
	
}
