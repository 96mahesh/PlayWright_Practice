package demo1;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class LanchWebKit {

	public static void main(String[] args) throws InterruptedException {
//		try (Playwright playwright = Playwright.create()) {
//		      Browser browser = playwright.firefox().launch(new  LaunchOptions().setHeadless(false));
//		      Page page = browser.newPage();
//		      page.navigate("https://playwright.dev/");
//		      page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example.png")));
//		    }
		
//		try (Playwright playwright = Playwright.create()) {
//		      Browser browser = playwright.webkit().launch(new  LaunchOptions().setHeadless(false));
//		      Page page = browser.newPage();
//		      Thread.sleep(3000);
//		      page.navigate("https://playwright.dev/");
//		      page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example.png")));
//		    }
		
		
		try (Playwright playwright = Playwright.create()) {
		      Browser browser = null;
		      String browserName = "firefox";
		      System.out.println(browserName);
		      if (browserName.equals("chromium")) {
		        browser = playwright.chromium().launch(new  LaunchOptions().setHeadless(false));
		      } else if (browserName.equals("firefox")) {
		        browser = playwright.firefox().launch(new  LaunchOptions().setHeadless(false));
		      } else if (browserName.equals("webkit")) {
		        browser = playwright.webkit().launch(new  LaunchOptions().setHeadless(false));
		      }
		      else if (browserName.equals("edge")) {
			        browser = playwright.chromium().launch(new  LaunchOptions().setChannel("msedge").setHeadless(false));
			      }
		      else if (browserName.equals("chrome")) {
			    
		    	  browser = playwright.chromium().launch(new  LaunchOptions().setChannel("chrome").setHeadless(false));
			      }
		      Page page = browser.newPage();
		      page.navigate("https://www.facebook.com");
//		      page.getByPlaceholder("Email address or phone number").fill("7842358565");
//		      page.getByLabel("Password").fill("swapna");
		      page.getByText("Forgotten password?").click();
		      page.getByLabel("Email address or mobile number").last().click();
		      Thread.sleep(3000);
		      
		      
		    }

	}
}
