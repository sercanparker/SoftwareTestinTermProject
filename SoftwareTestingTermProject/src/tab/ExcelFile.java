package tab;

import java.util.List;

/**
 * Class represents excel file specifications
 * @see	Tab 
 */
public class ExcelFile<T> {

	/**
	 * Physical path of excel file.
	 * Users/User/Project/file.xslx etc.
	  */
	private String path;
	/**
	 * Excel file consist of List of tabs*/
	private List<Tab> tabs;

	public ExcelFile() {

	}

	public ExcelFile(String path, List<Tab> tabs) {
		this.path = path;
		this.setTabs(tabs);
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public List<Tab> getTabs() {
		return tabs;
	}

	public void setTabs(List<Tab> tabs) {
		this.tabs = tabs;
	}

}
