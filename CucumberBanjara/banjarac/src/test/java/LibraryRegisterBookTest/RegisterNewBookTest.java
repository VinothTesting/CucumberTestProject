package LibraryRegisterBookTest;

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

public class RegisterNewBookTest {
	WebDriver driver=null;

	@Given("^Librarian logs in using Username as \"(.*)\" and password as \"(.*)\" and then navigate to New Book Registration page$")
	public void user_navigate_to_NewBook_Registration_page(String username,String password) throws InterruptedException{
	//	System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	//  driver=new ChromeDriver();
    //set property for firefox browser
	       System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
	       driver=new FirefoxDriver();
           driver.manage().window().maximize();
	       driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	       //enter Teacher login page url
	       driver.get("http://192.168.1.201:8080/Banjara_Library_Module/#!");  
	       //enter username
	       driver.findElement(By.name("ID")).sendKeys(username);
	       //enter password
	       driver.findElement(By.name("PASSWORD")).sendKeys(password);
	       Thread.sleep(2000);
	       //click login button
	       driver.findElement(By.xpath("//input[@value='LOG IN']")).click();
	       Thread.sleep(2000);
	       //Navigate to New Book Registration page
	       driver.findElement(By.xpath("//i[@class='fa fa-book']")).click();
	       Thread.sleep(2000);
	       driver.findElement(By.linkText("New Book Registration")).click();
	       Thread.sleep(2000);
	      
       }

	@When("^Librarian enters all details of a New Book in New Book Registration page to register it$")
	public void registerBook(DataTable table) throws InterruptedException {
		 List<List<String>> input = table.raw();
		//Enter Book id
		 	driver.findElement(By.name("bookid")).sendKeys(input.get(1).get(1));
		 	Thread.sleep(2000);
		 	//Enter Book Name
		 	driver.findElement(By.name("bookname")).sendKeys(input.get(2).get(1));
		 	Thread.sleep(2000);
		 	//Enter Author Name
		 	driver.findElement(By.name("bookauthor")).sendKeys(input.get(3).get(1));
		 	Thread.sleep(2000);
		 	//Enter Publisher Name
		 	driver.findElement(By.name("bookpublisher")).sendKeys(input.get(4).get(1));
		 	Thread.sleep(2000);
		 	//Enter Book Quantity
		 	driver.findElement(By.name("bookquantity")).sendKeys(input.get(5).get(1));
		 	Thread.sleep(2000);
		 	//click register button
		 	driver.findElement(By.xpath("//input[@class='button button5']")).click();;
		 	Thread.sleep(2000);
		 //Success Message Displayed?
		 	driver.findElement(By.xpath("//h4[.='Book Is Added Successfully:']")).isDisplayed();
	}
	@Then("^Librarian navigates to Total Books Page as well as Available Books page and checking whether book details is Updated$")
    public void verify(DataTable table) throws InterruptedException{
     driver.findElement(By.xpath("//i[@class='fa fa-book']")).click();
	 Thread.sleep(2000);
	 driver.findElement(By.xpath("//a[.=' Total Book Details']")).click();
	 Thread.sleep(2000);
	 List<List<String>> input = table.raw();
	 WebElement name = driver.findElement(By.xpath("//td[.='"+input.get(2).get(1).toUpperCase()+"']"));
     int locationOfBookName= name.getLocation().getY();
     JavascriptExecutor j=(JavascriptExecutor)driver;
     j.executeScript("window.scrollTo(0,"+locationOfBookName+")");
      driver.findElement(By.xpath("//th[.='Book-ID']/../following-sibling::tr/td[.='"+input.get(1).get(1)+"']/following-sibling::td[.='"+input.get(2).get(1).toUpperCase()+"']/following-sibling::td[.='"+input.get(3).get(1).toUpperCase()+"']/following-sibling::td[.='"+input.get(5).get(1)+"']")).isDisplayed();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//i[@class='fa fa-language']")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//a[.=' Available Books ']")).click();
	  Thread.sleep(2000);
	  WebElement name1 = driver.findElement(By.xpath("//td[.='"+input.get(2).get(1).toUpperCase()+"']"));
      int locationOfBookName1= name1.getLocation().getY();
      JavascriptExecutor j1=(JavascriptExecutor)driver;
      j1.executeScript("window.scrollTo(0,"+locationOfBookName1+")");
      driver.findElement(By.xpath("//th[.='Book-ID']/../following-sibling::tr/td[.='"+input.get(1).get(1).toUpperCase()+"']/following-sibling::td[.='"+input.get(2).get(1).toUpperCase()+"']/following-sibling::td[.='"+input.get(3).get(1).toUpperCase()+"']/following-sibling::td[.='"+input.get(5).get(1).toUpperCase()+"']")).isDisplayed();
	  Thread.sleep(2000);
      driver.close();
      
  }

}
