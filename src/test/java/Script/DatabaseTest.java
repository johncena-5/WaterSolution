package Script;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatabaseTest {

	@Parameters("browser")
	@Test
	public void demo(String browser) {
		
		WebDriver driver = null;
		
		switch(browser) {
		
		case "chrome":WebDriverManager.chromedriver().setup();
		              driver = new ChromeDriver();
		              break;
		case "edge"  :WebDriverManager.edgedriver().setup();
		              driver = new EdgeDriver();
		              break;
		  default    :System.out.println("enter valid browser");
		
		}
		driver.get("https://google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
	}
}
