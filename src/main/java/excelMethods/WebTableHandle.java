package excelMethods;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.freeCRM.qa.utilities.Xls_Reader;

public class WebTableHandle {
	
	public static String TESTDATA_SHEET_PATH = "C://Users//Basavanagouda BR//workspace//FreeCRMTest//src//main//java"
			+ "//com//freeCRM//qa//testData//freeCrmTestData.xlsx";
	static String sheetName = "WebTableData";
	public static void main(String[] args) {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C://HomeProjects//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		//table[@id='customers']/tbody/tr[2]/td[1]
		//table[@id='customers']/tbody/tr[3]/td[1]
		//table[@id='customers']/tbody/tr[4]/td[1]
		 
		String beforeXPath_company = "//table[@id='customers']/tbody/tr[";
		String afterXPath_company = "]/td[1]";
		String beforeXPath_contact = "//table[@id='customers']/tbody/tr[";
		String afterXPath_contact = "]/td[2]";
		String beforeXPath_country = "//table[@id='customers']/tbody/tr[";
		String afterXPath_country = "]/td[3]";
		
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='customers']//tr"));
		
		System.out.println("Row count is: "+(rows.size()-1));
		int rowCount = rows.size();
		
		Xls_Reader reader = new Xls_Reader(TESTDATA_SHEET_PATH);
		
		if(!reader.isSheetExist(sheetName)){
				reader.addSheet("WebTableData");
		reader.addColumn(sheetName, "CompanyName");
		reader.addColumn(sheetName, "ContactName");
		reader.addColumn(sheetName, "CountryName");
		}
		
		for(int i=2;i<=rowCount;i++){
		String actualXPath_company = beforeXPath_company+i+afterXPath_company;
		String companyName = driver.findElement(By.xpath(actualXPath_company)).getText();
		System.out.println(companyName);
		reader.setCellData(sheetName, "CompanyName", i, companyName);
		
		String actualXPath_contact = beforeXPath_contact+i+afterXPath_contact;
		String contactName = driver.findElement(By.xpath(actualXPath_contact)).getText();
		System.out.println(contactName);
		reader.setCellData(sheetName, "ContactName", i, contactName);
		
		String actualXPath_country = beforeXPath_country+i+afterXPath_country;
		String countryName = driver.findElement(By.xpath(actualXPath_country)).getText();
		System.out.println(countryName);
		reader.setCellData(sheetName, "CountryName", i, countryName);
		}
		driver.close();
		
		
		

	}

}
