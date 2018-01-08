package org.excelmethods;

/**
 * @author Ankush
 *
 */

public class TestExcelData {
	
	
	public static void main (String []args) throws Exception
	{
		/*ReadInputData RID = new ReadInputData("C:\\Users\\Ankush\\Desktop\\Readwritedata.xlsx");
		System.out.println();
		
		RID.SetCellValueIn(0, 1, 2, "test");
		RID.WriteOutputData("C:\\Users\\Ankush\\Desktop\\Readwritedata.xlsx");*/
		
		WriteOutputData WOD = new WriteOutputData();
		
		WOD.WriteData("C:\\Users\\Ankush\\Desktop\\Readwritedata.xlsx", 0, 1, 3, "Hurray!!");
	}
	
	
	
	

}
