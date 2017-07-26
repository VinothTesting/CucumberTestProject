package generics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.google.common.collect.Table.Cell;

public class Excel {
	
	//method to get row count
	public static int getRowCount(String PATH,String sheet) throws EncryptedDocumentException, InvalidFormatException, IOException
	{   
		 FileInputStream fis=new FileInputStream(PATH);
		 Workbook wb = WorkbookFactory.create(fis);
	     int rc = wb.getSheet(sheet).getLastRowNum();
		return rc;
	}
	//Method to get cell value
	public static String getCellValue(String PATH,String sheet,int row,int col) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		
		FileInputStream fis=new FileInputStream(PATH);
		 Workbook wb = WorkbookFactory.create(fis);
	      String cellValue = wb.getSheet(sheet).getRow(row).getCell(col).toString();
	      return cellValue;
	
  
}
}
