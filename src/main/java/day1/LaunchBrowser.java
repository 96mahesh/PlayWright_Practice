

package day1;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LaunchBrowser {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false));
		
		Page page = browser.newPage();
		page.navigate("https://www.letcode.in/");
		System.out.println(page.title());
		System.out.println(page.url());
		page.close();
		browser.close();
		playwright.close();
	}
}
