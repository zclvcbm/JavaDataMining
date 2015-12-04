import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import Excel.Excel;
import Txt.Txt;
import data.Data;

public class JDMData {

	public JDMData() {
	}

	public void loadDataExcel(String path, Data data)
			throws EncryptedDocumentException, InvalidFormatException,
			IOException {
		Excel excel = new Excel(path);
		excel.loadData(data);
	}

	public void writeToExcel(String path, Data data, boolean onlyNumbers) {
		Excel excel = new Excel(path);
		excel.writeData(data, onlyNumbers);
	}

	public void writeToTxt(String path, Data data, boolean onlyNumbers)
			throws IOException {
		Txt txt = new Txt(path);
		txt.writeToTxt(data, onlyNumbers);
	}

	public void loadDataTxt(String path, Data data)
			throws EncryptedDocumentException, InvalidFormatException,
			IOException {
		Txt txt = new Txt(path);
		txt.loadData(data);
	}

}
