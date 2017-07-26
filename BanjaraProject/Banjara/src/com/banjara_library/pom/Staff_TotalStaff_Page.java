package com.banjara_library.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Staff_TotalStaff_Page extends BasePage{

	
	
	public Staff_TotalStaff_Page(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver,this);
	}

	



}
