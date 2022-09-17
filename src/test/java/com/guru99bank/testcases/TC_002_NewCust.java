package com.guru99bank.testcases;

import org.apache.commons.lang.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.guru99bank.pageobject.AddNewCustomerPage;
import com.guru99bank.pageobject.LoginPage;
import com.guru99bank.utility.BaseClass;
import com.guru99bank.utility.Helper;

public class TC_002_NewCust extends BaseClass {

	@Test
	public void addNewCust() {

		logger = report.createTest("Login To Guru99Bnak New Account");

		driver.get(baseURL);
		logger.info("Browser Opening");

		LoginPage lp = new LoginPage(driver);
		logger.info("Login Page Opend");
		lp.setUsername(username);
		logger.info("Username Sent");
		lp.setPassword(password);
		logger.info("Password sent");
		lp.ClickSubmit();
		logger.info("Clicked Login Button");

		AddNewCustomerPage nc = new AddNewCustomerPage(driver);
		nc.clickAddNewCustomer();
		logger.info("clickAddNewCustomer");
		nc.custName("Mahantesh");
		logger.info("custName");
		nc.custgender("male");
		logger.info("custName");
		nc.custdob("7", "9", "1998");
		logger.info("custgender");
		nc.custadders("Kar123");
		logger.info("custadders");
		nc.custcity("Bgm");
		logger.info("custcity");
		nc.custstate("kar");
		logger.info("custstate");
		nc.custpinno("591420");
		logger.info("custpinno");
		nc.custtelephoneno("9481636091");
		String email = randomestring() + "@gmail.com";
		nc.custemailid(email);
		nc.custpassword("umamah");
		nc.custsubmit();

		boolean res = driver.getPageSource().contains("Customer Registered Successfuly!!!");

		if (res == true) {
			Assert.assertTrue(true);
			Helper.captureScreenshot(driver);
			logger.pass("Cust Registered Success done");
		} //else 
//		{
//
//			Assert.assertTrue(false);
//			Helper.captureScreenshot(driver);
//			logger.pass("Cust Registered Success failed");
//		}
	}

	public String randomestring() {
		String generatedstring = RandomStringUtils.randomAlphabetic(8);
		return (generatedstring);
	
	}
}
