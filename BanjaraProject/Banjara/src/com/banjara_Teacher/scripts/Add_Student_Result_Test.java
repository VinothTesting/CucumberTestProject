package com.banjara_Teacher.scripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

import com.banjara_Teacher.pom.Add_Student_Result_Page;
import com.banjara_Teacher.pom.Teacher_Home_Page;

import generics.Excel;

public class Add_Student_Result_Test extends BaseTest{


	@Test
	public void test_Add_Student_Result() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		log.info("Adding Student result Test");
		Teacher_Home_Page thp=new Teacher_Home_Page(driver);
		thp.clickStudentResultLink();
		Thread.sleep(3000);
		thp.clickAddResultLink();
		Thread.sleep(3000);
		Add_Student_Result_Page asr=new Add_Student_Result_Page(driver);

		String resultsheet="studResult"; 
		
		int no= (int)Float.parseFloat(Excel.getCellValue(STUDENT_RESULT,resultsheet, 1, 2));
		
	
		String std = Excel.getCellValue(STUDENT_RESULT,resultsheet, 1, 0);
	   	String sec=Excel.getCellValue(STUDENT_RESULT,resultsheet, 1, 1);
    	String sub = Excel.getCellValue(STUDENT_RESULT,resultsheet, 1, 3);
    	String exam=Excel.getCellValue(STUDENT_RESULT,resultsheet, 1, 4);
    	
    	
    	System.out.println(std+" "+sec+" "+sub+" "+exam+" "+no);
    	log.info("Adding result for " +std+ " " +sec+ " "+sub+" Marks in "+exam);
		asr.clickStdDropdown(std);
		Thread.sleep(3000);
		asr.clickSectionDropdown(sec);
		Thread.sleep(3000);
		asr.clickSubDropdown(sub);
		Thread.sleep(3000);
		asr.clickExamNameDropdown(exam);
		Thread.sleep(3000);
		asr.clickSubmitButton();
		Thread.sleep(3000);
		try{
		for(int i=1;i<=no;i++)
		{
			String id=Excel.getCellValue(STUDENT_RESULT,resultsheet, i, 5);
		    String marks=Excel.getCellValue(STUDENT_RESULT,resultsheet, i, 6);
		    String studid=String.valueOf((int)Float.parseFloat(id));
		    String mark=String.valueOf((int)Float.parseFloat(marks));
	    	asr.enterMark(studid, mark);
	    	
	    	Thread.sleep(3000);
		
	   }

		log.info("Entering marks for every Students");
		log.info("Submitting results");
		asr.clickSubmitResultButton();
		
		Thread.sleep(3000);
	
	asr.isSuccessMsgDisplayed();
	
	Thread.sleep(5000);
		}
		catch(NoSuchElementException e)
		{
			log.info("Result is already added message is displayed successfully");
		}
		
}
}
