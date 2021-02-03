package com.qa.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class ContactUsPage extends TestBase {

	@FindBy(xpath = "//*[@id='contact-link']/a")
	WebElement contactusButton;
	
	@FindBy(xpath = "//*[@id='id_contact']")
	WebElement subjectHeading;
	
	@FindBy(xpath = "//*[@id='message']")
	WebElement msgbox;
	
	@FindBy(xpath = "//*[@id='submitMessage']")
	WebElement sendButton;

	public ContactUsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickContactButton()
	{
		contactusButton.click();
	}
	
	public String verifyTitle()
	{
		return driver.getTitle();
	}
	
	
	
}
