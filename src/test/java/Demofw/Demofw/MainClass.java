package Demofw.Demofw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MainClass {
	
  @Test
  public void orange() throws InterruptedException 
  {
	  	System.setProperty("webdriver.chrome.driver","C:\\selinium webdriver\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		LoginObjects obj=new LoginObjects(driver);
		Thread.sleep(5000);
		obj.loginusername("Admin");
		obj.loginpassword("admin123");
		obj.loginbutton();
		
  }
  @Test
  public void demoqa() throws InterruptedException
  {
	  	System.setProperty("webdriver.chrome.driver","C:\\selinium webdriver\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/login");
		LoginObjects obj=new LoginObjects(driver);
		Thread.sleep(5000);
		obj.demoqaloginuname("abcd");
		obj.demoqaloginpass("1234");
		obj.demoqaloginbutton();
	  
  }
  
  
}
