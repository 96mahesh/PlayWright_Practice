package naveenAutomation;

import java.util.List;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;

public class Alerts {

	@Test
	public void alertExamples() {
		
		//js alerts , prompt, conformation popup
		
		Playwright play = Playwright.create();
		LaunchOptions lp = new LaunchOptions();
		// lp.setChannel("chrome");
		lp.setHeadless(false);
		lp.setArgs(List.of("--start-maximized"));
		lp.setChannel("chrome");

		Browser browser = play.chromium().launch(lp);

		BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
		
		Page page = browserContext.newPage();
		page.navigate("https://the-internet.herokuapp.com/javascript_alerts");
		
//		page.onDialog(dailog->{
//			String alertmsg = dailog.message();
//			System.out.println(alertmsg);
//			dailog.accept();
//		});
//		page.click("//button[text()='Click for JS Alert']");
		
//		page.onceDialog(dailog->{
//			try {
//				Thread.sleep(3000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			String alertmsg = dailog.message();
//			System.out.println(alertmsg);
//			dailog.accept();
//		});
//		page.click("//button[text()='Click for JS Alert']");
//		
//		String result = page.textContent("#result");
//		System.out.println(result);
//		
//		page.onDialog(dailogbox->{
//			try {
//				Thread.sleep(3000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			String msg = dailogbox.message();
//			System.out.println(msg);
//			dailogbox.accept();
//		});
//		page.click("//button[text()='Click for JS Confirm']");
//		
//		
//		String result1 = page.textContent("#result");
//		System.out.println(result1);
		
		page.onDialog(promptbox->{
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String promptmsg = promptbox.message();
			System.out.println(promptmsg);
			promptbox.accept("Mahesh babu is bad boy");
			
			
		});
		
		page.click("//button[text()='Click for JS Prompt']");
		
		String result2 = page.textContent("#result");
		System.out.println(result2);
		
		
		
		
		
	}
}
