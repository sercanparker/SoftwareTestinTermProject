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
import common.Requirement;


/**
 * Class represent Requirement Tab for Excel file.
 * @see Requirement*/
public class RequirementRowTab extends RowTab<Requirement>{

	
	public RequirementRowTab(ExcelFile hostExcelFile) {
		// TODO Auto-generated constructor stub
		/*super.rows = rows;
		super.path = path;
		super.name = name;
		*/
		this.eTabType = ETabType.ETabType_Requirements;
		this.rows = new ArrayList<Requirement>();
		this.hostExcelFile = hostExcelFile;
		if(read()){
			System.out.println("Requirement list ready !");
		}
		
	}
	/**
	 *According to row list objects, it write onto cells 
	 *Not implemented for term project now.
	 *We expect that user already enter it on excel file. */
	@Override
	public Boolean write() {
		// TODO Auto-generated method stub
		return null;
	}


	/**
	 * Read from excel file and
	 * repare list of Requirements here.
	 * */
	
	@Override
	public Boolean read() {
		// TODO Auto-generated method stub
		try {

			File file = new File(hostExcelFile.getPath());
			Workbook workBook = WorkbookFactory.create(file);
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
				
				if (sheetIdentifier.equals(ETabType.ETabType_Requirements.toString())){
					 //implement,prepare requirement tab
					 //travel all rows via iterator
					 //List<Requirement> requirementList = new ArrayList<Requirement>();
					 while(iterator.hasNext()){

						row = iterator.next();
						rowIdentifier = row.getCell(0).toString();
						
						if(rowIdentifier.equals(sheetIdentifier)){
							//it is identifier..
							//do nothing...
						}else {
							//up to now, for each row is an object of Rule class.
							//maybe user does not enter requirement spec string
							if (row.getCell(1) != null){
								String requirementDescription = row.getCell(1).toString();
								if(!requirementDescription.isEmpty()){
									//create Requirement object
									Requirement requirement = new Requirement(requirementDescription);
									this.rows.add(requirement); //store it	
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
