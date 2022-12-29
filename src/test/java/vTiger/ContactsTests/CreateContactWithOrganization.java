package vTiger.ContactsTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import vTiger.GenericUtilities.BaseClass;
import vTiger.ObjectRepository.ContactInfoPage;
import vTiger.ObjectRepository.ContactsPage;
import vTiger.ObjectRepository.CreateNewContactPage;
import vTiger.ObjectRepository.CreateNewOrganizationPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.OrganizationInfoPage;
import vTiger.ObjectRepository.OrganizationsPage;

@Listeners(vTiger.GenericUtilities.ListenerImplementationClass.class)
public class CreateContactWithOrganization extends BaseClass {
	
        @Test(groups = "SmokeSuite")
        public void createContactWithOrgTest() throws EncryptedDocumentException, IOException {
        	
        	
        String LASTNAME = eUtil.readDataFromExcel("Contacts", 4, 2);
		String ORGNAME = eUtil.readDataFromExcel("Contacts", 4, 3)+jUtil.getRandomNumber();
		
		//Step 5: Navigate to Organization
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationLink();
		
		//Step 6: Click On create Organization look up image
		OrganizationsPage op= new OrganizationsPage(driver);
		op.clickOnCreateOrgLookUpImg();
		
		//Step 7: Create Organization with Mandatory details and Save
		CreateNewOrganizationPage cnop= new CreateNewOrganizationPage(driver);
		cnop.createNewOrganization(ORGNAME);
		
		//Step 8 Validate Organization
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String OrgHeader = oip.getOrganizationHeaderText();
		Assert.assertTrue(OrgHeader.contains(ORGNAME));
		
		//Step 9: Navigate to Contacts link
		hp.clickOnContactsLink();
		
		//Step 10: Click on Create Contact look up image
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactLookupImg();
		
		//Step 11: Create Contact with mandatory fields 
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createNewContact(LASTNAME, ORGNAME, driver);
		
		//Step 12: validate contact 
		ContactInfoPage cip = new ContactInfoPage(driver);
		String contactHeader=cip.getContactHeader();
		Assert.assertEquals(contactHeader.contains(LASTNAME), true);
		
    }
		
		@Test(groups = "RegressionSuite")
		public void DemoTest()
		{
			System.out.println("this is demo");
		}
	
		


}
