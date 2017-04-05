package tab;

import java.util.ArrayList;
import java.util.List;

import common.EProblemType;

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
	
	
	private EProblemType problemType;
	
	public ExcelFile(String path,EProblemType problemType) {
		
		this.path =  path;
		this.problemType = problemType;
		this.tabs = new ArrayList<Tab>();
		setTabs();
		
	}
	
	

	private void setTabs() {
		// TODO Auto-generated method stub

		RequirementRowTab requirementRowTab = new RequirementRowTab(this);
		tabs.add(requirementRowTab);
		
		InputRowTab inputRowTab = new InputRowTab(this);
		tabs.add(inputRowTab);
		
		OutputRowTab outputRowTab = new OutputRowTab(this);
		tabs.add(outputRowTab);
		
		ConditionRowTab conditionRowTab = new ConditionRowTab(this);
		tabs.add(conditionRowTab);
		
		ActionRowTab actionRowTabl = new ActionRowTab(this);
		tabs.add(actionRowTabl);
		
		DecisionTableColumnTab decisionTableColumnTab = new DecisionTableColumnTab(this);	
		tabs.add(decisionTableColumnTab);
		
		AbstractTestCaseRowTab abstractTestCaseRowTab = new AbstractTestCaseRowTab(this);
		tabs.add(abstractTestCaseRowTab);
		
		ConcreteTestCaseRowTab concreteTestCaseRowTab = new ConcreteTestCaseRowTab(this);
		tabs.add(concreteTestCaseRowTab);
		
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
	
	public EProblemType getProblemType() {
		return problemType;
	}
	
	public void setProblemType(EProblemType problemType) {
		this.problemType = problemType;
	}

}
