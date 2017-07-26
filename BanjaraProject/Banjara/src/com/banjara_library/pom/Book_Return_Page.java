package com.banjara_library.pom;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Book_Return_Page extends BasePage{

	
	
	@FindBy(xpath="//input[@value='Return Book']")
	public WebElement returnBookLink;
	
	@FindBy(xpath="//input[@value='Fine Check']")
	public WebElement fineCheckButton;
	
	
	@FindBy(name="fine")
	public WebElement fineAmountField;
	
	
	@FindBy(xpath="//button[.='PAID']")
	public WebElement paidButton;
	
	@FindBy(xpath="//h4[.='Successfully Paid']")
	public WebElement successMsg;
	
	@FindBy(xpath="//input[@name='StudentId']")
	public WebElement studentIdField;
	
	
	public Book_Return_Page(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this);	
	}
		
	public void clickReturnBookLink()
	{
		returnBookLink.click();
	}
		
	public void clickFineCheckButton()
	{
		fineCheckButton.click();
	}
		
	
	public void setFineAmount()
	{
		fineAmountField.sendKeys("10");
	}
		
	public void clickPaidButon()
	{
	  paidButton.click();
	}	
	public void setStudentId(String stud_id)
	{
		studentIdField.sendKeys(stud_id);
	}

	public void isSuccessMsgDisplayed()
	{
	  try{
		  successMsg.isDisplayed();
		  log.info("Successful Message is displayed after paying and Returning Book");
	  }
	  catch(NoSuchElementException e)
	  {
		  log.error("Successful Message is not displayed");
	  }
	}	

}
