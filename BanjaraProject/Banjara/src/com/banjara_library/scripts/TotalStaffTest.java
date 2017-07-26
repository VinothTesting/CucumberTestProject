package com.banjara_library.scripts;

import org.testng.annotations.Test;

import com.banjara_library.pom.Library_Home_Page;
import com.banjara_library.pom.Staff_TotalStaff_Page;

public class TotalStaffTest extends BaseTest{

	
	
	@Test
	public void testTotalStaff() throws InterruptedException
	{
		Library_Home_Page lhp=new Library_Home_Page(driver);
		Staff_TotalStaff_Page tsp=new Staff_TotalStaff_Page(driver);
		lhp.clickStaffLink();
		Thread.sleep(3000);
		lhp.clickTotalStaffLink();
		
		
	}
}
