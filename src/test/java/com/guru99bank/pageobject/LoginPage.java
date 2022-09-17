package com.guru99bank.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//td//input[@name='uid']")
	WebElement txtUserId;
	
	@FindBy(name="password")
	WebElement txtPassword;
	
	@FindBy(name="btnLogin")
	WebElement LoginButton;
	
	@FindBy(xpath = "//a[text()='Log out']")
	WebElement LoginOut;
	
	public void setUsername(String uname) {
		txtUserId.sendKeys(uname);
	}
	
	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	
	public void ClickSubmit() {
		LoginButton.click();
	}

	public void ClickLogout() {
		LoginOut.click();
	}
	

}
