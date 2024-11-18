
package day4;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

public class WindowHandleCodegen {

	 public static void main(String[] args) {
		    try (Playwright playwright = Playwright.create()) {
		      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
		        .setHeadless(false));
		      BrowserContext context = browser.newContext();
		      Page page = context.newPage();
		      page.navigate("https://letcode.in/windows");
		      Page page1 = page.waitForPopup(() -> {
		        page.getByLabel("Goto Home").click();
		      });
		      Page page3 = page.waitForPopup(() -> {
		        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Muiltiple windows")).click();
		      });
		      page3.locator("#fruits").selectOption("0");
//		      page2.onceDialog(dialog -> {
//		        System.out.println(String.format("Dialog message: %s", dialog.message()));
//		        dialog.dismiss();
//		      });
//		      page2.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Simple Alert")).click();
		    }
		  }
}
