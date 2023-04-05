package Script;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestScriptTest1 {
	
	
		
		@Test(dataProvider = "data")
		public void login(String username, String password) {

			ChromeOptions option = new ChromeOptions();
			option.addArguments("--remote-allow-origins=*");
			WebDriver driver = new ChromeDriver(option);
			driver.get("https://demo.actitime.com/login.do");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			driver.findElement(By.id("username")).sendKeys(username);
			driver.findElement(By.name("pwd")).sendKeys(password);
			driver.findElement(By.id("loginButton")).click();
			WebElement close = driver.findElement(By.id("closeProjectLightBoxBtn"));
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(close)).click();

		}

		@DataProvider
		public Object[][] data() {

			Object[][] obj = new Object[2][2];

			obj[0][0] = "admin";
			obj[1][0] = "trainee";

			obj[0][1] = "manager";
			obj[1][1] = "trainee";

			return obj;
		
	}
}
