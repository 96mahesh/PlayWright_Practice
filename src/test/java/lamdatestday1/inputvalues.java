package lamdatestday1;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import org.testng.annotations.Test;;


public class inputvalues {

	@Test
	public void setUp() {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://www.lambdatest.com/selenium-playground/simple-form-demo");
		
		page.type("input#user-message", "Hey Tester");
		page.click("button#showInput");
		String message = page.textContent("#message");
		System.out.println("Message name is : " + message);
		assertThat(page.locator("#message")).hasText("Hey Tester");
		
		page.navigate("https://www.lambdatest.com/selenium-playground/generate-file-to-download-demo");
		page.waitForLoadState();
		
		page.navigate("https://www.letcode.in/edit");
		String inputvalue = page.inputValue("#getMe");
		System.out.println("input value is : "+ inputvalue);
		
		String placeholdervalue = page.getAttribute("#fullName","placeholder");
		System.out.println("place holder value is : " +placeholdervalue);
		
		Locator fullname = page.getByPlaceholder(placeholdervalue);
		
		assertThat(fullname).hasAttribute("placeholder", placeholdervalue);
		
//		page.navigate("https://www.lambdatest.com/selenium-playground/checkbox-demo");
//		Locator loc = page.locator("#isAgeSelected");
//		assertThat(loc).not().isChecked();
//		loc.click();
//		assertThat(loc).isChecked();
		
		page.navigate("https://www.lambdatest.com/selenium-playground/checkbox-demo");
		Locator loc = page.locator("#isAgeSelected");
		assertThat(loc).not().isChecked();
		loc.check();Locator checkloc = page.locator("//div[text()='Disabled Checkbox Demo']//following::div[@class='pb-10']");
		
		
	}
}
