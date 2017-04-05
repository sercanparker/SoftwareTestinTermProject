package common;

import java.util.List;

public class ConcreateTestCase {

	private List<InputVariable<Integer>> inputs;
	private List<OutputVariable<String>> expectedOutput;
	private List<OutputVariable<String>> observedOutput;
	private String testResult;

	public ConcreateTestCase(List<InputVariable<Integer>> inputs, List<OutputVariable<String>> expectedOutputs,
			List<OutputVariable<String>> observedOutputs) {
		this.inputs = inputs;
		this.expectedOutput = expectedOutputs;
		this.observedOutput = observedOutputs;

	}

	public ConcreateTestCase() {

	}

	public List<InputVariable<Integer>> getInputs() {
		return inputs;
	}

	public void setInputs(List<InputVariable<Integer>> inputs) {
		this.inputs = inputs;
	}

	public List<OutputVariable<String>> getExpectedOutput() {
		return expectedOutput;
	}

	public void setExpectedOutput(List<OutputVariable<String>> expectedOutput) {
		this.expectedOutput = expectedOutput;
	}

	public List<OutputVariable<String>> getObservedOutput() {
		return observedOutput;
	}

	public void setObservedOutput(List<OutputVariable<String>> observedOutput) {
		this.observedOutput = observedOutput;
	}

	public String getTestResult() {
		return testResult;
	}

	public void setTestResult(String testResult) {
		this.testResult = testResult;
	}

}
