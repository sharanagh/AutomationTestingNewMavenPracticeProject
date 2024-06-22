package com.selenium.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadDataFromExcel {

	public static Object[][] readDataFromExcelFl(String sheetName) throws Exception {

		String filePath = "D:\\Practice\\PracticeMaven\\src\\main\\java\\com\\selenium\\mavenTestData\\ExcelTestData.xlsx";
	
		FileInputStream fis = new FileInputStream(filePath);
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		XSSFSheet sheet = wb.getSheet(sheetName);
		int rowLength = sheet.getLastRowNum();
		int colLength = sheet.getRow(1).getLastCellNum();
		Object[][] data = new Object[rowLength][colLength];
		for (int i = 0; i < rowLength; i++) {
			XSSFRow row = sheet.getRow(i + 1);
			for (int j = 0; j < colLength; j++) {
				XSSFCell cell = row.getCell(j);
				
				switch (cell.getCellType()) {
				case STRING:
					data[i][j] = cell.getStringCellValue();
					System.out.print(data[i][j]);
					break;
				case NUMERIC:
					data[i][j] = cell.getNumericCellValue();
					System.out.print(data[i][j]);
					break;
				}
				System.out.print("   |   ");
			}
			System.out.println();
		}
		return data;
	}
}
