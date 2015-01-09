package User_actions;
//import org.testng.annotations.*;

//import org.openqa.selenium.interactions.Keyboard;

//import org.sikuli.script.App;

//import org.openqa.selenium.By;

//import org.openqa.selenium.firefox.FirefoxDriver;

//import org.sikuli.script.App;

//import org.sikuli.script.FindFailed;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class SikuliValidation {
public static void main(String args[]) throws Exception {

//Open FireFox application with google home page   

  //App flight = App.open("G:\\Others\\samples\\flight\\app\\flight4a.exe");

	WebDriver driver=new FirefoxDriver();
	driver.get("https://google.co.in");
//WebElement element = driver.findElement(By.name("q"));
	//element.sendKeys("Cheese!");

                     

       //Create and initialize an instance of Screen object   
	
              Screen screen = new Screen();
              

              //Add image path  

              Pattern image1 = new Pattern("C:\\sikulitest.png");

              //Pattern image2 = new Pattern("C:\\Users\\sai\\Desktop\\Flight Images\\image1.png");
              screen.wait(image1, 10);

              screen.type("mercury");
                 

              //Wait 10ms for image 

              //screen.wait(image1, 10);

                 

              //Click on the image

              //screen.

              

              screen.click(image1);
              //Close firefox  

              

                }

       

}