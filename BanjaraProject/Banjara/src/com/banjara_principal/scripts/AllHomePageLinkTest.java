package com.banjara_principal.scripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import com.banjara_principal.pom.LoginPage;
import com.banjara_principal.pom.Principal_Home_Page;

import generics.Excel;

public class AllHomePageLinkTest extends BaseTest{
	
	
	@Test
	public void testClickAllLinks() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		String sheet="verifyValidLogin";
		int rc=Excel.getRowCount(PATH, sheet);
		
	      for(int i=1;i<=rc;i++)	
	      {
		String un=Excel.getCellValue(PATH,sheet, i, 2); 
		int username=(int)Float.parseFloat(un);
    	String pwd=Excel.getCellValue(PATH,sheet, i, 3);
    	//String homePageTitle=Excel.getCellValue(PATH,sheet, 1, 2);
    	//String loginPageTitle=Excel.getCellValue(PATH,sheet, 1, 3);
      	//Enter Valid UserName
		LoginPage l=new LoginPage(driver);
		l.setUsername(un);
	//Enter Password
		l.setPassword(pwd);
		
		Thread.sleep(12000);
	//Click on Login Button
		l.clickLoginButton();
		Thread.sleep(3000);
		
	
	
		Principal_Home_Page lp=new Principal_Home_Page(driver);
	
		lp.clickProfileLink();
		Thread.sleep(3000);
	//	lp.clickProfileLink();
	//	Thread.sleep(3000);
		lp.clickDetailsLink();
		Thread.sleep(3000);
		lp.clickStaffLink();
		Thread.sleep(3000);
		lp.clickStaff_details_Link();
		Thread.sleep(3000);
		
		lp.clickStaff_Timetable_Link();
		Thread.sleep(3000);
		lp.clickStaff_Attendance_Link();
		Thread.sleep(3000);
		lp.clickStudentsLink();
		Thread.sleep(3000);
		lp.clickStudent_details_Link();
		Thread.sleep(3000);
		lp.clickStudent_Timetable_Link();
		Thread.sleep(3000);
		lp.clickStudent_Attendance_Link();
		Thread.sleep(3000);
		lp.clickStudent_Performance_Link();
		Thread.sleep(3000);
		lp.clickDocumentsLink();
		Thread.sleep(3000);
		lp.clickDocuments_View_Link();
	//	Thread.sleep(3000);
		lp.clickNoticeboardLink();
		Thread.sleep(3000);
		lp.clickAnnouncementsLink();
		Thread.sleep(3000);
		lp.clickMeetingsLink();
		Thread.sleep(3000);
		lp.clickEventsLink();
		Thread.sleep(3000);
		lp.clickActivitiesLink();
		Thread.sleep(3000);
		lp.clickAccountsLink();
		Thread.sleep(3000);
		lp.clickRecievedLink();
		Thread.sleep(3000);
		lp.clickReceived_Fees_Link();
		Thread.sleep(3000);
		lp.clickReceived_Others_Link();
		Thread.sleep(3000);
		lp.clickPaymentsLink();
		Thread.sleep(3000);
		lp.clickPayments_Salary_Link();
		Thread.sleep(3000);
		lp.clickPayments_Inventory_Link();
		Thread.sleep(3000);
		lp.clickCommunicationLink();
		Thread.sleep(3000);
		lp.clickCommunication_Parents_Link();
		Thread.sleep(3000);
		lp.clickCommunication_Staff_Link();
		Thread.sleep(10000);
		 
		 
	  
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