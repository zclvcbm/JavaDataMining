import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import Excel.Excel;
import Txt.Txt;
import data.Data;

public class JDMData {
	


	public JDMData() {
	}

	public void loadData(String path, Data data) throws EncryptedDocumentException,
			InvalidFormatException, IOException {
		Excel excel= new Excel(path);
		excel.loadData(data);
	}

	public void writeToTxt(String path, Data data, boolean onlyNumbers) throws IOException {
		Txt txt= new Txt(path);
		txt.writeToTxt(data, onlyNumbers);
	}




}
