package tab;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import common.Action;
import common.Condition;
import common.EActionType;
import common.ETabType;
import common.InputVariable;
import common.OutputVariable;
import common.Requirement;
import common.Rule;

/**
 * Class represents excel file specifications
 * @see	Tab 
 */
public class ExcelFile {

	/**
	 * Physical path of excel file.
	 * Users/User/Project/file.xslx etc.
	  */
	private String path;
	/**
	 * Excel file consist of List of tabs*/
	private List<Tab> tabs;
	
	private List<Requirement> requirementList;
	private List<InputVariable<Integer>> inputVariableList;
	private List<OutputVariable<String>> outputVariableList;
	private List<Condition> conditionList;
	private List<Action<String>> actionList ;
	private List<Rule> rules;
	
	private Sheet abstractTestCaseSheet;
	private Workbook workBook;
	
	public ExcelFile(String path) {
		
		this.path =  path;
		this.tabs = new ArrayList<Tab>();
		preapreObjectsFromExcelRealFile();
		//after preparing object set Tabs
		setTabs();
		
	}
	
	public List<Rule> getRules() {
		return rules;
	}
	
	

	private void setTabs() {
		// TODO Auto-generated method stub
//		DecisionTableColumnTab decisionTableTab = new DecisionTableColumnTab(this);
		AbstractTestCaseRowTab abstractTestCaseRowTab = new AbstractTestCaseRowTab(this,abstractTestCaseSheet,workBook);
	}



	private void preapreObjectsFromExcelRealFile() {
		// TODO Auto-generated method stub
		//read each tab from Requirement to AbstractTestCase tab
		Workbook workBook;
		Sheet sheet;
		
		try {
			// create workBook instance that refers to .xls file
			 File file = new File(path);
			 workBook = WorkbookFactory.create(file);
			 this.workBook = workBook;

			 
			 //travel all sheets, by the way sheet means tab for us.
			 int numberOfSheets = workBook.getNumberOfSheets();
			 Iterator<Row> iterator;
			 Row row;
			 String rowIdentifier;
			 conditionList = new ArrayList<Condition>();
			 actionList = new ArrayList<Action<String>>();
			 
			 for (int i = 0 ; i < numberOfSheets; i++){
				 
				 //when we analyze excel file, we recognize that every 0 row , 0 cell is Identifier
				 //of sheets for every sheets=tabs
				 sheet = workBook.getSheetAt(i);
				 String sheetIdentifier = sheet.getRow(0).getCell(0).toString();

				 iterator = sheet.rowIterator();
				 
				 if (sheetIdentifier.equals(ETabType.ETabType_Requirements.toString())){
					 //implement,prepare requirement tab
					 //travel all rows via iterator
					 requirementList = new ArrayList<Requirement>();
					 while(iterator.hasNext()){

						row = iterator.next();
						rowIdentifier = row.getCell(0).toString();
						
						if(rowIdentifier.equals(sheetIdentifier)){
							//it is identifier..
							//do nothing...
						}else {
							//up to now, for each row is an object of Rule class.
							//maybe user does not enter requirement spec string
							if (row.getCell(1) != null){
								String requirementDescription = row.getCell(1).toString();
								if(!requirementDescription.isEmpty()){
									//create Requirement object
									Requirement requirement = new Requirement(requirementDescription);
									requirementList.add(requirement); //store it	
								}
							}

						}
					 }

					 
				 }
				 else if (sheetIdentifier.equals(ETabType.ETabType_Input_Variables.toString()))
				 {
					//implement,prepare input variable tab
					 inputVariableList = new ArrayList<InputVariable<Integer>>();
					 while(iterator.hasNext()){
						 row = iterator.next();
						 rowIdentifier = row.getCell(0).toString();
							
						if(rowIdentifier.equals(sheetIdentifier)){
								//it is identifier..
								//do nothing...
						}else {
							//up to now, for each row is an object of Input Variable class.
							
							if (row.getCell(1) != null){
								String inputVariableName = row.getCell(1).toString();
								if(!inputVariableName.isEmpty()){
									//create Requirement object
									//for now value of input variable is not needed. hidden feature.
									InputVariable<Integer> inputVariable = new InputVariable<Integer>(inputVariableName,0);
									inputVariableList.add(inputVariable);
								}
							}
						} 
					 }
					
					 
				 }
				 else if (sheetIdentifier.equals(ETabType.ETabType_Output_Variables.toString()))
				 {
					//implement,prepare output variable tab
					outputVariableList = new ArrayList<OutputVariable<String>>();
					
					while(iterator.hasNext()){
						row = iterator.next();
						rowIdentifier = row.getCell(0).toString();
						
						if(rowIdentifier.equals(sheetIdentifier)){
							//it is identifier..
							//do nothing...
						}else {
							//up to now, for each row is an object of Output Variable class.
							
							if (row.getCell(1) != null){
								String outputVariableName = row.getCell(1).toString();
								if(!outputVariableName.isEmpty()){
									//create Requirement object
									//for now value of outpu variable is not needed.
									//It is Empty String. hidden feature.
									OutputVariable<String> outputVariable = new OutputVariable<String>(outputVariableName,"");
									outputVariableList.add(outputVariable);
								}
							}
						}
							
					}
					 
					 
				 }
				 else if (sheetIdentifier.equals(ETabType.ETabType_Conditions.toString()))
				 {
					//implement,prepare conditions tab
					//conditionList = new ArrayList<Condition>();
					while(iterator.hasNext()){
						row = iterator.next();
						rowIdentifier = row.getCell(0).toString();
						if(rowIdentifier.equals(sheetIdentifier)){
							
						}else {
							if (row.getCell(1) != null){

								//up to now, for each row is an object of Condition class.
								String conditionName = row.getCell(1).toString();
								if(!conditionName.isEmpty()){
									//for now isOcurred property is false as default.
									Condition condition = new Condition(false,conditionName);
									conditionList.add(condition);
								}
							}
						}
					}
					 
				 }
				 else if (sheetIdentifier.equals(ETabType.ETabType_Actions.toString()))
				 {
					//implement,prepare actions tab
					//List<Action<String>> actionList = new ArrayList<Action<String>>();
					 while(iterator.hasNext()){
							row = iterator.next();
							rowIdentifier = row.getCell(0).toString();
							if(rowIdentifier.equals(sheetIdentifier)){
								
							}else {
								if (row.getCell(1) != null){

									//up to now, for each row is an object of Condition class.
									String actionName = row.getCell(1).toString();
									if(!actionName.isEmpty()){
										//for now isOcurred property is false as default.
										Action<String> action = new Action<String>(EActionType.PRINT, actionName);
										actionList.add(action);
									}
								}
							}						 
					 }
					 
				 }
				 else if (sheetIdentifier.equals(ETabType.ETabType_Decision_Table.toString()))
				 {
					 //implement,prepare decision table tab
					 rules = new ArrayList<Rule>();
					 
					 
 					 //firstly, determine that how many rule decision table exist..
					 //number of row that starting from index 2 to null
					 Row startingRow = iterator.next();
					 Row secondRow = iterator.next();
					 int startingRuleIndex = 2; //rule sets starting from index 2
					 int currentRuleIndexCounter = 2;
					 int numberOfRule = 0;
					 while(secondRow.getCell(currentRuleIndexCounter)!= null){
						 numberOfRule = numberOfRule + 1;
						 currentRuleIndexCounter = currentRuleIndexCounter + 1;
						 
					 }

					 //travel numberOfRule times on decition table tab to create rule for each loop
					 for (int k = startingRuleIndex ; k < startingRuleIndex + numberOfRule; k++){
						 List<Condition> conditionsOfRule =  new ArrayList<Condition>();
						 List<Action<String>> actionsOfRule = new ArrayList<Action<String>>();
						 
						 //refresh iterator
						 iterator = sheet.rowIterator();
						 iterator.next(); //pass identifier of tab
						 while(iterator.hasNext()){
							 Row rowOnDecitionTable = iterator.next();
							 //travel # of rules times
							 Cell conditionCell = rowOnDecitionTable.getCell(1);
							 if(conditionCell != null){
								 
								 //check rowId is it Condition or Action
								 String cellIdentifierString = rowOnDecitionTable.getCell(1).toString();
								 if(cellIdentifierString.contains(ETabType.ETabType_Conditions.toString())){
									 //cell is condition
									 String conditionValue = rowOnDecitionTable.getCell(1).getStringCellValue();
									 //travel all Condition on List and define which Condition you on.
									 for (Condition condition : conditionList) {
										 if(condition.getValue().equals(conditionValue)){
											 //which condition you on found,
											 //create condition with false and empty string as default
											 Condition condationOfRule = new Condition(false, "");
											 condationOfRule.setValue(conditionValue);
											 //now determine is it True or False
											 if(rowOnDecitionTable.getCell(k)!=null){
												 //cell has value
												 String cellValue = rowOnDecitionTable.getCell(k).toString();
												 if(cellValue.equals("T")){
													 //it is True
													 condationOfRule.setIsOccurred(true);
													 conditionsOfRule.add(condationOfRule);
													 
													 
												 }else {
													 //it is False
													 condationOfRule.setIsOccurred(false);
													 conditionsOfRule.add(condationOfRule);
													 
												 }
											 }else {
												 //cell is null make it false as default condition.
												 condationOfRule.setIsOccurred(false);
												 conditionsOfRule.add(condationOfRule);
												 
											 }
										 }
									 }
								 }
								 if(cellIdentifierString.contains(ETabType.ETabType_Actions.toString())){
									//cell is action
									 String actionValue = rowOnDecitionTable.getCell(1).getStringCellValue();
									 //travel all Action List
									 for (Action<String> action : actionList) {
										 if(action.getParameter().equals(actionValue)){
											 //which action you on.
											 //check its cell has X or not
											 if(rowOnDecitionTable.getCell(k)!=null){
												 String cellValue = rowOnDecitionTable.getCell(k).toString();
												 if(cellValue.equals("X")){
													 //copy action and add it onto list of actions
													 Action<String> ruleOfAction = action;
													 actionsOfRule.add(ruleOfAction);
												 }
											 }
										 }
										 
									 }
								 }
							 }

						 }
						 //if iterator is last row set rule and refresh list of conditions and actions
						 Rule rule = new Rule(conditionsOfRule,actionsOfRule);
						 rules.add(rule);
						 
					 }
					 
				 }
				  else if (sheetIdentifier.equals(ETabType.ETabType_Abstract_Test_Cases.toString()))
				 {
					//implement,prepare abstract tab
					// System.out.println(sheetIdentifier + "was implemented");
					  this.abstractTestCaseSheet = sheet;
					  workBook.close();
					  
					 
				 }
				 /*else if (sheetIdentifier.equals(ETabType.ETabType_Abstract_Test_Cases.toString()))
				 {
					//TODO: implement,prepare input variable tab
					//System.out.println(sheetIdentifier + "was implemented");
					 
				 }
				 */
			 }

		    
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch blocks
			e.printStackTrace();
			
		}
		
	}



	public ExcelFile(String path, List<Tab> tabs) {
		this.path = path;
		this.setTabs(tabs);
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public List<Tab> getTabs() {
		return tabs;
	}

	public void setTabs(List<Tab> tabs) {
		this.tabs = tabs;
	}

}
