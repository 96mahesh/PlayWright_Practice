package day4;

import java.util.regex.Pattern;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.MouseButton;

public class Codegen {

	public static void main(String[] args) {
	    try (Playwright playwright = Playwright.create()) {
	      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
	        .setHeadless(false));
	      BrowserContext context = browser.newContext();
	      Page page = context.newPage();
	      page.locator("body").click();
	      page.navigate("https://letcode.in/");
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Log in")).click();
	      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter registered email")).click();
	      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter registered email")).fill("Mahesh");
	      page.getByPlaceholder("Enter password").click();
	      page.getByPlaceholder("Enter password").fill("Pawan");
	      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("LOGIN")).click();
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Sign up")).click();
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Work-Space")).click();
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Drop-Down")).click();
	      page.locator("#fruits").selectOption("1");
	      page.getByText("You have selected Mango").click();
	      page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^You have selected Mango$"))).nth(1).click();
	      page.locator("#superheros").selectOption("am");
	      page.locator("#superheros").selectOption("ta");
	      page.locator("#lang").selectOption("py");
	      page.locator("#country").selectOption("Peru");
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Work-Space")).click();
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Dialog")).click();
	      page.onceDialog(dialog -> {
	        System.out.println(String.format("Dialog message: %s", dialog.message()));
	        dialog.dismiss();
	      });
	      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Simple Alert")).click();
	      page.onceDialog(dialog -> {
	        System.out.println(String.format("Dialog message: %s", dialog.message()));
	        dialog.dismiss();
	      });
	      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Confirm Alert")).click();
	      page.getByText("Your name is: mahesh").click();
	      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Modern Alert")).click();
	      page.getByText("Modern Alert - Some people address me as sweet alert as well").click(new Locator.ClickOptions()
	        .setButton(MouseButton.RIGHT));
	    }
	  }
}
