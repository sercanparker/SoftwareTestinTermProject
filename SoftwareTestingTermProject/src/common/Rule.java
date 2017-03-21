package common;

import java.util.List;

public class Rule extends AbstractTestCase {
	/**
	 * Rule has List of Condition and Action objects
	 * For each object of list has same Condition set.
	 * @see Condition
	 * @see Action
	 * */
	private List<Condition> conditions;
	private List<Action<?>> actions;
	//private List<AbstractTestCase> abstractTestCases;

	public Rule() {

	}

	public Rule(List<Condition> conditions, List<Action<?>> actions){
		this.actions = actions;
		this.conditions = conditions;
	}
	
	@Override
	public Action<?> getAction() {
		// TODO Auto-generated method stub
		return super.getAction();
	}
	
	@Override
	public List<Condition> getListOfCondition() {
		// TODO Auto-generated method stub
		return super.getListOfCondition();
	}
	
	@Override
	public void setAction(Action<?> action) {
		// TODO Auto-generated method stub
		super.setAction(action);
	}
	
	@Override
	public void setListOfCondition(List<Condition> conditions) {
		// TODO Auto-generated method stub
		super.setListOfCondition(conditions);
	}
	
}
