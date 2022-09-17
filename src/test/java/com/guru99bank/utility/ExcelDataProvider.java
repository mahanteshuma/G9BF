package com.guru99bank.utility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {

	XSSFWorkbook wb;

	public ExcelDataProvider() {
		File src = new File("./TestData/Data.xlsx");

		try {
			FileInputStream fis = new FileInputStream(src);
			wb=new XSSFWorkbook(fis);
		} catch (Exception e) 
		{
			System.out.println("Excepation is:" + e.getMessage());
		}
	}
	public String getStringData(int Sheetindex,int row,int column) {
		return wb.getSheetAt(Sheetindex).getRow(row).getCell(column).getStringCellValue();
	}
	
	public String getStringData(String SheetName,int row,int column) {
		return wb.getSheet(SheetName).getRow(row).getCell(column).getStringCellValue();
	}
	
	public double getNumricalData(String SheetName,int row,int column) {
		return wb.getSheet(SheetName).getRow(row).getCell(column).getNumericCellValue();
	}
	
	

}
