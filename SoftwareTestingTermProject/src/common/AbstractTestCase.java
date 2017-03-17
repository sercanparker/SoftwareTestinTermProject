package common;

import java.util.List;


public class AbstractTestCase {
	/**
	 * Abstract Test Case consist of List of Conditions
	 * @see Condition
	 * */
	private List<Condition> conditions;
	
	
	
	/**
	 * Abstract Test Case has only one Action.
	 * @see Action
	 * */
	private Action<?> action;

	
	
	
	public List<Condition> getListOfCondition() {
		return conditions;
	}

	public void setListOfCondition(List<Condition> conditions) {
		this.conditions = conditions;
	}

	public Action<?> getAction() {
		return action;
	}

	public void setAction(Action<?> action) {
		this.action = action;
	}

}
