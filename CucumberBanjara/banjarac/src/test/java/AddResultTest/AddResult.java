package AddResultTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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

public class AddResult {
	WebDriver driver=null;

	@Given("^Teacher logs in using Username as \"(.*)\" and password as \"(.*)\" and then navigate to Add Result page$")
	public void user_navigate_to_Add_Result_page(String username,String password) throws InterruptedException{
	//	System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	//  driver=new ChromeDriver();
    //set property for firefox browser
	       System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
	       driver=new FirefoxDriver();
           driver.manage().window().maximize();
	       driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	       //enter Teacher login page url
	       driver.get("http://192.168.1.201:8080/Banjara_Teacher_Module/#!");  
	       //enter username
	       driver.findElement(By.name("ID")).sendKeys(username);
	       //enter password
	       driver.findElement(By.name("PASSWORD")).sendKeys(password);
	       Thread.sleep(2000);
	       //click login button
	       driver.findElement(By.xpath("//input[@value='LOG IN']")).click();
	       Thread.sleep(2000);
	       //Navigate to Add Student Result Page
	       driver.findElement(By.xpath("//a[.=' Student Result ']")).click();
	       Thread.sleep(2000);
	       driver.findElement(By.linkText("Add Result")).click();
	       Thread.sleep(2000);
	     }
	@When("^Teacher enters marks to all students for an exam in Add Result page$")
	public void enterMarks(DataTable table) throws InterruptedException {
		 List<List<String>> input = table.raw();
		//select Standard 
		 WebElement stdDropdown = driver.findElement(By.name("STANDARD"));
			Select select=new Select(stdDropdown);
			select.getOptions();
			select.selectByVisibleText(input.get(1).get(1));
	  //select section
			 WebElement secDropdown = driver.findElement(By.name("SECTION"));
				Select select1=new Select(secDropdown);
				select1.getOptions();
				select1.selectByVisibleText(input.get(2).get(1));
	//Select Subject
				 WebElement subDropdown = driver.findElement(By.name("SUBJECT"));
					Select select2=new Select(subDropdown);
					select2.getOptions();
					Thread.sleep(2000);
					select2.selectByVisibleText(input.get(3).get(1));
				    Thread.sleep(2000);
	//Select Exam Name
		WebElement examDropdown = driver.findElement(By.name("EXAM_NAME"));
		Select select3=new Select(examDropdown);
		select3.getOptions();
		select3.selectByVisibleText(input.get(4).get(1));
		 Thread.sleep(2000);
		 
		driver.findElement(By.xpath("//input[@value='submit']")).click();
					try{				for(int i=1;i<=3;i++)
						{						
						 driver.findElement(By.xpath("//td[.='"+input.get(5).get(i)+"']/following-sibling::td/input[@name='marks']")).sendKeys(input.get(6).get(i));
					     Thread.sleep(2000);	
						}
					driver.findElement(By.xpath("//button[@class='button button3']")).click();
					Thread.sleep(2000);
					driver.findElement(By.xpath("//font[.='Successfully Inserted Result ']")).isDisplayed();
					}
					catch(NoSuchElementException e)
					{
						driver.findElement(By.xpath("//font[.='Already Added Result !!!! ']")).isDisplayed();
					}
					
					   Thread.sleep(3000);								
	}
	@Then("^Result must be successfully updated in View Result page$")
    public void verifyMarks(DataTable table) throws InterruptedException{
		  driver.findElement(By.xpath("//a[.=' Student Result ']")).click();
	       Thread.sleep(2000);
	       driver.findElement(By.linkText("View Result")).click();
	       Thread.sleep(2000);
	    
	  List<List<String>> input = table.raw();
	     //select Standard 
			 WebElement stdDropdown = driver.findElement(By.name("STANDARD"));
				Select select=new Select(stdDropdown);
				select.getOptions();
				select.selectByVisibleText(input.get(1).get(1));
		  //select section
				 WebElement secDropdown = driver.findElement(By.name("SECTION"));
					Select select1=new Select(secDropdown);
					select1.getOptions(); 
					select1.selectByVisibleText(input.get(2).get(1));
		//Select Subject
					    WebElement subDropdown = driver.findElement(By.name("SUBJECT"));
						Select select2=new Select(subDropdown);
						select2.getOptions();
						select2.selectByVisibleText(input.get(3).get(1));
					    Thread.sleep(2000);
		//Select Exam Name
		WebElement examDropdown = driver.findElement(By.name("EXAM_NAME"));
		Select select3=new Select(examDropdown);
		select3.getOptions();
		select3.selectByVisibleText(input.get(4).get(1));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value='submit']")).click();
		for(int i=1;i<=3;i++)
		{
         driver.findElement(By.xpath("//td[.='"+input.get(5).get(i)+"']/following-sibling::td[.='"+input.get(6).get(i)+"']")).isDisplayed();
        }
	    driver.close();
      }
}
