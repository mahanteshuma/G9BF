package com.guru99bank.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {
	
	WebDriver driver;
	
	public static String captureScreenshot(WebDriver driver){
	  File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  
	  String screenshotpath=System.getProperty("user.dir")+"/Screenshot/Gur99Bnak"+getCurrentDateTime()+".png";
	  File dest=new File(screenshotpath);
	  try {
		FileHandler.copy(src, dest);
		System.out.println("Screenshot captured");
	} catch (IOException e) {
		
		System.out.println("Unble to Take Screenshot:"+e.getMessage());
	}
	  return screenshotpath;
}
	public static String getCurrentDateTime() {
		
		DateFormat customFornat=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate=new Date();
		return customFornat.format(currentDate);
		
		
	}
	
	
	

}
