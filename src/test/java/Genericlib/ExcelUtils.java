package Genericlib;
import java.io.FileInputStream;

import java.io.FileNotFoundException;

import java.io.FileOutputStream;

import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;

import org.apache.poi.xssf.usermodel.XSSFRow;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	public String path;
	public FileInputStream fis = null;
	public FileOutputStream fileOut = null;
	private XSSFWorkbook workbook = null;
	private XSSFSheet sheet = null;
	private XSSFRow row = null;
	private XSSFCell cell = null;
	
	
	
	
	static Xls_AllMethods fileone = new Xls_AllMethods("C:\\Users\\satyaranjan.m\\eclipse-workspace\\JuniorForm\\JuniorFieldValidationwrite.xlsx");	
	
	String sheetName = "JuniorFieldMapping";
	
	public Object[][] gettingJuniorCAFdata(String JuniorCAF) throws Exception
	{
		
	
	FileInputStream fis= new FileInputStream("C:\\Users\\satyaranjan.m\\eclipse-workspace\\JuniorForm\\RoughSheet.xlsx");
	XSSFWorkbook workbook= new XSSFWorkbook(fis);
	int sheets=workbook.getNumberOfSheets();
	XSSFSheet sh= workbook.getSheet("JuniorCAF");
	System.out.println("number of sheet:"+sheets);
	Object[][] data= new Object[sh.getLastRowNum()][sh.getRow(0).getLastCellNum()];
	
	//System.out.println(data);
	for(int i=0; i<sh.getLastRowNum();i++)
	{
		for(int k=0;k<sh.getRow(0).getLastCellNum();k++)
		{
			data[i][k]=sh.getRow(i+1).getCell(k).toString();

		}
		
	
	}
	return data;
	
	}
	
	

	public boolean setCellData(String sheetName, String colName, int rowNum, String data) {
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);

			if (rowNum <= 0)
				return false;

			int index = workbook.getSheetIndex(sheetName);
			int colNum = -1;
			if (index == -1)
				return false;

			sheet = workbook.getSheetAt(index);

			row = sheet.getRow(0);
			for (int i = 0; i < row.getLastCellNum(); i++) {
				// System.out.println(row.getCell(i).getStringCellValue().trim());
				if (row.getCell(i).getStringCellValue().trim().equals(colName))
					colNum = i;
			}
			if (colNum == -1)
				return false;

			sheet.autoSizeColumn(colNum);
			row = sheet.getRow(rowNum - 1);
			if (row == null)
				row = sheet.createRow(rowNum - 1);

			cell = row.getCell(colNum);
			if (cell == null)
				cell = row.createCell(colNum);
				cell.setCellValue(data);

			fileOut = new FileOutputStream(path);

			workbook.write(fileOut);

			fileOut.close();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
