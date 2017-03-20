
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

public class ReadingExcel {

	

	public static void main(String[] args) {

		try {

			FileInputStream file = new FileInputStream(new File("C:\\Users\\emre.karakis\\Desktop\\deneme.xls"));

			// Get the workbook instance for XLS file
			HSSFWorkbook workbook = new HSSFWorkbook(file);

			// Get first sheet from the workbook
			HSSFSheet sheet = workbook.getSheetAt(0);

			// Iterate through each rows from first sheet
			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();

				// For each row, iterate through each columns
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {

					Cell cell = cellIterator.next();

					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_BOOLEAN:
						System.out.print(cell.getBooleanCellValue() + "\t\t");
						break;
					case Cell.CELL_TYPE_NUMERIC:
						System.out.print(cell.getNumericCellValue() + "\t\t");
						break;
					case Cell.CELL_TYPE_STRING:
						System.out.print(cell.getStringCellValue() + "\t\t");
						break;
					}
				}
				System.out.println("");
			}
			file.close();
			FileOutputStream out = new FileOutputStream(new File("C:\\Users\\emre.karakis\\Desktop\\deneme.xls"));
			workbook.write(out);
			out.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

/*
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;

public class ReadingExcel {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream(new File("C:\\Users\\emre.karakis\\Desktop\\deneme.xls"));

		// create workBook instance that refers to .xls file
		HSSFWorkbook wb = new HSSFWorkbook(fis);
		// create a sheet object to retrieve the sheet
		HSSFSheet sheet = wb.getSheetAt(0);

		// that is for evaluate the cell type

		FormulaEvaluator formulaEvaluator = wb.getCreationHelper().createFormulaEvaluator();

		for (Row row : sheet) {
			for (Cell cell : row) {
				switch (formulaEvaluator.evaluateInCell(cell).getCellType()) {

				// if cell is a numeric format
				case Cell.CELL_TYPE_NUMERIC:
					System.out.println(cell.getNumericCellValue() + "\t\t");
					break;
				case Cell.CELL_TYPE_STRING:
					System.out.println(cell.getStringCellValue() + "\t\t");
					break;
				}
			}
			System.out.println();
		}

	}

}*/
