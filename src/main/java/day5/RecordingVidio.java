package day5;

import java.nio.file.Paths;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class RecordingVidio {

	@Test
	public void browserContext() throws InterruptedException {
	
//		Playwright play = Playwright.create();
//		BrowserType browsertype = play.firefox();
//		LaunchOptions lp = new BrowserType.LaunchOptions().setHeadless(false);
//		Browser browser = browsertype.launch(lp);
//		BrowserContext context = browser.newContext(new Browser.NewContextOptions()
//				.setRecordVideoDir(Paths.get("vidio/")).setRecordVideoSize(1280, 720));
//		Thread.sleep(3000);
//		Page page = context.newPage();
//		page.navigate("https://bookcart.azurewebsites.net/login");
//		page.locator("input[formcontrolname='username']").type("ortoni");
//		page.locator("input[formcontrolname='password']").type("pass1234$");
//		page.locator("//span[text()='Login']").click();
//		String user = page.locator("(//a[contains(@class,'mat-mdc-menu-trigger mdc-button mdc-button')]//span[2])[1]").textContent();
//		System.out.println(user);
		
		Playwright play = Playwright.create();
		BrowserType browserType = play.chromium();
		LaunchOptions headless = new BrowserType.LaunchOptions().setHeadless(false);
		Browser browser = browserType.launch(headless);
		BrowserContext context = browser.newContext(new Browser.NewContextOptions()
				.setRecordVideoDir(Paths.get("videos/"))
				.setRecordVideoSize(1280, 720));
		Page page = context.newPage();
		page.navigate("https://bookcart.azurewebsites.net/");
		page.click("//span[text()='Login']/..");
		page.locator("input[formcontrolname='username']").type("ortoni");
		page.locator("input[formcontrolname='password']").type("Pass1234$");
		page.locator("button[color='primary']").click();
		
		page.close();
		
		play.close();
	}
}

