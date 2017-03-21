package tab;

import java.util.List;

/**
 * Class is used by ExcelFile object to represent its Tab structure */
public abstract class Tab {
	/**
	 * This path is same with path of File which holds it.
	 */
	protected String path;
	
	/**
	 * Physical name of Tab.*/
	protected String name;
	
	/**
	 * variable that indicates that host excelfile object that tab exist.*/
	protected ExcelFile hostExcelFile;

	public Tab() {

	}

	public Tab(String path, String name, ExcelFile hostExcelFile) {
		this.path = path;
		this.name = name;
		this.hostExcelFile = hostExcelFile;
	}
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * write and read methods have different implementations
	 * @see Boolean */
	public abstract Boolean write();

	public abstract Boolean read();



}
