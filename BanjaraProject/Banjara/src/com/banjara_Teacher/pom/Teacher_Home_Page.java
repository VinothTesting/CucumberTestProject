package com.banjara_Teacher.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Teacher_Home_Page extends BasePage{


	@FindBy(xpath="//a[@class='user-profile dropdown-toggle']")
	public WebElement profileMenu;

	@FindBy(xpath="//a[@href='logout.jsp']")
	public WebElement logoutLink;
	
	@FindBy(xpath="//a[.=' Attendance ']")
	public WebElement attendanceLink;
	
	@FindBy(linkText="Student Attendance")
	public WebElement studentAttendanceLink;
	
	@FindBy(xpath="//a[.=' Student Result ']")
	public WebElement studentResultLink;
	
	@FindBy(linkText="Add Result")
	public WebElement addResultLink;
	
	
	@FindBy(linkText="View Result")
	public WebElement viewResultLink;
	
	public Teacher_Home_Page(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver,this);
	}

	public void clickProfileMenu()
	{
		profileMenu.click();
	}
	
	public void clickLogoutLink()
	{
		logoutLink.click();
	}

	public void clickAttendanceLink()
	{
		attendanceLink.click();
	}
	public void clickStudentAttendanceLink()
	{
		studentAttendanceLink.click();
	}
	public void clickStudentResultLink()
	{
		studentResultLink.click();
	}

	public void clickAddResultLink()
	{
		addResultLink.click();
	}
	public void clickViewResultLink()
	{
		viewResultLink.click();
	}
}
