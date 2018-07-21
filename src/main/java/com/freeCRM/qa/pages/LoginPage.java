package com.freeCRM.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freeCRM.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//Page Factory
	@FindBy(name="username")
	WebElement username;
	@FindBy(name="password")
	WebElement password;
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	WebElement signUpBtn;
	@FindBy(xpath="//img[contains(@class, 'img-responsive')]")
	WebElement freeCRM_Image;
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String loginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean loginPageImage(){
		return freeCRM_Image.isDisplayed();
	}
	
	public HomePage login(String un, String pwd){
		try {
			Thread.sleep(3000);
			username.sendKeys(un);
			password.sendKeys(pwd);
			loginBtn.click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new HomePage();
	}

}
