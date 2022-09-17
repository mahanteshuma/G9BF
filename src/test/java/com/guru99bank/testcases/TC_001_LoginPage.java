package com.guru99bank.testcases;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.guru99bank.pageobject.LoginPage;
import com.guru99bank.utility.BaseClass;

public class TC_001_LoginPage extends BaseClass {
	
	
	//ExcelDataProvider edp=new ExcelDataProvider();
	@Parameters("browser")
	@Test
	public void LoginTest() {
		
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
		
		if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {

			Assert.assertTrue(true);
			logger.pass("Login done");
		} else 
		{
			Assert.assertTrue(false);
			logger.fail("Login failed");
		}
		
	}
	

}
