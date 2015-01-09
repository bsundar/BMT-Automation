package User_actions;
import java.io.File;

import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Listeners;

import static ObjectRepository.ObjectRepository.*;
import static ReusableComponents.commonmethods.*;
import static UIWrappers.UIobjects.clickOn;
import static UIWrappers.UIobjects.enterData;
import static UIWrappers.UIobjects.log;
import static UIWrappers.UIobjects.pause;
import static Config.XlsReader.*;
import ReusableComponents.*;
import UIWrappers.Page;
import static UIWrappers.UIobjects.*;

import org.sikuli.script.Screen;

@Listeners({ReportsUtils.CustomReport.class,ReportsUtils.ReportSetup.class})

public class Useractions extends Page{
	
	static String image1="C:\\Automation_Framework\\BMT_GAIN\\BMT Highligter.png"; 
	
	htmlReport HF = new htmlReport();
 
	@SuppressWarnings("unused")	
    @Test(enabled=false)
	public void f_answeredstatus() throws Exception
		{
		try{
		System.out.print("entered answeredstatus");
		Fetchmethod("Sheet2");
	    int rowno = FindRowno("f_answeredstatus");
	    FetchExceldata(rowno);
		String uname = localArray1[0][0];
		String pwd = localArray1[0][1];
		String acccode = localArray1[0][2];		
		Integer accesscode =Integer.parseInt(acccode);
		String Testname = localArray1[0][3];
		String noofitem1 = localArray1[0][4];
		Integer intitem =Integer.parseInt(noofitem1);
		String response1 = localArray1[0][5];
		Integer  response =Integer.parseInt(response1);	
		int tcn = FindTCNumber("TestCases","AS-1");
		System.out.println("the value is:"+tcn);
		HF.addResultToHTMLFile(""+localArray2[tcn][0],""+localArray2[tcn][1],""+localArray2[tcn][2],""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
		tcn++;		  				
		superAdminLogin(uname,pwd,acccode);  				
		HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
		tcn++;
		HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
		tcn++;
	    Welcomestart(driver);
	    HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
		tcn++;    	
		 
    	for(int i=1;i<intitem+1;i++)
		{   
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("javascript:window.scrollBy(0,8000)");
			itemnavigation(driver, i);	
				
			verifyitemnumber(driver, i);
			blueballno(driver, i);
			answerstatusno(driver, i);			
		}
    	HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
		tcn++;  
		HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");		
		}
		
		catch(Exception e)
		 {
		
			HF.htmlReportFail("''","''","''","''","Aborted Execution","Fail");
		 }	
		}
	
	    @SuppressWarnings("unused")
		@Test(enabled=false)	
		public void f_itemNavigation() throws Exception
		{
		 try
		 {
			Fetchmethod("Sheet2");
		    int rowno = FindRowno("f_itemNavigation");
		    FetchExceldata(rowno);		    		
			String uname = localArray1[0][0];
			String pwd = localArray1[0][1];
			String acccode = localArray1[0][2];
		    Integer accesscode =Integer.parseInt(acccode);
			String Testname = localArray1[0][3];
			String noofitem1 = localArray1[0][4];
			Integer noofitem =Integer.parseInt(noofitem1);
			String response1 = localArray1[0][5];
			Integer  response =Integer.parseInt(response1);	
			int tcn = FindTCNumber("TestCases","AS-1");
			System.out.println("the value is:"+tcn);
			HF.addResultToHTMLFile(""+localArray2[tcn][0],""+localArray2[tcn][1],""+localArray2[tcn][2],""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
			tcn++;		  				
			superAdminLogin(uname,pwd,acccode);  				
			HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
			tcn++;		
			HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
			tcn++;							  
		    Welcomestart(driver);
		    HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
			tcn++;
		
			//Item navigation is verified in below step
			for(int noofitems=2;noofitems<noofitem+1;noofitems++)
			{
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("javascript:window.scrollBy(0,8000)");
				itemnavigation(driver, noofitems);
				verifyitemnumber(driver, noofitems);
			}			
			HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
			tcn++;
			//Item navigation is verified in below step
			for(int noofitems=noofitem-1;noofitems>0;noofitems--)
			{
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("javascript:window.scrollBy(0,8000)");
				itemnavigation(driver, noofitems);
				verifyitemnumber(driver, noofitems);				
			}
			HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
			tcn++;
			HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
		  }
		 
		 catch(Exception e)
		 {
			HF.htmlReportFail("''","''","''","''","Aborted Execution","Fail");
			 
		 }
		}
	@SuppressWarnings("unused") 
	@Test(enabled=false)
		public void f_pauseTest() throws Exception{
		 try
		    {
		    
			 //Reading Data From Excel
			Fetchmethod("Sheet2");
		    int rowno = FindRowno("f_pauseTest");
		    FetchExceldata(rowno);
		    System.out.println("The value of uname is"+localArray1[1][0]);
		    String uname = localArray1[0][0];
			String pwd = localArray1[0][1];
			String acccode = localArray1[0][2];			
			Integer accesscode =Integer.parseInt(acccode);
			String Testname = localArray1[0][3];
			String noofitem1 = localArray1[0][4];
			Integer noofitem =Integer.parseInt(noofitem1);
			String response1 = localArray1[0][5];
			Integer  response =Integer.parseInt(response1);	
			int tcn = FindTCNumber("TestCases","PT-1");
			System.out.println("the value is:"+tcn);
			HF.addResultToHTMLFile(""+localArray2[tcn][0],""+localArray2[tcn][1],""+localArray2[tcn][2],""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
			tcn++;		  				
			superAdminLogin(uname,pwd,acccode);  				
			HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
			tcn++;
			HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
			tcn++;
		    Welcomestart(driver);	
		    HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
			tcn++;
		   
		   	//We are verifying Pause test button
				for(int noofitems=1;noofitems<noofitem+1;noofitems++)
				{
					verifyitemnumber(driver, noofitems);
					pausetest(driver);
					pauselogin(driver);
					verifyitemnumber(driver, noofitems);
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("javascript:window.scrollBy(0,8000)");
					
					if (noofitems<noofitem)
					{
						clickgoon(driver);
					}
					else
						
						finishtest(driver);
										
				}	
				HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
				tcn++;
				HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
			 }
			 catch(Exception e)
			 {			 
			  HF.htmlReportFail("''","''","''","''","Aborted Execution","Fail");				 
			 }

		}
	@SuppressWarnings("unused") 
	@Test(enabled=false)		
		public void f_StopTest() throws Exception
		{			
		    try{	
		    System.out.println("Entered stoptest");
		    Fetchmethod("Sheet2");
		    int rowno = FindRowno("f_StopTest");
		    FetchExceldata(rowno);		       
			String uname = localArray1[0][0];
			String pwd = localArray1[0][1];
			String acccode = localArray1[0][2];
			Integer accesscode =Integer.parseInt(acccode);
			String Testname = localArray1[0][3];
			String noofitem1 = localArray1[0][4];
			Integer noofitem =Integer.parseInt(noofitem1);
			String response1 = localArray1[0][5];
			Integer  response =Integer.parseInt(response1);									
			int tcn = FindTCNumber("TestCases","ST-1");
			System.out.println("the value is:"+tcn);
			HF.addResultToHTMLFile(""+localArray2[tcn][0],""+localArray2[tcn][1],""+localArray2[tcn][2],""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
			tcn++;		  				
			superAdminLogin(uname,pwd,acccode);  				
			HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
			tcn++;
			HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
			tcn++;			
		    Welcomestart(driver);
		    HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
			tcn++;
		   
			for(int noofitems=1;noofitems<noofitem+1;noofitems++)
			{
				verifyitemnumber(driver, noofitems);
				stoptest(driver);
				stopno(driver);
				verifyitemnumber(driver, noofitems);
				
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("javascript:window.scrollBy(0,8000)");
				
				if (noofitems<noofitem)
				{
					clickgoon(driver);
				}
				else					
			finishtest(driver);
				}
			HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
			tcn++;
			HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
			}
		    catch(Exception e)
			 {				
		    	HF.htmlReportFail("''","''","''","''","Aborted Execution","Fail");		 
			 }    

	}
	
	/*--------------------------------------------------------------------------------------*
	 *----------------Created by Dinesh on 12-22-2014--------------------------------------*
	 *----------------Used to check highlighter functionality------------------------------**/
	
	@Test(enabled=false)	
	public void f_highlightScen1() throws Exception
	{
	 try{
		String image1="C:\\Automation_Framework\\BMT_GAIN\\BMT Highligter.png";
	    System.out.println("Entered f_highlightScen1");
		Fetchmethod("Sheet2");
		int rowno = FindRowno("f_highlightScen1");
		FetchExceldata(rowno);
		String uname = localArray1[0][0];
		String pwd = localArray1[0][1];
		String acccode = localArray1[0][2];
		System.out.println("The value of uname is"+uname);
		System.out.println("The value of uname is"+pwd);
		System.out.println("The value of uname is"+acccode);
		
		HF.addResultToHTMLFile(""+fetchCell(0,26,0),""+fetchCell(0,26,1),""+fetchCell(0,26,2),""+fetchCell(0,26,3),""+fetchCell(0,26,4), "Pass");
		superAdminLogin(uname,pwd,acccode);
		HF.addResultToHTMLFile("''","''","''",""+fetchCell(0,27,3),""+fetchCell(0,27,4),"Pass");
		String noofitem1 = localArray1[0][4];
		Integer noofitem =Integer.parseInt(noofitem1);
		String response1 = localArray1[0][5];
		Integer  response =Integer.parseInt(response1);	
		System.out.println("The uname is:"+uname);
		System.out.println("The pwd is:"+pwd);			
		System.out.println("The Testname is:"+noofitem);
		System.out.println("The noofitem is:"+response);
		log("Actual Result: Fetching UserName,Password,Access Code,TestName,noofItems,responses");
		pause(10000);
		
	   Welcomestart(driver);
	   pause(10000);
	   HF.addResultToHTMLFile("''","''","''",""+fetchCell(0,29,3),""+fetchCell(0,29,4),"Pass");
	    
	   
		//Item navigation is verified in below step
		for(int noofitems=1;noofitems<noofitem+1;noofitems++)
		{
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("javascript:window.scrollBy(0,8000)");
			itemnavigation(driver, noofitems);
			verifyitemnumber(driver, noofitems);
			highlight();
			pause(10000);
			verifyHighlighter(image1,noofitems);
		}

	 }		
	 catch(Exception e)
	 {
		HF.htmlReportFail("''","''","''","Highlighter function failed","Highligter not available","Fail"); 
		driver.quit(); 
	 }
	 
	}
 

	 
	 @Test(enabled=false)	
		public void highlightEraser() throws Exception
		{
		 try{
				System.out.println("Entered Mixeditems");
				Fetchmethod("Sheet2");
			    int rowno = FindRowno("MixedItems");
			    FetchExceldata(rowno);
			    String uname = localArray1[0][0];
				String pwd = localArray1[0][1];
				String acccode = localArray1[0][2];
			    System.out.println("The value of uname is"+uname);
			    System.out.println("The value of uname is"+pwd);
			    System.out.println("The value of uname is"+acccode);
			    
			    HF.addResultToHTMLFile(""+fetchCell(0,26,0),""+fetchCell(0,26,1),""+fetchCell(0,26,2),""+fetchCell(0,26,3),""+fetchCell(0,26,4), "Pass");
			    
			    superAdminLogin(uname,pwd,acccode);
			    HF.addResultToHTMLFile("''","''","''",""+fetchCell(0,27,3),""+fetchCell(0,27,4),"Pass");
			String noofitem1 = localArray1[0][4];
			Integer noofitem =Integer.parseInt(noofitem1);
			String response1 = localArray1[0][5];
			Integer  response =Integer.parseInt(response1);	
			System.out.println("The uname is:"+uname);
			System.out.println("The pwd is:"+pwd);			
			System.out.println("The Testname is:"+noofitem);
			System.out.println("The noofitem is:"+response);
			log("Actual Result: Fetching UserName,Password,Access Code,TestName,noofItems,responses");
			
		   Welcomestart(driver);
		   pause(10000);
		   HF.addResultToHTMLFile("''","''","''",""+fetchCell(0,29,3),""+fetchCell(0,29,4),"Pass");
		    
		   
			//Item navigation is verified in below step
			for(int noofitems=1;noofitems<noofitem+1;noofitems++)
			{
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("javascript:window.scrollBy(0,8000)");
				itemnavigation(driver, noofitems);
				verifyitemnumber(driver, noofitems);
				highlight();
				pause(5000);
				System.out.println("Entered Screenshot method");
		   		File scrnsht =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		   		String scenario = "C:\\Automation_Framework\\BMT_GAIN\\"+noofitems;
				File targetFile = new File(scenario+".png");
		   		System.out.println("the path is:"+targetFile);
		   		FileUtils.copyFile(scrnsht, targetFile);  
		   		System.out.println("completed Screenshot method");
				//eraser();
				//@SuppressWarnings("unused")
				Screen screen=new Screen();
				String image1="C:\\Automation_Framework\\BMT_GAIN\\BMT Highligter.png";
				if(screen.exists(image1) != null)
				{
				//screen.click(image1,0);
				screen.click(screen.getLastMatch());
				System.out.println("Image1 is available");
				}
				else
				{
				HF.htmlReportFail("''","''","''","Item#"+noofitems,"Highligter not available","Fail"); 	
				System.out.println("Not available Image1");
				}
				
				/*Screen screen=new Screen();
				screen.exists("image1");*/

			}

		 }		
		 catch(Exception e)
		 {
			HF.htmlReportFail("''","''","''","Highlighter function failed","Highligter not available","Fail"); 
			driver.quit(); 
		 }
		 
		}

		/*--------------------------------------------------------------------------------------*
		 *----------------Created by Dinesh on 12-22-2014--------------------------------------*
		 *--------------*Function for checking Highlighter retaining after item Navigation----**/
	
	@Test(enabled=false)		
	public void f_highlightScen2() throws Exception
	{
	 try{
			System.out.println("Entered f_highlightScen2");
			Fetchmethod("Sheet2");
		    int rowno = FindRowno("f_highlightScen2");
		    FetchExceldata(rowno);
		    String uname = localArray1[0][0];
			String pwd = localArray1[0][1];
			String acccode = localArray1[0][2];
		    System.out.println("The value of uname is"+uname);
		    System.out.println("The value of uname is"+pwd);
		    System.out.println("The value of uname is"+acccode);
		    
		    HF.addResultToHTMLFile(""+fetchCell(0,26,0),""+fetchCell(0,26,1),""+fetchCell(0,26,2),""+fetchCell(0,26,3),""+fetchCell(0,26,4), "Pass");
		    
		    superAdminLogin(uname,pwd,acccode);
		    HF.addResultToHTMLFile("''","''","''",""+fetchCell(0,27,3),""+fetchCell(0,27,4),"Pass");
		String noofitem1 = localArray1[0][4];
		Integer noofitem =Integer.parseInt(noofitem1);
		String response1 = localArray1[0][5];
		Integer  response =Integer.parseInt(response1);	
		System.out.println("The uname is:"+uname);
		System.out.println("The pwd is:"+pwd);			
		System.out.println("The Testname is:"+noofitem);
		System.out.println("The noofitem is:"+response);
		log("Actual Result: Fetching UserName,Password,Access Code,TestName,noofItems,responses");
		
	   Welcomestart(driver);
	   pause(10000);
	   HF.addResultToHTMLFile("''","''","''",""+fetchCell(0,29,3),""+fetchCell(0,29,4),"Pass");
	   
		  
		//Item navigation is verified in below step
		for(int noofitems=1;noofitems<noofitem+1;noofitems++)
		{
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("javascript:window.scrollBy(0,8000)");
			itemnavigation(driver, noofitems);
			verifyitemnumber(driver, noofitems);
			highlight();
			pause(10000);
			verifyHighlighter(image1,noofitems);
		}
		
		for(int noofitems=noofitem-1;noofitems>0;noofitems--)
		{
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("javascript:window.scrollBy(0,8000)");
			itemnavigation(driver, noofitems);
			verifyitemnumber(driver, noofitems);
			verifyHighlighter(image1,noofitems);			
		}

	 }		
	 catch(Exception e)
	 {
		HF.htmlReportFail("''","''","''","Highlighter function failed","Highligter not available","Fail"); 
		driver.quit(); 
	 }
	 
	}
	
	/*--------------------------------------------------------------------------------------*
	 *----------------Created by Dinesh on 12-22-2014--------------------------------------*
	 *--------------Function for checking Highlighter retaining after Pause Test---------**/
	
	@Test(enabled=false)		
	public void f_highlightScen3() throws Exception
	{
	 try{
			System.out.println("Entered Mixeditems");
			Fetchmethod("Sheet2");
		    int rowno = FindRowno("f_highlightScen3");
		    FetchExceldata(rowno);
		    String uname = localArray1[0][0];
			String pwd = localArray1[0][1];
			String acccode = localArray1[0][2];
		    System.out.println("The value of uname is"+uname);
		    System.out.println("The value of uname is"+pwd);
		    System.out.println("The value of uname is"+acccode);
		    
		    HF.addResultToHTMLFile(""+fetchCell(0,26,0),""+fetchCell(0,26,1),""+fetchCell(0,26,2),""+fetchCell(0,26,3),""+fetchCell(0,26,4), "Pass");
		    
		    superAdminLogin(uname,pwd,acccode);
		    HF.addResultToHTMLFile("''","''","''",""+fetchCell(0,27,3),""+fetchCell(0,27,4),"Pass");
		String noofitem1 = localArray1[0][4];
		Integer noofitem =Integer.parseInt(noofitem1);
		String response1 = localArray1[0][5];
		Integer  response =Integer.parseInt(response1);	
		System.out.println("The uname is:"+uname);
		System.out.println("The pwd is:"+pwd);			
		System.out.println("The Testname is:"+noofitem);
		System.out.println("The noofitem is:"+response);
		log("Actual Result: Fetching UserName,Password,Access Code,TestName,noofItems,responses");
		
	   Welcomestart(driver);
	   pause(10000);
	   HF.addResultToHTMLFile("''","''","''",""+fetchCell(0,29,3),""+fetchCell(0,29,4),"Pass");
	   
		  
		//Item navigation is verified in below step
		for(int noofitems=1;noofitems<noofitem+1;noofitems++)
		{
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("javascript:window.scrollBy(0,8000)");
			itemnavigation(driver, noofitems);
			verifyitemnumber(driver, noofitems);
			highlight();
			pause(15000);			
			verifyHighlighter(image1,noofitems);			
			pausetest(driver);
			enterData(password,pwd);
			pauselogin(driver);
			pause(15000);
			verifyHighlighter(image1,noofitems);
			verifyitemnumber(driver, noofitems);
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("javascript:window.scrollBy(0,8000)");
			
			if (noofitems<noofitem)
			{
				clickgoon(driver);
			}
			else
				
				finishtest(driver);
		}
		
		/*for(int noofitems=noofitem-1;noofitems>0;noofitems--)
		{
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("javascript:window.scrollBy(0,8000)");
			itemnavigation(driver, noofitems);
			verifyitemnumber(driver, noofitems);
			verifyHighlighter(image1,noofitems);			
		}*/

	 }		
	 catch(Exception e)
	 {
		HF.htmlReportFail("''","''","''","Highlighter function failed","Highligter not available","Fail"); 
		driver.quit(); 
	 }
	 
	}
	
	/*--------------------------------------------------------------------------------------*
	 *----------------Created by Dinesh on 12-22-2014--------------------------------------*
	 *--------------Function for checking Highlighter retaining after Stop Test---------**/

     @Test(enabled=false)		
     public void f_highlightScen4() throws Exception
    {
    try{
     System.out.println("Entered f_highlightScen4");
     Fetchmethod("Sheet2");
     int rowno = FindRowno("f_highlightScen4");
     FetchExceldata(rowno);
     String uname = localArray1[0][0];
     String pwd = localArray1[0][1];
     String acccode = localArray1[0][2];
     System.out.println("The value of uname is"+uname);
     System.out.println("The value of uname is"+pwd);
     System.out.println("The value of uname is"+acccode);

    HF.addResultToHTMLFile(""+fetchCell(0,26,0),""+fetchCell(0,26,1),""+fetchCell(0,26,2),""+fetchCell(0,26,3),""+fetchCell(0,26,4), "Pass");
    superAdminLogin(uname,pwd,acccode);
    HF.addResultToHTMLFile("''","''","''",""+fetchCell(0,27,3),""+fetchCell(0,27,4),"Pass");
    String noofitem1 = localArray1[0][4];
    Integer noofitem =Integer.parseInt(noofitem1);
    String response1 = localArray1[0][5];
    Integer  response =Integer.parseInt(response1);	
    System.out.println("The uname is:"+uname);
    System.out.println("The pwd is:"+pwd);			
    System.out.println("The Testname is:"+noofitem);
    System.out.println("The noofitem is:"+response);
    log("Actual Result: Fetching UserName,Password,Access Code,TestName,noofItems,responses");

    Welcomestart(driver);
    pause(10000);
    HF.addResultToHTMLFile("''","''","''",""+fetchCell(0,29,3),""+fetchCell(0,29,4),"Pass");


   for(int noofitems=1;noofitems<noofitem+1;noofitems++)
   {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("javascript:window.scrollBy(0,8000)");
    itemnavigation(driver, noofitems);
    verifyitemnumber(driver, noofitems);
    highlight();
    pause(15000);			
    verifyHighlighter(image1,noofitems);
    pause(15000);			
    stoptest(driver);
	stopno(driver);
	verifyitemnumber(driver, noofitems);
	pause(15000);	
	verifyHighlighter(image1,noofitems);
	
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("javascript:window.scrollBy(0,8000)");
	
	if (noofitems<noofitem)
	{
		clickgoon(driver);
	}
	else
		
		finishtest(driver);

    }

  }		
   catch(Exception e)
   {
     HF.htmlReportFail("''","''","''","Highlighter function failed","Highligter not available","Fail"); 
     driver.quit(); 
    }
  }	
     
     /*--------------------------------------------------------------------------------------*
 	 *----------------Created by Dinesh on 12-23-2014----------------------------------------*
 	 *----------------Used to check highlighter Eraser functionality------------------------**/
 	
 	@Test(enabled=false)	
 	public void f_highlightEraserScen1() throws Exception
 	{
 	 try{
 		//String image1="C:\\Users\\t0043920\\Desktop\\BMT Highligter.png";
 		//String image2="C:\\Users\\t0043920\\Desktop\\Image2.png";
 	    System.out.println("Entered f_highlightEraserScen1");
 		Fetchmethod("Sheet2");
 		int rowno = FindRowno("f_highlightEraserScen1");
 		FetchExceldata(rowno);
 		String uname = localArray1[0][0];
 		String pwd = localArray1[0][1];
 		String acccode = localArray1[0][2];
 		System.out.println("The value of uname is"+uname);
 		System.out.println("The value of uname is"+pwd);
 		System.out.println("The value of uname is"+acccode);
 		
 		HF.addResultToHTMLFile(""+fetchCell(0,26,0),""+fetchCell(0,26,1),""+fetchCell(0,26,2),""+fetchCell(0,26,3),""+fetchCell(0,26,4), "Pass");
 		superAdminLogin(uname,pwd,acccode);
 		HF.addResultToHTMLFile("''","''","''",""+fetchCell(0,27,3),""+fetchCell(0,27,4),"Pass");
 		String noofitem1 = localArray1[0][4];
 		Integer noofitem =Integer.parseInt(noofitem1);
 		String response1 = localArray1[0][5];
 		Integer  response =Integer.parseInt(response1);	
 		System.out.println("The uname is:"+uname);
 		System.out.println("The pwd is:"+pwd);			
 		System.out.println("The Testname is:"+noofitem);
 		System.out.println("The noofitem is:"+response);
 		log("Actual Result: Fetching UserName,Password,Access Code,TestName,noofItems,responses");
 		
 	   Welcomestart(driver);
 	   pause(10000);
 	   HF.addResultToHTMLFile("''","''","''",""+fetchCell(0,29,3),""+fetchCell(0,29,4),"Pass");
 	    
 	   
 		//Item navigation is verified in below step
 		for(int noofitems=1;noofitems<noofitem+1;noofitems++)
 		{
 			JavascriptExecutor js = (JavascriptExecutor) driver;
 			js.executeScript("javascript:window.scrollBy(0,8000)");
 			itemnavigation(driver, noofitems);
 			verifyitemnumber(driver, noofitems);
 			highlight();
 			pause(15000);
 			eraser(image1);
 			pause(15000);
 			verifyHighlighterNo(image1,noofitems);
 		}

 	 }		
 	 catch(Exception e)
 	 {
 		HF.htmlReportFail("''","''","''","Highlighter function failed","Highligter not available","Fail"); 
 		driver.quit(); 
 	 }
 	 
 	}
  
 	/*--------------------------------------------------------------------------------------*
	 *----------------Created by Dinesh on 12-23-2014--------------------------------------*
	 *--------------*Function for checking Highlighter retaining after item Navigation----**/

          @Test(enabled=false)		
        public void f_highlightEraserScen2() throws Exception
        {
         try{
		System.out.println("Entered f_highlightEraserScen2");
		Fetchmethod("Sheet2");
	    int rowno = FindRowno("f_highlightEraserScen2");
	    FetchExceldata(rowno);
	    String uname = localArray1[0][0];
		String pwd = localArray1[0][1];
		String acccode = localArray1[0][2];
	    System.out.println("The value of uname is"+uname);
	    System.out.println("The value of uname is"+pwd);
	    System.out.println("The value of uname is"+acccode);
	    
	    HF.addResultToHTMLFile(""+fetchCell(0,26,0),""+fetchCell(0,26,1),""+fetchCell(0,26,2),""+fetchCell(0,26,3),""+fetchCell(0,26,4), "Pass");
	    
	    superAdminLogin(uname,pwd,acccode);
	    HF.addResultToHTMLFile("''","''","''",""+fetchCell(0,27,3),""+fetchCell(0,27,4),"Pass");
	    String noofitem1 = localArray1[0][4];
	    Integer noofitem =Integer.parseInt(noofitem1);
	    String response1 = localArray1[0][5];
	    Integer  response =Integer.parseInt(response1);	
	    System.out.println("The uname is:"+uname);
	    System.out.println("The pwd is:"+pwd);			
	    System.out.println("The Testname is:"+noofitem);
	    System.out.println("The noofitem is:"+response);
	    log("Actual Result: Fetching UserName,Password,Access Code,TestName,noofItems,responses");
	
        Welcomestart(driver);
        pause(10000);
        HF.addResultToHTMLFile("''","''","''",""+fetchCell(0,29,3),""+fetchCell(0,29,4),"Pass");
   
	  
	   //Item navigation is verified in below step
	    for(int noofitems=1;noofitems<noofitem+1;noofitems++)
     	{
	    	JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("javascript:window.scrollBy(0,8000)");
		    itemnavigation(driver, noofitems);
		    verifyitemnumber(driver, noofitems);
		    highlight();
		    pause(15000);
 			eraser(image1);
 			pause(15000);
 			verifyHighlighterNo(image1,noofitems);
	  }
	
	 for(int noofitems=noofitem-1;noofitems>0;noofitems--)
	 {
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("javascript:window.scrollBy(0,8000)");
	     itemnavigation(driver, noofitems);
		 verifyitemnumber(driver, noofitems);
		 verifyHighlighterNo(image1,noofitems);			
	 }

  }		
    catch(Exception e)
    {
    	HF.htmlReportFail("''","''","''","Highlighter function failed","Highligter not available","Fail"); 
	   driver.quit(); 
    }
 
 }

/*--------------------------------------------------------------------------------------*
 *----------------Created by Dinesh on 12-23-2014--------------------------------------*
 *--------------Function for checking Highlighter retaining after Pause Test---------**/

         @Test(enabled=false)		
         public void f_highlightEraserScen3() throws Exception
         {
         try{
		    System.out.println("Entered Mixeditems");
		    Fetchmethod("Sheet2");
	        int rowno = FindRowno("f_highlightScen3");
	        FetchExceldata(rowno);
	        String uname = localArray1[0][0];
		    String pwd = localArray1[0][1];
		    String acccode = localArray1[0][2];
	        System.out.println("The value of uname is"+uname);
	    System.out.println("The value of uname is"+pwd);
	    System.out.println("The value of uname is"+acccode);
	    
	    HF.addResultToHTMLFile(""+fetchCell(0,26,0),""+fetchCell(0,26,1),""+fetchCell(0,26,2),""+fetchCell(0,26,3),""+fetchCell(0,26,4), "Pass");
	    
	    superAdminLogin(uname,pwd,acccode);
	    HF.addResultToHTMLFile("''","''","''",""+fetchCell(0,27,3),""+fetchCell(0,27,4),"Pass");
	String noofitem1 = localArray1[0][4];
	Integer noofitem =Integer.parseInt(noofitem1);
	String response1 = localArray1[0][5];
	Integer  response =Integer.parseInt(response1);	
	System.out.println("The uname is:"+uname);
	System.out.println("The pwd is:"+pwd);			
	System.out.println("The Testname is:"+noofitem);
	System.out.println("The noofitem is:"+response);
	log("Actual Result: Fetching UserName,Password,Access Code,TestName,noofItems,responses");
	
   Welcomestart(driver);
   pause(10000);
   HF.addResultToHTMLFile("''","''","''",""+fetchCell(0,29,3),""+fetchCell(0,29,4),"Pass");
   
	  
	//Item navigation is verified in below step
	for(int noofitems=1;noofitems<noofitem+1;noofitems++)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(0,8000)");
		itemnavigation(driver, noofitems);
		verifyitemnumber(driver, noofitems);
		highlight();
	    pause(15000);
		eraser(image1);
		pause(15000);
		verifyHighlighterNo(image1,noofitems);
		
		pausetest(driver);
		enterData(password,pwd);
		pauselogin(driver);
		pause(10000);
		verifyHighlighterNo(image1,noofitems);
		verifyitemnumber(driver, noofitems);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("javascript:window.scrollBy(0,8000)");
		
		if (noofitems<noofitem)
		{
			clickgoon(driver);
		}
		else
			
			finishtest(driver);
	}
	
	/*for(int noofitems=noofitem-1;noofitems>0;noofitems--)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(0,8000)");
		itemnavigation(driver, noofitems);
		verifyitemnumber(driver, noofitems);
		verifyHighlighter(image1,noofitems);			
	}*/

 }		
 catch(Exception e)
 {
	HF.htmlReportFail("''","''","''","Highlighter function failed","Highligter not available","Fail"); 
	driver.quit(); 
 }
 
}

/*--------------------------------------------------------------------------------------*
 *----------------Created by Dinesh on 12-23-2014--------------------------------------*
 *--------------Function for checking Highlighter retaining after Stop Test---------**/

 @Test(enabled=false)		
 public void f_highlightEraserScen4() throws Exception
{
try{
 System.out.println("Entered f_highlightScen4");
 Fetchmethod("Sheet2");
 int rowno = FindRowno("f_highlightScen4");
 FetchExceldata(rowno);
 String uname = localArray1[0][0];
 String pwd = localArray1[0][1];
 String acccode = localArray1[0][2];
 System.out.println("The value of uname is"+uname);
 System.out.println("The value of uname is"+pwd);
 System.out.println("The value of uname is"+acccode);

HF.addResultToHTMLFile(""+fetchCell(0,26,0),""+fetchCell(0,26,1),""+fetchCell(0,26,2),""+fetchCell(0,26,3),""+fetchCell(0,26,4), "Pass");
superAdminLogin(uname,pwd,acccode);
HF.addResultToHTMLFile("''","''","''",""+fetchCell(0,27,3),""+fetchCell(0,27,4),"Pass");
String noofitem1 = localArray1[0][4];
Integer noofitem =Integer.parseInt(noofitem1);
String response1 = localArray1[0][5];
Integer  response =Integer.parseInt(response1);	
System.out.println("The uname is:"+uname);
System.out.println("The pwd is:"+pwd);			
System.out.println("The Testname is:"+noofitem);
System.out.println("The noofitem is:"+response);
log("Actual Result: Fetching UserName,Password,Access Code,TestName,noofItems,responses");

Welcomestart(driver);
pause(10000);
HF.addResultToHTMLFile("''","''","''",""+fetchCell(0,29,3),""+fetchCell(0,29,4),"Pass");


for(int noofitems=1;noofitems<noofitem+1;noofitems++)
{
JavascriptExecutor js = (JavascriptExecutor) driver;
js.executeScript("javascript:window.scrollBy(0,8000)");
itemnavigation(driver, noofitems);
verifyitemnumber(driver, noofitems);
highlight();
pause(15000);
eraser(image1);
pause(15000);
verifyHighlighterNo(image1,noofitems);

pause(10000);
stoptest(driver);
stopno(driver);
pause(10000);
verifyitemnumber(driver, noofitems);	
verifyHighlighterNo(image1,noofitems);

JavascriptExecutor js1 = (JavascriptExecutor) driver;
js1.executeScript("javascript:window.scrollBy(0,8000)");

if (noofitems<noofitem)
{
	clickgoon(driver);
}
else
	
	finishtest(driver);

}

}		
catch(Exception e)
{
 HF.htmlReportFail("''","''","''","Highlighter function failed","Highligter not available","Fail"); 
 driver.quit(); 
}
}	
 
    /*--------------------------------------------------------------------------------------*
	 *----------------Created by Dinesh on 12-24-2014--------------------------------------*
	 *--------------*Function for checking Mark for Review retaining after item Navigation----**/

     //@Test(enabled=true)	
     @Test
	 public void f_markForReviewScen1() throws Exception
	  {
	   try{
		System.out.println("Entered f_markForReviewScen1");
		Fetchmethod("Sheet2");
		int rowno = FindRowno("f_markForReviewScen1");
		FetchExceldata(rowno);
		String uname = localArray1[0][0];
		String pwd = localArray1[0][1];
		String acccode = localArray1[0][2];
		System.out.println("The value of uname is"+uname);
		System.out.println("The value of uname is"+pwd);
		System.out.println("The value of uname is"+acccode);
		int tcn = FindTCNumber("TestCases","MR-1");	
		System.out.println("the value is:"+tcn);
				
		superAdminLogin(uname,pwd,acccode);
		HF.addResultToHTMLFile(""+localArray2[tcn][0],""+localArray2[tcn][1],""+localArray2[tcn][2],""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
		tcn++;			
		
		String noofitem1 = localArray1[0][4];
		Integer noofitem =Integer.parseInt(noofitem1);
		String response1 = localArray1[0][5];
		Integer  response =Integer.parseInt(response1);	
		System.out.println("The Testname is:"+noofitem);
		System.out.println("The noofitem is:"+response);
				
	    Welcomestart(driver);
	    pause(10000);
	    HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
		tcn++;	   

		for(int noofitems=1;noofitems<noofitem+1;noofitems++)
		{
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("javascript:window.scrollBy(0,8000)");
			itemnavigation(driver, noofitems);
			verifyitemnumber(driver, noofitems);
			clickOn(markForReview);			
			verifyYellowFilledForm(noofitems);
			verifyUnmarkForReview(noofitems);						
		}
		HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
		tcn++;
		HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
		tcn++;
		HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
	 }		
	 catch(Exception e)
	 {
		HF.htmlReportFail("''","''","''","MarkforReview failed","MarkforReview failed","Fail"); 
		driver.quit(); 
	 }
	 
	}

	/*--------------------------------------------------------------------------------------*
	 *----------------Created by Dinesh on 12-24-2014--------------------------------------*
	 *--------------*Function for checking Mark for Review retaining after item Navigation----**/

       //@Test(enabled=true)		
     @Test
     public void f_markForReviewScen2() throws Exception
     {
      try{
		System.out.println("Entered f_markForReviewScen2");
		Fetchmethod("Sheet2");
	    int rowno = FindRowno("f_markForReviewScen2");
	    FetchExceldata(rowno);
	    String uname = localArray1[0][0];
		String pwd = localArray1[0][1];
		String acccode = localArray1[0][2];
	    System.out.println("The value of uname is"+uname);
	    System.out.println("The value of uname is"+pwd);
	    System.out.println("The value of uname is"+acccode);
	    int tcn = FindTCNumber("TestCases","MR-2");	
		System.out.println("the value is:"+tcn);
	   	    
	    superAdminLogin(uname,pwd,acccode);
	    HF.addResultToHTMLFile(""+localArray2[tcn][0],""+localArray2[tcn][1],""+localArray2[tcn][2],""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
		tcn++;
	    String noofitem1 = localArray1[0][4];
	    Integer noofitem =Integer.parseInt(noofitem1);
	    String response1 = localArray1[0][5];
	    Integer  response =Integer.parseInt(response1);	
	    System.out.println("The uname is:"+uname);
	    System.out.println("The pwd is:"+pwd);			
	    System.out.println("The Testname is:"+noofitem);
	    System.out.println("The noofitem is:"+response);
	    	
        Welcomestart(driver);
        HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
		tcn++;
        pause(10000);
        

	  
	   //Item navigation is verified in below step
	    for(int noofitems=1;noofitems<noofitem+1;noofitems++)
     {
	    	JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("javascript:window.scrollBy(0,8000)");
		    itemnavigation(driver, noofitems);
		    verifyitemnumber(driver, noofitems);  
			clickOn(markForReview);
			verifyYellowFilledForm(noofitems);
			verifyUnmarkForReview(noofitems);		    
	  }
	    HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
		tcn++;
		HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
		tcn++;
	
	 for(int noofitems=noofitem-1;noofitems>0;noofitems--)
	 {
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("javascript:window.scrollBy(0,8000)");
	     itemnavigation(driver, noofitems);
		 verifyitemnumber(driver, noofitems);
		 JavascriptExecutor js1 = (JavascriptExecutor) driver;
		 js1.executeScript("javascript:window.scrollBy(0,8000)");
		 verifyUnmarkForReview(noofitems);
		 verifyYellowFilledForm(noofitems);
	 }
	 
	 HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
	 tcn++;
	 HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
	 tcn++;
	 HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");	 
 }		
      catch(Exception e)
      {
    	  HF.htmlReportFail("''","''","''","MarkforReview function failed","MarkforReview not available","Fail"); 
    	  driver.quit(); 
      }

     }

/*--------------------------------------------------------------------------------------*
*----------------Created by Dinesh on 12-24-2014--------------------------------------*
*--------------Function for checking Mark for Review retaining after Pause Test---------**/

      //@Test(enabled=true)
     @Test
      public void f_markForReviewScen3() throws Exception
      {
      try{
		    System.out.println("Entered f_markForReviewScen3");
		    Fetchmethod("Sheet2");
	        int rowno = FindRowno("f_markForReviewScen3");
	        FetchExceldata(rowno);
	        String uname = localArray1[0][0];
		    String pwd = localArray1[0][1];
		    String acccode = localArray1[0][2];
	        int tcn = FindTCNumber("TestCases","MR-3");	
			System.out.println("the value is:"+tcn); 	    
	        superAdminLogin(uname,pwd,acccode);
	        HF.addResultToHTMLFile(""+localArray2[tcn][0],""+localArray2[tcn][1],""+localArray2[tcn][2],""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
			tcn++;
	    
	     String noofitem1 = localArray1[0][4];
	     Integer noofitem =Integer.parseInt(noofitem1);
	     Welcomestart(driver);
	     HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
		 tcn++;
	     pause(10000);
     
	     //Item navigation is verified in below step
	     for(int noofitems=1;noofitems<noofitem+1;noofitems++)
	     {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(0,8000)");
		itemnavigation(driver, noofitems);
		verifyitemnumber(driver, noofitems);
		
		clickOn(markForReview);
		verifyYellowFilledForm(noofitems);
		verifyUnmarkForReview(noofitems);	
			
		pausetest(driver);
		enterData(password,pwd);
		pauselogin(driver);
		pause(10000);
		
		verifyitemnumber(driver, noofitems);
		verifyYellowFilledForm(noofitems);
		verifyUnmarkForReview(noofitems);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("javascript:window.scrollBy(0,8000)");
		
		if (noofitems<noofitem)
		{
			clickgoon(driver);
		}
		else
			
			finishtest(driver);
	  }
	     HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
		 tcn++;   
		 HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
	     tcn++;
	     HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
		 tcn++;   
		 HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
	     tcn++;
	     HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
		 tcn++;   
		 HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
	     tcn++;
  }		
      catch(Exception e)
     {
	  HF.htmlReportFail("''","''","''","Highlighter function failed","Highligter not available","Fail"); 
	  driver.quit(); 
    }
}

/*--------------------------------------------------------------------------------------*
*----------------Created by Dinesh on 12-24-2014--------------------------------------*
*--------------Function for checking Mark for Review retaining after Stop Test---------**/

      //@Test(enabled=true)
     @Test
     public void f_markForReviewScen4() throws Exception 
     {
      try{ 
          System.out.println("Entered f_markForReviewScen4");
          Fetchmethod("Sheet2");
          int rowno = FindRowno("f_markForReviewScen4");
          FetchExceldata(rowno);
          String uname = localArray1[0][0];
          String pwd = localArray1[0][1];
          String acccode = localArray1[0][2];
          int tcn = FindTCNumber("TestCases","MR-4");	
		  System.out.println("the value is:"+tcn);

		  superAdminLogin(uname,pwd,acccode);
		  HF.addResultToHTMLFile(""+localArray2[tcn][0],""+localArray2[tcn][1],""+localArray2[tcn][2],""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
		  tcn++;
		  String noofitem1 = localArray1[0][4];
		  Integer noofitem =Integer.parseInt(noofitem1);
		  String response1 = localArray1[0][5];
		  Integer  response =Integer.parseInt(response1);	
		  System.out.println("The uname is:"+uname);
		  System.out.println("The pwd is:"+pwd);			
		  System.out.println("The Testname is:"+noofitem);
		  System.out.println("The noofitem is:"+response);
		  log("Actual Result: Fetching UserName,Password,Access Code,TestName,noofItems,responses");

		  Welcomestart(driver);
		  HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
		  tcn++;
		  pause(10000);
		  
		  for(int noofitems=1;noofitems<noofitem+1;noofitems++)
			{
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("javascript:window.scrollBy(0,8000)");
			itemnavigation(driver, noofitems);
			verifyitemnumber(driver, noofitems);
			clickOn(markForReview);
			verifyYellowFilledForm(noofitems);
			verifyUnmarkForReview(noofitems);	
				
			pause(10000);
			stoptest(driver);
			stopno(driver);
			pause(10000);
			verifyitemnumber(driver, noofitems);
			verifyYellowFilledForm(noofitems);
			verifyUnmarkForReview(noofitems);	
			
			
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("javascript:window.scrollBy(0,8000)");
			
			if (noofitems<noofitem)
			{
				clickgoon(driver);
			}
			else
				
				finishtest(driver);
			
			}
			
			 HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
		     tcn++;
		     HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
			 tcn++;   
			 HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
		     tcn++;
		     HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
			 tcn++;   
			 HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
			 tcn++;   
			 HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");	
			}		
			catch(Exception e)
			{
			HF.htmlReportFail("''","''","''","Highlighter function failed","Highligter not available","Fail"); 
			driver.quit(); 
			}
			}	
      
       /*---------------------------------------------------------------------------------------------------------*
	  	*----------------Created by Dinesh on 12-29-2014-----------------------------------------------------------*
	  	*--------------Function for checking for Item count of Mark for Review after clicking Stop button ---------**/

	  	      //@Test(enabled=true)
     			@Test
	  	     public void f_markForReviewScen6() throws Exception 
	  	     {
	  	      try{ 
	  	          System.out.println("Entered f_markForReviewScen6");
	  	          Fetchmethod("Sheet2");
	  	          int rowno = FindRowno("f_markForReviewScen6");
	  	          FetchExceldata(rowno);
	  	          String uname = localArray1[0][0];
	  	          String pwd = localArray1[0][1];
	  	          String acccode = localArray1[0][2];
	  	          int tcn = FindTCNumber("TestCases","MR-6");	
	  		      System.out.println("the value is:"+tcn);
	  				superAdminLogin(uname,pwd,acccode);
	  				String noofitem1 = localArray1[0][4];
	  				Integer noofitem =Integer.parseInt(noofitem1);
	  					
	  				Welcomestart(driver);
	  				HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
	  			    tcn++;
	  				pause(10000);
	  				
	  				for(int noofitems=1;noofitems<noofitem+1;noofitems++)
	  				{
	  				JavascriptExecutor js = (JavascriptExecutor) driver;
	  				js.executeScript("javascript:window.scrollBy(0,8000)");
	  				itemnavigation(driver, noofitems);
	  				verifyitemnumber(driver, noofitems);
	  				clickOn(markForReview);
	  				verifyYellowFilledForm(noofitems);
	  				verifyUnmarkForReview(noofitems);	
	  				pause(10000);
	  				stoptest(driver);
	  				verifyMarkReviewCount(driver,noofitems);
	  				stopno(driver);	
	  					  			
	  				JavascriptExecutor js1 = (JavascriptExecutor) driver;
	  				js1.executeScript("javascript:window.scrollBy(0,8000)");
	  				
	  				if (noofitems<noofitem)
	  				{
	  					clickgoon(driver);
	  				}
	  				else	  					
	  					finishtest(driver);	  				
	  				}	  				
	  			HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
	  			tcn++;
	  			HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
	  			tcn++;   
	  			HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
	  			tcn++;
	  			HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
	  			tcn++;   
	  			HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");	  				 
	  		   }		
	  		catch(Exception e)
	  			{
	  		    	HF.htmlReportFail("''","''","''","Mark For Review Failed","Mark For Review Failed","Fail"); 
	  				driver.quit(); 
	  				}
	  				}	



      
       
       /*--------------------------------------------------------------------------------------*
		 *----------------Created by Dinesh on 12-24-2014--------------------------------------*
		 *--------------*Function for checking UnMark for Review retaining after item Navigation----**/

	     //@Test(enabled=true)
     	@Test
		 public void f_unMarkForReviewScen1() throws Exception
		  {
		   try{
		    System.out.println("Entered f_unMarkForReviewScen1");
			Fetchmethod("Sheet2");
			int rowno = FindRowno("f_unMarkForReviewScen1");
			FetchExceldata(rowno);
			String uname = localArray1[0][0];
			String pwd = localArray1[0][1];
			String acccode = localArray1[0][2];
			System.out.println("The value of uname is"+uname);
			System.out.println("The value of uname is"+pwd);
			System.out.println("The value of uname is"+acccode);
			int tcn = FindTCNumber("TestCases","UMR-1");	
			System.out.println("the value is:"+tcn);
			
		    superAdminLogin(uname,pwd,acccode);
		    HF.addResultToHTMLFile(""+localArray2[tcn][0],""+localArray2[tcn][1],""+localArray2[tcn][2],""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
			tcn++;
			
			String noofitem1 = localArray1[0][4];
			Integer noofitem =Integer.parseInt(noofitem1);
						
		    Welcomestart(driver);
		    pause(10000);
		    HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
  			tcn++;
		    	   

			for(int noofitems=1;noofitems<noofitem+1;noofitems++)
			{
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("javascript:window.scrollBy(0,8000)");
				itemnavigation(driver, noofitems);
				verifyitemnumber(driver, noofitems);
				clickOn(markForReview);
				verifyYellowFilledForm(noofitems);
				verifyUnmarkForReview(noofitems);						
				pause(10000);
				clickOn(markForReview);
				verifyYellowFilledFormNo(noofitems);
				verifyMarkForReview(noofitems);				
			 }			
			HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
  			tcn++;
  			HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
  			tcn++;   
  			HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
  			tcn++;
  			HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
  			tcn++;   
  			HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");			
		  }		
		 catch(Exception e)
		 {
			HF.htmlReportFail("''","''","''","UnMark For Review Scen1 failed","UnMark For Review Scen1 failed","Fail"); 
			driver.quit(); 
		 }
		 
		}

		/*--------------------------------------------------------------------------------------*
		 *----------------Created by Dinesh on 12-24-2014--------------------------------------*
		 *--------------*Function for checking UnMark for Review retaining after item Navigation----**/

	     //@Test(enabled=true)
     	@Test
	     public void f_unMarkForReviewScen2() throws Exception
	     {
	      try{
			System.out.println("Entered f_unMarkForReviewScen2");
			Fetchmethod("Sheet2");
		    int rowno = FindRowno("f_unMarkForReviewScen2");
		    FetchExceldata(rowno);
		    String uname = localArray1[0][0];
			String pwd = localArray1[0][1];
			String acccode = localArray1[0][2];
		    int tcn = FindTCNumber("TestCases","UMR-2");	
			System.out.println("the value is:"+tcn);
		   
		    superAdminLogin(uname,pwd,acccode);
		    HF.addResultToHTMLFile(""+localArray2[tcn][0],""+localArray2[tcn][1],""+localArray2[tcn][2],""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
			tcn++;		    
		    String noofitem1 = localArray1[0][4];
		    Integer noofitem =Integer.parseInt(noofitem1);
		    Welcomestart(driver);
	        pause(10000);
	        HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
  			tcn++;
	        

		  
		   //Item navigation is verified in below step
		    for(int noofitems=1;noofitems<noofitem+1;noofitems++)
	       {
		    	JavascriptExecutor js = (JavascriptExecutor) driver;
			    js.executeScript("javascript:window.scrollBy(0,8000)");
			    itemnavigation(driver, noofitems);
			    verifyitemnumber(driver, noofitems);  
				clickOn(markForReview);
				verifyYellowFilledForm(noofitems);
				verifyUnmarkForReview(noofitems);	
				clickOn(markForReview);
				verifyYellowFilledFormNo(noofitems);
				verifyMarkForReview(noofitems);
		   }
		    HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
  			tcn++;
  			HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
  			tcn++;
		
		 for(int noofitems=noofitem-1;noofitems>0;noofitems--)
		 {
			 JavascriptExecutor js = (JavascriptExecutor) driver;
			 js.executeScript("javascript:window.scrollBy(0,8000)");
		     itemnavigation(driver, noofitems);
			 verifyitemnumber(driver, noofitems);	
			 verifyYellowFilledFormNo(noofitems);
			 verifyMarkForReview(noofitems);			 
		 }
		    HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
			tcn++;
			HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
			tcn++;
			HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
			tcn++;
	 }		
	 catch(Exception e)
	 {
	 	HF.htmlReportFail("''","''","''","UnMark For Review Scen2 failed","UnMark For Review Scen2 failed","Fail"); 
		driver.quit(); 
	 }

	}

	/*--------------------------------------------------------------------------------------*
	*----------------Created by Dinesh on 12-24-2014--------------------------------------*
	*--------------Function for checking UnMark for Review retaining after Pause Test---------**/

	      //@Test(enabled=true)
     	@Test
	      public void f_unMarkForReviewScen3() throws Exception
	      {
	      try{
			    System.out.println("Entered f_unMarkForReviewScen3");
			    Fetchmethod("Sheet2");
		        int rowno = FindRowno("f_unMarkForReviewScen3");
		        FetchExceldata(rowno);
		        String uname = localArray1[0][0];
			    String pwd = localArray1[0][1];
			    String acccode = localArray1[0][2];
			    int tcn = FindTCNumber("TestCases","UMR-3");	
				System.out.println("the value is:"+tcn);
		        	    
			    superAdminLogin(uname,pwd,acccode);
			    HF.addResultToHTMLFile(""+localArray2[tcn][0],""+localArray2[tcn][1],""+localArray2[tcn][2],""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
				tcn++;
		        String noofitem1 = localArray1[0][4];
		        Integer noofitem =Integer.parseInt(noofitem1);		        		
		        Welcomestart(driver);
		        pause(10000);		 
		        HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
				tcn++;
				//Item navigation is verified in below step
		  for(int noofitems=1;noofitems<noofitem+1;noofitems++)
		   {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("javascript:window.scrollBy(0,8000)");
			itemnavigation(driver, noofitems);
			verifyitemnumber(driver, noofitems);			
			clickOn(markForReview);
			verifyYellowFilledForm(noofitems);
			verifyUnmarkForReview(noofitems);
			pause(10000);
			clickOn(markForReview);
			verifyYellowFilledFormNo(noofitems);
			verifyMarkForReview(noofitems);				
			pausetest(driver);
			enterData(password,pwd);
			pauselogin(driver);
			pause(10000);			
			verifyitemnumber(driver, noofitems);
			verifyYellowFilledFormNo(noofitems);
			verifyMarkForReview(noofitems);
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("javascript:window.scrollBy(0,8000)");
			
			if (noofitems<noofitem)
			{
				clickgoon(driver);
			}
			else
				
				finishtest(driver);
		}		
		HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
		tcn++;
		HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
		tcn++;
		HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
		tcn++;
		HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
		tcn++;
		HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
		tcn++;
		HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
		tcn++;
 	}		
	catch(Exception e)
	{
		HF.htmlReportFail("''","''","''","UnMark For Review Scen3 failed","UnMark For Review Scen3 failed","Fail"); 
		driver.quit(); 
	}

	}

	/*--------------------------------------------------------------------------------------*
	*----------------Created by Dinesh on 12-24-2014--------------------------------------*
	*--------------Function for checking UnMark for Review retaining after Stop Test---------**/

	      //@Test(enabled=true)
     	@Test
	     public void f_unMarkForReviewScen4() throws Exception 
	     {
	      try{ 
	            System.out.println("Entered f_unMarkForReviewScen4");
	            Fetchmethod("Sheet2");
	            int rowno = FindRowno("f_unMarkForReviewScen4");
	            FetchExceldata(rowno);
	            String uname = localArray1[0][0];
	            String pwd = localArray1[0][1];
	            String acccode = localArray1[0][2];        
	          
	            int tcn = FindTCNumber("TestCases","UMR-4");	
			    System.out.println("the value is:"+tcn);
		       
			    superAdminLogin(uname,pwd,acccode);
			    HF.addResultToHTMLFile(""+localArray2[tcn][0],""+localArray2[tcn][1],""+localArray2[tcn][2],""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
				tcn++;
				
				String noofitem1 = localArray1[0][4];
				Integer noofitem =Integer.parseInt(noofitem1);
						

				Welcomestart(driver);
				pause(10000);
				HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
				tcn++;
				

				for(int noofitems=1;noofitems<noofitem+1;noofitems++)
				{
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("javascript:window.scrollBy(0,8000)");
				itemnavigation(driver, noofitems);
				verifyitemnumber(driver, noofitems);
				clickOn(markForReview);
				verifyYellowFilledForm(noofitems);
				verifyUnmarkForReview(noofitems);	
				pause(10000);
				clickOn(markForReview);
				pause(10000);
				verifyitemnumber(driver, noofitems);
				verifyYellowFilledFormNo(noofitems);
				verifyMarkForReview(noofitems);
				stoptest(driver);
				stopno(driver);
				verifyYellowFilledFormNo(noofitems);
				verifyMarkForReview(noofitems);
								
				
				JavascriptExecutor js1 = (JavascriptExecutor) driver;
				js1.executeScript("javascript:window.scrollBy(0,8000)");
				
				if (noofitems<noofitem)
				{
					clickgoon(driver);
				}
				else
				finishtest(driver);
				}				
				HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
				tcn++;
				HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
				tcn++;
				HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
				tcn++;
				HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
				tcn++;
				HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
				tcn++;
				HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
				tcn++;				
				}		
				catch(Exception e)
				{
				HF.htmlReportFail("''","''","''","UnMark For Review Scen4 failed","UnMark For Review Scen4 failed","Fail"); 
				driver.quit(); 
				}
				}	

	      /*---------------------------------------------------------------------------------------------*
	  	   *------------------------Created by Dinesh on 12-29-2014--------------------------------------*
	  	   *--Function for checking Item count of UNMark for Review after clicking Stop button ---------**/

	  	      //@Test(enabled=true)
     			@Test
	  	     public void f_unMarkForReviewScen6() throws Exception 
	  	     {
	  	      try{ 
	  	          System.out.println("Entered f_unMarkForReviewScen6");
	  	          Fetchmethod("Sheet2");
	  	          int rowno = FindRowno("f_unMarkForReviewScen6");
	  	          FetchExceldata(rowno);
	  	          String uname = localArray1[0][0];
	  	          String pwd = localArray1[0][1];
	  	          String acccode = localArray1[0][2];
	  	          int tcn = FindTCNumber("TestCases","UMR-6");	
			      System.out.println("the value is:"+tcn);  	          
	  	         
	  			  superAdminLogin(uname,pwd,acccode);
	  			  HF.addResultToHTMLFile(""+localArray2[tcn][0],""+localArray2[tcn][1],""+localArray2[tcn][2],""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
				  tcn++;
	  			  String noofitem1 = localArray1[0][4];
	  			  Integer noofitem =Integer.parseInt(noofitem1);
	  			  Welcomestart(driver);
	  			  HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
	  			  tcn++;		  
	  			  pause(10000);
	  			  
	  			 for(int noofitems=1;noofitems<noofitem+1;noofitems++)
	  			 {
	  			    JavascriptExecutor js = (JavascriptExecutor) driver;
	  				js.executeScript("javascript:window.scrollBy(0,8000)");
	  				itemnavigation(driver, noofitems);
	  				verifyitemnumber(driver, noofitems);
	  				clickOn(markForReview);
					verifyYellowFilledForm(noofitems);
					verifyUnmarkForReview(noofitems);	
					pause(10000);			
	  				stoptest(driver);
	  				verifyMarkReviewCount(driver,noofitems);
	  				stopno(driver);
	  				pause(10000);
	  				clickOn(markForReview);
					pause(10000);
					verifyitemnumber(driver, noofitems);
					verifyYellowFilledFormNo(noofitems);
					verifyMarkForReview(noofitems);
					stoptest(driver);
					verifyMarkReviewCount(driver,noofitems);
					stopno(driver);	  				
	  				
	  				JavascriptExecutor js1 = (JavascriptExecutor) driver;
	  				js1.executeScript("javascript:window.scrollBy(0,8000)");
	  				
	  				if (noofitems<noofitem)
	  				{
	  					clickgoon(driver);
	  				}
	  				else
	  					
	  					finishtest(driver);
	  				
	  				}
	  			 
	  			HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
	  		    tcn++;
	  		    HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
	  		    tcn++;
	  		    HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
	  		    tcn++;
	  		    HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
	  		    tcn++;
	  		    HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
	  		    }		
	  				catch(Exception e)
	  				{
	  				HF.htmlReportFail("''","''","''","UnMark For Review Scen6 failed","UnMark For Review Scen6 failed","Fail"); 
	  				driver.quit(); 
	  				}
	  				}	

	  	    @Test(enabled=true)
     		//@Test
	  		public void f_LoginValid() throws Exception
	  			{
	  			try{
	  				System.out.println("Entered f_LoginValid");
	  				Fetchmethod("Sheet2");
	  				int rowno = FindRowno("f_LoginValid");
	  				FetchExceldata(rowno);
	  				String uname = localArray1[0][0];
	  				String pwd = localArray1[0][1];
	  				String acccode = localArray1[0][2];
	  				System.out.println("The value of uname is"+uname);
	  				System.out.println("The value of uname is"+pwd);
	  				System.out.println("The value of uname is"+acccode);
	  				int tcn = FindTCNumber("TestCases","LV-1");	
	  				System.out.println("the value is:"+tcn);
	  				HF.addResultToHTMLFile(""+localArray2[tcn][0],""+localArray2[tcn][1],""+localArray2[tcn][2],""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
	  				tcn++;		
	  				superAdminLogin(uname,pwd,acccode);  				
  
	  			    HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
	  		    	tcn++;	  			
	  		    	HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
	  		    	tcn++;
	  			
	  			String actugetStarted=getText(getStarted);
	  			String expegetStarted="Let's get started!";
	  			verifyEquals(expegetStarted,actugetStarted);
	  			verifyTextPresent("Test Title:");
	  			verifyTextPresent("Notes:");
	  			verifyTextPresent("Welcome");
	  			HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
	  			tcn++;
	  			HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");	  			
	  		   }
	  			
	  			catch(Exception e)
	  			 {	  			
	  				HF.htmlReportFail("''","''","''","''","Login Aborted","Fail");
	  			 }	
	  			}
     		//@Test(enabled=true)
     		@Test
	  		public void f_LoginNetworkDisconnect() throws Exception
	  			{
	  			try{
	  				System.out.println("Entered f_LoginNetworkDisconnect");
	  				Fetchmethod("Sheet2");
	  				int rowno = FindRowno("f_LoginNetworkDisconnect");
	  				FetchExceldata(rowno);
	  				String uname = localArray1[0][0];
	  				String pwd = localArray1[0][1];
	  				String acccode = localArray1[0][2];
	  				System.out.println("The value of uname is"+uname);
	  				System.out.println("The value of uname is"+pwd);
	  				System.out.println("The value of uname is"+acccode);
	  				int tcn = FindTCNumber("TestCases","LV-3");	
	  				System.out.println("the value is:"+tcn);
	  				HF.addResultToHTMLFile(""+localArray2[tcn][0],""+localArray2[tcn][1],""+localArray2[tcn][2],""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
	  				tcn++;		
	  				superAdminLogin(uname,pwd,acccode); 
	  			    HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
	  		    	tcn++;	  			
	  		    	HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
	  		    	tcn++;	  		    	
	  		    	verifyLoginNetworkDisconnect();
	  		    	pause(10000);
	  		    	HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
	  		    	tcn++;
	  		    	HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");	  		    			
	  		     }
	  			
	  			catch(Exception e)
	  			 {	  			
	  				HF.htmlReportFail("''","''","''","''","Login Aborted","Fail");
	  			 }	
	  			}

 
	  	   @Test(enabled=true)
	  	   //@Test
	  		public void f_LoginInValid() throws Exception
	  			{
	  			  try{
		  				System.out.println("Entered f_LoginInValid");
		  				Fetchmethod("Sheet2");
		  				int rowno = FindRowno("f_LoginInValid");
		  				FetchExceldata(rowno);
		  				String uname = localArray1[0][0];
		  				String pwd = localArray1[0][1];
		  				String acccode = localArray1[0][2];
		  				System.out.println("The value of uname is"+uname);
		  				System.out.println("The value of uname is"+pwd);
		  				System.out.println("The value of uname is"+acccode);
		  				int tcn = FindTCNumber("TestCases","LV-2");	
		  				System.out.println("the value is:"+tcn);
		  				HF.addResultToHTMLFile(""+localArray2[tcn][0],""+localArray2[tcn][1],""+localArray2[tcn][2],""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
		  		    	tcn++;		  				
		  				superAdminLogin(uname,pwd,acccode);  				
		  				HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
		  		    	tcn++;
		  		    	HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
		  		    	tcn++;
		  		    	verifyLoginErrorText();
		  		    	pause(10000);
		  		    	
		  		    	HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
		  		    	tcn++;
		  		    	HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");	  			
	  		   }
	  			
	  			catch(Exception e)
	  			 {	  			
	  				HF.htmlReportFail("''","''","''","''","Login Aborted","Fail");
	  			 }	
	  			}
	  	  
	  	 //@Test(enabled=true)
	  	 @Test
	  		public void f_WelcomeStart() throws Exception
	  			{
	  			try{
	  				System.out.println("Entered f_LoginValid");
	  				Fetchmethod("Sheet2");
	  				int rowno = FindRowno("f_WelcomeStart");
	  				FetchExceldata(rowno);
	  				String uname = localArray1[0][0];
	  				String pwd = localArray1[0][1];
	  				String acccode = localArray1[0][2];
	  				System.out.println("The value of uname is"+uname);
	  				System.out.println("The value of uname is"+pwd);
	  				System.out.println("The value of uname is"+acccode);
	  				int tcn = FindTCNumber("TestCases","WS-1");	
	  				System.out.println("the value is:"+tcn);
	  				HF.addResultToHTMLFile(""+localArray2[tcn][0],""+localArray2[tcn][1],""+localArray2[tcn][2],""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
	  				tcn++;		
	  				superAdminLogin(uname,pwd,acccode);  				

	  			    HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
	  		    	tcn++;	  			
	  		    	HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
	  		    	tcn++;
	  		    	
	  			
	  			String actugetStarted=getText(getStarted);
	  			String expegetStarted="Let's get started!";
	  			verifyEquals(expegetStarted,actugetStarted);
	  			verifyTextPresent("Test Title:");
	  			verifyTextPresent("Notes:");
	  			verifyTextPresent("Welcome");
	  			Welcomestart(driver);
  		    	HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
  		    	tcn++;	
  		    	String actuqusNum=getText(questid);
  		    	String actutestName=getText(testName);
  		    	String expequsNum="QUESTION 1 OF 3";
  		    	String expetestName="Untimed Test";
  		    	verifyEquals(expequsNum,actuqusNum);
  		    	verifyEquals(expetestName,actutestName);
  		    	HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
  		    	tcn++;
  		    	HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");    	
	  		   }
	  			
	  			catch(Exception e)
	  			 {	  			
	  				HF.htmlReportFail("''","''","''","''","WelcomeStart aborted","Fail");
	  			 }	
	  			}
	  	 
	  	 //@Test(enabled=true)
	  	@Test
	  		public void f_WelcomeStop() throws Exception
	  			{
	  			try{
	  					System.out.println("Entered f_WelcomeStop");
		  				Fetchmethod("Sheet2");
		  				int rowno = FindRowno("f_WelcomeStop");
		  				FetchExceldata(rowno);
		  				String uname = localArray1[0][0];
		  				String pwd = localArray1[0][1];
		  				String acccode = localArray1[0][2];
		  				System.out.println("The value of uname is"+uname);
		  				System.out.println("The value of uname is"+pwd);
		  				System.out.println("The value of uname is"+acccode);
		  				int tcn = FindTCNumber("TestCases","WS-2");	
		  				System.out.println("the value is:"+tcn);
		  				HF.addResultToHTMLFile(""+localArray2[tcn][0],""+localArray2[tcn][1],""+localArray2[tcn][2],""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
		  				tcn++;		
		  				superAdminLogin(uname,pwd,acccode);  				

		  			    HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
		  		    	tcn++;	  			
		  		    	HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
		  		    	tcn++;
		  		    	
		  			
		  			String actugetStarted=getText(getStarted);
		  			String expegetStarted="Let's get started!";
		  			verifyEquals(expegetStarted,actugetStarted);
		  			verifyTextPresent("Test Title:");
		  			verifyTextPresent("Notes:");
		  			verifyTextPresent("Welcome");
		  			clickOn(stopButton);
	  		    	HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
	  		    	tcn++;	
	  		    	String actuqusNum=getText(goodBye);
	  		    	String expequsNum="Good-bye!";
	  		    	verifyEquals(expequsNum,actuqusNum);
	  		    	HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
	  		      }
	  			
	  			catch(Exception e)
	  			 {	  			
	  				HF.htmlReportFail("''","''","''","''","Login Aborted","Fail");
	  			 }	
	  			}
	  	 
	  	 //@Test(enabled=true)
	  	@Test
	  		public void f_PauseValid() throws Exception
	  			{
	  			try{
	  				System.out.println("Entered f_PauseValid");
	  				Fetchmethod("Sheet2");
	  				int rowno = FindRowno("f_PauseValid");
	  				FetchExceldata(rowno);
	  				String uname = localArray1[0][0];
	  				String pwd = localArray1[0][1];
	  				String acccode = localArray1[0][2];
	  				System.out.println("The value of uname is"+uname);
	  				System.out.println("The value of uname is"+pwd);
	  				System.out.println("The value of uname is"+acccode);
	  				int tcn = FindTCNumber("TestCases","PV_1");	
	  				System.out.println("the value is:"+tcn);
	  				HF.addResultToHTMLFile(""+localArray2[tcn][0],""+localArray2[tcn][1],""+localArray2[tcn][2],""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
	  				tcn++;		
	  				superAdminLogin(uname,pwd,acccode);  				

	  			    HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
	  		    	tcn++;	  			
	  		    	HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
	  		    	tcn++;
	  		    	
	  			
	  			String actugetStarted=getText(getStarted);
	  			String expegetStarted="Let's get started!";
	  			verifyEquals(expegetStarted,actugetStarted);
	  			verifyTextPresent("Test Title:");
	  			verifyTextPresent("Notes:");
	  			verifyTextPresent("Welcome");
	  			Welcomestart(driver);
		    	HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
		    	tcn++;	
		    	String actuqusNum=getText(questid);
		    	String actutestName=getText(testName);
		    	String expequsNum="QUESTION 1 OF 3";
		    	String expetestName="Untimed Test";
		    	verifyEquals(expequsNum,actuqusNum);
		    	verifyEquals(expetestName,actutestName);
		    	pause(5000);
		    	clickOn(nextButton);
		    	System.out.println("Next button is clicked");
		    	HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
		    	tcn++;
		    	pausetest(driver);
		    	HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");  
		    	tcn++;
				enterData(password,pwd);
				pauselogin(driver);
				HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");  
		    	tcn++;
		    	String actuqusNum2=getText(questid);
		    	String actutestName2=getText(testName);
		    	String expequsNum2="QUESTION 2 OF 3";
		    	String expetestName2="Untimed Test";
		    	verifyEquals(expequsNum2,actuqusNum2);
		    	verifyEquals(expetestName2,actutestName2);
		    	tcn++;
		    	HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");		    	  	
	  		   }
	  			
	  			catch(Exception e)
	  			 {	  			
	  				HF.htmlReportFail("''","''","''","''","WelcomeStart aborted","Fail");
	  			 }	
	  			}
	  	 
	  	 //@Test(enabled=true)
	  	@Test
	  		public void f_StopNogoback() throws Exception
	  			{
	  			try{
	  				System.out.println("Entered f_StopNogoback");
	  				Fetchmethod("Sheet2");
	  				int rowno = FindRowno("f_StopNogoback");
	  				FetchExceldata(rowno);
	  				String uname = localArray1[0][0];
	  				String pwd = localArray1[0][1];
	  				String acccode = localArray1[0][2];
	  				System.out.println("The value of uname is"+uname);
	  				System.out.println("The value of uname is"+pwd);
	  				System.out.println("The value of uname is"+acccode);
	  				int tcn = FindTCNumber("TestCases","ST-2");	
	  				System.out.println("the value is:"+tcn);
	  				HF.addResultToHTMLFile(""+localArray2[tcn][0],""+localArray2[tcn][1],""+localArray2[tcn][2],""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
	  				tcn++;		
	  				superAdminLogin(uname,pwd,acccode);  				

	  			    HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
	  		    	tcn++;	  			
	  		    	HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
	  		    	tcn++;
	  		    	
	  			
	  			String actugetStarted=getText(getStarted);
	  			String expegetStarted="Let's get started!";
	  			verifyEquals(expegetStarted,actugetStarted);
	  			verifyTextPresent("Test Title:");
	  			verifyTextPresent("Notes:");
	  			verifyTextPresent("Welcome");
	  			Welcomestart(driver);
		    	HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
		    	tcn++;	
		    	String actuqusNum=getText(questid);
		    	String actutestName=getText(testName);
		    	String expequsNum="QUESTION 1 OF 3";
		    	String expetestName="Untimed Test";
		    	verifyEquals(expequsNum,actuqusNum);
		    	verifyEquals(expetestName,actutestName);
		    	pause(5000);
		    	clickOn(nextButton);
		    	System.out.println("Next button is clicked");
		    	HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
		    	tcn++;
		    	stoptest(driver);
		    	stopno(driver);
				HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");  
		    	tcn++;
		    	String actuqusNum2=getText(questid);
		    	String actutestName2=getText(testName);
		    	String expequsNum2="QUESTION 2 OF 3";
		    	String expetestName2="Untimed Test";
		    	verifyEquals(expequsNum2,actuqusNum2);
		    	verifyEquals(expetestName2,actutestName2);
		    	tcn++;
		    	HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");		    	  	
	  		   }
	  			
	  			catch(Exception e)
	  			 {	  			
	  				HF.htmlReportFail("''","''","''","''","WelcomeStart aborted","Fail");
	  			 }	
	  			}
	  	 
		 //@Test(enabled=true)
	  	@Test
	  		public void f_StopYesIhaveFinished() throws Exception
	  			{
	  			try{
	  				System.out.println("Entered f_StopYesIhaveFinished");
	  				Fetchmethod("Sheet2");
	  				int rowno = FindRowno("f_StopYesIhaveFinished");
	  				FetchExceldata(rowno);
	  				String uname = localArray1[0][0];
	  				String pwd = localArray1[0][1];
	  				String acccode = localArray1[0][2];
	  				System.out.println("The value of uname is"+uname);
	  				System.out.println("The value of uname is"+pwd);
	  				System.out.println("The value of uname is"+acccode);
	  				int tcn = FindTCNumber("TestCases","ST-3");	
	  				System.out.println("the value is:"+tcn);
	  				HF.addResultToHTMLFile(""+localArray2[tcn][0],""+localArray2[tcn][1],""+localArray2[tcn][2],""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
	  				tcn++;		
	  				superAdminLogin(uname,pwd,acccode);  				

	  			    HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
	  		    	tcn++;	  			
	  		    	HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
	  		    	tcn++;
	  		    	
	  			
	  			String actugetStarted=getText(getStarted);
	  			String expegetStarted="Let's get started!";
	  			verifyEquals(expegetStarted,actugetStarted);
	  			verifyTextPresent("Test Title:");
	  			verifyTextPresent("Notes:");
	  			verifyTextPresent("Welcome");
	  			Welcomestart(driver);
		    	HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
		    	tcn++;	
		    	String actuqusNum=getText(questid);
		    	String actutestName=getText(testName);
		    	String expequsNum="QUESTION 1 OF 3";
		    	String expetestName="Untimed Test";
		    	verifyEquals(expequsNum,actuqusNum);
		    	verifyEquals(expetestName,actutestName);
		    	pause(5000);
		    	clickOn(nextButton);
		    	System.out.println("Next button is clicked");
		    	HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
		    	tcn++;
		    	stoptest(driver);
		    	HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");  
		    	tcn++;
		    	stopyes(driver);
		    	
		    	//String actutext=getText(yesFinish);
		    	//String actutestName2=getText(testName);
		    	//String expetext="Thanks for taking test is displayed";
		    	//String expetestName2="Untimed Test";
		    	//verifyEquals(expetext,actutext);
		    	verifyTextPresent("Thank you for taking the test.");
		    	verifyTextPresent("Good-bye!");
		    	verifyTextPresent("Continue");
		    	HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");  
		    	tcn++;
		    	HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");		    	
	  		   }
	  			
	  			catch(Exception e)
	  			 {	  			
	  				HF.htmlReportFail("''","''","''","''","WelcomeStart aborted","Fail");
	  			 }	
	  			}


	  	 
	  	   //@Test(enabled=true)
	  		@Test
	  		public void f_PauseInValid() throws Exception
	  			{
	  			try{
	  			System.out.println("Entered f_PauseInValid");
	  			Fetchmethod("Sheet2");
	  			int rowno = FindRowno("f_PauseInValid");
	  			FetchExceldata(rowno);
	  			String uname = localArray1[0][0];
	  			String pwd = localArray1[0][1];
	  			String acccode = localArray1[0][2];
	  			System.out.println("The value of uname is"+uname);
	  			System.out.println("The value of uname is"+pwd);
	  			System.out.println("The value of uname is"+acccode);
	  			int tcn = FindTCNumber("TestCases","PV_2");	
	  			System.out.println("the value is:"+tcn);
	  			HF.addResultToHTMLFile(""+localArray2[tcn][0],""+localArray2[tcn][1],""+localArray2[tcn][2],""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
	  			tcn++;		
	  			superAdminLogin(uname,pwd,acccode);  				

	  			HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
	  		    tcn++;	  			
	  		    HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
	  		    tcn++;	  			
	  			String actugetStarted=getText(getStarted);
	  			String expegetStarted="Let's get started!";
	  			verifyEquals(expegetStarted,actugetStarted);
	  			verifyTextPresent("Test Title:");
	  			verifyTextPresent("Notes:");
	  			verifyTextPresent("Welcome");
	  			Welcomestart(driver);
		    	HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
		    	tcn++;	
		    	String actuqusNum=getText(questid);
		    	String actutestName=getText(testName);
		    	String expequsNum="QUESTION 1 OF 3";
		    	String expetestName="Untimed Test";
		    	verifyEquals(expequsNum,actuqusNum);
		    	verifyEquals(expetestName,actutestName);
		    	pause(5000);
		    	pausetest(driver);
		    	HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");  
		    	tcn++;
				enterData(password,"pwd1");
				pauselogin(driver);
				HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");  
		    	tcn++;	
		    	verifyPauseErrorText();	
		    	pause(10000);
		    	HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");		    	
	  		    }
	  			
	  			catch(Exception e)
	  			 {	  			
	  				HF.htmlReportFail("''","''","''","''","Login Aborted","Fail");
	  			 }	
	  			}
	  	   
	  		//@Test(enabled=true)
	  		@Test
	  		public void f_LoginTestCompleted() throws Exception
	  			{
	  			try{
	  				System.out.println("Entered f_LoginTestCompleted");
	  				Fetchmethod("Sheet2");
	  				int rowno = FindRowno("f_LoginTestCompleted");
	  				FetchExceldata(rowno);
	  				String uname = localArray1[0][0];
	  				String pwd = localArray1[0][1];
	  				String acccode = localArray1[0][2];
	  				System.out.println("The value of uname is"+uname);
	  				System.out.println("The value of uname is"+pwd);
	  				System.out.println("The value of uname is"+acccode);
	  				int tcn = FindTCNumber("TestCases","LV-4");	
	  				System.out.println("the value is:"+tcn);
	  				HF.addResultToHTMLFile(""+localArray2[tcn][0],""+localArray2[tcn][1],""+localArray2[tcn][2],""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
	  				tcn++;		
	  				superAdminLogin(uname,pwd,acccode); 
	  			    HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
	  		    	tcn++;	  			
	  		    	HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
	  		    	tcn++;	  		    	
	  		    	verifyLoginTestCompleted();
	  		    	pause(10000);
	  		    	HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");
	  		    	tcn++;
	  		    	HF.addResultToHTMLFile("''","''","''",""+localArray2[tcn][3],""+localArray2[tcn][4], "Pass");	  		    			
	  		     }
	  			
	  			catch(Exception e)
	  			 {	  			
	  				HF.htmlReportFail("''","''","''","''","Login Aborted","Fail");
	  			 }	
	  			}





      }
