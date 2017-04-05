package common;

public class Condition{

	/**
	 * It shows condition is active or not.*/
	private EConditionOccurrence isOccurred;
	//private Boolean isOccurred;
	/**
	 * Condition's value that such as a<10 as String*/
	private String value;

	public Condition(EConditionOccurrence isOccurred, String value) {
		this.isOccurred = isOccurred;
		this.value = value;
	}

	public EConditionOccurrence getIsOccurred() {
		return isOccurred;
	}

	public void setIsOccurred(EConditionOccurrence isOccurred) {
		this.isOccurred = isOccurred;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
