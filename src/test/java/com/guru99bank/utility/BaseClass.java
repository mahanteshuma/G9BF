package com.guru99bank.utility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	ReadConfig readconfig = new ReadConfig();
	public String baseURL = readconfig.getApplicationURL();
	public String username = readconfig.getUsername();
	public String password = readconfig.getPassword();
	public static WebDriver driver;
	// public ExcelDataProvider excel;
	public ExtentReports report;
	public ExtentTest logger;

	@BeforeSuite
	public void setUpSuite() {
		
		Reporter.log("Setting Up Started and test is getting ready", true);
		ExtentHtmlReporter extent = new ExtentHtmlReporter(
				new File("./Report/Gur99Bnak" + Helper.getCurrentDateTime() + ".html"));
		report = new ExtentReports();
		report.attachReporter(extent);
		
		Reporter.log("Setting done Test Started", true);
	}

	@BeforeClass
	public void setup() {
		
		Reporter.log("Browser setting started", true);
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Reporter.log("Browser setting Completed", true);
	}

	@AfterClass
	public void tearDown() {
		
		driver.quit();
	}

	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			// Helper.captureScreenshot(driver);
			logger.fail("TestCase Failed",
					MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.pass("TestCase Passed",
					MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.pass("TestCase Skipped",
					MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		report.flush();
	}
}
