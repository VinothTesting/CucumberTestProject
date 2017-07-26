package com.banjara_library.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Available_Books_Page extends BasePage{

		
	

	public Available_Books_Page(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver,this);
	}
	
	
	
	
	
	
	
	
}
