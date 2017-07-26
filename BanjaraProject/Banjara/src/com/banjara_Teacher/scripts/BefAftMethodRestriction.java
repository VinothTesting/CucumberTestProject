package com.banjara_Teacher.scripts;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BefAftMethodRestriction {

@BeforeMethod
	public  void open(Method method) throws InterruptedException 
	{
	if (!method.getName().equals("second"))
    {
		System.out.println("start only for first method");
   }
}
@Test
public  void first() 
{
	System.out.println("first method run after before method");
}

@Test
public  void second() throws InterruptedException 
{
	System.out.println("second method run without before method");
}

@AfterMethod
public  void close(Method method) {
if (!method.getName().equals("second"))
{
	System.out.println("end for first method only");
}
}
}