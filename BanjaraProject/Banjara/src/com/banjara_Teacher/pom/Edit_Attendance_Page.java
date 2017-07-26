package com.banjara_Teacher.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Edit_Attendance_Page extends BasePage {

	
@FindBy(xpath="//input[@value='Update']")
public WebElement updateButton;



	public Edit_Attendance_Page(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver,this);
	}
	
	public void clickEditButton(String id)
	{
		driver.findElement(By.xpath("//td[.='"+id+"']/following-sibling::td/a/u[.='Edit']")).click();
	}
	
	public void clickUpdateButton(String id)
	{
		updateButton.click();
	}
	
	public void editAttRadioButton()
	{
		try
		{
		driver.findElements(By.xpath("//input[@name='status']")).get(0).isSelected();
		driver.findElements(By.xpath("//input[@name='status']")).get(1).click();
		
		}
		catch(Exception e)
		{

			driver.findElements(By.xpath("//input[@name='status']")).get(1).isSelected();
			driver.findElements(By.xpath("//input[@name='status']")).get(0).click();
			
		}
	}
}
