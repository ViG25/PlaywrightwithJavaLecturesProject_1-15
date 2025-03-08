package gettingstarted;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class V13_HandleMultipleWindowsUsingTitleOfPage {

	public static void main(String[] args) {

		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(5000));
		
		BrowserContext context = browser.newContext();
		Page page = context.newPage();
		
		page.navigate("https://freelance-learn-automation.vercel.app/login");
		
		Locator alllinks=page.locator("//div[@class='social']//a");
		
		for(int i=0; i<alllinks.count(); i++) 
		{
			alllinks.nth(i).click();
		}
		
		List<Page> allpages=context.pages();
		for (Page p:allpages) 
		{
			String title=p.title();
			System.out.println(title);
			
			if(title.contains("Facebook")) 
			{
				p.bringToFront();
				p.locator("(//input[@name='email'])[2]").fill("Vinod");
				
				break;
			}
		}
		page.bringToFront();
		page.locator("#email1");
		
		context.close();
		browser.close();
		page.close();
		
	}

}
