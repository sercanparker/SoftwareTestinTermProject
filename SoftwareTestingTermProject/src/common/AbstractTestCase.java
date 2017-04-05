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
	
	
	/**
	 *Shows that abstract test case is satisfiability or not.
	 * */
	private boolean isSAT;
	
	public AbstractTestCase(List<Condition> conditions,Action<?> action) {
		// TODO Auto-generated constructor stub
		this.conditions = conditions;
		this.action = action;
	}

	
	
	
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

	public boolean isSAT() {
		return isSAT;
	}

	public void setSAT(boolean isSAT) {
		this.isSAT = isSAT;
	}
	
	/**
	 * We are going to override it to show Abstract Test Case to user.*/
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		//return super.toString();
		String result = "";
		List<Condition> conditions = this.getListOfCondition();
		for (Condition condition : conditions) {
			result += condition.getValue() + " | " + condition.getIsOccurred().toString() + "\n";
		}
		return result;
		
	}
	
	

}
