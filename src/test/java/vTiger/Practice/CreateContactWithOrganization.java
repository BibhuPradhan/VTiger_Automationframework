package vTiger.Practice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateContactWithOrganization {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("(//a[text()='Contacts'])[1]")).click();
		driver.findElement(By.xpath("(//img[@border='0'])[10]")).click();
		
	 	String parent = driver.getWindowHandle();
	 	
		driver.findElement(By.name("lastname")).sendKeys("bibhu");
		driver.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
		driver.findElement(By.xpath("(//img[@alt='Select'])[1]")).click();
		
        Set<String> child = driver.getWindowHandles();
        for(String b:child) {
    		driver.switchTo().window(b);
    	}
    	driver.findElement(By.xpath("//a[text()='globe nextgen']")).click();
   
    	driver.switchTo().window(parent);
    	
    	
		driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
		
        WebElement ele = driver.findElement(By.xpath("(//img[@border='0'])[3]"));
		
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}

}
