package com.banjara_Teacher.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class View_Attendance_Page extends BasePage{

	@FindBy(xpath="//a[@href='View_Student_Attendance.jsp']")
	public WebElement viewAttendanceMenu;
	
	@FindBy(name="STANDARD")
	public WebElement stdDropdown;
	
	@FindBy(name="SECTION")
	public WebElement sectionDropdown;
	
	@FindBy(id="date")
	public WebElement dateField;
	
	@FindBy(xpath="//input[@value='submit']")
	public WebElement submitButton;
	
	public View_Attendance_Page(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver,this);
	}
	public void clickViewAttendanceMenu()
	{
		viewAttendanceMenu.click();
	}
	
	public void clickStdDropdown(String std)
	{
		
		Select select=new Select(stdDropdown);
		select.getOptions();
		select.selectByVisibleText(std);
		//driver.findElement(By.xpath("//option[@value='"++"']")).click();
	}
	
	public void clickSectionDropdown(String sec)
	{
		Select select=new Select(sectionDropdown);
		select.getOptions();
		select.selectByValue(sec);
	//	driver.findElement(By.xpath("//option[@value='"+sec+"']")).click();
	}
	public void setDate(String date)
	{
		dateField.clear();
		dateField.sendKeys(date);
	}
	public void clickSubmitButton()
	{
		submitButton.click();
	}
	

	public boolean isAddedAttendanceDisplayed(String date,String AttendanceStatus,String id)
	{
		try
		{
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");
			driver.findElement(By.xpath("//td[.='"+id+"']/following-sibling::td[.='"+date+"']/following-sibling::td[.='"+AttendanceStatus+"']")).isDisplayed();
			return true;
		}
		catch(NoSuchElementException e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
}
