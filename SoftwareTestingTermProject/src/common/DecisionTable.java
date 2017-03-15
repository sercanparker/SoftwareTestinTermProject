package common;

import java.util.List;

public class DecisionTable {

	private List<Rule> rules;

	public DecisionTable() {

	}

	public DecisionTable(List<Rule> rules) {
		this.rules = rules;
	}

	public List<Rule> getRules() {
		return rules;
	}

	public void setRules(List<Rule> rules) {
		this.rules = rules;
	}

}
