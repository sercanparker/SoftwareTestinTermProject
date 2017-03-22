package tab;

import java.util.ArrayList;
import java.util.List;

import common.DecisionTable;
import common.Rule;

public class DecisionTableColumnTab extends ColumnTab<DecisionTable>{

	public DecisionTableColumnTab(ExcelFile hostExcelFile){
		super.hostExcelFile = hostExcelFile;
		
		read();
		write();
		
	}
	
	

	//there is only one decision table on tab.
	/*
	public DecisionTableColumnTab(List<DecisionTable> decisionTableList, String path, String name,ExcelFile hostExcelFile){
		
		super(decisionTableList,path,name,hostExcelFile);
		
	}
	*/
	
	
	@Override
	public Boolean write() {
		// TODO Auto-generated method stub
		//hidden feature for now...
		//there is only one decision table on tab.
		DecisionTable decisionTable = super.columns.get(0);
		//find Abstract Test Case Tab.
		
		//for each rule is column of tab.
		//do not forget first rule starts with 3rd column of tab and follow as 4,5,6,...
		for (Rule rule : decisionTable.getRules()) {
			//for each rule if condition isOccurred put T , otherwise put F
			
			//put X row of action
		}
		return null;
	}

	
	@Override
	public Boolean read() {// TODO Auto-generated method stub
		//read other files and fill the decision table object...
		//hidden feature for now..
		List<Rule> rules = hostExcelFile.getRules();
		
		DecisionTable table = new DecisionTable(rules);
		super.columns = new ArrayList<DecisionTable>();
		super.columns.add(table);
		
		return true;
	}
	
	
	
	

}
