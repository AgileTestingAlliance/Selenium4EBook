import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import io.github.bonigarcia.wdm.WebDriverManager;


public class demoRelativeLocators {
	
	WebDriver driver;
	
  
  @BeforeMethod
  public void beforeMethod() {
	  WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
  }

  @Test
  public void openApp() throws Exception{
	  
	  driver.get("https://the-internet.herokuapp.com/login");
	  //above
	  WebElement loginBtn=driver.findElement(By.xpath("//button[@class='radius']"));
	  WebElement password=driver.findElement(RelativeLocator.with(By.tagName("input")).above(loginBtn));
	
	  password.sendKeys("SuperSecretPassword!"); //set the text in password field
	  password.clear(); //clear the contents of the password field
	  
	  
	  //below
	  WebElement username=driver.findElement(By.name("username"));
	  WebElement passwd=driver.findElement(RelativeLocator.with(By.tagName("input")).below(username));
	  passwd.sendKeys("SuperSecretPassword!"); //set the text in password field
	  passwd.clear(); //clear the contents of the password field
	  
	  

	  	  
	  
	 
	/*
	 
	 //toLeft
	 driver.get("https://the-internet.herokuapp.com/challenging_dom");
	 WebElement table=driver.findElement(By.tagName("table"));
	 WebElement lastButton=driver.findElement(RelativeLocator.with(By.tagName("a")).toLeftOf(table));
	 System.out.println(lastButton.getText());
	*/
	  

	 
	
	 
  }
  
  @AfterMethod
  public void afterMethod() {
	 // driver.close();
  }

}
