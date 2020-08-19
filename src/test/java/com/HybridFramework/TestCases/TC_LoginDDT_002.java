package com.HybridFramework.TestCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.HybridFramework.PageObjects.LoginPage;
import com.HybridFramework.Utilities.XLUtils;

import junit.framework.Assert;

public class TC_LoginDDT_002 extends BaseClass
{
	// Actual Test Method
	@Test(dataProvider="LoginData")
	public void LoginDDT(String user, String pwd) throws InterruptedException, IOException
	{
		LoginPage lp = new LoginPage(driver);
		driver.manage().window().maximize();
		lp.setUserName(user);
		logger.info("UserName Provided");
		lp.setPassword(pwd);
		logger.info("Password Provided");
		lp.clickSubmit();
		Thread.sleep(3000);
		
		/*if (driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Login Test Passed.Application Title is Mached.");
		}
		else
		{
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("Login Test Failed. Application Title not Mached.");
		}*/
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept(); // Close the alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login Failed!!");
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("Login Successfully!");
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept(); // Close logout alert
			driver.switchTo().defaultContent();
		}
	}
	
	// User created method created to check alert is present or not
	public boolean isAlertPresent()
	{
		try
		{
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
	}
	
	//Data Provider Method
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException
	{
		String path = System.getProperty("user.dir")+ "/src/test/java/com/HybridFramework/TestData/LoginData.xlsx";
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colconut = XLUtils.getCellCount(path, "Sheet1", 1);
		
		String logindata[][] = new String[rownum][colconut];
		
		for(int i=1; i<=rownum; i++)
		{
			for(int j=0;j<colconut;j++)
			{
				logindata[i-1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return logindata;
	}
}
