package lamdatestday1;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Iframes {

	public static void main(String[] args) {
		
		Playwright play = Playwright.create();
		Page page = play.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)).newPage();
		
		page.navigate("https://www.londonfreelance.org/courses/frames/index.html");
		
	}
}
