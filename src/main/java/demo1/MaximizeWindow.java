package demo1;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class MaximizeWindow {

	@Test
	public void maximizedWindow() {
		
		Playwright palywright = Playwright.create();
		Browser browser = palywright.chromium().launch(new LaunchOptions().setChannel("chrome").setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https:www.amazon.in");
		
	}
}
