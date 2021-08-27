import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;

public class demoFluentWait {
	WebDriver driver;
 
  @BeforeMethod
  public void beforeMethod() {
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
  }

  @Test
  public void fluentMethodExample() throws Exception{
	  driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
	  Thread.sleep(2000); //this wait is introduced so that we are able to observe add element being clicked.
	  driver.findElement(By.xpath("//*[contains(text(),'Add Element')]")).click();
	  //creation of fluent wait object with 
	  FluentWait wait = new FluentWait(driver)
              .pollingEvery(Duration.ofMillis(500))
              .ignoring(NoSuchElementException.class)
              .withTimeout(Duration.ofSeconds(20));
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Delete')]")));
	  Thread.sleep(2000);//this wait is introduced so that we are able to observe delete element being clicked.
	  driver.findElement(By.xpath("//*[contains(text(),'Delete')]")).click();
	 
	}
  
  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}
