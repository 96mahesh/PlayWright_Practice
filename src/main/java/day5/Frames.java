




package day5;

import java.util.List;
import java.util.regex.Pattern;

import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Frames {
	
	public static void main(String[] args) throws InterruptedException {
		
		Playwright play = Playwright.create();
		
		Page page = play.chromium().launch(new LaunchOptions().setHeadless(false)).newPage();
		page.navigate("https://letcode.in/frame");
		
		List<Frame> frames = page.frames();
		System.out.println(frames.size());
		
		Frame frame = page.frame("firstFr");
		frame.getByPlaceholder("Enter name").type("Mahesh");
		frame.getByPlaceholder("Enter email").type("Rampatruni");
		
		List<Frame> childframe = frame.childFrames();
		System.out.println(childframe.size());
		
		childframe.forEach(e->System.out.println(e.url()));
		
		//Frame innerframe = page.frameByUrl("https://letcode.in/innerFrame");
		
		Frame innerframe = page.frameByUrl(Pattern.compile("innerFrame"));
		innerframe.getByPlaceholder("Enter email").fill("mahirampo@gmail.com");
		frame.getByPlaceholder("Enter email").fill("Pawan kalyan");
		
		Thread.sleep(5000);
		play.close();
		page.close();
	}

}
