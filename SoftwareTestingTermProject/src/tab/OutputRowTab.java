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

import common.ETabType;
import common.InputVariable;
import common.OutputVariable;


/**
 * Class represent Output Tab for Excel file.
 * @see OutputVariable*/
public class OutputRowTab extends RowTab<OutputVariable<String>>{

	public OutputRowTab(ExcelFile hostExcelFile) {
		// TODO Auto-generated constructor stub
		/*super.rows = rows;
		super.path = path;
		super.name = name;
		 */
		this.eTabType = ETabType.ETabType_Output_Variables;
		this.rows = new ArrayList<OutputVariable<String>>();
		super.hostExcelFile = hostExcelFile;
		if(read()){
			System.out.println("Output List ready !");
		}
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
	 * Read from excel file and
	 * prepare list of Output here.
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

				if (sheetIdentifier.equals(ETabType.ETabType_Output_Variables.toString())){
					//implement,prepare output variable tab

					while(iterator.hasNext()){
						row = iterator.next();
						rowIdentifier = row.getCell(0).toString();

						if(rowIdentifier.equals(sheetIdentifier)){
							//it is identifier..
							//do nothing...
						}else {
							//up to now, for each row is an object of Output Variable class.

							if (row.getCell(1) != null){
								String outputVariableName = row.getCell(1).toString();
								if(!outputVariableName.isEmpty()){
									//create Requirement object
									//for now value of outpu variable is not needed.
									//It is Empty String. hidden feature.
									OutputVariable<String> outputVariable = new OutputVariable<String>(outputVariableName,"");
									this.rows.add(outputVariable);
								}
							}
						}

					}
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
