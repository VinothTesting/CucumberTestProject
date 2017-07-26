package com.banjara_Teacher.pom;



import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class LoginPage extends BasePage {
	public static Logger log = Logger.getLogger("LoginPage");
	@FindBy(name="ID")
	public WebElement unTB;
	
	@FindBy(name="PASSWORD")
	public WebElement pwTB;
	
	
	@FindBy(xpath="//input[@value='LOG IN']")
	public WebElement loginButton;

	@FindBy(xpath="//h4[contains(.,'Sorry')]")
	public WebElement errorMsg;
	
	@FindBy(xpath="//a[@href='ChangePassword.html']")
	public WebElement changePasswordLink;
	
	@FindBy(xpath="//a[@href='ForgetPassword.html']")
	public WebElement forgotPasswordLink;
	
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver,this);
	}
	public void setUsername(String un)
	{
		unTB.sendKeys(un);
	}
	public void setPassword(String pwd)
	{
		pwTB.sendKeys(pwd);
	}
	public void clickLoginButton()
	{
		loginButton.click();
	}
	public void clickChangePasswordLink()
	{
		changePasswordLink.click();
	}
	public void clickForgotPasswordLink()
	{
		forgotPasswordLink.click();
	}
	public void checkErrorMsg() throws InterruptedException
	{
	  Thread.sleep(3000);
	  try{
	  Assert.assertEquals(true,errorMsg.isDisplayed());
	  log.info("Error message is displayed for invalid inputs");
	  
	  
	  }
	  catch(AssertionError e)
	  {
		  	log.error("Error message is not displayed for entering invalid inputs");
	  }
	  
	}
	
}
