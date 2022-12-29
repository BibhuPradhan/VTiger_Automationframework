package vTiger.OrganizationsTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericUtilities.BaseClass;
import vTiger.GenericUtilities.ExcelFileUtility;
import vTiger.GenericUtilities.JavaUtility;
import vTiger.GenericUtilities.PropertyFileUtility;
import vTiger.GenericUtilities.WebDriverUtility;
import vTiger.ObjectRepository.CreateNewOrganizationPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;
import vTiger.ObjectRepository.OrganizationInfoPage;
import vTiger.ObjectRepository.OrganizationsPage;

public class CreateOrganization extends BaseClass {
	
	       @Test
	       public void createOrgTest() throws EncryptedDocumentException, IOException
	       {

	        
			//excel file : test data
			String ORGNAME=eUtil.readDataFromExcel("Organizations", 1, 2)+jUtil.getRandomNumber();
			
		    //click on organizations link
			HomePage hp = new HomePage(driver);
			hp.clickOnOrganizationLink();
			
		    //click on create organizations look up image
			OrganizationsPage op= new OrganizationsPage(driver);
			op.clickOnCreateOrgLookUpImg();
			
			//create new organization with mandatory fields and save
			CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
			cnop.createNewOrganization(ORGNAME);
			
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
}
