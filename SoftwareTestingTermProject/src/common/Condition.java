package common;

public class Condition extends AbstractTestCase {

	private Boolean isOccurred;
	private String value;

	public Condition() {

	}

	public Condition(Boolean isOccurred, String value) {
		this.isOccurred = isOccurred;
		this.value = value;
	}

	public Boolean getIsOccurred() {
		return isOccurred;
	}

	public void setIsOccurred(Boolean isOccurred) {
		this.isOccurred = isOccurred;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
