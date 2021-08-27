import org.testng.annotations.*;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.interactions.*;

public class demoClickAndContextClick {

	WebDriver driver;
  
  @BeforeMethod
  public void beforeMethod() {
	  //create webdriver for chrome driver
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
  }

  @Test
  public void openApp() throws Exception{
	  //open application
	  driver.get("https://the-internet.herokuapp.com/");
	  WebElement menuLink=driver.findElement(By.linkText("Context Menu"));
	  //Create object for action class
	  Actions act= new Actions(driver);
	  //call the click(WebElement) method
	  act.click(menuLink).perform(); 
	  WebElement box=driver.findElement(By.id("hot-spot"));
	  //call the contextClick(WebElement) method
	  act.contextClick(box).perform();
	  //wait for 2 seconds before browser closes to see the action done
	  Thread.sleep(2000);
  }
  
  @AfterMethod
  public void afterMethod() {
	  //close the browser
	 driver.quit();
  }

}
