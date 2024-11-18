package lamdatestday1;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HighlightTheFeaild {

	 public static void main(String[] args) throws InterruptedException {
	     
		 
		 try (Playwright playwright = Playwright.create()) {
	            
	            Browser browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false));
	            BrowserContext context = browser.newContext();
	            Page page = context.newPage();
	            
	            page.navigate("https://www.facebook.com/");

	            Locator emailLocator = page.locator("input[name='email']");
	            highlightElement(page, emailLocator);
	            emailLocator.fill("7842358565");

	            Locator passwordLocator = page.locator("input[name='pass']");
	            highlightElement(page, passwordLocator);
	            passwordLocator.fill("swapna");
	            
	            Locator loginloc = page.locator("button[name='login']");
	            highlightElement(page,loginloc);
	            loginloc.click();
	            try {
	                Thread.sleep(10000);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }

	            browser.close();
	        }
	    }

	    public static void highlightElement(Page page, Locator locator) {
	        locator.evaluate("(element) =>{element.style.backgroundColor = 'yellow'; element.style.border = '2px solid red'}");
	    }

	    
}
