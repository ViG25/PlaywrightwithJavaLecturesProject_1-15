package gettingstarted;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;

public class V6_CodeRecordedByPlaywrightCodeGen {

	public static void main(String[] args) {
		
		try (Playwright playwright = Playwright.create()) {
		      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
		        .setHeadless(false).setSlowMo(500));
		      BrowserContext context = browser.newContext();
		      Page page = context.newPage();
		      page.navigate("https://freelance-learn-automation.vercel.app/login");
		      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("New user? Signup")).click();
		      page.getByPlaceholder("Name").click();
		      page.getByPlaceholder("Name").fill("Ass2");
		      page.getByPlaceholder("Email").click();
		      page.getByPlaceholder("Email").fill("As2@gmail.com");
		      page.getByPlaceholder("Password").click();
		      page.getByPlaceholder("Password").fill("As@123");
		      page.getByLabel("Java").check();
		      page.getByLabel("Selenium").check();
		      page.getByLabel("Playwright").check();
		      page.getByLabel("Automation Testing2").check();
		      page.locator("#gender1").check();
		      page.locator("#state").selectOption("Maharashtra");
		      page.locator("#hobbies").selectOption("Swimming");
		      page.locator("#hobbies").selectOption(new String[] {"Playing", "Swimming"});
		      PlaywrightAssertions.assertThat(page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign up"))).isVisible();
		      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign up")).click();
		      PlaywrightAssertions.assertThat(page.getByText("Signup successfully, Please")).isVisible();

	}

}
}
