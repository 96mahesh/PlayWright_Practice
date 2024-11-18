package demo1;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.MouseButton;

import java.io.IOException;
import java.nio.file.Paths;

import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator.ClickOptions;
import com.microsoft.playwright.Locator;

public class Autoit {

	public static void main(String[] args) throws InterruptedException, IOException {

		Playwright play = Playwright.create();
		Page page = play.chromium().launch(new LaunchOptions().setHeadless(false)).newPage();

		page.navigate("https://www.sejda.com/en/index.html");

		page.click("#heroHomepageBtn");
		Thread.sleep(2000);
		
		page.click("//span[@class='btn btn-lg fileinput-button']");
		Thread.sleep(3000);
		Runtime.getRuntime().exec("C:\\Users\\Admin\\Desktop\\Autoit.exe");

		Thread.sleep(5000);

		// page.close();
	}
}
