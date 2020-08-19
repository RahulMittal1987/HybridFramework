package com.HybridFramework.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.HybridFramework.PageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass
{
	@Test
	public void loginTest() throws IOException
	{
		logger.info("URL Opened");
		
		driver.manage().window().maximize();
		logger.info("Browser Window Maximized");
		
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserName(username);
		logger.info("Entered UserName");
		
		lp.setPassword(password);
		logger.info("Entered Password");
		
		lp.clickSubmit();
		
		if (driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Login Test Passed");
		}
		else
		{
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("Login Test Failed");
		}
	}
}
