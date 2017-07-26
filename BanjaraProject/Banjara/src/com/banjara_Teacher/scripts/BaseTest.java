package com.banjara_Teacher.scripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.banjara_Teacher.pom.LoginPage;

import generics.Excel;

abstract public class BaseTest implements AutomationConst {
	public WebDriver driver;

	public static Logger log = Logger.getLogger("BaseTest");
	
	
	@BeforeTest
	public void pre()
	{
		log.info("Framework started");
	}
	@Parameters({ "browser" })
	@BeforeMethod
	public void openBrowser(String browser) throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException {
		
		try {
			if (browser.equalsIgnoreCase("firefox")) 
			{
				log.info("browser is firefox-searching for geeko driver");
				System.setProperty("webdriver.gecko.driver",
						"./driver/geckodriver.exe");
				log.info("launching firefox broswer");
				driver = new FirefoxDriver();
			} else if (browser.equalsIgnoreCase("chrome")) 
			{
				System.setProperty("webdriver.chrome.driver",
						"./driver/chromedriver.exe");
				driver = new ChromeDriver();
			} 
            log.info("Entering application Url");
			driver.get("http://192.168.1.201:8080/Banjara_Teacher_Module");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		} catch (WebDriverException e) {
			
			System.out.println(e.getMessage());
		}
		String sheet="verifyValidLogin";
		int rc=Excel.getRowCount(PATH, sheet);
		
     
    	String un=Excel.getCellValue(PATH,sheet, 3, 1); 
    	String user=String.valueOf((int)Float.parseFloat(un));
    	String pwd=Excel.getCellValue(PATH,sheet, 3, 2);

    	String password=String.valueOf((int)Float.parseFloat(pwd));
    	//String homePageTitle=Excel.getCellValue(PATH,sheet, 1, 2);
    	//String loginPageTitle=Excel.getCellValue(PATH,sheet, 1, 3);
      	//Enter Valid UserName

    	
		LoginPage l=new LoginPage(driver);
		log.info("Entering valid username and password");
		l.setUsername(user);
	//Enter Password
		l.setPassword(password);
		Thread.sleep(2000);
	//Click on Login Button
		l.clickLoginButton();
		Thread.sleep(3000);
		
	//Take snapshot 
		//ScreenShot.takeScreenShot();
	//Verify the Title
		l.verifyHomePageTitle();
		log.info("Login successfull");
	
	}
	
   @AfterMethod
   public void postcondition()
	{
     driver.close();
	}
   @AfterTest
	public void post()
	{
		log.info("Framework Ended");
	}
   
}
