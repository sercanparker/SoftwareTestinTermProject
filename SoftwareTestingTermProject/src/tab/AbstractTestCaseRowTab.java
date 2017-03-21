package tab;

import java.util.List;

import common.AbstractTestCase;
import common.Action;
import common.Condition;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
/**
 * Class represent AbstractTestCase Tab for Excel file.
 * @see AbstractTestCase
 * */

public class AbstractTestCaseRowTab extends RowTab<AbstractTestCase> {
	
	
	
	/**
	 * Write each object of AbstractTestCase class on each rows in file
	 * */
	@Override
	public Boolean write() {

		List<AbstractTestCase> abstractTestCases = getRows();
		for (AbstractTestCase abstractTestCase : abstractTestCases) {
			//each row is abstract test case
			List<Condition> conditions = abstractTestCase.getListOfCondition();
			for (Condition condition : conditions) {
				if(condition.getIsOccurred()){
					//PUT T onto cell 
				}else {
					//PUT F onto cell
				}
			}
			//after condition list setting on file operation
			//put action as string on cell
			Action<?> action = abstractTestCase.getAction();
			Object param = action.getParameter();
		}

		throw new NotImplementedException();
	}

	/**
	 *Read from Decision Table Tab and prepare AbstractTestCase object */
	
	@Override
	public Boolean read() {
		//TODO Auto-generated method stub
		//TODO: read rules of DecitionTable Tab and for each Rules and one Action pairs
		//TODO: find Decisiton Table Tab on tabs
		List<Tab> tabs = hostExcelFile.getTabs();
		//If there exist more than one action, for each action-conditionList pair create an
		//AbstractTestCase object.
		//create an abstract test case object...		
				
		AbstractTestCase abstractTestCase = new AbstractTestCase();
		this.rows.add(abstractTestCase);
		throw new NotImplementedException();
	}
}
