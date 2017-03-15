package common;

public abstract class Parameter<T> {
	private String variable;
	private T value;

	public Parameter() {

	}

	public Parameter(String variable, T value) {
		this.variable = variable;
		this.value = value;
	}

	public String getVariable() {
		return variable;
	}

	public void setVariable(String variable) {
		this.variable = variable;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

}
