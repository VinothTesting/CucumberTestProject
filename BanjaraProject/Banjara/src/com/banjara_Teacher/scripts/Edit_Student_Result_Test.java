package com.banjara_Teacher.scripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.banjara_Teacher.pom.Teacher_Home_Page;
import com.banjara_Teacher.pom.View_Student_Result_Page;

import generics.Excel;

public class Edit_Student_Result_Test extends BaseTest{

	

	@Test
	public void test_Add_Student_Result() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
	log.info("Editing Student result Test");
	Teacher_Home_Page thp=new Teacher_Home_Page(driver);
	thp.clickStudentResultLink();
	Thread.sleep(3000);
	thp.clickViewResultLink();
	Thread.sleep(3000);
	View_Student_Result_Page vsr=new View_Student_Result_Page(driver);

	String resultsheet="studResult"; 
	
	int no= (int)Float.parseFloat(Excel.getCellValue(STUDENT_RESULT,resultsheet, 1, 2));
	

	String std = Excel.getCellValue(STUDENT_RESULT,resultsheet, 1, 0);
   	String sec=Excel.getCellValue(STUDENT_RESULT,resultsheet, 1, 1);
	String sub = Excel.getCellValue(STUDENT_RESULT,resultsheet, 1, 3);
	String exam=Excel.getCellValue(STUDENT_RESULT,resultsheet, 1, 4);
	
	System.out.println(std+" "+sec+" "+sub+" "+exam+" "+no);

	vsr.clickStdDropdown(std);
	Thread.sleep(3000);
	vsr.clickSectionDropdown(sec);
	Thread.sleep(3000);
	vsr.clickSubDropdown(sub);
	Thread.sleep(3000);
	vsr.clickExamNameDropdown(exam);
	Thread.sleep(3000);
	vsr.clickSubmitButton();
	Thread.sleep(3000);
	

	  for(int i=1;i<=2;i++)
      {
	   try
	   {
			String id=Excel.getCellValue(STUDENT_RESULT,resultsheet, i, 5);
		    String marks=Excel.getCellValue(STUDENT_RESULT,resultsheet, i, 6);
		    String studid=String.valueOf((int)Float.parseFloat(id));
		    String mark=String.valueOf((int)Float.parseFloat(marks));
		    log.info("Editing marks of students");
		    vsr.clickEditButton(studid);
		    System.out.println(studid+" "+mark);
	        vsr.editStudentResult();
	        vsr.clickUpdateButton();
	        log.info(" Result is Edited successfully ");
	        break;
	      
      }
	   catch(AssertionError e)
	   {
		   log.error(" Result is not edited successfully");
	   }
	  Thread.sleep(5000);
}
}
}
