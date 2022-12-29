package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {

	@FindBy(xpath="//img[@alt='Create Contact...']")
	private WebElement CreateContactLookupImg;
	
	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateContactLookupImg() {
		return CreateContactLookupImg;
	}
	
	/*
	 * This method will click on create contact lookup image
	 */
	public void clickOnCreateContactLookupImg() {
		CreateContactLookupImg.click();
	}
	
}