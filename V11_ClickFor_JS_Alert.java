package gettingstarted;

import org.testng.Assert;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class V11_ClickFor_JS_Alert {

	public static void main(String[] args) throws InterruptedException {

		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
		Page page = browser.newPage();
		
		page.navigate("https://practice.expandtesting.com/js-dialogs?utm_source=chatgpt.com");
				
		page.onDialog(dialog -> 
			{
				String msgJsAlert = dialog.message();
				System.out.println("Dialog Alert message is "+msgJsAlert);
				Assert.assertTrue(msgJsAlert.contains("I am a Js Alert"));	
				dialog.accept();
			}
		);
		
		page.locator("#js-alert").click();
		page.close();

	}

}
