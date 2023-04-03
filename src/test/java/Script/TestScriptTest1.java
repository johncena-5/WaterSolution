package Script;

import org.testng.annotations.Test;

public class TestScriptTest1 {
	
	@Test
	public void login() {
		
		String BROWSER = System.getProperty("browser");
		String URL = System.getProperty("url");
		String USERNAME = System.getProperty("username");
		String PASSWORD = System.getProperty("password");
		String TIME = System.getProperty("time");
		
		System.out.println(BROWSER+" "+URL+" "+USERNAME+" "+PASSWORD+" "+TIME);
	}
}
