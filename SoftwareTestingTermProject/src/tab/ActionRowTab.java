package tab;

import java.util.List;

import common.Action;
import common.Condition;
/**
 * Class represent Action Tab for Excel file.
 * @see Action*/

public class ActionRowTab extends RowTab<Action<String>>{

	
	public ActionRowTab(List<Action<String>> rows,String path,String name,ExcelFile hostExcelFile) {
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
