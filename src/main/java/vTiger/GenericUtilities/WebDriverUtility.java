package vTiger.GenericUtilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

   /**
    * This class contains  generic methods to perform all web driver related actions
    * @author Bibhu Prasad
    *
    */
public class WebDriverUtility {
    
    /**
     * This method will maximize the window	
     * @param driver
     */
    public void maximiseWindow(WebDriver driver) {
    	driver.manage().window().maximize();
    }
    
    /**
     * This method will minimize the window
     * @param driver
     */
    public void miniseWindow(WebDriver driver) {
    	driver.manage().window().minimize();
    }
    
    /**
     * This method will wait for entire page to load for 20 seconds 
     * @param driver
     */
    public void waitForPageLoad(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
	/**
	 * This method will wait for element to be visible 
	 * @param driver
	 * @param element
	 */
	public void WaitForElementToBeVisible(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This method will wait for element to be clickable
	 * @param driver
	 * @param element
	 */
	public void WaitForElementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * This is a custom wait for a second to wait for element to become clickable
	 * @param element
	 * @throws InterruptedException
	 */
	public void customWaitForSecond(WebElement element) throws InterruptedException {
		int count=0;
		while(count<5) {
			try {
				element.click(); //exception
				break;
			}
			catch(Exception e){
				Thread.sleep(1000);
				count++;
			}
		}
	}
	
	/**
	 * This method will handle drop down based on index
	 * @param element
	 * @param index
	 */
	public void handleDropDown(WebElement element,int index) {
	Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	
	/**
	 * This method will handle drop down based on value
	 * @param element
	 * @param value
	 */
	public void handleDropDown(WebElement element, String value) {
	Select sel=new Select(element);
	sel.selectByValue(value);
    }
	
	/**
	 * This method will handle drop down based on visible text
	 * @param visibleText
	 * @param element
	 */
	public void handleDropDown(String visibleText, WebElement element ) {
		Select sel = new Select(element);
		sel.selectByVisibleText(visibleText);
	}
	
   /**
    * This method will perform mouse hover action
    * @param driver
    * @param element
    */
	public void mouseHoverAction(WebDriver driver,WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	/**
	 * This method will perform mouse hover action based on offset
	 * @param driver
	 * @param element
	 * @param x
	 * @param y
	 */
	public void mouseHoverAction(WebDriver driver, WebElement element, int x, int y) {
		Actions act = new Actions(driver);
		act.moveToElement(element, x, y).perform();
	}
	
	/**
	 * This method will perform right click randomly on web page
	 * @param driver
	 */
	public void rightClickAction(WebDriver driver) {
		Actions act = new Actions(driver);
		act.contextClick().perform();
	}
	
	/**
	 * This method will perform right click on a particular web element  
	 * @param driver 
	 * @param element
	 */
	public void rightClickAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	
	/**
	 * This method will perform double click randomly on web page 
	 * @param driver
	 */
	public void doubleClickAction(WebDriver driver) {
		Actions act = new Actions(driver);
		act.doubleClick().perform();
	}
	
	/**
	 * This method will perform double click on particular web element
	 * @param driver
	 * @param element
	 */
	public void doubleClickAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	/**
	 * This method will drag and drop from source to target element
	 * @param driver
	 * @param srcElement
	 * @param tarElement
	 */
	public void dranAndDropAction(WebDriver driver, WebElement srcElement, WebElement tarElement) {
		Actions act = new Actions(driver);
		act.dragAndDrop(srcElement, tarElement).perform();
	}
	
	/**
	 * This method will press and release enter key
	 * @throws AWTException
	 */
	public void pressEnterKey() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	
	/**
	 * This method will switch to frame based on index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver, int index) {
	    driver.switchTo().frame(index);
	}
	
	/**
	 * This method will switch to frame based on name or ID
	 * @param driver
	 * @param nameOrID
	 */
	public void switchToFrame(WebDriver driver, String nameOrID) {
		driver.switchTo().frame(nameOrID);
	}
	
	/**
	 * This method will switch to frame based on web element
	 * @param driver
	 * @param element
	 */
	public void switchToFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}
	
	/**
	 * This method will switch to default frame
	 * @param driver
	 */
	public void switchToFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	/**
	 * This element will scroll for 500 units
	 * @param driver
	 */
	public void scrollAction(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0, 500)", "");
	}
	
	/**
	 * This element will scroll until a particular
	 * @param driver
	 * @param element
	 */
	public void scrollAction(WebDriver driver, WebElement element) {
		JavascriptExecutor js= (JavascriptExecutor) driver;
		int y=element.getLocation().getY();
		js.executeScript("window.scrollBy(0, "+y+")", element);
	}
	
	/**
	 * This method will take screen shot and save it in the screenshot folder
	 * @param driver
	 * @param screenShotName
	 * @return
	 * @throws IOException
	 */
	public String taketheScreenShot(WebDriver driver, String screenShotName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(".\\ScreenShots\\"+screenShotName+".png");
		Files.copy(src,dst);
		
		return dst.getAbsolutePath();//used for extent report
	}
	
	/**
	 * this method will switch to window based on partial window title
	 * @param driver
	 * @param partialWinTitle
	 */
	public void switchToWindow(WebDriver driver, String partialWinTitle) 
	{
		Set<String> allWindows = driver.getWindowHandles();
		for(String indWindow:allWindows) 
		{
			String currentWinTitle = driver.switchTo().window(indWindow).getTitle();
			if(currentWinTitle.contains(partialWinTitle))
			{
				break;
			}
		}
	}
	
	
	
	
	
}