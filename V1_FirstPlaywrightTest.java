package gettingstarted;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class V1_FirstPlaywrightTest {

	public static void main(String[] args) {

		Playwright pw = Playwright.create(); // invoke playwright
		
		BrowserType browserType = pw.chromium();  // type of browser use Chromium
		
		// BrowserType browserType = pw.firefox();  // type of browser use firefox (nightly private browsing)
		
		// BrowserType browserType = pw.webkit(); // type of browser use webkit
		
		Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("msedge")); // launch the browser by default it will run in headless - use this to go headed mode
		// and above code to launch microsoft edge cod used method .setChannel("msedge")
		
		Page page = browser.newPage();
		
		page.navigate("https://playwright.dev/java/docs/intro#system-requirements");
		String title = page.title();
		System.out.println("Title is "+ title);		
		
//		page.close();
//		browser.close();
//		pw.close();

	}

}
