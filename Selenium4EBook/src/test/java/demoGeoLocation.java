import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class demoGeoLocation {
	WebDriver driver;
 
  @BeforeMethod
  public void beforeMethod() {
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
  }

  @Test
  public void findPumaStore() throws Exception{
	 
	  //Map coordinates Delhi India
	  Map coordinatesDelhi = Map.of(
              "latitude", 28.6472799,
              "longitude", 76.8130644,
              "accuracy", 1
      );
	//Map coordinates Dubai UAE
	 Map coordinatesDubai = Map.of(
              "latitude", 25.0763815,
              "longitude", 54.9475464,
              "accuracy", 1
      );
	  
	String totalStores;
	
	 //((ChromiumDriver) driver).executeCdpCommand("Emulation.setGeolocationOverride", coordinatesDelhi);
	 ((ChromiumDriver) driver).executeCdpCommand("Emulation.setGeolocationOverride", coordinatesDubai);
     driver.navigate().to("https://about.puma.com/en/storelocator");
     Thread.sleep(5000);
     totalStores=driver.findElement(By.className("number-of-stores")).getText();
     System.out.println(totalStores+ " PUMA stores found near this location");
}
	 
  
  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}
