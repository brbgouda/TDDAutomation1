package excelMethods;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadData {
	static Workbook book;
	static Sheet sheet;
	static String path = "C://BG//HomeLearnings//TestExcelFile.xlsx";
	
	public static void main(String[] args) {
		FileInputStream file;
		String SheetName = "Sheet1";
		try {
			file = new FileInputStream(path);
			try {
				book = WorkbookFactory.create(file);
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
//			Row r = sheet.getRow(0);
//			Cell c =r.getCell(0);f
//			String s = c.getStringCellValue();
			for(int i = 0;i<=sheet.getLastRowNum();i++){
				for(int j = 0;j<sheet.getRow(0).getLastCellNum();j++){
					String s = sheet.getRow(i).getCell(j).getStringCellValue();
					System.out.println(s);
				}
				
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
