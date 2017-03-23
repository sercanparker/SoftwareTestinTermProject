package tab;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import common.Action;
import common.Condition;
import common.DecisionTable;
import common.ETabType;
import common.Rule;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class DecisionTableColumnTab extends ColumnTab<DecisionTable>{

	public DecisionTableColumnTab(ExcelFile hostExcelFile){

		this.eTabType = ETabType.ETabType_Decision_Table;
		this.columns = new ArrayList<DecisionTable>();
		this.hostExcelFile = hostExcelFile;

		if(read()){
			System.out.println("Decision Table Ready !");
		}

	}


	@Override
	public Boolean write() {
		// TODO Auto-generated method stub

		throw new NotImplementedException();
	}

	/**
	 * Read from excel file and
	 * prepare list of Actions here.
	 * */
	@Override
	public Boolean read() {// TODO Auto-generated method stub
		List<Tab> tabs = hostExcelFile.getTabs();
		List<Action<String>> actionList = new ArrayList<Action<String>>();
		List<Condition> conditionList = new ArrayList<Condition>();
		for (Tab tab : tabs) {
			if(tab.eTabType == ETabType.ETabType_Actions){
				//get actions list..
				
				ActionRowTab _tab = (ActionRowTab) tab;
				//Collections.copy(actionList,_tab.getRows());
				actionList = _tab.getRows();
			}
			if(tab.eTabType == ETabType.ETabType_Conditions){
				//get conditions list..
				ConditionRowTab _tab = (ConditionRowTab) tab; 
				//Collections.copy(conditionList, _tab.getRows());
				conditionList = _tab.getRows();
			}
		}
		Workbook workBook;
		try {

			File file = new File(hostExcelFile.getPath());
			workBook = WorkbookFactory.create(file);

			int numberOfSheets = workBook.getNumberOfSheets();
			Iterator<Row> iterator;
			Row row;
			String rowIdentifier;

			for (int i = 0 ; i < numberOfSheets; i++){
				//when we analyze excel file, we recognize that every 0 row , 0 cell is Identifier
				//of sheets for every sheets=tabs
				sheet = workBook.getSheetAt(i);
				String sheetIdentifier = sheet.getRow(0).getCell(0).toString();

				iterator = sheet.rowIterator();

				if (sheetIdentifier.equals(ETabType.ETabType_Decision_Table.toString()))
				{
					//implement,prepare decision table tab
					List<Rule> rules = new ArrayList<Rule>();


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
					//create Decision table
					this.columns.add(new DecisionTable(rules));
					break;

				}
			}

			workBook.close();
			return true;
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

}
