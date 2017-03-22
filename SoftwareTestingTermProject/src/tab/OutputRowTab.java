package tab;

import java.util.List;

import common.InputVariable;
import common.OutputVariable;


/**
 * Class represent Output Tab for Excel file.
 * @see OutputVariable*/
public class OutputRowTab extends RowTab<OutputVariable<String>>{

	public OutputRowTab(List<OutputVariable<String>> rows,String path,String name,ExcelFile hostExcelFile) {
		// TODO Auto-generated constructor stub
		super.rows = rows;
		super.path = path;
		super.name = name;
		super.hostExcelFile = hostExcelFile;
	}
	/**
	 *According to row list objects, it write onto cells 
	 *Not implemented for term project now. */
	@Override
	public Boolean write() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 *To fill Tab's row based on other excel file, word file etc...
	 *Not implemented for term project now. */
	@Override
	public Boolean read() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}