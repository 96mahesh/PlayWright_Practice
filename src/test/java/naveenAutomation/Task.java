package naveenAutomation;

import java.util.List;

import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Task {

	public static void main(String[] args) throws InterruptedException {
		
		Playwright play = Playwright.create();
		Page page = play.chromium().launch(new LaunchOptions().setHeadless(false)).newPage();
		
		page.navigate("https://www.google.com");
		Locator loc = page.locator("xpath=//textarea[@name='q']");
        loc.fill("Ram");
        loc.press("Enter");
        
        List<Locator> val = page.locator("//*[contains(text(),'ram') or contains(text(),'Ram') or contains(text(),'RAM')]").all();
		Thread.sleep(6000);
        int Ram_count = val.size();
		System.out.println(Ram_count);
	}
}
