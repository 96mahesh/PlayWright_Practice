package naveenAutomation;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;

public class HasElements {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://orangehrm.com/en/30-day-free-trial");
		
		Locator loc = page.locator("select#Form_getForm_Country:has(option[value='India'])");
		loc.allInnerTexts().forEach(e -> System.out.println(e));
		//href='https://amazon.jobs'
	}
}
