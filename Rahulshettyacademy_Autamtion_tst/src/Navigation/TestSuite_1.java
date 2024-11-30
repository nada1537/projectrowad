package Navigation;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSuite_1 
{
	@Test
	public void Navigate_AboutPage() //Test Case 1
	{
		//System.setProperty("webdriver.chrome.driver", "D:\\Eclipse\\Eclipse Workspace\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		driver.findElement(By.id("react-burger-menu-btn")).click();
		driver.findElement(By.id("about_sidebar_link")).click();
	    String actual_URL = driver.getCurrentUrl();
		String Expected_URL = "https://saucelabs.com/";
		if(!(Expected_URL.equals(actual_URL ))) 
		{
			Assert.fail("Expected and actual results do not match :)");
		}
	}
	
	@Test
	public void Navigation_Close_button() //Test Case 2
	{
		//System.setProperty("webdriver.chrome.driver", "D:\\Eclipse\\Eclipse Workspace\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		driver.findElement(By.id("react-burger-menu-btn")).click();
		driver.findElement(By.id("react-burger-cross-btn")).click();
	}
	@Test
	public void Navigation_AllItems() //Test Case 3
	{
		//System.setProperty("webdriver.chrome.driver", "D:\\Eclipse\\Eclipse Workspace\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		driver.findElement(By.className("shopping_cart_link")).click();
		driver.findElement(By.id("react-burger-menu-btn")).click();
		driver.findElement(By.id("inventory_sidebar_link")).click();
	}
	@Test
	public void Reset_App_State() //Test Case 4
	{
		//System.setProperty("webdriver.chrome.driver", "D:\\Eclipse\\Eclipse Workspace\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		driver.findElement(By.cssSelector("[data-test='add-to-cart-sauce-labs-backpack']")).click();
		driver.findElement(By.cssSelector("[data-test='add-to-cart-sauce-labs-bike-light']")).click();
		driver.findElement(By.cssSelector("[data-test='add-to-cart-sauce-labs-bolt-t-shirt']")).click();
		driver.findElement(By.cssSelector("[data-test='add-to-cart-sauce-labs-fleece-jacket']")).click();
		String number_of_items =driver.findElement(By.cssSelector("[data-test='shopping-cart-badge']")).getText();
		if(!number_of_items.equals("4")) 
		{
			Assert.fail("Items is not added Successfully to the Cart :(");
		}
		driver.findElement(By.id("react-burger-menu-btn")).click();
		driver.findElement(By.id("reset_sidebar_link")).click();
		driver.findElement(By.id("react-burger-cross-btn")).click();
		//driver.findElement(By.className("shopping_cart_link")).click();
		List<WebElement> elements_cart = driver.findElements(By.className("shopping_cart_badge"));
		if(!(elements_cart.size()==0)) 
		{
			Assert.fail("Items is not removed Successfully to the Cart :(");
		}
		//driver.findElement(By.id("continue-shopping")).click();
		/*driver.findElement(By.className("shopping_cart_link")).click();
		driver.findElement(By.id("react-burger-menu-btn")).click();
		driver.findElement(By.id("inventory_sidebar_link")).click();*/
	}
}
