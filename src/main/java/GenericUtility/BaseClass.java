package GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	Connection con;
	static WebDriver sdriver;
	WebDriver driver;
	
	
	
	@BeforeSuite
	public void configureSuite() throws SQLException {
		
		Driver driver = new Driver();
	    DriverManager.registerDriver(driver);
	    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hebbal", "root", "root");
		
	}
	
	@BeforeClass
	public void configureClass(String Browser) {
		
		switch (Browser) {
		
		case "chrome": WebDriverManager.chromedriver().setup();
		               driver = new ChromeDriver();
		               break;
		case "edge":   WebDriverManager.edgedriver().setup();
		               driver = new ChromeDriver();
		               break;
		default:       System.out.println("enter valid browser");
		}
		driver.manage().window().maximize();
		driver.get("");
		sdriver=driver;

	}
}
