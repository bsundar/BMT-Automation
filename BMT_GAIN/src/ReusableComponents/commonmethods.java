package ReusableComponents;

//import static Config.BaseConfig.driver;
//import static UIWrappers.UIobjects.*;
import static Config.XlsReader.localArray2;
import static ObjectRepository.ObjectRepository.*;
import static UIWrappers.UIobjects.clickOn;
import static UIWrappers.UIobjects.enterData;
import static UIWrappers.UIobjects.getText;
import static UIWrappers.UIobjects.pause;
import static UIWrappers.UIobjects.verifyEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import java.awt.Robot;
import java.awt.event.InputEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.internal.Locatable;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import UIWrappers.Page;


//@Listeners({ReportsUtils.CustomReport.class,ReportsUtils.ReportSetup.class})

public class commonmethods extends Page {
	static String MarkForReview="oas_testing_flag_label";
	static String UnmarkForReview="oas_testing_flag_label oas-mark-for-review_selected";
	//old object repository static String YellowFilledForm="oas_testing_goto_div oas_testing_goto_div_on oas_testing_goto_div_flag oas_testing_goto_div_over";
	static String YellowFilledForm="oas_testing_goto_div oas_testing_goto_div_on oas_testing_goto_div_flag";
	static String UnYellowFilledForm="oas_testing_goto_div oas_testing_goto_div_on oas_testing_goto_div_over";
	static htmlReport HF = new htmlReport();
	
	public static void superAdminLogin(String Username, String Password, String Accesscode) throws Exception
	{
		//driver.switchTo().frame("mainFrame");
	    enterData(loginID,Username);
	    enterData(password,Password);
	    enterData(accesscode,Accesscode);
	    clickOn(loginButton);
	    pause(4000);
	}	
	
    
	

	/*--------------------------------------------------------------------------------------*
	 *-------------------------Created on 6/16/2014-----------------------------------------*
	 *-------------------------Created by Raamkumar Anandhan--------------------------------*
	 *----------------This file contains all common methods used in BMT project-------------*
	 *--------------------------------------------------------------------------------------* 
	 */
	

		/*--------------------------------------------------------------------------------------*
		 *This method "select_test" is used to select test in launch page and verifies login page is displayed* 
		 *-----------------------Test name reads it from the excel file-------------------------*
		 *--------------------------------------------------------------------------------------*  
		 */
		//@SuppressWarnings("static-access")
		//@SuppressWarnings("static-access")
		public static void select_test(String Testname, WebDriver driver) throws Exception {
			try{
				String[] folder = Testname.split(",");
				String parentfolder = folder[0];
				String testName = folder[1];
				System.out.println("Selecting the test "+testName);
				WebElement table = driver.findElement(By.xpath("/html/body/div[2]/section[1]/div"));
				//WebElement table = driver.findElement(By.xpath("html/body/div[2]/section/div/div[1]"));
			    List<WebElement> rows = table.findElements(By.tagName("h3"));
			    int i=1;
			    for(WebElement row:rows) {
			    	if(row.getText().contains(parentfolder))
			    	{
			    		break;
			    	}
			    	else
			    	{
			    		i++;
			    	}
			    	
			    }
			    
			    
			    WebElement testfolder = driver.findElement(By.xpath("/html/body/div[2]/section[1]/div/div["+i+"]"));
			    List<WebElement> tests = testfolder.findElements(By.tagName("li"));
			    	    
			    for (WebElement test : tests) {
			    	
			    	if(test.getText().contains(testName))
			    	{	
			    		String id = test.getAttribute("id");
			    		WebElement testname = driver.findElement(By.xpath("//*[@id='"+id+"']"));//INDIANA CCRA QA Test 01
						testname.click();
						System.out.println(testName+" is selected");
						pause(20000);
						break;
			    	}
			    
			    }
				for(String winHandle : driver.getWindowHandles()){
				    driver.switchTo().window(winHandle);
				}
				String browsertitle = driver.getTitle();
				if(browsertitle.startsWith("Login"))
				{
					System.out.println("Login page is displayed");
				}
				else
				{
					System.out.println("Error: Login page is not displayed");
				}
				}
				catch (Exception e) {
					HF.htmlReportFail("''","''","''","TestName Selected","TestName not selected","Fail");
					//htmlFunc.htmlReportFail("''","Select TestName","TestName Selected","TestName not selected","Fail");
					System.out.println(e);
					pause(5000);					
					driver.quit();
					}
				}
		
		/*--------------------------------------------------------------------------------------*
		 *This method "BMTLogin" is used to click on Login button in Login page and verifies Welcome page is displayed* 
		 *--------------------------------------------------------------------------------------*  
		 */
		//@SuppressWarnings("static-access")
		//@SuppressWarnings("static-access")
		public static void BMTLogin(WebDriver driver) throws Exception {
			try{
			WebElement Submit = driver.findElement(By.xpath(".//*[@id='login_container']/div/div/div[1]/div/center/div[2]/button[2]"));
			//WebElement Submit = driver.findElement(By.xpath("//html/body/div[2]/div[1]/div/div/div[1]/div/center/div[2]/button[2]"));
			System.out.println("Clicking on Login button in Login Screen");
			Submit.click();
			pause(15000);
			String browsertitle = driver.getTitle();
			if(browsertitle.startsWith("Test Welcome"))
			{
				System.out.println("Welcome page is displayed");
			}
			else
			{
				System.out.println("Error: Welcome page is not displayed");
			}
			}
			catch (Exception e) {
				HF.htmlReportFail("''","''","''","Login","Login Failed","Fail");
				//htmlFunc.htmlReportFail("''","BMT Login","Login","Login Failed","Fail");
				System.out.println(e);
				pause(5000);
				driver.quit();
			}
		
		}
		/*--------------------------------------------------------------------------------------*
		 *This method "Welcomestart" is used to click on start button in Welcome page and verifies Item#1 is displayed* 
		 *--------------------------------------------------------------------------------------*  
		 */
		
		/*--------------------------------------------------------------------------------------*
		 *This method "BMTLogin" is used to click on Login button in Login page and verifies Welcome page is displayed* 
		 *--------------------------------------------------------------------------------------*  
		 */
		
		public static void BMTcancel(WebDriver driver) throws Exception {
			try{
			WebElement cancellogin = driver.findElement(By.xpath(".//*[@id='login_container']/div/div/div[1]/div/center/div[2]/button[1]"));
			System.out.println("Clicking on cancel button in Login Screen");
			cancellogin.click();
			pause(15000);
			String browsertitle = driver.getTitle();
			if(browsertitle.startsWith("Login - OK"))
			{
				System.out.println("Cancel page is displayed");
			}
			else
			{
				System.out.println("Error: Cancel page is not displayed");
			}
			}
			catch (Exception e) {
				HF.htmlReportFail("''","''","''","BMTCancel Fail","BMTCancel Fail","Fail");
				driver.quit();				
			}
		
		}
		/*--------------------------------------------------------------------------------------*
		 *This method "Welcomestart" is used to click on start button in Welcome page and verifies Item#1 is displayed* 
		 *--------------------------------------------------------------------------------------*  
		 */
		
		//@SuppressWarnings("static-access")
		
		public static void Welcomestart(WebDriver driver) throws Exception {
			try{
			WebElement Submit = driver.findElement(By.xpath(".//*[@id='welcome_start_button']"));
			System.out.println("Clicking on Start button in Welcome screen");
			Submit.click();
			pause(4000);
			String browsertitle = driver.getTitle();
			//HF.htmlReportFail("+","WelcomeStart Click","Start button click","Start button clicked","Pass");
			if(browsertitle.startsWith("Test"))
			{
				System.out.println("Item #1 is displayed");
			}
			else
			{
				System.out.println("Error: Item #1 is not displayed");
			}
			}
			catch (Exception e) {
				HF.htmlReportFail("''","''","''","Welcome Screen not displayed","Item#1 not displayed","Fail");
				driver.quit();
				//htmlFunc.htmlReportFail("''","Welcome page display","Page display","Page Not display","Fail");				
			}
		}
		
		/*--------------------------------------------------------------------------------------*
		 *This method "Welcomestop" is used to click on stop button in Welcome page * 
		 *--------------------------------------------------------------------------------------*  
		 */
		
		
		public static void Welcomestop(WebDriver driver) throws Exception {
			try{
			WebElement stop = driver.findElement(By.xpath(".//*[@id='welcome_stop_button']"));
			System.out.println("Clicking on Start button in Welcome screen");
			stop.click();
			pause(10000);
			String browsertitle = driver.getTitle();
			if(browsertitle.startsWith("Test"))
			{
				System.out.println("Good bye Message is displayed");
			}
			else
			{
				System.out.println("Error: Good bye Message is not displayed");
			}
			}
			catch (Exception e) {
				HF.htmlReportFail("''","''","''","Welcomestop error","WelcomeStop Error","Fail");
				//htmlFunc.htmlReportFail("''","Welcomestop Failed","Welcomestop error","WelcomeStop Error","Fail");	
				System.out.println(e);
				pause(5000);
				driver.quit();
			}
		}
		
		
		/*--------------------------------------------------------------------------------------*
		 *This method "clickgoon" is used to click on Go On button in item page ----------------* 
		 *--------------------------------------------------------------------------------------*  
		 */
		
		public static void clickgoon(WebDriver driver) throws Exception {
			try{
			WebElement goon = driver.findElement(By.xpath("//*[@id='oas-go-on-button']"));
			goon.click();
			System.out.println("Go On button is clicked");
			pause(1000);
			}
			catch (Exception e) {
				HF.htmlReportFail("''","''","''","GoonClick Error","GoonClick Error","Fail");
				//htmlFunc.htmlReportFail("''","GoonClick Error","GoonClick Error","GoonClick Error","Fail");	
				System.out.println(e);
				pause(5000);
				driver.quit();
			}
		}
		
		/*--------------------------------------------------------------------------------------*
		 *This method "FinishTest" is used to click on Go On button in item page ----------------* 
		 *--------------------------------------------------------------------------------------*  
		 */
		
		public static void finishtest(WebDriver driver) throws Exception {
			try{
			WebElement goon = driver.findElement(By.xpath("//*[@id='oas-finish-button']"));
			goon.click();
			System.out.println("Finish test is clicked");
			pause(1000);
			}
			catch (Exception e) {
				HF.htmlReportFail("''","''","''","FinishTest Error","FinishTest Error","Fail");
				//htmlFunc.htmlReportFail("''","FinishTest Error","FinishTest Error","FinishTest Error","Fail");
				System.out.println(e);
				pause(5000);
				driver.quit();
							}
		}
		/*--------------------------------------------------------------------------------------*
		 *This method "verifyitemnumber" is used to verify which item is displayed after clicking Go On* 
		 *--------------------------------------------------------------------------------------*  
		 */
		
		public static void verifyitemnumber(WebDriver driver, int item) throws Exception {
			try{
			WebElement itemnumber = driver.findElement(By.xpath("//*[@id='view_container']/div/table[1]/tbody/tr[2]/td[1]"));
			String itemnum=itemnumber.getText();
			if(itemnum.startsWith("QUESTION "+item+" OF"))
			{
				System.out.println("Item #"+item+" is displayed");
			}
			else
			{
				HF.htmlReportFail("''","''","''","Navigation Error", "Navigation Error","Fail");
				System.out.println("Error: Item #"+item+"is not displayed");
			}
			pause(1000);
			}
			catch (Exception e) {
				HF.htmlReportFail("''","''","''","Navigation Error", "Navigation Error","Fail");
				//htmlFunc.htmlReportFail("''","Item Navigation","Navigation Error", "Navigation Error","Fail");
				System.out.println(e);
				pause(5000);
				driver.quit();				
			}
		}
		/*--------------------------------------------------------------------------------------*
		 *This method "clickgoback" is used to click on Go Back button in item page ------------* 
		 *--------------------------------------------------------------------------------------*  
		 */
		
		public static void clickgoback(WebDriver driver) throws Exception {
			try{
			WebElement goback = driver.findElement(By.xpath("//*[@id='oas-go-back-button']"));
			goback.click();
			System.out.println("Go back button is clicked");
			pause(1000);
			}
			catch (Exception e) {
				
				HF.htmlReportFail("''","''","''","GoBack Error", "GoBack Error","Fail");
				//htmlFunc.htmlReportFail("''","clickgoBack","GoBack Error", "GoBack Error","Fail");
				System.out.println(e);
				pause(5000);
				driver.quit();
				
			}
		}
		/*--------------------------------------------------------------------------------------*
		 *This method "itemnavigation"is used to click on itemnumbers at the bottom of the screen* 
		 *--------------------------------------------------------------------------------------*  
		 */
		
		public static void itemnavigation(WebDriver driver, int item) throws Exception {
			try{				
			WebElement itemnum = driver.findElement(By.xpath("//*[@id='oas_goto_"+item+"']"));
			System.out.println("Navigating to Item #"+item);
			itemnum.click();
			pause(1000);
			}
			catch (Exception e) {
				driver.quit();
				HF.htmlReportFail("''","''","''","Item Number#"+item, "Item Navigation Error","Fail");				
     		}
		}
		/*--------------------------------------------------------------------------------------*
		 *----------This method "pausetest"is used to click on pause button in item page--------* 
		 *--------------------------------------------------------------------------------------*  
		 */
		
		public static void pausetest(WebDriver driver) throws Exception {
			try{
			WebElement pause = driver.findElement(By.xpath("//*[@id='oas_testing_header_button_pause']"));
			System.out.println("Pause Test button is clicked");
			pause.click();
			pause(1000);
			WebElement pausetest = driver.findElement(By.xpath("//*[@id='login_container']/div/div/div[1]/h1"));
			String pausetext = pausetest.getText();
			if(pausetext.contains("Log in to resume your paused test"))
			{
				System.out.println("Pause Test Page is displayed");
			}
			else
			{
				System.out.println("Error: Pause test page is not displayed");
			}
			}
			catch (Exception e) {
				HF.htmlReportFail("''","''","''","PauseTest Error", "PauseTest Error","Fail");
				//htmlFunc.htmlReportFail("''","PauseTest","PauseTest Error", "PauseTest Error","Fail");
				System.out.println(e);
				pause(5000);
				driver.quit();
				
		
			}
		}
		/*--------------------------------------------------------------------------------------*
		 *------This method "pauselogin"is used to click on Login button in pause screen--------* 
		 *--------------------------------------------------------------------------------------*  
		 */
		
		public static void pauselogin(WebDriver driver) throws Exception {
			try{
			WebElement pause = driver.findElement(By.xpath("//*[@id='login_container']/div/div/div[1]/div/center/div[2]/button[2]"));
			pause.click();
			System.out.println("Login button is clicked");
			pause(1000);
			}
			catch (Exception e) {
				HF.htmlReportFail("''","''","''","PauseLogin Failed", "PauseLogin Failed","Fail");
				//htmlFunc.htmlReportFail("''","PauseLogin","PauseLogin Failed", "PauseLogin Failed","Fail");
				System.out.println(e);
				pause(5000);
				driver.quit();
				
		
			}
		}
		/*--------------------------------------------------------------------------------------*
		 *-----------This method "stoptest"is used to click on stop button in item page---------* 
		 *--------------------------------------------------------------------------------------*  
		 */
		
		public static void stoptest(WebDriver driver) throws Exception {
			try{
			WebElement stop = driver.findElement(By.xpath("//*[@id='oas_testing_header_button_stop']"));
			System.out.println("Stop Test button is clicked");
			stop.click();
			pause(1000);
			WebElement stoptest = driver.findElement(By.xpath("//*[@id='testing_finish_div']/div[1]/div[1]/center/b"));
			String pausetext = stoptest.getText();
			if(pausetext.contains("Have you finished"))
			{
				System.out.println("Stop Test Page is displayed");
			}
			else
			{
				System.out.println("Error: Stop test page is not displayed");
			}
			}
			catch (Exception e) {
				HF.htmlReportFail("''","''","''","StopTest Failed", "StopTest Failed","Fail");
				//htmlFunc.htmlReportFail("''","StopTest","StopTest Failed", "StopTest Failed","Fail");				
				System.out.println(e);
				pause(5000);
				driver.quit();
				
		
			}
		}
		/*--------------------------------------------------------------------------------------*
		 *------This method "stopno"is used to click on No, go back to the test in stop page----* 
		 *--------------------------------------------------------------------------------------*  
		 */
		//@SuppressWarnings("static-access")
		public static void stopno(WebDriver driver) throws Exception {
			try{
			WebElement pause = driver.findElement(By.xpath("//*[@id='oas-test-finish-go-back']"));
			pause.click();
			System.out.println("No, go back to test button is clicked");
			pause(1000);
			}
			catch (Exception e) {
				HF.htmlReportFail("''","''","''","StopNo Failed", "StopNo Failed","Fail");
				//htmlFunc.htmlReportFail("''","StopNo","StopNo Failed", "StopNo Failed","Fail");
				System.out.println(e);
				pause(5000);
				driver.quit();
				
		
			}
		}
		/*--------------------------------------------------------------------------------------*
		 *----This method "stopyes"is used to click on Yes, I have finished test in stop page---* 
		 *--------------------------------------------------------------------------------------*  
		 */
		//@SuppressWarnings("static-access")
		public static void stopyes(WebDriver driver) throws Exception {
			try{
			WebElement pause = driver.findElement(By.xpath("//*[@id='oas-test-finish-finish']"));
			pause.click();
			System.out.println("Yes, I have finished button is clicked");
			//pause(10000);
			}
			catch (Exception e) {
				HF.htmlReportFail("''","''","''","StopYes","StopYes Failed","Fail");
				//htmlFunc.htmlReportFail("''","StopYes","StopYes Failed", "StopYes Failed","Fail");
				System.out.println(e);
				pause(5000);	
				driver.quit();
			}
		}
		/*--------------------------------------------------------------------------------------*
		 *--------This method "blueball"is used to verify blueball is displayed or not----------* 
		 *--------------------------------------------------------------------------------------*  
		 */
		//@SuppressWarnings("static-access")
		public static void blueballyes(WebDriver driver, int item) throws Exception {
			try{
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("javascript:window.scrollBy(0,8000)");

			WebElement blueball = driver.findElement(By.xpath(".//*[@id='oas_goto_"+item+"']/div[2]/img"));
			pause(10000);
			if(blueball.isDisplayed())
			{
				
			}
		}
			catch (Exception e) {	
			    System.out.println("Error : Blue ball is not displayed for the item"+item);
				HF.htmlReportFail("''","''","''","Blue ball not displayed", ""+item,"Fail");
				pause(5000);	
				driver.quit();
			}
			
			//
				
				//htmlFunc.htmlReportFail("''","blueballyes","blueballyes", "blueballyes","Fail");
				//System.out.println(e);
			
			//}
		}
		//@SuppressWarnings("static-access")
		public static void blueballno(WebDriver driver, int item) throws Exception {
			try{
			WebElement blueball = driver.findElement(By.xpath("//*[@id='oas_goto_answered_"+item+"']"));
			pause(1000);
			if(blueball.isDisplayed())
			{
				System.out.println("Error: Blueball is displayed for the item"+item);
			}
			}
			catch (Exception e) {
				HF.htmlReportFail("''","''","''","blueballno", "blueballno","Fail");
				//htmlFunc.htmlReportFail("''","blueballno","blueballno", "blueballno","Fail");
				System.out.println(e);
				pause(5000);
				driver.quit();
				
		
			}
		}
		/*--------------------------------------------------------------------------------------*
		 *--------This method "answerstatus"is used to verify answer status for each item----------* 
		 *--------------------------------------------------------------------------------------*  
		 */
		//@SuppressWarnings("static-access")
		public static void answerstatusyes(WebDriver driver, int item) throws Exception {
			try{
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("javascript:window.scrollBy(0,8000)");

			WebElement answerstatus = driver.findElement(By.xpath("//*[@id='testing_footer_bmt']/table/tbody/tr/td[3]/table/tbody/tr[1]/td/center"));
			String answertext = answerstatus.getText();
			pause(1000);
			if(answertext.equals("- NOT ANSWERED -"))
			{
				System.out.println("Error: Answer status is  Not Answered for item #"+item);
			}
			}
			catch (Exception e) {
				HF.htmlReportFail("''","''","''","answerstatusyes", "answerstatusyes","Fail");
				//htmlFunc.htmlReportFail("''","answerstatusyes","answerstatusyes", "answerstatusyes","Fail");
				System.out.println(e);
				pause(5000);	
				driver.quit();
			}
		}
		//@SuppressWarnings("static-access")
		public static void answerstatusno(WebDriver driver, int item) throws Exception {
			try{
			WebElement answerstatus = driver.findElement(By.xpath("//*[@id='testing_footer_bmt']/table/tbody/tr/td[3]/table/tbody/tr[1]/td/center"));
			String answertext = answerstatus.getText();
			pause(1000);
			if(answertext.equals("- ANSWERED -"))
			{
				System.out.println("Error: Answer status is  Answered for item #"+item);
			}
			}
			catch (Exception e) {
				HF.htmlReportFail("''","''","''","answerstatusno", "answerstatusno","Fail");
				//htmlFunc.htmlReportFail("''","answerstatusno","answerstatusno", "answerstatusno","Fail");
				System.out.println(e);
				pause(5000);
				driver.quit();			
		
			}
		}
		
				
		/*--------------------------------------------------------------------------------------*
		 *--------This method is used to create log files----------* 
		 *--------------------------------------------------------------------------------------*  
		 */
		
		public static void creatLog(String filepath) throws Exception {
			File file = new File(filepath);  
			FileOutputStream fis = new FileOutputStream(file);  
			PrintStream out = new PrintStream(fis);  
			System.setOut(out); 
		
		
		}
		
		/*--------------------------------------------------------------------------------------*
		 *--------This method is used to DropDown Box Reset and Click Ok on confirmation----------* 
		 *--------------------------------------------------------------------------------------*  
		 */		
		//@SuppressWarnings("static-access")
		public static void dropDownResetOk(int intitem) throws Exception{
			
		try{			
		WebElement reset=driver.findElement(By.xpath(".//*[@id='reset_options']"));
		reset.click();
		System.out.println("Clicked the reset button");
		WebElement okButton=driver.findElement(By.xpath("//html/body/div[7]/div[3]/div/button[1]"));
		okButton.click();
		System.out.println("Clicked the reset's OK button");
		verifyitemnumber(driver, intitem);
		blueballno(driver,intitem);
		answerstatusno(driver,intitem);
	    }
		catch(Exception e){	
			HF.htmlReportFail("''","''","''","dropDownResetOk", "dropDownResetOk","Fail");
			//htmlFunc.htmlReportFail("''","dropDownResetOk","dropDownResetOk", "dropDownResetOk","Fail");
			e.printStackTrace();
			driver.quit();
		}
			
		}
		
		/*--------------------------------------------------------------------------------------*
		 *--------This method is used to DropDown Box Reset and Click cancel on confirmation----------* 
		 *--------------------------------------------------------------------------------------*  
		 */		
		//@SuppressWarnings("static-access")
		public static void dropDownResetCancel() throws Exception{
		try{			
		WebElement reset=driver.findElement(By.xpath(".//*[@id='reset_options']"));
		reset.click();
		System.out.println("Clicked the reset button");
		WebElement cancelButton=driver.findElement(By.xpath("//html/body/div[7]/div[3]/div/button[2]"));
		System.out.println("Clicked the reset's cancel button");
		cancelButton.click();
		}
		catch(Exception e){			
			HF.htmlReportFail("''","''","''","dropDownResetCancel","dropDownResetCancel","Fail");
			//htmlFunc.htmlReportFail("''","dropDownResetCancel","dropDownResetCancel", "dropDownResetCancel","Fail");
			e.printStackTrace();
			driver.quit();
		}
			
		}
		
	
		/*--------------------------------------------------------------------------------------*
		 *--------This method is used to Match Reset and Click Ok on confirmation----------* 
		 *--------------------------------------------------------------------------------------*  
		 */		
		//@SuppressWarnings("static-access")
		public static void matchResetOk(int intitem) throws Exception{
	    try{			
		WebElement reset=driver.findElement(By.xpath(".//*[@id='match_line_resetitem_area_0_match_line_canvas']"));
		reset.click();
		System.out.println("Clicked the reset button");
		WebElement okButton=driver.findElement(By.xpath("//html/body/div[7]/div[3]/div/button[1]"));
		okButton.click();
		System.out.println("Clicked the reset's OK button");
		verifyitemnumber(driver, intitem);
		blueballno(driver,intitem);
		answerstatusno(driver,intitem);
		
	}
		catch(Exception e){			
			HF.htmlReportFail("''","''","''","matchResetOk","matchResetOk","Fail");
			//htmlFunc.htmlReportFail("''","matchResetOk","matchResetOk", "matchResetOk","Fail");
			e.printStackTrace();
			driver.quit();
		}
			
		}
		
		/*--------------------------------------------------------------------------------------*
		 *--------This method is used to Match Reset and Click cancel on confirmation----------* 
		 *--------------------------------------------------------------------------------------*  
		 */		
		//@SuppressWarnings("static-access")
		public static void matchResetCancel() throws Exception{
			
		  try{			
				WebElement reset=driver.findElement(By.xpath(".//*[@id='match_line_resetitem_area_0_match_line_canvas']"));
				reset.click();
				System.out.println("Clicked the reset button");
				WebElement okButton=driver.findElement(By.xpath("//html/body/div[7]/div[3]/div/button[2]"));
				System.out.println("Clicked the reset's cancel button");
				okButton.click();
				
			}
				catch(Exception e){	
					HF.htmlReportFail("''","''","''","matchResetCancel","matchResetCancel","Fail");
					//htmlFunc.htmlReportFail("''","matchResetCancel","matchResetCancel", "matchResetCancel","Fail");
					e.printStackTrace();
					driver.quit();
				}
					
				}
		
		/*--------------------------------------------------------------------------------------*
		 *--------This method is used to Select Text Reset and Click Ok on confirmation----------* 
		 *--------------------------------------------------------------------------------------*  
		 */		
		//@SuppressWarnings("static-access")
		public static void selecttextResetOk(int intitem) throws Exception{
	    try{			
		WebElement reset=driver.findElement(By.xpath(".//*[@id='reset_select']"));
		reset.click();
		System.out.println("Clicked the reset button");
		WebElement okButton=driver.findElement(By.xpath("//html/body/div[9]/div[3]/div/button[1]/span"));
		okButton.click();
		System.out.println("Clicked the reset's OK button");
		verifyitemnumber(driver, intitem);
		blueballno(driver,intitem);
		answerstatusno(driver,intitem);
		
	}
		catch(Exception e){	
			HF.htmlReportFail("''","''","''","selecttextResetOk", "selecttextResetOk","Fail");
			//htmlFunc.htmlReportFail("''","selecttextResetOk","selecttextResetOk", "selecttextResetOk","Fail");
			e.printStackTrace();
			driver.quit();
		}
			
		}
		
		/*--------------------------------------------------------------------------------------*
		 *--------This method is used to Match Reset and Click cancel on confirmation----------* 
		 *--------------------------------------------------------------------------------------*  
		 */		
		//@SuppressWarnings("static-access")
		public static void selecttextResetCancel() throws Exception{
			
		  try{			
				WebElement reset=driver.findElement(By.xpath(".//*[@id='reset_select']"));
				reset.click();
				System.out.println("Clicked the reset button");
				WebElement okButton=driver.findElement(By.xpath("/html/body/div[9]/div[3]/div/button[2]/span"));
				System.out.println("Clicked the reset's cancel button");
				okButton.click();
				
			}
				catch(Exception e){	
					HF.htmlReportFail("''","''","''","selecttextResetCancel","selecttextResetCancel","Fail");
					//htmlFunc.htmlReportFail("''","selecttextResetCancel","selecttextResetCancel", "selecttextResetCancel","Fail");
					e.printStackTrace();
					driver.quit();
				}
					
				}
		
		/*--------------------------------------------------------------------------------------*
		 *--------This method is used to Graph Reset and Click Ok on confirmation----------* 
		 *--------------------------------------------------------------------------------------*  
		 */		
		//@SuppressWarnings("static-access")
		public static void graphResetOk(int intitem) throws Exception{
	    try{			
		WebElement reset=driver.findElement(By.xpath(".//*[@id='item_area_0_grid_reset']"));
		reset.click();
		System.out.println("Clicked the reset button");
		WebElement okButton=driver.findElement(By.xpath("/html/body/div[9]/div[3]/div/button[1]/span"));
		okButton.click();
		System.out.println("Clicked the reset's OK button");
		verifyitemnumber(driver, intitem);
		blueballno(driver,intitem);
		answerstatusno(driver,intitem);
		
	}
		catch(Exception e){			
			HF.htmlReportFail("''","''","''","graphResetOk", "graphResetOk","Fail");
			//htmlFunc.htmlReportFail("''","graphResetOk","graphResetOk", "graphResetOk","Fail");
			e.printStackTrace();
			driver.quit();
		}
			
		}
		
		/*--------------------------------------------------------------------------------------*
		 *--------This method is used to Graph-----------------------------------------------**/		
		//@SuppressWarnings("static-access")
		public static void graphResetCancel() throws Exception{
			
		  try{			
				WebElement reset=driver.findElement(By.xpath(".//*[@id='item_area_0_grid_reset']"));
				reset.click();
				System.out.println("Clicked the reset button");
				WebElement okButton=driver.findElement(By.xpath("/html/body/div[9]/div[3]/div/button[2]/span"));
				System.out.println("Clicked the reset's cancel button");
				okButton.click();
				
			}
				catch(Exception e){	
					HF.htmlReportFail("''","''","''","graphResetCancel","graphResetCancel","Fail");
					//htmlFunc.htmlReportFail("''","graphResetCancel","graphResetCancel", "graphResetCancel","Fail");
					e.printStackTrace();
					driver.quit();
				}
					
				}
		
		
		/*--------------------------------------------------------------------------------------*
		 *--------This method is used to Highlighter-----------------------------------------------**/		
		public static void highlight() throws Exception{
			
		  try{
			  List<WebElement> elements = driver.findElements(By.cssSelector("[display=none]"));
			  int count = elements.size();
			  System.out.println("The size of display:none is:"+count);
			 WebElement canvasArea=driver.findElement(By.xpath(".//*[@id='item_area_0']"));
				//String BeforebgColor = ((WebElement) canvasArea).getCssValue("background-color");
			  String BeforebgColor=driver.findElement(By.xpath(".//*[@id='item_area_0']")).getCssValue("background-color");
		        System.out.println("Before hover: " + BeforebgColor); 
				WebElement highlight=driver.findElement(By.xpath(".//*[@id='highlight-btn']"));
				highlight.click();
				System.out.println("selected highlighter button");

				     
				Actions builder= new Actions(driver);
				Action allactions= builder
						.moveToElement(canvasArea)
						//.moveByOffset(150,450)
						//.moveByOffset(150,450)
						.click()
						.dragAndDropBy(canvasArea,50,100)
						//.release(canvasArea)
						.build();
				allactions.perform();		

				
			}
				catch(Exception e){			
					e.printStackTrace();
				}
					
				}
		
		/*--------------------------------------------------------------------------------------*
		 *--------This method is used to eraser-----------------------------------------------**/		
		public static void eraser(String text) throws Exception{
			
		  try{			
				WebElement erase=driver.findElement(By.xpath(".//*[@id='erase-btn']"));
				erase.click();
				System.out.println("selected Eraser button");
				//pause(10000);	
				//WebElement canvasArea=driver.findElement(By.xpath(".//*[@id='item_area_0']"));
				
				/*Actions builder= new Actions(driver);
				Action allactions= builder
						.moveToElement(canvasArea)
						//.moveByOffset(150,450)
						//.moveByOffset(150,450)						
						.dragAndDropBy(canvasArea,50,100)
						.click()
						
						//.release(canvasArea)
						.build();
				allactions.perform();*/		

							
				Screen screen=new Screen();
				//String image1=text;
				//Pattern image1 = new Pattern(text);
				 Pattern image1 = new Pattern(text).similar((float) 0.7);

				    if(screen.find(image1)!=null){ 
				        screen.mouseMove(image1); 
				        screen.click(image1); 
				    }
				
				
				//screen.wait(image1,0);
				/*if(screen.exists(image1) != null)
				{
				 screen.click(image1,0);	
				 screen.click(screen.getLastMatch());
				 System.out.println("Image1 is available");
				}
				
				//eraserClick(0,940,640);
				//String AfterbgColor = ((WebElement) canvasArea).getCssValue("background-color");
		        //System.out.println("After hover with eraser clicked: " + AfterbgColor);   */
				
			}
				catch(Exception e){			
					e.printStackTrace();
				}
					
				}
		
		/*--------------------------------------------------------------------------------------*
		 *----------------Created by Dinesh on 12-29-2014--------------------------------------*
		 *----------------Used to check the count of MarkForReview functionality------------------------------**/	
		
		public static void verifyMarkReviewCount(WebDriver driver,int noofitems) throws Exception
		{
		try{
			String cntExpText=noofitems+ "questions marked for review.";
			String cntActText=driver.findElement(By.xpath(".//*[@id='oas-test-finish-review']")).getText();
			if(cntActText.equals(cntExpText))
			{
				System.out.println("The text is equal");				
			}
			else
			{
				HF.htmlReportFail("''","''","''","MarkForReview text Mismatch","MarkForReview text Mismatch","Fail");
			}
		
		}
		catch(Exception e)
		{
			HF.htmlReportFail("''","''","''","MarkForReview text Mismatch","MarkForReview text Mismatch","Fail");
			driver.quit();
		}
		
		}
		
		
		
		
		public static void verifyHighlighterNo(String text,int num) throws Exception
		{
		try{
		Screen screen=new Screen();
		String image1=text;
		if(screen.exists(image1) == null)
		{
		System.out.println("Highlighter is not available");
		}
		else
		{
		HF.htmlReportFail("''","''","''","Item#"+num,"Highligter is available","Fail"); 	
		System.out.println("Highlighter is Available");
	    }
		}
		catch(Exception e)
		{
			HF.htmlReportFail("''","''","''","Highligter function failed","Highligter function failed","Fail");
			driver.quit();
		}
		
		}

		/*--------------------------------------------------------------------------------------*
		 *----------------Created by Dinesh on 12-22-2014--------------------------------------*
		 *----------------Used to check highlighter functionality------------------------------**/	
		
		public static void verifyHighlighter(String text,int num) throws Exception
		{
		try{
		Screen screen=new Screen();
		String image1=text;
		if(screen.exists(image1) != null)
		{
		screen.click(screen.getLastMatch());
		System.out.println("Image1 is available");
		}
		else
		{
		HF.htmlReportFail("''","''","''","Item#"+num,"Highligter not available","Fail"); 	
		System.out.println("Not available Image1");
	    }
		}
		catch(Exception e)
		{
			HF.htmlReportFail("''","''","''","Highligter function failed","Highligter function failed","Fail");
			driver.quit();
		}
		
		}
		

		
		public static void eraserClick(int x,int y, int z) throws Exception {
			{
			  
				WebElement canvasArea=driver.findElement(By.xpath(".//*[@id='item_area_0']"));
		        Point objPoint = ((Locatable)canvasArea).getCoordinates().inViewPort();
		        Robot objRobot = new Robot();
		        int intWbEltX = objPoint.x;
		        System.out.print(intWbEltX);
		        int intWbEltY = objPoint.y;
		        System.out.print("\n"+intWbEltY);
		        int intBRWToolbarHeight = x;
		        System.out.print("\n"+intBRWToolbarHeight+"\n");
		        pause(1000);
		        objRobot.mouseMove(y, z);
		        //canvasArea.click();
		        objRobot.mousePress(InputEvent.BUTTON1_MASK);
		        pause(2000);
		        objRobot.mouseRelease(InputEvent.BUTTON1_MASK);
		        pause(8000);
			           		           
			       }
		}

		public static void highlightOld() throws Exception{
			
			  try{
				  List<WebElement> elements = driver.findElements(By.cssSelector("[display=none]"));
				  int count = elements.size();
				  System.out.println("The size of display:none is:"+count);
				 WebElement canvasArea=driver.findElement(By.xpath(".//*[@id='item_area_0']"));
					//String BeforebgColor = ((WebElement) canvasArea).getCssValue("background-color");
				  String BeforebgColor=driver.findElement(By.xpath(".//*[@id='item_area_0']")).getCssValue("background-color");
			        System.out.println("Before hover: " + BeforebgColor); 
					WebElement highlight=driver.findElement(By.xpath(".//*[@id='highlight-btn']"));
					highlight.click();
					System.out.println("selected highlighter button");
					//pause(10000);			
					     
					Actions builder= new Actions(driver);
					Action allactions= builder
							.moveToElement(canvasArea)
							.moveByOffset(150,450)
							//.moveByOffset(150,450)
							.click()
							.dragAndDropBy(canvasArea,155,405)
							//.release(canvasArea)
							.build();
					allactions.perform();
					
					//String bgColor = ((WebElement) allactions).getCssValue("background-color");
			        //System.out.println("Before hover: " + bgColor);   
					       
					
				
					

					//dragandDro(0,300,500);				
				}
					catch(Exception e){			
						e.printStackTrace();
					}
						
					}
			

     	/*--------------------------------------------------------------------------------------*
		 *----------------Created by Dinesh on 12-29-2014--------------------------------------*
		 *----------------Used to check UnMark for Review functionality------------------------------**/
		
		public static void verifyUnmarkForReview(int num) throws Exception
		{
			try{		
		           
		        WebElement yellowColor=driver.findElement(By.xpath(".//*[@id='oas-mark-for-review']"));		
		        String actuUnMarkReview=yellowColor.getAttribute("class");
		        pause(10000);
		       if(actuUnMarkReview.equals(UnmarkForReview))
		       {
			    System.out.println("Item number changed to Mark for Review");
				System.out.println("The value of actuYellowFilledForm"+actuUnMarkReview);
				System.out.println("The value of expecYellowFilledForm"+UnmarkForReview);
		       }
	    	else
	          {
			  HF.htmlReportFail("''","''","''","Unmark ForReview function failed","Unmark For Review not available","Fail");
	          }			
	        }
			catch(Exception e)
			{
				
			}			
		}
   
     	/*--------------------------------------------------------------------------------------*
		 *----------------Created by Dinesh on 12-29-2014--------------------------------------*
		 *----------------Used to check Yellow Filled Form functionality-----------------------**/
		
	
		public static void verifyYellowFilledForm(int num) throws Exception
		{
		 try{
			 WebElement yellowColor=driver.findElement(By.xpath(".//*[@id='oas_goto_"+num+"']"));
		     String actuYellowFilledForm=yellowColor.getAttribute("class");
		     System.out.println("the value of actuYellowFilledForm is:"+actuYellowFilledForm);
		     pause(10000);
		  if(actuYellowFilledForm.equals(YellowFilledForm))
		{
			System.out.println("YellowFilledForm is available for item"+num);
			System.out.println("The value of actuYellowFilledForm"+actuYellowFilledForm);
			System.out.println("The value of expecYellowFilledForm"+YellowFilledForm);
		}
		else
		{
			HF.htmlReportFail("''","''","''","Yellow Filled for item#"+num,"Yellow Filled item not available","Fail");
			driver.quit();
		}
      }
			catch(Exception e)
			{
				HF.htmlReportFail("''","''","''","Yellow Filled item function failed","Yellow Filled item not available","Fail");
				driver.quit();
			}			
		}
 
		
		/*--------------------------------------------------------------------------------------*
		 *----------------Created by Dinesh on 12-29-2014--------------------------------------*
		 *----------------Used to check Mark For Review functionality-----------------------**/
		
      public static void verifyMarkForReview(int num) throws Exception
     {
	  try{		
        WebElement yellowColor=driver.findElement(By.xpath(".//*[@id='oas-mark-for-review']"));		
        String actuUnMarkReview=yellowColor.getAttribute("class");
       if(actuUnMarkReview.equals(MarkForReview))
       {
	    System.out.println("Item number changed to Mark for Review");
		System.out.println("The value of actuYellowFilledForm"+actuUnMarkReview);
		System.out.println("The value of expecYellowFilledForm"+MarkForReview);
       }
	else
      {
	  HF.htmlReportFail("''","''","''","Mark For Review failed","Mark For Review not available","Fail");
      }			
    }
	catch(Exception e)
	{
		
	}			
}

      /*--------------------------------------------------------------------------------------*
       *----------------Created by Dinesh on 12-29-2014----------------------------------------*
	   *----------------Used to check No Yellow Filled Form functionality-----------------------**/
public static void verifyYellowFilledFormNo(int num) throws Exception
{
 try{
	 WebElement yellowColor=driver.findElement(By.xpath(".//*[@id='oas-mark-for-review']"));
     String actuYellowFilledForm=yellowColor.getAttribute("class");
    if(actuYellowFilledForm.equals(UnYellowFilledForm))
		{
			System.out.println("YellowFilledForm is available for item"+num);
			System.out.println("The value of actuYellowFilledForm"+actuYellowFilledForm);
			System.out.println("The value of expecYellowFilledForm"+UnYellowFilledForm);
		}
		else
		{
			HF.htmlReportFail("''","''","''","Yellow Filled for item#"+num,"Yellow Filled item not available","Fail");
		}
}
	catch(Exception e)
	{
		HF.htmlReportFail("''","''","''","Yellow Filled item function failed","Yellow Filled item not available","Fail");
		driver.quit();
	}			
 
 }


	
	
	 /*--------------------------------------------------------------------------------------*
     *----------------Created by Dinesh on 01-05-2015----------------------------------------*
	 *----------------Used to check Invalid Credentials-----------------------**/
  public static void verifyLoginErrorText() throws Exception
  {
   try{
	 
	   String actuloginError=getText(LoginErrorTxt);
	   String loginError="Sorry: Your request could not be processed by our server due to the following error:";
	   String othertext="471 - One or more of the following errors has occurred: Your username is not found, the access code is not found, you are not assigned to the test session, or your password does not match.";
	   String expeLoginError=loginError+"\n"+"\n"+othertext;				
	   System.out.println("Actual loginError Text"+actuloginError);
	   System.out.println("Expected loginError Text"+expeLoginError);	
	   verifyEquals(expeLoginError,actuloginError);
	   clickOn(loginback);
	 }
		catch(Exception e)
	  {
		HF.htmlReportFail("''","''","''","Yellow Filled item function failed","Yellow Filled item not available","Fail");
		driver.quit();
	  }			

}
  
  /*--------------------------------------------------------------------------------------*
   *----------------Created by Dinesh on 01-05-2015----------------------------------------*
	 *----------------Used to check Invalid Credentials in pause page-----------------------**/
  public static void verifyPauseErrorText() throws Exception
 {
  try{	 
	  System.out.println("entered verify loop");
	 // Alert al=driver.switchTo().alert();
	  System.out.println("entered alert");
	  String actupauseError=getText(pauseErrorTxt);
	  String expepauseError="Your password is not correct. Please try again.";
	  System.out.println("Actual loginError Text"+actupauseError);
	  System.out.println("Expected loginError Text"+expepauseError);	
	  verifyEquals(expepauseError,actupauseError);	  
	  //al.accept();
	  clickOn(pauseback);
	  /*String actupauseError=getText(pauseErrorTxt);
	   String expepauseError="Your password is not correct. Please try again.";
	   System.out.println("Actual loginError Text"+actupauseError);
	   System.out.println("Expected loginError Text"+expepauseError);	
	   verifyEquals(expepauseError,actupauseError);
	   clickOn(pauseback);*/
	 }
		catch(Exception e)
	  {
		HF.htmlReportFail("''","''","''","Pause page credetials failed","Pause page credetials failed","Fail");
		driver.quit();
	  }			
  }
  
   /*--------------------------------------------------------------------------------------*
    *----------------Created by Dinesh on 01-05-2015----------------------------------------*
	*----------------Used to check valid credentails for networkdisconnect-----------------------**/
  public static void verifyLoginNetworkDisconnect() throws Exception
  {
	  try{
	   pause(10000);
	   String actuloginnwkError=getText(LoginErrorTxt);
	   String loginError="Sorry: Your request could not be processed by our server due to the following error:";
	   String othertext="You cannot log into this test session because a network disconnect prevented completion of your previous session. Please see your administrator.";
	   String expeLoginnwkError=loginError+"\n"+"\n"+othertext;				
	   System.out.println("Actual loginError Text"+actuloginnwkError);
	   System.out.println("Expected loginError Text"+expeLoginnwkError);	
	   verifyEquals(expeLoginnwkError,actuloginnwkError);
	   clickOn(nwkback);
	 }
		catch(Exception e)
	  {
		HF.htmlReportFail("''","''","''","Yellow Filled item function failed","Yellow Filled item not available","Fail");
		driver.quit();
	  }			

   }
  
  /*--------------------------------------------------------------------------------------*
   *----------------Created by Dinesh on 01-05-2015----------------------------------------*
	*----------------Used to check valid credentials for verifyLoginTestComplete-----------------------**/
 public static void verifyLoginTestCompleted() throws Exception
 {
	  try{
       pause(10000);
	   String actuloginnwkError=getText(LoginErrorTxt);
	   String loginError="Sorry: Your request could not be processed by our server due to the following error:";
	   String othertext="475 - You cannot log into this test session because you have already completed it.";
	   String expeLoginnwkError=loginError+"\n"+"\n"+othertext;				
	   System.out.println("Actual loginError Text"+actuloginnwkError);
	   System.out.println("Expected loginError Text"+expeLoginnwkError);	
	   verifyEquals(expeLoginnwkError,actuloginnwkError);
	   clickOn(nwkback);
	 }
		catch(Exception e)
	  {
		HF.htmlReportFail("''","''","''","Yellow Filled item function failed","Yellow Filled item not available","Fail");
		driver.quit();
	  }			

}

}


	
		
		
		
		

		
		
		
		
			
		
		


