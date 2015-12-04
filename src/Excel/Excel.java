package Excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import data.Data;

public class Excel {

	String path;

	public Excel(String path) {
		this.path=path;
	}

	public void loadData(Data data) throws EncryptedDocumentException, InvalidFormatException, IOException {

		FileInputStream file = new FileInputStream(new File(path));
		org.apache.poi.ss.usermodel.Workbook workbook = WorkbookFactory.create(file);
		org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(0);
		try {
			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				ArrayList<String> arrayRow = new ArrayList<String>();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					testDataType(cell, arrayRow);
				}
				data.getData().add(arrayRow);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		workbook.close();
		file.close();
		sheet = null;
		workbook = null;
		file = null;

	}

	private void testDataType(Cell cell, ArrayList<String> arrayRow) {

		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_NUMERIC:
			arrayRow.add(String.valueOf(cell.getNumericCellValue()));
		break;
		case Cell.CELL_TYPE_STRING:
			arrayRow.add(cell.getStringCellValue());
		break;
		case Cell.CELL_TYPE_BLANK:
			arrayRow.add("--");
		break;
		default:
			arrayRow.add("--");
		break;
		}

	}

	public void writeData(Data data, boolean onlyNumbers) {
		// TODO Auto-generated method stub
		
	}

}
