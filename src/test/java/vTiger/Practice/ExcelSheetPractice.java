package vTiger.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ExcelSheetPractice { 
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		//load file location into FileInputStream
	 FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx") ;
	 
	 //create workbook
	 Workbook wb = WorkbookFactory.create(fis);
	 
	 //Navigate to required sheet
	 Sheet sh = wb.getSheet("organizations");
	 
	 //Navigate to required row
	 Row rw = sh.getRow(1);
	 
	 //Navigate to required cell
	 Cell ce = rw.getCell(2);
	 
	 //capture the data present in the cell
	 String value = ce.getStringCellValue();
	 System.out.println(value);

}
}