package demo1;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Google {

	@Test
	public void setUp() throws InterruptedException {
		try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            
            // Navigate to a webpage
            page.navigate("https://google.com");
            Locator loc = page.locator("xpath=//textarea[@name='q']");
//            loc.fill("power star images");
//            Thread.sleep(3000);
//            loc.press("Backspace");
            Thread.sleep(3000);
            loc.fill("Playwright");
            Thread.sleep(3000);
            for(int i = 0; i<=5;i++) {
            loc.press("ArrowDown");
            Thread.sleep(3000);
            }
            loc.press("Enter");
            Thread.sleep(3000);
	}
	}
}
