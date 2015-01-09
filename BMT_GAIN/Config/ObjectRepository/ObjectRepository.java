package ObjectRepository;

import org.openqa.selenium.By;

public class ObjectRepository {
	
	//public static By loginID = By.xpath("/html/body/div[3]/div[1]/div/div/div[1]/div/center/div[1]/form/div[1]/div/input");
	public static By loginID = By.xpath(".//*[@id='frmUsername']"); 
	//public static By password = By.xpath("/html/body/div[3]/div[1]/div/div/div[1]/div/center/div[1]/form/div[2]/div[2]/input");
	public static By password = By.xpath(".//*[@id='frmPassword']");
	public static By accesscode = By.xpath(".//*[@id='frmSiteCode']");
	public static By loginButton = By.xpath(".//*[@id='login_container']/div/div/div[1]/div/center/div[2]/button[2]");
	public static By markForReview=By.xpath(".//*[@id='oas-mark-for-review']");
	public static By WelcomeText=By.xpath(".//*[@id='view_container']/div[1]/h1[1]");
	public static By getStarted=By.xpath(".//*[@id='view_container']/div[1]/h1[2]");
	public static By getaltText=By.xpath("html/body/div[11]/div[1]/span");
	public static By backLogin=By.xpath("html/body/div[11]/div[3]/div/button");
	public static By questid=By.xpath(".//*[@id='view_container']/div/table[1]/tbody/tr[2]/td[1]");
	public static By testName=By.xpath(".//*[@id='view_container']/div/table[1]/tbody/tr[1]/td[3]/div");
	public static By stopButton=By.xpath(".//*[@id='welcome_stop_button']");
	public static By goodBye=By.xpath(".//*[@id='view_container']/div[1]/center/h1");
	public static By nextButton=By.xpath(".//*[@id='oas-go-on-button']");
	public static By yesFinish=By.xpath(".//*[@id='testing_finish_div']/center/h1");
	public static By yescontinue=By.xpath(".//*[@id='testing_finish_div']/center/h1/button");
	public static By loginback=By.xpath("html/body/div[10]/div[3]/div/button");
	public static By pauseback=By.xpath("html/body/div[15]/div[3]/div/button");
	public static By LoginErrorTxt=By.xpath(".//*[@id='ui-id-2']/div");
	public static By pauseErrorTxt=By.xpath(".//*[@id='ui-id-3']/div");
	public static By nwkback=By.xpath("html/body/div[10]/div[3]/div/button");
	
}
