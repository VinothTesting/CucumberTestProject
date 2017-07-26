package com.banjara_library.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HardCopyNewBookRegistration_TotalBookDetails_Page extends BasePage{
	
	
	@FindBy(name="bookid")
	public WebElement bookIdTB;
	
	@FindBy(name="bookname")
	public WebElement bookNameTB;

	@FindBy(name="bookauthor")
	public WebElement authorTB;
	
	@FindBy(name="bookpublisher")
	public WebElement publisherTB;

	@FindBy(name="Sdate")
	public WebElement submitDateField;

		
	
	@FindBy(name="bookquantity")
	public WebElement bookQuantityTB;
	

	@FindBy(xpath="//input[@class='button button5']")
	public WebElement registerButton;
	
	@FindBy(xpath="//h4[.='Book Is Added Successfully:']")
	public WebElement successMsg;
	
	public HardCopyNewBookRegistration_TotalBookDetails_Page(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver,this);
	}
	
	public void setBookId(int id)
	{
		bookIdTB.sendKeys(String.valueOf(id));
		System.out.println("sending");
	}
	public void setBookName(String name)
	{
		bookNameTB.sendKeys(name);
	}
	public void setAuthorName(String name)
	{
		authorTB.sendKeys(name);
	}
	public void setPublisher(String publisher)
	{
		publisherTB.sendKeys(publisher);
	}
	public void setSubmitDate(String date)
	{
		submitDateField.sendKeys(date);
	}
	public void setBookQuantity(int no)
	{
		bookQuantityTB.sendKeys(String.valueOf(no));
	}
	public void clickRegisterButton() 
	{
	    registerButton.click();
	}
	public void isSuccessMsgDisplayed() 
	{
	    try{
	    	successMsg.isDisplayed();
	    	log.info("Registration successful Message is displayed");
	    }
	    catch(Exception e)
	    {
	    log.error("Success message is not displayed");	
	    }
	}

}
