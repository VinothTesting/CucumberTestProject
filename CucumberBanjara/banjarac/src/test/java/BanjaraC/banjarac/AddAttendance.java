package BanjaraC.banjarac;

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

public class AddAttendance {
	WebDriver driver=null;

	@Given("^Teacher logs in using Username as \"(.*)\" and password as \"(.*)\" and then navigate to Add Attendance page$")
	public void user_navigate_to_Add_Attendance_page(String username,String password) throws InterruptedException{
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
	       //Navigate to Add Student Attendance Page
	       driver.findElement(By.xpath("//a[.=' Attendance ']")).click();
	       Thread.sleep(2000);
	       driver.findElement(By.linkText("Student Attendance")).click();
	       Thread.sleep(2000);
	       driver.findElement(By.xpath("//a[@href='Add_Student_Attendance.jsp']")).click();
	       Thread.sleep(2000);
       }


	@When("^Teacher enters all Valid inputs in Add Attendance page$")
	public void enterinputs(DataTable table) throws InterruptedException {
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
	//SET DATE
				  WebElement selectDate = driver.findElement(By.id("datepicker"));
			            selectDate.click();
				        String dateDayMonthSplit[] = (input.get(3).get(1).split("-"));
				        for(int i=0;i<dateDayMonthSplit.length;i++)
				        	System.out.println(dateDayMonthSplit[i]);
				    while(true)
				    {  	
				      try{
				          driver.findElement(By.xpath("//span[.='"+dateDayMonthSplit[2]+"']"));
				          driver.findElement(By.xpath("//span[contains(.,'"+dateDayMonthSplit[1]+"')]"));
				          driver.findElement(By.xpath("//a[.='"+dateDayMonthSplit[0]+"']")).click();
				         driver.findElement(By.xpath("//input[@value='submit']")).click();
				         
				          break;        	 
				      }
				     catch(NoSuchElementException e)
				     {
				    	 System.out.println("Trying to click previous link for not matching year");
				    	 driver.findElement(By.xpath("//span[.='Prev']")).click();
				     }
				   }
				        
				    Thread.sleep(5000);
						try{
									for(int i=1;i<=3;i++)
						{
												
								 driver.findElement(By.xpath("//input[@name='id' and @value='"+input.get(4).get(i)+"']/../..//input[@value='"+input.get(5).get(i)+"']")).click();
					             Thread.sleep(3000);
							
						}
									driver.findElement(By.xpath("//button[@class='button button3']")).click();
					 
					   Thread.sleep(5000);
					  				
							driver.findElement(By.xpath("//font[.='Successfully Added Attendance ']")).isDisplayed();
						
						}
						catch(NoSuchElementException e)
						{
							driver.findElement(By.xpath("//font[.='You Already Added Attendance !!!! ']")).isDisplayed();
						}
				}
	@Then("^Attendance must be sucessfully updated in view Attendance page$")
    public void verify(DataTable table) throws InterruptedException{
	       driver.findElement(By.xpath("//a[.=' Attendance ']")).click();
	       Thread.sleep(2000);
	       driver.findElement(By.linkText("Student Attendance")).click();
	       Thread.sleep(2000);
	       driver.findElement(By.xpath("//a[@href='View_Student_Attendance.jsp']")).click();
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
		//SET DATE
					  WebElement selectDate = driver.findElement(By.id("datepicker"));
				            selectDate.click();
					        String dateDayMonthSplit[] = (input.get(3).get(1).split("-"));
					        for(int i=0;i<dateDayMonthSplit.length;i++)
					        	System.out.println(dateDayMonthSplit[i]);
					    while(true)
					    {  	
					      try
					      {
					          driver.findElement(By.xpath("//span[.='"+dateDayMonthSplit[2]+"']"));
					          driver.findElement(By.xpath("//span[contains(.,'"+dateDayMonthSplit[1]+"')]"));
					          driver.findElement(By.xpath("//a[.='"+dateDayMonthSplit[0]+"']")).click();
					          driver.findElement(By.xpath("//input[@value='submit']")).click();
					          break;        	 
					      }
					     catch(NoSuchElementException e)
					     {
					    	 System.out.println("Trying to click previous link for not matching year");
					    	 driver.findElement(By.xpath("//span[.='Prev']")).click();
					     }
					   }  
					    Thread.sleep(5000);
					    for(int i=1;i<=3;i++)
					       {
							 driver.findElement(By.xpath("//td[.='"+input.get(4).get(i)+"']/following-sibling::td[.='"+input.get(3).get(1)+"']/following-sibling::td[.='"+input.get(5).get(i)+"']")).isDisplayed(); 
					       }
					  driver.close();
				 }
            }
