import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import Excel.Excel;
import Txt.Txt;
import data.Data;

public class JDM {
	Excel excel;
	Txt txt;
	Data data;
	public JDM(){
		data= new Data();
		excel= new Excel();
		txt=new Txt();
	}
	public void loadData(String path) throws EncryptedDocumentException, InvalidFormatException, IOException{
		excel.loadData(path, data);
	}
	public void writeToTxt(String path, boolean onlyNumbers) throws IOException{
		txt.writeToTxt(path,this.data,onlyNumbers);
	}
	@SuppressWarnings("rawtypes")
	public ArrayList<ArrayList> getData(){
		return data.getData();
	}
	@SuppressWarnings("rawtypes")
	public void setData(ArrayList<ArrayList> data){
		this.data.setData(data);
		
	}
	
	
}
