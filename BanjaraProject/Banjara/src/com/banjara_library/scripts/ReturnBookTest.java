package com.banjara_library.scripts;

import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.banjara_library.pom.Book_Issue_Page;
import com.banjara_library.pom.Book_Return_Page;
import com.banjara_library.pom.Library_Home_Page;
import com.banjara_library.pom.Non_Available_Books_Page;

import generics.Excel;

public class ReturnBookTest extends BaseTest{

	
	@Test
	public void TestBookReturn() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{

		Book_Issue_Page bip=new Book_Issue_Page(driver);
		log.info("Book Return to Library By Student-Feature");
        Thread.sleep(5000);


    	Library_Home_Page lp=new Library_Home_Page(driver);
        lp.clickForStudentLink();
        Thread.sleep(3000);
        lp.clickforStudentReturnLink();
        Thread.sleep(3000);
        
    	String studentIdSheet="studentTeacherId";
        String studId=Excel.getCellValue(STUDENT_ID,studentIdSheet, 1, 2); 
        int id=(int)Float.parseFloat(studId);
        Book_Return_Page brp=new Book_Return_Page(driver);
        brp.setStudentId(String.valueOf(id));
        Thread.sleep(3000);
     
        brp.clickReturnBookLink();
        String submitdate=Excel.getCellValue(STUDENT_ID,studentIdSheet, 1, 5); 
        WebElement selectDate = driver.findElement(By.id("start_date"));
        
        selectDate.click();
        String dateDayMonthSplit[] = (submitdate.split("-"));
        int yeardif = (Calendar.getInstance().get(Calendar.YEAR))-Integer.parseInt(dateDayMonthSplit[2]);
       
         while(true)
        {  	
          try{
              driver.findElement(By.xpath("//span[.='"+dateDayMonthSplit[2]+"']"));
              driver.findElement(By.xpath("//span[contains(.,'"+dateDayMonthSplit[1]+"')]"));
              driver.findElement(By.xpath("//a[.='"+dateDayMonthSplit[0]+"']")).click();
       
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
         Thread.sleep(3000);
         brp.clickFineCheckButton();
         Thread.sleep(3000);
         brp.setFineAmount();
         Thread.sleep(2000);
         brp.clickPaidButon();
         Thread.sleep(2000);
         brp.isSuccessMsgDisplayed();
		String registerdatasheet="registerData";
		String bookid=Excel.getCellValue(REGISTERDATA,registerdatasheet, 1, 0); 
		String bookQuan=Excel.getCellValue(REGISTERDATA,registerdatasheet, 1, 5);     
    	int bookID=(int)Float.parseFloat(bookid);
    	Thread.sleep(2000);
        log.info("Checking whether Non Available books page is updated after Returning book");
        Thread.sleep(5000);
   	   	lp.clickBookIssueLink();
    	Thread.sleep(2000);
    	lp.clickNonAvailableBooksLink();
    	Non_Available_Books_Page nabp=new Non_Available_Books_Page(driver);  
    	
    	Thread.sleep(2000);
    	nabp.clickStudentButton();
    	Thread.sleep(2000);
    	
    	try
    	{
    		WebElement studIdInNonAvailableBooks=driver.findElement(By.xpath("//th[.='Student-ID']/../..//td[.='"+id+"']"));
        	WebElement bookIdInNonAvailableBooks=driver.findElement(By.xpath("//th[.='Book-ID']/../..//td[.='"+bookID+"']"));
    		try{
    		Assert.assertEquals(studIdInNonAvailableBooks.isDisplayed(),true);    		
    		Assert.assertEquals(bookIdInNonAvailableBooks.isDisplayed(),true);
    		log.error("Returned Book is not removed from Non-Available books page");
    		}
    		catch(AssertionError e)
    		{
    			log.error("Returned Book is not removed from Non-Available books page");
    		}
       	}
    	
        catch(NoSuchElementException e)
    	{
        	log.info("Returned Book is removed from Non-Available book Details page");
    	}

    	//Library_Home_Page lp1=new Library_Home_Page(driver);
    	lp.clickBookIssueLink();
    	Thread.sleep(2000);
    	lp.clickAvailableBooksLink();
    	Thread.sleep(2000);
    	int numofbooks=(int)Float.parseFloat(bookQuan);
    	WebElement bookQuanAfterReturn=driver.findElement(By.xpath("//td[.='"+bookID+"']/..//td[.='"+(numofbooks)+"']"));
    	String bookQuanAfterReturnText=bookQuanAfterReturn.getText();
    	
    	try{
    	Assert.assertEquals(bookQuanAfterReturnText.equals(String.valueOf(numofbooks)),true);
    	log.info("Book quantity successfully updated in Available books page after book Return");
    	Thread.sleep(5000);
    	log.info("Book Return Test Succesful");
    	}
    	catch(AssertionError e)
    	{
        	log.error("Book quantity not updated correctly in Available book page after Returning book");
        	log.error("Book Return Test is not successfull");
    	}
    
		Thread.sleep(5000);
    	
    	
		
	}
}
