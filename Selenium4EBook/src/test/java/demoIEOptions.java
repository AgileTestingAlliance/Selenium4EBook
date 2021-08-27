import org.testng.annotations.*;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.*;
import org.openqa.selenium.ie.*;
import io.github.bonigarcia.wdm.WebDriverManager;


public class demoIEOptions {

	WebDriver driver;
  
  @BeforeMethod
  public void beforeMethod() {
	  //create webdriver for ie driver
	  WebDriverManager.iedriver().setup();
	  //Create option class object to ignore zoom settings
	  InternetExplorerOptions options = new InternetExplorerOptions();
	  options.ignoreZoomSettings();
	  driver = new InternetExplorerDriver(options);
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
