package User_actions;

//import java.awt.Robot;
//import java.awt.event.InputEvent;

/*import java.awt.Robot;
import java.awt.event.InputEvent;
import org.openqa.selenium.Point;
import org.openqa.selenium.internal.Locatable;*/
import java.util.List;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static Config.XlsReader.*;
import static ReusableComponents.commonmethods.*;
//import static UIWrappers.UIobjects.clickOn;
//import static UIWrappers.UIobjects.enterData;
import static UIWrappers.UIobjects.log;
import static User_actions.mixedItems.*;
import ReusableComponents.htmlReport;
import UIWrappers.Page;
import static UIWrappers.UIobjects.*;

@Listeners({ReportsUtils.CustomReport.class,ReportsUtils.ReportSetup.class})

public class TEItems extends Page {
	htmlReport HF = new htmlReport();
	
@Test(enabled=false)		
public void dropDown() throws Exception{
	try{	
	Fetchmethod("Sheet1");
    int rowno = FindRowno("MixedItems");
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
	System.out.println("The uname is:"+uname);
	System.out.println("The pwd is:"+pwd);
	System.out.println("The accesscode is:"+accesscode);
	System.out.println("The Testname is:"+Testname);
	System.out.println("The Testname is:"+intitem);
	System.out.println("The noofitem is:"+response);
	log("Actual Result: Fetching UserName,Password,Access Code,TestName,noofItems,responses");
	
	log("Step 4: Entering Username,password,Accesscode");
	//Login with Username, Password, Accesscode
	//superAdminLogin(String Username, String Password, String Accesscode);
	log("Actual Result: Entered Username,password,Accesscode");
	
	log("Step 5: Selecting TestName");
	select_test(Testname, driver);
	log("Actual Result: Selected TestName");
	
	log("Step 6: Clicking Login Button.");
    //Clicking on Login button
    BMTLogin(driver); 
    log("Actual Result: Clicked Login button");
    
    log("Step 7: Clicking start in welcome screen.");
    //Clicking on Start in welcome screen
    Welcomestart(driver);
    log("Actual Result : Clicked start in welcome screen.");
   
   log("Step 8: Started giving responses");	
   
		for (int i=1;i<intitem+1;i++)
		{
		itemnavigation(driver, i);	
		verifyitemnumber(driver, i);
		Thread.sleep(3000);
		int select=1;
		WebElement dropdown = driver.findElement(By.xpath("//*[@id='options_table']/tbody/tr/td[2]/span/p"));
		List<WebElement> noofdropdowns = dropdown.findElements(By.tagName("select"));
		if(noofdropdowns.size()==0)
		{
			WebElement dropdown0 = driver.findElement(By.xpath("//*[@id='options_table']/tbody/tr/td[2]/span/p/select"));
			List<WebElement> values = dropdown0.findElements(By.tagName("option"));
			for(int valueselect=1;valueselect<values.size()+1;valueselect++)
			{
			WebElement vselect = driver.findElement(By.xpath("//*[@id='options_table']/tbody/tr/td[2]/span/p/select/option["+valueselect+"]"));
			vselect.click();
			Thread.sleep(1000);
			}
			blueballyes(driver, i);
			answerstatusyes(driver, i);
		}
		for(WebElement onedropdown : noofdropdowns)
		{
			List<WebElement> values = onedropdown.findElements(By.tagName("option"));
			for(int valueselect=1;valueselect<values.size()+1;valueselect++)
			{
				if(noofdropdowns.size()==0)
				{
					WebElement vselect = driver.findElement(By.xpath("//*[@id='options_table']/tbody/tr/td[2]/span/p/select/option["+valueselect+"]"));
					vselect.click();
					Thread.sleep(1000);
				
				}
				else
				{
				WebElement vselect = driver.findElement(By.xpath("//*[@id='options_table']/tbody/tr/td[2]/span/p/select["+select+"]/option["+valueselect+"]"));
				vselect.click();
				Thread.sleep(1000);
				}
			}
			select++;
			blueballyes(driver, i);
			answerstatusyes(driver, i);
			
		}
	}
		finishtest(driver);
		stopyes(driver);
	}
	catch(Exception e)
	 {	
		HF.htmlReportFail("''","''","''","''","Aborted dropDown","Fail");
		driver.quit();
	 }
}

@Test(enabled=false)

public void multiplechoice() throws Exception
{
	try{	
	log("Step 1:Test Case name: Mixed Items");
	log("Started reading reference from Excel, sheet1");
	Fetchmethod("Sheet1");
    int rowno = FindRowno("MixedItems");
    FetchExceldata(rowno);
    log("Actual Result: Identified the Mixed Items in sheet 1");
    
	log("Step 2: Hitting the BMT URL");	
	log("Actual Result: Browser Intialized and navigated to target URL");
	
	log("Step 3: Fetching UserName, Password, Access Code,TestName,noofItems,responses");
	String uname = localArray1[0][0];
	String pwd = localArray1[0][1];
	String acccode = localArray1[0][2];
	Integer accesscode =Integer.parseInt(acccode);
	String Testname = localArray1[0][3];
	String noofitem1 = localArray1[0][4];
	Integer intitem =Integer.parseInt(noofitem1);
	System.out.println("The uname is:"+uname);
	System.out.println("The pwd is:"+pwd);
	System.out.println("The accesscode is:"+accesscode);
	System.out.println("The Testname is:"+Testname);
	System.out.println("The Testname is:"+intitem);
	log("Actual Result: Fetching UserName,Password,Access Code,TestName,noofItems,responses");
	
	log("Step 4: Entering Username,password,Accesscode");
	//Login with Username, Password, Accesscode
	//superAdminLogin(String Username, String Password, String Accesscode);
	log("Actual Result: Entered Username,password,Accesscode");
	
	log("Step 5: Selecting TestName");
	select_test(Testname, driver);
	log("Actual Result: Selected TestName");
	
	log("Step 6: Clicking Login Button.");
    //Clicking on Login button
    BMTLogin(driver); 
    log("Actual Result: Clicked Login button");
    
    log("Step 7: Clicking start in welcome screen.");
    //Clicking on Start in welcome screen
    Welcomestart(driver);
    log("Actual Result : Clicked start in welcome screen.");
   
   log("Step 8: Started giving responses");	
	
	
	for (int i=1;i<intitem+1;i++)
	{
	itemnavigation(driver, i);	
	verifyitemnumber(driver, i);
	Thread.sleep(3000);
	for(int response=1;response<5;response++)
	{
	WebElement sranswer = driver.findElement(By.xpath("//*[@id='img_mc"+response+"_item_area_0_multiple_choices']"));
	sranswer.click();
	blueballyes(driver, intitem);
	answerstatusyes(driver, intitem);
	}
	}
	finishtest(driver);
	stopyes(driver);
	}
	catch(Exception e)
	 {
	HF.htmlReportFail("''","''","''","''","Aborted multiplechoice","Fail");
	driver.quit();
	 }
}

@Test(enabled=false)		
public void multipleselect() throws Exception
{
	try{
	log("Step 1:Test Case name: Mixed Items");
	log("Started reading reference from Excel, sheet1");
	Fetchmethod("Sheet1");
    int rowno = FindRowno("MixedItems");
    FetchExceldata(rowno);
    log("Actual Result: Identified the Mixed Items in sheet 1");
    
	log("Step 2: Hitting the BMT URL");	
	log("Actual Result: Browser Intialized and navigated to target URL");
	
	log("Step 3: Fetching UserName, Password, Access Code,TestName,noofItems,responses");
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
	log("Actual Result: Fetching UserName,Password,Access Code,TestName,noofItems,responses");
	
	log("Step 4: Entering Username,password,Accesscode");
	//Login with Username, Password, Accesscode
	//superAdminLogin(String Username, String Password, String Accesscode);
	log("Actual Result: Entered Username,password,Accesscode");
	
	log("Step 5: Selecting TestName");
	select_test(Testname, driver);
	log("Actual Result: Selected TestName");
	
	log("Step 6: Clicking Login Button.");
    //Clicking on Login button
    BMTLogin(driver); 
    log("Actual Result: Clicked Login button");
    
    log("Step 7: Clicking start in welcome screen.");
    //Clicking on Start in welcome screen
    Welcomestart(driver);
    log("Actual Result : Clicked start in welcome screen.");
   
   log("Step 8: Started giving responses");	

	for(int noofitems=1;noofitems<noofitem+1;noofitems++)
	{
		 JavascriptExecutor js = (JavascriptExecutor) driver;
         js.executeScript("javascript:window.scrollBy(0,8000)");
         itemnavigation(driver, noofitems);
         verifyitemnumber(driver, noofitems);
		
	int count = (driver.findElements(By.xpath("//table[@id='item_area_0_multiple_selections']/tbody/tr")).size());
	
	for(int i=1;i<=count;i++)
	{
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("javascript:window.scrollBy(0,8000)");
        driver.findElement(By.xpath("//input[@id='ms"+i+"_item_area_0_multiple_selections']")).click();
		blueballyes(driver, noofitems);
		answerstatusyes(driver,noofitems);
		Thread.sleep(1000);
					
	}
				
	}
	finishtest(driver);
	stopyes(driver);
	}
	catch(Exception e)
	 {
	 HF.htmlReportFail("''","''","''","''","Aborted multipleselect","Fail");
	 driver.quit();
	 }
}

@Test(enabled=false)		
public void placingpoint() throws Exception
{
	try{	
	log("Step 1:Test Case name: Mixed Items");
	log("Started reading reference from Excel, sheet1");
	Fetchmethod("Sheet1");
    int rowno = FindRowno("MixedItems");
    FetchExceldata(rowno);
    log("Actual Result: Identified the Mixed Items in sheet 1");
    
	log("Step 2: Hitting the BMT URL");	
	log("Actual Result: Browser Intialized and navigated to target URL");
	
	log("Step 3: Fetching UserName, Password, Access Code,TestName,noofItems,responses");
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
	log("Actual Result: Fetching UserName,Password,Access Code,TestName,noofItems,responses");
	
	log("Step 4: Entering Username,password,Accesscode");
	//Login with Username, Password, Accesscode
	//superAdminLogin(String Username, String Password, String Accesscode);
	log("Actual Result: Entered Username,password,Accesscode");
	
	log("Step 5: Selecting TestName");
	select_test(Testname, driver);
	log("Actual Result: Selected TestName");
	
	log("Step 6: Clicking Login Button.");
    //Clicking on Login button
    BMTLogin(driver); 
    log("Actual Result: Clicked Login button");
    
    log("Step 7: Clicking start in welcome screen.");
    //Clicking on Start in welcome screen
    Welcomestart(driver);
    log("Actual Result : Clicked start in welcome screen.");
   
   log("Step 8: Started giving responses");	

  for(int noofitems=1;noofitems<noofitem+1;noofitems++)
   {
   itemnavigation(driver, noofitems);	
   verifyitemnumber(driver, noofitems);
   Thread.sleep(3000);
   //((JavascriptExecutor)driver).executeScript("arguments[0].checked = true;", inputElement);
   WebElement table_element = driver.findElement(By.xpath("//*[@id='item_area_0_foreground_canvas']"));
   Thread.sleep(1000);
   new Actions(driver).moveToElement(table_element,0,0).moveByOffset(160,240).click().build().perform();
   Thread.sleep(1000);
   blueballyes(driver, noofitems);
   answerstatusyes(driver, noofitems);
   graphResetCancel();
   blueballyes(driver, noofitems);
   answerstatusyes(driver, noofitems);
   graphResetOk(noofitems);
   new Actions(driver).moveToElement(table_element,0,0).moveByOffset(160,240).click().build().perform();
   Thread.sleep(1000);
   blueballyes(driver, noofitems);
   answerstatusyes(driver, noofitems);
}
finishtest(driver);
stopyes(driver);
	}
	catch(Exception e)
	 {	
		HF.htmlReportFail("''","''","''","''","Aborted placingpoint","Fail");
		driver.quit();
	 }
}

@Test(enabled=false)		
public void singlecircle() throws Exception
{
	try{
	log("Step 1:Test Case name: Mixed Items");
	log("Started reading reference from Excel, sheet1");
	Fetchmethod("Sheet1");
    int rowno = FindRowno("MixedItems");
    FetchExceldata(rowno);
    log("Actual Result: Identified the Mixed Items in sheet 1");
    
	log("Step 2: Hitting the BMT URL");	
	log("Actual Result: Browser Intialized and navigated to target URL");
	
	log("Step 3: Fetching UserName, Password, Access Code,TestName,noofItems,responses");
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
	log("Actual Result: Fetching UserName,Password,Access Code,TestName,noofItems,responses");
	
	log("Step 4: Entering Username,password,Accesscode");
	//Login with Username, Password, Accesscode
	//superAdminLogin(String Username, String Password, String Accesscode);
	log("Actual Result: Entered Username,password,Accesscode");
	
	log("Step 5: Selecting TestName");
	select_test(Testname, driver);
	log("Actual Result: Selected TestName");
	
	log("Step 6: Clicking Login Button.");
    //Clicking on Login button
    BMTLogin(driver); 
    log("Actual Result: Clicked Login button");
    
    log("Step 7: Clicking start in welcome screen.");
    //Clicking on Start in welcome screen
    Welcomestart(driver);
    log("Actual Result : Clicked start in welcome screen.");
   
   log("Step 8: Started giving responses");	

for(int noofitems=1;noofitems<noofitem+1;noofitems++)
{
itemnavigation(driver, noofitems);	
//
verifyitemnumber(driver, noofitems);
Thread.sleep(3000);
//((JavascriptExecutor)driver).executeScript("arguments[0].checked = true;", inputElement);
WebElement table_element = driver.findElement(By.xpath("//*[@id='item_area_0_foreground_canvas']"));
Thread.sleep(1000);
new Actions(driver).moveToElement(table_element,0,0).moveByOffset(160,240).click().build().perform();
Thread.sleep(1000);
new Actions(driver).moveToElement(table_element,0,0).moveByOffset(320,240).click().build().perform();
Thread.sleep(1000);
blueballyes(driver, noofitems);
answerstatusyes(driver, noofitems);
graphResetCancel();
blueballyes(driver, noofitems);
answerstatusyes(driver, noofitems);
graphResetOk(noofitems);
new Actions(driver).moveToElement(table_element,0,0).moveByOffset(160,240).click().build().perform();
Thread.sleep(1000);
new Actions(driver).moveToElement(table_element,0,0).moveByOffset(320,240).click().build().perform();
Thread.sleep(1000);
blueballyes(driver, noofitems);
answerstatusyes(driver, noofitems);


}
finishtest(driver);
stopyes(driver);
	}
	catch(Exception e)
	 {	
		HF.htmlReportFail("''","''","''","''","Aborted singlecircle","Fail");
		driver.quit();
	 }
}

@Test(enabled=false)		
public void singleparabola() throws Exception
{
	try{
	log("Step 1:Test Case name: Mixed Items");
	log("Started reading reference from Excel, sheet1");
	Fetchmethod("Sheet1");
    int rowno = FindRowno("MixedItems");
    FetchExceldata(rowno);
    log("Actual Result: Identified the Mixed Items in sheet 1");
    
	log("Step 2: Hitting the BMT URL");	
	log("Actual Result: Browser Intialized and navigated to target URL");
	
	log("Step 3: Fetching UserName, Password, Access Code,TestName,noofItems,responses");
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
	log("Actual Result: Fetching UserName,Password,Access Code,TestName,noofItems,responses");
	
	log("Step 4: Entering Username,password,Accesscode");
	//Login with Username, Password, Accesscode
	//superAdminLogin(String Username, String Password, String Accesscode);
	log("Actual Result: Entered Username,password,Accesscode");
	
	log("Step 5: Selecting TestName");
	select_test(Testname, driver);
	log("Actual Result: Selected TestName");
	
	log("Step 6: Clicking Login Button.");
    //Clicking on Login button
    BMTLogin(driver); 
    log("Actual Result: Clicked Login button");
    
    log("Step 7: Clicking start in welcome screen.");
    //Clicking on Start in welcome screen
    Welcomestart(driver);
    log("Actual Result : Clicked start in welcome screen.");
   
   log("Step 8: Started giving responses");	

for(int noofitems=1;noofitems<noofitem+1;noofitems++)
{
itemnavigation(driver, noofitems);	
//
verifyitemnumber(driver, noofitems);
Thread.sleep(3000);
//((JavascriptExecutor)driver).executeScript("arguments[0].checked = true;", inputElement);
WebElement table_element = driver.findElement(By.xpath("//*[@id='item_area_0_foreground_canvas']"));
Thread.sleep(1000);
WebElement table_orientationup = driver.findElement(By.xpath("//*[@id='open_upitem_area_0_grid_canvas']"));
table_orientationup.click();
new Actions(driver).moveToElement(table_element,0,0).moveByOffset(320,240).click().build().perform();
Thread.sleep(1000);
blueballyes(driver, noofitems);
answerstatusyes(driver, noofitems);
graphResetCancel();
blueballyes(driver, noofitems);
answerstatusyes(driver, noofitems);
graphResetOk(noofitems);
WebElement table_orientationdown = driver.findElement(By.xpath("//*[@id='open_downitem_area_0_grid_canvas']"));
table_orientationdown.click();
new Actions(driver).moveToElement(table_element,0,0).moveByOffset(320,240).click().build().perform();
Thread.sleep(1000);
blueballyes(driver, noofitems);
answerstatusyes(driver, noofitems);
graphResetCancel();
blueballyes(driver, noofitems);
answerstatusyes(driver, noofitems);
graphResetOk(noofitems);
WebElement table_orientationright = driver.findElement(By.xpath("//*[@id='open_rightitem_area_0_grid_canvas']"));
table_orientationright.click();
new Actions(driver).moveToElement(table_element,0,0).moveByOffset(320,240).click().build().perform();
Thread.sleep(1000);
blueballyes(driver, noofitems);
answerstatusyes(driver, noofitems);
graphResetCancel();
blueballyes(driver, noofitems);
answerstatusyes(driver, noofitems);
graphResetOk(noofitems);
WebElement table_orientationleft = driver.findElement(By.xpath("//*[@id='open_leftitem_area_0_grid_canvas']"));
table_orientationleft.click();
new Actions(driver).moveToElement(table_element,0,0).moveByOffset(320,240).click().build().perform();
Thread.sleep(1000);
blueballyes(driver, noofitems);
answerstatusyes(driver, noofitems);
graphResetCancel();
blueballyes(driver, noofitems);
answerstatusyes(driver, noofitems);
graphResetOk(noofitems);
table_orientationleft.click();
new Actions(driver).moveToElement(table_element,0,0).moveByOffset(320,240).click().build().perform();
Thread.sleep(1000);
blueballyes(driver, noofitems);
answerstatusyes(driver, noofitems);
}
finishtest(driver);
stopyes(driver);
	}
	catch(Exception e)
	 {	
		HF.htmlReportFail("''","''","''","''","Aborted singleparabola","Fail");
		driver.quit();
	 }
}

@Test(enabled=false)		
public void selectext() throws Exception
{
	try{
	log("Step 1:Test Case name: Mixed Items");
	log("Started reading reference from Excel, sheet1");
	Fetchmethod("Sheet1");
    int rowno = FindRowno("MixedItems");
    FetchExceldata(rowno);
    log("Actual Result: Identified the Mixed Items in sheet 1");
    
	log("Step 2: Hitting the BMT URL");	
	log("Actual Result: Browser Intialized and navigated to target URL");
	
	log("Step 3: Fetching UserName, Password, Access Code,TestName,noofItems,responses");
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
	log("Actual Result: Fetching UserName,Password,Access Code,TestName,noofItems,responses");
	
	log("Step 4: Entering Username,password,Accesscode");
	//Login with Username, Password, Accesscode
	//superAdminLogin(String Username, String Password, String Accesscode);
	log("Actual Result: Entered Username,password,Accesscode");
	
	log("Step 5: Selecting TestName");
	select_test(Testname, driver);
	log("Actual Result: Selected TestName");
	
	log("Step 6: Clicking Login Button.");
    //Clicking on Login button
    BMTLogin(driver); 
    log("Actual Result: Clicked Login button");
    
    log("Step 7: Clicking start in welcome screen.");
    //Clicking on Start in welcome screen
    Welcomestart(driver);
    log("Actual Result : Clicked start in welcome screen.");
   
   log("Step 8: Started giving responses");	
   

for(int noofitems=1;noofitems<noofitem+1;noofitems++)
{
itemnavigation(driver, noofitems);	
//
verifyitemnumber(driver, noofitems);
Thread.sleep(3000);
int count = (driver.findElements(By.xpath("//*[@id='item_area_0']/table/tbody/tr/td[2]/font/table/tbody/tr/td[2]/div/span")).size());
for(int i=1;i<count+1;i++)
{
WebElement selecttestrespopnse = driver.findElement(By.xpath("//*[@id='T"+i+"']"));
selecttestrespopnse.click();
blueballyes(driver, noofitems);
answerstatusyes(driver, noofitems);

}
selecttextResetCancel();
blueballyes(driver, noofitems);
answerstatusyes(driver, noofitems);
selecttextResetOk(noofitems);
blueballno(driver,noofitems);
answerstatusno(driver, noofitems);
Thread.sleep(1000);
WebElement selecttestrespopnse = driver.findElement(By.xpath("//*[@id='T1']"));
selecttestrespopnse.click();
blueballyes(driver, noofitems);
answerstatusyes(driver, noofitems);
}
finishtest(driver);
stopyes(driver);
	}
	catch(Exception e)
	 {	
		HF.htmlReportFail("''","''","''","''","Aborted selectext","Fail");
		driver.quit();
	 }
}

@Test(enabled=false)		
public void matchingitems() throws Exception
{
	try{
	log("Step 1:Test Case name: Matchingitems");
	log("Started reading reference from Excel, sheet1");
	Fetchmethod("Sheet1");
    int rowno = FindRowno("MatchingItems");
    FetchExceldata(rowno);
    log("Actual Result: Identified the Mixed Items in sheet 1");
    
	log("Step 2: Hitting the BMT URL");	
	log("Actual Result: Browser Intialized and navigated to target URL");
	
	log("Step 3: Fetching UserName, Password, Access Code,TestName,noofItems,responses");
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
	log("Actual Result: Fetching UserName,Password,Access Code,TestName,noofItems,responses");
	
	log("Step 4: Entering Username,password,Accesscode");
	//Login with Username, Password, Accesscode
	//superAdminLogin(String Username, String Password, String Accesscode);
	log("Actual Result: Entered Username,password,Accesscode");
	
	log("Step 5: Selecting TestName");
	select_test(Testname, driver);
	log("Actual Result: Selected TestName");
	
	log("Step 6: Clicking Login Button.");
    //Clicking on Login button
    BMTLogin(driver); 
    log("Actual Result: Clicked Login button");
    
    log("Step 7: Clicking start in welcome screen.");
    //Clicking on Start in welcome screen
    Welcomestart(driver);
    log("Actual Result : Clicked start in welcome screen.");
   
   log("Step 8: Started giving responses");	
   
for(int noofitems=1;noofitems<noofitem+1;noofitems++)
{
	FetchExceldata(response);
	String count1 = localArray1[0][0];
	Integer count =Integer.parseInt(count1);
	String pxoffset1 = localArray1[0][1];
	Integer pxoffset =Integer.parseInt(pxoffset1);
	String rxoffset1 = localArray1[0][2];
	Integer rxoffset =Integer.parseInt(rxoffset1);
	
itemnavigation(driver, noofitems);	
//
verifyitemnumber(driver, noofitems);
Thread.sleep(3000);
for(int yoffset=3;yoffset<count;yoffset++)
{
	String pyoffset1 = localArray1[0][yoffset];
	Integer pyoffset =Integer.parseInt(pyoffset1);
	yoffset = yoffset+1;
	String ryoffset1 = localArray1[0][yoffset];
	Integer ryoffset =Integer.parseInt(ryoffset1);
	WebElement table_element = driver.findElement(By.xpath("//*[@id='item_area_0_match_line_canvas']"));
	Thread.sleep(1000);
	
	new Actions(driver).moveToElement(table_element,0,0).moveByOffset(pxoffset,pyoffset).click().build().perform();
	Thread.sleep(1000);
	
	new Actions(driver).moveToElement(table_element,0,0).moveByOffset(rxoffset,ryoffset).click().build().perform();
	Thread.sleep(1000);
	
}
}
finishtest(driver);
stopyes(driver);
	}
	catch(Exception e)
	 {	
		HF.htmlReportFail("''","''","''","''","Aborted matchingitems","Fail");
		driver.quit();
	 }
}

@Test(enabled=true)		
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

@Test(enabled=false)		
public void matchingtable() throws Exception
{
	try{		
	log("Step 1:Test Case name: Mixed Items");
	log("Started reading reference from Excel, sheet1");
	Fetchmethod("Sheet1");
    int rowno = FindRowno("MixedItems");
    FetchExceldata(rowno);
    log("Actual Result: Identified the Mixed Items in sheet 1");
    
	log("Step 2: Hitting the BMT URL");	
	log("Actual Result: Browser Intialized and navigated to target URL");
	
	log("Step 3: Fetching UserName, Password, Access Code,TestName,noofItems,responses");
	String uname = localArray1[0][0];
	String pwd = localArray1[0][1];
	String acccode = localArray1[0][2];
	Integer accesscode =Integer.parseInt(acccode);
	String Testname = localArray1[0][3];
	String noofitem1 = localArray1[0][4];
	Integer noofitem =Integer.parseInt(noofitem1);
	String response1 = localArray1[0][5];
	Integer responsedata =Integer.parseInt(response1);	
	System.out.println("The uname is:"+uname);
	System.out.println("The pwd is:"+pwd);
	System.out.println("The accesscode is:"+accesscode);
	System.out.println("The Testname is:"+Testname);
	System.out.println("The Testname is:"+noofitem);
	System.out.println("The noofitem is:"+responsedata);
	log("Actual Result: Fetching UserName,Password,Access Code,TestName,noofItems,responses");
	
	log("Step 4: Entering Username,password,Accesscode");
	//Login with Username, Password, Accesscode
	//superAdminLogin(String Username, String Password, String Accesscode);
	log("Actual Result: Entered Username,password,Accesscode");
	
	log("Step 5: Selecting TestName");
	select_test(Testname, driver);
	log("Actual Result: Selected TestName");
	
	log("Step 6: Clicking Login Button.");
    //Clicking on Login button
    BMTLogin(driver); 
    log("Actual Result: Clicked Login button");
    
    log("Step 7: Clicking start in welcome screen.");
    //Clicking on Start in welcome screen
    Welcomestart(driver);
    log("Actual Result : Clicked start in welcome screen.");
   
   log("Step 8: Started giving responses");	

for(int noofitems=1;noofitems<noofitem+1;noofitems++)
{
	itemnavigation(driver, noofitems);	
	verifyitemnumber(driver, noofitems);
	Thread.sleep(5000);
	WebElement sourcepremises = driver.findElement(By.xpath("//*[@id='item_area_0_match_checks']/tbody"));
	List<WebElement> noofrows = sourcepremises.findElements(By.tagName("tr"));
	WebElement sourcetable = driver.findElement(By.xpath("//*[@id='item_area_0_match_checks']/tbody/tr[2]"));
	List<WebElement> noofcols = sourcetable.findElements(By.tagName("td"));
	for(int i=1;i<noofrows.size();i++)
	{
		for(int j=1;j<noofcols.size();j++)
		{
			WebElement response = driver.findElement(By.xpath("//*[@id='img_p"+i+"-r"+j+"']"));
			response.click();
			blueballyes(driver,noofitems);
			answerstatusyes(driver,noofitems);
		}
	}
	
}
finishtest(driver);
stopyes(driver);
	}
	catch(Exception e)
	 {	
		HF.htmlReportFail("''","''","''","''","Aborted matchingtable","Fail");
		driver.quit();
	 }
}

@Test(enabled=false)		
public void selectorder() throws Exception
{
	try{	
	log("Step 1:Test Case name: Mixed Items");
	log("Started reading reference from Excel, sheet1");
	Fetchmethod("Sheet1");
    int rowno = FindRowno("MixedItems");
    FetchExceldata(rowno);
    log("Actual Result: Identified the Mixed Items in sheet 1");
    
	log("Step 2: Hitting the BMT URL");	
	log("Actual Result: Browser Intialized and navigated to target URL");
	
	log("Step 3: Fetching UserName, Password, Access Code,TestName,noofItems,responses");
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
	log("Actual Result: Fetching UserName,Password,Access Code,TestName,noofItems,responses");
	
	log("Step 4: Entering Username,password,Accesscode");
	//Login with Username, Password, Accesscode
	//superAdminLogin(String Username, String Password, String Accesscode);
	log("Actual Result: Entered Username,password,Accesscode");
	
	log("Step 5: Selecting TestName");
	select_test(Testname, driver);
	log("Actual Result: Selected TestName");
	
	log("Step 6: Clicking Login Button.");
    //Clicking on Login button
    BMTLogin(driver); 
    log("Actual Result: Clicked Login button");
    
    log("Step 7: Clicking start in welcome screen.");
    //Clicking on Start in welcome screen
    Welcomestart(driver);
    log("Actual Result : Clicked start in welcome screen.");
   
   log("Step 8: Started giving responses");	

for(int noofitems=1;noofitems<noofitem+1;noofitems++)
{
	FetchExceldata(response);
	String count1 = localArray1[0][0];
	Integer count =Integer.parseInt(count1);
	itemnavigation(driver, noofitems);	
	verifyitemnumber(driver, noofitems);
	Thread.sleep(3000);
	int div =1;
for(int yoffset=1;yoffset<(count*2)+1;yoffset++)
{
	WebElement drag1 = driver.findElement(By.xpath("//*[@id='src_div']/div["+div+"]"));
	div++;
	WebElement drag2 = driver.findElement(By.xpath("//*[@id='item_area_0']/table/tbody/tr/td[2]/font/table/tbody/tr/td[2]/table/tbody/tr[1]/td[1]/img"));
	String pyoffset1 = localArray1[0][yoffset];
	Integer pyoffset =Integer.parseInt(pyoffset1);
	System.out.println(pyoffset);
	yoffset=yoffset+1;
	String ryoffset1 = localArray1[0][yoffset];
	Integer ryoffset =Integer.parseInt(ryoffset1);
	System.out.println(ryoffset);
	Thread.sleep(1000);
	Actions drop = new Actions(driver);
	drop.dragAndDrop(drag1, drag2).perform();
	drop.dragAndDropBy(drag1, pyoffset, ryoffset);
	Thread.sleep(3000);
	Thread.sleep(1000);
	}
blueballyes(driver,noofitems);
answerstatusyes(driver,noofitems);
response++;
}
finishtest(driver);
stopyes(driver);
	}
	catch(Exception e)
	 {
	 HF.htmlReportFail("''","''","''","''","Aborted selectorder","Fail");
	 driver.quit();
	 }
}

@Test(enabled=false)
public void Equationentry() throws Exception
{
	try{	
	log("Step 1:Test Case name: Mixed Items");
	log("Started reading reference from Excel, sheet1");
	Fetchmethod("Sheet1");
    int rowno = FindRowno("MixedItems");
    FetchExceldata(rowno);
    log("Actual Result: Identified the Mixed Items in sheet 1");
    
	log("Step 2: Hitting the BMT URL");	
	log("Actual Result: Browser Intialized and navigated to target URL");
	
	log("Step 3: Fetching UserName, Password, Access Code,TestName,noofItems,responses");
	String uname = localArray1[0][0];
	String pwd = localArray1[0][1];
	String acccode = localArray1[0][2];
	Integer accesscode =Integer.parseInt(acccode);
	String Testname = localArray1[0][3];
	String noofitem1 = localArray1[0][4];
	Integer intitem =Integer.parseInt(noofitem1);
	String response1 = localArray1[0][5];
	Integer responses =Integer.parseInt(response1);	
	System.out.println("The uname is:"+uname);
	System.out.println("The pwd is:"+pwd);
	System.out.println("The accesscode is:"+accesscode);
	System.out.println("The Testname is:"+Testname);
	System.out.println("The Testname is:"+intitem);
	System.out.println("The noofitem is:"+responses);
	log("Actual Result: Fetching UserName,Password,Access Code,TestName,noofItems,responses");
	
	log("Step 4: Entering Username,password,Accesscode");
	//Login with Username, Password, Accesscode
	//superAdminLogin(String Username, String Password, String Accesscode);
	log("Actual Result: Entered Username,password,Accesscode");
	
	log("Step 5: Selecting TestName");
	select_test(Testname, driver);
	log("Actual Result: Selected TestName");
	
	log("Step 6: Clicking Login Button.");
    //Clicking on Login button
    BMTLogin(driver); 
    log("Actual Result: Clicked Login button");
    
    log("Step 7: Clicking start in welcome screen.");
    //Clicking on Start in welcome screen
    Welcomestart(driver);
    log("Actual Result : Clicked start in welcome screen.");
   
   log("Step 8: Started giving responses");	
   
   for (int i=1;i<intitem+1;i++)
   {
	FetchExceldata(responses);
	String eeeresponses = localArray1[0][0];
	String eeeresponse[] = eeeresponses.split(",");
	Integer count = eeeresponse.length;
	System.out.println(count);
	itemnavigation(driver, i);	
	verifyitemnumber(driver, i);
	Thread.sleep(3000);
	WebElement container = driver.findElement(By.xpath("//*[@id='Controls_Content_equation_container_0']"));
	List<WebElement> buttons = container.findElements(By.tagName("Button"));

for(int j=0;j<count-2;j++)
{
	System.out.println(eeeresponse[j]);
	for(WebElement button:buttons)
{
	String buttonname = button.getText();
	
	if(eeeresponse[j].equals(buttonname))
	{
		String buttonpath = button.getAttribute("id");
		WebElement buttonclick = driver.findElement(By.xpath("//*[@id='"+buttonpath+"']"));
		buttonclick.click();
		Thread.sleep(1000);
		break;
	}
}
}
WebElement value = driver.findElement(By.xpath("//*[@id='dynamic_item_json_text_0']"));
System.out.println("The value is:"+value);
blueballyes(driver, i);
answerstatusyes(driver, i);
	
responses++;
}
finishtest(driver);
stopyes(driver);
	}
	catch(Exception e)
	 {	
		HF.htmlReportFail("''","''","''","''","Aborted Equationentry","Fail");
		driver.quit();
	 }
}



}
