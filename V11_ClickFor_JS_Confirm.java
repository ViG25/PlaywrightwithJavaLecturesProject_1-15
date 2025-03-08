package gettingstarted;

import org.testng.Assert;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class V11_ClickFor_JS_Confirm {

	public static void main(String[] args) {

		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(600));
		Page page = browser.newPage();
		page.navigate("https://practice.expandtesting.com/js-dialogs?utm_source=chatgpt.com");
		
		page.onDialog(dialog -> 
		{
			String jsConfirmmsg = dialog.message();
			System.out.println("JS Confirmation message is - "+jsConfirmmsg);
			Assert.assertTrue(jsConfirmmsg.contains("I am a Js Confirm"));
			dialog.dismiss();
		}
		);
		
		page.locator("#js-confirm").click();
		page.close();
		
	}

}
