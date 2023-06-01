package scripts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Script01 {
	@Test
	public void test() throws Exception
	{
		String url = "jdbc:mysql://localhost:3306/qsp";
		String username = "root";
		String password = "root";
		
		Connection connection = DriverManager.getConnection(url, username, password);
		
		Statement statement = connection.createStatement();
		
		String query = "select * from user;";
		
		ResultSet resultSet = statement.executeQuery(query);
		
		while(resultSet.next())
		{
			String un = resultSet.getString(1);
			String pwd = resultSet.getString(2);
			loginToFB(un, pwd);
		}
	}
	
	public static void loginToFB(String username, String password) throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "./Softwares/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys(username);
		Thread.sleep(3000);
		WebElement pass = driver.findElement(By.name("pass"));
		pass.sendKeys(password);
		Thread.sleep(3000);
		WebElement login = driver.findElement(By.name("login"));
		login.click();
		Thread.sleep(5000);
		driver.quit();
	}
}
