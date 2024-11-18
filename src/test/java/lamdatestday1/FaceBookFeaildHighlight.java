package lamdatestday1;

import org.testng.annotations.Test;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FaceBookFeaildHighlight {

	@Test
	
	public void elementHighlight() {
		
		Playwright play = Playwright.create();
		
		Page page = play.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)).newPage();
		page.navigate("https://www.facebook.com");
		
		String email = "input[name='email']";
		highlightElement(page, email);
		page.fill(email,"7842358565");
		
		String pass = "input[name='pass']";
		highlightElement(page, pass);
		page.fill(pass,"swapna");
		
		String login = "button[name='login']";
		highlightElement(page, pass);
		page.click(login);
		
		
		
	}
	
	public static void highlightElement(Page page, String s) {
       page.locator(s).evaluate("(element) =>{element.style.backgroundColor = 'yellow'; element.style.border = '2px solid red'}");
    }
}
