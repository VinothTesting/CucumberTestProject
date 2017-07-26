package com.banjara_library.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Library_Home_Page extends BasePage{

	@FindBy(xpath="//i[@class='fa fa-home']")
	public WebElement homeLink;
	
	@FindBy(linkText="Profile")
	public WebElement profileLink;
	
	@FindBy(xpath="//i[@class='fa fa-users']")
	public WebElement staffLink;
	
	@FindBy(linkText="Total Staff")
	public WebElement totalStaffLink;
	
	@FindBy(xpath="//i[@class='fa fa-book']")
	public WebElement hardCopyLink;
	
	@FindBy(linkText="New Book Registration")
	public WebElement newBookRegLink;

	@FindBy(xpath="//a[.=' Total Book Details']")
	public WebElement totalBookLink;
	
	@FindBy(xpath="//i[@class='fa fa-language']")
	public WebElement bookIssueLink;
	
	@FindBy(xpath="//a[.=' Available Books ']")
	public WebElement availableBooksLink;
	
	@FindBy(xpath="//a[@href='NonAvailableBook.jsp']")
	public WebElement nonAvailableBooksLink;
	
	@FindBy(xpath="//a[.='For Student']")
	public WebElement forStudentLink;
	
	@FindBy(xpath="(//a[.='Registration For Booking'])[1]")
	public WebElement forStudentRegBookingLink;
	
	@FindBy(xpath="(//a[.='Return Book'])[1]")
	public WebElement forStudentReturnLink;
	
	@FindBy(xpath="(//a[.='Fine Collection'])[1]")
	public WebElement forStudentFineCollectionLink;
	
	
	@FindBy(xpath="//a[.='For Teacher']")
	public WebElement forTeacherLink;
	@FindBy(xpath="(//a[.='Registration For Booking'])[2]")
	public WebElement forTeacherRegBookingLink;
	@FindBy(xpath="(//a[.='Return Book'])[2]")
	public WebElement forTeacherReturnLink;
	@FindBy(xpath="(//a[.='Fine Collection'])[2]")
	public WebElement forTeacherFineCollectionLink;
	
	public Library_Home_Page(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver,this);
	}
	
	public void clickHomeLink() 
	{
	  
		homeLink.click();
	}
	public void clickProfileLink() 
	{
	  
		profileLink.click();
	}
	public void clickHardCopyLink() 
	{
	  
		hardCopyLink.click();
	}
	public void clickNewBookRegLink() 
	{
	  
		newBookRegLink.click();
	}
	public void clickTotalBookPageLink() 
	{
	  
		totalBookLink.click();
	}

	public void clickStaffLink() 
	{
	  	staffLink.click();
	}
	public void clickTotalStaffLink() 
	{
	  
		totalStaffLink.click();
	}
	public void clickBookIssueLink() 
	{
	  
		bookIssueLink.click();
	}
	
	public void clickAvailableBooksLink() 
	{
	  availableBooksLink.click();
	}
	public void clickNonAvailableBooksLink() 
	{
	  nonAvailableBooksLink.click();
	}
	
	public void clickForStudentLink() 
	{
	  forStudentLink.click();
	}
	public void clickForStudentRegBookingLink() 
	{
	  forStudentRegBookingLink.click();
	}
	public void clickforStudentReturnLink() 
	{
	  forStudentReturnLink.click();
	}
	public void clickForStudentFineCollectionLink() 
	{
	    forStudentFineCollectionLink.click();
	}
	
	public void clickForTeacherLink() 
	{
	  forTeacherLink.click();
	}
	
	public void clickForTeacherRegBookingLink() 
	{
	  	forTeacherRegBookingLink.click();
	}	
	public void clickForTeacherReturnLink() 
	{
	  	forTeacherReturnLink.click();
	}
	
	public void clickForTeacherFineCollectionLink() 
	{
	  	forTeacherFineCollectionLink.click();
	}

}
