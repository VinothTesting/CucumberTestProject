
package com.banjara_Teacher.scripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.banjara_Teacher.pom.Student_AddAttendance_Page;
import com.banjara_Teacher.pom.Teacher_Home_Page;

import generics.Excel;


public class Add_Student_Attendance_Test extends BaseTest{
	@Test
	public void testAddStudentAttendance() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
		
		String entrysheet="studentry";
		String studidsheet="studentTeacherId";
		String registerdatasheet="registerData";

		Teacher_Home_Page thp=new Teacher_Home_Page(driver);
		Student_AddAttendance_Page sap=new Student_AddAttendance_Page(driver);
		log.info("Adding Student Attendance Test");
		thp.clickAttendanceLink();
		Thread.sleep(2000);
		thp.clickStudentAttendanceLink();
		Thread.sleep(2000);
		sap.clickAddAttendanceMenu();
		Thread.sleep(2000);
		String std = Excel.getCellValue(STUDENT_ENTRY_DETAILS,entrysheet, 1, 0);
    	String sec=Excel.getCellValue(STUDENT_ENTRY_DETAILS,entrysheet, 1, 1);
    	String date=Excel.getCellValue(STUDENT_ENTRY_DETAILS,entrysheet, 1, 2);
    	log.info("Student attendance  for " +std+" "+sec+" "+date);
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
    	 System.out.println("Trying to click previous link for not matching year");
    	 driver.findElement(By.xpath("//span[.='Prev']")).click();
     }
   }
        
    Thread.sleep(5000);
		try{
					for(int i=1;i<=2;i++)
		{
			String studid=Excel.getCellValue(STUDENT_ID,studidsheet, i, 2);
			String stid=String.valueOf((int)Float.parseFloat(studid));
			String attStatus=Excel.getCellValue(STUDENT_ID,studidsheet, i, 4);
			if(i==1)
			log.info("Entering student attendance");
	        sap.clickAttendanceRadioButton(stid,attStatus);
	        Thread.sleep(3000);
			
		}
	   sap.clickSubmitAttendanceButton();
	   Thread.sleep(5000);
	   if(sap.isSuccessMsgDisplayed())
		   log.info("Adding Attendance Successfull");
	   else
		   log.error("Adding Attendance not Successfull");
		}
		catch(NoSuchElementException e)
		{
			driver.findElement(By.xpath("//font[.='You Already Added Attendance !!!! ']")).isDisplayed();
			log.info("Sucessfully got message as already added attendance for that date");
		}
	
  
	  
}

}
