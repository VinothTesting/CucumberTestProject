package com.banjara_library.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Non_Available_Books_Page extends BasePage {

	String studentIdSheet="studentTeacherId";
	
	@FindBy(xpath="//input[@value='STUDENT']")
	public WebElement studentButton;
	

	@FindBy(xpath="//input[@value='TEACHER']")
	public WebElement teacherButton;
	

	

	

	public Non_Available_Books_Page(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver,this);
	}
	
	public void clickStudentButton()
	{
		studentButton.click();
	}
	
	public void clickTeacherButton()
	{
		teacherButton.click();
	}
	

	
	
	
	
	
}
