package com.guru99bank.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewAccountPage {
	WebDriver driver;
	
	public AddNewAccountPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[text()='New Account']")
	WebElement newAccountButtonElement;
	
	@FindBy(name="cusid")
	WebElement custId;
	
	@FindBy(xpath = "//select[@name='selaccount']//option[text()='Savings']")
	WebElement Accounttype;
	
	@FindBy(name="inideposit")
	WebElement Initialdeposit;
	
	@FindBy(name="button2")
	WebElement submitButton;
	
	
	public void ClickNewAccount() {
		newAccountButtonElement.click();
	}
	
	public void CustID() {
		custId.sendKeys("33243");
	}
	
	public void AccountType() {
		Accounttype.click();
	}
	
	public void Initialdeposit() {
		Initialdeposit.sendKeys("10000");
	}
	
	public void SubmitButton() {
		submitButton.click();
	}

}
