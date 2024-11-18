package lamdatestday1;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import java.util.List;

public class WindowHandles {

	@Test
	public void satUp() throws InterruptedException {
	
		Playwright palywright = Playwright.create();
		LaunchOptions lp = new LaunchOptions();
		Browser browser = palywright.chromium().launch(lp.setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://www.lambdatest.com/selenium-playground/window-popup-modal-demo");
		System.out.println("parrent popup title is : " +page.title());
		
		
		// Sinle window popup
		
//		Page singlepopup = page.waitForPopup(()->{
//			page.getByText("  Like us On Facebook ").click();
//		});
//		
//		singlepopup.waitForLoadState();
//		assertThat(singlepopup).hasTitle("LambdaTest | San Francisco CA | Facebook");
//		System.out.println("parrent popup title is : "+singlepopup.title());
//		
//		singlepopup.locator("xpath=//input[@type='text']").fill("7842358565");
//		singlepopup.locator("xpath=(//input[@name='pass'])[2]").fill("swapna");
//		singlepopup.locator("(//span[text()='Log in'])[3]").click();
//		
//		singlepopup.close();
//		
//		page.getByText("  Follow On Twitter ").click();
		
		//Multiple window handle
		
		
		
		
		Page tabs = page.waitForPopup(new Page.WaitForPopupOptions().setPredicate(
				p->p.context().pages().size()==3),()->{
			page.getByText("Follow Twitter & Facebook").click();
		});
		
		tabs.waitForLoadState();
		List<Page> pages = tabs.context().pages();
		System.out.println(pages.size());
		
		pages.forEach(tab->{
			tabs.waitForLoadState();
			System.out.println(tab.title());
		});
		tabs.waitForLoadState();
		Thread.sleep(5000);
		Page fbpage = pages.get(0);
		System.out.println("fbtitle is :"+fbpage.title());
		Page twpage = pages.get(1);
		System.out.println("twpage is :"+twpage.title());
		
		
//		Page fbpage = null;
//		Page twpage = null;
//		if(pages.get(0).title().endsWith("Run Selenium Test On Cloud")) {
//			fbpage = pages.get(0);
//		}
//		else {
//			twpage = pages.get(1);
//		}
//		
//		System.out.println(fbpage.url());
//		System.out.println(twpage.url());
	}
}
