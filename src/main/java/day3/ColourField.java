package day3;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.ElementHandle;

public class ColourField {

	public static void main(String[] args) throws InterruptedException {
		
		Playwright play = Playwright.create();
		Browser browser  = play.chromium().launch(new LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://www.facebook.com");
		
		ElementHandle emailloc = page.querySelector("data-testid=royal_email");
		highlightElement(page, emailloc);
		emailloc.fill("7842358565");
		
		ElementHandle passloc = page.querySelector("data-testid=royal_pass");
		highlightElement(page, passloc);
		passloc.fill("swapna");
		
        ElementHandle loginButton = page.querySelector("[data-testid='royal_login_button']");
        //Locator loc = loginButton.click();
        //highlightElement(page, loginButton);
        page.evaluate("loginButton => {loginButton.style.backgroundColor = 'green'; loginButton.style.border = '2px solid blue';}",loginButton);
        loginButton.click();
       
  
        
        Thread.sleep(3000);
        //browser.close();
        
        
    }


// Method to highlight an element using JavaScript
public static void highlightElement(Page page, ElementHandle element) {
    // Execute JavaScript to apply highlighting effect
    page.evaluate("element => { element.style.backgroundColor = 'yellow'; element.style.border = '2px solid red'; }", element);

}
	}

