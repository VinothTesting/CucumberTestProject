package com.banjara_library.scripts;

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
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import com.banjara_library.pom.Available_Books_Page;
import com.banjara_library.pom.Book_Issue_Page;
import com.banjara_library.pom.Library_Home_Page;
import com.banjara_library.pom.LoginPage;
import com.banjara_library.pom.Non_Available_Books_Page;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import generics.Excel;
@Listeners(generics.CustumListener.class)	
abstract public class BaseTest implements AutomationConst {
	public WebDriver driver=null;
	ExtentReports logger=ExtentReports.get(BaseTest.class);
	Available_Books_Page abp=new Available_Books_Page(driver);
	Non_Available_Books_Page nabp=new Non_Available_Books_Page(driver);
	public static Logger log = Logger.getLogger("BaseTest");
	@BeforeTest
	public void startMsg()
	{
		logger.init("./extentreport/report.html", true);
		 logger.startTest("Librarian Module - Issue Book Test");
		log.info("Framework started");
		logger.log(LogStatus.PASS,"Framework started");
	}
	@Parameters({ "browser" })
	@BeforeMethod
	public void login(String browser) throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		
		try {
			if (browser.equalsIgnoreCase("firefox")) 
			{
				log.info("browser is firefox-searching for geeko driver");
				logger.log(LogStatus.PASS,"browser is firefox-searching for geeko driver");
				System.setProperty("webdriver.gecko.driver",
						"./driver/geckodriver.exe");
				log.info("launching firefox browser");
				logger.log(LogStatus.PASS,"launching firefox browser");
				driver = new FirefoxDriver();
			} 
			else if (browser.equalsIgnoreCase("chrome")) 
			{
				System.setProperty("webdriver.chrome.driver",
						"./driver/chromedriver.exe");
				driver = new ChromeDriver();
			} 
		}
			catch(Exception e)
			{
				log.error("Browser/Network issues");
				logger.log(LogStatus.FAIL,"Browser/Network issues");
			} 
		try
		   {
			log.info("Entering application Url");	
			logger.log(LogStatus.PASS,"Entering application Url");	
			driver.get("http://192.168.1.201:8080/Banjara_Library_Module");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		   } 
		catch (WebDriverException e) {
			
			System.out.println(e.getMessage());
		}
		String loginsheet="verifyValidLogin";    	 
  		log.info("Librarian logging in");
  		logger.log(LogStatus.PASS,"Librarian logging in");
    	String un=Excel.getCellValue(PATH,loginsheet, 1, 1); 
     	int user=(int)Float.parseFloat(un);
    	String pwd=Excel.getCellValue(PATH,loginsheet, 1, 2);
    	int password=(int)Float.parseFloat(pwd);
	LoginPage l=new LoginPage(driver);
	//Enter username
		l.setUsername(String.valueOf(user));
	//Enter Password
		l.setPassword(String.valueOf(password));
		Thread.sleep(2000);
	//Click on Login Button
		l.clickLoginButton();
		Thread.sleep(3000);
	}
	@AfterMethod
	public void logout()
	{
		LoginPage l=new LoginPage(driver);
		l.clickLogoutLink();
	}
	
	@AfterTest
	public void close()
	{
		log.info("Framework Ended");
		logger.log(LogStatus.PASS,"Framework Ended");
		logger.endTest();
		driver.close();
	}
  
}
