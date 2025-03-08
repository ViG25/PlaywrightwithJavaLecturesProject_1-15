package gettingstarted;

import org.testng.Assert;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.WaitForSelectorState;

public class V15_Assignment_5 {

	public static void main(String[] args) {
		
		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
		BrowserContext browserContext = browser.newContext();
		Page page1 = browserContext.newPage();	
		
		page1.navigate("https://freelance-learn-automation.vercel.app/login");
		page1.locator("#email1").fill("admin@email.com");
		page1.getByPlaceholder("Enter Password").fill("admin@123");
		page1.locator("xpath=//button[@type='submit']").click();
		page1.locator("//div[@class='nav-menu-item-manage']").hover();
		
		Page page2 = browserContext.waitForPage(()->
		{
			page1.locator("//a[text()='Manage Categories']").click();
		});
		
		page2.onceDialog(dialog ->{
			String promptMsg = dialog.message();
			System.out.println("Prompt msg is : "+promptMsg);
			Assert.assertEquals(promptMsg, "Enter a Category Name");
			System.out.println("Prompt msg verified");
			dialog.accept("Learnig Playwright with Java");
		});
		page2.locator("//button[contains(text(),'Add New Category')]").click();	
				
//		page2.onceDialog(dialog ->
//		{
//			String promptMsgUpdate = dialog.message();
//			System.out.println(promptMsgUpdate);
//			Assert.assertEquals(promptMsgUpdate, "Update the category");
//			System.out.println("Prompt message verified");
//			dialog.accept("Jo bhi hai wo updated");
//		});
//		page2.locator("(//button[@class='action-btn'])[4]").click();
		
//		Verifying added text
//		Locator tableText = page2.locator("//table[@class='category-table table table-borderless']//tr[4]/td[1]");
//		System.out.println("Course added - "+tableText.innerText());
		
		

		page2.locator("(//button[@class='action-btn delete-btn'])[4]").click();
		String deleteMessage = page2.locator("//div[@class='modal-body']").innerText();
		System.out.println("Before delete message : "+deleteMessage);
		
		// next step delete the added course
		page2.locator("//button[text()='Delete']").click();
		page2.waitForTimeout(1000);
		
		Locator tableRow4 = page2.locator("//table[@class='category-table table table-borderless']//tr[4]");
		tableRow4.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.DETACHED));
		// confirming that row 4 deleted and not visible
		PlaywrightAssertions.assertThat(tableRow4).isHidden();
		System.out.println("Course Deleted");
		
		page2.locator("//img[@alt='menu']").click();
		page2.locator("//button[text()='Sign out']").click();
		
		Assert.assertEquals(page2.url(), "https://freelance-learn-automation.vercel.app/login"); 
		System.out.println("Signout Done");
		page2.close();
		page1.close();
		browser.close();
		
	}

}
