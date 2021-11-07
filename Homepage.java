package lambda;

import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class Homepage {
	
	public static WebDriver driver;
	
	public void Homevalidations(String email) throws InterruptedException, IOException, AWTException
	   {
		   this.enterEmail(email);
		   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		   this.Popup();
		   this.radiobutton();
		   this.selectcheck("1");
		   this.selectcheck("2");
		   this.paymentMethod();
		   this.selectcheck("5");
		   this.ecommerce();
		   this.feedbacksection();
		   this.newtab();
		   this.gettingimage();
		   this.previoustab();
	 }

	By Emailid = By.id("developer-name");
	By populatebutton  = By.xpath("//input[@id='populate']");
	String radbutton ="//input[@id='month']";
    String  checkbutton ="(//input[@type='checkbox'])[Num]";
    By sliderarea = By.xpath("//div[@role='slider']");
    By  slidenum = By.xpath("//div[@class='mb-30']/div/div/div[10]");
	By  paymentpreference = By.id("preferred-payment");
	By  textfeedback   = By.xpath("//textarea[@id='comments']");
	By   upload = By.xpath("//label[@id='img']");
	String actualurl = "https://www.lambdatest.com/automation-demos";
	By imgJenkins = By.xpath("//img[@title='Jenkins']");
	
    public Homepage(WebDriver driver )
    {
       Homepage.driver=driver;  	
    }

	public void enterEmail(String email)
	{
		driver.findElement(Emailid).sendKeys(email);
		driver.findElement(populatebutton).click();
	}
	
	public void radiobutton()
	{
     driver.findElement(By.xpath(radbutton)).click();
	}
	
   public void Popup()
   {  	
	   Alert alert= driver.switchTo().alert();
       String message =alert.getText();
       message.equalsIgnoreCase("hey@gmail.com");
	   alert.accept();
   }
   
   public void  selectcheck(String num)
   {
	 String xpath= checkbutton.replaceAll("Num", num);
	 driver.findElement(By.xpath(xpath)).click();  
	 
   }
   
   public void paymentMethod()
   {  
	   WebElement dropdown = driver.findElement(paymentpreference);
	   Select select = new Select(dropdown); 
	   select.selectByVisibleText("Wallets");
   }
   
   
   public void ecommerce() throws InterruptedException
   {
	   WebElement Pos1 = driver.findElement(sliderarea);
	   WebElement Pos2 = driver.findElement(slidenum);
	   Actions builder = new Actions(driver);
	   builder.dragAndDrop(Pos1, Pos2).build().perform();	
	   String actualvalue = Pos1.getAttribute("aria-valuemax");
	   AssertJUnit.assertEquals(actualvalue, "100");
	   System.out.println("The expected aria-valuemax value is same as actual value --- "+actualvalue);
   }
   
   
   public void feedbacksection() throws InterruptedException
   {
	   Thread.sleep(2000);
	   driver.findElement(textfeedback).sendKeys("Feedback");
   }
   
   
   public void newtab()
   {
	  ((JavascriptExecutor) driver).executeScript("window.open()");
	    ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1));
	    driver.get("https://www.lambdatest.com/selenium-automation");
   }
   
   public void gettingimage() throws IOException, InterruptedException, AWTException
	 {
    WebElement logo =   driver.findElement(imgJenkins);
    Actions action= new Actions(driver);
    action.contextClick(logo).build().perform();
    action.sendKeys(Keys.CONTROL, "v").build().perform();
    Robot r = new Robot();
    r.keyPress(KeyEvent.VK_SHIFT);
    r.keyPress(KeyEvent.VK_ENTER);
	 }
	 
	 public void previoustab()
	   {
		  ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		    driver.switchTo().window(tabs.get(0)); //switches to new tab
		    driver.get("https://www.lambdatest.com/selenium-automation");
	   }

    public void uploadimage()
    {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	WebElement upload_file = driver.findElement(upload);
    	js.executeScript("arguments[0].scrollIntoView();", upload_file);
    	upload_file.sendKeys("/Users/vikrams/Downloads/jenkins.svg");
    }
   
}
