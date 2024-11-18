package day4;

import java.nio.file.Paths;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Page;

public class AutomaticLoginFunction {

	@Test
	public void automaticLoginApplication() throws InterruptedException {
		Playwright playwrite = Playwright.create();
	    Browser browser = playwrite.chromium().launch(
	    		new  LaunchOptions().setChannel("chrome").setHeadless(false));
	    
	    
	   BrowserContext brcontext = browser.newContext(new Browser.NewContextOptions().setStorageStatePath(Paths.get("applogin.json")));
	   
	  Page page = brcontext.newPage();
//	  page.navigate("https://the-internet.herokuapp.com/iframe");
//	  
//	  FrameLocator frameloc = page.frameLocator("#mce_0_ifr");
//	  frameloc.locator("#tinymce").fill("Mahesh");
//	  page.pause();
//	  
	  
	  page.navigate("https://the-internet.herokuapp.com/nested_frames");
	  
	  for(Frame childFrame 	: page.mainFrame().childFrames())
		  System.out.println(childFrame.name());
	  
	  Frame main_frame = page.mainFrame();
	  
	  Frame top_frame = main_frame.childFrames().get(0);
	  Frame bottom_frame = main_frame.childFrames().get(1);
	  
	  bottom_frame.addScriptTag();
	  Frame left_frame  = top_frame.childFrames().get(0);
	  Frame middle_frame  = top_frame.childFrames().get(1);
	  Frame right_frame  = top_frame.childFrames().get(2);
	  
	  System.out.println(left_frame.locator("body").innerText());
	  System.out.println(middle_frame.locator("body").innerText());
	  System.out.println(right_frame.locator("body").innerText());
	  
	  
	 Thread.sleep(3000);
	 
	 
	 
	}
}
