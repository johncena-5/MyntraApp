package genricLibraries;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pompages.BlogPage;
import pompages.CartPage;
import pompages.HomePage;
import pompages.TshirtPage;

public class BaseClass {
	
	protected PropertiesFileUtility property;
	protected ExcelUtility excel;
	protected WebDriverUtility web;
	protected Long time;
	protected WebDriver driver;
	protected HomePage home;
	protected TshirtPage tshirt;
	protected CartPage cart;
	protected BlogPage blog;
//	@BeforeSuite
//	@BeforeTest
	@BeforeClass
	public void classConfiguration()
	{
	   property = new PropertiesFileUtility();
	   excel = new ExcelUtility();
	   web = new WebDriverUtility();
	   
	   property.propertyFileUtilization(IConstantPath.PROPERTIES_FILE_PATH);
	   excel.excelInitialization(IConstantPath.EXCEL_FILE_PATH);
	}
	@BeforeMethod
	public void methodConfiguration()
	{
		time = Long.parseLong(property.fetchProperty("timeouts"));
		driver = web.openApplication(property.fetchProperty("browser"), property.fetchProperty("url"), time);
		
		home = new HomePage(driver);
		tshirt = new TshirtPage(driver);
		cart = new CartPage(driver);
		blog = new BlogPage(driver);
	}
	@AfterMethod
	public void methodTearDown()
	{
		web.quitBrowser();
	}
	@AfterClass
	public void classTearDown()
	{
	   excel.closeExcel();
	}
//	@AfterTest
//	@AfterSuite
	

}
