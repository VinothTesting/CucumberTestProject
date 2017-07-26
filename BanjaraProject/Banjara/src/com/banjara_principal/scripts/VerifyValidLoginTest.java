package com.banjara_principal.scripts;

import java.io.IOException;

import generics.Excel;
import generics.ScreenShot;

import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import com.banjara_library.pom.LoginPage;

public class VerifyValidLoginTest extends BaseTest{
	
	public static Logger log = Logger.getLogger("VerifyValidLoginTest");
	@Test
	public void testVerifyValidLogin() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		
		String sheet="verifyValidLogin";
		int rc=Excel.getRowCount(PATH, sheet);
		
    	String un=Excel.getCellValue(PATH,sheet, 2, 1); 
    	String pwd=Excel.getCellValue(PATH,sheet, 2, 2);
    	//String homePageTitle=Excel.getCellValue(PATH,sheet, 1, 2);
    	//String loginPageTitle=Excel.getCellValue(PATH,sheet, 1, 3);
      	//Enter Valid UserName
		LoginPage l=new LoginPage(driver);
		log.info("Entering valid username and password");
		l.setUsername(un);
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
		l.clickLogoutLink();
	//Verify the Title
		l.verifyLoginPageTitle();
		log.info("User logged out");
		
	
	

}
}