package gettingstarted;

import java.nio.file.Path;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class V15_Assignment_4 {

	public static void main(String[] args) {
		
		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000));
		Page page = browser.newPage();		
		page.navigate("https://freelance-learn-automation.vercel.app/login");
		
		 page.locator("#email1").fill("admin@email.com");
		 page.getByPlaceholder("Enter Password").fill("admin@123");
		 page.locator("xpath=//button[@type='submit']").click();
		 
		 page.locator("//div[@class='nav-menu-item-manage']").hover();
		 page.locator("//a[text()='Manage Courses']").click();
		 page.locator("//button[text()='Add New Course ']").click();
		 
		 page.locator("#thumbnail").setInputFiles(Path.of(System.getProperty("user.dir")+"/Files/Peacock Feather.jpg"));
		 page.locator("#name").fill("Test 3 Test");
		 page.locator("#description").fill("Learn 3 Test");
		 page.locator("#instructorNameId").fill("Vinod 3");
		 page.locator("#price").fill("2000");
		 page.locator("#isPermanent").check();
		 
//		 PlaywrightAssertions.assertThat(page.locator("#course_67c8b5b234ecc2ec894b6c5e")).containsText("Test 2 Test");
//		 System.out.println("Course Added");
		 
//		 page.locator("//div[@class='nav-menu-item-manage']").hover();
//		 page.locator("//a[text()='Manage Courses']").click();
//		 page.locator("(//button [@class='action-btn delete-btn'])[1]").click();
//		 page.locator("//button[text()='Delete']").click();
		 
//		 FileChooser filechooser = page.waitForFileChooser(()-> page.locator("//button[@class='menu-btn']").click());
//		 filechooser.setFiles(Paths.get("D:\\Playwright_Feb_2025\\MavenFeb25\\Files\\Peacock Feather.jpg"));
		 
		 page.locator("//button[@class='menu-btn']").click();
		 page.locator("//button[text()='PWS']").click();
		 page.locator("//button[text()='Save']").click();
		 
		 page.locator("//img[@alt='menu']").click();
		 page.locator("//button[text()='Sign out']").click();
		 
		 page.close();
		 browser.close();
		 
	}

}
