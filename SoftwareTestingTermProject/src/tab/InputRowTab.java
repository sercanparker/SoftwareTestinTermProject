package tab;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import common.EProblemType;
import common.ETabType;
import common.EquivalenceClass;
import common.InputVariable;
import common.Requirement;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Class represent Input Tab for Excel file.
 * @see InputVariable*/
public class InputRowTab extends RowTab<InputVariable<Integer>> {

	
	public InputRowTab(ExcelFile hostExcelFile) {
		// TODO Auto-generated constructor stub
		/*super.rows = rows;
		super.path = path;
		super.name = name;
		*/
		this.eTabType = ETabType.ETabType_Input_Variables;
		this.rows = new ArrayList<InputVariable<Integer>>();
		this.hostExcelFile = hostExcelFile;
		if(read()){
			
			System.out.println("Input List ready !");
		}
		
	}
	
	/**
	 *According to row list objects, it write onto cells 
	 *Not implemented for term project now. */
	@Override
	public Boolean write() {
		
		throw new NotImplementedException();
	}
	/**
	 * Read from excel file and
	 * prepare list of Inputs here.
	 * */
	
	@Override
	public Boolean read() {
		// TODO Auto-generated method stub
		Workbook workBook;
		try {

			File file = new File(hostExcelFile.getPath());
			workBook = WorkbookFactory.create(file);

			int numberOfSheets = workBook.getNumberOfSheets();
			Iterator<Row> iterator;
			Row row;
			String rowIdentifier;
			
			for (int i = 0 ; i < numberOfSheets; i++){
				
				 //when we analyze excel file, we recognize that every 0 row , 0 cell is Identifier
				 //of sheets for every sheets=tabs
				 sheet = workBook.getSheetAt(i);
				 String sheetIdentifier = sheet.getRow(0).getCell(0).toString();

				 iterator = sheet.rowIterator();
				 
				 if (sheetIdentifier.equals(ETabType.ETabType_Input_Variables.toString())){
					//implement,prepare input variable tab
					while(iterator.hasNext()){
							 row = iterator.next();
							 rowIdentifier = row.getCell(0).toString();
								
							if(rowIdentifier.equals(sheetIdentifier)){
									//it is identifier..
									//do nothing...
							}else {
								//up to now, for each row is an object of Input Variable class.
								
								if (row.getCell(1) != null){
									String inputVariableName = row.getCell(1).toString();
									if(!inputVariableName.isEmpty()){
										//create Input Variable object
										//for now value of input variable is not needed. hidden feature.
										//determine equivalance class for input variable.
										if(hostExcelFile.getProblemType() == EProblemType.TRIANGLE){
											//for triangle problem every input variable has same classes
											InputVariable<Integer> inputVariable = new InputVariable<Integer>(inputVariableName,0);
											EquivalenceClass valid = new EquivalenceClass(1, Integer.MAX_VALUE);
											EquivalenceClass invalid = new EquivalenceClass(0,Integer.MIN_VALUE);
											List<EquivalenceClass> eqClasses = new ArrayList<EquivalenceClass>();
											eqClasses.add(valid);
											eqClasses.add(invalid);
											inputVariable.setEquivalenceClasses(eqClasses);
											this.rows.add(inputVariable);
										}
									}
								}
							} 
						 }

					 //no need to travel any more on workbook
					 break;
				 }
				
			}
			
			
			
			workBook.close();
			return true;
			
			
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
