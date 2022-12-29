package vTiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericUtilities.WebDriverUtility;

public class CreateNewContactPage  extends WebDriverUtility{

	@FindBy(name="lastname")
	private WebElement lastNameEdt;
	
	@FindBy(name="leadsource")
	private WebElement leadsourceDropDown;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img[@title='Select']")
	private WebElement organizationImg;
	
	@FindBy(name="search_text")
	private WebElement searchEdt;
	
	@FindBy(name="search")
	private WebElement searchBtn;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn; 
	
	public CreateNewContactPage( WebDriver driver) 
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	public WebElement getLeadsourceDropDown() {
		return leadsourceDropDown;
	}

	public WebElement getOrganizationImg() {
		return organizationImg;
	}

	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//this method will create a new method with last name
	public void createNewContact(String lastName) {
		lastNameEdt.sendKeys(lastName);
		saveBtn.click();
	}
	
	//
	public void createNewContact(String lastName, String orgName, WebDriver driver)
	{
		lastNameEdt.sendKeys(lastName);
		organizationImg.click();
		switchToWindow(driver,"Accounts");
		searchEdt.sendKeys(orgName);
		searchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		switchToWindow(driver,"contacts");
		saveBtn.click();
		
	}

	
}
