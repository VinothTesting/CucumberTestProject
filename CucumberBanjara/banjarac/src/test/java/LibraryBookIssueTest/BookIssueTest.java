package LibraryBookIssueTest;

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

public class BookIssueTest {
	WebDriver driver=null;

	@Given("^Librarian logs in using Username as \"(.*)\" and password as \"(.*)\" and then navigate to Book Issue Page$")
	public void user_navigate_to_Book_Issue_page(String username,String password) throws InterruptedException
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
	       driver.findElement(By.xpath("//a[.='Registration For Booking'][1]")).click();
	       Thread.sleep(2000);
	   }

	@When("^Librarian checks and enter details of a Book and student to issue the book$")
	public void issueBook(DataTable table) throws InterruptedException {
		 List<List<String>> input = table.raw();
		    //Enter Book id
		 	driver.findElement(By.xpath("//input[@name='BookId']")).sendKeys(input.get(1).get(1));
		 	Thread.sleep(2000);
		 	//click search button
		 	driver.findElement(By.className("myButton")).click();;
		 	Thread.sleep(2000);
		 	//Enter Register here link
		 	driver.findElement(By.linkText("Register Here")).click();
		 	Thread.sleep(2000);
		 	//Enter student id
		 	driver.findElement(By.xpath("//input[@name='name']")).sendKeys(input.get(2).get(1));
		 	Thread.sleep(2000);
		 	//click Register Here Button
		 	driver.findElement(By.linkText("Register Here")).click();
		 	Thread.sleep(2000);
		 	//Select Return Date
		 	WebElement returnDateField = driver.findElement(By.name("Rdate"));
		 	returnDateField.click();
	        String dateDayMonthSplit[] = (input.get(3).get(1).split("-"));
	        for(int i=0;i<dateDayMonthSplit.length;i++)
	        	System.out.println(dateDayMonthSplit[i]);
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
	    	 System.out.println("Trying to click previous link for not matching year");
	    	 driver.findElement(By.xpath("//span[.='Prev']")).click();
	     }
	   }
	        
        //click Register Book link
        driver.findElement(By.xpath("//button[.='Register Book']")).click();
    	driver.findElement(By.xpath("//h3[contains(.,'Booking Successfull')]")).isDisplayed();
	  
		 
	}
	@Then("^Librarian navigates to Available Books page to check whether the book Quantity is reduced by 1$")
    public void verifyAvailableBooks(DataTable table) throws InterruptedException{
		
     driver.findElement(By.xpath("//i[@class='fa fa-language']")).click();
	 Thread.sleep(2000);
	 driver.findElement(By.xpath("//a[.=' Available Books ']")).click();
	 Thread.sleep(2000);
	 List<List<String>> input = table.raw();
	 int quanAfterIssue=Integer.parseInt(input.get(2).get(1))-1;
	 driver.findElement(By.xpath("//td[.='"+input.get(1).get(1)+"']/..//td[.='"+quanAfterIssue+"']")).isDisplayed();
	 Thread.sleep(5000);
	
      
  }
	@Then("^Librarian navigates to non Available Books page to check whether the issued book is added$")
    public void verifyNonAvailableBooks(DataTable table) throws InterruptedException{
		 List<List<String>> input = table.raw();
	 driver.findElement(By.xpath("//a[@href='NonAvailableBook.jsp']")).click();
	 Thread.sleep(2000);
	 driver.findElement(By.xpath("//input[@value='STUDENT']")).click();
	 Thread.sleep(2000);
	 driver.findElement(By.xpath("//th[.='Student-ID']/../..//td[.='"+input.get(2).get(1)+"']"));
	 driver.findElement(By.xpath("//th[.='Book-ID']/../..//td[.='"+input.get(1).get(1)+"']"));
	 Thread.sleep(5000);
      driver.close();
	}
	
}
