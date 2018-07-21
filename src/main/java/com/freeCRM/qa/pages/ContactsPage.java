package com.freeCRM.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.freeCRM.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	@FindBy(name="first_name")
	WebElement firstName;
	@FindBy(name="surname")
	WebElement lastName;
	@FindBy(id="company_position")
	WebElement position;
	@FindBy(id="department")
	WebElement department;
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement saveContactBtn;
	
	public ContactsPage(){
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsLabel(){
		return contactsLabel.isDisplayed();
	}
	public void createNewContact(String title, String fName, String lName, String pos, String dep){
		Select contactTitle = new Select(driver.findElement(By.name("title")));
		contactTitle.selectByVisibleText(title);
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		position.sendKeys(pos);
		department.sendKeys(dep);
		saveContactBtn.click();
	
	}
}
