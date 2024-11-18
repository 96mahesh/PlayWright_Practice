package naveenAutomation;

import java.nio.file.Path;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Download;

public class DownloadFile {

	public static void main(String[] args) {
		
		Playwright play = Playwright.create();
		Browser browser = play.chromium().launch(new LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		
		page.navigate("https://chromedriver.storage.googleapis.com/index.html?path=114.0.5735.90/");
		
		Download download = page.waitForDownload(()->{
			page.click("a:text('chromedriver_mac64.zip')");
		});
		 
		download.cancel();
		System.out.println(download.url());
		System.out.println(download.page().title());
		
		//Path path = download.path();
		String path = download.path().toString();
		System.err.println(path);
	}
}
