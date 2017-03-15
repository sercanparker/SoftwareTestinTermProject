package common;

import java.util.List;

public class Rule extends AbstractTestCase {
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
