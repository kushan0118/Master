package org.DDT;

import java.io.File;
import java.io.IOException;

import org.apache.xalan.xsltc.runtime.Hashtable;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExcelData {
	
	static Workbook wrkbook = null;  //Initialize Work Book
	static Sheet wrksheet = null;   //Initialize WorkSheet
	static Hashtable useDict = new Hashtable();
	
	//Create a Constructor
		
	public ExcelData(String path)
	{
		try {
			wrkbook = Workbook.getWorkbook(new File(path));  //Open Workbook
			wrksheet = wrkbook.getSheet("Sheet1");  //Select Sheet
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//Returns the Cell value by taking row and Column values as argument
	public static int RowCount()
	{
		return wrksheet.getRows();
	}
	
	
	public static String GetCellValue(int colNumber, int rowNumber)
	{
		return wrksheet.getCell(colNumber, rowNumber).getContents(); //Read Cell Data
	}
	
	//Create Dictionary
	public static void colDictionary()
	{
		//Iterate through all the columns in the Excel sheet and store the value in Hashtable
		for (int col=0;col<wrksheet.getColumns();col++)
		{
			useDict.put(GetCellValue(col, 0), col);
		}
	}
	//Read Column Values
	
	public static int GetCell(String colName)
	{
		int value = 0;
		try{
		
		value = ((Integer) useDict.get(colName)).intValue();
		
		
		} catch (NullPointerException e) {
			// TODO: handle exception
		}
		return value;
	}
	
	public static String ReadCell(String colName, int rowName)
	{
		return GetCellValue(GetCell(colName), rowName);
	}
}
