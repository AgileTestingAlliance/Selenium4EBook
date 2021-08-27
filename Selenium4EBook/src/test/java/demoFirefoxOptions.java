import org.testng.annotations.*;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import io.github.bonigarcia.wdm.WebDriverManager;


public class demoFirefoxOptions {

	WebDriver driver;
  
  @BeforeMethod
  public void beforeMethod() {
	  //create webdriver for ie driver
	  WebDriverManager.firefoxdriver().setup();
	  //Create option class object to set custom profile
	  FirefoxProfile profile = new FirefoxProfile();
	  FirefoxOptions options = new FirefoxOptions();
	  options.setProfile(profile);
	  driver = new FirefoxDriver(options);
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
