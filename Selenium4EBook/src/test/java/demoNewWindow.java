import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class demoNewWindow {
	
	WebDriver driver;
	
  
  @BeforeMethod
  public void beforeMethod() {
	  WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
  }

  @Test
  public void openApp() throws Exception{
	  driver.get("https://seleniumsummit21.agiletestingalliance.org/");
	  driver.switchTo().newWindow(WindowType.WINDOW);
	  driver.navigate().to("https://www.agiletestingalliance.org/");
  }
  
  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}
