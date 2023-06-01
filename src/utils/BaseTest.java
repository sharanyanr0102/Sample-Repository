package utils;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	WebDriver driver;
	@BeforeMethod
	public void openApplication()
	{
		driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void closeApplication()
	{
		driver.quit();
	}
}
