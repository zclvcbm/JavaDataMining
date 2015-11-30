package Txt;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import data.Data;

public class Txt {

	public Txt() {
	}

	public void writeToTxt(String path, Data data, boolean onlyNumbers) throws IOException {

		if (path.equals(null)) {
			path = "defaultData.data";
		} else {
			path = path.replace(".xls", ".data");
		}
		BufferedWriter out = new BufferedWriter(new FileWriter(path));
		int totalRowNumber = data.data.size();
		for (int row = 0; row < totalRowNumber; row++) {
			try {
				if (onlyNumbers) {
					writeNumbersRow(row, data, out);
				} else {
					writeRow(row, data, out);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		out.close();
	}

	private void writeNumbersRow(int row, Data data, BufferedWriter out) throws IOException {

		StringBuilder stringBuilder = new StringBuilder();

		Integer rowSize = Integer.valueOf(data.data.get(row).size());
		for (int col = 0; col < rowSize - 1; col++) {
			try {
				Double.parseDouble(data.data.get(row).get(col).toString());

				stringBuilder.append(data.data.get(row).get(col).toString());
				stringBuilder.append(",");

			} catch (NumberFormatException e1) {
				e1.printStackTrace();
			}
		}
		out.write(stringBuilder.toString() + "\n");
	}

	private void writeRow(int row, Data data, BufferedWriter out) throws IOException {

		StringBuilder stringBuilder = new StringBuilder();
		

		Integer rowSize = Integer.valueOf(data.data.get(row).size());
		for (int col = 0; col < rowSize - 1; col++) {

			stringBuilder.append(data.data.get(row).get(col).toString());
			stringBuilder.append(",");
			
		}
		out.write(stringBuilder.toString() + "\n");
	}
}
