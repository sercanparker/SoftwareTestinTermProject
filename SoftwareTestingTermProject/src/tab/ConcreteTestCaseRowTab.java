package tab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import common.AbstractTestCase;
import common.ConcreateTestCase;
import common.Condition;
import common.DecisionTable;
import common.ETabType;
import common.EquivalenceClass;
import common.InputVariable;
import common.OutputVariable;

public class ConcreteTestCaseRowTab extends RowTab<ConcreateTestCase> {

	private List<AbstractTestCase> abstractTestCases;

	public ConcreteTestCaseRowTab(ExcelFile excelFile) {
		// TODO Auto-generated constructor stub
		this.abstractTestCases = new ArrayList<AbstractTestCase>();
		super.eTabType = ETabType.ETabType_Concrete_Test_Cases;
		super.rows = new ArrayList<ConcreateTestCase>();
		super.hostExcelFile = excelFile;

		read();
		if(write()){
			System.out.println("Please check excel file under Output Folder , Its Abstract Test Cases tab was updated.");
		}
	}

	@Override
	public Boolean write() {
	
		try {
			String path = "Output/Homework1_template.xlsx";
			FileInputStream fileInputStream = new FileInputStream(path);
			
			XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
			XSSFSheet sheet = workbook.getSheetAt(7);
			Row conditionValuesRow = sheet.getRow(2);
			int testCasesInitialRowIndex = 3;
			
			for (AbstractTestCase abstractTestCase : abstractTestCases) {
				if(abstractTestCase.isSAT()){ // we write just satisfiable conditions
					ConcreateTestCase concreteTestCase= new ConcreateTestCase();
					//EquivalenceClass eq = new EquivalenceClass(minValue, maxValue);
					//our output range is something like that
					// the triangle is equiliteral,isosceles,scalene,not a triangle
					List<InputVariable <Integer>> inputVariables = new ArrayList<>();
					List<OutputVariable<String>> expectedOutput = new ArrayList<>();
					List<OutputVariable<String>> observedOutput = new ArrayList<>();
					String testResult= null;
					
					//variables are filled here
					
                    concreteTestCase.setInputs(inputVariables);
                    concreteTestCase.setExpectedOutput(expectedOutput);
                    concreteTestCase.setObservedOutput(observedOutput);
                    concreteTestCase.setTestResult(testResult);
		            
                    // writing Excel File as outputs
					
					
				}
			}
			return true;
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
			return false;
		}

	}

	/*
	 * Read from AbstractTestCase tab and determine that Which abstract test
	 * cases are SAT or not, to determine SAT or not we are going to trust user
	 * input for now we could not implement SAT4J on project.
	 */
	@Override
	public Boolean read() {
		// TODO Auto-generated method stub
		List<Tab> tabs = new ArrayList<Tab>();
		// List<AbstractTestCase> abstractTestCases = new
		// ArrayList<AbstractTestCase>();
		tabs = hostExcelFile.getTabs();
		for (Tab tab : tabs) {
			if (tab.eTabType == ETabType.ETabType_Abstract_Test_Cases) {
				AbstractTestCaseRowTab _tab = (AbstractTestCaseRowTab) tab;
				this.abstractTestCases = _tab.getRows();

			}
		}
		for (AbstractTestCase abstractTestCase : this.abstractTestCases) {
			System.out.println(abstractTestCase.toString());
			// ask user on console that Is given Abstract Test Case is SAT or
			// Not.

			while (true) {
				System.out.println("Given Condition set is Satisfiable or not ,please enter Y or N");
				Scanner scan = new Scanner(System.in);
				String enteredMessage = scan.nextLine();
				if (!enteredMessage.equals("") || enteredMessage != null) {
					if (enteredMessage.equalsIgnoreCase("Y") || enteredMessage.equalsIgnoreCase("y")) {
						// make abstract test case as SAT
						abstractTestCase.setSAT(true);
						break;

					} else if (enteredMessage.equalsIgnoreCase("N") || enteredMessage.equalsIgnoreCase("n")) {
						// make abstract test as not SAT
						abstractTestCase.setSAT(false);
						break;
					}
				}
			}

		}
		return null;
	}
}
