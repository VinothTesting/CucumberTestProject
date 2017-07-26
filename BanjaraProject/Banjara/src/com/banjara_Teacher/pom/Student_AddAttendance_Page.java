package com.banjara_Teacher.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Student_AddAttendance_Page extends BasePage{

	
	@FindBy(xpath="//a[@href='Add_Student_Attendance.jsp']")
	public WebElement addAttendanceMenu;
	
	@FindBy(name="STANDARD")
	public WebElement stdDropdown;
	
	@FindBy(name="SECTION")
	public WebElement sectionDropdown;
	
	@FindBy(id="datepicker")
	public WebElement dateField;
	
	@FindBy(xpath="//input[@value='submit']")
	public WebElement submitButton;
	
	@FindBy(xpath="//button[@class='button button3']")
	public WebElement submitAttendanceButton;
	
	public Student_AddAttendance_Page(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver,this);
	}
		
	public void clickAddAttendanceMenu()
	{
		addAttendanceMenu.click();
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

	public void clickAttendanceRadioButton(String studid,String attStatus)
	{
	   driver.findElement(By.xpath("//input[@name='id' and @value='"+studid+"']/../..//input[@value='"+attStatus+"']")).click();
	}
	
	
	public void clickSubmitAttendanceButton()
	{
		submitAttendanceButton.click();
	}
	
	public boolean isSuccessMsgDisplayed()
	{
		try
		{
			//((JavascriptExecutor)driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");
			driver.findElement(By.xpath("//font[.='Successfully Added Attendance ']")).isDisplayed();
			return true;
		}
		catch(NoSuchElementException e)
		{
			return false;
		}
	}
}
