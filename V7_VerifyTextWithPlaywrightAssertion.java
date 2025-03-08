package gettingstarted;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class V7_VerifyTextWithPlaywrightAssertion {

	public static void main(String[] args) {
		
		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
		Page page = browser.newPage();
		
		page.navigate("https://freelance-learn-automation.vercel.app/login");
		page.locator(".submit-btn").click();
		
		PlaywrightAssertions.assertThat(page.locator(".errorMessage")).containsText("Email and Password is required");
		// here playwright assertion checks that locator text is matching with given text
		
		page.locator("#email1").fill("vinodmk@gmail.com");
		page.locator(".submit-btn").click();
		PlaywrightAssertions.assertThat(page.locator(".errorMessage")).containsText("Password is required");
		
		page.clock();
		browser.close();		

	}

}
