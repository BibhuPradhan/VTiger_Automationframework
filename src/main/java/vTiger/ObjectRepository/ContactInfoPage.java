package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement ContactHeaderText;
	
	public ContactInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getContactHeaderText() {
		return ContactHeaderText;
	}


	//Business Logic
			/**
			 * This method will return the header text of organization
			 * @return
			 */
	public String getContactHeader() {
		return ContactHeaderText.getText();
	}


	

	}

	
