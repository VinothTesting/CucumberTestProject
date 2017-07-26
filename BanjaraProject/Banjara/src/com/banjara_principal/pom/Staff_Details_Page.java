package com.banjara_principal.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Staff_Details_Page extends BasePage{





	@FindBy(linkText="click to view all")
	public WebElement viewAllStaffLink;
	
	@FindBy(name="teacherid")
	public WebElement teacheridField;
	

	@FindBy(xpath="//input[@value='view']")
	public WebElement viewButton;
	
	@FindBy(xpath="//(//input[@name='tab'])[1]")
	public WebElement teachingRadioButton;
	
	@FindBy(xpath="(//input[@name='tab'])[2]")
	public WebElement nonTeachingRadioButton;
	
	public Staff_Details_Page(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this);
	}
	
	public void clickViewAllStaffLink()
	{
		viewAllStaffLink.click();
	}
	public void clickViewButton()
	{
		viewButton.click();
	}
	public void isStaffDisplayed(String[] id)
	{
	 try
		{
			for(int i=1;i<id.length;i++)
		    {
				
		       driver.findElement(By.xpath("//b[.='TEACHER ID']/../../..//td/b[.='"+id[i]+"']")).isDisplayed();
		    }
		    log.info("All staff Details are sucessfully Displayed");
		}
		catch(NoSuchElementException e)
		{
			log.error("All staff Details are not sucessfully Displayed");
		}
	}
	public void viewTimeTable(String[] id) throws InterruptedException
	{
		for(int i=1;i<id.length;i++)
		{
			teacheridField.clear();
			teacheridField.sendKeys(id[i]);
			Thread.sleep(2000);
			viewButton.click();
			Thread.sleep(2000);
			try{

				driver.findElement(By.xpath("//h3[.='TeacherId :"+id[i]+"']")).isDisplayed();
				log.info("Time Table for Teacher id:"+id[i]+" is viewed");
			}
			catch(NoSuchElementException e)
			{
                 
				try{
					driver.findElement(By.xpath("//h3[.='Sorry, could not find that Timetable...']")).isDisplayed();
					log.info("Time Table for Teacher id:"+id[i]+" not been added message displayed");
				}
				catch(NoSuchElementException f)
				{
					log.error("Time Table view is not Successfull ");
				}
			}
			
			
			driver.navigate().back();
			Thread.sleep(2000);
			
		}
	}
	public void clickTeachingRadioButton()
	{
		teachingRadioButton.click();
	}
	public void clickNonTeachingRadioButton()
	{
		nonTeachingRadioButton.click();
	}
}
