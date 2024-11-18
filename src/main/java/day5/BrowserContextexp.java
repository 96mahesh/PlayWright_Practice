package day5;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BrowserContextexp {

	@Test
	public void browserContext() throws InterruptedException {
	
		Playwright play = Playwright.create();
		BrowserType browsertype = play.firefox();
		LaunchOptions lp = new BrowserType.LaunchOptions().setHeadless(false);
		Browser browser = browsertype.launch(lp);
		BrowserContext context = browser.newContext();
		Page page = context.newPage();
		page.navigate("https://bookcart.azurewebsites.net/login");
		page.locator("input[formcontrolname='username']").type("ortoni");
		page.locator("input[formcontrolname='password']").type("pass1234$");
		page.locator("//span[text()='Login']").click();
		String user = page.locator("(//a[contains(@class,'mat-mdc-menu-trigger mdc-button mdc-button')]//span[2])[1]").textContent();
		System.out.println(user);
		
		BrowserContext context2 = browser.newContext();
		Page newpage = context2.newPage();
		newpage.navigate("https://bookcart.azurewebsites.net/login");
		context2.close();
//	    user = newpage.locator("(//a[contains(@class,'mat-mdc-menu-trigger mdc-button mdc-button')]//span[2])[1]").textContent();
//		System.out.println(user);
		
		Thread.sleep(3000);
		page.bringToFront();
		page.locator("//input[@type='search']").type("Hp2");
		page.close();
		
		
		play.close();
	}
}

