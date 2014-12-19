package ObjectRepository;

import org.openqa.selenium.By;

public class ObjectRepository {
	
	//public static By loginID = By.xpath("/html/body/div[3]/div[1]/div/div/div[1]/div/center/div[1]/form/div[1]/div/input");
	public static By loginID = By.xpath(".//*[@id='frmUsername']"); 
	//public static By password = By.xpath("/html/body/div[3]/div[1]/div/div/div[1]/div/center/div[1]/form/div[2]/div[2]/input");
	public static By password = By.xpath(".//*[@id='frmPassword']");
	public static By accesscode = By.xpath(".//*[@id='frmSiteCode']");
	public static By loginButton = By.xpath(".//*[@id='login_container']/div/div/div[1]/div/center/div[2]/button[2]");

}
