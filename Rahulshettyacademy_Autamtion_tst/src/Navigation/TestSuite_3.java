package Navigation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestSuite_3 
{
	@Test
	public void Navigate_Twitter() //Test Case 6
	{
		//System.setProperty("webdriver.chrome.driver", "D:\\Eclipse\\Eclipse Workspace\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
	    driver.findElement(By.cssSelector("[data-test='social-twitter']")).click();
	}
	@Test
	public void Navigate_Facebook() //Test Case 7
	{
	//	System.setProperty("webdriver.chrome.driver", "D:\\Eclipse\\Eclipse Workspace\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
	    driver.findElement(By.cssSelector("[data-test='social-facebook']")).click();
	}
	@Test
	public void Navigate_LinkedIN() //Test Case 8
	{
		//System.setProperty("webdriver.chrome.driver", "D:\\Eclipse\\Eclipse Workspace\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
	    driver.findElement(By.cssSelector("[data-test='social-linkedin']")).click();
	}
}
