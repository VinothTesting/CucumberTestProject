package com.banjara_library.scripts;

import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.banjara_library.pom.Available_Books_Page;
import com.banjara_library.pom.Book_Issue_Page;
import com.banjara_library.pom.HardCopyNewBookRegistration_TotalBookDetails_Page;
import com.banjara_library.pom.Library_Home_Page;
import com.banjara_library.pom.LoginPage;
import com.banjara_library.pom.Non_Available_Books_Page;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import generics.Excel;

public class BookIssueTest extends BaseTest implements AutomationConst{

	

	public static Logger log = Logger.getLogger("BookIssueTest");
	ExtentReports logger=ExtentReports.get(BookIssueTest.class);
	@Test
	public void TestBookIssue() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{

		Book_Issue_Page bip=new Book_Issue_Page(driver);
		log.info("Book issue to Student-Feature");
		logger.log(LogStatus.PASS,"Book issue to Student-Feature");
        Thread.sleep(5000);


    	Library_Home_Page lp=new Library_Home_Page(driver);
        lp.clickForStudentLink();
        Thread.sleep(3000);
        lp.clickForStudentRegBookingLink();
        
        
		String studentIdSheet="studentTeacherId";
		String registerdatasheet="registerData";
		String bookid=Excel.getCellValue(REGISTERDATA,registerdatasheet, 1, 0); 
		String bookQuan=Excel.getCellValue(REGISTERDATA,registerdatasheet, 1, 5); 
		String studId=Excel.getCellValue(STUDENT_ID,studentIdSheet, 1, 2); 
		String returndate=Excel.getCellValue(STUDENT_ID,studentIdSheet, 1, 4); 
        System.out.println(returndate);
       
        log.info("Searching Book using Book-id");
        logger.log(LogStatus.PASS,"Searching Book using Book-id");
    	int bookID=(int)Float.parseFloat(bookid);
        bip.setBookId(String.valueOf(bookID));
    	Thread.sleep(2000);
    	bip.clickSearchButton();
    	Thread.sleep(2000);
    	bip.clickRegisterHereLink();
    	Thread.sleep(2000);
        log.info("Entering student Id to issue the Book to student");
        logger.log(LogStatus.PASS,"Entering student Id to issue the Book to student");
        int id=(int)Float.parseFloat(studId);
        bip.setStudentId(String.valueOf(id));
      	Thread.sleep(2000);
      	bip.clickRegisterLink();
      	Thread.sleep(2000);
 
      	WebElement selectDate = driver.findElement(By.id("start_date"));
        
        selectDate.click();
        

            String dateDayMonthSplit[] = (returndate.split("-"));
            for(int i=0;i<dateDayMonthSplit.length;i++)
            	System.out.println(dateDayMonthSplit[i]);
            int yeardif = (Calendar.getInstance().get(Calendar.YEAR))-Integer.parseInt(dateDayMonthSplit[2]);
       
         while(true)
        {  	
          try{
              driver.findElement(By.xpath("//span[.='"+dateDayMonthSplit[2]+"']"));
              driver.findElement(By.xpath("//span[contains(.,'"+dateDayMonthSplit[1]+"')]"));
              driver.findElement(By.xpath("//a[.='"+dateDayMonthSplit[0]+"']")).click();
            bip.clickIssueRegisterButton();
              break;        	 
          }
         catch(NoSuchElementException e)
         {
        	
        	 if(yeardif>0)
             {              
                 driver.findElement(By.xpath("//span[.='Prev']")).click();
             }
        	 else if(yeardif<0)
        	 {              
            	 driver.findElement(By.xpath("//span[.='Next']")).click();
             } 
        	 else
        	 {
                
        		 String  monthno[]={"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};      		   
        		 int monthdif = (Calendar.getInstance().get(Calendar.MONTH))-(Arrays.asList(monthno).indexOf(dateDayMonthSplit[1]));
        	
        		 if(monthdif>0)
        		 {
        			 driver.findElement(By.xpath("//span[.='Prev']")).click();
        		 }
        		 else
        		 {
        			 driver.findElement(By.xpath("//span[.='Next']")).click();
        			
        		 }
        	 }
         }
        }
       
        Thread.sleep(5000);

    	boolean msg=bip.returnSuccessMessage();
      	Thread.sleep(2000);
    	try{
    	Assert.assertEquals(msg, true);
    	log.info("Book issue successful");
    	logger.log(LogStatus.PASS,"Book issue successful");
    	log.info("Checking whether the issued book is updated in Non available books");
    	logger.log(LogStatus.PASS,"Checking whether the issued book is updated in Non available books");
    	lp.clickBookIssueLink();
    	Thread.sleep(2000);
    	lp.clickNonAvailableBooksLink();
    	Non_Available_Books_Page nabp=new Non_Available_Books_Page(driver);  
    	
    	Thread.sleep(2000);
    	nabp.clickStudentButton();
    	Thread.sleep(2000);
    	WebElement studIdInNonAvailableBooks=driver.findElement(By.xpath("//th[.='Student-ID']/../..//td[.='"+id+"']"));
    	WebElement bookIdInNonAvailableBooks=driver.findElement(By.xpath("//th[.='Book-ID']/../..//td[.='"+bookID+"']"));
    	try
    	{
    		Assert.assertEquals(studIdInNonAvailableBooks.isDisplayed(),true);
    		Assert.assertEquals(bookIdInNonAvailableBooks.isDisplayed(),true);
    		log.info("Issued Book Details is  updated in Non-Available books Detailspage");
    		logger.log(LogStatus.PASS,"Issued Book Details is  updated in Non-Available books Detailspage");
    	}
    	
        catch(AssertionError e)
    	{
    	log.error("Issued Book Details is not updated in Non-Available books Detailspage");
    	logger.log(LogStatus.FAIL,"Issued Book Details is not updated in Non-Available books Detailspage");
    	}

    	//Library_Home_Page lp1=new Library_Home_Page(driver);
    	lp.clickBookIssueLink();
    	Thread.sleep(2000);
    	lp.clickAvailableBooksLink();
    	Thread.sleep(2000);
    	int numofbooks=(int)Float.parseFloat(bookQuan);
    	
    	WebElement bookQuanAfterIssue=driver.findElement(By.xpath("//td[.='"+bookID+"']/..//td[.='"+(numofbooks-1)+"']"));
    	String bookQuanAfterIssueText=bookQuanAfterIssue.getText();
    	
    	try{
    	Assert.assertEquals(bookQuanAfterIssueText.equals(String.valueOf(numofbooks-1)),true);
    	log.info("Book quantity successfully updated in Available books page after book issue");
    	logger.log(LogStatus.PASS,"Book quantity successfully updated in Available books page after book issue");
    	Thread.sleep(5000);
    	log.info("Book Issue Test Succesful");
    	}
    	catch(Exception e)
    	{
        	log.error("Book quantity not updated correctly in Available book page after book issue");
        	logger.log(LogStatus.FAIL,"Book quantity not updated correctly in Available book page after book issue");
        	log.error("Book Issue Test Unsuccessfull");
        	logger.log(LogStatus.FAIL,"Book Issue Test Unsuccessfull");
    	} 
		Thread.sleep(5000);
  	}
    	catch(AssertionError e)
    	{
        	log.error("Book issue is not successful");
        	logger.log(LogStatus.FAIL,"Book issue is not successful");
    	}
    	
		
	}
	
}
