	package lambda;
	
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	
	public class login {
		
		 public void loginsection(String username,String password) throws InterruptedException
		    {
		    	this.setusername(username);
		    	this.setpassword(password);
		    	this.login();
		    	Thread.sleep(2000);
		    	this.validateurl();
		    	
		    }
		
		
		WebDriver test;
		
		
		By username=By.cssSelector("#username");
		By password=By.cssSelector("#password");
		By loginbutton = By.xpath("//button[normalize-space()='Login']");
		String expectedtitle = "Selenium Playground";
		
		
	    public login(WebDriver test)
	    {
	       this.test=test;  	
	    }

	    
	    public void login(String user,String pass)
	    {
	    
	    	test.findElement(username).sendKeys(user);
	    	test.findElement(password).sendKeys(pass);
	    	test.findElement(loginbutton).click();
	    }
	    
	    
	    public void setusername(String user)
	    {
	    	test.findElement(username).sendKeys(user);
	    }
	   
	    
	    public void setpassword(String pass)
	    {
	    	test.findElement(password).sendKeys(pass);
	    }
	    
	    
	    public void login()
	    {
	    	test.findElement(loginbutton).click();
	    }
	    
	    public void validateurl()
	    {
	    	String title = test.findElement(By.xpath("//h1[normalize-space()='Selenium Playground']")).getText();
	    	if(expectedtitle.equalsIgnoreCase(title))
              	System.out.println("The expected title is same as actual tile --- "+title);
        	else
              	System.out.println("The expected title doesn't match the actual tile --- "+title);
      	}

	}


