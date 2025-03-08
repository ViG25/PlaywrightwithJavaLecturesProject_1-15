package gettingstarted;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class V12_HandleMultipleWindows {

	public static void main(String[] args) {
		
		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
		
		BrowserContext browserContext = browser.newContext();
		
		Page page = browserContext.newPage();
		
		page.navigate("https://practice.expandtesting.com/js-dialogs?utm_source=chatgpt.com");
		
		Page page2 = browserContext.waitForPage(()-> 
		{
			page.locator("//a[text()='Expand Testing']").click();
		});
		
		page2.locator("//a[@href='https://www.facebook.com/expandtesting/']").click();
		page2.locator("(//input[@name='email'])[2]").fill("Vinod Katekar");
		
		page.bringToFront();
		Page page3 = browserContext.waitForPage(()->{
			page.locator("//a[@href='https://www.buymeacoffee.com/expandtesting']").click();
		});
		
		page3.locator("//a[text()='Tawfik Nouri']").click();
		
		page2.bringToFront();
		page2.locator("(//input[@type='password'])[2]").fill("Test@123");
		page.bringToFront();
		
		page.close();
		page2.close();
		page3.close();
		
		
		
	}

}
