package com.banjara_Teacher.scripts;

import java.io.IOException;

import generics.Excel;
import generics.ScreenShot;

import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import com.banjara_Teacher.pom.LoginPage;
import com.banjara_Teacher.pom.Teacher_Home_Page;


public class VerifyValidLoginTest extends BaseTest{
	
	public static Logger log = Logger.getLogger("VerifyValidLoginTest");
	@Test
	public void testVerifyValidLogin() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		String sheet="verifyValidLogin";
		int rc=Excel.getRowCount(PATH, sheet);
		
     
    	String un=Excel.getCellValue(PATH,sheet, 3, 1); 
    	String user=String.valueOf((int)Float.parseFloat(un));
    	String pwd=Excel.getCellValue(PATH,sheet, 3, 2);
    	//String homePageTitle=Excel.getCellValue(PATH,sheet, 1, 2);
    	//String loginPageTitle=Excel.getCellValue(PATH,sheet, 1, 3);
      	//Enter Valid UserName

    	
		LoginPage l=new LoginPage(driver);
		log.info("Entering valid username and password");
		l.setUsername(user);
	//Enter Password
		l.setPassword(pwd);
		Thread.sleep(2000);
	//Click on Login Button
		l.clickLoginButton();
		Thread.sleep(3000);
		
	//Take snapshot 
		//ScreenShot.takeScreenShot();
	//Verify the Title
		l.verifyHomePageTitle();
		log.info("Login successfull");
	//Click on welcome link

	//click on logout link
		Teacher_Home_Page thp=new Teacher_Home_Page(driver);
	thp.clickProfileMenu();
	thp.clickLogoutLink();
	//Verify the Title
		l.verifyLoginPageTitle();
		log.info("User logged out");
		
	
	

}
}