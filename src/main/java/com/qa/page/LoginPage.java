package com.qa.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class LoginPage extends TestBase {

	@FindBy(id = "email")
	WebElement UserName;
	
	@FindBy(id = "passwd")
	WebElement Password;
	
	@FindBy(id = "SubmitLogin")
	WebElement submitButton;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void launchUrl(String url)
	{
		driver.get(url);
	}
	
	public void enterCredentials(String username, String password)
	{
		UserName.sendKeys(username);
		Password.sendKeys(password);
		submitButton.click();
	}
	
	public String verifyTitle()
	{
		return driver.getTitle();
	}
	
	public void quitBrowser()
	{
		driver.quit();
	}
	
}
