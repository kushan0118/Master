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
public class WriteOutputData {

	static File InputDataFile;
	static XSSFWorkbook InputWB;
	static XSSFSheet InputSH;
	static FileInputStream InputFile;
	static FileOutputStream ResultData;
	
	
	public void WriteData( String Path, int SheetNum, int RowNum, int ColNum, String ResultVal) throws Exception
	{
		InputDataFile = new File(Path);
		InputFile = new FileInputStream(InputDataFile);
		InputWB = new XSSFWorkbook(InputFile);
		InputSH = InputWB.getSheetAt(SheetNum);
		
		InputSH.getRow(RowNum).createCell(ColNum).setCellValue(ResultVal);
		
		ResultData = new FileOutputStream(Path);
		
		InputWB.write(ResultData);
		InputWB.close();
	}
	
}
