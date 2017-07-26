package com.banjara_Teacher.scripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.banjara_Teacher.pom.Edit_Attendance_Page;
import com.banjara_Teacher.pom.Student_AddAttendance_Page;
import com.banjara_Teacher.pom.Teacher_Home_Page;
import com.banjara_Teacher.pom.View_Attendance_Page;

import generics.Excel;

public class Edit_Student_Attendance_Test extends BaseTest {

	
	@Test
	public void test_Edit_Student_Attendance() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{

		String entrysheet="studentry";
		String studidsheet="studentTeacherId";
		String registerdatasheet="registerData";
        log.info("Edit Student Attendance Test");
		Teacher_Home_Page thp=new Teacher_Home_Page(driver);
		Student_AddAttendance_Page sap=new Student_AddAttendance_Page(driver);
		thp.clickAttendanceLink();
		Thread.sleep(2000);
		thp.clickStudentAttendanceLink();
		Thread.sleep(2000);
		
		View_Attendance_Page vap=new View_Attendance_Page(driver);
		vap.clickViewAttendanceMenu();
		Thread.sleep(2000);
		
		String std = Excel.getCellValue(STUDENT_ENTRY_DETAILS,entrysheet, 1, 0);
    	String sec=Excel.getCellValue(STUDENT_ENTRY_DETAILS,entrysheet, 1, 1);
    	String date=Excel.getCellValue(STUDENT_ENTRY_DETAILS,entrysheet, 1, 2);
    	
    	log.info("Viewing and then editing Attendance for " +std+" "+sec+ " on "+date);
		sap.clickStdDropdown(std);
		Thread.sleep(2000);

		sap.clickSectionDropdown(sec);
		Thread.sleep(2000);

        WebElement selectDate = driver.findElement(By.id("datepicker"));
		selectDate.click();


	        String dateDayMonthSplit[] = (date.split("-"));
	        for(int i=0;i<dateDayMonthSplit.length;i++)
	        	System.out.println(dateDayMonthSplit[i]);
	    while(true)
	    {  	
	      try{
	          driver.findElement(By.xpath("//span[.='"+dateDayMonthSplit[2]+"']"));
	          driver.findElement(By.xpath("//span[contains(.,'"+dateDayMonthSplit[1]+"')]"));
	          driver.findElement(By.xpath("//a[.='"+dateDayMonthSplit[0]+"']")).click();
	          sap.clickSubmitButton();
	          break;        	 
	      }
	     catch(NoSuchElementException e)
	     {
	    	 driver.findElement(By.xpath("//span[.='Prev']")).click();
	     }
	   }
	        
	    Thread.sleep(5000);
		       
    	String attStatus=Excel.getCellValue(STUDENT_ID,studidsheet, 1, 4);
    	String stuid=Excel.getCellValue(STUDENT_ID,studidsheet, 1, 2);
    	String id=String.valueOf((int)Float.parseFloat(stuid));
    	
	    
	   
	    Edit_Attendance_Page eap=new Edit_Attendance_Page(driver);
	    eap.clickEditButton(id);
        eap.editAttRadioButton();
      
       log.info("Attendance is edited Successfully");

       }
		
	
}
