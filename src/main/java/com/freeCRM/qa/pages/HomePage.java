package com.freeCRM.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freeCRM.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//td[contains(text(),'Basavanagouda BR')]")
	WebElement userNameLabel;
	@FindBy(xpath="//a[text()='Contacts']")
	WebElement contactsLink;
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newContactsLink;
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	public ContactsPage clickOnContactsLink(){
		contactsLink.click();
		return new ContactsPage();
	}
	
	public boolean homePageUserLabel(){
		return userNameLabel.isDisplayed();
	}
	
	public void clickNewContactsLink(){
		Actions act = new Actions(driver);
		act.moveToElement(contactsLink).build().perform();
		newContactsLink.click();
	}
}
