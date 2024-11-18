package day5;

import java.nio.file.Paths;

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
		
		page.navigate("https://letcode.in/file");
		
		Download download = page.waitForDownload(()->{
			page.locator("'Download Excel'").click();
		});
		
		System.out.println(download.path());
		System.out.println(download.url());
		System.out.println(download.failure());
		System.out.println(download.suggestedFilename());
		download.saveAs(Paths.get(download.suggestedFilename()));
	}
}
