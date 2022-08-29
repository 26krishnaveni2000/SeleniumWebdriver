package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.ClickAction;

public class Locators {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\krishnaveni.p\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://login.yahoo.com/");
		//ID
//		WebElement username= driver.findElement(By.id("login-username"));
//		username.sendKeys("krishna veni@yahoo.com");
//		Thread.sleep(2000);
//		WebElement nextBtn= driver.findElement(By.id("login-signin"));
//		nextBtn.click();
//		Thread.sleep(2000);
		
		//XPATH
		
//		driver.findElement(By.xpath("//input[@id='login-username']")).sendKeys("krishnaveni@yahoo.com");
//		driver.findElement(By.xpath("//input[@id='login-signin']")).click();
		
		//link
		
		driver.findElement(By.linkText("Create an account")).click();
		driver.findElement(By.linkText("Continue")).click();
		driver.quit();
	}

}
