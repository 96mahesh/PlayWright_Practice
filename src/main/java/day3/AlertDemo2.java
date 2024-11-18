package day3;

import java.util.function.Consumer;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Dialog;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;


public class AlertDemo2 {

	@Test
	public void alert() {
		Playwright play = Playwright.create();
	    Browser browser = play.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
	    Page page = browser.newPage();
	    
	    page.navigate("https://www.letcode.in/alert");
	    
	    Consumer<Dialog> alert = new Consumer<Dialog>() {

			public void accept(Dialog dailog) {
				
				String msg =  dailog.message();	
			    System.out.println(msg);
			    String defvalue =dailog.defaultValue();
			    System.out.println(defvalue);
			    dailog.accept("Mahesh");
			}
	    	
	    };
	    
	    page.onDialog(alert);
	    page.locator("#prompt").click();
	    String value = page.locator("#myName").textContent();
	    System.out.println(value);
	    
//	    play.close();
//	    browser.close();
//	    page.close();
	    
	}
}
