package gettingstarted;

import org.testng.Assert;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class V7_VerifyTextWithTestNGAssertion {

	public static void main(String[] args) {
		
		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
		Page page = browser.newPage();
		
		page.navigate("https://freelance-learn-automation.vercel.app/login");
		page.locator(".submit-btn").click();
		
		String expectedMsg = "Email and Password is required";
		String actualMsg = page.locator(".errorMessage").textContent();
		
		Assert.assertEquals(actualMsg, expectedMsg);
				
		page.locator("#email1").fill("vinodmk@gmail.com");
		page.locator(".submit-btn").click();
		
		Assert.assertTrue(actualMsg.contains("Password is required"));
		
		page.clock();
		browser.close();		

	}

}
