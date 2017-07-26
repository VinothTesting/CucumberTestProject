package com.banjara_library.scripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import com.banjara_library.pom.Library_Home_Page;
import com.banjara_library.pom.LoginPage;

import generics.Excel;

public class AllHomePageLinkTest extends BaseTest{
	
	
	@Test
	public void testClickAllLinks() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		String sheet="verifyValidLogin";
		int rc=Excel.getRowCount(PATH, sheet);
		
	      for(int i=1;i<=rc;i++)	
	      {
		String un=Excel.getCellValue(PATH,sheet, i, 0); 
    	String pwd=Excel.getCellValue(PATH,sheet, i, 1);
    	//String homePageTitle=Excel.getCellValue(PATH,sheet, 1, 2);
    	//String loginPageTitle=Excel.getCellValue(PATH,sheet, 1, 3);
      	//Enter Valid UserName
		LoginPage l=new LoginPage(driver);
		l.setUsername(un);
	//Enter Password
		l.setPassword(pwd);
		Thread.sleep(2000);
	//Click on Login Button
		l.clickLoginButton();
		Thread.sleep(3000);
		
	
	
		Library_Home_Page lp=new Library_Home_Page(driver);
	
		lp.clickHomeLink();
		Thread.sleep(3000);
	//	lp.clickProfileLink();
	//	Thread.sleep(3000);
		lp.clickHardCopyLink();
		Thread.sleep(3000);
		lp.clickNewBookRegLink();
		Thread.sleep(3000);
		lp.clickTotalBookPageLink();
		Thread.sleep(3000);
		lp.clickStaffLink();
		Thread.sleep(3000);
		lp.clickBookIssueLink();
		Thread.sleep(3000);
		lp.clickAvailableBooksLink();
		Thread.sleep(3000);
		lp.clickNonAvailableBooksLink();
		Thread.sleep(3000);
		lp.clickForStudentLink();
		Thread.sleep(3000);
		lp.clickForStudentRegBookingLink();
		Thread.sleep(3000);
		lp.clickforStudentReturnLink();
		Thread.sleep(3000);
		lp.clickForStudentFineCollectionLink();
		Thread.sleep(3000);
		//lp.clickForTeacherLink();
	//	Thread.sleep(3000);
		lp.clickForTeacherRegBookingLink();
		Thread.sleep(3000);
		lp.clickForTeacherReturnLink();
		Thread.sleep(3000);
		lp.clickForTeacherFineCollectionLink();
		Thread.sleep(3000);
		 
	  
		//Take snapshot 
				//ScreenShot.takeScreenShot();
			//Verify the Title
			
			//Click on welcome link

			//click on logout link
				l.clickLogoutLink();
			//Verify the Title
	}
	     

}
}