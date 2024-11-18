package day2;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;

public class InputValues {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false));
		
		Page page = browser.newPage();
		page.navigate("https://www.letcode.in/edit");
		page.locator("#fullName").type("Mahesh");//css selector
		page.locator("#join").fill("Babu");//Locator it is a interface
//		Locator loc = page.locator("#join");
//		loc.press("End");
//		loc.type("man");
//		loc.press("Tab");
//		page.type("#fullName", "Koushik c");
//		String value = page.locator("id=getMe").getAttribute("value");
//		System.out.println(value);
//		page.locator("//label[text()='Clear the text']/following::input[@placeholder='Enter ']").clear();
	}
}
