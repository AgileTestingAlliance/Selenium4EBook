import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.*;
import java.net.URL;
import java.util.List;


public class demoSeleniumGridHubAndNodeonDockerComposeChrome {
	WebDriver driver;
	String hubURL = "http://34.125.112.81:4444/wd/hub";

 
  @BeforeMethod
  public void beforeMethod() throws Exception {
	  DesiredCapabilities caps = new DesiredCapabilities();
      caps.setBrowserName("chrome");
      driver = new RemoteWebDriver(new URL(hubURL), caps);
  }

  @Test
  public void launchApplication() throws Exception{
	  driver.get("https://seleniumsummit21.agiletestingalliance.org/");
	  //find all links on the home page and print information
	  List<WebElement> links = driver.findElements(By.xpath("//a"));
	  for(WebElement link: links) {
		  System.out.println(link.getText());
		  System.out.println(link.getAttribute("href"));
	  }
  }
  
  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}
