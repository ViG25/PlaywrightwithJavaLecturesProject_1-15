package gettingstarted;

import java.util.regex.Pattern;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class V2_LoginLogout {

	public static void main(String[] args) {
		
		Browser browser = null;
		Page page = null;
		try 
		{ 
			
		browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
		
		page = browser.newPage();
		
		page.navigate("https://freelance-learn-automation.vercel.app/login");
		
		PlaywrightAssertions.assertThat(page).hasTitle("Learn Automation Courses");
		
		// page.locator("#email1").fill("admin@email.com");
		// page.locator("xpath=//input[@name='email1']").fill("admin@email.com");
		// page.locator("css=input[@name='email1']").fill("admin@email.com");
		
		page.getByPlaceholder("Enter Email").fill("admin@email.com");
		// page.waitForTimeout(1000);
		
		page.getByPlaceholder("Enter Password").fill("admin@123");
		// page.waitForTimeout(1000);
		
		page.locator("xpath=//button[@type='submit']").click();
		// page.waitForTimeout(1000);
		
		PlaywrightAssertions.assertThat(page.locator(".welcomeMessage")).containsText("Welcome");
		
		page.getByAltText("menu").click();
		page.waitForTimeout(1000);
		
		page.locator("xpath=//button[@class='nav-menu-item']").click();
		PlaywrightAssertions.assertThat(page).hasURL(Pattern.compile("login"));
		
		}
		
		finally 
		{
		page.close();
		browser.close();
		}

	}

}
