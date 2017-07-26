package com.banjara_principal.scripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import generics.Excel;

public class Rough implements AutomationConst {
public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {
	
int a=0;
try{
	a=a+2;
}
catch(Exception e)
{
	
}
System.out.println(a+5);

}
}