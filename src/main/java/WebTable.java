import java.util.List;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class WebTable {

	public static void main(String[] args) {
		
		Playwright play = Playwright.create();
		Page page = play.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)).newPage();
		page.navigate("https://demo.guru99.com/test/web-table-element.php");
		
		List<Locator> row  = page.locator("//table[@class='dataTable']//tbody//tr").all();
		for (Locator loc : row) {
			String actualText =loc.textContent();
		}
		System.out.println(row.size());
		
		List<Locator> col = page.locator("//table[@class='dataTable']//thead//tr/th").all();
		String value = "Group";
		int culnum = 0;
		for (int i=0;i<col.size();i++) {
			 if( col.get(i).textContent().equals(value)) {
			culnum = i;
			 }
			
		}
		
		List<Locator> singlecol = page.locator("//table[@class='dataTable']//tbody//td").all();
		for (int j=culnum;j<singlecol.size();j=j+col.size()) {
			String data = singlecol.get(j).textContent();
			
			System.out.println(data);
		
	}
		play.close();
		page.close();
		
	}
}
