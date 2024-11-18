package demo1;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class MultipleWindowHandles {

	@Test
	public void setUp() {
	
//		Playwright play = Playwright.create();
//		Browser browser = play.chromium().launch(new LaunchOptions().setHeadless(false));
//		Page page1 = browser.newPage();
//		Page page2 = browser.newPage();
//		
//		page1.navigate("https://www.google.com");
//		page2.navigate("https://www.amazon.in");
		
		Playwright play = Playwright.create();
		Browser browser = play.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		BrowserContext box1  = browser.newContext();
		
		Page page = box1.newPage();
		page.navigate("http://orangehrm.qedgetech.com/symfony/web/index.php/auth/login");
		
		Page popup = page.waitForPopup(()->{
			page.click("img[alt='OrangeHRM on twitter']");
		});
		
		page.waitForLoadState();
//		String loc  = popup.getByText("New to X?").textContent();
		//String loc  = popup.getByText("New to X?").innerText();
		String loc  = popup.getByText("New to X?").innerHTML();
		//int loc  = popup.getByText("New to X?").count();
		System.out.println(loc);
		popup.locator("xpath=//div[@class='css-175oi2r r-1awozwy']//div[@class='css-175oi2r']//*[local-name()='svg']").click();
		System.out.println("title is : " + popup.title());
		popup.close();
		System.out.println("page title is : " + page.title());
		page.close();
		
//		Page popup = page.waitForPopup(()->{
//			page.click("a[target='_blank']"); //opens a new tab window
//		});
//		popup.waitForLoadState();
//		popup.navigate("https://www.google.com");
//		System.out.println(popup.title());
//		popup.close();
//		System.out.println("page title is : " + page.title());
//		page.close();
		
		
		//page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		//BrowserContext box2  = browser.newContext();
		//Page page2 = box2.newPage();
		//page2.navigate("https://www.amazon.in");
		
	}
}
