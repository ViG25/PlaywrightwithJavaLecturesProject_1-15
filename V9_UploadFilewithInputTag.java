package gettingstarted;

import java.nio.file.Path;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

public class V9_UploadFilewithInputTag {

	public static void main(String[] args) {

		Page page = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000)).newPage();

	      page.navigate("https://app.iriscarbon.com/#/login");
	      page.getByPlaceholder("abc@example.com").click();
	      page.getByPlaceholder("abc@example.com").fill("vinod.katekar@irisbusiness.com");
	      page.getByPlaceholder("●●●●●●●●").click();
	      page.getByPlaceholder("●●●●●●●●").fill("Vinod@12345");
	      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign in")).click();
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("")).first().click();
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Edit")).click();
	      page.getByRole(AriaRole.TAB, new Page.GetByRoleOptions().setName("")).click();
	      page.getByRole(AriaRole.TAB, new Page.GetByRoleOptions().setName("")).click();
	      page.locator("#file-dropzone1").setInputFiles(Path.of(System.getProperty("user.dir")+"/Files/MainDocument.htm"));
	           
	      // Input tag example not found

	}

}
