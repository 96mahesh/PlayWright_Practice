package naveenAutomation;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;

public class CommaSelector {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://academy.naveenautomationlabs.com/");
		
		Locator loc = page.locator("a:has-text('Login')");
		loc.click();
		
		Locator ele = page.locator("a:has-text('Login') ,"
				+ " a:has-text('Courses'), "
				+ "a:has-text('Demo Site')");
		
		System.out.println(ele.count());
		
		if(ele.count()==4) {
			System.out.println("Test script pass");
		}
		else {
			System.out.println("Test script fail");
		}
	}
}
