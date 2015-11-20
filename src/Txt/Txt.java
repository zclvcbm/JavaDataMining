package Txt;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Txt {

	public Txt() {
	}

	@SuppressWarnings("rawtypes")
	public void writeToTxt(String path, ArrayList<ArrayList> data) throws IOException {

		int datosSize;
		if (path.equals(null)) {
			path = "data.data";
		} else {
			path = path.replace(".xls", ".data");
		}
		BufferedWriter out = new BufferedWriter(new FileWriter(path));
		datosSize = data.size();
		for (int row = 0; row < datosSize; row++) {
			try {
				writeRow(row, data, out);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		out.close();
	}

	private void writeRow(int fila, @SuppressWarnings("rawtypes") ArrayList<ArrayList> data, BufferedWriter out)
			throws IOException {

		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder = new StringBuilder();

		Integer filaSize = Integer.valueOf(data.get(fila).size());

		for (int col = 0; col < filaSize - 1; col++) {
			try {
				Double.parseDouble(data.get(fila).get(col).toString());

				stringBuilder.append(data.get(fila).get(col).toString());
				stringBuilder.append(",");

			} catch (NumberFormatException e1) {

			}
		}
		out.write(stringBuilder.toString() + "\n");
	}
}
