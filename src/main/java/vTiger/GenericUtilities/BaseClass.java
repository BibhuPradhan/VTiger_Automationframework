package vTiger.GenericUtilities;

/*
 * This class of basic configuration annotations
 */

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;

public class BaseClass {
	
	public JavaUtility jUtil = new JavaUtility();
	public ExcelFileUtility eUtil = new ExcelFileUtility();
	public PropertyFileUtility pUtil = new PropertyFileUtility();
	public WebDriverUtility wUtil = new WebDriverUtility();
	public WebDriver driver = null;
	
   
	@BeforeSuite(groups = {"RegressionSuite","SmokeSuite"})
	public void bsConfig() {
		System.out.println("=============Data base connection is successful===============");
	}
	
	// @Parameters("BROWSER")
	//@BeforeTest
	@BeforeClass(groups = {"RegressionSuite","SmokeSuite"})
	public void bcConfig(/*String BROWSER*/) throws IOException 
	{
	String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("========"+BROWSER+"==========Browser is launched=========");
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("========"+BROWSER+"==========Browser is launched=========");
		}
		else 
			System.out.println("============Invalid browser details=====================");
		
		wUtil.maximiseWindow(driver);
		wUtil.waitForPageLoad(driver);
		driver.get(URL);
	}
	
	@BeforeMethod(groups = {"RegressionSuite","SmokeSuite"})
	public void bmConfig() throws IOException
	{
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		System.out.println("===========login to app is successful===================");
	}
	
	@AfterMethod(groups = {"RegressionSuite","SmokeSuite"})
	public void amConfig()
	{
		HomePage hp = new HomePage(driver);
		hp.logOutOfApp(driver);
		System.out.println("===========logout of app is successful================");
	}
	
	@AfterTest
	//@AfterClass(groups = {"RegressionSuite","SmokeSuite"})
	public void acConfig()
	{
		driver.quit();
		System.out.println("============browser is closed===================");
	}
	
	@AfterSuite(groups = {"RegressionSuite","SmokeSuite"})
	public void asConfig()
	{
		System.out.println("=============Database is closed=================");
	}
}
