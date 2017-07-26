package com.banjara_principal.scripts;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.banjara_principal.pom.Principal_Home_Page;
import com.banjara_principal.pom.Staff_Details_Page;
import com.banjara_principal.pom.Student_Details_Page;

import generics.Excel;

public class Student_Details_Test extends BaseTest{

	@Test(priority=1)
	public void test_Student_Details() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{

		Principal_Home_Page php=new Principal_Home_Page(driver);
		Student_Details_Page sdp=new Student_Details_Page(driver);
		log.info("Viewing all Student Details Test");
		php.clickDetailsLink();
		Thread.sleep(2000);
		php.clickStudentsLink();
		Thread.sleep(2000);
		php.clickStudent_details_Link();
		log.info("Navigated to Student Details page");
		int noofstudent=  Excel.getRowCount(STUDENT_DETAILS, "studDetails");
		String staffid[]=new String[noofstudent+1];
		String staffName[]=new String[noofstudent+1];
		  for(int i=1;i<=noofstudent;i++)
		  {
			  staffid[i]=Excel.getCellValue(STUDENT_DETAILS, "studDetails", i, 0);
			  try
			  {
				  staffid[i]=String.valueOf((int)Float.parseFloat(staffid[i]));
			  }
			  catch(Exception e)
			  {	  
			  }		
			  staffName[i]=Excel.getCellValue(STUDENT_DETAILS, "studDetails", i, 1);
			  try
			  {
				  staffName[i]=String.valueOf((int)Float.parseFloat(staffName[i]));
			  }
			  catch(Exception e)
			  {	  
			  }	
		  }
		 
		  sdp.isStaffDisplayed(staffid, staffName);
		  Thread.sleep(3000);
	}
	@Test(priority=2)
  	public void test_Student_TimeTable() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
  	{
		log.info("Viewing Student Time Table for Every Class and section");
		Principal_Home_Page php=new Principal_Home_Page(driver);
		Student_Details_Page sdp=new Student_Details_Page(driver);
		Thread.sleep(2000);
	//	php.clickDetailsLink();
	//	Thread.sleep(2000);
	//	php.clickStudentsLink();
	//	Thread.sleep(2000);
		php.clickStudent_Timetable_Link();
		Thread.sleep(2000);
		sdp.viewTimeTable();
				
	}

}

























