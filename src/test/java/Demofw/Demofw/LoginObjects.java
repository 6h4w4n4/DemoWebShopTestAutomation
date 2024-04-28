package Demofw.Demofw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class LoginObjects {
  
	  WebDriver driver;
	  public LoginObjects(WebDriver d)
	  {
		  this.driver=d;
		  PageFactory.initElements(d, this);
	  }
	  @FindBy(name="username")
	  WebElement name;
	  
	  @FindBy(name="password")
	  WebElement password;
	  
	  @FindBy(xpath="//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")
	  WebElement button;
	  
	  void loginusername(String uname)
	  {
		  name.sendKeys(uname);
	  }
	  void loginpassword(String pass)
	  {
		  password.sendKeys(pass);
	  }
	  void loginbutton()
	  {
		  button.click();
	  }
	  @FindBy(xpath="//*[@id=\'userName\']")
	  WebElement demoqausername;
	  
	  @FindBy(xpath="//*[@id=\"password\"]")
	  WebElement demoqapassword;
	  
	  @FindBy(xpath="//*[@id=\"login\"]")
	  WebElement demoqabutton;
	  
	  void demoqaloginuname(String qauname)
	  {
		  demoqausername.sendKeys(qauname);
	  }
	  void demoqaloginpass(String qapass)
	  {
		  demoqapassword.sendKeys(qapass);
	  }
	  void demoqaloginbutton()
	  {
		  demoqabutton.click();
	  }
	  
	  
}

