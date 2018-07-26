package excelMethods;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GenericMethods {
	private static final String String = null;
	static FileInputStream fip;
	static String path;
	static Workbook book;
	static Sheet sheet;
	static String sheetName;
	static int rowCount;
	static int cellCount;

	public static void main(String[] args) {
		rowCount = GenericMethods.getRowCount("C://BG//HomeLearnings//TestExcelFile.xlsx", "Sheet1");
		System.out.println(rowCount);
		cellCount = GenericMethods.getCellCount("C://BG//HomeLearnings//TestExcelFile.xlsx", "Sheet1");
		System.out.println(cellCount);
//		Object[][] data = GenericMethods.getExcelData("C://BG//HomeLearnings//TestExcelFile.xlsx", "Sheet1");
//		System.out.println(data);
		String s = GenericMethods.getTestData("C://BG//HomeLearnings//TestExcelFile.xlsx","Sheet1").toString();
		System.out.println(s);
	}

	public static int getRowCount(String path, String sheetName) {
		try {
			fip = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(fip);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		rowCount = sheet.getLastRowNum();
		return rowCount;
	}

	public static int getCellCount(String path, String SheetName) {
		try {
			fip = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(fip);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sheet = book.getSheet(SheetName);
		cellCount = sheet.getRow(0).getLastCellNum();
		return cellCount;

	}

	public static Object[][] getExcelData(String path, String sheetName) {
		try {
			fip = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(fip);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		sheet = book.getSheet(sheetName);

		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

		for (int i = 0; i <= sheet.getLastRowNum(); i++) {
			for (int j = 0; i < sheet.getRow(0).getLastCellNum(); j++) {
				data[i][j] = sheet.getRow(i).getCell(j).toString();
				System.out.println(data[i][j]);
			}
		}
		return data;
	}	
	
	public static Object[][] getTestData(String path, String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		System.out.println(sheet.getRow(0).getLastCellNum());
		for (int i = 0; i <= sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i).getCell(k).toString();
				 System.out.println(data[i][k]);
			}
		}
		return data;
	}

}
