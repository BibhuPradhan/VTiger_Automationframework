package vTiger.OrganizationsTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericUtilities.ExcelFileUtility;
import vTiger.GenericUtilities.JavaUtility;
import vTiger.GenericUtilities.PropertyFileUtility;
import vTiger.GenericUtilities.WebDriverUtility;
import vTiger.ObjectRepository.CreateNewOrganizationPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;
import vTiger.ObjectRepository.OrganizationInfoPage;
import vTiger.ObjectRepository.OrganizationsPage;

public class CreateMultipleOrganizatuion {

	ExcelFileUtility eUtil= new ExcelFileUtility();
	 //Step 1: Create all the object necessary for the utilities
	PropertyFileUtility pUtil = new PropertyFileUtility();
	WebDriverUtility wUtil = new WebDriverUtility();
	JavaUtility jUtil = new JavaUtility();
	
	@Test(dataProvider="Orgdata")
	public void createMultipleOrg(String ORG, String INDUSTRY) throws IOException {
		
		
		//property file : common data
		String BROWSER=pUtil.readDataFromPropertyFile("browser");
		String URL=pUtil.readDataFromPropertyFile("url");
		String USERNAME=pUtil.readDataFromPropertyFile("username");
		String PASSWORD=pUtil.readDataFromPropertyFile("password");
		
		String ORGNAME=ORG+jUtil.getRandomNumber();
		
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
		
		//Step 3: login to application
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		//click on organizations link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationLink();
		
	    //click on create organizations look up image
		OrganizationsPage op= new OrganizationsPage(driver);
		op.clickOnCreateOrgLookUpImg();
		
		//create new organization with mandatory fields and save
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createNewOrganization(ORGNAME, INDUSTRY);
		
		//validate
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String OrgHeader = oip.getOrganizationHeaderText();
		if (OrgHeader.contains(ORGNAME))
		{
			System.out.println(OrgHeader);
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
		//logout
		hp.logOutOfApp(driver);
		
	}
	
	@DataProvider(name="OrgData")
	public Object[][] getData() throws EncryptedDocumentException, IOException{
		return eUtil.readMultipleDataIntoDataProvider("MultipleOrganization");
	}
	
}
