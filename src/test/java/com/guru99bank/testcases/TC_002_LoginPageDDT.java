package com.guru99bank.testcases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.guru99bank.pageobject.LoginPage;
import com.guru99bank.utility.BaseClass;
import com.guru99bank.utility.XLUtils;

public class TC_002_LoginPageDDT extends BaseClass  {
	@Test(dataProvider = "Logindata")
	public void LoginDDT(String usrename,String password) {
		
		logger=report.createTest("Login To Guru99Bnak");
		driver.get(baseURL);
		logger.info("Browser Opening");
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(username);
		logger.info("username provided");
		lp.setPassword(password);
		logger.info("password provided");
		lp.ClickSubmit();
		logger.info("clicked login button");
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();//close alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warning("Login failed");
		}
		else 
		{
			Assert.assertTrue(true);
			logger.info("Login Passed");
			driver.switchTo().alert().accept();//close logout alert
			driver.switchTo().defaultContent();
		}
	}
	
	public boolean isAlertPresent() 
	{
		try 
		{
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) 
		{
			return false;
		}
	}
	
	
	@DataProvider(name = "Logindata")
	String[][] getDtaa() throws IOException {
		String path=("./TestData/Data.xlsx");
				//System.getProperty("user.dir")+"src/test/java/com/guru99bank/testData/Data.xlsx";
		int rownum = XLUtils.getRowCount(path, "LoginData");
		int colcount = XLUtils.getCellCount(path, "LoginData", 1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++) {
			for(int j=0;j<colcount;j++) {
				logindata[i-1][j]=XLUtils.getCellData(path, "LoginData", i, j);//1,0
			}
		}
		return logindata;
		
	}
	

}
