package com.qa.tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.page.ContactUsPage;
import com.qa.page.LoginPage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ContactUsTest extends TestBase {

	ExtentTest test;
	ContactUsPage contactusPage;
	LoginPage loginPage;
	
	public ContactUsTest() {
		super();
	}
	
	@BeforeTest
	public void setup()
	{
		initialization();
		test = generateReport("D:\\SeleniumFramework\\SeleniumPOMFramework\\test-output\\Reports", "ContactUsTest");
		contactusPage = new ContactUsPage();
		loginPage = new LoginPage();
	}
	
	@Test
	public void contactUs() {
		try
		{
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			loginPage.launchUrl("http://automationpractice.com/index.php?controller=authentication&back=my-account");
			test.log(LogStatus.PASS, "URL launch Successfully");
			Assert.assertEquals(loginPage.verifyTitle(), "Login - My Store");
			loginPage.enterCredentials("dasguptababi@gmail.com", "12345678");
			test.log(LogStatus.PASS, "Login Successfully");
			contactusPage.clickContactButton();
			Assert.assertEquals(contactusPage.verifyTitle(), "Contact us - My Store");
			test.log(LogStatus.PASS, "Title Verified Successfully");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, e.toString());
		}
		
	}
	
	@AfterTest
	public void tearDown()
	{
		loginPage.quitBrowser();
		closeReport();
	}
}
