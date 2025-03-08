package gettingstarted;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class V8_SearchOrDropDownSuggessions {

	public static void main(String[] args) {
		
		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
		
		Page page = browser.newPage();
		
		page.navigate("https://www.google.com/");
		
		page.locator("xpath=//textarea[@title=\"Search\"]").fill("Vinod");
		
		page.locator("xpath=//li[@class='sbct PZPZlf']").nth(3).click();
				
//		page.close();
//		browser.close();
		
	}

}
