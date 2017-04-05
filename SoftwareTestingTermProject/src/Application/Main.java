package Application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import common.*;

import common.ETabType;
import tab.ExcelFile;

import org.apache.poi.*;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class Main {

	public static void main(String[] args) throws IOException {

		String path ;
		System.out.println("#####################");
		System.out.println("We prepared a sample excel file to test under Input Folder");
		System.out.println("After execution , Please check excel file under Output Folder ");
		System.out.println("#####################");
		System.out.println("Please be sure that Apache Poi library was added as shown on our guidelines ");
		System.out.println("You could find guidline file source under Guidlines folder");
		System.out.println("You could find required jar files under Jar Files folder");
		System.out.println("#####################");
		System.out.println("For homework_1, report was prepared under Reports folder ");
		System.out.println("If you get trouble about Jar files or other things in project \n please contact us sercansensulun@gmail.com or emrekarakis@gmail.com");
		System.out.println("#####################");
		

		boolean isEnterPressed = false;
		while(true){
			System.out.println("Please press enter 1 to Triangle Problem .");
			Scanner scan = new Scanner(System.in);
			String enteredString = scan.nextLine();
			if(enteredString.equals("1")){
				path = "Input/Triangle_Homework2_template.xlsx";
				ExcelFile file = new ExcelFile(path,EProblemType.TRIANGLE);
				break;
			}
			else if(enteredString.equals("2")){
				
			}
		}


	}

}
