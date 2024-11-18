package day5;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BasicAuthantication {

	public static void main(String[] args) {
		 
		Playwright play = Playwright.create();
		Browser browser = play.chromium().launch();
		BrowserContext context = browser.newContext(new Browser.NewContextOptions().setHttpCredentials("admin","admin"));
		Page page = context.newPage();
		page.navigate("https://the-internet.herokuapp.com/basic_auth");
		System.out.println(page.locator("h3").textContent());
		play.close();
	}
}


