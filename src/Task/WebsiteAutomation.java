package Task;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WebsiteAutomation {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\krishnaveni.p\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	
		 driver.get("https://in.search.yahoo.com/");
			
		 String parent  = driver.getWindowHandle();
		 System.out.println("Parent window id: "+parent);
		 
		 driver.manage().window().maximize();
		 driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
			

		WebElement searchBox = driver.findElement(By.id("yschsp"));
		sendKeys(driver,searchBox ,10, "selenium");
		
		WebElement searchBoxLink = driver.findElement(By.xpath("//button[@class='sbb'][1]"));
		clickOf(driver,searchBoxLink,3);
	
		WebElement link = driver.findElement(By.xpath("//a[@href='https://www.selenium.dev/']"));
		clickOf(driver, link, 10);
		
		Set<String> childWindow = driver.getWindowHandles();
		
		for(String child: childWindow) {
			if(!(parent.equalsIgnoreCase(child))){
				driver.switchTo().window(child);
				System.out.println("Child window title: " + driver.getTitle());
				
				WebElement searchThisSite = driver.findElement(By.xpath("//input[@aria-label='Search this site…']"));
				sendKeys(driver, searchThisSite, 20, "Web Driver");
				searchThisSite.sendKeys(Keys.ENTER);
				Thread.sleep(2000);
				
				driver.navigate().back();
				
				Thread.sleep(2000);
				
				driver.close();
			}
		}

		driver.switchTo().window(parent);
		System.out.println("parent window name: " + driver.getTitle());
		driver.navigate().back();
		Thread.sleep(3000);
		
		
		WebElement signin = driver.findElement(By.id("ysignin"));
		clickOf(driver,signin, 5);
		
		WebElement createAccount = driver.findElement(By.linkText("Create an account"));
		clickOf(driver, createAccount, 4);
		
		WebElement name = driver.findElement(By.id("usernamereg-firstName"));
		WebElement surname = driver.findElement(By.id("usernamereg-lastName"));
		WebElement email = driver.findElement(By.id("usernamereg-userId"));
		WebElement pwd = driver.findElement(By.xpath("//input[@id='usernamereg-password']"));
		WebElement birthYear = driver.findElement(By.xpath("//input[@id='usernamereg-birthYear'][1]"));
		
		sendKeys(driver, name, 5, "VENI");
		sendKeys(driver, surname, 5, "SREE");
		sendKeys(driver, email, 6, "veni308");
		sendKeys(driver, pwd, 5, "New_12345");
		sendKeys(driver, birthYear, 3, "2000");
		Thread.sleep(2000);
		
		WebElement conti = driver.findElement(By.id("reg-submit-button"));
		clickOf(driver, conti, 5);
		Thread.sleep(2000);
		
		WebElement sendCode = driver.findElement(By.id("reg-submit-button"));
		clickOf(driver, sendCode, 10);
		
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(2000);
		
		for(int i=0; i<3; i++) {
			driver.navigate().back();  
		} 
		Thread.sleep(3000);
		driver.quit();

	}
	
	public static void sendKeys(WebDriver driver, WebElement element, int i, String value ) {
		new WebDriverWait(driver, Duration.ofSeconds(i)).
		until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);
	}
	
	public static void clickOf(WebDriver driver, WebElement element, int i) {
		new WebDriverWait(driver, Duration.ofSeconds(i)).
		until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
	


}
