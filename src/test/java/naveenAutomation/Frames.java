package naveenAutomation;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Frames {

	public static void main(String[] args) {
		
		Playwright play = Playwright.create();
		Page page = play.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)).newPage();
		
//		page.navigate("https://www.londonfreelance.org/courses/frames/index.html");
//		
////		String header = page.frameLocator("frame[name='main']").locator("h2").textContent();
////		System.out.println(header);
//		
//		String header = page.frame("main").locator("h2").textContent();
//		System.out.println(header);
		
		page.navigate("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");
		
		page.locator("img[title='Vehicle-Registration-Forms-and-Examples']").click();
		page.frameLocator("#FSForm").locator("#RESULT_TextField-8").fill("Mahesh rampatruni");
	}
}
