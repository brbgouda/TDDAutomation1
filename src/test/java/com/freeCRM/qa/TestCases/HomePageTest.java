package com.freeCRM.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.freeCRM.qa.base.TestBase;
import com.freeCRM.qa.pages.HomePage;
import com.freeCRM.qa.pages.LoginPage;
import com.freeCRM.qa.utilities.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	
	public HomePageTest(){
		super();
		
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void homePageTitleTest(){
		String title = homePage.verifyHomePageTitle();
		Assert.assertEquals(title, "CRMPRO");
	}
	
	@Test(priority=2)
	public void homePageUserLabelTest(){
		testUtil.switchToFrame();
		boolean flag = homePage.homePageUserLabel();
		Assert.assertTrue(flag);
	}
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
}
