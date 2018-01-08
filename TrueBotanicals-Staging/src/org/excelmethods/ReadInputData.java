/**
 * 
 */
package org.excelmethods;

/**
 * @author Ankush
 *
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author Ankush
 *
 */
public class ReadInputData {
	
	static File InputDataFile;
	static XSSFWorkbook InputWB;
	static XSSFSheet InputSH;
	static FileInputStream InputFile;
	static FileOutputStream ResultData;
	
	
	public ReadInputData(String Path)
	{
		try {
			InputDataFile = new File(Path);
			InputFile = new FileInputStream(InputDataFile);
			InputWB = new XSSFWorkbook(InputDataFile);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage() + "input");
		} 
		
				
		
	}

	public String GetCellValue(int SheetNum, int RowNum, int ColNum)
	{
		InputSH = InputWB.getSheetAt(SheetNum);
		return InputSH.getRow(RowNum).getCell(ColNum).getStringCellValue();
	}
	
	
}
