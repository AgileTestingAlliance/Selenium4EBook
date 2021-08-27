import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class demoW3C {
	
	WebDriver driver;
	
  
  @BeforeMethod
  public void beforeMethod() {
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
		
		
  }

  @Test
  public void openApp() throws Exception{
	  driver.get("https://seleniumsummit21.agiletestingalliance.org/");
	  Thread.sleep(1000);
	  
	  
  }
  
  @AfterMethod
  public void afterMethod() {
	//  driver.close();
  }

}
