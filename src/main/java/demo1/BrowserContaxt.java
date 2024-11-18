package demo1;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BrowserContaxt {

	@Test
	public void dropDownList() {
	
		Browser browser = Playwright.create().chromium().launch(new LaunchOptions());
		BrowserContext context = browser.newContext();
		// Create a new page inside context.
		Page page = context.newPage();
		page.navigate("https://example.com");
		// Dispose context once it is no longer needed.
		context.close();
	}
	
	
}
