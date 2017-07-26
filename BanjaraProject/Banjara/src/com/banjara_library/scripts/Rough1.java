package com.banjara_library.scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Rough1 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver",
				"./driver/geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.get("http://192.168.1.201:8080/Banjara_Library_Module");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		WebElement unTB=driver.findElement(By.name("ID"));
		WebElement pwTB=driver.findElement(By.name("PASSWORD"));
		WebElement loginButton= driver.findElement(By.xpath("//input[@value='LOG IN']"));
		unTB.sendKeys("1");
		Thread.sleep(2000);
		pwTB.sendKeys("22");
		Thread.sleep(2000);
		driver.navigate().refresh();
		
		loginButton.click();
		Thread.sleep(4000);
		driver.close();
		
		
	}
}
