package common;
/**
 * There exist 8 number of types currently*/
public enum ETabType {
	ETabType_Requirements("Requirements"),
	ETabType_Input_Variables("Input Variables"),
	ETabType_Output_Variables("Output Variables"),
	ETabType_Conditions("Conditions"),
	ETabType_Actions("Actions"),
	ETabType_Decision_Table("Decision Table"),
	ETabType_Abstract_Test_Cases("Abstract Test Cases"),
	ETabType_Concrete_Test_Cases("Concrete Test Cases"),
    ;

    private final String text;

    /**
     * @param text
     */
    private ETabType(final String text) {
        this.text = text;
    }

    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return text;
    }
	

}
