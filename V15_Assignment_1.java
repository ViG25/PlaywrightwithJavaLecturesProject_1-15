package gettingstarted;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class V15_Assignment_1 {

	public static void main(String[] args) {

		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000));
		Page page = browser.newPage();
		page.navigate("https://freelance-learn-automation.vercel.app/login");
		
		String title = page.title();
		System.out.println(title);  // Learn Automation Courses
		PlaywrightAssertions.assertThat(page).hasTitle("Learn Automation Courses");
		System.out.println("Title is confirmed");
		
		page.locator("#email1").fill("AJ1@gmail.com");
		
		page.locator("#password1").fill("AJ@123");
		page.locator("//button[@class='submit-btn']").click();
		
		PlaywrightAssertions.assertThat(page.locator("//h4[@class='welcomeMessage']")).containsText("Welcome");
		
		int availableCourses = page.locator("//div[@class='course-card row']").count();
		if (availableCourses > 0) 
		{
			System.out.println("Available Courses is "+availableCourses);
		}
		else 
		{
			System.out.println("Courses Count Failed");
		}
		
		int aTagIcon = page.locator("//a[@target='_blank']").count();
		
		if (aTagIcon > 0) 
		{
			System.out.println("Available Icons is "+aTagIcon);
		}
		else 
		{
			System.out.println("Icon Count Failed");
		}		
		
		page.close();
		browser.close();
		
	}

}
