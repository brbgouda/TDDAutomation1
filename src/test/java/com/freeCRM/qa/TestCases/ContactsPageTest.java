package com.freeCRM.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.freeCRM.qa.base.TestBase;
import com.freeCRM.qa.pages.ContactsPage;
import com.freeCRM.qa.pages.HomePage;
import com.freeCRM.qa.pages.LoginPage;
import com.freeCRM.qa.utilities.TestUtil;

public class ContactsPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	String sheetname = "contacts";
	
	public ContactsPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();
	}
	
	@Test(priority=1)
	public void contactsLabelTest(){
		boolean flag = contactsPage.verifyContactsLabel();
		Assert.assertTrue(flag);
	}
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data [][] = TestUtil.getTestData(sheetname);
		return data;
	}
	
	@Test(priority=2, dataProvider="getCRMTestData")
	public void createNewContactTest(String title, String firstname, String lastname, String position, String department){
		homePage.clickNewContactsLink();
		contactsPage.createNewContact(title, firstname, lastname, position, department);
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
