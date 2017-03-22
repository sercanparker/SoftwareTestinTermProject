package common;

import java.util.List;

public class Rule  {
	/**
	 * Rule has List of Condition and Action objects
	 * For each object of list has same Condition set.
	 * @see Condition
	 * @see Action
	 * */
	private List<Condition> conditions;
	private List<Action<String>> actions;
	//private List<AbstractTestCase> abstractTestCases;

	public Rule() {

	}

	public Rule(List<Condition> conditions, List<Action<String>> actions){
		this.actions = actions;
		this.conditions = conditions;
	}
	
	

	public void setConditions(List<Condition> conditions) {
		this.conditions = conditions;
	}
	
	
	public void setActions(List<Action<String>> actions) {
		this.actions = actions;
	}
	
	public List<Action<String>> getActions() {
		return actions;
	}
	public List<Condition> getConditions() {
		return conditions;
	}
	
	
	
}
