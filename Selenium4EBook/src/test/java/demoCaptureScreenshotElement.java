import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.File;
import org.apache.commons.io.FileUtils;


public class demoCaptureScreenshotElement {
	WebDriver driver;
 
  @BeforeMethod
  public void beforeMethod() {
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
  }

  @Test
  public void openApp() throws Exception{
	  driver.get("https://the-internet.herokuapp.com/login");
	  //Click on social media icon
	  driver.manage().window().maximize();
	  driver.findElement(By.name("username")).sendKeys("admin");
	  driver.findElement(By.name("password")).sendKeys("admin");
	  driver.findElement(By.className("radius")).click();
	  if(driver.getPageSource().contains("invalid")) {
		//Capturing Screenshot of an element
		  WebElement element = driver.findElement(By.id("flash-messages"));
		  File scrElement = ((TakesScreenshot) element).getScreenshotAs(OutputType.FILE);
		  File dstElement = new File("Screenshots\\errorElement.jpg");
		  FileUtils.copyFile(scrElement, dstElement);
		  Thread.sleep(2000);
		}
	 }
  
  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}
