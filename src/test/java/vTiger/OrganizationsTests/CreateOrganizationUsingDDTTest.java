package vTiger.OrganizationsTests;



import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericUtilities.ExcelFileUtility;
import vTiger.GenericUtilities.JavaUtility;
import vTiger.GenericUtilities.PropertyFileUtility;
import vTiger.GenericUtilities.WebDriverUtility;

public class CreateOrganizationUsingDDTTest {
	
	@Test
	public void createOrganizationTest() throws IOException
	{
		
		//Step 1: Create all the object necessary for the utilities
		PropertyFileUtility pUtil = new PropertyFileUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		ExcelFileUtility eUtil = new ExcelFileUtility();
		JavaUtility jUtil = new JavaUtility();
		
		//property file : common data
		String BROWSER=pUtil.readDataFromPropertyFile("browser");
		String URL=pUtil.readDataFromPropertyFile("url");
		String USERNAME=pUtil.readDataFromPropertyFile("username");
		String PASSWORD=pUtil.readDataFromPropertyFile("password");
		
		//excel file : test data
		String ORGNAME=eUtil.readDataFromExcel("Organizations", 1, 2)+jUtil.getRandomNumber();
		
		WebDriver driver=null;
		
		//Step 2:lunch browser : run time polymorphism -driver
		if(BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
		    driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else{
			System.out.println("invalid broswer name");
		}
		
		wUtil.maximiseWindow(driver);
		wUtil.waitForPageLoad(driver);
		driver.get(URL);
		
		//Step 3: Login To Application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//Step 4: Click on Organizations Link
		driver.findElement(By.linkText("Organizations")).click();
		
		//Step 5: click on create organization lookup image
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		//Step 6: Create new organization with mandatory information and save
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Step 7: logout
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wUtil.mouseHoverAction(driver, ele);
		driver.findElement(By.linkText("Sign Out")).click();
	}

}
