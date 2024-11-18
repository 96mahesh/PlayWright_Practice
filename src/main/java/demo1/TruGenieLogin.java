package demo1;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.SelectOption;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class TruGenieLogin {

	public static void main(String[] args) throws InterruptedException, AWTException {
		
//		Playwright play = Playwright.create();
//		Browser browser = play.chromium().launch(new LaunchOptions().setChannel("chrome").setHeadless(false));
//		Page page = browser.newPage();
//		page.navigate("https://test.truboardpartners.com/NOCExternal/#/");
//		
//		page.locator("xpath=//input[@name='loginfmt']").fill("test1@truboardpartners.com");
//		page.locator("xpath=//input[@type='submit']").click();
//		page.locator("xpath=//input[@name='passwd']").fill("Kuz16929");
		
		
		
		Page page  = Playwright.create().chromium().launch(new LaunchOptions().setChannel("msedge")
				.setHeadless(false).setArgs(List.of("--start-maximized"))).newContext(new Browser.NewContextOptions().setViewportSize(null))

.newPage();
		page.navigate("https://test.truboardpartners.com/NOCExternal/#/");
		
		
		page.locator("xpath=//input[@name='loginfmt']").fill("test1@truboardpartners.com");
		page.locator("xpath=//input[@type='submit']").click();
		page.locator("xpath=//input[@name='passwd']").fill("Kuz16929");
		 page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign in")).click();
		page.locator("xpath=//input[@type='submit']").click();
		Locator dd = page.locator("xpath=//select[@name='wm-datatable']");
		dd.selectOption("Project Name");
		Locator loc = page.locator("xpath=//input[@type='text']");
		loc.fill("TestPerform 2");
		loc.press("Enter");
		page.locator("xpath=//button[@title='View Request']").click();
		page.locator("xpath=//span[text()='Request NOC']").click();
		
		Locator uniloc = page.locator("xpath=//input[@placeholder='Search Unit No']");
		uniloc.click();
		uniloc.fill("Villa --144");
		
		uniloc.press("ArrowDown");
		Thread.sleep(2000);
		uniloc.press("Enter");
		Thread.sleep(2000);
		//await page.locator("xpath=//input[@placeholder='Search Unit No']").pressSequentially("Villa --144");
		
//		page.getByPlaceholder("Search Unit No").click();
//	    page.getByPlaceholder("Search Unit No").fill("villa --11");
//	    page.getByPlaceholder("Search Unit No").press("ArrowDown");
		
		
		
	}
}

