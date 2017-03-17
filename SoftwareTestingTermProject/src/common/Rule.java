package common;

import java.util.List;

public class Rule extends AbstractTestCase {
	/**
	 * Rule has List of Abstract Test Case
	 * For each object of list has same Condition set.
	 * @see AbstractTestCase
	 * */
	private List<AbstractTestCase> abstractTestCases;

	public Rule() {

	}

	public Rule(List<AbstractTestCase> abstracTestCase) {
		this.abstractTestCases = abstracTestCase;
	}

	public List<AbstractTestCase> getAbstractTestCases() {
		return abstractTestCases;
	}

	public void setAbstractTestCases(List<AbstractTestCase> abstractTestCases) {
		this.abstractTestCases = abstractTestCases;
	}

}
