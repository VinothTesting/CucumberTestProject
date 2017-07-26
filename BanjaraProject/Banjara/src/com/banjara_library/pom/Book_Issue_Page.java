package com.banjara_library.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Book_Issue_Page extends BasePage{


	
	
	@FindBy(xpath="//input[@name='BookId']")
	public WebElement bookId_SearchBoxField;
	
	@FindBy(className="myButton")
	public WebElement searchButton;
	
	@FindBy(linkText="Register Here")
	public WebElement registerHereLink;
	
	@FindBy(xpath="//input[@name='name']")
	public WebElement studentIdField;
	
	@FindBy(linkText="Register Here")
	public WebElement registerLink;
	
	@FindBy(name="Rdate")
	public WebElement returnDateField;
	
	@FindBy(xpath="//button[.='Register Book']")
	public WebElement issueRegisterButton;
	
//	@FindBy(xpath="//h3[.='Booking Successfull']")
//	public WebElement issueSuccessMessage;
	

	public Book_Issue_Page(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver,this);
	}
	
	public void setBookId(String bookid)
	{
		bookId_SearchBoxField.sendKeys(bookid);
	}
	
	public void clickSearchButton()
	{
		searchButton.click();
	}
    public void clickRegisterHereLink()
     {
    	  registerHereLink.click();
     }
	public void setStudentId(String stud_id)
	{
		studentIdField.sendKeys(stud_id);
	}
	
	public void clickRegisterLink()
	{
		registerLink.click();
	}
	
	public void setReturnDate(String return_Date)
	{
		returnDateField.clear();
		returnDateField.sendKeys(return_Date);
	}
	public void clickIssueRegisterButton()
	{
		issueRegisterButton.click();
	}
	
	public boolean returnSuccessMessage()
	{
		try{
			WebElement msg=driver.findElement(By.xpath("//h3[contains(.,'Booking Successfull')]"));
			return msg.isDisplayed();
		}
		catch(NoSuchElementException e)
		{
			return false;
		}
		
	}
	
	
	
}
