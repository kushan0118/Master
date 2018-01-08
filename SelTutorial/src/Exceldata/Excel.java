package Exceldata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {

	public static void main(String[] args) throws IOException {
		
		// Giving path of excel to read.
		InputStream ExcelFileToRead = new FileInputStream("C:/Users/Ankush/Desktop/Readwritedata.xlsx");
		
		// passing path to object oof hssfworkbook.
		XSSFWorkbook workbook = new XSSFWorkbook(ExcelFileToRead);
		
		//reading number of sheets present and increment that
		
		for (int i=0;i<workbook.getNumberOfSheets();i++)
		{
			XSSFSheet sheetnumber= workbook.getSheetAt(i);
			
			System.out.println(i);
			
			// Creating class variable
			
			XSSFRow row;
			XSSFCell cell;
			
			Iterator rows =sheetnumber.rowIterator();
			
			while (rows.hasNext())
			{
			
				row= (XSSFRow)rows.next();
				
				System.out.println(row.getRowNum());
				
				Iterator cells=row.cellIterator();
				
				while (cells.hasNext())
				{
					cell = (XSSFCell)cells.next();
					System.out.println(cell);
				}
			}
		}
			
		
	}

}
