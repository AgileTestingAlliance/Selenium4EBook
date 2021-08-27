import org.testng.annotations.*;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import io.github.bonigarcia.wdm.WebDriverManager;


public class demoChromeOptions {

	WebDriver driver;
  
  @BeforeMethod
  public void beforeMethod() {
	  //create webdriver for chrome driver
	  WebDriverManager.chromedriver().setup();
	  //Create option class object and make chrome browser run in headless mode.
	  ChromeOptions options = new ChromeOptions();
	  options.setHeadless(true);
	  driver = new ChromeDriver(options);
  }

  @Test
  public void openApp() throws Exception{
	  //open application
	  driver.get("https://seleniumsummit21.agiletestingalliance.org/");
	  //wait for 2 seconds before browser closes to see the action done
	  Thread.sleep(2000);
  }
  
  @AfterMethod
  public void afterMethod() {
	  //close the browser
	 driver.quit();
  }

}
