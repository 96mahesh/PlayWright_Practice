package day3;

import java.util.List;


import org.testng.annotations.Test;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Locator.SelectOptionOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.SelectOption;

public class DropDown {
	
	@Test
	public void setUp() {
		Playwright play = Playwright.create();
		Browser browser = play.chromium().launch(new LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		
		page.navigate("https://letcode.in/dropdowns");
		
		//page.selectOption("#fruits", "Orange");
		page.selectOption("#fruits", "3");
		
		Locator fruitedd = page.locator("#fruits");
		fruitedd.selectOption("1");
		String text = page.locator("p.subtitle").textContent();
		System.out.println(text);
		
		fruitedd.selectOption(new SelectOption().setLabel("Apple"));
		//fruitedd.selectOption(new SelectOption().setIndex(3), new SelectOptionOptions().setForce(false));
		fruitedd.selectOption(new SelectOption().setIndex(3), new SelectOptionOptions().setNoWaitAfter(false));
		//fruitedd.selectOption(new SelectOption().setIndex(3), new SelectOptionOptions().setTimeout(10));
		fruitedd.selectOption(new SelectOption().setValue("4"));
		
		Locator loc = page.locator("id=superheros");
		loc.allInnerTexts().forEach(e->System.out.println(e));
		loc.selectOption(new String[] {"ta","ca","am"});
		//loc.selectOption(new String[] {"Ant-Man","Black Panther","Captain Marvel"});
		page.waitForLoadState();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//  select last value
		Locator lan = page.locator("#lang");
		Locator options = lan.locator("option");
		List<String> allopt = options.allInnerTexts();
		System.out.println();
//		for (String s : allopt) {
//			System.out.println(s);
//		}
		//select last value
		allopt.forEach(e->System.out.println(e));
		int count = options.count();
		System.out.println("len :"+count);
		lan.selectOption(new SelectOption().setIndex(count-1));
		
		
		page.close();
	}

}
