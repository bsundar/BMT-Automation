package Config;
//import static Config.XlsReader.configDetails;
//import static Config.XlsReader.configDetails;
import static Config.XlsReader.localArray1;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.model.Sheet;
import org.apache.poi.hssf.model.Workbook;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import ReusableComponents.htmlReport;

@SuppressWarnings("unused")
public class XlsReader extends BaseConfig
{
	//@SuppressWarnings("unused")
	private static Workbook workbook;
	static Sheet sheet;
	//@SuppressWarnings("unused")
	private static HSSFSheet xlSheet;
	//@SuppressWarnings("unused")
	private static HSSFWorkbook xlWorkBook;
	private static HSSFCell cell;
    //@SuppressWarnings("unused")
	private static HSSFRow row;
	static int ExcelRows;
	static int Excelcols;    
	public static String localArray[][];
	public static String localArray1[][];
	public static String localArray2[][];
	public static String ExpeActual[][];
	
	 static htmlReport htr=new htmlReport();
	 
	private static String excelP() throws Exception
	 {
		 String ExcelPa=configDetails(0,3,1); 
		 return "ExcelPa";
	 }
	 
	 
	//@SuppressWarnings("static-access")
	public static void Fetchmethod(String sheet) throws Exception {	
		try{		
		//String ExcelPath=configDetails(0,1,1);
		//String ExcelPath=excelPath();		
		System.out.println("Entered FetchMethod");
		System.out.println("The value of ExcelPath is:"+ExcelPath);
		File oxlFile = new File(ExcelPath);
		FileInputStream oTestDataStream = new FileInputStream(oxlFile);
		HSSFWorkbook xlWorkBook = new HSSFWorkbook(oTestDataStream);
		HSSFSheet xlSheet = xlWorkBook.getSheet("TestScripts");
	
		ExcelRows = xlSheet.getLastRowNum() + 1;
		Excelcols = xlSheet.getRow(0).getLastCellNum();
		localArray = new String[ExcelRows][Excelcols];
			
		for(int i=0;i<ExcelRows;i++){			
		HSSFRow row = xlSheet.getRow(i);
		for(Short j=0;j<Excelcols;j++){
			HSSFCell cell =row.getCell(j);
			if (cell == null)
			{
			  
			}
			else if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING)
            {
			String Value = cell.getStringCellValue();			
			localArray[i][j] = Value;
            }
			else if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC)
            {
                
                double num = cell.getNumericCellValue();
                int num1 = Double.valueOf(num).intValue();
                String num2 = Integer.toString(num1);
                localArray[i][j] = num2;
            }
						
		}
				
		}
		System.out.println("Completed FetchMethod");
		}
		  catch (Exception e){
 

            }
	}
	
	public static int FindRowno(String Methodname) throws Exception {
		int rowno=0;
		for(int i=0;i<ExcelRows;i++){
			
				if(localArray[i][0].contentEquals(Methodname))
				{
					String noofitem1 = localArray[i][1];
					rowno =Integer.parseInt(noofitem1);
				}		
			}
		System.out.println("the value of rowno:"+rowno);
		return rowno;				
	}		
		//@SuppressWarnings("static-access")
		public static void FetchExceldata(int rowno) throws Exception {
			System.out.println("Entered FetchExceldata");
			File oxlFile = new File(ExcelPath);
			FileInputStream oTestDataStream = new FileInputStream(oxlFile);
			HSSFWorkbook xlWorkBook = new HSSFWorkbook(oTestDataStream);
			HSSFSheet xlSheet = xlWorkBook.getSheet("TestData");
			int i=0;
			ExcelRows = xlSheet.getLastRowNum()+1;
			Excelcols = xlSheet.getRow(0).getLastCellNum();
			localArray1 = new String[ExcelRows][Excelcols];
			HSSFRow row = xlSheet.getRow(rowno);			
			for(short j=0;j<Excelcols;j++){
				HSSFCell cell =row.getCell(j);
				if (cell == null)
				{
				  continue; 
				}
				else if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING)
	            {
				String Value = cell.getStringCellValue();			
				localArray1[i][j] = Value;
	            }
				else if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC)
	            {
					double num = cell.getNumericCellValue();
	                int num1 = Double.valueOf(num).intValue();
	                String num2 = Integer.toString(num1);
	                localArray1[i][j] = num2;
	            }								
			}
			System.out.println("Completed FetchExceldata");	
			}	
		
	
		@SuppressWarnings("static-access")
		public static String fetchCell(int num,int row, int i) throws Exception {
			try{
			File oxlFile = new File(Path_TestData+File_TestData);
			FileInputStream oTestDataStream = new FileInputStream(oxlFile);
			HSSFWorkbook xlWorkBook = new HSSFWorkbook(oTestDataStream);
			HSSFSheet xlSheet = xlWorkBook.getSheetAt(num);	
				
				
			//HSSFRow Row = xlSheet.getRow(row);
			//HSSFCell  cell = Row.getCell(i);
			cell = xlSheet.getRow(row).getCell((short) i);
			String cellData=cell.getStringCellValue();
			
		if (cell.getCellType() != cell.CELL_TYPE_BLANK) {
		    System.out.println("Value "+cell.getStringCellValue());
		}
		return cellData;		
	}
		  catch (Exception e){

              return"";

            }
}
		
		@SuppressWarnings("static-access")
		public static String xmlStatus(int num,int row, int i) throws Exception {
			try{
			File oxlFile = new File(ExcelPath);
			FileInputStream oTestDataStream = new FileInputStream(oxlFile);
			HSSFWorkbook xlWorkBook = new HSSFWorkbook(oTestDataStream);
			HSSFSheet xlSheet = xlWorkBook.getSheetAt(num);	
			cell = xlSheet.getRow(row).getCell((short) i);
			String cellData=cell.getStringCellValue();			
		if (cell.getCellType() != cell.CELL_TYPE_BLANK) {
		    System.out.println(" "+cell.getStringCellValue());
		}
		return cellData;		
	}
		  catch (Exception e){

              return"";

            }
  }
		
		@SuppressWarnings("static-access")
		public static boolean excelStatus(int num,int row, int i) throws Exception {
			try{
			File oxlFile = new File(TestNGPath);
			FileInputStream oTestDataStream = new FileInputStream(oxlFile);
			HSSFWorkbook xlWorkBook = new HSSFWorkbook(oTestDataStream);
			HSSFSheet xlSheet = xlWorkBook.getSheetAt(num);	
				
				
			//HSSFRow Row = xlSheet.getRow(row);
			//HSSFCell  cell = Row.getCell(i);
				cell = xlSheet.getRow(row).getCell((short) i);
			//@SuppressWarnings("unused")
			String cellData=cell.getStringCellValue();
			
		if (cell.getCellType() != cell.CELL_TYPE_BLANK) {
		    System.out.println(" "+cell.getStringCellValue());
		}
		return true;		
	}
		  catch (Exception e){

            //  return"";

            }
			return false;
  }
				
		@SuppressWarnings("static-access")
		public static String configDetails(int num,int row, int i) throws Exception {
			try{			
				File oxlFile = new File(ExcelPath);
				FileInputStream oTestDataStream = new FileInputStream(oxlFile);
				HSSFWorkbook xlWorkBook = new HSSFWorkbook(oTestDataStream);
				HSSFSheet xlSheet = xlWorkBook.getSheetAt(num);					
				//HSSFRow Row = xlSheet.getRow(row);
				//HSSFCell  cell = Row.getCell(i);
					cell = xlSheet.getRow(row).getCell((short) i);
				String cellData=cell.getStringCellValue();
				
			if (cell.getCellType() != cell.CELL_TYPE_BLANK) {
			    System.out.println(" "+cell.getStringCellValue());
			}
			return cellData;		
		}
			  catch (Exception e){

	              return"";

	            }
	  }

		public static void FetchExcel(int rowno) throws Exception {
			System.out.println("Entered FetchExceldata");
			File oxlFile = new File(ExcelPath);
			FileInputStream oTestDataStream = new FileInputStream(oxlFile);
			HSSFWorkbook xlWorkBook = new HSSFWorkbook(oTestDataStream);
			HSSFSheet xlSheet = xlWorkBook.getSheet("Sheet1");
			//int i=0;
			//ExcelRows = xlSheet.getLastRowNum()+1;
			//Excelcols = xlSheet.getRow(0).getLastCellNum();
			localArray1 = new String[ExcelRows][Excelcols];
			HSSFRow row = xlSheet.getRow(rowno);
			for(int i=0;i<ExcelRows;i++){
			HSSFRow row1 = xlSheet.getRow(i);
			for(short j=0;j<Excelcols;j++){
				HSSFCell cell =row1.getCell(j);
				if (cell == null)
				{
				  continue; 
				}
				else if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING)
	            {
				String Value = cell.getStringCellValue();			
				localArray1[i][j] = Value;
	            }
				else if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC)
	            {
					double num = cell.getNumericCellValue();
	                int num1 = Double.valueOf(num).intValue();
	                String num2 = Integer.toString(num1);
	                localArray1[i][j] = num2;
	            }								
			 }
			}
			System.out.println("Completed FetchExceldata");	
			}	
		
		//*------------To Fetch the TC row number from Excel and fetch Data---------*//
		//*------------Created on 12/31/2014------------------------*//
		
		public static int FindTCNumber(String sheet,String Methodname) throws Exception,NumberFormatException {
			try
			{
			File oxlFile = new File(ExcelPath);
			FileInputStream oTestDataStream = new FileInputStream(oxlFile);
			HSSFWorkbook xlWorkBook = new HSSFWorkbook(oTestDataStream);
			HSSFSheet xlSheet = xlWorkBook.getSheet(sheet);
			ExcelRows = xlSheet.getLastRowNum() + 1;
			Excelcols = xlSheet.getRow(0).getLastCellNum();
			localArray2 = new String[ExcelRows][Excelcols];
			System.out.println("The value of ExcelRows is:"+ExcelRows);		
			for(int i=0;i<ExcelRows;i++){			
				HSSFRow row = xlSheet.getRow(i);
				for(Short j=0;j<Excelcols;j++){
					HSSFCell cell =row.getCell(j);
					if (cell == null)
					{
					  
					}
					else if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING)
		            {
					String Value = cell.getStringCellValue();			
					localArray2[i][j] = Value;
		            }
					else if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC)
		            {                
		                double num = cell.getNumericCellValue();
		                int num1 = Double.valueOf(num).intValue();
		                String num2 = Integer.toString(num1);
		                localArray2[i][j] = num2;
		            }
					else if(cell.getCellType() == HSSFCell.CELL_TYPE_BLANK)
		            {		                
						String Value = cell.getStringCellValue();			
						localArray2[i][j] = Value;
		            }
								
				}
						
				}
			
			  for(int i=0;i<ExcelRows;i++)
			  {
			   if(localArray2[i][0].equals(Methodname))
			  {
				return i;					
			  }	
			}
		  }
			catch(Exception e)
			{
				return -1;
			}
			return -1;
		}	
		
		  public static int xmlFetch() throws Exception,NumberFormatException {
			try
			{
			File oxlFile = new File(ExcelPath);
			FileInputStream oTestDataStream = new FileInputStream(oxlFile);
			HSSFWorkbook xlWorkBook = new HSSFWorkbook(oTestDataStream);
			HSSFSheet xlSheet = xlWorkBook.getSheet("TestControl");
			ExcelRows = xlSheet.getLastRowNum() + 1;
			Excelcols = xlSheet.getRow(0).getLastCellNum();
			localArray2 = new String[ExcelRows][Excelcols];
			System.out.println("The value of ExcelRows is:"+ExcelRows);		
			for(int i=0;i<ExcelRows;i++){			
				HSSFRow row = xlSheet.getRow(i);
				for(Short j=0;j<Excelcols;j++){
					HSSFCell cell =row.getCell(j);
					if (cell == null)
					{
					  
					}
					else if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING)
		            {
					String Value = cell.getStringCellValue();			
					localArray2[i][j] = Value;
		            }
					else if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC)
		            {                
		                double num = cell.getNumericCellValue();
		                int num1 = Double.valueOf(num).intValue();
		                String num2 = Integer.toString(num1);
		                localArray2[i][j] = num2;
		            }
					else if(cell.getCellType() == HSSFCell.CELL_TYPE_BLANK)
		            {		                
						String Value = cell.getStringCellValue();			
						localArray2[i][j] = Value;
		            }
								
				}
						
				}
					 
		  }
			catch(Exception e)
			{
				return -1;
			}
			return -1;
		}	
		  
		  public static int rowCount() throws Exception,NumberFormatException {
				try
				{
				File oxlFile = new File(ExcelPath);
				FileInputStream oTestDataStream = new FileInputStream(oxlFile);
				HSSFWorkbook xlWorkBook = new HSSFWorkbook(oTestDataStream);
				HSSFSheet xlSheet = xlWorkBook.getSheet("TestControl");
				ExcelRows = xlSheet.getLastRowNum() + 1;
				return ExcelRows;
				}
				catch(Exception e)
				{
					
				}
				return -1;
			}	
				

			
					
}
