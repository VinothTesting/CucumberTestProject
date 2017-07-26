package com.banjara_principal.pom;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



abstract public class BasePage {
	public static Logger log = Logger.getLogger("BasePage");
	public WebDriver driver;
	
	public BasePage(WebDriver driver)
	{
		this.driver=driver;
	}
	@FindBy(xpath="//i[@class='fa fa-sign-out pull-right']")
    public WebElement logoutLink;
	@FindBy(xpath="//a[@class='user-profile dropdown-toggle']")
	public WebElement profileDropdownLink;
	public void clickLogoutLink() throws InterruptedException
	{
		profileDropdownLink.click();
		Thread.sleep(3000);
		logoutLink.click();
	}
	
	
	public void verifyHomePageTitle()
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.titleContains("Principal |"));
		String title = driver.getTitle();
		try{
		Assert.assertEquals("Principal |", title);
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
