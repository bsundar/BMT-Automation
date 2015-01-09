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
import static UIWrappers.UIobjects.getText;
import static UIWrappers.UIobjects.log;
import static UIWrappers.UIobjects.pause;
import static UIWrappers.UIobjects.verifyEquals;
import static UIWrappers.UIobjects.verifyTextPresent;
import static Config.XlsReader.*;
import ReusableComponents.*;
import UIWrappers.Page;
import static UIWrappers.UIobjects.*;
import static User_actions.mixedItems.ddresponses;
import static User_actions.mixedItems.ebsrmcmcrresponses;
import static User_actions.mixedItems.ebsrmcresponses;
import static User_actions.mixedItems.ebsrmcrmcresponses;
import static User_actions.mixedItems.ebsrmcrresponses;
import static User_actions.mixedItems.eeeresponses;
import static User_actions.mixedItems.mcresponses;
import static User_actions.mixedItems.mcresponses1;
import static User_actions.mixedItems.mcrresponses;
import static User_actions.mixedItems.miresponses;
import static User_actions.mixedItems.mtresponses;
import static User_actions.mixedItems.ppresponses;
import static User_actions.mixedItems.scresponses;
import static User_actions.mixedItems.soresponses;
import static User_actions.mixedItems.spresponses;
import static User_actions.mixedItems.stresponses;

import org.sikuli.script.Screen;

@Listeners({ReportsUtils.CustomReport.class,ReportsUtils.ReportSetup.class})

public class BMT_GAIN_Smoke extends Page{
	
	static String image1="C:\\Automation _Framework\\BMT_GAIN_Review\\BMT Highligter.png"; 
	
	htmlReport HF = new htmlReport();
	@Test(enabled=false)	
	public void f_highlightScen1() throws Exception
	{
	 try{
		String image1="C:\\Automation _Framework\\BMT_GAIN_Review\\BMT Highligter.png";
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
	/*--------------------------------------------------------------------------------------*
	 *----------------Created by Dinesh on 12-24-2014--------------------------------------*
	 *--------------*Function for checking Mark for Review retaining after item Navigation----**/
	
	 @Test(enabled=true)	
	 public void f_markForReviewScen1() throws Exception
	  {
	   try{
		   
		//String image1="C:\\Users\\t0043920\\Desktop\\BMT Highligter.png";
		//String image2="C:\\Users\\t0043920\\Desktop\\Image2.png";
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
	    HF.addResultToHTMLFile("''","''","''",""+fetchCell(0,28,3),""+fetchCell(0,28,4),"Pass");
	    
	
	
		for(int noofitems=1;noofitems<noofitem+1;noofitems++)
		{
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("javascript:window.scrollBy(0,8000)");
			itemnavigation(driver, noofitems);
			verifyitemnumber(driver, noofitems);
			clickOn(markForReview);
			verifyYellowFilledForm(noofitems);
			verifyUnmarkForReview(noofitems);		
			HF.addResultToHTMLFile("''","''","''",""+fetchCell(0,29,3),""+fetchCell(0,29,4),"Pass");
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
	 *--------------*Function for checking UnMark for Review retaining after item Navigation----**/
	
	 @Test(enabled=true)	
	 public void f_unMarkForReviewScen1() throws Exception
	  {
	   try{
		//String image1="C:\\Users\\t0043920\\Desktop\\BMT Highligter.png";
		//String image2="C:\\Users\\t0043920\\Desktop\\Image2.png";
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
			clickOn(markForReview);
			verifyYellowFilledForm(noofitems);
			verifyUnmarkForReview(noofitems);						
			pause(10000);
			clickOn(markForReview);
			verifyYellowFilledFormNo(noofitems);
			verifyMarkForReview(noofitems);
			
		}
	 }		
	 catch(Exception e)
	 {
		HF.htmlReportFail("''","''","''","Highlighter function failed","Highligter not available","Fail"); 
		driver.quit(); 
	 }
	
	}

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
		System.out.println("The uname is:"+uname);
		System.out.println("The pwd is:"+pwd);
		System.out.println("The accesscode is:"+accesscode);
		System.out.println("The Testname is:"+Testname);
		System.out.println("The Testname is:"+noofitem);
		System.out.println("The noofitem is:"+response);
		
		
		superAdminLogin(uname,pwd,acccode);
		  
	    Welcomestart(driver);	
	
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
			HF.addResultToHTMLFile("''","''","''",""+fetchCell(0,12,3),""+fetchCell(0,12,4),"Pass");
			HF.addResultToHTMLFile("''","''","''",""+fetchCell(0,13,3),""+fetchCell(0,13,4),"Pass");
		
	    }
		 catch(Exception e)
		 {
			 
			 HF.htmlReportFail("''","''","''","''","Aborted Execution","Fail");
			 
		 }
	
	}

	//@SuppressWarnings("static-access")
	@Test(enabled=true)		
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
			System.out.println("The uname is:"+uname);
			System.out.println("The pwd is:"+pwd);
			System.out.println("The accesscode is:"+accesscode);
			System.out.println("The Testname is:"+Testname);
			System.out.println("The Testname is:"+noofitem);
			System.out.println("The noofitem is:"+response);
						
			
			superAdminLogin(uname,pwd,acccode);
			  
		    Welcomestart(driver);	
		   
		   log("Step 8: Checking for StopTest functioanlity");	
		   
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
			HF.addResultToHTMLFile("''","''","''",""+fetchCell(0,24,3),""+fetchCell(0,24,4),"Pass");
		 
			HF.addResultToHTMLFile("''","''","''",""+fetchCell(0,25,3),""+fetchCell(0,25,4),"Pass");
		    }
		    catch(Exception e)
			 {
				
		    	HF.htmlReportFail("''","''","''","''","Aborted Execution","Fail");
				
				 
			 }    
	
	}

	@Test(enabled=false)		
	public void mixeditems() throws Exception
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
		pause(60000);
		
		//Login with Username, Password, Accesscode
		
	    
	    Welcomestart(driver);
	    pause(10000);
	    HF.addResultToHTMLFile("''","''","''",""+fetchCell(0,29,3),""+fetchCell(0,29,4),"Pass");
	    
	   
	     
	   for(int nofitems=1;nofitems<noofitem+1;nofitems++)
	    {
		FetchExceldata(response);
		String itemno = localArray1[0][0];
		Integer noofitems =Integer.parseInt(itemno);
	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(0,8000)");
		
		itemnavigation(driver, noofitems);	
		verifyitemnumber(driver, noofitems);
		Thread.sleep(3000);
		String itemtype = localArray1[0][1];
		Integer intitemtype =Integer.parseInt(itemtype);
				
		switch(intitemtype)
			{
				case 1:
					mcresponses(driver, response, noofitems);
					break;
				case 2:
					ddresponses(driver, response, noofitems);
					break;	
				case 3:
					miresponses(driver, response, noofitems);
					break;
				case 4:
					scresponses(driver, response, noofitems);
					break;
				case 5:
					ppresponses(driver, response, noofitems);
					break;
				case 6:
					soresponses(driver, response, noofitems);
					break;
				case 7:
					spresponses(driver, response, noofitems);
					break;
				case 8:
					mcrresponses(driver, response, noofitems);
					break;
				case 9:
					mcresponses1(driver, response, noofitems);
					break;
				case 10:
					stresponses(driver, response, noofitems);
					break;
				case 11:
					mtresponses(driver, response, noofitems);
					break;
				case 12:
					ebsrmcresponses(driver, response, noofitems);
					break;
				case 13:
					ebsrmcrresponses(driver, response, noofitems);
					break;
				case 14:
					ebsrmcmcrresponses(driver, response, noofitems);
					break;
				case 15:
					ebsrmcrmcresponses(driver, response, noofitems);
					break;
				case 16:
					eeeresponses(driver, response, noofitems);
					break;
				default:
					log("itemtype is wrong");
					
			}
		response++;
		}
	finishtest(driver);
	stopyes(driver);
	HF.addResultToHTMLFile("''","''","''",""+fetchCell(0,30,3),""+fetchCell(0,30,4),"Pass");
	HF.addResultToHTMLFile("''","''","''",""+fetchCell(0,31,3),""+fetchCell(0,31,4),"Pass");
		}
		catch(Exception e)
		 {	
			HF.htmlReportFail("''","''","''","''","Aborted mixeditems","Fail");
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

	@Test(enabled=true)
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

	@Test(enabled=true)
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

	@Test(enabled=true)
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

	@Test(enabled=true)
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

	@Test(enabled=true)
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

	@Test(enabled=true)
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

	@Test(enabled=true)
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

	@Test(enabled=true)
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

	@Test(enabled=true)
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
}
