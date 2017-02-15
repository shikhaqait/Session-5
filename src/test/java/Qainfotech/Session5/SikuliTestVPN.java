package Qainfotech.Session5;

import org.sikuli.script.*;
import org.testng.annotations.Test;

public class SikuliTestVPN {
	
	@Test
	public void sikulitest() throws InterruptedException{
		 Screen scr = new Screen();
         try{
        	    scr.type("d",Key.WIN);
        	 	scr.doubleClick("C:\\Users\\shikhamudgal\\workspace4\\Session5\\Img\\vpnShortcut (1).png", 0);
                scr.click("C:\\Users\\shikhamudgal\\workspace4\\Session5\\Img\\vpnShortcut (2).png", 0);
                scr.wait("C:\\Users\\shikhamudgal\\workspace4\\Session5\\Img\\vpnShortcut (3).png",20);
                scr.click("C:\\Users\\shikhamudgal\\workspace4\\Session5\\Img\\vpnShortcut (4).png");
                scr.paste("Compassqa9");
                scr.click("C:\\Users\\shikhamudgal\\workspace4\\Session5\\Img\\vpnShortcut (5).png");

         }
         catch(FindFailed e){
                 e.printStackTrace();
         }
	}

}
