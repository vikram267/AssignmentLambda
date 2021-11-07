package lambda;

import java.awt.AWTException;
import java.io.IOException;
import java.net.MalformedURLException;
//import com.gargoylesoftware.htmlunit.javascript.host.URL;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class basetest {
	
	public static RemoteWebDriver driver = null;
	public String username = "vikramviki267";
	public String authkey = "vNNGspjIyQyymgra4yJCOwgMOUKz5VcvNBTOD6Xt7gI06HOuRP";
	public String gridURL = "@hub.lambdatest.com/wd/hub";
	  boolean status = false;
	 WebDriver driver1;

	@Parameters({ "browser" })
	@BeforeTest
	public void setUp(String browser) throws InterruptedException, IOException, AWTException, MalformedURLException {
		  DesiredCapabilities capabilities = new DesiredCapabilities();
		  capabilities.setCapability("platform", "Windows 10");
	      capabilities.setCapability("browserName", "Chrome");
	      capabilities.setCapability("version", "95.0");
	      capabilities.setCapability("resolution","1024x768");
	      capabilities.setCapability("build", "LambdaTestSampleApp");
	      capabilities.setCapability("name", "LambdaTestJavaSample");
	      capabilities.setCapability("build", "First Test");
	      capabilities.setCapability("name", "Sample Test");
	      capabilities.setCapability("network", true); // To enable network logs
	      capabilities.setCapability("visual", true); // To enable step by step screenshot
	      capabilities.setCapability("video", true); // To enable video recording
	      capabilities.setCapability("console", true); // To capture console logs
	      try {
			if (browser.equalsIgnoreCase("safari")) {		
				WebDriver driver = new SafariDriver();	
			} else if (browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver1 = new ChromeDriver();	
	      } 
      
			driver = new RemoteWebDriver(capabilities);
			driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + gridURL), capabilities);
    		
	      } catch (Exception e) {
	          System.out.println(e.getMessage());
	  }
  }

	@Test
	public void lamassignment() throws InterruptedException, IOException, AWTException
	{
		driver.manage().window().maximize();
		driver.get("https://www.lambdatest.com/automation-demos");
		login loginpage = new login(driver);
		Homepage Home = new Homepage(driver);
		loginpage.loginsection("lambda", "lambda123");
	    Home.Homevalidations("hey@gmail.com");
	    Home.uploadimage();
        driver.quit();
	   
	}

  }
