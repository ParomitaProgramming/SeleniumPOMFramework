package com.qa.tests;

import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.page.LoginPage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import junit.framework.Assert;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class LoginTest extends TestBase {

	TestBase testBase;
	LoginPage loginPage;
	ExtentTest test;

	public LoginTest() {
		super();
	}

	@BeforeTest
	public void setup() {
		initialization();
		test = generateReport("D:\\SeleniumFramework\\SeleniumPOMFramework\\test-output\\Reports", "LoginTest");
		loginPage = new LoginPage();
	}

	@Test
	public void login() {
		try{
			loginPage.launchUrl("http://automationpractice.com/index.php?controller=authentication&back=my-account");
			test.log(LogStatus.PASS, "URL launch Successfully");
			Assert.assertEquals(loginPage.verifyTitle(), "Login - My Store");
			loginPage.enterCredentials("dasguptababi@gmail.com", "12345678");
			test.log(LogStatus.PASS, "Login Successfully");
		}
		catch(Throwable e)
		{
			test.log(LogStatus.FAIL, e.toString());
		}

	}
	
	@AfterTest
	public void tearDown(){
		loginPage.quitBrowser();
		closeReport();
	}


}
