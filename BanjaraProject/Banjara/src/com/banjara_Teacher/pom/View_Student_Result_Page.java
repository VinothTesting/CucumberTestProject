package com.banjara_Teacher.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class View_Student_Result_Page extends BasePage{


	public View_Student_Result_Page(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this);
	}

	@FindBy(name="STANDARD")
	public WebElement stdDropdown;
	
	@FindBy(name="SECTION")
	public WebElement sectionDropdown;
	
	@FindBy(name="SUBJECT")
	public WebElement subDropdown;
	
	@FindBy(name="EXAM_NAME")
	public WebElement examNameDropdown;
	
	@FindBy(xpath="//input[@value='submit']")
	public WebElement submitButton;

	@FindBy(xpath="//u[.='Delete  Record']")
	public WebElement deleteLink;

	@FindBy(xpath="//input[@value='Update']")
	public WebElement updateButton;

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
	public void clickSubDropdown(String sub)
	{
		Select select=new Select(subDropdown);
		select.getOptions();
		select.selectByVisibleText(sub);
		//driver.findElement(By.xpath("//option[@value='"++"']")).click();
	}
	
	public void clickExamNameDropdown(String examName)
	{
		Select select=new Select(examNameDropdown);
		select.getOptions();
		select.selectByValue(examName);
	//	driver.findElement(By.xpath("//option[@value='"+sec+"']")).click();
	}
	public void clickEditButton(String id)
	{
		driver.findElement(By.xpath("//td[.='"+id+"']/following-sibling::td[.='Edit']")).click();
	}
	public void clickSubmitButton()
	{
		submitButton.click();
	}

	public boolean isAddedResultDisplayed(String id,String mark)
	{
		try
		{
		//((JavascriptExecutor)driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");
			driver.findElement(By.xpath("//td[.='"+id+"']/following-sibling::td[.='"+mark+"']")).isDisplayed();
			return true;
		}
		catch(NoSuchElementException e)
		{
			e.printStackTrace();
			return false;
		}
	}
	public void editStudentResult()
	{
		driver.findElement(By.name("marks")).clear();
		driver.findElement(By.name("marks")).sendKeys("80");
	}
	public void clickUpdateButton()
	{
		updateButton.click();
	}
	public void clickDeleteLink()
	{
		deleteLink.click();
	}

}
