package tab;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import common.AbstractTestCase;
import common.Action;
import common.Condition;
import common.DecisionTable;
import common.ETabType;
import common.Rule;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 * Class represent AbstractTestCase Tab for Excel file.
 * @see AbstractTestCase
 * */

public class AbstractTestCaseRowTab extends RowTab<AbstractTestCase> {


	public AbstractTestCaseRowTab(ExcelFile hostExcelFile) {
		// TODO Auto-generated constructor stub
		/*this.workbook = workbook;
		super.hostExcelFile = hostExcelFile;
		super.sheet = sheet;
		 */
		super.rows = new ArrayList<AbstractTestCase>();
		super.hostExcelFile= hostExcelFile;
		read();
		if(write()){
			System.out.println("Please check excel file under Output Folder , Its Abstract Test Cases tab was updated.");
		}
	}

	/**
	 * Write each object of AbstractTestCase class on each rows in file
	 * */
	@Override
	public Boolean write() {
		try {

			//Write it onto Output folder
			//FileInputStream fileInputStream = new FileInputStream(new File(hostExcelFile.getPath()));

			String path = "Output/Homework1_template.xlsx";
			FileInputStream fileInputStream = new FileInputStream(path);
			

			XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
			XSSFSheet sheet = workbook.getSheetAt(6);


			List<AbstractTestCase> abstractTestCases = getRows();
			Row conditionValuesRow = sheet.getRow(2);
			int testCasesInitialRowIndex = 3;


			for (AbstractTestCase abstractTestCase : abstractTestCases) {
				//each row is abstract test case
				List<Condition> conditions = abstractTestCase.getListOfCondition();
				//int numberOfCondition = conditions.size();

				int startingIndexOfConditionValueCell = 1;
				for (Condition condition : conditions) {
					//starting from conditionValuesRow and put every value onto cells one by one
					Cell conditionValueCell = conditionValuesRow.getCell(startingIndexOfConditionValueCell);
					if(conditionValueCell != null) {
						//update exist value
						conditionValuesRow.getCell(startingIndexOfConditionValueCell).setCellValue(condition.getValue());
						startingIndexOfConditionValueCell =  startingIndexOfConditionValueCell + 1;
					}else {
						//create a cell
						conditionValueCell = conditionValuesRow.createCell(startingIndexOfConditionValueCell);
						conditionValueCell.setCellValue(condition.getValue());
						startingIndexOfConditionValueCell =  startingIndexOfConditionValueCell + 1;
					}

				}
				startingIndexOfConditionValueCell = 1; //refresh index.
				Row abstractTestCaseRow = sheet.getRow(testCasesInitialRowIndex);
				if(abstractTestCaseRow == null){
					abstractTestCaseRow = sheet.createRow(testCasesInitialRowIndex);
					int indexOFACT = abstractTestCases.indexOf(abstractTestCase);
					abstractTestCaseRow.createCell(0).setCellValue("ATC"+String.valueOf(indexOFACT+1));
				}
				for (Condition condition : conditions) {
					//starting from abstractTestcaseRow and put T or F on Cells
					Cell abstractTestCaseCell = abstractTestCaseRow.getCell(startingIndexOfConditionValueCell);
					if(abstractTestCaseCell == null){
						abstractTestCaseCell = abstractTestCaseRow.createCell(startingIndexOfConditionValueCell);
					}
					//abstractTestCaseCell is not null now...
					if(condition.getIsOccurred()){
						//PUT T onto cell
						abstractTestCaseCell.setCellValue("T");
						startingIndexOfConditionValueCell = startingIndexOfConditionValueCell + 1;
					}else {
						//PUT F onto cell
						abstractTestCaseCell.setCellValue("F");
						startingIndexOfConditionValueCell = startingIndexOfConditionValueCell + 1;
					}
				}
				//end of the ACT row is action cell...
				Cell actionCell = abstractTestCaseRow.getCell(startingIndexOfConditionValueCell);
				if(actionCell == null){
					actionCell = abstractTestCaseRow.createCell(startingIndexOfConditionValueCell);
				}
				//after condition list setting on file operation
				//put action as string on cell
				Action<?> action = abstractTestCase.getAction();
				Object param = action.getParameter();
				actionCell.setCellValue(param.toString());
				testCasesInitialRowIndex = testCasesInitialRowIndex + 1;
			}
			fileInputStream.close();
			FileOutputStream out = new FileOutputStream(new File(path));
			workbook.write(out);
			workbook.close();
			out.close();
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

	/**
	 *Read from Decision Table Tab and prepare AbstractTestCase object */

	@Override
	public Boolean read() {
		//TODO Auto-generated method stub
		//TODO: read rules of DecitionTable Tab and for each Rules and one Action pairs
		//TODO: find Decision Table Tab on tabs
		List<Tab> tabs = new ArrayList<Tab>();
		//Collections.copy(tabs,hostExcelFile.getTabs());
		tabs= hostExcelFile.getTabs();
		List<Rule> rules = new ArrayList<Rule>();
		for (Tab tab : tabs) {
			if(tab.eTabType == ETabType.ETabType_Decision_Table){
				DecisionTableColumnTab _tab = (DecisionTableColumnTab) tab;
				List<DecisionTable> _decisionTable = _tab.getColumns(); //we have only one Decision TABLE..
				rules = _decisionTable.get(0).getRules();
				//Collections.copy(rules,_decisionTable.get(0).getRules());
			}
		}
		for ( Rule rule : rules) {
			List<Condition> conditionList = rule.getConditions();
			List<Action<String>> actionList = rule.getActions();
			int numberOfActions = actionList.size();

			if(numberOfActions > 1){
				//If there exist more than one action, for each action-conditionList pair create an
				for (Action<String> action : actionList) {
					//AbstractTestCase object.
					//create an abstract test case object...
					AbstractTestCase abstractTestCase = new AbstractTestCase(conditionList,action);
					this.rows.add(abstractTestCase);

				}

			}else if(numberOfActions == 1){
				//AbstractTestCase object.
				//create an abstract test case object...
				AbstractTestCase abstractTestCase = new AbstractTestCase(conditionList,actionList.get(0));
				this.rows.add(abstractTestCase);

			}else {
				//do nothing because numberOfActions 0 or negative..
			}
		}
		return true;

	}
}
