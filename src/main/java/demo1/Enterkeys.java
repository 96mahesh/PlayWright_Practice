package demo1;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Keyboard;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;

public class Enterkeys {

	public static void main(String[] args) throws InterruptedException {
        try (Playwright playwright = Playwright.create()) {
//            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
//            BrowserContext context = browser.newContext();
//            Page page = context.newPage();
            
            // Navigate to a webpage
//             page.navigate("https://google.com");
////            
//             page.keyboard().insertText("嗨");
//             
//            // Press the Enter key
//            //page.keyboard().press("Enter");
//            //page.keyboard().down(null);
//            //page.keyboard()..up(null);
//            
//            // Close the browser
////           page.keyboard().type("Mahesh", new Keyboard.TypeOptions().setDelay(10));
////           page.type("text-area[name='q']","Mahesh",new Page.TypeOptions().setDelay(10));
//            page.type("textarea[name='q']","Mahesh");
//            Thread.sleep(5000);
//            page.keyboard().press("Control+A");
//            Thread.sleep(5000);
//           // page.fill("input[name=email]", "Mahesh");
            
//            page.navigate("https://keycode.info");
//            Thread.sleep(5000);
//            page.keyboard().press("A");
//            Thread.sleep(5000);
//            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("A.png")));
//            Thread.sleep(5000);
//            page.keyboard().press("ArrowLeft");
//            Thread.sleep(5000);
//            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("ArrowLeft.png")));
//            Thread.sleep(5000);
//            page.keyboard().press("Shift+O");
//            Thread.sleep(5000);
//            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("O.png")));
//            Thread.sleep(5000);
//            browser.close();
            
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext context = browser.newContext();
            context.tracing().start(new Tracing.StartOptions()
              .setScreenshots(true)
              .setSnapshots(true));
            Page page = context.newPage();
            page.navigate("https://playwright.dev");
            context.tracing().stop(new Tracing.StopOptions()
              .setPath(Paths.get("trace.zip")));
            
        }
    }
}
