package day4;

import java.nio.file.Paths;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class LoginFunctions {

	@Test
	
	public void loginPage() {
		Playwright playwrite = Playwright.create();
	    Browser browser = playwrite.chromium().launch(
	    		new  LaunchOptions().setHeadless(false)
	    	);
	    BrowserContext brContext = browser.newContext();
	    
	    Page page = brContext.newPage();
	    page.navigate("http://www.automationpractice.pl/index.php");
	    page.click("a:text('Sign in')");
	    page.fill("#email", "testrigornaveen@gmail.com");
	    page.fill("#passwd","testrigor123");
	    page.click("#SubmitLogin");
	   // page.locator("//button[text()='Log in']").click();
	   // page.getByTestId("royal_login_button").click();
	    
	    brContext.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("applogin.json")));
	}
}
