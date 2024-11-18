package day3;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class MultipleElements {

	
	@Test
	public void setup() throws InterruptedException {
		
		Playwright play = Playwright.create();
		Page page = play.chromium().launch(new LaunchOptions().setHeadless(false)).newPage();
		page.navigate("https://www.google.com");
		
		page.fill("//textarea[@name='q']", "Playwright");
		Thread.sleep(3000);
		List<Locator> allelements =page.locator("//div[@class='pcTkSc']//div[starts-with(@class,'wM6W7d')]").all();
		List<String> listofele = new ArrayList<>();
		for (Locator loc : allelements) {
			String alltext = loc.textContent();
			System.out.println(alltext);
			listofele.add(alltext);
		}
		
		String name = "playwright vs selenium";
		for (String loc : listofele) {
			Thread.sleep(2000);
			page.keyboard().press("ArrowDown");
			if(loc.equals(name)) {
				Thread.sleep(2000);
				page.keyboard().press("Enter");
				Thread.sleep(8000);
			}
			
		}
	}
}
