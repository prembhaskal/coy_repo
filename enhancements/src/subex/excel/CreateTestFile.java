package subex.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class CreateTestFile {

	public void createSheetWithTestData(String path, Map<String, String> keyValue) {
		File file = createFile(path);
		Workbook workbook = createWorkbook();
		Sheet sheet = createWorkSheet(workbook);

		List<String> headers = new ArrayList(Arrays.asList("test1", "test2"));
		createHeaderRow(sheet, headers);

		writeKeyValuesPairs(sheet, keyValue);
		writeToWorkbook(workbook, file);
	}

	private File createFile(String path) {
		File file = new File(path);
		return file;
	}

	private Workbook createWorkbook() {
		Workbook wb = new XSSFWorkbook();
		return wb;
	}

	private Sheet createWorkSheet(Workbook workbook) {
		return workbook.createSheet("test_sheet");
	}

	private void writeKeyValuesPairs(Sheet sheet, Map<String, String> keyValue) {
		int i=1; // 0 is for the header row
		for (Map.Entry<String, String> entry : keyValue.entrySet()) {
			writeDataToRow(sheet, i, 0, entry.getKey());
			writeDataToRow(sheet, i, 1, entry.getValue());
			i++;
		}
	}

	private void writeDataToRow(Sheet sheet, int rowIdx, int columnIdx, String data) {
		Row row = sheet.getRow(rowIdx);
		if (row==null)
			row = sheet.createRow(rowIdx);

		Cell cell = row.getCell(columnIdx);
		if (cell == null)
			cell = row.createCell(columnIdx);

		cell.setCellValue(data);
	}

	private void createHeaderRow(Sheet sheet, List<String> headers) {
		Row headerRow = sheet.createRow(0);

		int i = 0;
		for (String header : headers) {
			Cell cell = headerRow.createCell(i++);
			cell.setCellValue(header);
		}

	}

	private void writeToWorkbook(Workbook workbook, File file) {
		try (FileOutputStream fileOut = new FileOutputStream(file)) {
			workbook.write(fileOut);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void writeSampleDataToTextFile(File file) {
		try (PrintWriter writer = new PrintWriter(file)) {
			String data = "this is sample data";
			writer.println(data);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
