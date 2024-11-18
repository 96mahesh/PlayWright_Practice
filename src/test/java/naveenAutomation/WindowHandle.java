package naveenAutomation;

import java.util.List;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class WindowHandle {

	@Test
	public void windowHandles() throws InterruptedException {
		Playwright playwright = Playwright.create();
		 
		LaunchOptions lp = new LaunchOptions();
		lp.setHeadless(false);
		lp.setArgs(List.of("--start-maximized"));
		lp.setChannel("msedge");
 
		Browser browser = playwright.chromium().launch(lp);
		BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
		Page page = browserContext.newPage();
		
		page.navigate("https://the-internet.herokuapp.com/javascript_alerts");
		
		page.evaluate("window.open('', ' ')");
		 //page.evaluate("window.open()");
		//.navigate("about:blank");
		 Thread.sleep(5000);
		
//		Page popup = page.waitForPopup(() -> {
//			page.waitForLoadState();
//	        page.click("a[target='_blank']"); //open new tab
//	     
//	    });
//		
//		Thread.sleep(5000);
		
		
//		Page newTab = page.context().newPage(); 
//		Thread.sleep(5000);
	}
}
