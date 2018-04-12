package First;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class NewTest {
	private WebDriver driver;
 
	@Test
  public void v() {
	  
	  driver.get("http://dev.autoaccessoryconfigurator.com");  
		String title = driver.getTitle();				 
		Assert.assertTrue(title.contains("AAC"));
		System.out.println("Test Success one");
  }
  
	@Test 
  
  public void two () throws InterruptedException{
	  driver.get("http://devhrs.thesynapses.com");
	  driver.findElement(By.xpath("html/body/div[1]/div/div/div[1]/div[2]/form/center/div/div/div")).click();
	  Set<String> AllWindowHandles = driver.getWindowHandles();
		String window1 = (String) AllWindowHandles.toArray()[0];
		System.out.print("window1 handle code = "+AllWindowHandles.toArray()[0]);
		String window2 = (String) AllWindowHandles.toArray()[1];
		System.out.print("\nwindow2 handle code = "+AllWindowHandles.toArray()[1]);
	    driver.switchTo().window(window2);
	    Thread.sleep(3000);
		driver.findElement(By.id("identifierId")).sendKeys("an.nigam@thesynapses.com");
		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='password']/div[1]/div/div[1]/input")).sendKeys("anmol159@@");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		driver.switchTo().window(window1);
		Thread.sleep(3000);
		System.out.println("Test Success two");
	  
  }
  
	@BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "G:\\WSpace\\WRP\\src\\main\\resources\\chromedriver.exe");
	  driver = new ChromeDriver();
  }

  @AfterTest
  public void afterTest() {
	  
	  driver.quit();
  }
  

}
