package common;

import java.util.List;

public abstract class AbstractTestCase {
	private List<Condition> conditions;
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
