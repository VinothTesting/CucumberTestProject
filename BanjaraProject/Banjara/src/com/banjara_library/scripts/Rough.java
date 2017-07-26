package com.banjara_library.scripts;

import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import generics.Excel;

public class Rough implements AutomationConst {
public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {
	
	String loginsheet="verifyValidLogin";
	String registerdatasheet="registerData";
	int logindatarc=Excel.getRowCount(PATH, loginsheet);
	int registerdatarc=Excel.getRowCount(REGISTERDATA,registerdatasheet);
	
	  for(int i=1;i<=logindatarc;i++)	
      {
 
    String returndate="06-Jul-2017";
    String dateDayMonthSplit[] = (returndate.split("-"));
    for(int j=0;j<dateDayMonthSplit.length;j++)
    	System.out.println(dateDayMonthSplit[j]);
    
    int yeardif = (Calendar.getInstance().get(Calendar.YEAR))-Integer.parseInt(dateDayMonthSplit[2]);
    System.out.println("year dif:"+yeardif);
  String  monthno[]={"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
   int indexval = Arrays.asList(monthno).indexOf("Jul");
   
  System.out.println("month is :"+Calendar.getInstance().get(Calendar.MONTH));
   int monthdif = (Calendar.getInstance().get(Calendar.MONTH))-(Arrays.asList(monthno).indexOf(dateDayMonthSplit[1])+1);
    
    System.out.println("Monthindex is:"+(indexval));
    System.out.println();
 while(true)
{  	
 
	 if(yeardif>0)
     {              
         System.out.println("previous link click");
     }
	 else if(yeardif<0)
	 {              
		  System.out.println("next link click");
     } 
	 else
	 {
		 
	 }
 }
}
}
}
