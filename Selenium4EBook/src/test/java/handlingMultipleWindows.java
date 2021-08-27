import org.testng.annotations.*;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class handlingMultipleWindows {

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
	  Set<String> windows=driver.getWindowHandles();
	  Iterator<String> itr = windows.iterator();
	// traversing over windows Set
	 while(itr.hasNext()){ 
		 driver.switchTo().window(itr.next());
		 System.out.println(driver.getTitle());
		 driver.close();
		 Thread.sleep(1000); //introducing a small wait of 1 second.
		}
	 }
  
  @AfterMethod
  public void afterMethod() {
	  System.out.println("Execution Complete...");
  }

}
