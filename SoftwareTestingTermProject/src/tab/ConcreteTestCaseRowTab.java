package tab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import common.AbstractTestCase;
import common.ConcreateTestCase;
import common.DecisionTable;
import common.ETabType;

public class ConcreteTestCaseRowTab extends RowTab<ConcreateTestCase> {
	
	
	private List<AbstractTestCase> abstractTestCases;
	
	public ConcreteTestCaseRowTab(ExcelFile excelFile) {
		// TODO Auto-generated constructor stub
		this.abstractTestCases = new ArrayList<AbstractTestCase>();
		super.eTabType = ETabType.ETabType_Concrete_Test_Cases;
		super.rows = new ArrayList<ConcreateTestCase>();
		super.hostExcelFile= excelFile;
		
		read();
	}
	
	@Override
	public Boolean write() {
		return null;
	}

	/*
	 * Read from AbstractTestCase tab and determine that
	 * Which abstract test cases are SAT or not, to determine SAT or not
	 * we are going to trust user input for now we could not implement SAT4J 
	 * on project.
	 * */
	@Override
	public Boolean read() {
		// TODO Auto-generated method stub
		List<Tab> tabs = new ArrayList<Tab>();
		//List<AbstractTestCase> abstractTestCases = new ArrayList<AbstractTestCase>();
		tabs= hostExcelFile.getTabs();
		for (Tab tab : tabs) {
			if(tab.eTabType == ETabType.ETabType_Abstract_Test_Cases){
				AbstractTestCaseRowTab _tab = (AbstractTestCaseRowTab) tab;
				this.abstractTestCases = _tab.getRows();
				
			}
		}
		for (AbstractTestCase abstractTestCase : this.abstractTestCases) {
			System.out.println(abstractTestCase.toString());
			//ask user on console that Is given Abstract Test Case is SAT or Not.
			while(true){
				System.out.println("Given Condition set is Satisfiable or not ,please enter Y or N");
				Scanner scan = new Scanner(System.in);
				String enteredMessage = scan.nextLine();
				if(enteredMessage.equalsIgnoreCase("Y")){
					//make abstract test case as SAT
					abstractTestCase.setSAT(true);
					
				}else if (enteredMessage.equalsIgnoreCase("N")){
					//make abstract test as not SAT
					abstractTestCase.setSAT(false);
				}	
			}
			
		}
		return null;
	}
}
