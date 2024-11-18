
package demo1;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.SelectOption;

public class Dropdown {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();

		LaunchOptions lp = new LaunchOptions();
		//lp.setChannel("chrome");
		lp.setHeadless(false);
		lp.setArgs(List.of("--start-maximized"));
		lp.setChannel("chrome");

		Browser browser = playwright.chromium().launch(lp);

		BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
		Page page = browserContext.newPage();
		page.navigate("https://www.lambdatest.com/selenium-playground/select-dropdown-demo");
		System.out.println("HEllo");
		
		
		Locator dd = page.locator("//option[text()='Please select']/..");
		dd.allInnerTexts().forEach(e -> System.out.println(e));
		//dd.allTextContents().forEach(e->System.out.println(e));

		// select by value
		// dd.selectOption("Monday");

		// select by label
		// dd.selectOption(new SelectOption().setValue("Sunday"));

		// select by index
		dd.selectOption(new SelectOption().setIndex(5));
		// Thread.sleep(10000);

		// select multiple
		Locator states = page.locator("//select[@id='multi-select']");
		states.selectOption(new String[] { "New Jersey", "Texas" });
		// Thread.sleep(10000);
		System.out.println("Done");

		// browser.close();
		// playwright.close();
	}

	}

