package com.HybridFramework.TestCases;

import java.io.IOException;

//import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.HybridFramework.PageObjects.AddCustomerPage;
import com.HybridFramework.PageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass
{
	@Test
	public void AddNewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		driver.manage().window().maximize();
		lp.setUserName(username);
		logger.info("UserName Provided");
		lp.setPassword(password);
		logger.info("Passsword Provided");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		AddCustomerPage addcust=new AddCustomerPage(driver);
		
		addcust.clickAddNewCustomer();
		
		logger.info("Providing Customer Details....");
		
		
		addcust.custName("Rahul Mittal");
		addcust.custgender("Male");
		addcust.custdob("01","18","1987");
		Thread.sleep(5000);
		addcust.custaddress("India");
		addcust.custcity("Lucknow");
		addcust.custstate("Uttar Pradesh");
		addcust.custpinno("411055");
		addcust.custtelephoneno("9876543210");
		
		String email = randomestring()+"@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("Test@123");
		addcust.custsubmit();
		
		Thread.sleep(3000);
		
		logger.info("validation started....");
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("Add New Customer Test Case Passed Successfully!!");
			
		}
		else
		{
			logger.info("Add New Customer Test Cas	e Failed!!");
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
	}
			
}
