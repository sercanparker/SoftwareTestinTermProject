package tab;

import java.util.List;

import common.InputVariable;
import common.Requirement;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Class represent Input Tab for Excel file.
 * @see InputVariable*/
public class InputRowTab extends RowTab<InputVariable<Integer>> {

	
	public InputRowTab(List<InputVariable<Integer>> rows,String path,String name,ExcelFile hostExcelFile) {
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
		
		throw new NotImplementedException();
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
