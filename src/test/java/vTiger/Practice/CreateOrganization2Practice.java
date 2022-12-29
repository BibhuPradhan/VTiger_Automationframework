package vTiger.Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateOrganization2Practice {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		driver.findElement(By.xpath("(//img[@border='0'])[10]")).click();
		driver.findElement(By.name("accountname")).sendKeys("crio plus");
		driver.findElement(By.xpath("(//input[@type='radio'])[1]")).click();
		
		WebElement ele = driver.findElement(By.name("industry"));
		Select s=new Select(ele);
		s.selectByValue("Healthcare");
		
		driver.findElement(By.name("button")).click();
		
        WebElement ele1 = driver.findElement(By.xpath("(//img[@border='0'])[3]"));
		
		Actions act=new Actions(driver);
		act.moveToElement(ele1).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		

	}

}
