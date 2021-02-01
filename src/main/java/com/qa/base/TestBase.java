package com.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;


public class TestBase {

	public static Properties configProp;
	public static WebDriver driver;
	public ExtentReports reports;
	public ExtentTest test;

	public TestBase()
	{
		try{
			configProp = new Properties();
			FileInputStream configip = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//com//qa//config//config.properties");
			configProp.load(configip);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void initialization()
	{
		String browserName = configProp.getProperty("url");
		String browserDriverPath = configProp.getProperty("driverPath");

		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", browserDriverPath);
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();
	}
	
	public ExtentTest generateReport(String reportPath, String reportName)
	{
		reports = new ExtentReports(reportPath+"//"+reportName+"_"+System.currentTimeMillis()+".html");
		test = reports.startTest(reportName);
		
		return test;
	}
	
	public void closeReport()
	{
		reports.endTest(test);
		reports.flush();
	}
}
