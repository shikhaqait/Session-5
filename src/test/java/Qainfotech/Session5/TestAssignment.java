package Qainfotech.Session5;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestAssignment {

	String path = "C:\\Users\\shikhamudgal\\workspace4\\Session5\\Drivers\\chromedriver_win32 (1)";
	WebDriver driver; 
	
	@BeforeClass
	public void TATOCcases(){
		System.setProperty("webdriver.chrome.driver", path+"\\chromedriver.exe");
		driver = new ChromeDriver();
        driver.manage().window().maximize(); 
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}	
	   @Test
       public void LaunchURL() throws InterruptedException
       {		   
       driver.get("http://10.0.1.86/tatoc/basic/frame/dungeon");         
       driver.switchTo().frame("main");
       String box1=driver.findElement(By.xpath("//div[text()='Box 1']")).getAttribute("class");
       driver.switchTo().frame("child");
       String box2=driver.findElement(By.xpath("//div[text()='Box 2']")).getAttribute("class");  
       driver.switchTo().defaultContent();
       driver.switchTo().frame("main"); 
       if(box1.equalsIgnoreCase(box2))
       {
        System.out.println("Box 1 and Box 2 are Same");
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(By.id("main")));
        driver.findElement(By.linkText("Proceed")).click();
       }      
       else{        
            do{
             driver.switchTo().defaultContent();
             driver.switchTo().frame(driver.findElement(By.id("main")));
             driver.findElement(By.linkText("Repaint Box 2")).click();    
          driver.switchTo().frame(driver.findElement(By.id("child")));
          box2 = driver.findElement(By.xpath("//div[text()='Box 2']")).getAttribute("class");   
            }while(!box1.equalsIgnoreCase(box2));         
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(By.id("main")));
        driver.findElement(By.linkText("Proceed")).click();
       }
 
       //Drag Drop
       Actions act = new Actions(driver);
       act.dragAndDrop(driver.findElement(By.id("dragbox")), driver.findElement(By.id("dropbox")));
       act.build().perform();
       driver.findElement(By.xpath("//a[text()='Proceed']")).click();
       
       //Next Page for pop-up and submission of name
       driver.findElement(By.xpath("//a[text()='Launch Popup Window']")).click();
       
       ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());
       driver.switchTo().window(windows.get(1));
      
       driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Shikha");
       driver.findElement(By.xpath("//input[@id='submit']")).click();
       
       
       driver.switchTo().window(windows.get(0));
       driver.findElement(By.xpath("//a[text()='Proceed']")).click();
       Thread.sleep(2000);
       driver.findElement(By.xpath("//a[text()='Generate Token']")).click();
       String tokentext= driver.findElement(By.id("token")).getText();
       String tokenvalue = tokentext.substring(7);
       System.out.println(tokenvalue);
       
       
       Cookie name = new Cookie ("cookie name", "Token=["+tokenvalue+"]");
       driver.manage().addCookie(name);
       driver.findElement(By.xpath("//a[text()='Proceed']")).click();

       }     
	   @AfterClass 
	   public void CloseBrowser(){
		   driver.close();
	   }
}
