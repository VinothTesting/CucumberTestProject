package com.banjara_library.scripts;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.banjara_library.pom.HardCopyNewBookRegistration_TotalBookDetails_Page;
import com.banjara_library.pom.Library_Home_Page;
import com.banjara_library.pom.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;

import generics.Excel;

public class RegisterBookTest extends BaseTest
{
	ExtentReports logger=ExtentReports.get(RegisterBookTest.class);
	public static Logger log = Logger.getLogger("registerBookTest");


	@Test
	public void testRegisterBook() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
		
		String loginsheet="verifyValidLogin";
		String registerdatasheet="registerData";
	
		int registerdatarc=Excel.getRowCount(REGISTERDATA,registerdatasheet);

      for(int i=1;i<=1;i++)	
      {
    	 
  		
    	//String un=Excel.getCellValue(PATH,loginsheet, i, 0); 
     	

    	String bookid=Excel.getCellValue(REGISTERDATA,registerdatasheet, i, 0); 
    	System.out.println("got book id:"+bookid);
    	float bookID=Float.parseFloat(bookid);
    	System.out.println("converted to float:"+bookID);
    	int id=(int)bookID;
    	System.out.println("converted to int:"+id);
    	
    	String bookname = Excel.getCellValue(REGISTERDATA,registerdatasheet, i, 1);
    	String authorname=Excel.getCellValue(REGISTERDATA,registerdatasheet, i, 2); 
    	String publishername=Excel.getCellValue(REGISTERDATA,registerdatasheet, i, 3);
    	String bookquantity=Excel.getCellValue(REGISTERDATA,registerdatasheet, i, 5);
    	float bookquan=Float.parseFloat(bookquantity);
    	System.out.println("converted to float:"+bookquan);
    	int numofbooks=(int)bookquan;
    	System.out.println("converted to int:"+id);
    	
 
		
	//Take snapshot 
		//ScreenShot.takeScreenShot();
	//Verify the Title
		//l.verifyHomePageTitle();
		Library_Home_Page lhp=new Library_Home_Page(driver);
		log.info("New Book Registration Test");
		 lhp.clickHardCopyLink();
	     Thread.sleep(5000);
	      
	     log.info("clicking new book register link to register books");
	     lhp.clickNewBookRegLink();
	     Thread.sleep(5000);
	     log.info("Filling new book register form fields and submitting");
	     
        HardCopyNewBookRegistration_TotalBookDetails_Page nrp=new HardCopyNewBookRegistration_TotalBookDetails_Page(driver);
       //passing int
        System.out.println(bookID);
        nrp.setBookId(id);
        Thread.sleep(5000);
        nrp.setBookName(bookname);
        Thread.sleep(5000);
        nrp.setAuthorName(authorname);
        Thread.sleep(5000);
        nrp.setPublisher(publishername);
        Thread.sleep(5000);

        nrp.setBookQuantity(numofbooks);
        Thread.sleep(5000);
        nrp.clickRegisterButton();
        Thread.sleep(5000);
        
        nrp.isSuccessMsgDisplayed();
  //To check whether it is updated in Total book details page      
    	log.info("checking whether book is updated in Total books page");
        lhp.clickHardCopyLink();
        Thread.sleep(5000);
        lhp.clickTotalBookPageLink();
   
    Thread.sleep(5000);
      try{
       WebElement name = driver.findElement(By.xpath("//td[.='"+bookname.toUpperCase()+"']"));
       String text=name.getText();
        System.out.println(text);
        int locationOfBookName= name.getLocation().getY();
        JavascriptExecutor j=(JavascriptExecutor)driver;
        j.executeScript("window.scrollTo(0,"+locationOfBookName+")");
        log.info("It is updated in Total books page");
      
      }
      catch(Exception e)
      {
    	  log.error("failed to update in TotalBookDetails Page");
      }
      Thread.sleep(10000);

  	log.info("checking whether book is updated in available books page");
      lhp.clickBookIssueLink();
      Thread.sleep(2000);
      lhp.clickAvailableBooksLink();
      Thread.sleep(5000);
      try{
        WebElement name = driver.findElement(By.xpath("//td[.='"+bookname.toUpperCase()+"']"));
       String text=name.getText();
        
        int locationOfBookName= name.getLocation().getY();
        JavascriptExecutor j=(JavascriptExecutor)driver;
        j.executeScript("window.scrollTo(0,"+locationOfBookName+")");
        log.info("It is updated in Available books page");
        log.info("New Book Registration Sucessfull");
      
      }
      catch(Exception e)
      {
    	  log.error("failed to update in Available Books Page");
    	  log.error("New Book Registration not successfull");
      }
      Thread.sleep(5000);


}
		
	}
	}

