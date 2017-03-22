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
		System.out.println("################");
		System.out.println("DO NOT FORGET:\n While preparing Decision Table be sure that Conditions \n and Actions lines have reference from Condition and Action tabs \n and just use T(CAPITAL) for True, F(CAPITAL) for False and X for active Action");
		System.out.println("example : =Conditions!B2 etc.");
		System.out.println("################");
		
		System.out.println("Enter Excel File Path and press enter");
		System.out.println("example : C:\\Users\\TonyParker\\Desktop\\Homework1_template.xlsx");
		System.out.println("################");
		
		Scanner scan = new Scanner(System.in);
		path = scan.nextLine();
		
		ExcelFile file = new ExcelFile(path);


		}
	
}
