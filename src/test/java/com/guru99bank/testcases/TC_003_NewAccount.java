package com.guru99bank.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.guru99bank.pageobject.AddNewAccountPage;
import com.guru99bank.pageobject.LoginPage;
import com.guru99bank.utility.BaseClass;
import com.guru99bank.utility.Helper;

public class TC_003_NewAccount extends BaseClass{
	@Test
	public void AddNewAccount() {
	
	logger=report.createTest("Login To Guru99Bnak");
	
	driver.get(baseURL);
	logger.info("Browser Opening");
	
	LoginPage lp=new LoginPage(driver);
	logger.info("Login Page Opend");
	lp.setUsername(username);
	logger.info("Username Sent");
	lp.setPassword(password);
	logger.info("Password sent");
	lp.ClickSubmit();
	logger.info("Clicked Login Button");
	
	AddNewAccountPage anp=new AddNewAccountPage(driver);
	logger.info("New Account Page");
	anp.ClickNewAccount();
	logger.info("Click New Account");
	anp.CustID();
	logger.info("Cust ID");
	anp.AccountType();
	logger.info("Account Type");
	anp.Initialdeposit();
	logger.info("Initialdeposit");
	anp.SubmitButton();
	logger.info("SubmitButton");
	
	if(driver.getTitle().equals("Gtpl Bank Customer Registration Page")) {
		
		Assert.assertTrue(true);
		logger.pass("Login done");
	}else 
	{
		Assert.assertTrue(false);
		Helper.captureScreenshot(driver);
		logger.fail("Login failed");
	}
	
}
}
