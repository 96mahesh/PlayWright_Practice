package demo1;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Robotclass {

	public static void main(String[] args) throws InterruptedException {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();
            page.navigate("https://www.google.com");

             page.locator("//textarea[@title='Search']").fill("playwright");
            // Thread.sleep(5000);
            // Wait for the page to load

            // Using Robot class to perform keyboard actions
            try {
                Robot robot = new Robot();
                
                robot.setAutoDelay(100);
                // Type something in the search input
                Thread.sleep(2000);
                robot.keyPress(KeyEvent.VK_H);
                robot.keyRelease(KeyEvent.VK_H);
                robot.keyPress(KeyEvent.VK_E);
                robot.keyRelease(KeyEvent.VK_E);
                robot.keyPress(KeyEvent.VK_L);
                robot.keyRelease(KeyEvent.VK_L);
                robot.keyPress(KeyEvent.VK_L);
                robot.keyRelease(KeyEvent.VK_L);
               
        		
                
        		for(int i=0;i<=5;i++) {
        			Thread.sleep(3000);
        		robot.keyPress(KeyEvent.VK_DOWN);
                robot.keyRelease(KeyEvent.VK_DOWN);
        		}
        		
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);
                Thread.sleep(5000);
                
            } catch (AWTException e) {
                e.printStackTrace();
            }

            // Continue with Playwright actions if needed
        }
    }
}
