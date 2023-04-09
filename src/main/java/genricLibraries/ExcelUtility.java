package genricLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	private Workbook wb = null;

	/**
	 * This method is used to initialize the excel path 
	 * @param excelpath
	 */
	public void excelInitialization(String excelpath) {
		FileInputStream fis = null;

		try {
			fis = new FileInputStream(excelpath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			wb = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException | IOException e) {
			e.printStackTrace();
		}
	}

	public String fetchDataFromExcel(String sheetName, int rowName, int cellName) {
		return wb.getSheet(sheetName).getRow(rowName).getCell(cellName).getStringCellValue();
	}

	public List<String> fetchDataFromExcel(String sheetName) {
		List<String> dataList = new ArrayList<String>();
		Sheet sheet = wb.getSheet(sheetName);
		for (int i = 0; i <= sheet.getLastRowNum(); i++) {
			String data = sheet.getRow(i).getCell(1).getStringCellValue();
			dataList.add(data);
		}
		return dataList;
	}

	public void closeExcel() {
		try {
			wb.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
