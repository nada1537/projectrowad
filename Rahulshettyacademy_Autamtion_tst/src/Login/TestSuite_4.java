package Login;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSuite_4 
{
	@Test
	public void Login_with_correct_credentials() //Test Case 8
	{
		//System.setProperty("webdriver.chrome.driver", "D:\\Eclipse\\Eclipse Workspace\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		System.out.println(driver.getCurrentUrl());
		String actual_URL = driver.getCurrentUrl();
		String Expected_URL = "https://www.saucedemo.com/inventory.html";
		if(!(Expected_URL.equals(actual_URL ))) 
		{
			Assert.fail("Expected and actual results do not match :)");
		}
	}
}
