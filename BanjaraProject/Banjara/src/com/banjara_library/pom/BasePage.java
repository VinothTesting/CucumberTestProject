package com.banjara_library.pom;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



abstract public class BasePage {
	
	public static Logger log = Logger.getLogger("BasePage");
	public WebDriver driver=null;
	
	public BasePage(WebDriver driver)
	{
		this.driver=driver;
	}
	@FindBy(xpath="//a[@href='Logout.jsp']")
    public WebElement logoutLink;
	
	@FindBy(xpath="//a[@class='user-profile dropdown-toggle']")
	public WebElement profileDropdownLink;
	public void clickLogoutLink()
	{
		profileDropdownLink.click();
		logoutLink.click();
	}
	
	
	public void verifyHomePageTitle()
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.titleContains("Librarian"));
		String title = driver.getTitle();
		try{
		Assert.assertEquals("Librarian |", title);
		log.info("Home page title is verified");
		}
		catch(AssertionError e)
		{
			log.error("Title is not home page title");
		}
	}
	public void verifyLoginPageTitle()
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.titleContains("LOGIN"));
		String title = driver.getTitle();
		try{
		Assert.assertEquals("LOGIN", title);
		log.info("Login page Title is verified");
		}
		catch(AssertionError e)
		{
			log.error("Title is not login page title");
		}
	}
	
}
