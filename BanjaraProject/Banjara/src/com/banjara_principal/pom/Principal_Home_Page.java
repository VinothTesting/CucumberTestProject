package com.banjara_principal.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Principal_Home_Page extends BasePage{

	
	@FindBy(linkText="Profile")
	public WebElement profileLink;
	
	@FindBy(xpath="//a[.=' Details ']")
	public WebElement detailsLink;
	
	@FindBy(xpath="(//a[.='Staff'])[1]")
	public WebElement staffLink;

	@FindBy(xpath="(//a[.='Details'])[1]")
	public WebElement staff_details_Link;
	
	@FindBy(xpath="(//a[.='Timetable'])[1]")
	public WebElement staff_Timetable_Link;
	 
	@FindBy(xpath="(//a[.='Attendance'])[1]")
	public WebElement staff_Attendance_Link;
	
	@FindBy(linkText="Students")
	public WebElement studentsLink;
	
	@FindBy(xpath="(//a[.='Details'])[2]")
	public WebElement student_details_Link;
	

	@FindBy(xpath="(//a[.='Timetable'])[2]")
	public WebElement student_Timetable_Link;
	 
	@FindBy(xpath="(//a[.='Attendance'])[2]")
	public WebElement student_Attendance_Link;
	
	
	@FindBy(linkText="Performance")
	public WebElement student_Performance_Link;
	
	@FindBy(linkText="Documents")
	public WebElement documentsLink;


	@FindBy(linkText="Documents")
	public WebElement documents_View_Link;
	
	@FindBy(linkText=" Notice Board ")
	public WebElement noticeboardLink;
	
	@FindBy(linkText="Announcements")
	public WebElement announcementsLink;
	
	@FindBy(linkText="Meetings")
	public WebElement meetingsLink;
	
	@FindBy(linkText="Events")
	public WebElement eventsLink;
	
	@FindBy(linkText="Activities")
	public WebElement activitiesLink;
	
	@FindBy(linkText=" Accounts ")
	public WebElement accountsLink;
	
	@FindBy(linkText="Received")
	public WebElement recievedLink;
	

	@FindBy(linkText="Fees")
	public WebElement received_Fees_Link;
	
	@FindBy(linkText="Others")
	public WebElement received_Others_Link;
	

	@FindBy(linkText="Payments")
	public WebElement paymentsLink;
	
	@FindBy(linkText="Salary")
	public WebElement payments_Salary_Link;
	

	@FindBy(linkText="Inventory")
	public WebElement payments_Inventory_Link;
	
	@FindBy(linkText=" Communications ")
	public WebElement communicationLink;
	

	@FindBy(linkText="Parents")
	public WebElement communication_Parents_Link;
	
	@FindBy(xpath="(//a[.='Staff'])[2]")
	public WebElement communication_Staff_Link;
	
	
	public Principal_Home_Page(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver,this);
	}
	
	public void clickProfileLink() 
	{
	  
		profileLink.click();
	}
	public void clickDetailsLink() 
	{
	  
		detailsLink.click();
	}
	public void clickStaffLink() 
	{
	  
		staffLink.click();
	}
	public void clickStaff_details_Link() 
	{
	  
		staff_details_Link.click();
	}
	public void clickStaff_Timetable_Link() 
	{
	  
		staff_Timetable_Link.click();
	}

	public void clickStaff_Attendance_Link() 
	{
		staff_Attendance_Link.click();
	}
	public void clickStudentsLink() 
	{
	  
		studentsLink.click();
	}
	public void clickStudent_details_Link() 
	{
	  
		student_details_Link.click();
	}
	
	public void clickStudent_Timetable_Link() 
	{
		student_Timetable_Link.click();
	}
	public void clickStudent_Attendance_Link() 
	{
		student_Attendance_Link.click();
	}
	public void clickStudent_Performance_Link() 
	{
		student_Performance_Link.click();
	}
	public void clickDocumentsLink() 
	{
		documentsLink.click();
	}
	public void clickDocuments_View_Link() 
	{
		documents_View_Link.click();
	}
	public void clickNoticeboardLink() 
	{
		noticeboardLink.click();
	}
	
	public void clickAnnouncementsLink() 
	{
		announcementsLink.click();
	}
	public void clickMeetingsLink() 
	{
		meetingsLink.click();
	}

	public void clickEventsLink() 
	{
		eventsLink.click();
	}
	
	public void clickActivitiesLink() 
	{
		activitiesLink.click();
	}
	
	public void clickAccountsLink() 
	{
		accountsLink.click();
	}	
	public void clickRecievedLink() 
	{
		recievedLink.click();
	}
	
	public void clickReceived_Fees_Link() 
	{
		received_Fees_Link.click();
	}
	public void clickReceived_Others_Link() 
	{
		received_Others_Link.click();
	}
	public void clickPaymentsLink() 
	{
		paymentsLink.click();
	}
	public void clickPayments_Salary_Link() 
	{
		payments_Salary_Link.click();
	}
	public void clickPayments_Inventory_Link() 
	{
		payments_Inventory_Link.click();
	}
	public void clickCommunicationLink() 
	{
		communicationLink.click();
	}	
	public void clickCommunication_Parents_Link() 
	{
		communication_Parents_Link.click();
	}
	public void clickCommunication_Staff_Link() 
	{
		communication_Staff_Link.click();
	}

}
