package demo1;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;

public class AmazonDropDown {

	public static void main(String[] args) throws InterruptedException {
		
		Playwright play = Playwright.create();
		Browser browser = play.chromium().launch(new LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		
		page.navigate("https://www.amazon.in/");
		
		Locator loc = page.locator("//select[@id='searchDropdownBox']");
		loc.press("Enter");
		Thread.sleep(3000);
		loc.press("ArrowDown");
		loc.press("ArrowUp");
		
		page.keyboard().press("F5");
		//loc.press("Enter");
	}
}
