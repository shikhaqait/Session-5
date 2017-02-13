package Qainfotech.Session5;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class HRIS_Time {
	String path = "C:\\Users\\shikhamudgal\\workspace4\\Session5\\Drivers\\chromedriver_win32 (1)";
 WebDriver driver;
 
 @BeforeClass
 public void startBrowser(){
	 System.setProperty("webdriver.chrome.driver", path+"\\chromedriver.exe");
	 driver = new ChromeDriver();
  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
 }
 
 @Test
 public void launchWeb() throws InterruptedException{
  driver.get("http://hris.qait.com/qaithris/login.php");
  Thread.sleep(3000);
  ((JavascriptExecutor)driver).executeScript("document.getElementsByClassName('input-block-level')[0].value='shikhamudgal'");
  ((JavascriptExecutor)driver).executeScript("document.getElementsByClassName('input-block-level')[1].value='Lkjhgfd216'");
  ((JavascriptExecutor)driver).executeScript("document.getElementsByClassName('btn pull-left')[0].click()");
  ((JavascriptExecutor)driver).executeScript("document.getElementsByClassName('otherTab MyTimeCls')[0].click()"); 
  driver.switchTo().frame("rightMenu");
  String Week1 = driver.findElement(By.xpath(".//*[@id='weekHrs1']")).getText(); 
  System.out.println("Week 1 time : "+Week1);
  String Week2 = driver.findElement(By.xpath(".//*[@id='weekHrs2']")).getText();
  System.out.println("Week 2 time : "+Week2);
  String Week3 = driver.findElement(By.xpath(".//*[@id='weekHrs3']")).getText();
  System.out.println("Week 3 time : "+Week3);
  String Week4 = driver.findElement(By.xpath(".//*[@id='weekHrs4']")).getText();
  System.out.println("Week 4 time : "+Week4);  
//  Integer total =  Integer.parseInt(Week1 + Week2+Week3+Week4);
//  System.out.println(total);
 }
 
 @AfterClass 
 public void CloseBrowser(){
	   driver.close();
 }

}
