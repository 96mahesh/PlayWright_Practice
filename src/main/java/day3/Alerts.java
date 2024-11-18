
package day3;

import org.testng.annotations.Test;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class Alerts {

	@Test
	public void setUp() throws InterruptedException {
		
		Playwright play = Playwright.create();
		Page page = play.chromium().launch(new LaunchOptions().setHeadless(false)).newPage();
		page.navigate("https://www.letcode.in/alert");
		
		//Single Alert
		page.onceDialog(dialog->{
			System.out.println(dialog.message());
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dialog.accept();
		});
		page.locator("#accept").click();
		Thread.sleep(3000);
		
		//Conform Alert
		
		page.onceDialog(dilaog->{
			System.out.println(dilaog.message());
			try {
				Thread.
				sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dilaog.accept();
		});
		page.locator("#confirm").click();
		
		//Prompt Alert
		
		page.onDialog(dai->{
			System.out.println(dai.message());
			try {
				Thread.sleep(8000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String defaultvalue = dai.defaultValue();
			System.out.println(defaultvalue);
			dai.accept("Mahesh");
		});
		
		page.locator("#prompt").click();
		System.out.println(page.locator("#myName").textContent());
	}
}
