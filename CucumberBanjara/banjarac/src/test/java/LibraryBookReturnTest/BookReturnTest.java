package LibraryBookReturnTest;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;
import junit.framework.Assert;

public class BookReturnTest {
	WebDriver driver=null;

	@Given("^Librarian logs in using Username as \"(.*)\" and password as \"(.*)\" and then navigate to Book Return Page$")
	public void user_navigate_to_Book_Return_page(String username,String password) throws InterruptedException
	{
	//	System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	//  driver=new ChromeDriver();
    //set property for Firefox browser
	       System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
	       driver=new FirefoxDriver();
           driver.manage().window().maximize();
	       driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	       //enter Teacher login page url
	       driver.get("http://192.168.1.201:8080/Banjara_Library_Module/#!");  
	       //enter Username
	       driver.findElement(By.name("ID")).sendKeys(username);
	       //enter password
	       driver.findElement(By.name("PASSWORD")).sendKeys(password);
	       Thread.sleep(2000);
	       //click login button
	       driver.findElement(By.xpath("//input[@value='LOG IN']")).click();
	       Thread.sleep(2000);
	       //Navigate to Book Issue page
	       driver.findElement(By.xpath("//a[.='For Student']")).click();
	       Thread.sleep(2000);
	       driver.findElement(By.xpath("//a[.='Return Book'][1]")).click();
	       Thread.sleep(2000);
	   }

	@When("^Librarian checks and enter details of a Book and student to return the book$")
	public void returnBook(DataTable table) throws InterruptedException {
		 List<List<String>> input = table.raw();
		    //Enter Student id
		 	driver.findElement(By.xpath("//input[@name='StudentId']")).sendKeys(input.get(2).get(1));
		 	Thread.sleep(2000);
		 	//click Return book Button
		 	driver.findElement(By.xpath("//input[@value='Return Book']")).click();
		 	Thread.sleep(2000);
		    WebElement selectDate = driver.findElement(By.id("start_date"));
	        
	        selectDate.click();
	        String dateDayMonthSplit[] = (input.get(3).get(1).split("-"));
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
        //click Fine Check button
        driver.findElement(By.xpath("//input[@value='Fine Check']")).click();
        Thread.sleep(2000);
       //Enter fine amount
        driver.findElement(By.name("fine")).sendKeys(input.get(4).get(1));
        Thread.sleep(2000);
        //click Paid button
        driver.findElement(By.xpath("//button[.='PAID']")).click();
        Thread.sleep(2000);
        //Check success message displayed
        driver.findElement(By.xpath("//h4[.='Successfully Paid']")).isDisplayed();
        Thread.sleep(5000);
	}
	@Then("^Librarian navigates to Available Books page to check whether the book Quantity is increased by 1$")
    public void verifyAvailableBooks(DataTable table) throws InterruptedException{
		
     driver.findElement(By.xpath("//i[@class='fa fa-language']")).click();
	 Thread.sleep(2000);
	 driver.findElement(By.xpath("//a[.=' Available Books ']")).click();
	 Thread.sleep(2000);
	 List<List<String>> input = table.raw();
	 int quanAfterIssue=Integer.parseInt(input.get(2).get(1))+1;
	 driver.findElement(By.xpath("//td[.='"+input.get(1).get(1)+"']/..//td[.='"+quanAfterIssue+"']")).isDisplayed();
	 Thread.sleep(5000);     
  }
	@Then("^Librarian navigates to non Available Books page to check whether the returned book is removed$")
    public void verifyNonAvailableBooks(DataTable table) throws InterruptedException{
	 List<List<String>> input = table.raw();
	 driver.findElement(By.xpath("//a[@href='NonAvailableBook.jsp']")).click();
	 Thread.sleep(2000);
	 driver.findElement(By.xpath("//input[@value='STUDENT']")).click();
	 Thread.sleep(2000);
	try{
		driver.findElement(By.xpath("//th[.='Student-ID']/../following-sibling::tr/td[1][.='11']/following-sibling::td[1][.='1']")).isDisplayed();
	}
	catch(NoSuchElementException e)
	{
	}
	 Thread.sleep(5000);
      driver.close();
	}
}
