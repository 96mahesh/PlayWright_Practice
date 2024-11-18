package naveenAutomation;

import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.FilePayload;

public class FileUpload {

	@Test
	public void upLoadFile() throws InterruptedException {
		Playwright play = Playwright.create();
		Browser browser  = play.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		//page.navigate("https://davidwalsh.name/demo/multiple-file-upload.php");
		
		
//		page.setInputFiles("input#filesToUpload", Paths.get("letcode.pdf"));
//		Thread.sleep(4000);
//		page.setInputFiles("input#filesToUpload", new Path[0]);
				
		//select multiple file
	//	Thread.sleep(5000);
		
		//page.locator("#filesToUpload").setInputFiles(new Path[] {Paths.get("REQUEST_REQNOC_Plot __251_13032024.pdf"), Paths.get("Java_Programming_Questions_1687508607.pdf")});
		//page.setInputFiles(fileInputSelector, new String[]{"path/to/file1.txt", "path/to/file2.txt"});
		
//		page.setInputFiles("input#filesToUpload", new Path[] {
//				Paths.get("applogin.json"),
//				Paths.get("auth.json"),
//				Paths.get("sample.xlsx")});
//		Thread.sleep(4000);
//		page.setInputFiles("input#filesToUpload", new Path[0]);
		
		
		//Run time file - upload
		
		page.navigate("https://cgi-lib.berkeley.edu/ex/fup.html");
		page.setInputFiles("input[name='upfile']", new FilePayload("mahesh.pdf", 
				"application.pdf", 
				"mahesh is hear".getBytes(StandardCharsets.UTF_8)));
		
		page.locator("input[value='Press']").click();
		Thread.sleep(5000);
		
	}
}
