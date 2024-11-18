package demo1;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LanchBrowser {

	public static void main(String[] args) {
		
	    Playwright playwrite = Playwright.create();
	    Browser browser = playwrite.chromium().launch(
	    		new  LaunchOptions().setChannel("chrome").setHeadless(false)
	    	);
	   
	    Page page = browser.newPage();
	    page.navigate("https://www.facebook.com");
	    page.locator("//input[@name='email']").fill("7842358565");
	    page.locator("//input[@name='pass']").fill("swapna");
	   // page.locator("//button[text()='Log in']").click();
	    page.getByTestId("royal_login_button").click();
	    
	    
	    
	    
	    
	}
}
