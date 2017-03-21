package Application;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import common.*;

import common.ETabType;

import org.apache.poi.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		Workbook workBook;
		Sheet sheet;
		
		try {
			// create workBook instance that refers to .xls file
			
			workBook = WorkbookFactory.create(new File("C:\\Users\\deltasmarttech\\Desktop\\Homework1_template.xlsx"));

			 System.out.println("number of sheets" + workBook.getNumberOfSheets());
			 
			 //travel all sheets, by the way sheet means tab for us.
			 int numberOfSheets = workBook.getNumberOfSheets();
			 for (int i = 0 ; i < numberOfSheets; i++){
				 
				 //when we analyze excel file, we recognize that every 0 row , 0 cell is Identifier
				 //of sheets for every sheets=tabs
				 sheet = workBook.getSheetAt(i);
				 String sheetIdentifier = sheet.getRow(0).getCell(0).toString();
				 System.out.println(sheetIdentifier);
				 
				 if (sheetIdentifier.equals(ETabType.ETabType_Requirements.toString())){
					 //implement,prepare requirement tab
					 
					 
				 }
				 
				 
				 
				 
			 }

		    
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
