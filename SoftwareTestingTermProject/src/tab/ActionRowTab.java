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

import common.Action;
import common.Condition;
import common.EActionType;
import common.ETabType;
/**
 * Class represent Action Tab for Excel file.
 * @see Action*/

public class ActionRowTab extends RowTab<Action<String>>{


	public ActionRowTab(ExcelFile hostExcelFile) {
		// TODO Auto-generated constructor stub
		/*super.rows = rows;
		super.path = path;
		super.name = name;
		 */
		this.eTabType = ETabType.ETabType_Actions;
		this.rows = new ArrayList<Action<String>>();

		super.hostExcelFile = hostExcelFile;
		if(read()){
			System.out.println("Action list ready !");
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
	 * prepare list of Actions here.
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

				if (sheetIdentifier.equals(ETabType.ETabType_Actions.toString()))
				{
					//implement,prepare actions tab
					//List<Action<String>> actionList = new ArrayList<Action<String>>();
					while(iterator.hasNext()){
						row = iterator.next();
						rowIdentifier = row.getCell(0).toString();
						if(rowIdentifier.equals(sheetIdentifier)){

						}else {
							if (row.getCell(1) != null){

								//up to now, for each row is an object of Condition class.
								String actionName = row.getCell(1).toString();
								if(!actionName.isEmpty()){
									//for now isOcurred property is false as default.
									Action<String> action = new Action<String>(EActionType.PRINT, actionName);
									this.rows.add(action);
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
