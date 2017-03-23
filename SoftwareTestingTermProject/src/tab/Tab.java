package tab;

import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;

import common.ETabType;

/**
 * Class is used by ExcelFile object to represent its Tab structure */
public abstract class Tab {
	
	/**
	 * Physical name of Tab.*/
	protected String name;
	
	/**
	 * variable that indicates that host excelfile object that tab exist.*/
	protected ExcelFile hostExcelFile;
	
	protected Sheet sheet;
	
	protected ETabType eTabType;

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
