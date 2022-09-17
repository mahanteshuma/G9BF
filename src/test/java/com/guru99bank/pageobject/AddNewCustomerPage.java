package com.guru99bank.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomerPage {
	WebDriver driver;
	public  AddNewCustomerPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//a[text()='New Customer']")
	WebElement lnkAddNewAccount;
	
	@FindBy(name="name")
	WebElement txtCustomername ;
	
	@FindBy(name="rad1")
	WebElement rdGender;
	
	@FindBy(name="dob")
	WebElement txtdob;
	
	@FindBy(name="addr")
	WebElement txtaddr;
	
	@FindBy(name="city")
	WebElement txtcity;
	
	@FindBy(name="state")
	WebElement txtstate;
	
	@FindBy(name="pinno")
	WebElement txtpinno;
	
	@FindBy(name="telephoneno")
	WebElement txttelephoneno;
	
	@FindBy(name="emailid")
	WebElement txtemailid;
	
	@FindBy(name="password")
	WebElement txtpassword;
	
	@FindBy(name="sub")
	WebElement Btnsubmit;
	
	public void clickAddNewCustomer() {
		lnkAddNewAccount.click();
	}
	
	public void custName(String cname) {
		txtCustomername.sendKeys(cname);
	}
	
	public void custgender(String cgender) {
		rdGender.click();
	}
	
	public void custdob(String mm,String dd,String yyyy) {
		txtdob.sendKeys(mm);
		txtdob.sendKeys(dd);
		txtdob.sendKeys(yyyy);
		
	}
	public void custadders(String caddr) {
		txtaddr.sendKeys(caddr);
	}
	
	public void custcity(String ccity) {
		txtcity.sendKeys(ccity);
	}
	
	public void custstate(String cstate) {
		txtstate.sendKeys(cstate);
	}
	
	public void custpinno(String cpinno) {
		txtpinno.sendKeys(String.valueOf(cpinno));
	}
	
	public void custtelephoneno(String ctelephoneno) {
		txttelephoneno.sendKeys(ctelephoneno);
	}
	
	public void custemailid(String cemailid) {
		txtemailid.sendKeys(cemailid);
	}
	
	public void custpassword(String cpassword) {
		txtpassword.sendKeys(cpassword);
	}
	
	public void custsubmit() {
		Btnsubmit.click();
	}
	
	

}
