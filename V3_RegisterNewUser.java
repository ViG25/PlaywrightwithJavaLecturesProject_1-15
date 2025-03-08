package gettingstarted;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class V3_RegisterNewUser {

	public static void main(String[] args) throws InterruptedException {

		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		                                       // Firefox
		// Browser browser = Playwright.create().firefox().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
		
											// Webkit
		// Browser browser = Playwright.create().webkit().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
		
		Page page = browser.newPage();
		
		page.navigate("https://freelance-learn-automation.vercel.app/login");
		page.locator(".subLink").click();
		
		page.pause();
		
		PlaywrightAssertions.assertThat(page.locator("//button[@type='submit']")).isDisabled();
		
		page.locator("#name").fill("Vinod");
		
		                                   // to use unique id use following code
		page.getByPlaceholder("Email").fill("automation_" + System.currentTimeMillis() + "@gmail.com");
		
		page.locator("//input[@name='password']").fill("Vin@1234");
		
		page.locator("//label[text()='Java']").click();
		PlaywrightAssertions.assertThat(page.locator("//label[text()='Java']")).isChecked();
		
		page.locator("#gender1").click();
		PlaywrightAssertions.assertThat(page.locator("#gender1")).isChecked();
		
		page.locator("//select[@name='state']").selectOption("Maharashtra");
		
		String hobbies [] = {"Playing", "Swimming"};				
		page.locator("#hobbies").selectOption(hobbies);
		
		page.locator(".submit-btn").click();
		
		PlaywrightAssertions.assertThat(page.locator("//div[@class='Toastify__toast-icon Toastify--animate-icon Toastify__zoom-enter']")).isVisible();
		System.out.println("Toast messagevisible");
		
		page.close();
		browser.close();
		
	}

}
