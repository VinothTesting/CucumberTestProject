package com.banjara_principal.scripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import com.banjara_principal.pom.Principal_Home_Page;
import com.banjara_principal.pom.Staff_Details_Page;

import generics.Excel;

public class Staff_Details_Test extends BaseTest {

	@Test
	public void Test_StaffListDetails() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{

	Principal_Home_Page php=new Principal_Home_Page(driver);
	  Staff_Details_Page sdp=new Staff_Details_Page(driver);
	  log.info("Viewing all Staff Details Test");
	  php.clickDetailsLink();
	  Thread.sleep(3000);
	  php.clickStaffLink();
	  Thread.sleep(3000);
	  php.clickStaff_details_Link();
	  Thread.sleep(3000);
	  sdp.clickViewAllStaffLink();
	  Thread.sleep(3000);
	  log.info("Navigated to  Staff Details page");
	int noofstaff=  Excel.getRowCount(STAFF_DETAILS, "stafflist");
	String staffid[]=new String[noofstaff+1];
	  for(int i=1;i<=noofstaff;i++)
	  {
		  staffid[i]=Excel.getCellValue(STAFF_DETAILS, "stafflist", i, 0);
		  try
		  {
			  staffid[i]=String.valueOf((int)Float.parseFloat(staffid[i]));
		  }
		  catch(Exception e)
		  {	  
		  }		
	
	  }
		sdp.isStaffDisplayed(staffid);  
	}
	
	@Test
	public void Test_StaffTimeTable() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		Principal_Home_Page php=new Principal_Home_Page(driver);
		Staff_Details_Page sdp=new Staff_Details_Page(driver);
		php.clickDetailsLink();
		Thread.sleep(3000);
     	php.clickStaffLink();
     	Thread.sleep(3000);
		php.clickStaff_Timetable_Link();
		Thread.sleep(3000);
		int noofstaff=  Excel.getRowCount(STAFF_DETAILS, "stafflist");
		String staffid[]=new String[noofstaff+1];
		 for(int i=1;i<=noofstaff;i++)
		  {
			  staffid[i]=Excel.getCellValue(STAFF_DETAILS, "stafflist", i, 0);
			  try
			  {
				  staffid[i]=String.valueOf((int)Float.parseFloat(staffid[i]));
			  }
			  catch(Exception e)
			  {	  
			  }		
		      
		  }
		 log.info("Viewing Time Table of all Teachers");
		 sdp.viewTimeTable(staffid);
		 Thread.sleep(3000);
		
	}
	

	@Test
	public void Test_StaffAttendance() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		Principal_Home_Page php=new Principal_Home_Page(driver);
		Staff_Details_Page sdp=new Staff_Details_Page(driver);
		php.clickStaff_Attendance_Link();
		Thread.sleep(2000);
		sdp.clickTeachingRadioButton();
		Thread.sleep(2000);	
	}
}



























