package Login;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSuite_1 
{
	@Test
	public void Login_without_credentials() //Test Case 1
	{
		WebDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("login-button")).click();
		String actual_message = driver.findElement(By.cssSelector("h3")).getText();
		String Expected_message = "Epic sadface: Username is required";
		if(!Expected_message.equals(actual_message)) 
		{
			Assert.fail("Expected and actual results do not match :)");
		}
	}
	@Test
	public void Login_without_credentials_close_button() //Test Case 2
	{
		//System.setProperty("webdriver.chrome.driver", "D:\\Eclipse\\Eclipse Workspace\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("login-button")).click();
		driver.findElement(By.className("error-button")).click();
	}

}
