package gettingstarted;

import static org.testng.Assert.assertEquals;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class V15_Assignment_2n3 {

	public static void main(String[] args) {

		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
		Page page = browser.newPage();
		page.navigate("https://freelance-learn-automation.vercel.app/login");
		page.locator("//a[text()='New user? Signup']").click();
		
		assertEquals("https://freelance-learn-automation.vercel.app/signup", page.url());
		System.out.println("Landed on correct URL");
		
		page.locator("#name").fill("Arawa4794");
		page.locator("#email").fill("A94a@gmail.com");
		page.locator("#password").fill("Abc@123");
		
		page.locator("//label[text()='Playwright']").check();
		page.locator("#gender1").click();
		PlaywrightAssertions.assertThat(page.locator("#gender1")).isChecked();
		
		page.locator("//select[@name='state']").selectOption("Maharashtra");
		
		String [] hobbies = {"Playing", "Reading"};
		page.locator("#hobbies").selectOption(hobbies);
		page.locator("//button[text()='Sign up']").click();
		
		PlaywrightAssertions.assertThat(page.locator("//div[@class='Toastify__toast-icon Toastify--animate-icon Toastify__zoom-enter']")).isVisible();
		System.out.println("Message is Visible");
		
		assertEquals("https://freelance-learn-automation.vercel.app/login", page.url());
		System.out.println("Landed back in Login page");
		
		
		page.close();
		browser.close();

	}

}
