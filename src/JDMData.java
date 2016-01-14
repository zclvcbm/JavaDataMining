import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import Excel.Excel;
import Txt.Txt;
import data.Data;

public class JDMData {

	public JDMData() {
	}

	public void loadExcel(String path, Data data)
			throws EncryptedDocumentException, InvalidFormatException,
			IOException {
		Excel excel = new Excel(path);
		excel.loadData(data);
	}

	public void writeExcel(String path, Data data, boolean onlyNumbers) {
		Excel excel = new Excel(path);
		excel.writeData(data, onlyNumbers);
	}

	public void loadTxt(String path, Data data)
			throws EncryptedDocumentException, InvalidFormatException,
			IOException {
		Txt txt = new Txt(path);
		txt.loadData(data);
	}
	
	public void writeTxt(String path, Data data, boolean onlyNumbers)
			throws IOException {
		Txt txt = new Txt(path);
		txt.writeToTxt(data, onlyNumbers);
	}

	

}
