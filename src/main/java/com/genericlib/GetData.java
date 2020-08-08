package com.genericlib;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GetData {
	
	public Object[][] gettingdata(String BSEODISHA) throws Exception
	{
	FileInputStream fis= new FileInputStream("C:\\Users\\satyaranjan.m\\eclipse-workspace\\JuniorForm\\TestData.xlsx");
	XSSFWorkbook workbook= new XSSFWorkbook(fis);
	int sheets=workbook.getNumberOfSheets();
	XSSFSheet sh= workbook.getSheet("BSEODISHA");
	System.out.println("number of sheet:"+sheets);
	Object[][] data= new Object[sh.getLastRowNum()][sh.getRow(0).getLastCellNum()];
	for(int i=0; i<sh.getLastRowNum();i++)
	{
		for(int k=0;k<sh.getRow(0).getLastCellNum();k++)
		{
			data[i][k]=sh.getRow(i+1).getCell(k).toString();
		}
	}
	return data;
	}

	public Object[][] cbsedata(String CBSEDELHI) throws Exception
	{
	FileInputStream fis= new FileInputStream("C:\\Users\\satyaranjan.m\\eclipse-workspace\\JuniorForm\\TestData.xlsx");
	XSSFWorkbook workbook= new XSSFWorkbook(fis);
	int sheets=workbook.getNumberOfSheets();
	XSSFSheet sh= workbook.getSheet("CBSEDELHI");
	System.out.println("number of sheet:"+sheets);
	Object[][] data= new Object[sh.getLastRowNum()][sh.getRow(0).getLastCellNum()];
	for(int i=0; i<sh.getLastRowNum();i++)
	{
		for(int k=0;k<sh.getRow(0).getLastCellNum();k++)
		{
			data[i][k]=sh.getRow(i+1).getCell(k).toString();
		}
	}
	return data;
	}
	
	public Object[][] bseAndhradata(String FormData) throws Exception
	{
	FileInputStream fis= new FileInputStream("C:\\Users\\satyaranjan.m\\eclipse-workspace\\JuniorForm\\TestData.xlsx");
	XSSFWorkbook workbook= new XSSFWorkbook(fis);
	int sheets=workbook.getNumberOfSheets();
	XSSFSheet sh= workbook.getSheet("FormData");
	System.out.println("number of sheet:"+sheets);
	Object[][] data= new Object[sh.getLastRowNum()][sh.getRow(0).getLastCellNum()];
	for(int i=0; i<sh.getLastRowNum();i++)
	{
		for(int k=0;k<sh.getRow(0).getLastCellNum();k++)
		{
			data[i][k]=sh.getRow(i+1).getCell(k).toString();
		}
	}
	return data;
	}
	
	
	
	public Object[][] bpeKereladata(String FormData) throws Exception
	{
	FileInputStream fis= new FileInputStream("C:\\Users\\satyaranjan.m\\eclipse-workspace\\JuniorForm\\TestData.xlsx");
	XSSFWorkbook workbook= new XSSFWorkbook(fis);
	int sheets=workbook.getNumberOfSheets();
	XSSFSheet sh= workbook.getSheet("FormData");
	System.out.println("number of sheet:"+sheets);
	Object[][] data= new Object[sh.getLastRowNum()][sh.getRow(0).getLastCellNum()];
	for(int i=0; i<sh.getLastRowNum();i++)
	{
		for(int k=0;k<sh.getRow(0).getLastCellNum();k++)
		{
			data[i][k]=sh.getRow(i+1).getCell(k).toString();
		}
	}
	return data;
	}
	
}
