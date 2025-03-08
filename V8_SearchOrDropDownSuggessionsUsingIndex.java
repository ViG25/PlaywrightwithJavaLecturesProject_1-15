package gettingstarted;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class V8_SearchOrDropDownSuggessionsUsingIndex {

	public static void main(String[] args) {
		
		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
		
		Page page = browser.newPage();
		
		page.navigate("https://www.google.com/");
		
		page.locator("xpath=//textarea[@title=\"Search\"]").fill("Vinod");
		
		Locator locator = page.locator("xpath=//li[@class='sbct PZPZlf']");
		
		System.out.println(locator.count());
		
		for (int i=0; i<locator.count(); i++)
		{
			String text = locator.nth(i).innerText();
			System.out.println(text);
			
			if(text.contains("kambli stats"))
			{
				locator.nth(i).click();
				break;
			}
		}
		
		
//		page.close();
//		browser.close();
		
	}

}
