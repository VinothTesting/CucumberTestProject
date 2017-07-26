package com.banjara_Teacher.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Add_Student_Result_Page extends BasePage{
	
	
	
	public Add_Student_Result_Page(WebDriver driver) {
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
	
	@FindBy(xpath="//button[@class='button button3']")
	public WebElement submitResultButton;
	

	@FindBy(xpath="//font[.='Successfully Inserted Result ']")
	public WebElement successMessage;
	
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
	public void clickSubmitButton()
	{
		submitButton.click();
	}
	public void enterMark(String id,String mark)
	{
		driver.findElement(By.xpath("//td[.='"+id+"']/following-sibling::td/input[@name='marks']")).sendKeys(mark);
	}
	
	public void clickSubmitResultButton()
	{
		submitResultButton.click();
	}
	public boolean isSuccessMsgDisplayed()
	
	{
		try{
			successMessage.isDisplayed();
			log.info("Success message is displayed Successfully");
			return true;
		}
		catch(NoSuchElementException e)
		{
			log.error("Result not submitted Succesfully");
			return false;
		}
	}
}
