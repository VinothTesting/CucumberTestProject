package com.banjara_principal.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Student_Details_Page extends BasePage{

	
	@FindBy(xpath="//input[@value='Done']")
	public WebElement doneButton;
	

	@FindBy(name="standard")
	public WebElement standardDropdown;
	
	@FindBy(name="section")
	public WebElement sectionDropdown;
		
	@FindBy(xpath="//h3[.='Sorry, could not find that Timetable...']")
	public WebElement nottmsg;
	

	@FindBy(xpath="//h1[.='TIME TABLE']")
	public WebElement ttmsg;
	
	public Student_Details_Page(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver,this);
	}
	
	public void isStaffDisplayed(String id[],String name[])
	{
		try{
		
		for(int i=1;i<id.length;i++)
		{
		 driver.findElement(By.xpath("//th[.='Id']/../..//td[1][.='"+id[i]+"']")).isDisplayed();
		 driver.findElement(By.xpath("//td[.='"+id[i]+"']/../td[2][.='"+name[i]+"']")).isDisplayed();
	    }
		 log.info("All Student Details are displayed Successfully");
	}
		catch(NoSuchElementException e)
		{
		 log.error("All Student Details are not displayed Successfully");
		}
		
	}
	public boolean isMsgDisplayed()
	{
	try{
		nottmsg.isDisplayed();
		return true;
	   }
	catch(NoSuchElementException e)
	{
		return false;
	}
	
	}	
		
	public boolean isttMsgDisplayed()
	{
	 try
	  {
		ttmsg.isDisplayed();
		return true;
	  }
	 catch(NoSuchElementException e)
	 {
		return false;
     }
	
	}	
	public void clickDoneButton()
	{
		doneButton.click();
	}
	
	public void viewTimeTable() throws InterruptedException
	{
		for(int i=0;i<10;i++)
		{
		    Select select3=new Select(standardDropdown);
            String std=select3.getOptions().get(i).getText();
            Thread.sleep(1000);
			select3.selectByVisibleText(std);			
			for(int j=0;j<3;j++)
			{
				Thread.sleep(1000);
				Select select4=new Select(sectionDropdown);
				Thread.sleep(1000);
				String sec=select4.getOptions().get(j).getText();
				select4.selectByVisibleText(sec);
					
				Thread.sleep(1000);
				clickDoneButton();
			
				Thread.sleep(1000);
				boolean value=isMsgDisplayed();
			
				try
				{
			    	Assert.assertEquals(value, true); 
			     	log.info("Time Table for "+std+" Standard "+sec+" section  not been added message is displayed ");
			    }
				catch(AssertionError e)
				{
					boolean val=isttMsgDisplayed();
					try
					{
				    	Assert.assertEquals(val, true); 
				    	log.info("Time Table for "+std+" Standard "+sec+" section is viewed");
				    }
					
					catch(AssertionError ex)
					{
						log.error("Time Table for "+std+" Standard "+sec+" section is not successfull");
					}
				}                                                                                       
				                                                                                             
				Thread.sleep(1000);
				driver.navigate().back();
			    Thread.sleep(1000);
			
		 }
	   }
	
   }
}



