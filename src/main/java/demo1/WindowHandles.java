package demo1;

import java.util.List;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class WindowHandles {

	@Test
	public void setUp() {

		Playwright playwright = Playwright.create();

		LaunchOptions lp = new LaunchOptions();
		// lp.setChannel("chrome");
		lp.setHeadless(false);
		lp.setArgs(List.of("--start-maximized"));
		lp.setChannel("chrome");

		Browser browser = playwright.chromium().launch(lp);

		BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
		Page page = browserContext.newPage();
		page.navigate("https://letcode.in/windows");
		 
		// Click on a button to open a child browser
		//page.click("button");
		 
		// Wait for the child browser to open
		Page childPage = page.waitForPopup(() -> {
		    page.click("Open Home Page");
		});
		 
		// Handle child browser
		childPage.fill("input", "some text");
		 
		// Click on a button in the child browser to open a nested child browser
		childPage.click("button");
		 
		// Wait for the nested child browser to open
		Page nestedChildPage = childPage.waitForPopup(() -> {
		    childPage.click("button-in-nested-child-page");
		});
		 
		// Handle nested child browser
		nestedChildPage.fill("input", "some text for nested child");
		 
		// Close nested child browser
		nestedChildPage.close();
		 
		// Close child browser
		childPage.close();
	}
}
