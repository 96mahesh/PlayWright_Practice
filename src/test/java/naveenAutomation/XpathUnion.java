package naveenAutomation;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class XpathUnion {


	public static Page page = null; 
	public static void selectUser(String userName) {
		try {
			Thread.sleep(3000);
		page.locator("input[type='checkbox']:left-of(:text('"+userName+"'))").first().click();
		}catch(Exception e) {
		System.out.println(e);	
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://selectorshub.com/xpath-practice-page/");
		
		//page.locator("input[type='checkbox']:left-of(:text('Joe.Root'))").first().click();
		try {
		Thread.sleep(3000);
		selectUser("Jasmine.Morgan");		
		selectUser("Joe.Root");
		Thread.sleep(2000);
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
	
}
