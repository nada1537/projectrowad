package Login;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSuite_3 
{
	@Test
	public void Login_with_wrong_credentials() //Test Case 6
	{
		//System.setProperty("webdriver.chrome.driver", "D:\\Eclipse\\Eclipse Workspace\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("Nada");
		driver.findElement(By.id("login-button")).click();
		String actual_message = driver.findElement(By.cssSelector("h3")).getText();
		String Expected_message = "Epic sadface: Username and password do not match any user in this service";
		driver.findElement(By.id("user-name")).clear();
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("user-name")).sendKeys("Nada");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		String actual_message2 = driver.findElement(By.cssSelector("h3")).getText();
		String Expected_message2 = "Epic sadface: Username and password do not match any user in this service";
		if(!(Expected_message.equals(actual_message ) && Expected_message2.equals(actual_message2))) 
		{
			Assert.fail("Expected and actual results do not match :)");
		}
	}
	@Test
	public void Login_with_wrong_credentials_close_button() //Test Case 7
	{
		//System.setProperty("webdriver.chrome.driver", "D:\\Eclipse\\Eclipse Workspace\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("Nada");
		driver.findElement(By.id("login-button")).click();
		driver.findElement(By.className("error-button")).click();
		/*driver.findElement(By.id("user-name")).clear();
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("user-name")).sendKeys("Nada");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		driver.findElement(By.className("error-button")).click();*/
	}
	
}
