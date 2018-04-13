package appiumpackage;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;


public class LoginWRP {
WebDriver driver;

@BeforeClass
public void setUp() throws MalformedURLException{
	//Set up desired capabilities and pass the Android app-activity and app-package to Appium
	DesiredCapabilities capabilities = new DesiredCapabilities();
	capabilities.setCapability("BROWSER_NAME", "Android");
	capabilities.setCapability("VERSION", "8.0.0"); 
	capabilities.setCapability("deviceName","Emulator");
	capabilities.setCapability("platformName","Android");
 
   capabilities.setCapability("appPackage", "com.thesynapses.wrp");
// This package name of your app (you can get it from apk info app)
	capabilities.setCapability("appActivity","com.thesynapses.wrp.MainActivity"); // This is Launcher activity of your app (you can get it from apk info app)
//Create RemoteWebDriver instance and connect to the Appium server
 //It will launch the Calculator App in Android Device using the configurations specified in Desired Capabilities
   driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
}

@Test
public void testLogin() throws Exception {
   //locate the Text on the login by using By.id()
	
    driver.findElement(By.id("email")).sendKeys("n.sharma@thesynapses.com");
    driver.findElement(By.id("password")).sendKeys("Password1");
    WebElement loginbtn=driver.findElement(By.className("android.widget.Button"));
    loginbtn.click();
    
}



@AfterClass
public void f(){
	//close the app
//	driver.quit();
}
}

