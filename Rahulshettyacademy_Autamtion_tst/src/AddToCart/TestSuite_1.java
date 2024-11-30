package AddToCart;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSuite_1 
{
	@Test
	public void AddingOneItem_to_cart_successfully() //Test Case 1
	{
		//System.setProperty("webdriver.chrome.driver", "D:\\Eclipse\\Eclipse Workspace\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		List<WebElement> elements_inventory_names = driver.findElements(By.className("inventory_item_name"));
		List<WebElement> elements_inventory_prices = driver.findElements(By.cssSelector("[data-test='inventory-item-price']"));
		String Expected_ItemName_Added= elements_inventory_names.get(0).getText();
		String Expected_ItemPrice_Added= elements_inventory_prices.get(0).getText();
		driver.findElement(By.cssSelector("[data-test='add-to-cart-sauce-labs-backpack']")).click();
	    driver.findElement(By.className("shopping_cart_link")).click();
		List<WebElement> elements_cart_names = driver.findElements(By.className("inventory_item_name"));
		List<WebElement> elements_cart_prices = driver.findElements(By.cssSelector("[data-test='inventory-item-price']"));
		String Actual_ItemName_Added= elements_cart_names.get(0).getText();
		String Actual_ItemPrice_Added= elements_cart_prices.get(0).getText();
		if(!(elements_cart_names.size()==1 && elements_cart_prices.size()==1 
				&& Expected_ItemName_Added.equals(Actual_ItemName_Added) 
				&& Expected_ItemPrice_Added.equals(Actual_ItemPrice_Added))) 
		{
			Assert.fail("Expected and actual results do not match :)");
		}
	}
	@Test
	public void AddingItems_to_cart_successfully() //Test Case 2
	{
		//System.setProperty("webdriver.chrome.driver", "D:\\Eclipse\\Eclipse Workspace\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		List<WebElement> elements_inventory_names = driver.findElements(By.className("inventory_item_name"));
		List<WebElement> elements_inventory_prices = driver.findElements(By.cssSelector("[data-test='inventory-item-price']"));
		String Expected_ItemName_Added= elements_inventory_names.get(0).getText();
		String Expected_ItemPrice_Added= elements_inventory_prices.get(0).getText();
		String Expected_ItemName_Added_2= elements_inventory_names.get(1).getText();
		String Expected_ItemPrice_Added_2= elements_inventory_prices.get(1).getText();//momken tet3mel array
		driver.findElement(By.cssSelector("[data-test='add-to-cart-sauce-labs-backpack']")).click();
	    driver.findElement(By.cssSelector("[data-test='add-to-cart-sauce-labs-bike-light']")).click();
	    driver.findElement(By.className("shopping_cart_link")).click();
		List<WebElement> elements_cart_names = driver.findElements(By.className("inventory_item_name"));
		List<WebElement> elements_cart_prices = driver.findElements(By.cssSelector("[data-test='inventory-item-price']"));
		String Actual_ItemName_Added= elements_cart_names.get(0).getText();
		String Actual_ItemPrice_Added= elements_cart_prices.get(0).getText();
		String Actual_ItemName_Added_2= elements_cart_names.get(1).getText();
		String Actual_ItemPrice_Added_2= elements_cart_prices.get(1).getText();
		if(!(elements_cart_names.size()==2 && elements_cart_prices.size()==2 
				&& Expected_ItemName_Added.equals(Actual_ItemName_Added) 
				&& Expected_ItemPrice_Added.equals(Actual_ItemPrice_Added)
				&& Expected_ItemName_Added_2.equals(Actual_ItemName_Added_2) 
				&& Expected_ItemPrice_Added_2.equals(Actual_ItemPrice_Added_2))) 
		{
			Assert.fail("Expected and actual results do not match :)");
		}
	}
	@Test
	public void cart_remove_button() //Test Case 3
	{
		//System.setProperty("webdriver.chrome.driver", "D:\\Eclipse\\Eclipse Workspace\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
	    driver.findElement(By.cssSelector("[data-test='add-to-cart-sauce-labs-backpack']")).click();
	    driver.findElement(By.className("shopping_cart_link")).click();
		driver.findElement(By.id("remove-sauce-labs-backpack")).click();
		List<WebElement> elements = driver.findElements(By.className("inventory_item_name"));
		if(!(elements.size() == 0)) 
		{
			Assert.fail("Expected and actual results do not match :)");
		}
	}
	@Test
	public void cart_continue_shopping_button() //Test Case 4
	{
		//System.setProperty("webdriver.chrome.driver", "D:\\Eclipse\\Eclipse Workspace\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
	    driver.findElement(By.cssSelector("[data-test='add-to-cart-sauce-labs-backpack']")).click();
	    driver.findElement(By.className("shopping_cart_link")).click();
		driver.findElement(By.id("continue-shopping")).click();
		String actual_URl = driver.getCurrentUrl();
		String Expected_URL="https://www.saucedemo.com/inventory.html";
		if(!Expected_URL.equals(actual_URl)) 
		{
			Assert.fail("Expected and actual results do not match :)");
		}
		
	}
	@Test
	public void Inventory_remove_button() //Test Case 5
	{
		//System.setProperty("webdriver.chrome.driver", "D:\\Eclipse\\Eclipse Workspace\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
	    driver.findElement(By.cssSelector("[data-test='add-to-cart-sauce-labs-backpack']")).click();
	    driver.findElement(By.className("shopping_cart_link")).click();
		driver.findElement(By.id("continue-shopping")).click();
		driver.findElement(By.cssSelector("[data-test='remove-sauce-labs-backpack']")).click();
		driver.findElement(By.className("shopping_cart_link")).click();
		List<WebElement> elements_cart_names = driver.findElements(By.className("inventory_item_name"));
		List<WebElement> elements_cart_prices = driver.findElements(By.cssSelector("[data-test='inventory-item-price']"));
		if(!(elements_cart_names.size()==0 && elements_cart_prices.size()==0)) 
		{
			Assert.fail("Expected and actual results do not match :)");
		}		
	}
	
}
