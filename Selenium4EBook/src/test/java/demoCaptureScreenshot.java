import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.File;
import org.apache.commons.io.FileUtils;


public class demoCaptureScreenshot {
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
		  //Capturing Screenshot of entire screen
		  TakesScreenshot scrShot =((TakesScreenshot) driver);
		  File scrScreen=scrShot.getScreenshotAs(OutputType.FILE);
		  //Move image file to new destination
		  File dstScreen=new File("Screenshots\\entireScreen.jpg");
		  //Copy file at destination
		  FileUtils.copyFile(scrScreen, dstScreen);
		  Thread.sleep(2000);
		}
	 }
  
  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}
