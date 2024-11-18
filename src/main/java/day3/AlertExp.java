package day3;

import org.testng.annotations.Test;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class AlertExp {
    
	@Test
	public void setUP() throws InterruptedException {
		
		Playwright play = Playwright.create();
		Page page = play.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)).newPage();
		
		page.navigate("https://www.lambdatest.com/selenium-playground/javascript-alert-box-demo");
		
		//JavaScript
		
		page.onceDialog(dialog->{
			System.out.println(dialog.message());
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dialog.accept();
		});
		page.locator("xpath=//p[text()='JavaScript Alerts']//button[text()='Click Me']").click();
		
		
		//Confirm box: Alert
		
		page.onceDialog(dailog->{
			System.out.println(dailog.message());
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dailog.accept();
		});
		
		//page.locator("p:has-text('Confirm box:') , button:has-text('Click Me')").click();
		page.locator("xpath=//p[text()='Confirm box:']//button[text()='Click Me']").click();
		
		page.onceDialog(dai->{
			System.out.println(dai.message());
			String value = dai.defaultValue();
			System.out.println(value);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dai.accept("pawan");
			
		});
		Thread.sleep(5000);
		
		page.locator("//p[text()='Prompt box:']//button[text()='Click Me']").click();
		System.out.println(page.locator("#prompt-demo").textContent());
		
		
		
	}
}
