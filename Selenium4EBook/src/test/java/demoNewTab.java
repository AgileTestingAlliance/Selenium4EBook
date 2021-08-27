import org.testng.annotations.*;

import java.util.Set;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class demoNewTab {
	
	WebDriver driver;
	
  
  @BeforeMethod
  public void beforeMethod() {
	  WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
  }

  @Test
  public void openApp() throws Exception{
	  driver.get("https://seleniumsummit21.agiletestingalliance.org/");
	  driver.switchTo().newWindow(WindowType.TAB);
	  driver.navigate().to("https://www.agiletestingalliance.org/");
	  
	  
  }
  
  @AfterMethod
  public void afterMethod() {
	  //driver.close();
  }

}
