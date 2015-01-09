package Config;

import org.openqa.selenium.WebDriver;

 public class BaseConfig
{	
	//String sample=fetchCell(0,1,0);
	 
	//protected static String url="fetchCell(0,1,0)";//FF:Firefox,IE:Internet Explorer,CH:Chorme Driver 
	//public static String url="https://s3-us-west-1.amazonaws.com/okstudent.ctb.com.s3/launch.html";
	public static WebDriver driver=null;	
	public static XlsReader excel;
	
	public static long TIME_LIMIT=15000;
	//public static String BROWSER="FF";//FF:Firefox,IE:Internet Explorer,CH:Chorme Driver	
	public static String InputPath="C:\\Automation_Framework\\BMT_GAIN\\Test_Data\\TestData.xls";
	public static String ExcelPath="C:\\Automation_Framework\\BMT_GAIN\\Test_Data\\TestData.xls";
	public static String TestCases="C:\\Automation_Framework\\BMT_GAIN\\TestConditions\\Test_Cases.xls";
	public static String ScreenshotsPath="C:\\Automation_Framework\\BMT_GAIN\\Error_Log_Screenshots\\";
	public static String testOutputPath="C:\\Automation_Framework\\BMT_GAIN\\test-output";
	public static String testReportPath="C:\\Automation_Framework\\BMT_GAIN\\Test_Reports\\";
	public static String strResultsFolderPath="C:\\Automation_Framework\\BMT_GAIN\\";
	public static String htmlreport="C:\\Automation_Framework\\BMT_GAIN\\StepWiseResult11262014.html";
	public static String strResultsFolder="C:\\Automation_Framework\\BMT_GAIN\\Screenshots\\";
	public static String testSuiteName="BMT_GAIN";
	
	//Test cases Fetching data
	public static String Path_TestData = "C:\\Automation_Framework\\BMT_GAIN\\TestConditions\\";
	public static String File_TestData = "Test_Cases.xls"; 
	public static String TestNGPath = "C:\\Automation_Framework\\BMT_GAIN\\Test_Data\\TestControl.xls";    
    public static String TestNgXml="C:\\Automation_Framework\\BMT_GAIN\\TestNG.xml";
	
	 
    
}
 
