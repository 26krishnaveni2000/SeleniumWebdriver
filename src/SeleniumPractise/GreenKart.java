package SeleniumPractise;

import java.time.Duration;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GreenKart {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\krishnaveni.p\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	
		 driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
			
		 String parent  = driver.getWindowHandle();
		 System.out.println("Parent window: "+driver.getTitle());
		 
		 Scanner sc = new Scanner(System.in);
		 
		 for(int i=0;i<3;i++) {
			 System.out.println("Enter vegetable name: ");
			 String vegetables = sc.nextLine();
			 
			 WebElement searchbox= driver.findElement(By.xpath("//input[@placeholder='Search for Vegetables and Fruits']"));
			 sendKeys(driver, searchbox, 15, vegetables);
			 Thread.sleep(1000);
			 
			 WebElement search = driver.findElement(By.xpath("//button[@class='search-button']"));
			 clickOf(driver, search, 5);
			 
			 WebElement addToCart = driver.findElement(By.xpath("//div[@class='product-action']"));
			 clickOf(driver, addToCart, 20);
			 
			 searchbox.clear();
		 }
		 WebElement cartPreview = driver.findElement(By.xpath("//a[@class='cart-icon']"));
		 clickOf(driver, cartPreview, 20);
		 
		 WebElement proceedToCheckout = driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']"));
		 clickOf(driver, proceedToCheckout, 10);
		 Thread.sleep(2000);
		 
		 WebElement placeOrder = driver.findElement(By.xpath("//button[text()='Place Order']"));
		 clickOf(driver, placeOrder, 30);
		 Thread.sleep(2000);
		 
		 WebElement selectOption = driver.findElement(By.xpath("//select[@style='width: 200px;']"));
		 Select country = new Select(selectOption);
		 List<WebElement> countryList = country.getOptions();
		 System.out.println("List of countries: ");
		 
//		 for(WebElement options:countryList) {
//			 System.out.println(options.getText());
//		 }
		 
		 for(int i=0; i<countryList.size();i++) {
			 String name = countryList.get(i).getText();
			 System.out.println("index : "+ i + "=" + name);
		 }
		 System.out.println("Enter the index of the country: ");
		 int value= sc.nextInt();
		 country.selectByIndex(value);
		 Thread.sleep(2000);
		 
		 WebElement checkBox = driver.findElement(By.xpath("//input[@class='chkAgree']"));
		 clickOf(driver, checkBox, 15);
		 Thread.sleep(2000);
		 
		 WebElement proceed = driver.findElement(By.xpath("//button[text()='Proceed']"));
		 clickOf(driver, proceed, 15);
		 
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
