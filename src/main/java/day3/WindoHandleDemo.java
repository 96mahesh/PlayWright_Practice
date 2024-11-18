package day3;

import java.util.List;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class WindoHandleDemo {

	@Test
	public void wniHandle() {
		Playwright playwright=Playwright.create();
		Browser browser=playwright.chromium().launch(new LaunchOptions().setChannel("chrome").setHeadless(false));
		Page page=browser.newPage();
		page.navigate("https://www.hyrtutorials.com/p/window-handles-practice.html");
		page.locator("#newWindowBtn").click();
		System.out.println(page.title());
		Page tabs=page.waitForPopup(new Page.WaitForPopupOptions()
				.setPredicate(p->p.context().pages().size()==3),()->{
			page.locator("#newWindowsBtn").click();
 
		});
		
		List<Page> pages=tabs.context().pages();
		System.out.println(pages.size());
		pages.forEach(tab->{
			tab.waitForLoadState();
			System.out.println(tab.title());
		
				 if(pages.get(1).url().endsWith("add-padding-to-containers.html")) {
			System.out.println("Hellllllllllllllooo2");
			page.locator("//input[@name='name' and @maxlength=10']").fill("haripriya");
			System.out.println("helllooooooooooooo");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
				 else if(pages.get(0).url().endsWith("basic-controls.html")) {
					System.out.println("Hellllllllllllllooo1");
 
					page.locator("#firstName").fill("Haripriya");
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
 
		else {
			System.out.println("Hellllllllllllllooo3");
 
			page.locator("input#name.whTextBox").fill("hello");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
 
		});
	}
	}

